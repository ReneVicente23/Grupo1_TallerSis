package bo.ucb.edu.TallerSis.BL;


import bo.ucb.edu.TallerSis.DAO.CoordinateDAO;
import bo.ucb.edu.TallerSis.DTO.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinateBL
{
    private CoordinateDAO coordinateDAO;

    @Autowired
    public CoordinateBL(CoordinateDAO coordinateDAO)
    {
        this.coordinateDAO = coordinateDAO;
    }
    public void saveCoordinate(Coordinate coordinate, Long Id){
        Integer id= Math.toIntExact(Id);
        Double latitude=coordinate.getLatitude();
        Double lenght=coordinate.getLatitude();



    }
}
