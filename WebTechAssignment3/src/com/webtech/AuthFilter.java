package com.webtech;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/secure/*") // Spécifiez les URL sécurisées où ce filtre s'applique
public class AuthFilter implements Filter {
    
    public void init(FilterConfig fConfig) throws ServletException {
        // Initialisez le filtre
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // Vérifiez si l'utilisateur est authentifié en vérifiant la session
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            // Redirigez l'utilisateur vers la page de connexion s'il n'est pas authentifié
            res.sendRedirect(req.getContextPath() + "/Login.html");
        } else {
            // L'utilisateur est authentifié, laissez la demande se poursuivre
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
        // Détruisez le filtre
    }
}