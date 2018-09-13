package pl.lukaszprasek.delegationApp.common.mappers;

import java.util.List;

public interface EmployeeMapperFromEntityToDto<T, V> {
    pl.lukaszprasek.delegationApp.common.dto.EmployeeDto mapEmployeeEntityToDto(T from);

    List<V> mapListFromEntitiesToDtos(List<T> from);
}
