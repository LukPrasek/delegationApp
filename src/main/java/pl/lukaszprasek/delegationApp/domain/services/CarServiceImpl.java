package pl.lukaszprasek.delegationApp.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;
import pl.lukaszprasek.delegationApp.domain.entities.builder.CarEntityBuilder;
import pl.lukaszprasek.delegationApp.domain.repositories.CarRepository;
import pl.lukaszprasek.delegationApp.domain.repositories.EmployeeRepository;
import pl.lukaszprasek.delegationApp.domain.repositories.PassengerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final EmployeeRepository employeeRepository;
    private final PassengerRepository passengerRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, EmployeeRepository employeeRepository, PassengerRepository passengerRepository) {
        this.carRepository = carRepository;
        this.employeeRepository = employeeRepository;
        this.passengerRepository = passengerRepository;
    }

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream()
                .map(carEntity -> new CarDto.Builder()
                        .withCarId(carEntity.getCarId())
                        .withBrand(carEntity.getBrand())
                        .withModel(carEntity.getModel())
                        .withSeatsNumber(carEntity.getSeatsNumber())
                        //.withOwner((carEntity.getOwner() == null) ? "No owner" : carEntity.getOwner().showNameSurnameAndPosition())
//                        .withPassengers(carEntity.getPassengerEntities().stream()
//                                .map(passengerEntity -> passengerEntity.showPassengerData())
//                                .collect(Collectors.joining(",")))
                        .withPassengers( carEntity.getPassengerEntities().stream().findAny().get())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public CarDto getCarById(Long id) {
        CarEntity carEntity = carRepository.getOne(id);
        System.out.println("***************************************************"
                + carEntity.getPassengerEntities().size());
        return new CarDto.Builder()
                .withCarId(carEntity.getCarId())
                .withBrand(carEntity.getBrand())
                .withModel(carEntity.getModel())
                .withSeatsNumber(carEntity.getSeatsNumber())
                .withOwner(carEntity.getOwner())
                .withPassengers(carEntity.getPassengerEntities().stream().findAny().get())
                .build();
//                .withOwner((carEntity.getOwner() == null) ? "No owner" : carEntity.getOwner().showNameSurnameAndPosition())
//                .withPassengers(carEntity.getPassengerEntities()==null?"No passengers":carEntity.getPassengerEntities().stream()
//                        .map(passengerEntity -> passengerEntity.showPassengerData())
//                        .collect(Collectors.joining(";"))).build();
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        CarEntity carEntity = new CarEntityBuilder(carDto.getBrand(), carDto.getModel(), carDto.getSeatsNumber()).build();
        carRepository.save(carEntity);
        return new CarDto.Builder()
                .withCarId(carEntity.getCarId())
                .withBrand(carEntity.getBrand())
                .withModel(carEntity.getModel())
                .withSeatsNumber(carEntity.getSeatsNumber()).build();
    }

    @Override
    public boolean deleteCarById(Long id) {
        CarEntity carEntity = carRepository.getOne(id);

        if (carEntity == null) {
            return false;
        } else {
            carRepository.deleteById(id);
            return true;
        }
    }


    @Override
    public CarDto addPassengerToSelectedCar(long carId, long empId) {
        CarEntity carEntity = carRepository.getOne(carId);
        EmployeeEntity employeeEntity = employeeRepository.getOne(empId);
        if (((carEntity.getSeatsNumber() - 1) - carEntity.getPassengerEntities().size()) > 0) {
            PassengerEntity passengerEntity = new PassengerEntity();
            passengerEntity.setCar(carEntity);
            passengerEntity.setEmployeeEntity(employeeEntity);
            passengerRepository.save(passengerEntity);
            //return getCarById(carId);
            return new CarDto.Builder()
                    .withCarId(carEntity.getCarId())
                    .withBrand(carEntity.getBrand())
                    .withModel(carEntity.getModel())
                    .withSeatsNumber(carEntity.getSeatsNumber())
//                    .withOwner(carEntity.getOwner().showNameSurnameAndPosition())
//                    .withPassengers(carEntity.getPassengerEntities().stream()
//                            .map(passengerEnt -> passengerEnt.showPassengerData())
//                            .collect(Collectors.joining(",")))
                    .build();
        } else {
            return getCarById(carId);//todo
        }

    }

    @Override
    public CarDto removePassengerFromSelectedCar(long carId, long empId) {
        return null;
    }


}

