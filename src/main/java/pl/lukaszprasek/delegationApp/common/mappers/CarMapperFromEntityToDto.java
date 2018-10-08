package pl.lukaszprasek.delegationApp.common.mappers;

public interface CarMapperFromEntityToDto <F, T> {
    T mapToDto(F from);
}
