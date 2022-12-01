package bo.ucb.edu.TallerSis.BL;

import bo.ucb.edu.TallerSis.DAO.OrderDAO;
import bo.ucb.edu.TallerSis.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderBL {
    private OrderDAO orderDAO;

    @Autowired
    public OrderBL(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public List<Order> findOrdersbyBussines(Integer id) {
        List<Order> result =orderDAO.getorderbybussines(id);
        return result;
    }

    public void saveOrder(Order order){
        Double pay= order.getTotal_payment();
        Integer status=order.getOrder_status_id_order_status();
        Integer tpay=order.getType_payment_id_typepay();
        Integer deli=order.getDelivery_id_delivery();
        orderDAO.saveOrder(pay,status,tpay,deli);
    }
    public void updateOrderStatus(Integer  id_order, Integer status){
        //Integer id_order=order.getId_order();
        orderDAO.updateOrderStatus(id_order,status);
    }

    public void updateOrderStatuspay(Integer  id_order, Integer status,Integer payid){
        orderDAO.updateOrderStatus(id_order,status);
        orderDAO.updateOrderPayStatus(id_order,payid);
    }

    public void updateOrderPayStatus(Integer id_order, Integer payid){
        //Integer id_order=order.getId_order();
        orderDAO.updateOrderPayStatus(id_order,payid);
    }

    public List<Order> findOrdersbyBussinesday(Integer id) {
        List<Order> result =orderDAO.getorderbybussinesday(id);
        return result;
    }

    public List<Order> findorderstopay(Integer id) {
        List<Order> result =orderDAO.getorderforpayclient(id);
        return result;
    }

    public Double findpayday(Integer id) {
        Double result =orderDAO.getpayday(id);
        return result;
    }

    public Count findcountday(Integer id, Integer state) {
        Count result =orderDAO.getcountday(id, state);
        return result;
    }

    public List<Order> findOrdersforpay(Integer id) {
        List<Order> result =orderDAO.getorderforpay(id);
        return result;
    }

    public Order findorderid(Order order){
        Double pay= order.getTotal_payment();
        Integer status=order.getOrder_status_id_order_status();
        Integer tpay=order.getType_payment_id_typepay();
        Integer deli=order.getDelivery_id_delivery();
        order=orderDAO.getorder(pay,status,tpay,deli);
        return order;
    }

    public Order findlastorder(Integer userid){
        Order order = orderDAO.getorderlast(userid);
        return order;
    }

    public void savedelivery(Integer address, Integer idbuss, Integer user){
        orderDAO.saveDelivery(address, idbuss, user);
    }

    public Delivery getdeliveryid(Integer address, Integer idbuss, Integer user){
        return orderDAO.getdeliveryid(address, idbuss, user);
    }

    public void savedetail(CartItem[] cart, Integer idorder){
        for(CartItem s:cart){
            Food food = s.getFood();
            orderDAO.saveDetail(idorder, food.getId());
        }
    }

    public List<Order> userReport(Integer id, String row, String ord, Integer limit, Integer pag){
        Integer page=limit*pag;

        List<Order> result = orderDAO.getorderuser(id, Integer.parseInt(row),ord,limit,page);
        return result;
    }

    public List<Order> userReport2(Integer id, String row, String ord, Integer limit, Integer pag, Double fil){
        Integer page=limit*pag;

        List<Order> result = orderDAO.getorderuser2(id, Integer.parseInt(row),Integer.parseInt(ord),limit,page,fil);
        return result;
    }

    public Count gettotaluser(Integer id){
        Count res= orderDAO.gettotaluser(id);
        return res;
    }

    public List<Order> delireport(Integer id, String row, String ord, Integer limit, Integer pag){
        Integer page=limit*pag;

        List<Order> result = orderDAO.getdeliveryrep(id, Integer.parseInt(row),ord,limit,page);
        return result;
    }

}
