package pl.lukaszprasek.delegationApp.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {

    //@Query("SELECT p.empId FROM PassengerEntity p where p.car = :car")
    //@Query(value = "SELECT * FROM passengers WHERE passenger_id = :passengerId", nativeQuery = true)
    @Query(value = "SELECT * FROM company.passengers where car_id= :car_id", nativeQuery = true)
    //public List<PassengerEntity> find(@Param("car") CarEntity car);
    List<PassengerEntity> find(@Param("car_id") long car_id);
}
