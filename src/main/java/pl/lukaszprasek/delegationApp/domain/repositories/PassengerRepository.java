package pl.lukaszprasek.delegationApp.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {
}
