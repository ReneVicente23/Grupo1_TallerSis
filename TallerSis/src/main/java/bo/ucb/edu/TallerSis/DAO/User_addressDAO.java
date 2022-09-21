package bo.ucb.edu.TallerSis.DAO;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Service
public interface User_addressDAO {

    @Insert("INSERT INTO user_address (address_id_address, coordinate_id_coordinate, userapp_id_userapp,nickname,status) " +
            " VALUES ( #{id_address}, #{coordinate}, #{userapp}, #{nick}, #{status}) ")
    void saveuseraddress(@Param("id_address") Integer id_address, @Param("coordinate") Integer coordinate, @Param("userapp") Integer userid, @Param("nick") String nick,@Param("status")Integer status);

    @Update("UPDATE user_address SET nickname= #{nick} " +
            " WHERE id_user_address = #{id}")
    void updatenick(@Param("id") Integer id ,@Param("nick") String nick);

    @Update("UPDATE user_address SET status= #{status} " +
            " WHERE id_user_address = #{id}")
    void borraraddress(@Param("id") Integer id ,@Param("status") Integer status);
}
