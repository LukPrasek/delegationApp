package pl.lukaszprasek.delegationApp.rest.apiControllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszprasek.delegationApp.application.CarManager;
import pl.lukaszprasek.delegationApp.common.mapper.CarMapper;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;
import pl.lukaszprasek.delegationApp.domain.repositories.PassengerRepository;
import pl.lukaszprasek.delegationApp.rest.response.CarRestModel;

import java.util.List;

@RestController
@RequestMapping("/rest/v1")
@Api("Show all api")
public class CarController {

    private final CarManager carManager;
    private final CarMapper carMapper;


    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    public CarController(CarManager carManager, CarMapper carMapper) {
        this.carManager = carManager;
        this.carMapper = carMapper;
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

    @ApiOperation("Get all passengers")
    @GetMapping(path = "/passengers")
    public String showAllPassengers() {
        List<PassengerEntity> passengerEntities = passengerRepository.findAll();
        return passengerEntities.get(2).getCar().getModel();
    }
}
