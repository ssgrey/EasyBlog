package com.hui.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hui.dao.UserDAO;
import com.hui.javabean.User;

import java.io.IOException;


public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String from = request.getParameter("from");

        User user = new User(username, password);

        if (userDAO.validateLogin(user)) {

            //验证用户
            request.getSession().setAttribute("username", username);
            response.sendRedirect(response.encodeRedirectURL(from == null ? "/Blog" : from));
        } else {
            request.setAttribute("error_message", user.getMessage());
            doGet(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
    }


    @Override
    public void init() {
        userDAO = new UserDAO();
    }
}
