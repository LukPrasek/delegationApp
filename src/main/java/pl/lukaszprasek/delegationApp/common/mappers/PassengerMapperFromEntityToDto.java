package pl.lukaszprasek.delegationApp.common.mappers;

import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;

import java.util.List;

public interface PassengerMapperFromEntityToDto<T, V> {
    V mapPassengerEntityToDto(T from);

    List<V> mapList(List<T> from);
}
