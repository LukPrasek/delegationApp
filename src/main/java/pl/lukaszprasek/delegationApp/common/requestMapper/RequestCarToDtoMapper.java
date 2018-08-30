package pl.lukaszprasek.delegationApp.common.requestMapper;

import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.rest.request.CreateCarRequest;

public interface RequestCarToDtoMapper {
    CarDto mapCreatedRequestToDTO(CreateCarRequest createCarRequest);
}
