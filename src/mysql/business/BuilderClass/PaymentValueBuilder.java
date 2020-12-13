package mysql.business.BuilderClass;

import java.util.ArrayList;

public interface PaymentValueBuilder {

    PaymentValueBuilder setIdClient(int idClient);

    PaymentValueBuilder setSummary(double summary);

    PaymentValueBuilder setCreditPeriod(int creditPeriod);

    PaymentValueBuilder setPercent(int percent);

    PaymentValueBuilder setPercentEveryMonth(double percentEveryMonth);

    PaymentValueBuilder setPaymentEveryMonthWithPercent(double paymentEveryMonthWithPercent);

    PaymentValueBuilder setPaymentEveryMonth(double paymentEveryMonth);

    PaymentValueBuilder setAllSummary(double allSummary);

    PaymentValueBuilder setOverpayment(double overpayment);

    PaymentValueBuilder setYear(double year);

    PaymentValueBuilder setMonth(ArrayList<ArrayList<Double>> month);

    PaymentValue build();
}
