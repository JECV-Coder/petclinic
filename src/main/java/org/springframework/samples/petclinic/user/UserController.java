package org.springframework.samples.petclinic.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerDTO;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.springframework.samples.petclinic.user.UserDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private OwnerRepository owners;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/user")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public UserDTO login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        User userAux = this.userRepo.findByEmail(username);
        UserDTO user = new UserDTO();
        String idForEncode = "bcrypt";
        Map encoders = new HashMap<>();
        encoders.put(idForEncode, new BCryptPasswordEncoder());
        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);

        if(userAux != null && userAux.getActive().equals("1")) {
            int ownerId = userAux.getId();
            OwnerDTO owner = new OwnerDTO();

            Owner aux = this.owners.findOwnerByUser(ownerId);

            if(aux == null) {
                owner = modelMapper.map(userAux, OwnerDTO.class);
                owner.setAddress(userAux.getCity()+", "+userAux.getZipcode());
            } else {
                owner =  owner = modelMapper.map(aux, OwnerDTO.class);
            }

            if(passwordEncoder.matches(pwd, userAux.getPassword())) {
                String token = getJWTToken(username);
                user.setToken(token);
                user.setUser(username);
                user.setOwner(owner);
                user.setPwd(userAux.getPassword());
            }
        }
        return user;
    }

    @PostMapping(value = "/API/create-user", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public User createUser(@RequestBody User user) {
        String idForEncode = "bcrypt";
        Map encoders = new HashMap<>();
        encoders.put(idForEncode, new BCryptPasswordEncoder());
        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);


        user.setPassword(passwordEncoder.encode(user.getPassword()));

        this.userRepo.save(user);

        Owner owner = new Owner();
        owner.setUser(user);
        owner.setFirstName(user.getFirstName());
        owner.setLastName(user.getLastName());
        owner.setCity(user.getCity());
        owner.setTelephone(user.getTelephone());
        owner.setAddress(user.getCity());
        owner.setLatitud("1");
        owner.setLongitud("1");
        this.owners.save(owner);

        return user;
    }

    @PutMapping(value = {"/API/update-user/"},
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public User updateUser(@RequestBody User user) {
        String idForEncode = "bcrypt";
        Map encoders = new HashMap<>();
        encoders.put(idForEncode, new BCryptPasswordEncoder());
        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);

        User aux = userRepo.findById(user.getId());
        aux.setEmail(user.getEmail());
        aux.setPassword(passwordEncoder.encode(user.getPassword()));
        aux.setTelephone(user.getTelephone());
        aux.setZipcode(user.getZipcode());
        aux.setFirstName(user.getFirstName());
        aux.setLastName(user.getLastName());
        this.userRepo.save(aux);
        return aux;
    }

    @PutMapping(value = {"/API/delete-user/"},
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public User deleteUser(@RequestBody User user) {
        User aux = userRepo.findById(user.getId());
        aux.setActive("0");
        this.userRepo.save(aux);
        return aux;
    }


    private String getJWTToken(String username) {
        String secretKey = "secreto";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
            .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
            .builder()
            .setId("petJWT")
            .setSubject(username)
            .claim("authorities",
                grantedAuthorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()))
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 6000000))
            .signWith(SignatureAlgorithm.HS512,
                secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
