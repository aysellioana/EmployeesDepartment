package departments.employees.repositories.jdbc;

import departments.employees.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProjectRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Project> findAll() {
        String sql = "SELECT * FROM projects";
        return jdbcTemplate.query(sql, this::mapRowToProject);
    }

    @Override
    public Project findById(Long id) {
        String sql = "SELECT * FROM projects WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, this::mapRowToProject);
    }

    @Override
    public void save(Project project) {
        String sql = "INSERT INTO projects (project_name) VALUES (?)";
        jdbcTemplate.update(sql, project.getProjectName());
    }

    @Override
    public void update(Project project) {
        String sql = "UPDATE projects SET project_name = ? WHERE id = ?";
        jdbcTemplate.update(sql, project.getProjectName(), project.getId());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM projects WHERE id = ?";
        jdbcTemplate.update(sql, id);

    }

    private Project mapRowToProject(ResultSet rs, int rowNum) throws SQLException {
        return new Project(
                rs.getLong("id"),
                rs.getString("project_name"),
                null, // Employees
                null  // Tasks
        );
    }
}
