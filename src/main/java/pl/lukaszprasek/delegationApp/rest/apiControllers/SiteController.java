package pl.lukaszprasek.delegationApp.rest.apiControllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lukaszprasek.delegationApp.application.SiteManager;
import pl.lukaszprasek.delegationApp.common.dto.SiteDto;
import pl.lukaszprasek.delegationApp.common.mappers.EmployeeMapper;
import pl.lukaszprasek.delegationApp.common.mappers.SiteMapperFromDtoToRestModel;
import pl.lukaszprasek.delegationApp.common.requestMapper.RequestSiteToDtoMapper;
import pl.lukaszprasek.delegationApp.rest.request.CreateSiteRequest;
import pl.lukaszprasek.delegationApp.rest.response.EmployeeRestModel;
import pl.lukaszprasek.delegationApp.rest.response.SiteRestModel;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/v1")
@Api("Show all api")
public class SiteController {
    private final SiteManager siteManager;
    private final SiteMapperFromDtoToRestModel siteMapperFromDtoToRestModel;
    private final RequestSiteToDtoMapper requestSiteToDtoMapper;
    private final EmployeeMapper employeeMapper;


    @Autowired
    public SiteController(SiteManager siteManager, SiteMapperFromDtoToRestModel siteMapperFromDtoToRestModel, RequestSiteToDtoMapper requestSiteToDtoMapper, EmployeeMapper employeeMapper) {
        this.siteManager = siteManager;
        this.siteMapperFromDtoToRestModel = siteMapperFromDtoToRestModel;
        this.requestSiteToDtoMapper = requestSiteToDtoMapper;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping(path = "/sites", produces = "application/json")
    @ApiOperation("Show all sites")
    public List<SiteRestModel> showAllSites() {
        return siteMapperFromDtoToRestModel.mapListToRest(siteManager.getAllSites());
    }

    @GetMapping(path = "/site/{id}", produces = "application/json")
    @ApiOperation("Get single site")
    public SiteRestModel getSiteById(@PathVariable("id") long id) {
        return (SiteRestModel) siteMapperFromDtoToRestModel.mapToRest(siteManager.getSiteById(id));
    }

    @GetMapping(path = "/site/employees/{id}", produces = "application/json")
    @ApiOperation("Show all employees at site")
    public List<EmployeeRestModel> showAllEmployeesForGivenSiteId(@PathVariable("id") long id) {
        return employeeMapper.mapList(siteManager.showAllEmployeesForGivenSiteId(id));
    }

    @PostMapping(path = "site/add", produces = "application/json")
    @ApiOperation("Add new site")
    @ResponseStatus(HttpStatus.CREATED)
    public SiteRestModel createSite(@Valid @RequestBody CreateSiteRequest createSiteRequest) {
        SiteDto responseSiteDto = siteManager.createSite(requestSiteToDtoMapper.mapCreatedRequestToDTO(createSiteRequest));
        return (SiteRestModel) siteMapperFromDtoToRestModel.mapToRest(responseSiteDto);
    }
    @ApiOperation(value = "assign employee to site")
    @PutMapping(path = "/site/{siteId}/assign-employee/{empId}")
    public ResponseEntity<SiteRestModel> assignEmployeeToSite(@PathVariable("empId") Long empId, @PathVariable("siteId") Long siteId) {
        SiteRestModel siteRestModel = (SiteRestModel) siteMapperFromDtoToRestModel.mapToRest(siteManager.assignEmployeeToSite(empId, siteId));
        if (siteRestModel != null) {
            return new ResponseEntity<>(siteRestModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }
    @ApiOperation(value = "Remove employee from site")
    @PutMapping(path = "/site/{siteId}/remove-employee/{empId}")
    public ResponseEntity<SiteRestModel> removeEmployeeToSite(@PathVariable("empId") Long empId, @PathVariable("siteId") Long siteId) {
        SiteRestModel siteRestModel = (SiteRestModel) siteMapperFromDtoToRestModel.mapToRest(siteManager.removeEmployeeFromSite(empId, siteId));
        if (siteRestModel != null) {
            return new ResponseEntity<>(siteRestModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
