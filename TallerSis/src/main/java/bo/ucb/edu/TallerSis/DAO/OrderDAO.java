package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDAO {

    @Select("SELECT DISTINCT p.id_order, p.total_payment, p.order_status_id_order_status, p.type_payment_id_typepay, p.delivery_id_delivery " +
            "FROM \"order\" p JOIN order_details j ON p.id_order = j.order_id_order JOIN dish q ON q.id_dish=j.dish_id_dish WHERE q.business_id_business= #{idbussines}")
    public List<Order> getorderbybussines(@Param("idbussines") Integer id);

    @Insert("INSERT INTO \"order\"(total_payment, order_status_id_order_status, type_payment_id_typepay, delivery_id_delivery) " +
            " VALUES ( #{pay}, #{status}, #{tpay}, #{deli}) ")
    void saveOrder(@Param("pay") Double payment,@Param("status") Integer status,@Param("tpay") Integer tipopay,@Param("deli") Integer deliver);
    @Update("UPDATE \"order\" SET order_status_id_order_status= #{status} " +
            " WHERE id_order = #{id}")
    void updateOrderStatus(@Param("id") Integer id ,@Param("status") Integer status);
}
