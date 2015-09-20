package nikfisher.kickstarter.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("name", "Kickstarter");

//        QuoteDAO quoteDAO = new QuoteDAO();
//        request.setAttribute("quote", quoteDAO.quoteGenerate());
//
//
//        CategoriesDAO categoriesDAO = new CategoriesDAO();
//        List<String> categories = categoriesDAO.getCategories();
//        request.setAttribute("categories", categories);

        request.getRequestDispatcher("index.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }
}
