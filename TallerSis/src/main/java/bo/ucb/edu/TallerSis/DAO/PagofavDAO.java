package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.Pagofav;
import bo.ucb.edu.TallerSis.DTO.Saldoapp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Service
public interface PagofavDAO {
    @Insert("INSERT INTO pagofav (type_payment_id_typepay, userapp_id_userapp ) " +
            " VALUES ( #{type}, #{id}) ")
    void savePagofav(@Param("type") Integer type, @Param("id") Integer id);

    @Update("UPDATE pagofav SET type_payment_id_typepay= #{type} " +
            " WHERE userapp_id_userapp = #{id}")
    void updatePagofav(@Param("id") Integer id ,@Param("type") Integer type);

    @Select("SELECT idpagofav, type_payment_id_typepay, userapp_id_userapp " +
            "FROM pagofav WHERE userapp_id_userapp= #{id}")
    public Pagofav getPagofav(@Param("id") Integer id);

}
