package departments.employees.repositories.jpa;

import departments.employees.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepositoryJPA extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
    List<Employee> findByemail(String email);
}
