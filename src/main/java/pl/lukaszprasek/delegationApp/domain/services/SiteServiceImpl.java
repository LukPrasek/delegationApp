package pl.lukaszprasek.delegationApp.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.common.dto.SiteDto;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.entities.SiteEntity;
import pl.lukaszprasek.delegationApp.domain.repositories.SiteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiteServiceImpl implements SiteService {

    private final SiteRepository siteRepository;


    @Autowired
    public SiteServiceImpl(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;

    }

    @Override
    public List<SiteDto> showAllSites() {
        return siteRepository.findAll().stream().map(siteEntity ->
                new SiteDto.Builder().withSiteId(siteEntity.getSiteId())
                        .withName(siteEntity.getName())
                        .withAddress(siteEntity.getAddress())
                        .withEmployees(siteEntity.getEmployeeEntities().stream()
                                .map(employeeEntity -> employeeEntity.getEmpId()).collect(Collectors.toList())).build()).collect(Collectors.toList());
    }

    @Override
    public SiteDto getSiteById(long id) {
        SiteEntity siteEntity = siteRepository.getOne(id);
        return new SiteDto.Builder()
                .withSiteId(siteEntity.getSiteId())
                .withAddress(siteEntity.getAddress())
                .withName(siteEntity.getAddress())
                .withEmployees(siteEntity.getEmployeeEntities().stream()
                        .map(employeeEntity -> employeeEntity.getEmpId()).collect(Collectors.toList()))
                .build();
    }

    @Override
    public List<EmployeeDto> showAllEmployeesForGivenSiteId(long id) {
        List<EmployeeEntity> employeeEntities = siteRepository.findEmployeeEntityInGivenSite(id);
        return employeeEntities.stream()
                .map(employeeEntity -> new EmployeeDto.Builder().withEmpId(employeeEntity.getEmpId())
                        .withName(employeeEntity.getName())
                        .withSurname(employeeEntity.getSurname()).withEmployeePosition(employeeEntity.getEmployeePosition().toString())
                        .withStartWorkingDay(employeeEntity.getStartWorkingDate()).withBirthday(employeeEntity.getBirthday())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public SiteDto createSite(SiteDto siteDto) {
        return null;
    }

    @Override
    public Long deleteSiteById(long id) {
        return null;
    }
}
