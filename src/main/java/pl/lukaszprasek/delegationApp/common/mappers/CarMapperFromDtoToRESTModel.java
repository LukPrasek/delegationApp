package pl.lukaszprasek.delegationApp.common.mappers;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.rest.response.CarRestModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarMapperFromDtoToRESTModel implements CarMapper<CarDto, CarRestModel> {
//private final PassengerMapperFromDtoToRESTModelImpl passengerEmployeeMapperFromDtoToRESTModel;
//
//    public CarMapperFromDtoToRESTModel(PassengerMapperFromDtoToRESTModelImpl passengerEmployeeMapperFromDtoToRESTModel) {
//        this.passengerEmployeeMapperFromDtoToRESTModel = passengerEmployeeMapperFromDtoToRESTModel;
//    }

    @Override
    public CarRestModel map(CarDto from) {
        CarRestModel carRestModel = new CarRestModel();
        List<Long> longs = Arrays.asList(ArrayUtils.toObject(new long[]{1, 2, 3, 4}));
        carRestModel.setCarId(from.getCarId());
        carRestModel.setBrand(from.getBrand());
        carRestModel.setModel(from.getModel());
        carRestModel.setSeatsNumber(from.getSeatsNumber());
        carRestModel.setEmployeeId(from.getEmployeeId());
        carRestModel.setPassengers(from.getPassengersId());
        // carRestModel.setPassengers(longs);

        return carRestModel;
    }

    @Override
    public List<CarRestModel> mapList(List<CarDto> from) {
        return from.stream().map(this::map).collect(Collectors.toList());
    }
}
