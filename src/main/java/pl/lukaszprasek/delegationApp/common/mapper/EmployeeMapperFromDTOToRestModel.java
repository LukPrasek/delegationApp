package pl.lukaszprasek.delegationApp.common.mapper;

import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.rest.response.EmployeeRestModel;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapperFromDTOToRestModel implements Mapper<EmployeeDto, EmployeeRestModel> {
    @Override
    public EmployeeRestModel map(EmployeeDto from) {
        EmployeeRestModel employeeRestModel = new EmployeeRestModel();
        employeeRestModel.setEmpId(from.getEmpId());
        employeeRestModel.setName(from.getName());
        employeeRestModel.setSurname(from.getSurname());
        employeeRestModel.setBirthday(from.getBirthday());
        employeeRestModel.setStartWorkingDate(from.getStartWorkingDate());
        employeeRestModel.setPosition(from.getEmployeePosition());
        employeeRestModel.setCar(from.getCarDto());
        return employeeRestModel;
    }

    @Override
    public List<EmployeeRestModel> mapList(List<EmployeeDto> fromList) {
        return fromList.stream().map(this::map).collect(Collectors.toList());
    }


}
