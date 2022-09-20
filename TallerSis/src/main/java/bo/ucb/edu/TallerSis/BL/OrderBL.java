package bo.ucb.edu.TallerSis.BL;

import bo.ucb.edu.TallerSis.DAO.OrderDAO;
import bo.ucb.edu.TallerSis.DTO.Address;
import bo.ucb.edu.TallerSis.DTO.Order;
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
    public void updateOrderStatus(Order order, Integer status){
        Integer id_order=order.getId_order();
        orderDAO.updateOrderStatus(id_order,status);
    }
}
