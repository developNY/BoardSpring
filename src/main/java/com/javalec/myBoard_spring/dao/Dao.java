package com.javalec.myBoard_spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.myBoard_spring.dto.Dto;
import com.javalec.myBoard_spring.util.Constant;

public class Dao {

	DataSource dataSource;
	JdbcTemplate template = null;
	
	public Dao(){
		
		template = Constant.template;
	}
	
	public void delete(final String bId) {
		// TODO Auto-generated method stub
		
			String query = "delete from board where bId = ?";
			template.update(query, new PreparedStatementSetter(){

				@Override
				public void setValues(PreparedStatement pstmt) throws SQLException {
					// TODO Auto-generated method stub
					pstmt.setInt(1, Integer.parseInt(bId));
					//bId는 final로 해줘야 에러가 발생하지 않음. 변하지 않도록 설정해줘야하기때문.
				}
			});
	}
			
	public Dto contentView(String strId) {
		// TODO Auto-generated method stub
		
		upHit(strId);
		String query = "select * from board where bId = " + strId;
		return template.queryForObject(query, new BeanPropertyRowMapper<Dto>(Dto.class));

	}

	public ArrayList<Dto> list() {
		// TODO Auto-generated method stub
		
			String query = "select * from board";
			return (ArrayList<Dto>) template.query(query, new BeanPropertyRowMapper<Dto>(Dto.class));
	}

	public void modify(final String bId, final String name, final String title, final String content) {
		// TODO Auto-generated method stub
		
		String query = "update board set name = ?, title = ?, content = ? where bId = ?";
		template.update(query, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				
				pstmt.setString(1, name);
				pstmt.setString(2, title);
				pstmt.setString(3, content);
				pstmt.setInt(4, Integer.parseInt(bId));
			}
		});
	}
	
	public void write(final String name, final String title, final String content) {
		// TODO Auto-generated method stub
		
		String query = "insert into board (name, title, content, hit) values (?, ?, ?, 0)";
		template.update(query, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub

				pstmt.setString(1, name);
				pstmt.setString(2, title);
				pstmt.setString(3, content);
			}
		});
	}

	private void upHit(final String bId){
		String query = "update board set hit = hit + 1 where bId = ?";
		template.update(query, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				
				pstmt.setString(1, bId);
			}
		});
	}
}
