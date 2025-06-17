package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhonebookDAO;
import com.javaex.vo.PersonVO;

@WebServlet("/pbc")
public class PhonebookController extends HttpServlet {
	
	//필드
	private static final long serialVersionUID = 1L;
	
       
	//생성자 -> 기본생성자 사용으로 삭제
	

    //메소드 gs
	
    
    //메소드 일반
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직
		
		//작동했는지 확인용
		System.out.println("PhonebookController");
		
		//action 파라미터의 값이 뭔지 알아야됨
		String action = request.getParameter("action");
		System.out.println(action); //업무구분
		
		
		if("list".equals(action)) { // 리스트 업무
			System.out.println("리스트");
			//db 데이터 가져온다 --> List
			PhonebookDAO phonebookDAO = new PhonebookDAO();
			List<PersonVO> personList = phonebookDAO.personSelect();
			
			System.out.println(personList);
			
			//저 밑에 있는 list.jsp 에게 후반일을 시킨다
			// 1)request객체에 데이터를 넣어준다
			request.setAttribute("pList", personList);
								  //String //0x333
			
			// 2)list.jsp에 request객체와 response객체를 보낸다
			//*forward 포워드
			RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
			rd.forward(request, response);
		
		
		////////////////////////////////////////////////////////////////////////
		}else if("wform".equals(action)) {// 등록폼 업무
			
			System.out.println("등록폼");
		
			//등록폼을 응답해야함
			//1) DB관련 할 일이 없다 -> 안하면 된다
			
			//2) jsp에게 화면을 그리게 한다(포워드)
			//writeForm.jsp 포워드한다
			RequestDispatcher rd = request.getRequestDispatcher("/writeForm.jsp");
			rd.forward(request, response);
			
		}else if("mform".equals(action)) {// 수정폼 업무
			//System.out.println("수정폼");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
