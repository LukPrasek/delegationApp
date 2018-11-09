package pl.lukaszprasek.delegationApp.common.requestMapper;

import pl.lukaszprasek.delegationApp.common.dto.SiteDto;
import pl.lukaszprasek.delegationApp.rest.request.CreateSiteRequest;

public interface RequestSiteToDtoMapper {
        SiteDto mapCreatedRequestToDTO(CreateSiteRequest createSiteRequest);
    }

