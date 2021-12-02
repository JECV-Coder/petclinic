package org.springframework.samples.petclinic.order;

import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.product.Product;
import org.springframework.samples.petclinic.product.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class OrderController {
    @Autowired
    private final OrderRepository orders;
    @Autowired
    private final OrderItemRepository orderItems;
    @Autowired
    private final OwnerRepository owners;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepository products;

    public OrderController(OrderRepository orders, OrderItemRepository orderItems, OwnerRepository owners) {
        this.orders = orders;
        this.orderItems = orderItems;
        this.owners = owners;
    }

    @GetMapping({ "/API/ordersJSON" })
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public  @ResponseBody List<OrderDTO> showResourceOrderListJSON() {
        return this.orders.findAll().stream().map(x -> modelMapper.map(x, OrderDTO.class)).collect(Collectors.toList());
    }

    @GetMapping({"API/ordersJSON/{orderId}"})
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public @ResponseBody OrderDTO showResourcesOrderJSON(@PathVariable("orderId") int orderId) {
        Order orderAux = this.orders.findById(orderId);
        OrderDTO orderDTO = modelMapper.map(orderAux, OrderDTO.class);
        OrdersJSON order = new OrdersJSON();
        orderDTO.setOwnerId(orderAux.getOwner().getId());
        order.getOrderList().add(orderDTO);
        return orderDTO;
    }

    @PostMapping(value = { "/API/create-order/"  },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        Order order = modelMapper.map(orderDTO, Order.class);
        order.setOwner(this.owners.findOwnerId(orderDTO.getOwnerId()));
        this.orders.save(order);
        return orderDTO;
    }

    @PutMapping(value = {"/API/update-order/"},

            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {

        Order order = this.orders.findById(orderDTO.getId());
        order.setStatus(orderDTO.getStatus());
        order.setDate(orderDTO.getDate());
        order.setMethod_payment(orderDTO.getMethod_payment());
        order.setTotal(orderDTO.getTotal());
        order.setOwner(this.owners.findOwnerId(orderDTO.getOwnerId()));

//        aux.setDate(order.getDate());
//        aux.setMethod_payment(order.getMethod_payment());
//        aux.setOrders(order.getOrders());
//        aux.setStatus(order.getStatus());
//        aux.setTotal(order.getTotal());
        this.orders.save(order);
        orderDTO = modelMapper.map(order, OrderDTO.class);
        return orderDTO;
    }

    @DeleteMapping(value = "/API/delete-order/",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public void deleteOrder(@RequestBody Order order) {
        this.orders.delete(order);
    }



    @GetMapping({ "/API/orderItemsJSON" })
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public  @ResponseBody List<OrderItemDTO> showResourceOrderItemListJSON() {
        return this.orderItems.findAll().stream().map(x -> modelMapper.map(x, OrderItemDTO.class)).collect(Collectors.toList());
    }

    @GetMapping({"API/orderItemsJSON/{orderItemId}"})
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public @ResponseBody OrderItemDTO showResourcesOrderItemJSON(@PathVariable("orderItemId") int orderItemId) {
        OrderItem item = orderItems.findById(orderItemId);
        OrderItemDTO order = new OrderItemDTO();

        if(item != null) {
            order = modelMapper.map(item, OrderItemDTO.class);
        }
        return order;
    }

    @PostMapping(value = { "/API/create-item/"  },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public OrderItemDTO createOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();
        Order order = this.orders.findById(orderItemDTO.getOrderId());
        Product product = this.products.findById(orderItemDTO.getProductId());

        System.out.println(order.getId()+" "+product.getId()+ " "+ orderItemDTO.getQuantity());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setOrder(order);
        orderItem.setProduct(product);

        this.orderItems.save(orderItem);
        return orderItemDTO;
    }

    @PutMapping(value = {"/API/update-item/"},
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public OrderItemDTO updateOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        OrderItem orderItem = orderItems.findById(orderItemDTO.getId());
        Order order = this.orders.findById(orderItemDTO.getOrderId());
        orderItem.setOrder(order);
        Product product = this.products.findById(orderItemDTO.getProductId());
        orderItem.setProduct(product);
        orderItem.setQuantity(orderItemDTO.getQuantity());
        this.orderItems.save(orderItem);
        return orderItemDTO;
    }

    @DeleteMapping(value = "/API/delete-item/",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public void deleteProduct(@RequestBody OrderItem orderItem) {
        this.orderItems.delete(orderItem);
    }

    @GetMapping("API/cart/{ownerId}")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public @ResponseBody OrderDTO getCart(@PathVariable("ownerId") int ownerId) {
        Order order;
        OrderDTO orderDTO = new OrderDTO();
        order = this.orders.findOrder(ownerId);
        if(order != null) {

            ArrayList<OrderItem> orderItems = this.orderItems.getListOrderItem(order.getId());
            Double total = 0.0;
            for (int i = 0; i < orderItems.size(); i++) {
                total += (orderItems.get(i).getProduct().getPrice() * orderItems.get(i).getQuantity());
            }

            orderDTO = modelMapper.map(order, OrderDTO.class);
            orderDTO.setOwnerId(order.getOwner().getId());
            orderDTO.setTotal(total);
            order.setTotal(total);
            this.orders.save(order);
        }

        return orderDTO;
    }

    @GetMapping("API/my-orders/{ownerId}")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public @ResponseBody List<OrderDTO> getHistoryOrder(@PathVariable("ownerId") int ownerId) {
        Collection<Order> orderCollection;
        List<OrderDTO> orderDTOList = null;
        orderCollection = this.orders.allOrdersFinished(ownerId);
        if(!orderCollection.isEmpty()) {
            orderDTOList = orderCollection.stream().map(x -> modelMapper.map(x, OrderDTO.class)).collect(Collectors.toList());
        }
        return orderDTOList;
    }

    @GetMapping("API/orders-in-process/{ownerId}")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public @ResponseBody List<OrderDTO> getOrderInProcess(@PathVariable("ownerId") int ownerId) {
        Collection<Order> orderCollection = null;
        List<OrderDTO> orderDTOList = null;
        orderCollection = this.orders.allOrdersInProcess(ownerId);
        if(!orderCollection.isEmpty()) {
            orderDTOList = orderCollection.stream().map(x -> modelMapper.map(x, OrderDTO.class)).collect(Collectors.toList());
        }
        return orderDTOList;
    }

    @PostMapping(value = { "/API/order/create/{ownerId}"  },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public OrderDTO initCreationForm(@PathVariable("ownerId") int ownerId, @RequestBody OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();
        Product product = this.products.findById(orderItemDTO.getProductId());
        orderItem.setProduct(product);
        orderItem.setQuantity(orderItemDTO.getQuantity());
        OrderDTO orderDTO = new OrderDTO();
        Owner owner = this.owners.findById(ownerId);

        try {
            Order order = this.orders.findOrder(ownerId);

            if (order == null) {
                order = new Order();
                order.setOwner(owner);
                order.setTotal(1.00);
                order.setStatus(0);

                order.setDate(LocalDate.now());

                order.setMethod_payment("sin establecer");

            }

            orderItem.setOrder(order);

            this.orders.save(order);

            OrderItem aux = orderItems.getOrderItemDuplicated(product.getId(), order.getId());

            if (aux != null) {
                aux.setQuantity(aux.getQuantity() + orderItem.getQuantity());
                orderItems.save(aux);
            } else {
                orderItems.save(orderItem);
            }

            product.setExistence(product.getExistence() - orderItem.getQuantity());
            this.products.save(product);

            orderDTO = modelMapper.map(order, OrderDTO.class);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return orderDTO;
    }
}
