package com.Customer_Detail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.Customer_Detail.model.CustomerDetail;

public interface CustomerDetailService {
	CustomerDetail saveCustomerDetail(CustomerDetail customerDetail);
    List<CustomerDetail> getAllCustomerDetail();
    Optional<CustomerDetail> getCustomerDetailById(CustomerDetail customerDetail);
    CustomerDetail updateCustomerDetail(CustomerDetail updatedCustomerDetail);
    void deleteCustomerDetail(long id);
	Object getCustomerDetailById(long customerDetailId);
	Object updateEmployee(Object any);
}
