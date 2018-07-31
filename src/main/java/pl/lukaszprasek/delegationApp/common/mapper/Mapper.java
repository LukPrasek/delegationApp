package pl.lukaszprasek.delegationApp.common.mapper;

public interface Mapper <F, T> {
    T map (F from);
}
