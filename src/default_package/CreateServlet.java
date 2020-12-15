package default_package;

import mysql.business.BookDB;
import mysql.business.BuilderClass.CreditPersonBuilderMpl;
import mysql.business.BuilderClass.CreditPersone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        ArrayList<CreditPersone> traffics = BookDB.selectTraffic();
        request.setAttribute("traffics", traffics);

        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String clientName = request.getParameter("clientName");
            int numCredit = Integer.parseInt(request.getParameter("numCredit"));
            String dateCredit = request.getParameter("dateCredit");
            double summary = Double.parseDouble(request.getParameter("summary"));
            String currency = request.getParameter("currency");
            int codCredit = Integer.parseInt(request.getParameter("codCredit"));


            //CreditPersone credit = new Credit(numCredit, dateCredit, summary, currency, codCredit);
            CreditPersone credit = new CreditPersonBuilderMpl()
                    .setNumCredit(numCredit)
                    .setDateCredit(dateCredit)
                    .setSummary(summary)
                    .setCurrency(currency)
                    .setCodCredit(codCredit)
                    .build();
            BookDB.insertCredit(credit);

            //CreditPersone creditClient = new Credit(clientName, numCredit);
            CreditPersone creditPersone = new CreditPersonBuilderMpl()
                    .setClientName(clientName)
                    .setNumCredit(numCredit)
                    .build();
            BookDB.insertClient(creditPersone);

            response.sendRedirect(request.getContextPath()+"/index");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }
}