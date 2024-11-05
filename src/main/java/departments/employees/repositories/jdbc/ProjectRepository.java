package departments.employees.repositories.jdbc;

import departments.employees.domain.Project;

import java.util.List;

public interface ProjectRepository {
    List<Project> findAll();
    Project findById(Long id);
    void save(Project project);
    void update(Project project);
    void deleteById(Long id);
}
