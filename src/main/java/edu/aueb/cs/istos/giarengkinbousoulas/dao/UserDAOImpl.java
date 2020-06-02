package edu.aueb.cs.istos.giarengkinbousoulas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import edu.aueb.cs.istos.giarengkinbousoulas.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDAOImpl implements UserDAO{

    private final JdbcTemplate jdbcTemplate;

    public UserDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> usersList() {

        return jdbcTemplate.query("SELECT * FROM USERS", new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();

                user.setusername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));

                return user;
            }
        });
    }
}
