package pl.lukaszprasek.delegationApp.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.common.dto.SiteDto;
import pl.lukaszprasek.delegationApp.domain.builder.SiteEntityBuilder;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.entities.SiteEntity;
import pl.lukaszprasek.delegationApp.domain.repositories.EmployeeRepository;
import pl.lukaszprasek.delegationApp.domain.repositories.SiteRepository;
import pl.lukaszprasek.delegationApp.rest.response.SiteRestModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiteServiceImpl implements SiteService {

    private final SiteRepository siteRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public SiteServiceImpl(SiteRepository siteRepository, EmployeeRepository employeeRepository) {
        this.siteRepository = siteRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<SiteDto> showAllSites() {
        return siteRepository.findAll().stream().map(siteEntity ->
                new SiteDto.Builder()
                        .withSiteId(siteEntity.getSiteId())
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
                        .withSiteDto(employeeEntity.getSiteEntity() == null ? 0 : employeeEntity.getSiteEntity().getSiteId())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public SiteDto createSite(SiteDto siteDto) {
        SiteEntity siteEntity = new SiteEntityBuilder(siteDto.getName(), siteDto.getAddress()).build();
        siteRepository.save(siteEntity);
        return new SiteDto.Builder()
                .withSiteId(siteEntity.getSiteId())
                .withName(siteEntity.getName())
                .withAddress(siteEntity.getAddress()).build();
    }

    @Override
    public SiteDto assignEmployeeToSite(Long empId, Long siteId) {
        EmployeeEntity employeeEntity = employeeRepository.getOne(empId);
        if (employeeEntity.getSiteEntity() == null) {
            SiteEntity siteEntity = siteRepository.getOne(siteId);
            employeeEntity.setSiteEntity(siteEntity);
            employeeRepository.save(employeeEntity);
            return new SiteDto.Builder().withName(siteEntity.getName())
                    .withAddress(siteEntity.getAddress())
                    .withSiteId(siteEntity.getSiteId())
                    .withEmployees(siteEntity.getEmployeeEntities().stream()
                            .map(employeeEntity1 -> employeeEntity1.getEmpId()).collect(Collectors.toList())).build();
        } else {
            return null;
        }
    }

    @Override
    public SiteDto removeEmployeeFromSite(Long empId, Long siteId) {
        SiteEntity siteEntity = siteRepository.getOne(siteId);
        EmployeeEntity employeeEntity = employeeRepository.getOne(empId);
        if (employeeEntity.getSiteEntity() != null) {
            employeeEntity.setSiteEntity(null);
            employeeRepository.save(employeeEntity);
        }
        return new SiteDto.Builder().withName(siteEntity.getName())
                .withAddress(siteEntity.getAddress())
                .withSiteId(siteEntity.getSiteId())
                .withEmployees(siteEntity.getEmployeeEntities().stream()
                        .map(employeeEntity1 -> employeeEntity1.getEmpId()).collect(Collectors.toList())).build();
    }
}