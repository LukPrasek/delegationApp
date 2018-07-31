package pl.lukaszprasek.delegationApp.common.requestMapper;

import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.rest.request.CreateEmployeeRequest;

import java.time.LocalDate;

@Component
public class RequestEmployeeToDtoMapperImpl implements RequestEmployeeToDtoMapper {
    @Override
    public EmployeeDto mapCreateRequestToDTO(CreateEmployeeRequest createEmployeeRequest) {
        LocalDate birthday = LocalDate.parse(createEmployeeRequest.getBirthday());

        LocalDate startWorkingDate = LocalDate.parse(createEmployeeRequest.getStartWorkingDate());
        return new EmployeeDto.Builder()
                .withName(createEmployeeRequest.getName())
                .withSurname(createEmployeeRequest.getSurname())
                .withBirthday(birthday)
                .withStartWorkingDay(startWorkingDate).build();
    }
}
