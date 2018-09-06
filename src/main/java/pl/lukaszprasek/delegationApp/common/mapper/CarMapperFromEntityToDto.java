package pl.lukaszprasek.delegationApp.common.mapper;

import pl.lukaszprasek.delegationApp.common.dto.CarDto;

public interface CarMapperFromEntityToDto <F, T> {
    CarDto mapToDto(F from);
}
