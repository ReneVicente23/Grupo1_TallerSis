package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.DishBL;
import bo.ucb.edu.TallerSis.DTO.Dish;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/order")
public class DishAPI {
    private DishBL dishBL;

    public DishAPI(DishBL dishBL) {
        this.dishBL = dishBL;
    }

    @GetMapping(path="/detail/{id}", produces = APPLICATION_JSON_VALUE)
    public List<Dish> finddetailorder(@PathVariable("id") Integer id) {
        return dishBL.findOrderDetails(id);
    }

    @GetMapping(path="/report/{id}", produces = APPLICATION_JSON_VALUE)
    public List<Dish> finddishreport(@PathVariable("id") Integer id) {
        return dishBL.findDishReport(id);
    }

    @GetMapping(path="/report/day/{id}", produces = APPLICATION_JSON_VALUE)
    public List<Dish> finddishrepday(@PathVariable("id") Integer id) {
        return dishBL.findDishReportDay(id);
    }

    @GetMapping(path="/report/cost/{id}", produces = APPLICATION_JSON_VALUE)
    public Double findtcost(@PathVariable("id") Integer id) {
        return dishBL.findDishReporttcost(id);
    }
}
