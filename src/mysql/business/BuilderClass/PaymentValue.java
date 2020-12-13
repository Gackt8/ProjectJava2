package mysql.business.BuilderClass;

import java.util.ArrayList;

public class PaymentValue {

    public int idClient;
    public double summary;
    public int creditPeriod;
    public int percent;
    public double percentEveryMonth;
    public double paymentEveryMonthWithPercent;
    public double paymentEveryMonth;
    public double allSummary;
    public double overpayment;
    public double year;
    public ArrayList<ArrayList<Double>> month;

    public ArrayList<ArrayList<Double>> getMonth() {
        return month;
    }

    public double getYear() {
        return year;
    }

    public int getIdClient() {
        return idClient;
    }

    public double getSummary() {
        return summary;
    }

    public int getCreditPeriod() {
        return creditPeriod;
    }

    public int getPercent() {
        return percent;
    }

    public double getPercentEveryMonth() {
        return percentEveryMonth;
    }

    public double getPaymentEveryMonthWithPercent() {
        return paymentEveryMonthWithPercent;
    }

    public double getPaymentEveryMonth() {
        return paymentEveryMonth;
    }

    public double getAllSummary() {
        return allSummary;
    }

    public double getOverpayment() {
        return overpayment;
    }
}
