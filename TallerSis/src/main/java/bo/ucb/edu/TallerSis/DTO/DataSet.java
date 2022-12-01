package bo.ucb.edu.TallerSis.DTO;

public class DataSet {
    private String x;
    private Integer y;

    public DataSet(String label, Integer data) {
        this.x = label;
        this.y = data;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
