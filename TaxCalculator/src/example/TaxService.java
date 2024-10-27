package example;
import javax.jws.WebService;

@WebService
public class TaxService {
  public double calculateTax(double income) {
    double taxRate;
    if (income <= 5000) {
      taxRate = 0.03;
    } else if (income <= 10000) {
      taxRate = 0.1;
    } else if (income <= 20000) {
      taxRate = 0.2;
    } else {
      taxRate = 0.3;
    }
    return income * taxRate;
  }
}