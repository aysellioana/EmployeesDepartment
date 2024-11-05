package departments.employees;

import departments.employees.domain.Department;
import departments.employees.domain.Employee;
import departments.employees.domain.Project;
import departments.employees.services.jpa.DepartmentServiceJPA;
import departments.employees.services.jpa.EmployeeServiceJPA;
import departments.employees.services.jpa.ProjectServiceJPA;
import departments.employees.springData.DepartmentServiceSD;
import departments.employees.springData.EmployeeServiceSD;
import departments.employees.springData.ProjectServiceSD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication
public class EmployeesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeesApplication.class, args);

//		System.out.println("JDBC");
//		System.out.println();
//
//		EmployeeService employeeService = context.getBean(EmployeeService.class);
//		DepartmentService departmentService = context.getBean(DepartmentService.class);
//		ProjectService projectService = context.getBean(ProjectService.class);
//
//		Department newDepartment = new Department(null, "IT", null);
//		departmentService.saveDepartment(newDepartment);
//
//		List<Department> departments = departmentService.getAllDepartments();
//		System.out.println("Departments: " + departments);
//
//		Employee newEmployee = new Employee(null, "John Doe", "john.doe@example.com", newDepartment, null, null, null);
//		employeeService.saveEmployee(newEmployee);
//
//		List<Employee> employees = employeeService.getAllEmployees();
//		System.out.println("Employees: " + employees);
//
//		Employee employee = employeeService.getEmployeeById(1L);
//		System.out.println("Employee with ID 1: " + employee);
//
//		if (employee != null) {
//			employee.setName("John Smith");
//			employeeService.updateEmployee(employee);
//			System.out.println("Updated Employee: " + employeeService.getEmployeeById(1L));
//		}
//
//		Project newProject = new Project(null, "New Project", List.of(newEmployee), null);
//		projectService.saveProject(newProject);
//		System.out.println("Project created: " + newProject);
//
//		List<Project> projects = projectService.getAllProjects();
//		System.out.println("Projects: " + projects);
//
//
//		System.out.println();
//		System.out.println("JPA.. Hibernate");
//		EmployeeServiceJPA employeeService = context.getBean(EmployeeServiceJPA.class);
//		DepartmentServiceJPA departmentService = context.getBean(DepartmentServiceJPA.class);
//		ProjectServiceJPA projectService = context.getBean(ProjectServiceJPA.class);
//
//
//		Department newDepartment = new Department(null, "IT", null);
//		departmentService.createDepartment(newDepartment);
//		System.out.println("Department created: " + newDepartment);
//
//		Project newProject = new Project(null, "Website Development", null, null);
//		projectService.createProject(newProject);
//		System.out.println("Project created: " + newProject);
//
//		Employee newEmployee = new Employee(null, "John Doe", "john.doe@example.com", null, null, null, null);
//		newEmployee.setDepartment(newDepartment);
//
//		newEmployee.getProjects().add(newProject);
//		employeeService.saveEmployee(newEmployee);
//		System.out.println("Employee created: " + newEmployee);
//
//		List<Employee> employees = employeeService.getAllEmployees();
//		System.out.println("All Employees: " + employees);
//
//
//		employeeService.getEmployeeById(1L).ifPresent(employee -> {
//			System.out.println("Employee with ID 1: " + employee);
//
//			employee.setName("John Smith");
//			employeeService.updateEmployee(employee);
//			System.out.println("Updated Employee: " + employeeService.getEmployeeById(1L).orElse(null));
//		});


		System.out.println("Spring Data");

		DepartmentServiceSD departmentService = context.getBean(DepartmentServiceSD.class);
		EmployeeServiceSD employeeService = context.getBean(EmployeeServiceSD.class);
		ProjectServiceSD projectService = context.getBean(ProjectServiceSD.class);

		Department newDepartment = new Department();
		newDepartment.setName("IT");
		Department savedDepartment = departmentService.createDepartment(newDepartment);
		System.out.println("Department created: " + savedDepartment);

		Project newProject = new Project();
		newProject.setProjectName("Website Development");
		Project savedProject = projectService.createProject(newProject);
		System.out.println("Project created: " + savedProject);

		Employee newEmployee = new Employee();
		newEmployee.setName("John Doe");
		newEmployee.setEmail("john.doe@example.com");
		newEmployee.setDepartment(savedDepartment);
		newEmployee.getProjects().add(savedProject);
		Employee savedEmployee = employeeService.createEmployee(newEmployee);
		System.out.println("Employee created: " + savedEmployee);

		System.out.println("All departments:");
		departmentService.getAllDepartments().forEach(System.out::println);

		System.out.println("All projects:");
		projectService.getAllProjects().forEach(System.out::println);

		System.out.println("All employees:");
		employeeService.getAllEmployees().forEach(System.out::println);

	}
}
