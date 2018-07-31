package pl.lukaszprasek.delegationApp.common.requestMapper;

import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.rest.request.CreateEmployeeRequest;

public interface RequestEmployeeToDtoMapper {
    EmployeeDto mapCreateRequestToDTO (CreateEmployeeRequest createEmployeeRequest);
}
