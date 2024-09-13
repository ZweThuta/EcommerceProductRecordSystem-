package carinformationsystem;

public class Car {
    int car_id;
    String car_number;
    String car_name;
    int model;
    int kilometer;
    String fueltype;
    String drivetype;
    int price;

    public Car(int car_id, String car_number, String car_name, int model, int kilometer, String fueltype, String drivetype, int price) {
        this.car_id = car_id;
        this.car_number = car_number;
        this.car_name = car_name;
        this.model = model;
        this.kilometer = kilometer;
        this.fueltype = fueltype;
        this.drivetype = drivetype;
        this.price = price;

    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getKilometer() {
        return kilometer;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public String getDrivetype() {
        return drivetype;
    }

    public void setDrivetype(String drivetype) {
        this.drivetype = drivetype;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_id=" + car_id +
                ", car_number='" + car_number + '\'' +
                ", car_name='" + car_name + '\'' +
                ", model=" + model +
                ", kilometer=" + kilometer +
                ", fueltype='" + fueltype + '\'' +
                ", drivetype='" + drivetype + '\'' +
                ", price=" + price +
                '}';
    }
}