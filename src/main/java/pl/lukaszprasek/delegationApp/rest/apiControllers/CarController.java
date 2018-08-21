package pl.lukaszprasek.delegationApp.rest.apiControllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;
import pl.lukaszprasek.delegationApp.domain.repositories.CarRepository;
import pl.lukaszprasek.delegationApp.domain.repositories.PassengerRepository;

import java.util.List;
@RestController
@RequestMapping("/rest/v1")
@Api("Show all api")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @ApiOperation("Get all cars")
    @GetMapping(path = "/cars")
    public String showAllCars() {
        System.out.println(carRepository.findAll().toString());
        List<CarEntity> carEntities=carRepository.findAll();
        return carEntities.get(1).getOwner().getSurname()+carEntities.get(1).getOwner().getName();
    }
    @ApiOperation("Get all passengers")
    @GetMapping(path = "/passengers")
    public String showAllPassengers() {
        System.out.println(passengerRepository.findAll().toString());
        List<PassengerEntity> passengerEntities=passengerRepository.findAll();
        return passengerEntities.get(2).getCar().getModel();
    }
}
