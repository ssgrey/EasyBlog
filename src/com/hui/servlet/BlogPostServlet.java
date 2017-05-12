package com.hui.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hui.dao.PostDAO;
import com.hui.javabean.Post;

import java.io.IOException;


public class BlogPostServlet extends HttpServlet {

    private PostDAO postDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String permalink = req.getPathInfo().substring(1);//仅获取/post后面的路径,如果有?...=...也不会获取

        Post post = postDAO.findByPermalink(permalink);

        req.setAttribute("post", post);

        req.getRequestDispatcher("/post.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {

        postDAO = new PostDAO();

    }
}
