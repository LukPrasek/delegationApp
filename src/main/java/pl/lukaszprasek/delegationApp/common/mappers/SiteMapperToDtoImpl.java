package pl.lukaszprasek.delegationApp.common.mappers;

import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.SiteDto;
import pl.lukaszprasek.delegationApp.domain.entities.SiteEntity;

import java.util.stream.Collectors;
@Service
public class SiteMapperToDtoImpl implements SiteMapper<SiteEntity, SiteDto> {
    @Override
    public SiteDto mapToDto(SiteEntity from) {
        return new SiteDto.Builder()
                .withSiteId(from.getSiteId())
                .withName(from.getName())
                .withAddress(from.getAddress())
                .withEmployees(from.getEmployeeEntities().stream().map(employeeEntity -> employeeEntity.getEmpId()).collect(Collectors.toList())).build();
    }
}
