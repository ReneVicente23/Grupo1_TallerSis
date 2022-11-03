package bo.ucb.edu.TallerSis.DTO;

public class Pagofav {
    private Integer idpagofav;
    private Integer type_payment_id_typepay;
    private Integer userapp_id_userapp;

    public Pagofav(Integer idpagofav, Integer type_payment_id_typepay, Integer userapp_id_userapp) {
        this.idpagofav = idpagofav;
        this.type_payment_id_typepay = type_payment_id_typepay;
        this.userapp_id_userapp = userapp_id_userapp;
    }

    public Integer getIdpagofav() {
        return idpagofav;
    }

    public void setIdpagofav(Integer idpagofav) {
        this.idpagofav = idpagofav;
    }

    public Integer getType_payment_id_typepay() {
        return type_payment_id_typepay;
    }

    public void setType_payment_id_typepay(Integer type_payment_id_typepay) {
        this.type_payment_id_typepay = type_payment_id_typepay;
    }

    public Integer getUserapp_id_userapp() {
        return userapp_id_userapp;
    }

    public void setUserapp_id_userapp(Integer userapp_id_userapp) {
        this.userapp_id_userapp = userapp_id_userapp;
    }

    @Override
    public String toString() {
        return "pagofav{" +
                "idpagofav=" + idpagofav +
                ", type_payment_id_typepay=" + type_payment_id_typepay +
                ", userapp_id_userapp=" + userapp_id_userapp +
                '}';
    }
}
