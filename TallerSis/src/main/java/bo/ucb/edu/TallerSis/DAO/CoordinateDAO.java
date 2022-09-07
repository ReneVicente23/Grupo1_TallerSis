package bo.ucb.edu.TallerSis.DAO;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface CoordinateDAO
{
    @Insert("INSERT INTO coordinate(latitude, lenght) " +
            " VALUES ( #{latitude}, #{lenght}")
    void saveAddress(@Param("latitude") Double latitude, @Param("lenght") Double lenght);
}

