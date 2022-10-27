package com.example.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

@Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            if (login != null && password != null && login != "" && password != "") {

                request.getSession().setAttribute("login",login);
                request.getSession().setAttribute("password",password);
                request.getRequestDispatcher("user/hello.jsp").forward(request,response);
            } else {

                request.getRequestDispatcher("user/error.jsp").forward(
                        request, response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}

