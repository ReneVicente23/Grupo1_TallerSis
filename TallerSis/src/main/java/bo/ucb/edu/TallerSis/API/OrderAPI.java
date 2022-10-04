package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.OrderBL;
import bo.ucb.edu.TallerSis.DTO.Address;
import bo.ucb.edu.TallerSis.DTO.Count;
import bo.ucb.edu.TallerSis.DTO.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/order")
public class OrderAPI {
    private OrderBL orderBL;

    public OrderAPI(OrderBL orderBL) {
        this.orderBL = orderBL;
    }

    @GetMapping(path="/bussines/{bussinesid}/", produces = APPLICATION_JSON_VALUE)
    public List<Order> findbybussines(@PathVariable("bussinesid") Integer id) {
        return orderBL.findOrdersbyBussines(id);
    }//tested: OBTIENE TODAS LAS ORDERS DE UN NEGOCIO

    @PostMapping(path="/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Order insertorder(@RequestBody Order order) {
        orderBL.saveOrder(order);
        return order;
    }//tested: INGRESA UNA ORDER

    @PutMapping(path="/cash", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Order updatestatuspay(@RequestBody Order order) {
        orderBL.updateOrderStatus(order,2);
        orderBL.updateOrderPayStatus(order,1);
        return order;
    }//tested: MODIFICA UNA ORDER PARA QUE SU TIPO DE PAGO SEA EN EFECTIVO

    @PutMapping(path="/cash/pay", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Order updatestatus(@RequestBody Order order) {
        orderBL.updateOrderStatus(order,3);
        return order;
    }//tested: MODIFICA UNA ORDER PARA QUE SU ESTADO SEA PAGADO

    @GetMapping(path="/bussines/day/{bussinesid}", produces = APPLICATION_JSON_VALUE)
    public List<Order> findbybussinesday(@PathVariable("bussinesid") Integer id) {
        return orderBL.findOrdersbyBussinesday(id);
    }//tested: OBTIENE TODAS LAS ORDERS DE UN NEGOCIO EN EL DIA

    @GetMapping(path="/bussines/day/pay/{bussinesid}", produces = APPLICATION_JSON_VALUE)
    public Double findbybussinespayday(@PathVariable("bussinesid") Integer id) {
        return orderBL.findpayday(id);
    }//OBTIENE EL PAGO TODAL POR ORDES DE UN NEGOCIO EN UN DIA (NO USAR MAL PLANTEADO)

    @GetMapping(path="/bussines/count/{state}/{bussinesid}", produces = APPLICATION_JSON_VALUE)
    public Count findbycountday(@PathVariable("state") Integer st, @PathVariable("bussinesid") Integer id) {
        return orderBL.findcountday(id,st);
    }// OBTIENE UN CONTADOR DE TODAS ORDERS CON UN ESTADO DE UN NEGOCIO

    @GetMapping(path="/delivery/cash/pending/{bussinesid}", produces = APPLICATION_JSON_VALUE)
    public List<Order> findforpay(@PathVariable("bussinesid") Integer id) {
        return orderBL.findOrdersforpay(id);
    }//OBTIENE TODOS LAS ORDENES PENDIENTES DE PAGO EN EFECTIVO DE UN NEGOCIO

}
