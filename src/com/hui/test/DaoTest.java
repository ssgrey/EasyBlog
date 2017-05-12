package com.hui.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.hui.dao.PostDAO;
import com.hui.dao.UserDAO;
import com.hui.javabean.Comment;
import com.hui.javabean.Post;
import com.hui.javabean.User;
import com.hui.dao.*;



public class DaoTest {
	
	@Test
	public void insertPost(){
		List<String> list = new ArrayList<String>();
		list.add("baidu");
		Comment com = new Comment("body","email","author");
		List<Comment> coms = new ArrayList<Comment>();
		coms.add(com);
		Post post =new Post("hellow test body","link","hui","title",list,coms,new Date());
		PostDAO pd = new PostDAO();
		pd.addPost(post);
	}
	@Test
	public void insertUser(){
		User user = new User("hui","123");
		UserDAO dao = new UserDAO();
		dao.createUser(user);
	}
}
