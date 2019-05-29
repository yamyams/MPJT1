package ljh.mp.member.model;

import ljh.board.model.BoardDTO;

public class MemberService {
	private MemberDAO dao;
	private static MemberService instance = new MemberService();

	private MemberService() {
		dao = new MemberDAO();
	}

	public static MemberService getInstance() {
		return instance;
	}

	public void insertM(MemberDTO dto) {
		dao.insert(dto);
	}

	public int mLogin(String id, String pwd) {
		return dao.memberLogin(id, pwd);
	}

}
