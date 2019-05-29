package ljh.mp.member.control;

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

import ljh.board.model.BoardDTO;
import ljh.board.model.BoardService;
import ljh.mp.member.model.MemberDTO;
import ljh.mp.member.model.MemberService;
import ljh.mp.member.model.fboardDTO;
import ljh.mp.member.model.fboardService;

@WebServlet("/fboard.do")
public class fboardControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if (m != null) {
			m = m.trim();
			if (m.equals("write_form")) {
				// 글쓰기페이지
				write_form(request, response);
			}
			if (m.equals("insert")) {
				// 글쓰기페이지
				insert(request, response);
			}
			if (m.equals("content")) {
				// 글쓰기페이지
				content(request, response);
				reply(request, response);
			}
			
			if (m.equals("del")) {
				// 글쓰기페이지
				del(request, response);
			}
			if (m.equals("re")) {
				// 글쓰기페이지
				replyIn(request, response);
			}
			
		} else {
			fboardlist(request, response);
		}
	}

	public void fboardlist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		fboardService service = fboardService.getInstance();
		ArrayList<fboardDTO> listB = service.selectBoard();
		request.setAttribute("listB", listB);
		RequestDispatcher rd = request.getRequestDispatcher("fileboard/fboardlist.jsp");
		rd.forward(request, response);
	}
	public void write_form(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("fileboard/writeform.jsp");
	}
	public void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String saveDir = sc.getRealPath("/file");
		System.out.println(""+saveDir);
		int maxPostSize = 1*1028*1028;
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(request, saveDir, maxPostSize, encoding, policy);
		String subject = mr.getParameter("subject");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String email = mr.getParameter("email");
		String homepage = mr.getParameter("homepage");
		String pwd = mr.getParameter("pwd");
		String filename = mr.getFilesystemName("filename");
		fboardDTO dto = new fboardDTO(-1, writer, email, homepage, pwd, subject, content, null, -1, filename, null, -1, -1, -1, -1);
		fboardService service = fboardService.getInstance();
		service.insertF(dto);
		response.sendRedirect("fboard.do");
	}
	public void content(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idxStr = request.getParameter("idx");
		int idx = Integer.parseInt(idxStr);
		fboardService service = fboardService.getInstance();
		fboardDTO listC = service.selectContent(idx);
		request.setAttribute("listC", listC);
		RequestDispatcher rd = request.getRequestDispatcher("fileboard/filecontent.jsp");
		rd.forward(request, response);
	}
//	static final String sqlRI = "insert into MEMBER values(IDX_REPLY.nextval, ?, ?, ?. SYSDATE, ?, ?)";
	public void replyIn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq = getIdx(request);
		if(seq != -1) {
			BoardService service =BoardService.getInstance();
			service.deleteC(seq);
			response.sendRedirect("fboard.do");
		}else {
			response.sendRedirect("fboard.do");
			
		}
	}

	private int getIdx(HttpServletRequest request) {
		String idxStr = request.getParameter("idx");
		if (idxStr != null) {
			idxStr = idxStr.trim();
			if (idxStr.length() != 0) {
				try {
					int idx = Integer.parseInt(idxStr);
					return idx;
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
