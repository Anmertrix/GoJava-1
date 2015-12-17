package com.gojava6.airbnb.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Autor Andrey Chaykin
 * @Since 09.12.2015
 */
public class LogInServlet extends HttpServlet {

    private final static String ADMIN_LOG = "admin";
    private final static String ADMIN_PASS = "pass";
    private final static String USER_LOG = "user";
    private final static String USER_PASS = "pass";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userLogin = request.getParameter("login");
        String userPassword = request.getParameter("password");
        Cookie loginCookie;
        HttpSession session;

        if (ADMIN_LOG.equals(userLogin) && ADMIN_PASS.equals(userPassword)) {
            session = request.getSession();
            session.setAttribute("admin", "Pankaj");
            session.setMaxInactiveInterval(30 * 60);
            loginCookie = new Cookie("admin", userLogin);
            loginCookie.setMaxAge(30 * 60);
            response.addCookie(loginCookie);
            response.sendRedirect("adminPage.jsp");
        } else if (USER_LOG.equals(userLogin) && USER_PASS.equals(userPassword)) {
            session = request.getSession();
            session.setAttribute("user", "UserPankaj");
            session.setMaxInactiveInterval(30 * 60);
            loginCookie = new Cookie("user", userLogin);
            loginCookie.setMaxAge(30 * 60);
            response.addCookie(loginCookie);
            response.sendRedirect("userPage.jsp");
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.html");
            PrintWriter pw = response.getWriter();
            pw.println("<p><font color=red>Either user name or password is wrong!</font></p>\n" +
                    "Please, check smth and try again!<br>");
            requestDispatcher.include(request, response);
        }
    }
}
