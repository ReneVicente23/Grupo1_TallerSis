package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.Count;
import bo.ucb.edu.TallerSis.DTO.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDAO {

    @Select("SELECT DISTINCT p.id_order, p.total_payment, p.order_status_id_order_status, p.type_payment_id_typepay, p.delivery_id_delivery, p.orderdate  " +
            "FROM \"order\" p JOIN order_details j ON p.id_order = j.order_id_order JOIN dish q ON q.id_dish=j.dish_id_dish WHERE q.business_id_business= #{idbussines}")
    public List<Order> getorderbybussines(@Param("idbussines") Integer id);

    @Insert("INSERT INTO \"order\"(total_payment, order_status_id_order_status, type_payment_id_typepay, delivery_id_delivery, orderdate) " +
            " VALUES ( #{pay}, #{status}, #{tpay}, #{deli}, CURRENT_DATE) ")
    void saveOrder(@Param("pay") Double payment,@Param("status") Integer status,@Param("tpay") Integer tipopay,@Param("deli") Integer deliver);
    @Update("UPDATE \"order\" SET order_status_id_order_status= #{status} " +
            " WHERE id_order = #{id}")
    void updateOrderStatus(@Param("id") Integer id ,@Param("status") Integer status);

    @Update("UPDATE \"order\" SET type_payment_id_typepay= #{status} " +
            " WHERE id_order = #{id}")
    void updateOrderPayStatus(@Param("id") Integer id ,@Param("status") Integer status);

    @Select("SELECT DISTINCT p.id_order, p.total_payment, p.order_status_id_order_status, p.type_payment_id_typepay, p.delivery_id_delivery, p.orderdate " +
            "FROM \"order\" p JOIN order_details j ON p.id_order = j.order_id_order JOIN dish q ON q.id_dish=j.dish_id_dish WHERE q.business_id_business= #{idbussines} AND p.orderdate = CURRENT_DATE")
    public List<Order> getorderbybussinesday(@Param("idbussines") Integer id);

    @Select("SELECT SUM(DISTINCT p.total_payment) " +
            "FROM \"order\" p JOIN order_details j ON p.id_order = j.order_id_order JOIN dish q ON q.id_dish=j.dish_id_dish WHERE q.business_id_business= #{idbussines} AND p.orderdate = CURRENT_DATE AND p.orderdate = CURRENT_DATE")
    public Double getpayday(@Param("idbussines") Integer id);

    @Select("SELECT count(DISTINCT id_order) " +
            "FROM \"order\" p JOIN order_details j ON p.id_order = j.order_id_order JOIN dish q ON q.id_dish=j.dish_id_dish WHERE q.business_id_business= #{idbussines} "+ /*AND p.orderdate = CURRENT_DATE*/ " AND p.order_status_id_order_status=#{state}")
    public Count getcountday(@Param("idbussines") Integer id, @Param("state") Integer state);

    @Select("SELECT DISTINCT p.id_order, p.total_payment, p.order_status_id_order_status, p.type_payment_id_typepay, p.delivery_id_delivery, p.orderdate " +
            "FROM \"order\" p JOIN order_details j ON p.id_order = j.order_id_order JOIN dish q ON q.id_dish=j.dish_id_dish WHERE q.business_id_business= #{idbussines} AND p.order_status_id_order_status = 2")
    public List<Order> getorderforpay(@Param("idbussines") Integer id);
}
