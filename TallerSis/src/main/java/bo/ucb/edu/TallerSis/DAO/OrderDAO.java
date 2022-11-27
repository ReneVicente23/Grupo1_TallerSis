package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.Count;
import bo.ucb.edu.TallerSis.DTO.Delivery;
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

    @Select("SELECT p.id_order, p.total_payment, p.order_status_id_order_status, p.type_payment_id_typepay, p.delivery_id_delivery, p.orderdate " +
            "FROM \"order\" p JOIN delivery j ON p.delivery_id_delivery = j.id_delivery WHERE p.type_payment_id_typepay= 1 AND p.order_status_id_order_status = 2 AND j.userapp_id_userapp= #{id}")
    public List<Order> getorderforpayclient(@Param("id") Integer id);

    @Insert("INSERT INTO delivery (user_address_id_user_address, business_id_business, userapp_id_userapp) " +
            " VALUES ( #{address}, #{idbuss}, #{userid}) ")
    void saveDelivery(@Param("address") Integer idaddress,@Param("idbuss") Integer idbuss,@Param("userid") Integer userid);

    @Select("SELECT DISTINCT id_order, total_payment, order_status_id_order_status, type_payment_id_typepay, delivery_id_delivery, orderdate " +
            "FROM \"order\" WHERE total_payment= #{pay} AND  order_status_id_order_status = #{orst} AND type_payment_id_typepay= #{tpay} AND delivery_id_delivery= #{del} AND orderdate = CURRENT_DATE ORDER BY id_order DESC FETCH FIRST 1 ROWS ONLY")
    public Order getorder(@Param("pay") Double pay,@Param("orst") Integer orderstatus, @Param("tpay") Integer tipopago, @Param("del") Integer delid);

    @Select("SELECT DISTINCT p.id_order, p.total_payment, p.order_status_id_order_status, p.type_payment_id_typepay, p.delivery_id_delivery, p.orderdate " +
            "FROM \"order\" p JOIN delivery d ON p.delivery_id_delivery=d.id_delivery JOIN user_address a ON d.user_address_id_user_address= a.id_user_address WHERE a.userapp_id_userapp = #{iduser} AND p.orderdate = CURRENT_DATE ORDER BY id_order DESC FETCH FIRST 1 ROWS ONLY")
    public Order getorderlast(@Param("iduser") Integer id);

    @Select("SELECT id_delivery, user_address_id_user_address, business_id_business, userapp_id_userapp " +
            "FROM delivery  WHERE user_address_id_user_address= #{address} AND business_id_business = #{idbuss} AND userapp_id_userapp = #{userid} ORDER BY id_delivery DESC FETCH FIRST 1 ROWS ONLY")
    public Delivery getdeliveryid(@Param("address") Integer idaddress,@Param("idbuss") Integer idbuss,@Param("userid") Integer userid);

    @Select("SELECT id_delivery, user_address_id_user_address, business_id_business, userapp_id_userapp " +
            "FROM delivery  WHERE id_delivery= #{id} ORDER BY id_delivery DESC FETCH FIRST 1 ROWS ONLY")
    public Delivery getdeliverybyid(@Param("id") Integer id);


    @Insert("INSERT INTO order_details (order_id_order, dish_id_dish) " +
            " VALUES ( #{order}, #{dish}) ")
    void saveDetail(@Param("order") Integer idorder,@Param("dish") Integer iddish);

    @Select("SELECT p.id_order, p.total_payment, p.order_status_id_order_status, p.type_payment_id_typepay, p.delivery_id_delivery, p.orderdate  " +
            "FROM \"order\" p JOIN delivery j ON p.delivery_id_delivery = j.id_delivery JOIN user_address q ON q.id_user_address=j.user_address_id_user_address WHERE q.userapp_id_userapp= #{iduser} "+
            "ORDER BY 6 DESC LIMIT #{limit} OFFSET #{pag}")
    public List<Order> getorderuser(@Param("iduser") Integer id,@Param("row") Integer row , @Param("ord") String ord, @Param("limit") Integer limit, @Param("pag") Integer pag);

    @Select("SELECT p.id_order, p.total_payment, p.order_status_id_order_status, p.type_payment_id_typepay, p.delivery_id_delivery, p.orderdate  " +
            "FROM \"order\" p JOIN delivery j ON p.delivery_id_delivery = j.id_delivery JOIN user_address q ON q.id_user_address=j.user_address_id_user_address WHERE q.userapp_id_userapp= #{iduser} AND p.total_payment < #{fil} "+
            "ORDER BY ${ord} DESC LIMIT #{limit} OFFSET #{pag}")
    public List<Order> getorderuser2(@Param("iduser") Integer id,@Param("row") Integer row , @Param("ord") Integer ord, @Param("limit") Integer limit, @Param("pag") Integer pag, @Param("fil") Double fil);

    @Select("SELECT count(DISTINCT id_order)  " +
            "FROM \"order\" p JOIN delivery j ON p.delivery_id_delivery = j.id_delivery JOIN user_address q ON q.id_user_address=j.user_address_id_user_address WHERE q.userapp_id_userapp= #{iduser} ")
    public Count gettotaluser(@Param("iduser") Integer id);



    @Select("SELECT p.id_order, p.total_payment, p.order_status_id_order_status, p.type_payment_id_typepay, p.delivery_id_delivery, p.orderdate  " +
            "FROM \"order\" p JOIN delivery j ON p.delivery_id_delivery = j.id_delivery WHERE j.userapp_id_userapp= #{iduser} "+
            "ORDER BY 1 DESC LIMIT #{limit} OFFSET #{pag}")
    public List<Order> getdeliveryrep(@Param("iduser") Integer id,@Param("row") Integer row , @Param("ord") String ord, @Param("limit") Integer limit, @Param("pag") Integer pag);

}
