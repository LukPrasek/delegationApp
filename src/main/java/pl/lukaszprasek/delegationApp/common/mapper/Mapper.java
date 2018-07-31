package pl.lukaszprasek.delegationApp.common.mapper;

import java.util.List;

public interface Mapper <F, T> {
    T map (F from);
    List<T> mapList(List<F> from);
}
