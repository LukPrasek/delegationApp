package pl.lukaszprasek.delegationApp.rest.apiControllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lukaszprasek.delegationApp.application.CarManager;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.mappers.CarMapper;
import pl.lukaszprasek.delegationApp.common.mappers.EmployeeMapper;
import pl.lukaszprasek.delegationApp.common.mappers.PassengerMapperFromDtoToRESTModel;
import pl.lukaszprasek.delegationApp.common.requestMapper.RequestCarToDtoMapper;
import pl.lukaszprasek.delegationApp.rest.request.CreateCarRequest;
import pl.lukaszprasek.delegationApp.rest.response.CarRestModel;
import pl.lukaszprasek.delegationApp.rest.response.EmployeeRestModel;
import pl.lukaszprasek.delegationApp.rest.response.PassengerRestModel;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/v1")
@Api("Show all api")
public class CarController {

    private final CarManager carManager;
    private final CarMapper carMapper;
    private final RequestCarToDtoMapper requestCarToDtoMapper;
    private final EmployeeMapper employeeMapper;
    private final PassengerMapperFromDtoToRESTModel passengerMapperFromDtoToRESTModel;

    @Autowired
    public CarController(CarManager carManager, CarMapper carMapper, RequestCarToDtoMapper requestCarToDtoMapper, EmployeeMapper employeeMapper, PassengerMapperFromDtoToRESTModel passengerMapperFromDtoToRESTModel) {
        this.carManager = carManager;
        this.carMapper = carMapper;
        this.requestCarToDtoMapper = requestCarToDtoMapper;
        this.employeeMapper = employeeMapper;
        this.passengerMapperFromDtoToRESTModel = passengerMapperFromDtoToRESTModel;
    }

    @ApiOperation("Get all cars")
    @GetMapping(path = "/cars")
    public List<CarRestModel> showAllCars() {
        return carMapper.mapList(carManager.getAllCars());
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
    public ResponseEntity<String> deleteCarById(@PathVariable("id") long id) {
        if (carManager.deleteCarById(id) == false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>("Done, car is deleted", HttpStatus.OK);
        }
    }

    @ApiOperation("Get all passengers for one car")
    @GetMapping(path = "/passengers/{car_id}")
//    public List<PassengerEntity> showPassengersForSelectedCar(@PathVariable("car_id") long carId) {
//        return passengerRepository.findAllPassengerInGivenCar(carRepository.getOne(carId));
    public List<PassengerRestModel> showPassengersForSelectedCar(@PathVariable("car_id") long carId) {
        return passengerMapperFromDtoToRESTModel.mapListToRest(carManager.showPassengersForSelectedCar(carId));
    }

    @ApiOperation("Add passenger to selected car")
    @PutMapping(path = "/car/{carId}/employee/{empId}")
    public ResponseEntity<CarRestModel> addPassengerToSelectedCar(@PathVariable("carId") long carId, @PathVariable("empId") long empId) {
        CarDto carDto=carManager.addPassengerToSelectedCar(carId, empId);
        if (carDto!= null){
            CarRestModel carRestModel = (CarRestModel) carMapper.map(carDto);
            return new ResponseEntity<>(carRestModel, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @ApiOperation("Remove passenger from selected car")
    @DeleteMapping(path = "/car/{carId}/passenger/{passengerId}")
    public ResponseEntity<CarRestModel> removePassengerFromSelectedCar
            (@PathVariable("carId") long carId, @PathVariable("passengerId") long passengerId) {
        carMapper.map(carManager.removePassengerFromSelectedCar(carId, passengerId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @ApiOperation("Show car owner")
    @GetMapping(path = "/car/owner/{carId}")
    public ResponseEntity<EmployeeRestModel> showCArOwner(@PathVariable("carId") long carId){
        EmployeeRestModel employeeRestModel= (EmployeeRestModel) employeeMapper.map(carManager.showCarOwner(carId));
        return new ResponseEntity<>(employeeRestModel, HttpStatus.OK);
    }
}
