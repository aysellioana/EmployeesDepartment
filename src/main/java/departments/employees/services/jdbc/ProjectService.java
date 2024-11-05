package departments.employees.services.jdbc;

import departments.employees.domain.Project;
import departments.employees.repositories.jdbc.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public Project getProjetcById(Long id){
        return projectRepository.findById(id);
    }

    public void saveProject(Project project){
        projectRepository.save(project);
    }

    public void updateProject(Project project){
        projectRepository.update(project);
    }

    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }
}
