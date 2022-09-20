package bo.ucb.edu.TallerSis.API;

import bo.ucb.edu.TallerSis.BL.AddressBL;
import bo.ucb.edu.TallerSis.BL.CoordinateBL;
import bo.ucb.edu.TallerSis.DTO.Address;
import bo.ucb.edu.TallerSis.DTO.Coordinate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/coordinate")
public class CoordinateAPI
{
    private CoordinateBL coordinateBL;

    public CoordinateAPI(CoordinateBL coordinateBL) {
        this.coordinateBL = coordinateBL;
    }

    @PostMapping(path="/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Coordinate insertcoordinate(@RequestBody Coordinate coordinate) {
        coordinateBL.saveCoordinate(coordinate);
        return coordinate;
    }//tested

    @PostMapping(path="/search", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Coordinate searchcoordinate(@RequestBody Coordinate coordinate) {
        Coordinate result= coordinateBL.findcoordianteparams(coordinate);
        return result;
    }//tested

    @GetMapping(path="/{id}", produces = APPLICATION_JSON_VALUE)
    public Coordinate findcoordinateid(@PathVariable("id") Integer id) {
        return coordinateBL.findcoordianteid(id);
    }//tested
}
