package Services;

import Models.ParkingSpot;
import Models.ParkingSpotStatus;

public class ParkingSpotService {
    public ParkingSpot updateParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot.setParkingSpotStatus(Models.ParkingSpotStatus.OCCUPIED);
        return parkingSpot;
    }

    public ParkingSpot freeParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        return parkingSpot;
    }


}
