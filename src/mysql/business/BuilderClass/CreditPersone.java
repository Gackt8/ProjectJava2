package mysql.business.BuilderClass;

public class CreditPersone {
    public int idClient;
    public String clientName;
    public int numCredit; //общее поле
    public String dateCredit;
    public double summary;
    public String currency;
    public int codCredit; //общее поле
    public int creditPeriod;
    public int percent;

    public int getIdClient() {
        return idClient;
    }

    public String getClientName() {
        return clientName;
    }

    public int getNumCredit() {
        return numCredit;
    }

    public String getDateCredit() {
        return dateCredit;
    }

    public double getSummary() {
        return summary;
    }

    public String getCurrency() {
        return currency;
    }

    public int getCodCredit() {
        return codCredit;
    }

    public int getCreditPeriod() {
        return creditPeriod;
    }

    public int getPercent() {
        return percent;
    }
}
