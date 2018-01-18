package models.entity;

public class Service {
    private int id;
    private int cost;
    private String kind;

    public Service() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", cost=" + cost +
                ", kind='" + kind + '\'' +
                '}';
    }
}
