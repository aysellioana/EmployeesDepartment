package departments.employees.services.jdbc;

import departments.employees.domain.Department;
import departments.employees.repositories.jdbc.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    public final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id);
    }
    public void saveDepartment(Department department){
        departmentRepository.save(department);
    }

    public void updateDepartment(Department department){
        departmentRepository.update(department);
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }
}
