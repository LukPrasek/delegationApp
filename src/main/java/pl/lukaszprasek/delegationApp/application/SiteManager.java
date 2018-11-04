package pl.lukaszprasek.delegationApp.application;

import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.common.dto.SiteDto;

import java.util.List;

public interface SiteManager {
    List<SiteDto> getAllSites();

    SiteDto getSiteById(Long id);

    List<EmployeeDto> showAllEmployeesForGivenSiteId(Long id);

    SiteDto createSite(SiteDto siteDto);

    Long deleteSiteById(long id);
}
