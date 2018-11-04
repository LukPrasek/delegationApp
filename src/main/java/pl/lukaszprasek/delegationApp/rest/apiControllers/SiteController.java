package pl.lukaszprasek.delegationApp.rest.apiControllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszprasek.delegationApp.application.SiteManager;
import pl.lukaszprasek.delegationApp.common.mappers.SiteMapper;
import pl.lukaszprasek.delegationApp.common.mappers.SiteMapperFromDtoToRestModel;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.services.SiteService;
import pl.lukaszprasek.delegationApp.rest.response.SiteRestModel;

import java.util.List;

@RestController
@RequestMapping("/rest/v1")
@Api("Show all api")
public class SiteController {
    private final SiteService siteService;
    private final SiteManager siteManager;
    private final SiteMapper siteMapper;
    private final SiteMapperFromDtoToRestModel siteMapperFromDtoToRestModel;

    @Autowired
    public SiteController(SiteService siteService, SiteManager siteManager, SiteMapper siteMapper, SiteMapperFromDtoToRestModel siteMapperFromDtoToRestModel) {
        this.siteService = siteService;
        this.siteManager = siteManager;
        this.siteMapper = siteMapper;
        this.siteMapperFromDtoToRestModel = siteMapperFromDtoToRestModel;
    }

    @GetMapping(path = "/sites", produces = "application/json")
    @ApiOperation("Show all sites")
    public List<SiteRestModel> showAllSites() {
        return siteMapperFromDtoToRestModel.mapListToRest(siteManager.getAllSites());
    }

    @GetMapping(path = "/site/{id}", produces = "application/json")
    @ApiOperation("Get single site")
    public SiteRestModel getSiteById(long id) {
        return (SiteRestModel) siteMapperFromDtoToRestModel.mapToRest(siteManager.getSiteById(id));
    }

    @GetMapping(path = "/site/{id}", produces = "application/json")
    @ApiOperation("Show all employees at site")
    public List<EmployeeEntity> showAllEmployeesForGivenSiteId(@PathVariable("id") long id) {
        return null;
    }
}
