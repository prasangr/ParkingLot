package Controller;

import DTO.GenerateTicketRequestDto;
import DTO.GenerateTicketResponseDto;
import DTO.ResponseStatus;
import Models.Ticket;
import Services.TicketService;
import Exception.NoParkingSpotFoundException;


public class TicketController {

    private TicketService ticketService;


    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto) {

        try {


            Ticket ticket = ticketService.generateTicket(generateTicketRequestDto.getVehicleNumber(),
                    generateTicketRequestDto.getVehicleType(),
                    generateTicketRequestDto.getGateId());

            GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
            generateTicketResponseDto.setTicket(ticket);
            generateTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

            return generateTicketResponseDto;

        }
        catch(NoParkingSpotFoundException e){
            GenerateTicketResponseDto generateTicketResponseDto=new GenerateTicketResponseDto();
            generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            generateTicketResponseDto.setFailureMessage(e.getMessage());
            return generateTicketResponseDto;
        }
        catch (Exception e){
            GenerateTicketResponseDto generateTicketResponseDto=new GenerateTicketResponseDto();
            generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            generateTicketResponseDto.setFailureMessage(e.getMessage());
            return generateTicketResponseDto;
        }



    }
}
