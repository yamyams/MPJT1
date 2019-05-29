package ljh.board.model;

import java.util.ArrayList;

public class BoardService {
	private BoardDAO dao;
	private static BoardService instance = new BoardService();
	
	private BoardService() {
		dao = new BoardDAO();
	}
	
	public static BoardService getInstance() {
		return instance;
	}
	public ArrayList<BoardDTO> selectBoard(){
		return dao.selectB();
	}
	public void insertS(BoardDTO dto) {
		dao.insert(dto);
	}
	public void deleteC(int seq) {
		dao.delete(seq);
	}
	public BoardDTO selectContent(BoardDTO dto) {
		return dao.selectC(dto);
	}
	public BoardDTO updateCon(BoardDTO dto) {
		return dao.updateC(dto);
	}
	public void updateC(BoardDTO dto) {
		dao.update(dto);
	}
	
}
