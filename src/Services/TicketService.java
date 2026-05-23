package Services;

import Models.Ticket;

public class TicketService {


    private VehicleService vehicleService;

    public Ticket generateTicket(String vehicleNumber, String vehicleType, Long gateId) {
        /*
            FLOW:
            1. get vehicle from db if its already present using vehicle number
            2. If vehicle is not found ,register the vehicle
            3. Assign Parking spot
            4. Update the Parking Spot as Occupied
            5. Generate Ticket

         */


        return null;
    }
}
