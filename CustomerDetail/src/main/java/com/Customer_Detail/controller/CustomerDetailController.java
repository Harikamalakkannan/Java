package com.Customer_Detail.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Customer_Detail.model.CustomerDetail;
import com.Customer_Detail.service.CustomerDetailService;

@RestController
@RequestMapping("/CustomerDetail")
public class CustomerDetailController {
	private CustomerDetailService customerDetailService;

    public CustomerDetailController(CustomerDetailService customerDetailService) {
        this.customerDetailService = customerDetailService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDetail createCustomerDetail(@RequestBody CustomerDetail customerDetail){
        return customerDetailService.saveCustomerDetail(customerDetail);
    }

    @GetMapping
    public List<CustomerDetail> getAllCustomerDetail(){
        return customerDetailService.getAllCustomerDetail();
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDetail> getEmployeeById(@PathVariable("id") long customerDetailId){
        return customerDetailService.getCustomerDetailById(customerDetailId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomerDetail> updateCustomerDetail(@PathVariable("id") long customerDetailId,
                                                   @RequestBody CustomerDetail customerDetail){
        return customerDetailService.getCustomerDetailById(customerDetailId)
                .map(savedCustomerDetail -> {

                    savedCustomerDetail.setFirstName(customerDetail.getFirstName());
                    savedCustomerDetail.setLastName(customerDetail.getLastName());
                    savedCustomerDetail.setEmail(customerDetail.getEmail());
                    savedCustomerDetail.setPhoneNumber(customerDetail.getPhoneNumber());
                    CustomerDetail updatedCustomerDetail = customerDetailService.updateCustomerDetail(savedCustomerDetail);
                    return new ResponseEntity<>(updatedCustomerDetail, HttpStatus.OK);

                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomerDetaile(@PathVariable("id") long customerDetailId){

    	customerDetailService.deleteCustomerDetail(customerDetailId);

        return new ResponseEntity<String>("CustomerDetail deleted successfully!.", HttpStatus.OK);

    }}
