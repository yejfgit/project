package com.mvc.service;

import java.util.List;

import com.mvc.entity.Student;

public interface IStudentService {
	public List<Object> getStudentList();

	public void save(Student st);

	public void delete(Object obj);
}
