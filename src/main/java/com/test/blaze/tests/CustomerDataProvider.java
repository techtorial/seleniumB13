package com.test.blaze.tests;

import org.testng.annotations.DataProvider;

public class CustomerDataProvider {

    @DataProvider(name = "validationCustomer")
    public Object[][] provideCustomerInfo(){
        return new Object[][]{
                {"MacBook Pro","Ion","Romania","cro","9932 8871","09","2025","Thank you for your purchase!"},
                {"MacBook Pro","Ahmet","Turkey","cro","9332 8851","05","2023","Thank you for your purchase!"},
                {"MacBook Pro","Ayse","Turkey","Princess","9332 8271","08","2021","Thank you for your purchase!"}
        };
    }
}
