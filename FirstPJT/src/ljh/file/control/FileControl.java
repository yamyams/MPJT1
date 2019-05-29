package ljh.file.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import ljh.addr.model.AddrDTO;
import ljh.addr.model.AddrService;

@WebServlet("/file.do")
public class FileControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddrService service;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if (m != null) {
			m = m.trim();
			if (m.equals("form")) {
				in_form(request, response);
			} else if (m.equals("insert")) {
				in(request, response);

			} else {
				in_form(request, response);
			}
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
		response.sendRedirect("file/form.jsp");

	}

	private void in(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String cPath = 	getServletContext().getContextPath();
		String saveDir = sc.getRealPath("/file/store");
		int maxPostSize = 1*1028*1028;
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(request, saveDir, maxPostSize, encoding, policy);
		String writer = mr.getParameter("writer");
		String fname = mr.getFilesystemName("fname");
		String ofname = mr.getOriginalFileName("fname");
		
		

	}

	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = getSeq(request);
		if (seq != -1) {
			AddrService service = AddrService.getInstance();
			service.deleteS(seq);
			response.sendRedirect("addr.do");
		} else {
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

		}
		return -1;
	}

}
