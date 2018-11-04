package pl.lukaszprasek.delegationApp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.common.dto.SiteDto;
import pl.lukaszprasek.delegationApp.domain.services.SiteService;

import java.util.List;

@Service
public class SiteManagerImpl implements SiteManager {
    private final SiteService siteService;

    @Autowired
    public SiteManagerImpl(SiteService siteService) {
        this.siteService = siteService;
    }

    @Override
    public List<SiteDto> getAllSites() {
        return siteService.showAllSites();
    }

    @Override
    public SiteDto getSiteById(Long id) {
        return siteService.getSiteById(id);
    }

    @Override
    public List<EmployeeDto> showAllEmployeesForGivenSiteId(Long id) {
        return siteService.showAllEmployeesForGivenSiteId(id);
    }

    @Override
    public SiteDto createSite(SiteDto siteDto) {
        return null;
    }

    @Override
    public Long deleteSiteById(long id) {
        return null;
    }
}
