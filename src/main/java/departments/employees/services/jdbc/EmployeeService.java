package departments.employees.services.jdbc;

import departments.employees.domain.Employee;
import departments.employees.repositories.jdbc.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
       return employeeRepository.findById(id);
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee){
        employeeRepository.update(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    public List<Employee> findEmployeesByName(String name){
        return employeeRepository.findByName(name);
    }

    public List<Employee> findEmployeesByEmail(String email){
        return employeeRepository.findByEmail(email);
    }


}
