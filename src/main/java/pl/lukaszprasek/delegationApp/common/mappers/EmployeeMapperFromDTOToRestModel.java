package pl.lukaszprasek.delegationApp.common.mappers;

import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.domain.services.CarService;
import pl.lukaszprasek.delegationApp.rest.response.EmployeeRestModel;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapperFromDTOToRestModel implements EmployeeMapper<EmployeeDto, EmployeeRestModel> {

//    private final CarService carService;
//    private final CarMapperFromDtoToRESTModel carMapperFromDtoToRESTModel;
//
//    public EmployeeMapperFromDTOToRestModel(CarService carService, CarMapperFromDtoToRESTModel carMapperFromDtoToRESTModel) {
//        this.carService = carService;
//        this.carMapperFromDtoToRESTModel = carMapperFromDtoToRESTModel;
//    }

    @Override
    public EmployeeRestModel map(EmployeeDto from) {
        EmployeeRestModel employeeRestModel = new EmployeeRestModel();
        employeeRestModel.setEmpId(from.getEmpId());
        employeeRestModel.setName(from.getName());
        employeeRestModel.setSurname(from.getSurname());
        employeeRestModel.setBirthday(from.getBirthday());
        employeeRestModel.setStartWorkingDate(from.getStartWorkingDate());
        employeeRestModel.setPosition(from.getEmployeePosition());
        //employeeRestModel.setCar(carMapperFromDtoToRESTModel.map(carService.getCarById(from.getCarId())));
        employeeRestModel.setCar(from.getCarId());
        System.out.println("Maper_pojedynczy z klasy Employee ale dla car**************************");//+carService.getCarById(from.getCarId();
        return employeeRestModel;
    }

    @Override
    public List<EmployeeRestModel> mapList(List<EmployeeDto> fromList) {
        System.out.println("Mappowanie listy");

        return fromList.stream().map(this::map).collect(Collectors.toList());
    }


}
