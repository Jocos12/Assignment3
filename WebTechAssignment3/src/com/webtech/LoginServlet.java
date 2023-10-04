package com.webtech;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("emailss");
        String pass = request.getParameter("passwords");

        HttpSession session = request.getSession();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (session == null) {
            res.sendRedirect("login.html");
        } else {
            String ema = (String) session.getAttribute("emails");
            String passw = (String) session.getAttribute("passwords");

            if (ema.equals(email) && passw.equals(pass)) {
                res.sendRedirect("admission.html");
            } else {
                res.sendRedirect("login.html");
            }
        }
    }
}