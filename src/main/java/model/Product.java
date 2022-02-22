package model;

public class Product {
    private int id;
    private String name;
    private long price;
    private int quantity;
    private String datePost;
    private String details;
    private Status status;
    private String img;

    public Product(){

    }

    public Product(int id, String name, long price, int quantity, String datePost, String details, Status status,String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.datePost = datePost;
        this.details = details;
        this.status = status;
        this.img=img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDatePost() {
        return datePost;
    }

    public void setDatePost(String datePost) {
        this.datePost = datePost;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", datePost='" + datePost + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                ", img='" + img + '\'' +
                '}';
    }
}
