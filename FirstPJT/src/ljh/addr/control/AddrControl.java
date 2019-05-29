package ljh.addr.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ljh.addr.model.AddrDTO;
import ljh.addr.model.AddrService;

@WebServlet("/addr.do")
public class AddrControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddrService service;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if (m != null) {
			m = m.trim();
			if (m.equals("in_form")) {
				in_form(request, response);
			} else if (m.equals("in")) {
				in(request, response);
			} else if (m.equals("del")) {
				del(request, response);
			} else {
				list(request, response);
			}
			;
		} else {
			list(request, response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddrService service = AddrService.getInstance();
		ArrayList<AddrDTO> list = service.selectS();
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("addr/list.jsp");
		rd.forward(request, response);

	}

	public void in_form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("addr/input.jsp");

	}

	private void in(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		AddrDTO dto = new AddrDTO(-1, name, addr, null);

		AddrService service = AddrService.getInstance();
		service.insertS(dto);
		response.sendRedirect("addr.do");

	}

	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = getSeq(request);
		if(seq != -1) {
			AddrService service = AddrService.getInstance();
			service.deleteS(seq);
			response.sendRedirect("addr.do");
		}else {
			response.sendRedirect("addr.do");
			
		}
		
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
					System.out.println("seq가 숫자가 아닌경우");
					return -1;
				}
			} else {
				System.out.println("seq가 0 인 경우");
				return -1;
			}
		} else {
			System.out.println("seq가 없는경우");
			
		}return -1;
	}
	
	
}
