package com.greedy.member.model.service;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.commit;
import static com.greedy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.greedy.member.model.dao.MemberDAO;
import com.greedy.member.model.dto.MemberDTO;

public class MemberService {
	
	private MemberDAO memberDAO = new MemberDAO();

	public boolean creatNewMember(MemberDTO member) {
		
		Connection con = getConnection();
		
		int result = memberDAO.insertNewMember(con, member);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result > 0? true: false;
	}
	
	public List<MemberDTO> findAllMember(){
		
		Connection con = getConnection();
		
		List<MemberDTO> memberList = memberDAO.selectMemberList(con);
		
		close(con);
		
		return memberList;
	}
	
	public MemberDTO findIdMember(String id) {
		
		Connection con = getConnection();
		
		MemberDTO memberId = memberDAO.selectById(con, id);
				
		close(con);
		
		return memberId;
	}

	public List<MemberDTO> findGenderMember(String gender) {
		
		Connection con = getConnection();
		
		List<MemberDTO> memberGender = memberDAO.selectByGender(con, gender);
		
		close(con);
		
		return memberGender;
	}

	public boolean updatePwdMember(String memberId, String password) {

		Connection con = getConnection();
		
		int result = memberDAO.updatePwdMember(con, memberId, password);

		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return false;
	}
	
public boolean updateEmailMember(String memberId, String email) {
		
		Connection con = getConnection();
		
		int result = memberDAO.updateEmailMember(con, memberId, email);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result > 0? true: false;
	}

	public boolean updatePhoneMember(String memberId, String phone) {
		
		Connection con = getConnection();
		
		int result = memberDAO.updatePhoneMember(con, memberId, phone);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result > 0? true: false;
	}

	public boolean updateAddressMember(String memberId, String address) {
		
		Connection con = getConnection();
		
		int result = memberDAO.updateAddressMember(con, memberId, address);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result > 0? true: false;
	}

	public boolean deleteIdMember(String memberId) {
		
		Connection con = getConnection();
		
		int result = memberDAO.deleteIdMember(con, memberId);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result > 0? true: false;
	}

}
