package mysql.business;

import mysql.business.BuilderClass.PaymentValue;
import mysql.business.BuilderClass.PaymentValueBuilderMpl;

import java.util.*;

public class Formulas {

    public static PaymentValue paymentDouble(int oneId, Double summary, int period, int percent) {

//        double procent = 20; //введённый процент
//        double summary = 50000; //введённая сумма взятого кредита
//        double years = 3; //введённое количество лет


        double c = (percent * 10000) / 12;// размер процентной ставки за месяц
        double cc = c / 1000000;
        double result = math(cc,6);

        double year = period*12; // всего месяцев

        ArrayList<ArrayList<Double>> doubles = new ArrayList<>();

        for (double i=1; i<=year; i++) {
//
            ArrayList<Double> d = new ArrayList<Double>();
            double percentEveryMonth = summary * result; //процент каждый месяц
            double result2 = math(percentEveryMonth, 3);


            double pow = Math.pow(1 + result, -year);
            double result3 = math(pow, 5);

            double paymentEveryMonthWithPercent = result2 / (1 - result3); //платёж с процентами каждый месяц
            double result4 = math(paymentEveryMonthWithPercent, 2);


            double paymentEveryMonth = paymentEveryMonthWithPercent - result2; //платёж каждый месяц без процентов
            double result5 = math(paymentEveryMonth, 2);

            d.add(i);
            d.add(result5);
            d.add(result2);
            d.add(result4);

            doubles.add(d);

        }

        double percentEveryMonth = summary * result; //процент каждый месяц
        double result2 = math(percentEveryMonth, 3);


        double pow = Math.pow(1 + result, -year);
        double result3 = math(pow, 5);

        double paymentEveryMonthWithPercent = result2 / (1 - result3); //платёж с процентами каждый месяц
        double result4 = math(paymentEveryMonthWithPercent, 2);


        double paymentEveryMonth = paymentEveryMonthWithPercent - result2; //платёж каждый месяц без процентов
        double result5 = math(paymentEveryMonth, 2);

        double allSummary = result4 * year; //общая сумма к выплате
        double result6 = math(allSummary,2);

        double overpayment = result6 - summary; //переплата за всё время
        double result7 = math(overpayment,2);


        PaymentValue paymentValue = new PaymentValueBuilderMpl()
                .setIdClient(oneId)
                .setSummary(summary)
                .setPercent(percent)
                .setCreditPeriod(period)
                .setYear(year)
                .setPercentEveryMonth(result2)
                .setPaymentEveryMonthWithPercent(result4)
                .setPaymentEveryMonth(result5)
                .setAllSummary(result6)
                .setOverpayment(result7)
                .setMonth(doubles)
                .build();

        return paymentValue;
    }

    public static double math(double name, double n){

        double scale = Math.pow(10, n);
        double result = Math.ceil(name * scale) / scale;

        return result;
    }
}
