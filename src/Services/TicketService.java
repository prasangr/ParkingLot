package Services;

import Models.*;
import Repository.TicketRepository;
import Strategy.SpotAssignmentStrategy;
import Exception.NoParkingSpotFoundException;

import java.util.Date;

public class TicketService {


    private VehicleService vehicleService;
    private GateService gateService;
    private ParkingSpotService parkingSpotService;
    private TicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotService parkingLotService;

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) throws NoParkingSpotFoundException {
        /*
            FLOW:
            1. get vehicle from db if its already present using vehicle number
            2. If vehicle is not found ,register the vehicle
            3. Assign Parking spot
            4. Update the Parking Spot as Occupied
            5. Generate Ticket
         */

        //1. get vehicle from db if its already present using vehicle number
        //2. If vehicle is not found ,register the vehicle

        Vehicle vehicle=vehicleService.getVehicleByNumber(vehicleNumber);
        if (vehicle==null){
            vehicle=vehicleService.registerVehicle(vehicleNumber,vehicleType);
        }


        Gate gate=gateService.getGate(gateId);
        //3. Assign Parking spot
        ParkingSpot parkingSpot=parkingLotService.getParkingSpot(vehicle,gate);
        if (parkingSpot==null){
            throw new NoParkingSpotFoundException("No Parking spot found");
        }

        // 4. Update the Parking Spot as Occupied
         parkingSpot=parkingSpotService.updateParkingSpot(parkingSpot);

        //5. Generate Ticket
        Ticket ticket=new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setParkingSpot(parkingSpot);
        ticket.setOperator(gate.getOperator());
        ticket.setEntryTime(Date.from(java.time.Instant.now()));

        //Saving the ticket in the in memory database
        ticketRepository.saveTicket(ticket);




        return ticket;
    }
}
