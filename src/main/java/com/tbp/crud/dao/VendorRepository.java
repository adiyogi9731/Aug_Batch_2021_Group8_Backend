package com.tbp.crud.dao;

import com.tbp.crud.entity.Request;
import com.tbp.crud.entity.Vendor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VendorRepository {
    Vendor saveUser(Vendor vendor);
    List<Vendor> allUsers();
    Vendor updatevendor(Vendor vendor);
    Vendor getVendorById(Long id);
    void deleteVendorById(int id);
}
