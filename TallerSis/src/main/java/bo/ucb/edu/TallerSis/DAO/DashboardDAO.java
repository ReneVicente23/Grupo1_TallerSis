package bo.ucb.edu.TallerSis.DAO;

import bo.ucb.edu.TallerSis.DTO.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public interface DashboardDAO {

    //admin
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

    //bussines
    @Select("SELECT id_dish, name,description,cost,business_id_business " +
            "FROM dish WHERE business_id_business = #{id} ")
    public List<Dish> products(@Param("id") Integer id);

    @Select("SELECT COUNT(id_order_details) " +
            "FROM order_details WHERE dish_id_dish = #{id} ")
    public Count productscount(@Param("id") Integer id);

    @Select("SELECT COUNT(o.id_order) " +
            "FROM \"order\" o JOIN order_details d ON o.id_order= d.order_id_order JOIN dish j ON j.id_dish = d.dish_id_dish WHERE j.business_id_business=#{id} AND o.order_status_id_order_status=3 AND o.orderdate <= #{inta} AND orderdate >= #{intb}; ")
    public Count countventasmesbss(@Param("id") Integer id,@Param("inta") LocalDate a, @Param("intb") LocalDate b);

    @Select("SELECT SUM(o.total_payment) " +
            "FROM \"order\" o JOIN delivery d ON o.delivery_id_delivery= d.id_delivery WHERE d.business_id_business=#{id} AND o.order_status_id_order_status=3 AND o.orderdate < #{inta} AND orderdate > #{intb}; ")
    public Cost sumpricesales(@Param("id") Integer id, @Param("inta") LocalDate a, @Param("intb") LocalDate b);

    //delivery
    @Select("SELECT COUNT(o.id_order) " +
            "FROM \"order\" o JOIN delivery d ON o.delivery_id_delivery= d.id_delivery WHERE d.userapp_id_userapp=#{id} AND o.order_status_id_order_status=3 AND o.orderdate < #{inta} AND o.orderdate > #{intb}; ")
    public Count countdeli(@Param("id") Integer id,@Param("inta") LocalDate a, @Param("intb") LocalDate b);

    @Select("SELECT COUNT(o.order_status_id_order_status) " +
            "FROM \"order\" o JOIN delivery d ON o.delivery_id_delivery= d.id_delivery WHERE d.userapp_id_userapp=#{id} AND o.order_status_id_order_status=#{tp}")
    public Count orderstatus(@Param("id") Integer id,@Param("tp") Integer idb);

}
