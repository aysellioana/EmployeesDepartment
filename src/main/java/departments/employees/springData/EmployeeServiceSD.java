package departments.employees.springData;

import departments.employees.domain.Employee;
import departments.employees.repositories.springData.EmployeeRepositorySD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceSD {
    private final EmployeeRepositorySD employeeRepositorySD;

    @Autowired
    public EmployeeServiceSD(EmployeeRepositorySD employeeRepositorySD) {
        this.employeeRepositorySD = employeeRepositorySD;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepositorySD.save(employee);
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepositorySD.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return (List<Employee>) employeeRepositorySD.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepositorySD.findById(id);
    }

    public void deleteEmployee(Long id){
        employeeRepositorySD.deleteById(id);
    }
}
