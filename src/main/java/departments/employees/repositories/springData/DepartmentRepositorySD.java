package departments.employees.repositories.springData;

import departments.employees.domain.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepositorySD extends CrudRepository<Department, Long> {

}
