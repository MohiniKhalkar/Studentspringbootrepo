package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Student;
import com.csi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentServiceImpl;
    @PostMapping("/savedata")
    public ResponseEntity<Student>saveData(@RequestBody Student student){
        return ResponseEntity.ok(studentServiceImpl.savedata(student));
    }
    @GetMapping("/getalldata")
     public ResponseEntity<List<Student>>getAllData()  {
        return ResponseEntity.ok(studentServiceImpl.getAllData());
    }
@GetMapping("getdatabyid/{studId}")
public ResponseEntity<Optional<Student>> getDataById(@PathVariable long studId){
        return ResponseEntity.ok(studentServiceImpl.getDataById(studId));
}
@PutMapping("updatedata/{studId}")
    public ResponseEntity<Student>updateData(@PathVariable long studId,@RequestBody Student student) throws RecordNotFoundException {
       Student student1=studentServiceImpl.getDataById(studId).orElseThrow(()->new RecordNotFoundException("Student Id does not exit"));

       student1.setStudName(student.getStudName());
       student1.setStudAddress(student.getStudAddress());
       student1.setStudDOB(student.getStudDOB());
       student1.setStudContactNumber(student.getStudContactNumber());
       student1.setStudContactNumber(student.getStudContactNumber());


        return ResponseEntity.ok(studentServiceImpl.updateData(student1));
}
@DeleteMapping("deletedata/{studId}")
    public ResponseEntity<String>deleteDataById(@PathVariable long studId){
        studentServiceImpl.deleteData(studId);
        return ResponseEntity.ok("Data Deleted successfully");
}
@GetMapping
        public String sayHello(){
            return "WELCOME TO CSI";

}
//creating API for msg
@GetMapping("/say")
    public String hello(){
        return "Full Stack";
}
}
