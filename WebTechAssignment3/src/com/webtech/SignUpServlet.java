package com.webtech;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate the email and password (You should add proper validation logic here)
        if (isValidEmail(email) && isValidPassword(password)) {
            // Registration successful, store user information in session
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setAttribute("password", password);

            // Redirect to the admission form page
            response.sendRedirect("admissionForm.html");
        } else {
            // Invalid email or password, redirect back to the signup page with an error message
            HttpSession session = request.getSession();
            session.setAttribute("error", "Invalid email or password");
            response.sendRedirect("signup.html");
        }
    }

    // Implement email validation logic (you can use regular expressions)
    private boolean isValidEmail(String email) {
        // Implement email validation logic
        return true; // Replace with your validation code
    }

    // Implement password validation logic (e.g., minimum length, requirements)
    private boolean isValidPassword(String password) {
        // Implement password validation logic
        return true; // Replace with your validation code
    }
}
