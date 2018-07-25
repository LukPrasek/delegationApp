import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.lukaszprasek.delegationApp.domain.repositories.EmployeeRepository;


@SpringBootApplication/*(scanBasePackages = {"pl.lukaszprasek.delegationApp",
		"pl.lukaszprasek.delegationApp.domain.repositories"})*/

@ComponentScan(basePackages = "pl.lukaszprasek.delegationApp")
@EntityScan(basePackages = "pl.lukaszprasek.delegationApp.domain.entities")
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@EnableJpaRepositories("pl.lukaszprasek.delegationApp.domain.repositories")
@EnableJpaRepositories(basePackageClasses = EmployeeRepository.class)
public class DelegationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelegationAppApplication.class, args);

	}

}
