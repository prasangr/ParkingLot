package Services;

import Models.Gate;
import Models.ParkingSpot;
import Models.Vehicle;
import Repository.ParkingLotRepository;
import Strategy.SpotAssignmentStrategy;

import java.util.List;

public class ParkingLotService {

    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository, SpotAssignmentStrategy spotAssignmentStrategy){
        this.parkingLotRepository = parkingLotRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }


    public ParkingSpot getParkingSpot(Vehicle vehicle, Gate gate){
        // Logic to get parking spot for a vehicle
        List<ParkingSpot> parkingSpotList=parkingLotRepository.getAllParkingSpots();
        return  spotAssignmentStrategy.assignSpot(vehicle.getVehicleType(),gate,parkingSpotList);
    }

}
