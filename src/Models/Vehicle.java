package Models;

public class Vehicle extends BaseEntity{
private String number;
private VehicleType vehicleType;

    public Vehicle(String number, VehicleType type) {
        super();
        this.number= number;
        this.vehicleType=type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

}
