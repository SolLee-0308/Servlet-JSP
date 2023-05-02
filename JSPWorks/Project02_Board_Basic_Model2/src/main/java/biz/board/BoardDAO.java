package biz.board;
// 회원 비즈니스 로직 처리 DAO

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import biz.common.JDBCConnection;

public class BoardDAO {
	// #1. 새 글 등록
	// DB
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	public int addBoard(BoardVO vo) {
		int cnt = 0;
		try {
			// 0. DB 연결
			conn = JDBCConnection.getConnection();
			// 1. sql
			String sql = "INSERT INTO b_board (seq, title, nickname, content) VALUES ((SELECT nvl(MAX(seq),0)+1 FROM b_board),?,?,?);";			
			// 2. PreparedStatement
			stmt = conn.prepareStatement(sql);
			// 3. ? mapping
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getNickname());
			stmt.setString(3, vo.getContent());
			// 4. 실행
			cnt = stmt.executeUpdate(); // cnt 잊어버리지 말기!
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.close(stmt, conn);
		}
		
		return 0;
	}
}

