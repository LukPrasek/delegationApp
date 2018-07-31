package pl.lukaszprasek.delegationApp.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.common.mapper.EmployeeMapper;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.entities.LocalDateAttributeConverter;
import pl.lukaszprasek.delegationApp.domain.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
private LocalDateAttributeConverter localDateAttributeConverter;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
       // localDateAttributeConverter=new LocalDateAttributeConverter();
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        System.out.println("************************Sprawdzam date"+employeeRepository.findById((long) 2).toString());
        return employeeRepository.findAll().stream().map(employeeEntity -> new EmployeeDto.Builder()
                .withEmpId(employeeEntity.getEmpId())
                .withName(employeeEntity.getName()).withSurname(employeeEntity.getSurname())
                .withBirthday(employeeEntity.getBirthday())
                .withStartWorkingDay(employeeEntity.getSwd()).build()).collect(Collectors.toList());

    }

    @Override
    public List<EmployeeEntity> getAllGuys() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.getOne(id);
        return new EmployeeDto.Builder().withEmpId(employeeEntity.getEmpId())
                .withName(employeeEntity.getName()).withSurname(employeeEntity.getSurname())
                .withBirthday(employeeEntity.getBirthday())
                .withStartWorkingDay(employeeEntity.getSwd()).build();
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return null;
    }

    public Collection<EmployeeDto> showAllEmployeesDto() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        EmployeeMapper employeeMapper = new EmployeeMapper();
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (EmployeeEntity employee : employeeEntities) {
            EmployeeDto employeeDto1 = employeeMapper.map(employee);
            employeeDtos.add(employeeDto1);


        }
        return employeeDtos;
    }
}