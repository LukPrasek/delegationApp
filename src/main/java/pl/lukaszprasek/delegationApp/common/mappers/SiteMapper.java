package pl.lukaszprasek.delegationApp.common.mappers;

public interface SiteMapper<F, T> {
    T mapToDto(F from);
}
