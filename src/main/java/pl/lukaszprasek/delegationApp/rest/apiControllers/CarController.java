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

    @Autowired
    public CarController(CarManager carManager, CarMapper carMapper, RequestCarToDtoMapper requestCarToDtoMapper, EmployeeMapper employeeMapper) {
        this.carManager = carManager;
        this.carMapper = carMapper;
        this.requestCarToDtoMapper = requestCarToDtoMapper;
        this.employeeMapper = employeeMapper;
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
        carManager.deleteCarById(id);
        return new ResponseEntity<>("Done, car is deleted", HttpStatus.OK);

    }

    @ApiOperation("Add passenger to selected car")
    @PutMapping(path = "/car/{carId}/employee/{empId}")
    public ResponseEntity<CarRestModel> addPassengerToSelectedCar(@PathVariable("carId") long carId, @PathVariable("empId") long empId) {
        CarDto carDto = carManager.addPassengerToSelectedCar(carId, empId);
        if (carDto != null) {
            CarRestModel carRestModel = (CarRestModel) carMapper.map(carDto);
            return new ResponseEntity<>(carRestModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);//409
        }
    }

    @ApiOperation("Remove passenger from selected car")
    @DeleteMapping(path = "/car/{carId}/employee/{empId}")
    public ResponseEntity<CarRestModel> removePassengerFromSelectedCar
            (@PathVariable("carId") long carId, @PathVariable("empId") long passengerId) {
        CarRestModel carRestModel = (CarRestModel) carMapper.map(carManager.removePassengerFromSelectedCar(carId, passengerId));
        return new ResponseEntity<>(carRestModel, HttpStatus.OK);
    }

    @ApiOperation("Show car owner")
    @GetMapping(path = "/car/owner/{carId}")
    public ResponseEntity<EmployeeRestModel> showCArOwner(@PathVariable("carId") long carId) {
        EmployeeRestModel employeeRestModel = (EmployeeRestModel) employeeMapper.map(carManager.showCarOwner(carId));
        return new ResponseEntity<>(employeeRestModel, HttpStatus.OK);
    }

    @ApiOperation("Show all passengers for one car")
    @GetMapping(path = "/car/{car_id}/passengers")
    public List<EmployeeRestModel> showPassengersForCar(@PathVariable("car_id") long carId) {
        return employeeMapper.mapList(carManager.showPassengersForCar(carId));
    }

    @ApiOperation(value = "assign employee to car")
    @PutMapping(path = "/assignCar/{carId}/employee/{empId}/")
    public ResponseEntity<CarRestModel> assignCarToEmployee(@PathVariable("empId") Long empId, @PathVariable("carId") Long carId) {
        CarDto carDto = carManager.assignEmployeeToCar(empId, carId);
        System.out.println(carDto);
        if (carDto != null) {
            CarRestModel carRestModel = (CarRestModel) carMapper.map(carDto);
            return new ResponseEntity<>(carRestModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @ApiOperation(value = "Unassign employee from car")
    @PutMapping(path = "/unassignemployee{carId}")
    public ResponseEntity<CarRestModel> unassignCarFromEmployee(@PathVariable("carId") long empId) {
        CarRestModel carRestModel = (CarRestModel) carMapper.map(carManager.unassignEmployeeFromCar(empId));
        return new ResponseEntity<>(carRestModel, HttpStatus.OK);
    }
}
