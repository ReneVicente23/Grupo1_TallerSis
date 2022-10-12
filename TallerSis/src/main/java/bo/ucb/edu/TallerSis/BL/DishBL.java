package bo.ucb.edu.TallerSis.BL;

import bo.ucb.edu.TallerSis.DAO.DishDAO;
import bo.ucb.edu.TallerSis.DTO.Cost;
import bo.ucb.edu.TallerSis.DTO.Dish;
import bo.ucb.edu.TallerSis.DTO.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DishBL {
    private DishDAO dishDAO;

    @Autowired
    public DishBL(DishDAO dishDAO) {
        this.dishDAO = dishDAO;
    }

    public List<Dish> findOrderDetails(Integer id) {
        List<Dish> result =dishDAO.findorderdetails(id);
        return result;
    }

    public List<Dish> findDishReport(Integer id) {
        List<Dish> result =dishDAO.dishreport(id);
        return result;
    }

    public List<Dish> findDishReportDay(Integer id) {
        List<Dish> result =dishDAO.dishreportperday(id);
        return result;
    }

    public Cost findDishReporttcost(Integer id) {
        Cost result =dishDAO.dishreporttcost(id);
        return result;
    }

    public List<Food> findFood(int pag){
        List<Dish> result = dishDAO.getFOOD((pag*20));
        List<Food> refood= new ArrayList<Food>();
        for(Dish s: result){
            String[] tag={"comida", "rapida"};
            String[] origins={"Bolivia", "Test origin"};

            Food f = new Food(s.getId_dish(),s.getName(), s.getCost(), tag ,false,3.0,"assets/food-1.jpg",origins,"1 test");
            refood.add(f);
        }
        return refood;
    }

    public Food findFoodId(Integer id){
        Dish result = dishDAO.findishbyid(id);
        String[] tag={"comida", "rapida"};
        String[] origins={"Bolivia", "Test origin"};
        Food f = new Food(result.getId_dish(),result.getName(), result.getCost(), tag ,false,3.0,"assets/food-1.jpg",origins,"1 test");
        return f;
    }

    public List<Dish> userReport(Integer id, String row, String ord, Integer limit, Integer pag){
        Integer page=limit*pag;

        List<Dish> result = dishDAO.dishUserReport(id, Integer.parseInt(row),ord,limit,page);
        return result;
   }
}
