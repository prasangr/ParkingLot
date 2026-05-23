package Repository;

import Models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
// Using map as in inmemory database for this project to push and retrieve data

    Map<String, Vehicle> vehicleStore;

    public VehicleRepository(){
        this.vehicleStore=new HashMap<>();

    }

    public void addVehicle(Vehicle vehicle){
        vehicleStore.put(vehicle.getNumber(),vehicle);
    }

    public Vehicle getVehicle(String number){
        return vehicleStore.get(number);
    }


}
