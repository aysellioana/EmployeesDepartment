package departments.employees.services.jpa;

import departments.employees.domain.Department;
import departments.employees.repositories.jpa.DepartmentRepositoryJPA;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Iterator;
import java.util.Optional;

@Service
public class DepartmentServiceJPA {
    private final DepartmentRepositoryJPA departmentRepositoryJPA;

    @Autowired
    public DepartmentServiceJPA(DepartmentRepositoryJPA departmentRepositoryJPA) {
        this.departmentRepositoryJPA = departmentRepositoryJPA;
    }

    public Department createDepartment(Department department) {
        return departmentRepositoryJPA.save(department);
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepositoryJPA.findById(id);
    }

    public Iterable<Department> getAllDepartments(){
        return departmentRepositoryJPA.findAll();
    }

    public Department updateDepartment(Long id, Department department){
        if(departmentRepositoryJPA.existsById(id)){
            department.setId(id);
            return departmentRepositoryJPA.save(department);
        }
        return null;
    }

    public void deleteDepartment(Long id){
        departmentRepositoryJPA.deleteById(id);
    }

}
