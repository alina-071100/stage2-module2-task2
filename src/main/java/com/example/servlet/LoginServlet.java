package com.example.servlet;


import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final Users usersRepo = Users.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        Object user = req.getSession().getAttribute("user");

        if (user == null) {
            resp.sendRedirect("/login.jsp");
        } else {
            resp.sendRedirect("/user/hello.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
            if (login != null && password != null && !login.equals("") && !password.equals("")) {


            boolean rightLogin = usersRepo.getUsers().contains(login);
            boolean rightPassword = password != null && !password.trim().isEmpty();


            if (rightLogin && rightPassword) {
                request.getSession().setAttribute("user", login);
                response.sendRedirect("/user/hello.jsp");
            } else {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }
}

