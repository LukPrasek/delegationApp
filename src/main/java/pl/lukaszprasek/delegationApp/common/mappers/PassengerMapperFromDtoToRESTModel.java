package pl.lukaszprasek.delegationApp.common.mappers;

import java.util.List;

public interface PassengerMapperFromDtoToRESTModel<T, V> {
    V mapToRestModel(T from);

    List<V> mapListToRest(List<T> from);
}
