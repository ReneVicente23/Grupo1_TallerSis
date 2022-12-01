package bo.ucb.edu.TallerSis.DTO;

public class Cost {
    private Double cost;

    public Cost(Double cost) {
        this.cost = cost;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "cost=" + cost +
                '}';
    }
}
