package Services;

import Models.Vehicle;
import Models.VehicleType;
import Repository.VehicleRepository;

public class VehicleService {
private VehicleRepository vehicleRepository;

public VehicleService(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
    }

    public Vehicle registerVehicle(String number, VehicleType type){
        return this.vehicleRepository.addVehicle(new Vehicle(number,type));

    }
    public Vehicle getVehicleByNumber(String number){
        return vehicleRepository.getVehicle(number);
    }

}
