package com.tbp.crud.dao;

import com.tbp.crud.entity.Request;
import com.tbp.crud.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VendorRepositoryImpl implements VendorRepository{

    private static final String INSERT_USER_QUERY = "INSERT INTO vendor(emp_id,req_id,furniture,it_equip,delivery_date,email) values(?,?,?,?,?,?)";
    private static final String GET_USERS_QUERY = "SELECT * FROM Vendor";
    private static final String GET_USERBYID_QUERY = "SELECT * FROM Vendor where req_id=?";
    private static  final  String update_query="update vendor set req_id=?, emp_id=?,furniture=?,it_equip=?,delivery_date=? where req_id=?";
    private static final String DELETE_ROW_QUERY = "DELETE FROM vendor where req_id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Vendor saveUser(Vendor vendor) {
        jdbcTemplate.update(INSERT_USER_QUERY, vendor.getEmp_id(),vendor.getReq_id(), vendor.getFurniture(), vendor.getIt_equip(), vendor.getDelivery_date(),vendor.getEmail());
        return vendor;
    }

    @Override
    public List<Vendor> allUsers() {
        return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> new Vendor(rs.getInt("emp_id"),rs.getInt("req_id"), rs.getString("furniture"), rs.getString("it_equip"), rs.getDate("delivery_date"),rs.getString("email")));
    }
    @Override
    public Vendor updatevendor(Vendor vendor) {
        jdbcTemplate.update(update_query,vendor.getReq_id(),vendor.getEmp_id(),vendor.getFurniture(),vendor.getIt_equip(),vendor.getDelivery_date(),vendor.getReq_id());
        return vendor;
    }
    @Override
    public Vendor getVendorById(Long id) {
        return (Vendor) jdbcTemplate.queryForObject(
                GET_USERBYID_QUERY,
                new Object[]{id},
                new BeanPropertyRowMapper(Vendor.class));
    }
    @Override
    public void deleteVendorById(int id) {

        jdbcTemplate.update(DELETE_ROW_QUERY, id);

    }


}