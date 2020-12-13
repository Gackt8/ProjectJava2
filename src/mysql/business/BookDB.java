package mysql.business;
import mysql.business.BuilderClass.CreditPersonBuilderMpl;
import mysql.business.BuilderClass.CreditPersone;
import mysql.business.BuilderClass.PaymentValue;

import java.sql.*;
import java.util.ArrayList;

public class BookDB {

    private static String url = "jdbc:mysql://localhost/credit_grafic?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "jhj5655565";

    public static ArrayList<CreditPersone> select(String name) throws ClassNotFoundException{ //для выборки клиентов по имени

        ArrayList<CreditPersone> credits = new ArrayList<CreditPersone>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                String sql = "SELECT client.id_client, client.client_name, client.num_credit, credit.date_credit, credit.summary, credit.currency, credit.cod_credit, traffic.credit_period, traffic.percent FROM client, credit, traffic where credit.num_credit = client.num_credit AND traffic.cod_credit = credit.cod_credit AND client.client_name = ?";

                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, name);

                    ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){

                    int idClient = resultSet.getInt(1);
                    String clientName = resultSet.getString(2);
                    int numCredit = resultSet.getInt(3);
                    String dateCredit = resultSet.getString(4);
                    double summary = resultSet.getDouble(5);
                    String currency = resultSet.getString(6);
                    int codCredit = resultSet.getInt(7);
                    int creditPeriod = resultSet.getInt(8);
                    int percent = resultSet.getInt(9);


                    CreditPersone creditPersone = new CreditPersonBuilderMpl()
                            .setIdClient(idClient)
                            .setClientName(clientName)
                            .setNumCredit(numCredit)
                            .setDateCredit(dateCredit)
                            .setSummary(summary)
                            .setCurrency(currency)
                            .setCodCredit(codCredit)
                            .setCreditPeriod(creditPeriod)
                            .setPercent(percent).build();


                    credits.add(creditPersone);
                }
            }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return credits;
    }

    public static ArrayList<CreditPersone> selectName() { //Для добавление данных клиента в таблицу

        ArrayList<CreditPersone> creditsName = new ArrayList<CreditPersone>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();


                ResultSet resultSet = statement.executeQuery("SELECT client.id_client, client.client_name, client.num_credit FROM client");

                while(resultSet.next()){

                    int idClient = resultSet.getInt(1);
                    String clientName = resultSet.getString(2);
                    int numCredit = resultSet.getInt(3);

                    CreditPersone creditPersone = new CreditPersonBuilderMpl()
                            .setIdClient(idClient)
                            .setClientName(clientName)
                            .setNumCredit(numCredit).build();

                    creditsName.add(creditPersone);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return creditsName;
    }


    public static ArrayList<CreditPersone> selectTraffic() { //для просмотра доступных трафиков

        ArrayList<CreditPersone> traffics = new ArrayList<CreditPersone>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();


                ResultSet resultSet = statement.executeQuery("SELECT traffic.cod_credit, traffic.credit_period, traffic.percent FROM traffic");

                while(resultSet.next()){

                    int codCredit = resultSet.getInt(1);
                    int creditPeriod = resultSet.getInt(2);
                    int percent = resultSet.getInt(3);

                   // Credit credit = new Credit(codCredit, creditPeriod, percent);

                    CreditPersone creditPersone = new CreditPersonBuilderMpl()
                            .setCodCredit(codCredit)
                            .setCreditPeriod(creditPeriod)
                            .setPercent(percent).build();

                    traffics.add(creditPersone);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return traffics;
    }

    public static int insertCredit(CreditPersone credit) { //для вставки данных кредита

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO credit(num_credit, date_credit, summary, currency, cod_credit) Values (?, ?, ?, ?, ?)";

                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, credit.getNumCredit());
                    preparedStatement.setString(2, credit.getDateCredit());
                    preparedStatement.setDouble(3, credit.getSummary());
                    preparedStatement.setString(4, credit.getCurrency());
                    preparedStatement.setInt(5, credit.getCodCredit());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int insertClient(CreditPersone creditPersone) { //для вставки данных клиента (объединён с кредитом)

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){


                String sql = "INSERT INTO client(client_name, num_credit) Values (?, ?);";

                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){

                    preparedStatement.setString(1, creditPersone.getClientName());
                    preparedStatement.setInt(2, creditPersone.getNumCredit());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }


    public static PaymentValue selectOne(int id) { //для графика, поменять на PaymentValue и добавить функцию

        PaymentValue creditPersone = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT client.id_client, credit.summary, traffic.credit_period, traffic.percent FROM client, credit, traffic where credit.num_credit = client.num_credit AND traffic.cod_credit = credit.cod_credit AND client.id_client = ?";

                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int oneId = resultSet.getInt(1);
                        Double summary = resultSet.getDouble(2);
                        int period = resultSet.getInt(3);
                        int percent = resultSet.getInt(4);

                        //creditOne = new Credit(oneId, summary, period, percent);

                        // записать функцию и высленные переменные записать в класс PaymentValue

                        creditPersone = Formulas.paymentDouble(oneId, summary, period, percent);
                        

//                        creditPersone = new CreditPersonBuilderMpl()
//                                .setIdClient(oneId)
//                                .setSummary(summary)
//                                .setCreditPeriod(period)
//                                .setPercent(percent).build();

                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return creditPersone;
    }

}