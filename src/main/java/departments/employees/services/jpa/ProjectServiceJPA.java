package departments.employees.services.jpa;

import departments.employees.domain.Project;
import departments.employees.repositories.jpa.ProjectRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceJPA {
    private final ProjectRepositoryJPA projectRepositoryJPA;

    @Autowired
    public ProjectServiceJPA(ProjectRepositoryJPA projectRepositoryJPA) {
        this.projectRepositoryJPA = projectRepositoryJPA;
    }

    public Project createProject(Project project){
        return projectRepositoryJPA.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepositoryJPA.findAll();
    }

    public Project getProjectById(Long id){
        return projectRepositoryJPA.findById(id).orElse(null);
    }

    public void updateProject(Project project){
        projectRepositoryJPA.save(project);
    }

    public void deleteProject(Long id){
        projectRepositoryJPA.deleteById(id);
    }
}
