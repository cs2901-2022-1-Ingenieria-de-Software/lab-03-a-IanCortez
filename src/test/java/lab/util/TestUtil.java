package lab.util;

import java.util.List;
import java.util.ArrayList;

import com.sun.org.apache.xpath.internal.operations.Or;
import lab.demand.Order;

public class TestUtil {

    public static List<Order> buildOrdersPeru() {
        List<Order> ordersPeru = new ArrayList<Order>();
        ordersPeru.add(new Order("PE", 10L));
        ordersPeru.add(new Order("PE", 10L));
        return ordersPeru;
    }

    public static List<Order> buildOrdersColombia() {
        List<Order> ordersPeru = new ArrayList<Order>();
        ordersPeru.add(new Order("CO", 10L));
        ordersPeru.add(new Order("CO", 10L));
        return ordersPeru;
    }

    public static List<Order> buildOrdersBrazil(){
        List<Order> ordersBrazil = new ArrayList<>();
        ordersBrazil.add(new Order("BR", 10L));
        ordersBrazil.add(new Order("BR", 10L));
        return ordersBrazil;
    }

    public static List<Order> buildDifferentOrders(){
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("PE", 15L));
        orders.add(new Order("PE", 10L));
        orders.add(new Order("BR", 10L));
        orders.add(new Order("CO", 5L));
        orders.add(new Order("BR", 5L));
        return orders;
    }

    public static List<Order> buildWrongCountryOrders(){
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("CL", 5L));
        orders.add(new Order("US", 14L));
        orders.add(new Order("UK", 9L));
        orders.add(new Order("UK", 9L));
        return orders;
    }

}