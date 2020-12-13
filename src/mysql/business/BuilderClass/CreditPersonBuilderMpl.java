package mysql.business.BuilderClass;

public class CreditPersonBuilderMpl implements CreditPersonBuilder {

    CreditPersone creditPersone = new CreditPersone();

    @Override
    public CreditPersonBuilder setIdClient(int idClient) {
        creditPersone.idClient = idClient;
        return this;
    }

    @Override
    public CreditPersonBuilder setClientName(String clientName) {
        creditPersone.clientName = clientName;
        return this;
    }

    @Override
    public CreditPersonBuilder setNumCredit(int numCredit) {
        creditPersone.numCredit = numCredit;
        return this;
    }

    @Override
    public CreditPersonBuilder setDateCredit(String dateCredit) {
        creditPersone.dateCredit = dateCredit;
        return this;
    }

    @Override
    public CreditPersonBuilder setSummary(double summary) {
        creditPersone.summary = summary;
        return this;
    }

    @Override
    public CreditPersonBuilder setCurrency(String currency) {
        creditPersone.currency = currency;
        return this;
    }

    @Override
    public CreditPersonBuilder setCodCredit(int codCredit) {
        creditPersone.codCredit = codCredit;
        return this;
    }

    @Override
    public CreditPersonBuilder setCreditPeriod(int creditPeriod) {
        creditPersone.creditPeriod = creditPeriod;
        return this;
    }

    @Override
    public CreditPersonBuilder setPercent(int percent) {
        creditPersone.percent = percent;
        return this;
    }

    @Override
    public CreditPersone build() {
        return creditPersone;
    }

}
