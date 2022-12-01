package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.Bussines;
import bo.ucb.edu.TallerSis.DTO.Count;
import bo.ucb.edu.TallerSis.DTO.Type_payment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public interface DashboardDAO {

    @Select("SELECT id_typepay, type " +
            "FROM type_payment ")
    public List<Type_payment> paymentmetods();

    @Select("SELECT COUNT(type_payment_id_typepay) " +
            "FROM \"order\" WHERE type_payment_id_typepay = #{id} ")
    public Count countmetods(@Param("id") Integer id);

    @Select("SELECT COUNT(id_order) " +
            "FROM \"order\" WHERE order_status_id_order_status=3 AND orderdate < #{inta} AND orderdate > #{intb}; ")
    public Count countventasmes(@Param("inta") LocalDate a, @Param("intb") LocalDate b);

    @Select("SELECT COUNT(p.id_order) " +
            "FROM \"order\" p JOIN delivery j ON p.delivery_id_delivery = j.id_delivery JOIN business b ON b.id_business=j.business_id_business WHERE b.id_business = #{id} ")
    public Count countbuss(@Param("id") Integer id);

    @Select("SELECT id_business, name_business, address_id_address " +
            "FROM business ")
    public List<Bussines> getbussines();
}
