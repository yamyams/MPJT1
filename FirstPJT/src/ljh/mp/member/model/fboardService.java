package ljh.mp.member.model;

import java.util.ArrayList;

public class fboardService {

	private fboardDAO dao;
	private static fboardService instance = new fboardService();

	private fboardService() {
		dao = new fboardDAO();
	}

	public static fboardService getInstance() {
		return instance;
	}

	public ArrayList<fboardDTO> selectBoard(){
		return dao.selectB();
	}
	public void insertF(fboardDTO dto) {
		dao.insert(dto);
	}
	public fboardDTO selectContent(int idx){
		return dao.selectC(idx);
	}
}
