package departments.employees.controllers.jpa;

import departments.employees.domain.Department;
import departments.employees.services.jpa.DepartmentServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/departments")
@Profile("jpa")
public class DepartmentControllerJPA {
    private final DepartmentServiceJPA departmentServiceJPA;

    @Autowired
    public DepartmentControllerJPA(DepartmentServiceJPA departmentServiceJPA) {
        this.departmentServiceJPA = departmentServiceJPA;
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department createdDepartment = departmentServiceJPA.createDepartment(department);
        return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = departmentServiceJPA.getDepartmentById(id);
        return department.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentServiceJPA.getAllDepartments());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        Department updatedDepartment = departmentServiceJPA.updateDepartment(id, department);
        return updatedDepartment != null ? ResponseEntity.ok(updatedDepartment) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentServiceJPA.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
