package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressDAO {
    @Select("SELECT p.id_address, p.street, p.zone, p.h_number, p.city " +
            "FROM address p JOIN User_addres u  ON p.id_address = u.id_user_address WHERE u.user_id_user = #{userid}")
    public List<Address> findAddress(@Param("userid") Integer id);

    @Insert("INSERT INTO address(street, zone, h_number, city) " +
            " VALUES ( #{street}, #{zone}, #{ h_number}, #{city} ")
    void saveAddress(@Param("street") String street,@Param("zone") String zone,@Param(" h_number") String  h_number,@Param("city") String city);
}
