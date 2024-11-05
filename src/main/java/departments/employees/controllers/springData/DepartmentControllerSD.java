package departments.employees.controllers.springData;

import departments.employees.domain.Department;
import departments.employees.springData.DepartmentServiceSD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/departments")
@Profile("spring-data")
public class DepartmentControllerSD {
    private final DepartmentServiceSD departmentServiceSD;

    @Autowired
    public DepartmentControllerSD(DepartmentServiceSD departmentServiceSD) {
        this.departmentServiceSD = departmentServiceSD;
    }


    @GetMapping
    public Department createDepartment(@RequestBody Department department){
        return departmentServiceSD.createDepartment(department);
    }

    @GetMapping("/{id}")
    public Iterable<Department> getAllDepartments(){
        return departmentServiceSD.getAllDepartments();
    }
    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable Long id) {
        return departmentServiceSD.getDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentServiceSD.deleteDepartment(id);
    }
}
