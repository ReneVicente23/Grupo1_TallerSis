package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.User;
import bo.ucb.edu.TallerSis.DTO.User2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDAO {
    @Insert("INSERT INTO \"userapp\"(name, last_name, phone, mail, type_user_typeid) " +
            " VALUES ( #{name}, #{last_name}, #{phone}, #{mail},#{type_user_typeid}) ")
    void nuevousuario(@Param("name") String name,@Param("last_name") String last_name,@Param("phone") String phone,@Param("mail") String mail,@Param("type_user_typeid") Integer type_user_typeid );

    @Select("SELECT id_userapp, name, last_name, phone, mail, type_user_typeid " +
            "FROM userapp  WHERE mail= #{name} AND last_name = #{last}")
    public User auth(@Param("name") String name, @Param("last") String last);

}
