package ljh.mp.member.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import ljh.board.model.BoardDTO;
import ljh.mp.member.model.*;

@WebServlet("/member.do")
public class MemberControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if (m != null) {
			m = m.trim();
			if (m.equals("home")) {
				home(request, response);
				//Ȩ
			}
			if (m.equals("login_form")) {
				login_form(request, response);
				//�α���������
			}
			if (m.equals("login")) {
				login(request, response);
				//�α���
			}
			if (m.equals("mAdd_form")) {
				mAdd_form(request, response);
				//ȸ������������
			}
			if (m.equals("mAdd")) {
				mAdd(request, response);
				//ȸ������
			}
			if (m.equals("mDel")) {
				mDel(request, response);
				//ȸ��Ż��
			}
			if (m.equals("mUp_form")) {
				mUp(request, response);
				//ȸ������������
			}
			if (m.equals("mUp")) {
				mUp(request, response);
				//ȸ������
			}
		} else {
			response.sendRedirect("index.jsp");
		}
	}
	//Ȩ
	public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");

	}
	//�α���������
	public void login_form(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./member/login.jsp");

	}
	//�α���
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberService service = MemberService.getInstance();
		int check = service.mLogin(id,pwd);
		if(check==1) {
			HttpSession session = request.getSession();
			session.setAttribute("session_id", id);
			response.sendRedirect("index.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("member.do?=login")
//			rd.forward(request, response);
			out.println("<script>alert('"+id+" is LOGIN!');location.href='member.do?m=home';</script>");
		}else {
			out.println("<script>alert('please check your ID or password.');location.href='member.do?m=login_form';</script>");		
		}
	}
//		protected void doPost(HttpServletRequest request, HttpServletResponse response)
//				throws ServletException, IOException {	
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			String id = request.getParameter("id");
//			String pwd = request.getParameter("pwd");
//			MemberDTO inMem = new MemberDTO();
//			inMem.setId(id);
//			inMem.setPw(pwd);
//			MemberDAO dao = new MemberDAO();
//			MemberDTO outMem = dao.getMem(inMem);
//			if (outMem == null) {	
//				out.println("<script>alert('���̵�, �н����带 Ȯ�����ּ���.');location.href='login.do?m=in';</script>");			
//			} else {
//				HttpSession session = request.getSession();
//				session.setAttribute("session_id", outMem.getId());	
//				System.out.println(outMem.getId());
//				//response.sendRedirect("index.do");		
//				out.println("<script>alert('"+id+" ���� �α���');location.href='index.do';</script>");
//			}
//		}
		
	//ȸ������������
	public void mAdd_form(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./member/memberAdd.jsp");

	}
	//ȸ������
	public void mAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nick = request.getParameter("nick");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		MemberDTO dto = new MemberDTO(-1, -1, nick, id, pwd, name, email, phone, address, null);
		MemberService service = MemberService.getInstance();
		service.insertM(dto);
		response.sendRedirect("./member/login.jsp");

	}
	//ȸ��Ż��
	private void mDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = getSeq(request);
		if (seq != -1) {
			MemberService service = MemberService.getInstance();
//			service.deleteS(seq);
			response.sendRedirect("addr.do");
		} else {
			response.sendRedirect("addr.do");
		}
	}
	private void mUp_form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./member/memberUp.jsp");
	}
	private void mUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = getSeq(request);
		if (seq != -1) {
			MemberService service = MemberService.getInstance();
//			service.deleteS(seq);
			response.sendRedirect("addr.do");
		} else {
			response.sendRedirect("addr.do");
		}
	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = MemberService.getInstance();
//		ArrayList<MemberDTO> list = service.selectS();
//		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("addr/list.jsp");
		rd.forward(request, response);

	}

	

	private int getSeq(HttpServletRequest request) {
		String seqStr = request.getParameter("seq");
		if (seqStr != null) {
			seqStr = seqStr.trim();
			if (seqStr.length() != 0) {
				try {
					int seq = Integer.parseInt(seqStr);
					return seq;
				} catch (NumberFormatException nfe) {
					System.out.println("seq�� ���ڰ� �ƴѰ��");
					return -1;
				}
			} else {
				System.out.println("seq�� 0 �� ���");
				return -1;
			}
		} else {
			System.out.println("seq�� ���°��");
		}
		return -1;
	}
}
