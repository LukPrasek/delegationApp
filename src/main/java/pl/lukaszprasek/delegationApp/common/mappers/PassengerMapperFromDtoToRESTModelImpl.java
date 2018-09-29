package pl.lukaszprasek.delegationApp.common.mappers;

import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;
import pl.lukaszprasek.delegationApp.domain.services.CarService;
import pl.lukaszprasek.delegationApp.domain.services.EmployeeService;
import pl.lukaszprasek.delegationApp.rest.response.PassengerRestModel;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassengerMapperFromDtoToRESTModelImpl implements PassengerMapperFromDtoToRESTModel<PassengerDto, Long> {

//    private final CarMapperFromDtoToRESTModel carMapperFromDtoToRESTModel;
//    private final CarService carService;
//    private final EmployeeMapperFromDTOToRestModel employeeEmployeeMapperFromDTOToRestModel;
//    private final EmployeeService employeeService;
//
//    public PassengerEmployeeMapperFromDtoToRESTModel(CarMapperFromDtoToRESTModel carMapperFromDtoToRESTModel,
//                                                     CarService carService, EmployeeMapperFromDTOToRestModel employeeEmployeeMapperFromDTOToRestModel, EmployeeService employeeService) {
//        this.carMapperFromDtoToRESTModel = carMapperFromDtoToRESTModel;
//        this.carService = carService;
//        this.employeeEmployeeMapperFromDTOToRestModel = employeeEmployeeMapperFromDTOToRestModel;
//        this.employeeService = employeeService;
//    }


    @Override
    public Long mapToRestModel(PassengerDto from) {
        PassengerRestModel passengerRestModel = new PassengerRestModel();
        passengerRestModel.setPassengerId(from.getPassengerId());
        passengerRestModel.setCarRestModel(from.getCarDto());
        passengerRestModel.setEmployeeRestModel(from.getEmployeeDto());
        return from.getPassengerId();
    }

    @Override
    public List<Long> mapListToRest(List<PassengerDto> from) {
        return from.stream().map(this::mapToRestModel).collect(Collectors.toList());
    }
}
