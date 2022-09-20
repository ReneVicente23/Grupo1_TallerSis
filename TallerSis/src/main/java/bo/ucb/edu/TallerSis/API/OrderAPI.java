package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.OrderBL;
import bo.ucb.edu.TallerSis.DTO.Address;
import bo.ucb.edu.TallerSis.DTO.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/order")
public class OrderAPI {
    private OrderBL orderBL;

    public OrderAPI(OrderBL orderBL) {
        this.orderBL = orderBL;
    }

    @GetMapping(path="/bussines/{bussinesid}/", produces = APPLICATION_JSON_VALUE)
    public List<Order> findbybussines(@PathVariable("bussinesid") Integer id) {
        return orderBL.findOrdersbyBussines(id);
    }

    @PostMapping(path="/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Order insertorder(@RequestBody Order order) {
        orderBL.saveOrder(order);
        return order;
    }

    @PutMapping(path="/cash", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Order updatestatuspay(@RequestBody Order order) {
        orderBL.updateOrderStatus(order,2);
        return order;
    }

}
