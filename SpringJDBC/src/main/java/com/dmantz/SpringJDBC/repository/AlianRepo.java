package com.dmantz.SpringJDBC.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dmantz.SpringJDBC.model.Alian;
@Repository
public interface AlianRepo {
	public void save(Alian alian);
	public List<Alian> findAll();
	public Alian getById(int id);
	public String updateById(int id);
	public String deleteById(int id);

}
