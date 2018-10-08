package pl.lukaszprasek.delegationApp.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.common.mappers.CarMapperFromEntityToDto;
import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.entities.builder.EmployeeEntityBuilder;
import pl.lukaszprasek.delegationApp.domain.repositories.CarRepository;
import pl.lukaszprasek.delegationApp.domain.repositories.EmployeeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CarRepository carRepository;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CarRepository carRepository) {
        this.employeeRepository = employeeRepository;
        this.carRepository = carRepository;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeEntity -> new EmployeeDto.Builder()
                .withEmpId(employeeEntity.getEmpId())
                .withName(employeeEntity.getName()).withSurname(employeeEntity.getSurname())
                .withBirthday(employeeEntity.getBirthday())
                .withStartWorkingDay(employeeEntity.getStartWorkingDate())
                .withEmployeePosition(employeeEntity.getEmployeePosition().toString())
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
                //.withCarDto(employeeEntity.getCarEntity() != null ? employeeEntity.getCarEntity().getCarId() : 0)
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
                .withEmployeePosition(employeeEntity.getEmployeePosition().toString()).build();
    }

    @Override
    public Long deleteEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.getOne(id);
        employeeRepository.deleteById(id);
        return id;
    }

//    @Override
//    public EmployeeDto assignEmployeeToCar(long empId, long carId) {
//        EmployeeEntity employeeEntity = employeeRepository.getOne(empId);
//        CarEntity carEntity = carRepository.getOne(carId);
//        employeeRepository.save(employeeEntity);
//        return new EmployeeDto.Builder().withEmpId(employeeEntity.getEmpId())
//                .withName(employeeEntity.getSurname())
//                .withSurname(employeeEntity.getSurname())
//                .withBirthday(employeeEntity.getBirthday())
//                .withStartWorkingDay(employeeEntity.getStartWorkingDate())
//                .withEmployeePosition(employeeEntity.getEmployeePosition().toString())
//                .build();
//    }
//
//    @Override
//    public EmployeeDto unassignEmployeeFromCar(long empId) {
//        EmployeeEntity employeeEntity = employeeRepository.getOne(empId);
//        // employeeEntity.setCarEntity(null);
//        employeeRepository.save(employeeEntity);
//        return new EmployeeDto.Builder().withEmpId(employeeEntity.getEmpId())
//                .withName(employeeEntity.getName())
//                .withSurname(employeeEntity.getSurname())
//                .withBirthday(employeeEntity.getBirthday())
//                .withStartWorkingDay(employeeEntity.getStartWorkingDate())
//                .withEmployeePosition(employeeEntity.getEmployeePosition().toString())
//                .build();
//    }
}


