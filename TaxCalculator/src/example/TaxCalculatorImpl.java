package example;

import example.TaxCalculator;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public class TaxCalculatorImpl {

    @WebMethod
    public double calculateTax(double income) {
        double tax = 0.0;

        // 个人所得税计算逻辑
        if (income <= 5000) {
            tax = 0;
        } else if (income <= 8000) {
            tax = (income - 5000) * 0.03;
        } else if (income <= 17000) {
            tax = (income - 8000) * 0.1 + 90; // 90是5000到8000之间的税
        } else if (income <= 30000) {
            tax = (income - 17000) * 0.2 + 1090; // 1090是5000到17000之间的税
        } else {
            tax = (income - 30000) * 0.25 + 4090; // 4090是5000到30000之间的税
        }

        return tax;
    }
}
