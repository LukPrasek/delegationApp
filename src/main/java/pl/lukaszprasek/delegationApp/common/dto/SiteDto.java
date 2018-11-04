package pl.lukaszprasek.delegationApp.common.dto;

import java.io.Serializable;
import java.util.List;

public class SiteDto implements Serializable {

    private long siteId;
    private String name;
    private String address;
    private List<Long> employees;

    private SiteDto(Builder builder) {
        if (builder == null)
            return;
        this.siteId = builder.siteId;
    }

    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Long> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Long> employees) {
        this.employees = employees;
    }

    public static class Builder {
        private long siteId;
        private String name;
        private String address;
        private List<Long> employees;

        public Builder withSiteId(Long siteId) {
            this.siteId = siteId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withEmployees(List<Long> employees) {
            this.employees = employees;
            return this;
        }

        public SiteDto build() {
            return new SiteDto(this);
        }
    }
}
