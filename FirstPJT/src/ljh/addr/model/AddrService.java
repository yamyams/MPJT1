package ljh.addr.model;
import java.util.*;

public class AddrService {
	private AddrDAO dao;
	//singleton object model
	private static AddrService instance =new AddrService();
	private AddrService() {
		dao = new AddrDAO();
	}
	
	public static AddrService getInstance() {
		return instance;
	}
	public ArrayList<AddrDTO> selectS(){
		return dao.select();
	}
	public void insertS(AddrDTO dto) {
		dao.insert(dto);
	}
	public void deleteS(int seq) {
		dao.delete(seq);
	}
}
