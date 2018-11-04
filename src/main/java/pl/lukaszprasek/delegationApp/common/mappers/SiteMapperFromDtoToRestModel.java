package pl.lukaszprasek.delegationApp.common.mappers;

import java.util.List;

public interface SiteMapperFromDtoToRestModel <T, F> {
     T mapToRest (F from);
    List<T> mapListToRest (List<F> from);
}
