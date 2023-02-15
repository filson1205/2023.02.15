package com.greedy.member.model.dao;

import static com.greedy.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import com.greedy.member.model.dto.MemberDTO;

public class MemberDAO {
	/* 종복되는 내용이 있으면 메소드로 분리 또 다시 중복되면 클래스로 분리  
	 * 기능단위로 구분하고 재사용할떄 구분해서 따로 작성*/

	private Properties prop;

	public MemberDAO() {
		this.prop = new Properties();

		try {
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertNewMember (Connection con, MemberDTO member) {

		String query = prop.getProperty("insertMember");

		System.out.println(query);

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = con.prepareStatement(query);
			//			pstmt.setInt(1, member.getNo());
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getAddress());
			pstmt.setInt(8, member.getAge());
			pstmt.setString(9, member.getEnrollDate());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public List<MemberDTO> selectMemberList(Connection con) {

		Statement stmt = null;
		ResultSet rset = null;
		List<MemberDTO> memberList = null;

		String query = prop.getProperty("selectMemberList");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			memberList = new ArrayList<>();

			while(rset.next()) {

				MemberDTO row = new MemberDTO();

				row.setNo(rset.getInt("MEMBER_NO"));
				row.setId(rset.getString("MEMBER_ID"));
				row.setPwd(rset.getString("MEMBER_PWD"));
				row.setName(rset.getString("MEMBER_NAME"));
				row.setGender(rset.getString("GENDER"));
				row.setEmail(rset.getString("EMAIL"));
				row.setPhone(rset.getString("PHONE"));
				row.setAddress(rset.getString("ADDRESS"));
				row.setAge(rset.getInt("AGE"));
				row.setEnrollDate(rset.getString("ENROLL_DATE"));

				memberList.add(row);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(stmt);
			close(rset);
		}

		return memberList;
	}

	public MemberDTO selectById(Connection con, String id) {

		String query = prop.getProperty("selectById");

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		MemberDTO member = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);

			rset = pstmt.executeQuery();

			while(rset.next()) {

				member = new MemberDTO();

				member.setNo(rset.getInt("MEMBER_NO"));
				member.setId(rset.getString("MEMBER_ID"));
				member.setPwd(rset.getString("MEMBER_PWD"));
				member.setName(rset.getString("MEMBER_NAME"));
				member.setGender(rset.getString("GENDER"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setAge(rset.getInt("AGE"));
				member.setEnrollDate(rset.getString("ENROLL_DATE"));

			} 
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return member;
	}

	public List<MemberDTO> selectByGender(Connection con, String gender) {
		
		String query = prop.getProperty("selectByGender");
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<MemberDTO> memberList = new ArrayList<>();
		
		MemberDTO member = null;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, gender);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {

				member = new MemberDTO();

				member.setNo(rset.getInt("MEMBER_NO"));
				member.setId(rset.getString("MEMBER_ID"));
				member.setPwd(rset.getString("MEMBER_PWD"));
				member.setName(rset.getString("MEMBER_NAME"));
				member.setGender(rset.getString("GENDER"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setAge(rset.getInt("AGE"));
				member.setEnrollDate(rset.getString("ENROLL_DATE"));
				
				memberList.add(member);
				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return memberList;
	}

	public int updatePwdMember(Connection con, String memberId, String password) {
		
		String query = prop.getProperty("updatePwdMember");

		System.out.println(query);

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, password);
			pstmt.setString(2, memberId);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}	
	
	public int updateEmailMember(Connection con, String memberId, String email) {
		String query = prop.getProperty("updateEmailMember");
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updatePhoneMember(Connection con, String memberId, String phone) {
		String query = prop.getProperty("updatePhoneMember");
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, phone);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateAddressMember(Connection con, String memberId, String address) {
		String query = prop.getProperty("updateAddressMember");
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, address);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteIdMember(Connection con, String memberId) {
		String query = prop.getProperty("deleteIdMember");
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
