package departments.employees.services.jpa;

import departments.employees.domain.Employee;
import departments.employees.repositories.jpa.EmployeeRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceJPA {
    private final EmployeeRepositoryJPA employeeRepository;

    @Autowired
    public EmployeeServiceJPA(EmployeeRepositoryJPA employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    public List<Employee> findEmployeesByName(String name){
        return employeeRepository.findByName(name);
    }

    public List<Employee> findEmployeesByEmail(String email){
        return employeeRepository.findByemail(email);
    }
}
