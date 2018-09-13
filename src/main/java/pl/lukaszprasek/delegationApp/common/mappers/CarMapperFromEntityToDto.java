package pl.lukaszprasek.delegationApp.common.mappers;

import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;

public interface CarMapperFromEntityToDto <F, T> {
    T mapToDto(F from);
}
