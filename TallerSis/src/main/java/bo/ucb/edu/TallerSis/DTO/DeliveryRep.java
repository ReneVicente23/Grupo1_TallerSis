package bo.ucb.edu.TallerSis.DTO;

import java.sql.Date;

public class DeliveryRep {
    private Integer id;
    private String bussines;
    private String cliente;
    private Double totalpayment;
    private String status;
    private Double gain;
    private Date date;

    public DeliveryRep(Integer id, String bussines, String cliente, Double totalpayment, String status, Double gain, Date date) {
        this.id = id;
        this.bussines = bussines;
        this.cliente = cliente;
        this.totalpayment = totalpayment;
        this.status = status;
        this.gain = gain;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBussines() {
        return bussines;
    }

    public void setBussines(String bussines) {
        this.bussines = bussines;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getTotalpayment() {
        return totalpayment;
    }

    public void setTotalpayment(Double totalpayment) {
        this.totalpayment = totalpayment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getGain() {
        return gain;
    }

    public void setGain(Double gain) {
        this.gain = gain;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DeliveryRep{" +
                "id=" + id +
                ", bussines='" + bussines + '\'' +
                ", cliente='" + cliente + '\'' +
                ", totalpayment=" + totalpayment +
                ", status='" + status + '\'' +
                ", gain=" + gain +
                ", date=" + date +
                '}';
    }
}
