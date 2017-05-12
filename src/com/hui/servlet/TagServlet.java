package com.hui.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hui.dao.PostDAO;
import com.hui.javabean.Post;

import java.io.IOException;
import java.util.List;


public class TagServlet extends HttpServlet {

    private PostDAO postDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tag = request.getPathInfo().substring(1);

        List<Post> posts = postDAO.findByTagDateDescending(tag);

        request.setAttribute("posts", posts);

        RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
        view.forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        postDAO = new PostDAO();
    }
}
