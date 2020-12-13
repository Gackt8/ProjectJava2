package mysql.business.BuilderClass;

public interface CreditPersonBuilder {

    CreditPersonBuilder setIdClient(int idClient);

    CreditPersonBuilder setClientName(String clientName);

    CreditPersonBuilder setNumCredit(int numCredit);

    CreditPersonBuilder setDateCredit(String dateCredit);

    CreditPersonBuilder setSummary(double summary);

    CreditPersonBuilder setCurrency(String currency);

    CreditPersonBuilder setCodCredit(int codCredit);

    CreditPersonBuilder setCreditPeriod(int creditPeriod);

    CreditPersonBuilder setPercent(int percent);

    CreditPersone build();
}
