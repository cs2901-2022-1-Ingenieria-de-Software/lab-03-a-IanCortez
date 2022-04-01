package lab.demand;

import java.util.List;

public class ManageDemand {

    private static final double PERUVIAN_TAX = 0.18;
    private static final double BRAZILIAN_TAX = 0.12;
    private static final double COLOMBIAN_TAX = 0.0;

    // Default constructor used

    private double getTaxByCountry(String country, Double taxPeru, Double taxColombia, Double taxBrazil){
        switch (country){
            case "PE": return taxPeru;
            case "BR": return taxBrazil;
            case "CO": return taxColombia;
            default: return 0.0;
        }
    }

    public double calculateTotal(List<Order> orders){
        double taxes = 0.0;
        double quantities = 0.0;

        for (Order order : orders) {
            // Calculate Taxes
            String country = order.getCountry().toUpperCase();
            taxes += getTaxByCountry(country, PERUVIAN_TAX, COLOMBIAN_TAX, BRAZILIAN_TAX);

            // Calculate Total
            quantities += order.getQuantity();
        }

        return quantities * taxes;
    }


    public double calculateTotalByAdditional(List<Order> orders, double additionalColombia, double additionalPeru, double additionalBrazil){
        double taxes = 0.0;
        double quantities = 0.0;

        for (Order order : orders) {
            // Calculate additional by country
            String currCountry = order.getCountry().toUpperCase();
            taxes += getTaxByCountry(currCountry, additionalPeru, additionalColombia, additionalBrazil);

            // Calculate Total
            quantities += order.getQuantity();
        }

        return quantities * taxes;
    }

}
