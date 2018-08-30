package pl.lukaszprasek.delegationApp.common.requestMapper;

import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.rest.request.CreateCarRequest;

@Component
public class RequestCarToDtoMapperImpl implements RequestCarToDtoMapper {
    @Override
    public CarDto mapCreatedRequestToDTO(CreateCarRequest createCarRequest) {
        return new CarDto.Builder()
                .withBrand(createCarRequest.getBrand())
                .withModel(createCarRequest.getModel())
                .withSeatsNumber(createCarRequest.getSeatsNumber()).build();
    }
}
