package com.csi.dao;

import com.csi.model.Student;
import com.csi.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentDao {
@Autowired
    StudentRepo studentRepo;

    public Student savedata(Student student) {
        return studentRepo.save(student);
    }
    public List<Student>getAllData(){
        return studentRepo.findAll();
    }
    public Optional<Student> getDataById(long studId){
        return studentRepo.findById(studId);
    }
      public  Student updateData(Student student){
        return  studentRepo.save(student);
     }
      public  void deleteData(long studId){
        studentRepo.deleteById(studId);
    }
}
