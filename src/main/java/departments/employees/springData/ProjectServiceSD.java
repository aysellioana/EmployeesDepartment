package departments.employees.springData;

import departments.employees.domain.Project;
import departments.employees.repositories.springData.ProjectRepositorySD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceSD {
    private final ProjectRepositorySD projectRepositorySD;

    @Autowired
    public ProjectServiceSD(ProjectRepositorySD projectRepositorySD) {
        this.projectRepositorySD = projectRepositorySD;
    }

    public Project createProject(Project project) {
        return projectRepositorySD.save(project);
    }

    public Iterable<Project> getAllProjects() {
        return projectRepositorySD.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepositorySD.findById(id);
    }

    public void deleteProject(Long id) {
        projectRepositorySD.deleteById(id);
    }
}

