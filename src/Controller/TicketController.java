package Controller;

import DTO.GenerateTicketRequestDto;
import DTO.GenerateTicketResponseDto;
import Models.Ticket;
import Services.TicketService;


public class TicketController {

    private TicketService ticketService;

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto) {
    Ticket ticket= ticketService.generateTicket(generateTicketRequestDto.getVehicleNumber(),
                                    generateTicketRequestDto.getVehicleType(),
                                    generateTicketRequestDto.getGateId());

    return null;
    }
}
