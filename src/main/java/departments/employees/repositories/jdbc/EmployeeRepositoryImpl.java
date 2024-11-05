package departments.employees.repositories.jdbc;

import departments.employees.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findAll() {
        String sql="SELECT * FROM employees";
        return jdbcTemplate.query(sql, this::mapRowToEmployee);
    }

    @Override
    public Employee findById(Long id) {
        String sql= "SELECT * FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, this::mapRowToEmployee);
    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employees (name, email) VALUES (?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getEmail());
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employees SET name = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getEmail(), employee.getId());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Employee> findByName(String name) {
        String sql = "SELECT * FROM employees WHERE name LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + name + "%"}, this::mapRowToEmployee);
    }

    @Override
    public List<Employee> findByEmail(String email) {
        String sql = "SELECT * FROM employees WHERE email = ?";
        return jdbcTemplate.query(sql, new Object[]{email}, this::mapRowToEmployee);
    }

    private Employee mapRowToEmployee(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email"),
                null, // Department
                null, // Address
                null, // Projects
                null  // Tasks
        );
    }

}
