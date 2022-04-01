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

    public void test_AllOrdersFromColombian() throws IOException{
        List<Order> ordersFromColombia = TestUtil.buildOrdersColombia();
        double result = demand.calculateTotal(ordersFromColombia);
        Assert.assertEquals(Math.round(result), 0);
    }

    public void test_AllOrdersFromBrazil() throws IOException {
        List<Order> ordersFromBrazil = TestUtil.buildOrdersBrazil();
        double result = demand.calculateTotal(ordersFromBrazil);
        Assert.assertEquals(Math.round(result), 5.0);
    }

    public void test_RandomOrders() throws IOException {
        List<Order> orders = TestUtil.buildDifferentOrders();
        double result = demand.calculateTotal(orders);
        Assert.assertEquals(Math.round(result), 27);
    }

    public void test_RandomOrdersByAdditional() throws IOException {
        List<Order> orders = TestUtil.buildDifferentOrders();
        double result = demand.calculateTotalByAdditional(orders, 0.1, 0.5, 0.8);
        Assert.assertEquals(Math.round(result), 122); // real 121.5
    }

    public void test_WrongCountryNames() throws IOException {
        List<Order> orders = TestUtil.buildWrongCountryOrders();
        double result = demand.calculateTotal(orders);
        Assert.assertEquals(Math.round(result), 0);
    }

    public void test_InvalidQuantity() throws IOException {
        List<Order> orders = TestUtil.buildWrongQuantityOrders();
        double result = demand.calculateTotal(orders);
        Assert.assertEquals(Math.round(result), -1);
    }

    public void test_InvalidCountryCodes() throws IOException {
        List<Order> orders = TestUtil.buildWrongSizeCountryCode();
        double result = demand.calculateTotal(orders);
        Assert.assertEquals(Math.round(result), -1);
    }

}
