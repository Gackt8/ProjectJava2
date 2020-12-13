package mysql.business.BuilderClass;

import java.util.ArrayList;

public class PaymentValueBuilderMpl implements PaymentValueBuilder{
    PaymentValue paymentValue = new PaymentValue();

    @Override
    public PaymentValueBuilder setIdClient(int idClient) {
        paymentValue.idClient = idClient;
        return this;
    }

    @Override
    public PaymentValueBuilder setSummary(double summary) {
        paymentValue.summary = summary;
        return this;
    }

    @Override
    public PaymentValueBuilder setCreditPeriod(int creditPeriod) {
        paymentValue.creditPeriod = creditPeriod;
        return this;
    }

    @Override
    public PaymentValueBuilder setPercent(int percent) {
        paymentValue.percent = percent;
        return this;
    }

    @Override
    public PaymentValueBuilder setPercentEveryMonth(double percentEveryMonth) {
        paymentValue.percentEveryMonth = percentEveryMonth;
        return this;
    }

    @Override
    public PaymentValueBuilder setPaymentEveryMonthWithPercent(double paymentEveryMonthWithPercent) {
        paymentValue.paymentEveryMonthWithPercent = paymentEveryMonthWithPercent;
        return this;
    }

    @Override
    public PaymentValueBuilder setPaymentEveryMonth(double paymentEveryMonth) {
        paymentValue.paymentEveryMonth = paymentEveryMonth;
        return this;
    }

    @Override
    public PaymentValueBuilder setAllSummary(double allSummary) {
        paymentValue.allSummary = allSummary;
        return this;
    }

    @Override
    public PaymentValueBuilder setOverpayment(double overpayment) {
        paymentValue.overpayment = overpayment;
        return this;
    }

    @Override
    public PaymentValueBuilder setMonth(ArrayList<ArrayList<Double>> month) {
        paymentValue.month = month;
        return this;
    }

    @Override
    public PaymentValueBuilder setYear(double year) {
        paymentValue.year = year;
        return this;
    }

    @Override
    public PaymentValue build() {
        return paymentValue;
    }
}
