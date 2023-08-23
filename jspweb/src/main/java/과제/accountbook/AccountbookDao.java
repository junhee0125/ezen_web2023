package 과제.accountbook;

import java.util.ArrayList;

import model.dao.Dao;

public class AccountbookDao extends Dao{

	//싱글톤
	private static AccountbookDao accountbookDao = new AccountbookDao();
	public static AccountbookDao getInstance() {return accountbookDao; }
	private AccountbookDao() {}
	
	
	
	/**
	* 1. 등록 create
	*/
	public boolean aWrite(AccountbookDto dto) {
		try {
			String sql = "insert into accountbook (atext, anumber) values (?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getAtext());
			ps.setInt(2,dto.getAnumber());
			int  row = ps.executeUpdate();
			if(row ==1) {return true ;}
			
		} catch (Exception e) {
			// TODO: handle exception
		} return false;
	}
	
	
	/**
	*  2. 출력 Read
	*/
	public ArrayList<AccountbookDto> aRead() {
		ArrayList<AccountbookDto> list = new ArrayList<>();
		String sql = "select * from accountbook order by adate desc;";
		System.out.println("dao + aRead()");
		
		try {
			
			ps = conn.prepareStatement(sql);			
			rs= ps.executeQuery();
			while(rs.next()) {
				AccountbookDto dto = new AccountbookDto(
						rs.getInt("ano"),
						rs.getString("atext"),
						rs.getInt("anumber"),
						rs.getString("adate"));
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} return list;
	}
	
	/**
	* 3. 수정 Update
	*/
	public boolean aUpdate(int ano, String atext, int anumber) {
		try {
			String sql = "update accountbook set atext =?,  anumber=? where ano = ?";
			ps = conn.prepareStatement(sql);			
			ps.setString(1, atext);
			ps.setInt(2,anumber);
			ps.setInt(3,ano);
			int  row = ps.executeUpdate();
			if(row ==1) {return true ;}
			
		} catch (Exception e) {
			// TODO: handle exception
		} return false;
	}
	
	/**
	* 4.삭제 Delete
	*/
	public boolean aDelete(int ano) {
		try {
			String sql = "delete from accountbook where ano =?  ";
			ps= conn.prepareStatement(sql);
			ps.setInt(1, ano);
			
			int row = ps.executeUpdate();
			if(row == 1)  {return true;}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return false;
	}	
	
	
	
}
