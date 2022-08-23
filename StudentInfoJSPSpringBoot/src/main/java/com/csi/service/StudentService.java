package com.csi.service;

import com.csi.dao.StudentDao;
import com.csi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;

    public Student savedata(Student student) {
        return studentDao.savedata(student);
    }
    public List<Student> getAllData(){
        return studentDao.getAllData();
    }
    public Optional<Student> getDataById(long studId){
        return studentDao.getDataById(studId);
    }
    public  Student updateData(Student student){
        return  studentDao.updateData(student);
    }
    public  void deleteData(long studId){
        studentDao.deleteData(studId);
    }
}
