package com.tbp.crud.dao;

import com.tbp.crud.entity.User;
import com.tbp.crud.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USER_QUERY = "INSERT INTO USER(emp_id,username,email,password,first_name,last_name) values(?,?,?,?,?,?)";
    private static final String GET_USERS_QUERY = "SELECT * FROM USER";
    private static final String Get_User_By_USERNAME="SELECT * FROM USER WHERE USERNAME=?";
    private static final String sql="SELECT role,username from user where username=? and password=? ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User saveUser(User user) {
        jdbcTemplate.update(INSERT_USER_QUERY, user.getEmp_id(), user.getUsername(), user.getEmail(), user.getPassword(), user.getFirst_name(),user.getLast_name());
        return user;
    }
    @Override
    public List<User> allUsers() {
        return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> new User(rs.getInt("emp_id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("first_name"), rs.getString("last_name"),rs.getInt("role")));
    }
    @Override
    public User getUserByUsername(String username) {
        return (User) jdbcTemplate.queryForObject(
                Get_User_By_USERNAME,
                new Object[]{username},
                new BeanPropertyRowMapper(User.class));
    }

   @Override
    public User loginUser(User user) {
        return (User) jdbcTemplate.queryForObject(
                sql,
                new Object[]{user.getUsername(),user.getPassword()},

                new BeanPropertyRowMapper(User.class));
    }
 /* @Override
  public User loginUser(String username,String password) {
      return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {

          return new User(rs.getInt("emp_id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("first_name"), rs.getString("last_name"),rs.getInt("role"));
      },username, password);
  }*/
}

