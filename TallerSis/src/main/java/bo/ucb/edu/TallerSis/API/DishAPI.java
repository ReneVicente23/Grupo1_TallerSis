package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.DishBL;
import bo.ucb.edu.TallerSis.DTO.Dish;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/order")
public class DishAPI {
    private DishBL dishBL;

    public DishAPI(DishBL dishBL) {
        this.dishBL = dishBL;
    }

    @GetMapping(path="/detail/{id}/", produces = APPLICATION_JSON_VALUE)
    public List<Dish> finddetailorder(@PathVariable("id") Integer id) {
        return dishBL.findOrderDetails(id);
    }
}
