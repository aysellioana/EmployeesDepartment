package departments.employees.controllers.springData;

import departments.employees.domain.Employee;
import departments.employees.springData.EmployeeServiceSD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Profile("spring-data")
public class EmployeeControllerSD {
    private final EmployeeServiceSD employeeServiceSD;

    @Autowired
    public EmployeeControllerSD(EmployeeServiceSD employeeServiceSD) {
        this.employeeServiceSD = employeeServiceSD;

    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee createdEmployee = employeeServiceSD.saveEmployee(employee);
        return ResponseEntity.ok(createdEmployee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeServiceSD.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return employeeServiceSD.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeServiceSD.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
