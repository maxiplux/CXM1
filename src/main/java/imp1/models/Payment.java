package imp1.models;

import javax.persistence.*;

/**
 * User: franc
 * Date: 05/09/2018
 * Time: 3:55
 */

@Embeddable
public class Payment {

    private String paydate;
    private double amount;

    public Payment() {
    }



    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paydate='" + paydate + '\'' +
                ", amount=" + amount +
                '}';
    }
}
