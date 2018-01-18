package models.entity;

public class RenderedService {

    private int id;
    private String date;
    private int customerId;
    private int employeId;
    private int serviceId;

    public RenderedService() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeId() {
        return employeId;
    }

    public void setEmployeId(int employeId) {
        this.employeId = employeId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "RenderedService{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", customerId=" + customerId +
                ", employeId=" + employeId +
                ", serviceId=" + serviceId +
                '}';
    }
}
