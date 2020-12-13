package default_package;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.business.*;
import mysql.business.BuilderClass.PaymentValue;

@WebServlet("/grafic")

public class GraficServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {


            int id = Integer.parseInt(request.getParameter("id"));
            PaymentValue product = BookDB.selectOne(id);
            request.setAttribute("product", product);

//            int id = Integer.parseInt(request.getParameter("id"));

//            PaymentValue productMy = BookDB.selectOne(id);
//
//            request.setAttribute("pro", productMy);

//            ArrayList<Double> doubles = new ArrayList<>();
//            for (int i = 1; i<productMy.getYear(); i++) {
//
//                doubles.add((double) i);
//                doubles.add(productMy.getPaymentEveryMonth());
//                doubles.add(productMy.getPercentEveryMonth());
//                doubles.add(productMy.getPaymentEveryMonthWithPercent());
//
//            }
//
//            request.setAttribute("pro", doubles);


//            getServletContext().getRequestDispatcher("/grafic.jsp").forward(request, response);

//            if(product!=null) {
//                request.setAttribute("product", product);
//                request.setAttribute("pr", product.getCreditPeriod());



                getServletContext().getRequestDispatcher("/grafic.jsp").forward(request, response);
//            }
//            else {
//                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
//            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

}