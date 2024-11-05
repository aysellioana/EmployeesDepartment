package departments.employees.repositories.jdbc;

import departments.employees.domain.Employee;

import java.util.List;

public interface EmployeeRepository{
    List<Employee> findAll();
    Employee findById(Long id);
    void save(Employee employee);
    void update(Employee employee);
    void deleteById(Long id);
    List<Employee> findByName(String name);
    List<Employee> findByEmail(String email);
}
