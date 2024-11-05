package departments.employees.repositories.jdbc;

import departments.employees.domain.Department;

import java.util.List;

public interface DepartmentRepository {
    List<Department> findAll();
    Department findById(Long id);
    void save(Department department);
    void update(Department department);
    void deleteById(Long id);
}
