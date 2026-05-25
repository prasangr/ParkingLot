import Controller.TicketController;
import Repository.TicketRepository;
import Services.TicketService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ObjectContainter objectContainter=new ObjectContainter();

        TicketService ticketService=new TicketService();

        objectContainter.register("ticketService",ticketService);

        TicketController ticketController=new TicketController((TicketService) objectContainter.get(String.valueOf(ticketService)));


     //   ticketController.generateTicket(new DTO.GenerateTicketRequestDto("KA-01-HH-1234,Car",1L));

        //Assignment: complete generate ticket and implement bill

    }
}