package pl.lukaszprasek.delegationApp.common.mappers;

import java.util.List;

public interface PassengerMapperFromEntityToDto<T, V> {
    V mapPassengerEntityToDto(T from);

    List<V> mapList(List<T> from);
}
