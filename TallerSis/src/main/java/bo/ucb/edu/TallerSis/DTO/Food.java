package bo.ucb.edu.TallerSis.DTO;

public class Food {
    private Integer id;
    private String name;
    private  Double price;
    private String[] tags;
    private Boolean favorite;
    private Double stars;
    private String imageUrl;
    private String[] origins;
    private String cookTime;

    public Food(Integer id, String name, Double price, String[] tags, Boolean favorite, Double stars, String imageUrl, String[] origins, String cookTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.tags = tags;
        this.favorite = favorite;
        this.stars = stars;
        this.imageUrl = imageUrl;
        this.origins = origins;
        this.cookTime = cookTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String[] getOrigins() {
        return origins;
    }

    public void setOrigins(String[] origins) {
        this.origins = origins;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", tags='" + tags + '\'' +
                ", favorite=" + favorite +
                ", stars=" + stars +
                ", imageUrl='" + imageUrl + '\'' +
                ", origins='" + origins + '\'' +
                ", cookTime='" + cookTime + '\'' +
                '}';
    }
}
