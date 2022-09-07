package bo.ucb.edu.TallerSis.DTO;

public class Coordinate
{
    //atributos
    private Integer id_coordinate;
    private Double latitude;
    private Double length;
    //constructor principal
    public Coordinate(Integer id_coordinate, Double latitude, Double length)
    {
        this.id_coordinate = id_coordinate;
        this.latitude = latitude;
        this.length = length;
    }
    //constructor vacio
    public Coordinate()
    {
        this.id_coordinate = 0;
        this.latitude = 0.0;
        this.length = 0.0;
    }
    // GETTERS AND SETTERS
    public Integer getId_coordinate() {
        return id_coordinate;
    }

    public void setId_coordinate(Integer id_coordinate) {
        this.id_coordinate = id_coordinate;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }
    //TO STRING PARA PRUEBAS
    @Override
    public String toString()
    {
        return "Coordinate" +
                "{" +
                "\nid_coordinate = " + id_coordinate +
                "\nlatitude = " + latitude +
                "\nlength = " + length +
                "\n}";
    }
}
