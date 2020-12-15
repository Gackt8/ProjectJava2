package default_package;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

//            for (int i = 0; i < product.getNum().size(); i++) {
//                request.setAttribute("num", product.getNum().get(i));
//
//            }
//            request.setAttribute("num", product.getNum());


            PaymentValue productMy = BookDB.selectOne(id);
            request.setAttribute("pro", productMy.getMonth());


                getServletContext().getRequestDispatcher("/grafic.jsp").forward(request, response);

        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

}