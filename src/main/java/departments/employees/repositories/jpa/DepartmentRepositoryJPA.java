package departments.employees.repositories.jpa;

import departments.employees.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepositoryJPA  extends JpaRepository<Department, Long> {

}
