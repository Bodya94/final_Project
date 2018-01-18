package models.entity;

public class Feedback {

    private int id;
    private int idEmploye;
    private int idCustomer;
    private String text;
    private String creted;

    public Feedback() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreted() {
        return creted;
    }

    public void setCreted(String creted) {
        this.creted = creted;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", idEmploye=" + idEmploye +
                ", idCustomer=" + idCustomer +
                ", text='" + text + '\'' +
                ", creted='" + creted + '\'' +
                '}';
    }
}
