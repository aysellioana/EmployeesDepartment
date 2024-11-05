package departments.employees.repositories.springData;

import departments.employees.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepositorySD  extends CrudRepository<Project, Long> {

}
