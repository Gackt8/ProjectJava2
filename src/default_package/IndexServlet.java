package default_package;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.business.*;
import mysql.business.BuilderClass.CreditPersone;


@WebServlet("/")
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//
//        PaymentValue paymentValues = Formulas.payment();
//        request.setAttribute("paymentValues", paymentValues);


        ArrayList<CreditPersone> creditsName = BookDB.selectName();
        request.setAttribute("creditsName", creditsName);


        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String name = request.getParameter("name");
            ArrayList<CreditPersone> credits = BookDB.select(name);
            request.setAttribute("credits", credits);

            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}