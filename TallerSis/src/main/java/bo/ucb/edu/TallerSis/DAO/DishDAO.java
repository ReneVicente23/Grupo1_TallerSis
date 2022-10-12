package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.Cost;
import bo.ucb.edu.TallerSis.DTO.Dish;
import bo.ucb.edu.TallerSis.DTO.Order;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DishDAO {
    @Select("SELECT p.id_dish, p.name, p.description, p.cost, business_id_business " +
            "FROM dish p JOIN order_details u  ON p.id_dish = u.dish_id_dish WHERE u.order_id_order = #{id}")
    public List<Dish> findorderdetails(@Param("id") Integer id);

    @Select("SELECT p.id_dish, p.name, p.description, p.cost, business_id_business " +
            "FROM dish p JOIN order_details j ON p.id_dish=j.dish_id_dish JOIN \"order\" q ON q.id_order = j.order_id_order WHERE p.business_id_business= #{idbussines} ")
    public List<Dish> dishreport(@Param("idbussines") Integer id);

    @Select("SELECT p.id_dish, p.name, p.description, p.cost, business_id_business " +
            "FROM dish p JOIN order_details j ON p.id_dish=j.dish_id_dish JOIN \"order\" q ON q.id_order = j.order_id_order WHERE p.business_id_business= #{idbussines} AND q.orderdate = CURRENT_DATE")
    public List<Dish> dishreportperday(@Param("idbussines") Integer id);

    @Select("SELECT SUM(p.cost) " +
            "FROM dish p JOIN order_details j ON p.id_dish=j.dish_id_dish JOIN \"order\" q ON q.id_order = j.order_id_order WHERE p.business_id_business= #{idbussines} ")
    public Cost dishreporttcost(@Param("idbussines") Integer id);

    @Select("SELECT id_dish, name, description, cost, business_id_business " +
            "FROM dish LIMIT 20 OFFSET #{pag}")
    public List<Dish> getFOOD(@Param("pag") Integer pag);

    @Select("SELECT id_dish, name, description, cost, business_id_business " +
            "FROM dish  WHERE id_dish = #{id} ")
    public Dish findishbyid(@Param("id") Integer id);

    @Select("SELECT p.id_dish, p.name, p.description, p.cost, p.business_id_business " +
            "FROM dish p JOIN order_details j ON p.id_dish=j.dish_id_dish JOIN \"order\" q ON q.id_order = j.order_id_order JOIN delivery d ON d.id_delivery = q.delivery_id_delivery JOIN user_address u ON u.id_user_address = d.user_address_id_user_address " +
            "WHERE u.userapp_id_userapp = #{iduser} ORDER BY 2 LIMIT #{limit} OFFSET #{pag} ") //ORDER BY #{row} #{ord}
    public List<Dish> dishUserReport(@Param("iduser") Integer id , @Param("row") Integer row , @Param("ord") String ord, @Param("limit") Integer limit, @Param("pag") Integer pag);
}
