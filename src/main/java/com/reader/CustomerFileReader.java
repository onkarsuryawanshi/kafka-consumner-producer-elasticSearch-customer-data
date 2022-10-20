package com.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.types.Customer;

import java.io.File;

public class CustomerFileReader {
    private static final CustomerFileReader customerFileReaderInstance = new CustomerFileReader();

    public static CustomerFileReader getInstance() {
        return customerFileReaderInstance;
    }

    String DATAFILE = "src/main/resources/data/data.json";

     private Customer[] customers;

    private CustomerFileReader() {
        final ObjectMapper mapper;
        mapper = new ObjectMapper();
        ;
        try {
            customers = mapper.readValue(new File(DATAFILE), Customer[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Customer[] getCustomers() {
        return customers;
    }


}

