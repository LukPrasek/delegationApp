package pl.lukaszprasek.delegationApp.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.entities.SiteEntity;

import java.util.List;

public interface SiteRepository extends JpaRepository<SiteEntity, Long> {

@Query("Select site.employeeEntities from SiteEntity site where site.siteId=:id")
    List<EmployeeEntity> findEmployeeEntityInGivenSite (@Param("id") long siteId);
}
//    @Query("SELECT p.employeeEntity FROM PassengerEntity p where p.car = :car")
//    List<EmployeeEntity> findPassengersInCar(@Param("car") CarEntity car_id);