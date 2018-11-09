package pl.lukaszprasek.delegationApp.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.domain.builder.EmployeeEntityBuilder;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.repositories.EmployeeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeEntity -> new EmployeeDto.Builder()
                .withEmpId(employeeEntity.getEmpId())
                .withName(employeeEntity.getName()).withSurname(employeeEntity.getSurname())
                .withBirthday(employeeEntity.getBirthday())
                .withStartWorkingDay(employeeEntity.getStartWorkingDate())
                .withEmployeePosition(employeeEntity.getEmployeePosition().toString())
                .withSiteDto(employeeEntity.getSiteEntity()==null?0:employeeEntity.getSiteEntity().getSiteId())
                .build()).collect(Collectors.toList());

    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.getOne(id);
        return new EmployeeDto.Builder().withEmpId(employeeEntity.getEmpId())
                .withName(employeeEntity.getName()).withSurname(employeeEntity.getSurname())
                .withBirthday(employeeEntity.getBirthday())
                .withStartWorkingDay(employeeEntity.getStartWorkingDate())
                .withEmployeePosition(employeeEntity.getEmployeePosition().toString())
                .withSiteDto(employeeEntity.getSiteEntity()==null?0:employeeEntity.getSiteEntity().getSiteId())
                .build();
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        LocalDate birthday = LocalDate.parse(employeeDto.getBirthday());
        LocalDate startWorkingDate = LocalDate.parse(employeeDto.getStartWorkingDate());
        EmployeeEntity employeeEntity = new EmployeeEntityBuilder(employeeDto.getName(),
                employeeDto.getSurname(), birthday, startWorkingDate, employeeDto.getEmployeePosition()).build();
        employeeRepository.save(employeeEntity);
        return new EmployeeDto.Builder().withEmpId(employeeEntity.getEmpId())
                .withName(employeeEntity.getName())
                .withSurname(employeeEntity.getSurname())
                .withBirthday(employeeEntity.getBirthday())
                .withStartWorkingDay(employeeEntity.getStartWorkingDate())
                .withEmployeePosition(employeeEntity.getEmployeePosition().toString())
                .withSiteDto(employeeEntity.getSiteEntity()==null?0:employeeEntity.getSiteEntity().getSiteId()).build();
    }

    @Override
    public Long deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
        return id;
    }

}


