package departments.employees.repositories.jdbc;

import departments.employees.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DepartmentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Department> findAll() {
        String sql = "SELECT * FROM departments";
        return jdbcTemplate.query(sql, this::mapRowToDepartment);
    }

    @Override
    public Department findById(Long id) {
        String sql = "SELECT * FROM departments WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, this::mapRowToDepartment);
    }

    @Override
    public void save(Department department) {
        String sql = "INSERT INTO departments (name) VALUES (?)";
        jdbcTemplate.update(sql, department.getName());
    }

    @Override
    public void update(Department department) {
        String sql = "UPDATE departments SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, department.getName(), department.getId());

    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM departments WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private Department mapRowToDepartment(ResultSet rs, int rowNum) throws SQLException {
        return new Department(
                rs.getLong("id"),
                rs.getString("name"),
                null // Employees will not be loaded here
        );
    }
}
