package pl.lukaszprasek.delegationApp.common.mappers;

import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;
import pl.lukaszprasek.delegationApp.rest.response.PassengerRestModel;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class PassengerEmployeeMapperFromDtoToRESTModel implements PassengerMapperFromDtoToRESTModel<PassengerDto, PassengerRestModel> {

    @Override
    public PassengerRestModel mapToRestModel(PassengerDto from) {
        PassengerRestModel passengerRestModel = new PassengerRestModel();
        passengerRestModel.setPassengerId(from.getPassengerId());
//        passengerRestModel.setCarDto(from.getCarDto());
        passengerRestModel.setEmployeeDto(from.getEmployeeDto());
        return passengerRestModel;
    }

    @Override
    public List<PassengerRestModel> mapListToRest(List<PassengerDto> from) {
        return from.stream().map(this::mapToRestModel).collect(Collectors.toList());
    }
}
