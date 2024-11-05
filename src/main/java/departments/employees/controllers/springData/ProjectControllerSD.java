package departments.employees.controllers.springData;

import departments.employees.domain.Project;
import departments.employees.springData.ProjectServiceSD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/projects")
@Profile("spring-data")
public class ProjectControllerSD {
    private final ProjectServiceSD projectServiceSD;

    @Autowired
    public ProjectControllerSD(ProjectServiceSD projectServiceSD) {
        this.projectServiceSD = projectServiceSD;
    }

    @GetMapping
    public Project createProject(@RequestBody Project project){
        return projectServiceSD.createProject(project);
    }

    @GetMapping
    public Iterable<Project> getAllProjects(){
        return projectServiceSD.getAllProjects();
    }

    @GetMapping("/{id}")
    public Optional<Project> getProjectById(@PathVariable Long id) {
        return projectServiceSD.getProjectById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectServiceSD.deleteProject(id);
    }
}
