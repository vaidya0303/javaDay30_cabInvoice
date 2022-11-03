package com.day30;

/**
 * import test class
 * import assert class
 */

import org.junit.Assert;
import org.junit.Test;

/**
 * creating class name as InvoiceServiceTest
 */
public class InvoiceServiceTest {

        @Test
        public void givenDistanceAndTime_ShouldReturnTotalFare() {
            CabInvoiceGenerator invoiceService = new  CabInvoiceGenerator();
            double distance = 2.0;
            int time = 5;
            double totalFare = invoiceService.calculateFare(distance, time);
            Assert.assertEquals(25, totalFare, 0);
        }

        @Test
        public void givenLessDistanceAndTime_ShouldReturnMinFare() {
            CabInvoiceGenerator invoiceService = new  CabInvoiceGenerator();
            double distance = 0.1;
            int time = 1;
            double totalFare = invoiceService.calculateFare(distance, time);
            Assert.assertEquals(5.0, totalFare, 0);
        }

        @Test
        public void givenMultipleRides_ShouldReturnTotalOfTotalFare() {
            Ride[] rides = {new Ride(2.0, 5),
                    new Ride(5.0, 10),
                    new Ride(0.1, 1),
                    new Ride(20, 60)
            };
            CabInvoiceGenerator invoiceService = new  CabInvoiceGenerator();
            double totalFare = invoiceService.calculateFareForMultipleRides(rides);
            Assert.assertEquals(260, totalFare, 0);
        }
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        CabInvoiceGenerator invoiceService = new CabInvoiceGenerator();
        InvoiceSummary invoiceSummary = invoiceService.invoiceSummaryCalculation(rides);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }
}