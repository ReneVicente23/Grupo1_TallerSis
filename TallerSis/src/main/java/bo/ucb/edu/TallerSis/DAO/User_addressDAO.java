package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.Nick;
import bo.ucb.edu.TallerSis.DTO.Type_payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface User_addressDAO {

    @Insert("INSERT INTO user_address (address_id_address, coordinate_id_coordinate, userapp_id_userapp,nickname,status) " +
            " VALUES ( #{id_address}, #{coordinate}, #{userapp}, #{nick}, #{status}) ")
    void saveuseraddress(@Param("id_address") Integer id_address, @Param("coordinate") Integer coordinate, @Param("userapp") Integer userid, @Param("nick") String nick,@Param("status")Integer status);

    @Update("UPDATE user_address SET nickname= #{nick} " +
            " WHERE address_id_address = #{id}")
    void updatenick(@Param("id") Integer id ,@Param("nick") String nick);

    @Update("UPDATE user_address SET status= #{status} " +
            " WHERE address_id_address = #{id}")
    void borraraddress(@Param("id") Integer id ,@Param("status") Integer status);

    @Update("UPDATE user_address SET status= 1 " +
            " WHERE id_user_address = #{id} AND status <> 3")
    void nofav(@Param("id") Integer id );

    @Select("SELECT address_id_address " +
            "FROM user_address WHERE userapp_id_userapp= #{id} AND status = 2 ")
    public Integer getidfav(@Param("id") Integer id);

    @Select("SELECT DISTINCT address_id_address " +
            "FROM user_address WHERE userapp_id_userapp= #{id} LIMIT 1")
    public Integer getidaddres(@Param("id") Integer id);

    @Update("UPDATE user_address SET status = 3 " +
            " WHERE userapp_id_userapp = #{id} AND address_id_address = #{idress} ")
    void borradirecc(@Param("id") Integer id, @Param("idress") Integer idress );

    @Select("SELECT nickname " +
            "FROM user_address WHERE address_id_address= #{id} LIMIT 1")
    public Nick getnick(@Param("id") Integer id);

}
