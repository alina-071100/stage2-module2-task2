package com.example.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    // jnjel user atribut@ sessiayic
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        session.removeAttribute("user");
        session.invalidate();
        response.sendRedirect("/login.jsp");
//
//        request.getRequestDispatcher("/").forward(
//                request, response);
    }
}
