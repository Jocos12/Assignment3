package com.webtech;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secure/Admission")
public class AdmissionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            // L'utilisateur est authentifié, affichez la page d'admission
            request.getRequestDispatcher("/Admission.html").forward(request, response);
        } else {
            // Redirigez l'utilisateur vers la page de connexion s'il n'est pas authentifié
            response.sendRedirect(request.getContextPath() + "/Login.html");
        }
    }
}