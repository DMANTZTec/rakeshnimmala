package com.dmantz.SpringJDBC.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dmantz.SpringJDBC.model.Alian;

@Repository
public class AlianRepoimpl implements AlianRepo {
	
	private  JdbcTemplate jdbcTemplate;
	
	public  AlianRepoimpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}

	@Override
	public void save(Alian alian) {
	String query="insert into alian(name,tech) values(?,?)";
	jdbcTemplate.update(query,alian.getName(),alian.getTech());
	}

	@Override
	public List<Alian> findAll() {
		
		String sql="select * from alian";
		return jdbcTemplate.query(sql, new AlianRowMapper());
		
		
	}
	
	private static class AlianRowMapper implements RowMapper<Alian> {

		@Override
		public Alian mapRow(ResultSet rs, int rowNum) throws SQLException {
			Alian alian=new Alian();
			alian.setId(rs.getInt("id"));
			alian.setName(rs.getString("name"));
			alian.setTech(rs.getString("tech"));
			return alian;
		}
		
	}

	@Override
	public Alian getById(int id) {
		String sql="select * from alian where id=?";
		return jdbcTemplate.queryForObject(sql, new  AlianRowMapper(), id);
		 	}

	@Override
	public String updateById(int id) {
		String sql="update alian set name=? where id=?";
		
		int result= jdbcTemplate.update(sql, "Rakesh",id);
		if(result!=0) {
			return "Alian Updated Successfully";
		}
		else {
			return "Alian not present in database";
		}
	}

	@Override
	public String deleteById(int id) {
		
		String sql ="delete from alian where id=?";
		int result=jdbcTemplate.update(sql,id);
		
		if(result!=0) {
			return "Alian Deleted Successfully";
		}
		else {
			return "Alian not Present dataBasae";
		}
		
	}
	
	

}
