package pl.lukaszprasek.delegationApp.common.mappers;

import java.util.List;

public interface EmployeeMapper<F, T> {
    T map (F from);
    List<T> mapList(List<F> from);
}
