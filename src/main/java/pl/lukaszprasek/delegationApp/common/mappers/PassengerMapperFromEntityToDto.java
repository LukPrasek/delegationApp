package pl.lukaszprasek.delegationApp.common.mappers;

import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;

import java.util.List;

public interface PassengerMapperFromEntityToDto<T, V> {
    PassengerDto mapPassengerEntityToDto(T from);

    List<V> mapList(List<T> from);
}
