package com.Learning.Event.DAO;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Learning.Event.Entity.Student;

@Service
public interface DAOStudService {
	
	public boolean addStudent(Student stud);
	public void updateStudent(Student stud);
	public void deleteStudent(int studId);
	public Student getStudent(int studId);
	public List<Student> getAllStudent();
}
