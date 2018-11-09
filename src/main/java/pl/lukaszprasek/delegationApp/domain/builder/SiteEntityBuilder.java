package pl.lukaszprasek.delegationApp.domain.builder;

import pl.lukaszprasek.delegationApp.domain.entities.SiteEntity;

public class SiteEntityBuilder implements EntityBuilder<SiteEntity> {
    private SiteEntity siteEntity;

    public SiteEntityBuilder(String name, String address) {
        siteEntity = new SiteEntity();
        siteEntity.setName(name);
        siteEntity.setAddress(address);
    }

    @Override
    public SiteEntity build() {
        return siteEntity;
    }
}
