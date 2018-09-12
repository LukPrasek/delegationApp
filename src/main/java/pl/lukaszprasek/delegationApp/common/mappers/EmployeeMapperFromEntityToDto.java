package pl.lukaszprasek.delegationApp.common.mappers;

public interface EmployeeMapperFromEntityToDto<T, V> {
    V mapEmployeeEntityToDt(T from);
}
