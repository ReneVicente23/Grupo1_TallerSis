package bo.ucb.edu.TallerSis.BL;


import bo.ucb.edu.TallerSis.DAO.CoordinateDAO;
import bo.ucb.edu.TallerSis.DTO.Address;
import bo.ucb.edu.TallerSis.DTO.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinateBL {
    private CoordinateDAO coordinateDAO;

    @Autowired
    public CoordinateBL(CoordinateDAO coordinateDAO)
    {
        this.coordinateDAO = coordinateDAO;
    }

    public void saveCoordinate(Coordinate coordinate){
        Double latitude=coordinate.getLatitude();
        Double lenght=coordinate.getLength();

        coordinateDAO.saveAddress(latitude,lenght);
    }

    public Coordinate findcoordianteparams(Coordinate coordinate) {
        Coordinate result =coordinateDAO.getcoordinatebyparams(coordinate.getLatitude(),coordinate.getLength());
        return result;
    }

    public Coordinate findcoordianteid(Integer id) {
        Coordinate result =coordinateDAO.getcoordinatebyid(id);
        return result;
    }
}
