package ljh.mp.member.model;

public class replyService {

	private replyDAO dao;
	private static replyService instance = new replyService();
	
	private replyService() {
		dao = new replyDAO();
	}
	public static replyService getInstance() {
		return instance;
	}
	public void insertR(replyDTO dto) {
		dao.insert(dto);
	}
	
	
	
}
