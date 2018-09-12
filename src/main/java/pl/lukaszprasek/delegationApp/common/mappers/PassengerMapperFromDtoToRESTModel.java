package pl.lukaszprasek.delegationApp.common.mappers;

import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;
import pl.lukaszprasek.delegationApp.rest.response.PassengerRestModel;

import java.util.List;
import java.util.stream.Collectors;

public class PassengerMapperFromDtoToRESTModel implements Mapper<PassengerDto, PassengerRestModel> {
    @Override
    public PassengerRestModel map(PassengerDto from) {
        PassengerRestModel passengerRestModel = new PassengerRestModel();
        passengerRestModel.setPassangerId(from.getPassengerId());
        passengerRestModel.setCarDto(from.getCarDto());
        passengerRestModel.setEmployeeDto(from.getEmployeeDto());
        return passengerRestModel;
    }

    @Override
    public List<PassengerRestModel> mapList(List<PassengerDto> from) {
        return from.stream().map(this::map).collect(Collectors.toList());
    }
}
