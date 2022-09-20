package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.Address;
import bo.ucb.edu.TallerSis.DTO.Coordinate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoordinateDAO
{
    @Insert("INSERT INTO coordinate (latitude,length)" +
            " VALUES (#{latitude}, #{lenght});")
    void saveAddress(@Param("latitude") Double latitude, @Param("lenght") Double lenght);

    @Select("SELECT id_coordinate, latitude, length " +
            "FROM coordinate WHERE latitude=#{latitude} AND length = #{lenght};")
    public Coordinate getcoordinatebyparams(@Param("latitude") Double latitude, @Param("lenght") Double lenght);

    @Select("SELECT id_coordinate, latitude, length " +
            "FROM coordinate WHERE id_coordinate=#{id};")
    public Coordinate getcoordinatebyid(@Param("id") Integer id);
}

