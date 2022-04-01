package lab;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lab.demand.ManageDemand;
import lab.util.TestUtil;
import lab.demand.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Test
public class ManageDemandTest {

    private ManageDemand demand;

    @BeforeClass
    public void setup() {
        demand = new ManageDemand();
    }
    
    public void test_AllOrdersFromPeru() {
        List<Order> ordersFromPeru = TestUtil.buildOrdersPeru();
        double result = demand.calculateTotal(ordersFromPeru);
        Assert.assertEquals(Math.round(result), 7.0);
    }

    // Add Tests !!
    public void test_NoOrders() throws IOException {
        List<Order> noOrders = new ArrayList<>();
        double result = demand.calculateTotal(noOrders);
        Assert.assertEquals(Math.round(result), 0);
    }

    public void test_AllOrdersFromColombian(){
        List<Order> ordersFromColombia = TestUtil.buildOrdersColombia();
        double result = demand.calculateTotal(ordersFromColombia);
        Assert.assertEquals(Math.round(result), 7.0);
    }

    public void test_HeavyOrders() throws IOException {

    }

}
