package nongsan.webmvc.model;

public class Product {
    private String id;
    private String catalog_id;
    private String name;
    private String price;
    private int qty;
    private String status;
    private String description;
    private String content;
    private String image_link;
    private String created;
    private String discount;

    public Product() {
    }

    public Product(String id, String catalog_id, String name, String price, int qty, String status, String description, String content, String image_link, String created, String discount) {
        this.id = id;
        this.catalog_id = catalog_id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.status = status;
        this.description = description;
        this.content = content;
        this.image_link = image_link;
        this.created = created;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(String catalog_id) {
        this.catalog_id = catalog_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", catalog_id='" + catalog_id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", qty=" + qty +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", image_link='" + image_link + '\'' +
                ", created='" + created + '\'' +
                ", discount='" + discount + '\'' +
                '}';
    }
}
