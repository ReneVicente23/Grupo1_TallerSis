package bo.ucb.edu.TallerSis.DTO;

public class Tarjeta {
    private Integer t_id;
    private String n_tarjeta;
    private String caducidad;
    private Integer cvv;
    private String titular;
    private Integer userapp_id_userapp;

    public Tarjeta(Integer t_id, String n_tarjeta, String caducidad, Integer cvv, String titular, Integer userapp_id_userapp) {
        this.t_id = t_id;
        this.n_tarjeta = n_tarjeta;
        this.caducidad = caducidad;
        this.cvv = cvv;
        this.titular = titular;
        this.userapp_id_userapp = userapp_id_userapp;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getN_tarjeta() {
        return n_tarjeta;
    }

    public void setN_tarjeta(String n_tarjeta) {
        this.n_tarjeta = n_tarjeta;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Integer getUserapp_id_userapp() {
        return userapp_id_userapp;
    }

    public void setUserapp_id_userapp(Integer userapp_id_userapp) {
        this.userapp_id_userapp = userapp_id_userapp;
    }

    @Override
    public String toString() {
        return "tarjeta{" +
                "t_id=" + t_id +
                ", n_tarjeta='" + n_tarjeta + '\'' +
                ", caducidad='" + caducidad + '\'' +
                ", cvv=" + cvv +
                ", titular='" + titular + '\'' +
                ", userapp_id_userapp=" + userapp_id_userapp +
                '}';
    }
}
