package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.Dish;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DishDAO {
    @Select("SELECT p.id_dish, p.name, p.description, p.cost, business_id_business " +
            "FROM dish p JOIN order_details u  ON p.id_dish = u.dish_id_dish WHERE u.order_id_order = #{id}")
    public List<Dish> findorderdetails(@Param("id") Integer id);
}
