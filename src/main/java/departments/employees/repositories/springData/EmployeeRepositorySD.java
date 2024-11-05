package departments.employees.repositories.springData;

import departments.employees.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepositorySD extends CrudRepository<Employee, Long> {
    List<Employee> findByName(String name);
}
