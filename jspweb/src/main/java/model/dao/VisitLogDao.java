package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.VisitLogDto;

public class VisitLogDao extends Dao{
	
	//싱글톤 생성
	private static VisitLogDao visitLogDao = new VisitLogDao();
	public static VisitLogDao getInstance() {return visitLogDao ; }
	private VisitLogDao(){}	 
	
	/**
	 * 1. 저장 [인수 : 저장할 내용이 담긴 DTO / 리턴 : 성공/싶패(boolean) = true/false]
	 */
	public boolean vWrite(VisitLogDto VisitLogDto) {
		
		System.out.println("vPost호출");
		
		String sql =" insert into visitlog (vwriter, vpwd, vcontent) values (?,?,?)";
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, VisitLogDto.getVwriter());
			ps.setString(2, VisitLogDto.getVpwd());
			ps.setString(3, VisitLogDto.getVcontent());
			int row = ps.executeUpdate();
			if(row ==1) { return true;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return false;
	}
	
	/**
	 * 2. 호출 [인수 : x  / 리턴 여러개 ArrayList의 Dto]
	 */
	public ArrayList<VisitLogDto> vRead() {
		ArrayList<VisitLogDto> list = new ArrayList<>();
		String  sql = "select * from visitlog order by vdatetime desc";
		
		try {
			ps= conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				VisitLogDto visitLogDto = new VisitLogDto(
						
					rs.getInt(1), 		//rs.getInt("vno");
					rs.getString(2), 	//rs.getInt("vwriter");
					rs.getString(3), 	//rs.getInt("vpwd");
					rs.getString(4), 	//rs.getInt("ycontent");
					rs.getString(5));	//rs.getInt("vdatetime");
				
				list.add(visitLogDto);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	/**
	 * 3.수정 [인수 : 수정할 방문록번호 int / 수정할방문록내용 (String) / 리턴 : 성공/싶패(boolean) = true/false]
	 */
	public int vUpdate(int vno, String vcontent, String vpwd) {
		
		try {
			String sq1 = "update visitlog set vcontent = ? , vdatetime = now() where vno =? and vpwd =?";
			ps= conn.prepareStatement(sq1);
			ps.setString(1, vcontent);
			ps.setInt(2, vno);
			ps.setString(3, vpwd);
			int row = ps.executeUpdate();
			if(row ==1 || row==0) {return row;}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		 return 2;
			
	}
	
	
	
	/**
	 * 4. [인수 : 삭제할 번호(int) / 수정할방문록내용 (String) 리턴 : 성공/싶패(boolean) = true/false] 
	 */
	public int vDelete(int vno, String vpwd) {
	
		try {
			String sql = "delete from visitlog where vno =? and vpwd =? ";
			ps= conn.prepareStatement(sql);
			ps.setInt(1, vno);
			ps.setString(2, vpwd);
			int row = ps.executeUpdate();
			if(row == 0)  {return 0;}
			if(row == 1)  {return 1;}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return 2;
			
	}
}
