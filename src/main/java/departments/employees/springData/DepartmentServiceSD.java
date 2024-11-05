package departments.employees.springData;

import departments.employees.domain.Department;
import departments.employees.repositories.jdbc.DepartmentRepository;
import departments.employees.repositories.springData.DepartmentRepositorySD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceSD {
    private final DepartmentRepositorySD departmentRepositorySD;

    @Autowired
    public DepartmentServiceSD(DepartmentRepositorySD departmentRepositorySD) {
        this.departmentRepositorySD = departmentRepositorySD;
    }

    public Department createDepartment(Department department){
        return departmentRepositorySD.save(department);
    }

    public Iterable<Department> getAllDepartments(){
        return departmentRepositorySD.findAll();
    }

    public Optional<Department> getDepartmentById(Long id){
        return departmentRepositorySD.findById(id);
    }

    public void deleteDepartment(Long id){
        departmentRepositorySD.deleteById(id);
    }
}
