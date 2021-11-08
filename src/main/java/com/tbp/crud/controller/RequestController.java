package com.tbp.crud.controller;
import com.tbp.crud.dao.RequestRepository;
import com.tbp.crud.dao.UserRepository;
import com.tbp.crud.entity.Request;
import com.tbp.crud.entity.User;


import com.tbp.crud.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@RestController
@Controller
public class RequestController {
    @Autowired
    RequestRepository requestRepository;
    @ResponseBody
    @PostMapping("/request/{username}")
    public Request addUser(@RequestBody Request request,@PathVariable("username") String username) {

        return requestRepository.saveUser(request);

    }
    @ResponseBody
    @GetMapping("/requests")
    public List<Request> getUser()  {
        return requestRepository.allUsers();
    }
    @ResponseBody
    @PutMapping ("/updateRequest")
    public Request updateRequest(@RequestBody Request request){
        return requestRepository.updateRequest(request);
    }
    @ResponseBody
    @GetMapping("/requests/{emp_id}")
    public List<Request> getuserbyemp_id(@PathVariable("emp_id") int emp_id)  {
        return requestRepository.getrequestbyid(emp_id);

    }

}