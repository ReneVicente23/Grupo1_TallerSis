package bo.ucb.edu.TallerSis.BL;

import bo.ucb.edu.TallerSis.DAO.DishDAO;
import bo.ucb.edu.TallerSis.DTO.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
