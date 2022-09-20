package bo.ucb.edu.TallerSis.DTO;

public class Dish {
    private Integer id_dish;
    private String name;
    private String description;
    private Double cost;
    private int business_id_business;

    public Dish(Integer id_dish, String name, String description, Double cost, int business_id_business) {
        this.id_dish = id_dish;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.business_id_business = business_id_business;
    }

    public Integer getId_dish() {
        return id_dish;
    }

    public void setId_dish(Integer id_dish) {
        this.id_dish = id_dish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getBusiness_id_business() {
        return business_id_business;
    }

    public void setBusiness_id_business(int business_id_business) {
        this.business_id_business = business_id_business;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id_dish=" + id_dish +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", business_id_business=" + business_id_business +
                '}';
    }
}
