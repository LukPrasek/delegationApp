package pl.lukaszprasek.delegationApp.common.mappers;

import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.SiteDto;
import pl.lukaszprasek.delegationApp.rest.response.SiteRestModel;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class SiteMapperFromDtoToRestModelImpl implements SiteMapperFromDtoToRestModel<SiteRestModel, SiteDto> {

    @Override
    public SiteRestModel mapToRest(SiteDto from) {
        SiteRestModel siteRestModel = new SiteRestModel();
        siteRestModel.setSiteId(from.getSiteId());
        siteRestModel.setName(from.getName());
        siteRestModel.setAddress(from.getAddress());
        siteRestModel.setEmployees(from.getEmployees());
        return siteRestModel;
    }

    @Override
    public List<SiteRestModel> mapListToRest(List<SiteDto> from) {
        return from.stream().map(this::mapToRest).collect(Collectors.toList());
    }
}
