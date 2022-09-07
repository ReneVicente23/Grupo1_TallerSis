package bo.ucb.edu.TallerSis.DTO;

public class Type_payment
{
    //atributos
    private Integer id_typepay;
    private String type;
    //constructor
    public Type_payment(Integer id_typepay, String type)
    {
        this.id_typepay = id_typepay;
        this.type = type;
    }
    public Type_payment()
    {
        this.id_typepay = 0;
        this.type = "";
    }
    //getters and setters
    public Integer getId_typepay() {
        return id_typepay;
    }

    public void setId_typepay(Integer id_typepay) {
        this.id_typepay = id_typepay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //to string
    @Override
    public String toString()
    {
        return "Type_payment{" +
                "id_typepay=" + id_typepay +
                ", type='" + type + '\'' +
                '}';
    }
}
