package ljh.board.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ljh.addr.model.AddrService;
import ljh.board.model.BoardDTO;
import ljh.board.model.BoardService;

@WebServlet("/board.do")
public class BoardControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if (m != null) {
			m = m.trim();
			if (m.equals("in_form")) {
				System.out.println("in_form 연결");
				in_form(request, response);
			}
			if (m.equals("in")) {
				System.out.println("in 연결");
				in(request, response);
			}
			if (m.equals("content")) {
				System.out.println("content 연결");
				content(request, response);
			}if (m.equals("del")) {
					System.out.println("delete연결");
					delete(request, response);
			} else if (m.equals("up")) {
				System.out.println("content_up 연결");
				content_up(request, response);
			} else if (m.equals("up1")) {
				System.out.println("content_up1 연결");
				content_up1(request, response);
			}
		} else {
			list(request, response);
		}
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		ArrayList<BoardDTO> listB = service.selectBoard();
		request.setAttribute("listB", listB);
		RequestDispatcher rd = request.getRequestDispatcher("board/board.jsp");
		rd.forward(request, response);

	}

	protected void in_form(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("board/input.jsp");

	}

	protected void in(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		BoardDTO dto = new BoardDTO(-1, writer, email, subject, content, null);
		BoardService service = BoardService.getInstance();
		service.insertS(dto);
		response.sendRedirect("board.do");
	}

	protected void content(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String seqStr = request.getParameter("seq");
		int seq = Integer.parseInt(seqStr);
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		BoardService service = BoardService.getInstance();
		BoardDTO dto = new BoardDTO(seq, writer, email, subject, content, null);
		BoardDTO listC = service.selectContent(dto);
		request.setAttribute("content", listC);
		RequestDispatcher rd = request.getRequestDispatcher("board/b_content.jsp");
		rd.forward(request, response);
	}

	protected void content_up(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String seqStr = request.getParameter("seq");
		seqStr = seqStr.trim();
		int seq = Integer.parseInt(seqStr);
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		BoardService service = BoardService.getInstance();
		BoardDTO dto = new BoardDTO(seq, writer, email, subject, content, null);
		BoardDTO listU = service.updateCon(dto);
		request.setAttribute("up", listU);
		RequestDispatcher rd = request.getRequestDispatcher("board/update.jsp");
		rd.forward(request, response);
	}
	protected void content_up1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq = getSeq(request);
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		BoardDTO dto = new BoardDTO(seq, writer, email, subject, content, null);
		BoardService service = BoardService.getInstance();
		service.updateC(dto);
		response.sendRedirect("board.do");
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = getSeq(request);
		if(seq != -1) {
			BoardService service =BoardService.getInstance();
			service.deleteC(seq);
			response.sendRedirect("board.do");
		}else {
			response.sendRedirect("board.do");
			
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
