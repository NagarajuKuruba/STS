package com.stc.dao;

import java.util.List;

import com.nt.model.StudentHLO;
import com.stc.dto.Student;

public interface StudentDAO {
	public StudentHLO getStudentWithId(Integer id);
	public List<StudentHLO> getAllStudents();
	public StudentHLO updateStudent(StudentHLO hlo);; 

}
