package pl.lukaszprasek.delegationApp.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "site")
public class SiteEntity {
    @Id
    @Column(name = "id")
    private long siteId;
    private String name;
    private String address;
    @OneToMany(mappedBy = "siteEntity", cascade = CascadeType.MERGE)
    private List<EmployeeEntity> employeeEntities;

    public SiteEntity() {
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

    public List<EmployeeEntity> getEmployeeEntities() {
        return employeeEntities;
    }

    public void setEmployeeEntities(List<EmployeeEntity> employeeEntities) {
        this.employeeEntities = employeeEntities;
    }
}
