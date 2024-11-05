package departments.employees.domain;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskName;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)  // This assumes you want to link tasks to roles
    private Role role;  // Reference to the Role entity

    @ManyToOne  // Add this to link each task to an employee
    @JoinColumn(name = "employee_id", nullable = false)  // Foreign key in the tasks table
    private Employee employee;  // Reference to the Employee entity

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false) // Add this line to reference the Project
    private Project project; // Reference to the Project entity

    public Task() {
    }

    public Task(Long id, String taskName, Role role, Employee employee) {
        this.id = id;
        this.taskName = taskName;
        this.role = role;
        this.employee = employee;  // Set the employee reference
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;  // Add getter for employee
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;  // Add setter for employee
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", role=" + role +
                ", employee=" + employee +  // Include employee in the toString
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
