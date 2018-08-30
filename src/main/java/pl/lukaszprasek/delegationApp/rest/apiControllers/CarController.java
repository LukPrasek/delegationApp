package pl.lukaszprasek.delegationApp.rest.apiControllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lukaszprasek.delegationApp.application.CarManager;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.mapper.CarMapper;
import pl.lukaszprasek.delegationApp.common.requestMapper.RequestCarToDtoMapper;
import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;
import pl.lukaszprasek.delegationApp.domain.repositories.PassengerRepository;
import pl.lukaszprasek.delegationApp.rest.request.CreateCarRequest;
import pl.lukaszprasek.delegationApp.rest.response.CarRestModel;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/v1")
@Api("Show all api")
public class CarController {

    private final CarManager carManager;
    private final CarMapper carMapper;
    private RequestCarToDtoMapper requestCarToDtoMapper;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    public CarController(CarManager carManager, CarMapper carMapper, RequestCarToDtoMapper requestCarToDtoMapper) {
        this.carManager = carManager;
        this.carMapper = carMapper;
        this.requestCarToDtoMapper = requestCarToDtoMapper;
    }

    @ApiOperation("Get all cars")
    @GetMapping(path = "/cars")
    public List<CarRestModel> showAllCars() {
        return carMapper.mapList(carManager.getAlCars());
    }

    @ApiOperation("Get one car")
    @GetMapping(path = "/car/{id}", produces = "application/json")
    public CarRestModel showOneCar(@PathVariable("id") long id) {
        return (CarRestModel) carMapper.map(carManager.getCarById(id));
    }


    @ApiOperation("Create new car")
    @PostMapping(path = "/add/car", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CarRestModel createNewCar(@Valid @RequestBody CreateCarRequest createCarRequest) {
        CarDto responseCarDto = carManager.createCar(requestCarToDtoMapper.mapCreatedRequestToDTO(createCarRequest));
        return (CarRestModel) carMapper.map(responseCarDto);
    }

    @ApiOperation("Get all passengers")
    @GetMapping(path = "/passengers")
    public String showAllPassengers() {
        List<PassengerEntity> passengerEntities = passengerRepository.findAll();
        return passengerEntities.stream()
                .map(passengerEntity -> passengerEntity == null ? "No passengers" : passengerEntity.showPassengerData())
                .collect(Collectors.joining());
    }

    @ApiOperation("Delete car by Id")
    @DeleteMapping(path = "/car/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CarEntity> deleteCarById(@PathVariable("id") long id) {
        if (carManager.deleteCarById(id) == false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
