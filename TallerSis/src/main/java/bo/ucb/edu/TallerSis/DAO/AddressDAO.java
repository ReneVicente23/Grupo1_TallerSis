package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressDAO {
    @Select("SELECT p.id_address, p.street, p.zone, p.h_number, p.city , p.ref " +
            "FROM address p JOIN user_address u  ON p.id_address = u.address_id_address WHERE u.userapp_id_userapp = #{userid} AND u.status = 1")
    public List<Address> findAddress(@Param("userid") Integer id);

    @Select("SELECT id_address, street, zone, h_number, city, ref " +
            "FROM address  WHERE id_address = #{addressid}")
    public Address findAddressid(@Param("addressid") Integer id);

    @Select("SELECT DISTINCT id_address " +
            "FROM address  WHERE street = #{street} AND zone = #{zone} AND h_number = #{h_number} AND city = #{city}")
    public Integer findIDAddress(@Param("street") String street, @Param("zone") String zone, @Param("h_number") String h_number, @Param("city") String city);

    @Insert("INSERT INTO address(street, zone, h_number, city, ref) " +
            " VALUES ( #{street}, #{zone}, #{h_number}, #{city} , #{ref}) ")
    void saveAddress(@Param("street") String street,@Param("zone") String zone,@Param("h_number") String  h_number,@Param("city") String city, @Param("ref") String ref);

    @Update("UPDATE address SET street= #{street}, zone= #{zone}, h_number= #{h_number}, city=#{city} , ref=#{ref} " +
            " WHERE id_address = #{id}")
    void updateAddress(@Param("id") Integer id ,@Param("street") String street,@Param("zone") String zone,@Param("h_number") String  h_number,@Param("city") String city,@Param("ref") String ref);
}
