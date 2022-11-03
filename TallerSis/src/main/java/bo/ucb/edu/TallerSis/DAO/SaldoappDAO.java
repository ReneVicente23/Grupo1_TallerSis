package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.Saldoapp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Service
public interface SaldoappDAO {

    @Insert("INSERT INTO saldoapp (saldo, userapp_id_userapp ) " +
            " VALUES ( #{saldo}, #{id}) ")
    void saveSaldoapp(@Param("saldo") Double saldo, @Param("id") Integer id);

    @Update("UPDATE saldoapp SET saldo= #{saldo} " +
            " WHERE userapp_id_userapp = #{id}")
    void updatesaldo(@Param("id") Integer id ,@Param("saldo") Double saldo);

    @Select("SELECT id_saldo, saldo, userapp_id_userapp " +
            "FROM saldoapp WHERE userapp_id_userapp= #{id}")
    public Saldoapp getsaldoapp(@Param("id") Integer id);

}
