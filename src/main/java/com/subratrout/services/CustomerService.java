package com.subratrout.services;

import com.subratrout.commands.CustomerForm;
import com.subratrout.domain.Customer;

import java.util.List;

/**
 * Created by subratrout on 3/13/17.
 */
public interface CustomerService extends CRUDService<Customer> {

    Customer saveOrUpdateCustomerForm(CustomerForm customerForm);

}
