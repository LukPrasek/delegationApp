package pl.lukaszprasek.delegationApp.common.mappers;

import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.rest.response.CarRestModel;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarMapperFromDtoToRESTModel implements CarMapper<CarDto, CarRestModel> {

    @Override
    public CarRestModel map(CarDto from) {
        CarRestModel carRestModel = new CarRestModel();
        carRestModel.setCarId(from.getCarId());
        carRestModel.setBrand(from.getBrand());
        carRestModel.setModel(from.getModel());
        carRestModel.setSeatsNumber(from.getSeatsNumber());
        carRestModel.setEmployeeId(from.getEmployeeId());
        carRestModel.setPassengers(from.getPassengersId());
        return carRestModel;
    }

    @Override
    public List<CarRestModel> mapList(List<CarDto> from) {
        return from.stream().map(this::map).collect(Collectors.toList());
    }
}
