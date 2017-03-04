package home.elitej.model.entity;



public class Restaurant extends BaseEntity {

    private String kitchen;

    private String address;

    private String phone;

    private String workingHours;

    private String image;

    private String description;

    public Restaurant() {
    }

    public Restaurant(int id, String name, String kitchen, String address, String phone, String workingHours, String image) {
        super(id, name);
        this.kitchen = kitchen;
        this.address = address;
        this.phone = phone;
        this.workingHours = workingHours;
        this.image = image;
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
