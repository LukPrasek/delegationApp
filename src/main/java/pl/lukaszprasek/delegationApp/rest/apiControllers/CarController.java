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
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;
import pl.lukaszprasek.delegationApp.domain.repositories.CarRepository;
import pl.lukaszprasek.delegationApp.domain.repositories.PassengerRepository;
import pl.lukaszprasek.delegationApp.rest.request.CreateCarRequest;
import pl.lukaszprasek.delegationApp.rest.response.CarRestModel;

import javax.validation.Valid;
import java.util.List;

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
    private CarRepository carRepository;

    @Autowired
    public CarController(CarManager carManager, CarMapper carMapper, RequestCarToDtoMapper requestCarToDtoMapper) {
        this.carManager = carManager;
        this.carMapper = carMapper;
        this.requestCarToDtoMapper = requestCarToDtoMapper;
    }

    @ApiOperation("Get all cars")
    @GetMapping(path = "/cars")
//    public List<CarRestModel> showAllCars() {
//                return carMapper.mapList(carManager.getAllCars());
    public String showAllCars() {
        return carRepository.findAll().get(2).getPassengerEntities().get(1).toString();
//                .getPassengerEntities().get(1)
//                .showPassengerData();
//        List<CarEntity> lista=carRepository.findAll();
//        for (CarEntity carEntity : lista) {
//            System.out.println(carEntity.toString());
//        }
//        return carRepository.findAll();
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

    @ApiOperation("Get all passengers")
    @GetMapping(path = "/passengers")
    public List<PassengerEntity> showAllPassengers() {
        return passengerRepository.findAll();//.get(1).getCar().showBasicCarData();
    }

    @ApiOperation("Get one passenger")
    @PutMapping(path = "/car/{carId}/passenger/{empId}")
    public CarRestModel showOnePassenger(@PathVariable("carId") long carId, @PathVariable("empId") long empId) {
        return (CarRestModel) carMapper.map(carManager.addPassengerToSelectedCar(carId, empId));
    }

//        CarEntity carEntity=carRepository.getOne(carId);
//        List<PassengerEntity> passengerEntities = passengerRepository.find(carEntity);
//        return passengerEntities.stream()
//                .map(passengerEntity -> passengerEntity == null ? "No passengers" : passengerEntity.showPassengerData())
//                .collect(Collectors.joining());
//    }

}
