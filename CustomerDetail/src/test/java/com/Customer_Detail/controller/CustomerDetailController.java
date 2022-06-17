package com.Customer_Detail.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.Customer_Detail.model.CustomerDetail;
import com.Customer_Detail.service.CustomerDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;



@WebMvcTest
class CustomerDetailControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerDetailService customerDetailService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenCustomerDetailObject_whenCreateCustomerDetail_thenReturnSavedCustomerDetail() throws Exception{

    	CustomerDetail customerDetail = CustomerDetail.builder()
                .firstName("Hari")
                .lastName("haran")
                .email("hari@gmail.com")
                .phonenumber("69857412365")
                .build();
        given(CustomerDetailService.saveCustomerDetail(any(CustomerDetail.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/api/CustomerDetail")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(customerDetail)));

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName",is(customerDetail.getFirstName())))
                .andExpect(jsonPath("$.lastName",is(customerDetail.getLastName())))       
                .andExpect(jsonPath("$.email",is(customerDetail.getEmail())))                       
                .andExpect(jsonPath("$.phonenumber",is(customerDetail.getPhoneNumber())));
                		
    }

    // JUnit test for Get All CustomerDetail REST API
    @Test
    public void givenListOfCustomerDetail_whenGetAllCustomerDetail_thenReturnCustomerDetailList() throws Exception{
        // given - precondition or setup
        List<CustomerDetail> listOfCustomerDetail = new ArrayList<>();
        listOfCustomerDetail.add(CustomerDetail.builder().firstName("Hari").lastName("Haran").email("hari@gmail.com").phonenumber("6945781236").build());
        listOfCustomerDetail.add(CustomerDetail.builder().firstName("Mohan").lastName("Kumar").email("kannan@gmail.com").phonenumber("6985234698").build());
        given(customerDetailService.getAllCustomerDetail()).willReturn(listOfCustomerDetail);

        ResultActions response = mockMvc.perform(get("/api/CustomerDetail"));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfCustomerDetail.size())));

    }
   
    // JUnit test for GET CustomerDetail by id REST API
    @Test
    public void givenCustomerDetailId_whenGetCustomerDetailId_thenReturnCustomerDetailObject() throws Exception{
        // given - precondition or setup
        long customerDetailId = 1L;
        CustomerDetail customerDetail = CustomerDetail.builder()
                .firstName("Hariharan")
                .lastName("Kannan")
                .email("mk@gmail.com")
                .phonenumber("695455245")
                .build();
        given(customerDetailService.getCustomerDetailById(customerDetailId)).willReturn(Optional.of(customerDetailId));

        ResultActions response = mockMvc.perform(get("/api/customerDetail/{id}", customerDetailId));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName",is(customerDetail.getFirstName())))
                .andExpect(jsonPath("$.lastName",is(customerDetail.getLastName())))       
                .andExpect(jsonPath("$.email",is(customerDetail.getEmail())))                       
                .andExpect(jsonPath("$.phonenumber",is(customerDetail.getPhoneNumber())));
    }

    // JUnit test for GET CustomerDetail by id REST API
    @Test
    public void givenInvalidCustomerDetailId_whenGetCustomerDetailById_thenReturnEmpty() throws Exception{
        // given - precondition or setup
        long customerDetailId = 1L;
        CustomerDetail customerDetail = CustomerDetail.builder()
                .firstName("Mohan")
                .lastName("kumar")
                .email("hari@gmail.com")
                .phonenuumber("9654136956")
                .build();
        given(customerDetailService.getCustomerDetailById(customerDetailId)).willReturn(Optional.empty());

        // when -  action or the behavior that we are going test
        ResultActions response = mockMvc.perform(get("/api/customerDetail/{id}", customerDetailId));

        // then - verify the output
        response.andExpect(status().isNotFound())
                .andDo(print());

    }
    // JUnit test for update CustomerDetail REST API - positive scenario
        @Test
        public void givenUpdatedCustomerDetail_whenUpdateCustomerDetail_thenReturnUpdateCustomerDetailObject() throws Exception{
            // given - precondition or setup
            long customerDetailId = 1L;
            CustomerDetail savedCustomerDetail = CustomerDetail.builder()
                    .firstName("Mani")
                    .lastName("Kandan")
                    .email("mani@gmail.com")
                    .phonenumber("9654786352")
                    .build();

            CustomerDetail updatedCustomerDetail = CustomerDetail.builder()
                    .firstName("Divya")
                    .lastName("Aravindhan")
                    .email("da@gmail.com")
                    .phonenumber("9654786352")
                    .build();
            given(customerDetailService.getCustomerDetailById(customerDetailId)).willReturn(Optional.of(savedCustomerDetail));
            given(customerDetailService.updateCustomerDetail(any(CustomerDetail.class)))
                    .willAnswer((invocation)-> invocation.getArgument(0));

            // when -  action or the behavior that we are going test
            ResultActions response = mockMvc.perform(put("/api/customerDetail/{id}", customerDetailId)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(objectMapper.writeValueAsString(updatedCustomerDetail)));


            // then - verify the output
            response.andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(jsonPath("$.firstName", is(updatedCustomerDetail.getFirstName())))
                    .andExpect(jsonPath("$.lastName", is(updatedCustomerDetail.getLastName())))
                    .andExpect(jsonPath("$.email", is(updatedCustomerDetail.getEmail())))
                    .andExpect(jsonPath("$.phonenumber", is(updatedCustomerDetail.getPhoneNumber())));
                    
            
        }

    // JUnit test for update employee REST API - negative scenario
    @Test
    public void givenUpdatedEmployee_whenUpdateEmployee_thenReturn404() throws Exception{
        // given - precondition or setup
        long customerDetailId = 1L;
        CustomerDetail savedCustomerDetail = CustomerDetail.builder()
                .firstName("Ramesh")
                .lastName("kumar")
                .email("ramesh@gmail.com")
                .build();

        CustomerDetail updatedCustomerDetail = CustomerDetail.builder()
                .firstName("Ram")
                .lastName("krishnan")
                .email("ram@gmail.com")
                .build();
        given(customerDetailService.getCustomerDetailById(customerDetailId)).willReturn(Optional.empty());
        given(customerDetailService.updateEmployee(any(CustomerDetail.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));

        // when -  action or the behavior that we are going test
        ResultActions response = mockMvc.perform(put("/api/customerDetail/{id}", customerDetailId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedCustomerDetail)));

        // then - verify the output
        response.andExpect(status().isNotFound())
                .andDo(print());
    }

private Object any(Class<CustomerDetail> class1) {
		// TODO Auto-generated method stub
		return null;
	}

private Object given(Object customerDetailById) {
		// TODO Auto-generated method stub
		return null;
	}

private MockHttpServletRequestBuilder put(String string, long customerDetailId) {
		// TODO Auto-generated method stub
		return null;
	}

// JUnit test for delete employee REST API
    @Test
    public void givenCustomerDetailId_whenDeleteCustomerDetail_thenReturn200() throws Exception{
        // given - precondition or setup
        long customerDetailId = 1L;
        willDoNothing().given(customerDetailService).deleteCustomerDetail(customerDetailId);

        // when -  action or the behavior that we are going test
        ResultActions response = mockMvc.perform(delete("/api/customerDetail/{id}", customerDetailId));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());
    }


}
