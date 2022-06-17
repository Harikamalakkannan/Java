package com.Customer_Detail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.Customer_Detail.model.CustomerDetail;
import com.Customer_Detail.repository.CustomerDetailRepository;
@Service
public class CustomerDetailServiceImpl implements CustomerDetailService{
	
	private CustomerDetailRepository customerDetailRepository;

	public CustomerDetailServiceImpl(CustomerDetailRepository customerDetailRepository) {
        this.customerDetailRepository = customerDetailRepository;
    }

    @Override
    public CustomerDetail saveCustomerDetail(CustomerDetail customerDetail) {

        Optional<CustomerDetail> savedCustomerDetail = CustomerDetailRepository.findByEmail(customerDetail);
        if(savedCustomerDetail.isPresent())
//           throw new ResourceNotFoundException("CustomerDetail already exist with given email:" + customerDetail.getEmail());
//        }
        return customerDetailRepository.save(customerDetail);
    }

    @Override
    public List<CustomerDetail> getAllCustomerDetail() {
        return customerDetailRepository.findAll();
    }

    @Override
    public Optional<CustomerDetail> getCustomerDetailById(long id) {
        return customerDetailRepository.findById(id);
    }

    @Override
    public CustomerDetail updateCustomerDetail(CustomerDetail updatedCustomerDetail) {
        return customerDetailRepository.save(updatedCustomerDetail);
    }

    @Override
    public void deleteCustomerDetail(long id) {
    	customerDetailRepository.deleteById(id);
    }
}
