package Controller;

import DTO.GenerateBillRequestDto;
import DTO.GenerateBillResponseDto;
import Models.Bill;
import Services.BillService;

public class BillController {

    private BillService billService;
    public GenerateBillResponseDto generateBill(GenerateBillRequestDto generateBillRequestDto){

        Bill bill= billService.generateBill(generateBillRequestDto.getVehiclenumber(), generateBillRequestDto.getVehicleType());

        return null;
    }
}
