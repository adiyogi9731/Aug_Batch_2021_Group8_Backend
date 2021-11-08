package com.tbp.crud.controller;

import com.tbp.crud.dao.VendorRepository;
import com.tbp.crud.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VendorController {
    @Autowired
    VendorRepository vendorRepository;
    @ResponseBody
    @PostMapping("/vendor")
    public Vendor addUser(@RequestBody Vendor vendor) {

        return vendorRepository.saveUser(vendor);

    }
    @ResponseBody
    @PutMapping ("/vendorupdate")
    public Vendor updatevendor(@RequestBody Vendor vendor){
        return vendorRepository.updatevendor(vendor);
    }
    @ResponseBody
    @GetMapping("/vendors")
    public List<Vendor> getUser()  {
        return vendorRepository.allUsers();
    }
    @ResponseBody
    @GetMapping("/vendor/{id}")
    public Vendor getVendorById(@PathVariable Long id)  {
        return vendorRepository.getVendorById(id);
    }

    @ResponseBody
    @DeleteMapping("/vendors/{id}")
    public void  deleteUser(@PathVariable("id") int id) {
        vendorRepository.deleteVendorById(id);
    }

}
