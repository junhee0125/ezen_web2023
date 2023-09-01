package model.dao;

import model.dto.HrmDto;

public class HrmDao extends Dao{

	//싱글톤
	private static HrmDao hrmDao = new HrmDao();
	public static HrmDao getInstance() {return hrmDao;}
	private HrmDao() {}


	// 등록
	public boolean hrmSave(HrmDto hrmDto) {

		System.out.println("getHname" +hrmDto.getHname() );
		System.out.println("getHphone" +hrmDto.getHphone() );
		System.out.println("getHrank" +hrmDto.getHrank() );
		System.out.println("getHphoto" +hrmDto.getHphoto() );
		try {
			String sql= "insert into hrm(hname, hrank, hphone, hphoto) values (?,?,?,?)";
			ps= conn.prepareStatement(sql);
			ps.setString(1, hrmDto.getHname());
			ps.setString(2, hrmDto.getHrank());
			ps.setString(3, hrmDto.getHphone());
			ps.setString(4, hrmDto.getHphoto());
			int rs = ps.executeUpdate();
			System.out.println("ps:: >>>> "+ps);
			if( rs == 1) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	// 리스트
	public void hrmList() {

	}
}
