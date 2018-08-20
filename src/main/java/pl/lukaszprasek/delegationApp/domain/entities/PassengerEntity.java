package pl.lukaszprasek.delegationApp.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class PassengerEntity {

    @Id
    @GeneratedValue
    private Long passengerId;
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="carId" )
    private CarEntity car;

    @OneToOne (mappedBy = "empId")
    @JoinColumn(name ="empId" )
    private EmployeeEntity employeeEntity;

}
