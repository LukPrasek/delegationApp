package pl.lukaszprasek.delegationApp.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.domain.repositories.EmployeeRepository;

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
        return employeeRepository.findAll().stream().map(employeeEntity -> EmployeeDto.builder()
                .withEmpId(employeeEntity.getEmpId())
                .withName(employeeEntity.getName()).withSurname(employeeEntity.getSurname())
                .withBirthday(employeeEntity.getBirthday().toString())
                .withStartWorkingDay(employeeEntity.getStartWorkingDate().toString()).build()).collect(Collectors.toList());

    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return null;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return null;
    }
}