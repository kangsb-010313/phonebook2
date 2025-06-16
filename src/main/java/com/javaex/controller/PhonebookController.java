package com.javaex.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pbc")
public class PhonebookController extends HttpServlet {
	
	//필드
	private static final long serialVersionUID = 1L;
	
       
	//생성자 -> 기본생성자 사용으로 삭제
	

    //메소드 gs
	
    
    //메소드 일반
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직
		System.out.println("PhonebookController");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
