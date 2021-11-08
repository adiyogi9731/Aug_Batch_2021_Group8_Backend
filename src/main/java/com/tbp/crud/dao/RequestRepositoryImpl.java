package com.tbp.crud.dao;

import com.tbp.crud.entity.Request;
import com.tbp.crud.entity.User;
import com.tbp.crud.entity.Vendor;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RequestRepositoryImpl implements RequestRepository {

    private static final String INSERT_USER_QUERY = "INSERT INTO REQUEST(emp_id,furniture,it_equip,shipping_add,email) values(?,?,?,?,?)";
    private static final String GET_USERS_QUERY = "SELECT * FROM Request";
    private static  final  String update_query="update request set status=?, rejectstatus=? where req_id=?";
    private  static final String get_request_by_id ="select * from request where emp_id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Request saveUser(Request request) {
        jdbcTemplate.update(INSERT_USER_QUERY, request.getEmp_id(), request.getFurniture(), request.getIt_equip(), request.getShipping_add(),request.getEmail());
        return request;
    }

    @Override
    public List<Request> allUsers() {
        return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> new Request(rs.getInt("req_id"), rs.getInt("status"),rs.getInt("rejectstatus"),rs.getInt("emp_id"), rs.getString("furniture"), rs.getString("it_equip"), rs.getString("shipping_add"), rs.getString("email")));
    }
    @Override
    public Request updateRequest(Request request) {
        jdbcTemplate.update(update_query,request.getStatus(),request.getRejectstatus(), request.getReq_id());
        return request;
    }

    @Override
    public List<Request> getrequestbyid(int emp_id) {
        return jdbcTemplate.query(get_request_by_id, (rs, rowNum)  -> {
            return new Request(rs.getInt("req_id"),rs.getInt("status"),rs.getInt("rejectstatus"), rs.getInt("emp_id") ,rs.getString("furniture"), rs.getString("it_equip"),rs.getString("shipping_add"), rs.getString("email"));
        },emp_id);

    }
}