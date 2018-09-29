package pl.lukaszprasek.delegationApp.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;
import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {

    @Query("SELECT p FROM PassengerEntity p where p.car = :car")
    List<PassengerEntity> findAllPassengerInGivenCar(@Param("car") CarEntity car_id);

    @Query("SELECT COUNT(p) FROM PassengerEntity p where p.car = :car")
    long countPassengersByCarId(@Param("car") CarEntity car_id);

    @Query("SELECT p.employeeEntity FROM PassengerEntity p where p.car = :car")
    List<EmployeeEntity> findPassengersInCar(@Param("car") CarEntity car_id);
}
