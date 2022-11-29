package bo.ucb.edu.TallerSis.DTO;

public class AdminBussinesRep {
    private Integer id;
    private String bussines;
    private String orders;
    private String completed;
    private String canceled;
    private Double totalpay;
    private Double gain;

    public AdminBussinesRep(Integer id, String bussines, String orders, String completed, String canceled, Double totalpay, Double gain) {
        this.id = id;
        this.bussines = bussines;
        this.orders = orders;
        this.completed = completed;
        this.canceled = canceled;
        this.totalpay = totalpay;
        this.gain = gain;
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

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getCanceled() {
        return canceled;
    }

    public void setCanceled(String canceled) {
        this.canceled = canceled;
    }

    public Double getTotalpay() {
        return totalpay;
    }

    public void setTotalpay(Double totalpay) {
        this.totalpay = totalpay;
    }

    public Double getGain() {
        return gain;
    }

    public void setGain(Double gain) {
        this.gain = gain;
    }
}
