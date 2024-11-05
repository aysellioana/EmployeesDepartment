package departments.employees.repositories.jpa;

import departments.employees.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepositoryJPA extends JpaRepository<Project, Long> {

}
