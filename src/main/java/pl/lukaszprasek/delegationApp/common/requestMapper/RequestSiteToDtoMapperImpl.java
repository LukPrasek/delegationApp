package pl.lukaszprasek.delegationApp.common.requestMapper;

import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.SiteDto;
import pl.lukaszprasek.delegationApp.rest.request.CreateSiteRequest;
@Component
public class RequestSiteToDtoMapperImpl implements RequestSiteToDtoMapper {
    @Override
    public SiteDto mapCreatedRequestToDTO(CreateSiteRequest createSiteRequest) {
               return new SiteDto.Builder()
                .withName(createSiteRequest.getName())
                .withAddress(createSiteRequest.getAddress()).build();
    }
}
