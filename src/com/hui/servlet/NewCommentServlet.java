package com.hui.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hui.dao.PostDAO;
import com.hui.javabean.Comment;
import com.hui.javabean.Post;

import java.io.IOException;
import java.io.PrintWriter;

public class NewCommentServlet extends HttpServlet {

    private PostDAO postDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean isJSEnabled = req.getParameter("isJSEnabled") == null;//js支持，因此一般都为空
        String permalink = req.getParameter("permalink");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String commentBody = req.getParameter("commentBody");

        Post post = postDAO.findByPermalink(permalink);
        Comment comment = new Comment(commentBody, email, name);

        if (post == null) {
            resp.sendRedirect(resp.encodeRedirectURL("/Blog"));
        }

        if (comment.validate()) {
            postDAO.addCommentToPost(comment, post);
        }

        if (isJSEnabled) {
        	//支持js就用js代码添加comment或错误信息
            String json = comment.toJson();
            resp.setContentType("application/json");//指定返回值类型
            PrintWriter writer = resp.getWriter();

            writer.write(json);
            writer.flush();
        } else {
        	//不支持就重新加载一遍页面
            if (comment.getMessage() != null && !comment.getMessage().isEmpty()) {
                req.setAttribute("error_message", comment.getMessage());
            }

            req.getRequestDispatcher("/post/" + permalink).forward(req, resp);
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("username") == null)
            resp.sendRedirect(resp.encodeRedirectURL("/login"));
        else
            doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        postDAO = new PostDAO();
    }
}
