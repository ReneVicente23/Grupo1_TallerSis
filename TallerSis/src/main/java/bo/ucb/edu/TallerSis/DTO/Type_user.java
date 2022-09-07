package bo.ucb.edu.TallerSis.DTO;

public class Type_user
{
    //atributos
    private Integer type_id;
    private String name_rol ;
    private String description ;
    //CONSTRUCTORES
    public Type_user(Integer type_id, String name_rol, String description)
    {
        this.type_id = type_id;
        this.name_rol = name_rol;
        this.description = description;
    }
    public Type_user() {
        this.type_id = 0;
        this.name_rol = "";
        this.description = "";
    }
    //GETTERS AND SETTERS
    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getName_rol() {
        return name_rol;
    }

    public void setName_rol(String name_rol) {
        this.name_rol = name_rol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //TO STRING

    @Override
    public String toString()
    {
        return "Type_user{" +
                "type_id=" + type_id +
                ", name_rol='" + name_rol + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
