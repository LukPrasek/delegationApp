package pl.lukaszprasek.delegationApp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lukaszprasek.delegationApp.models.EmployeeEntity;
import pl.lukaszprasek.delegationApp.models.EmployeeEntity;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {
    @Override
    Optional<EmployeeEntity> findById(Integer integer);

    //List<EmployeeEntity> findAll();
}

