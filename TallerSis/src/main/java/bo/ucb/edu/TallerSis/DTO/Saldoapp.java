package bo.ucb.edu.TallerSis.DTO;

public class Saldoapp {
    private Integer id_saldo;
    private Double saldo;
    private Integer userapp_id_userapp;

    public Saldoapp(Integer id_saldo, Double saldo, Integer userapp_id_userapp) {
        this.id_saldo = id_saldo;
        this.saldo = saldo;
        this.userapp_id_userapp = userapp_id_userapp;
    }

    public Integer getId_saldo() {
        return id_saldo;
    }

    public void setId_saldo(Integer id_saldo) {
        this.id_saldo = id_saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getUserapp_id_userapp() {
        return userapp_id_userapp;
    }

    public void setUserapp_id_userapp(Integer userapp_id_userapp) {
        this.userapp_id_userapp = userapp_id_userapp;
    }

    @Override
    public String toString() {
        return "saldoapp{" +
                "id_saldo=" + id_saldo +
                ", saldo=" + saldo +
                ", userapp_id_userapp=" + userapp_id_userapp +
                '}';
    }
}
