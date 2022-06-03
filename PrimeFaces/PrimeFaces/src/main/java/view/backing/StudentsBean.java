/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.backing;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author student
 */
@Named(value="studentBean")
@RequestScoped
public class StudentsBean {
    private List<Student> students = new ArrayList<>();
    
    StudentsBean() {
        students.add(new Student("Kamil", "Osak", 4.0));
        students.add(new Student("Jan", "Wolny", 3.4));
        students.add(new Student("Adam", "Mickiewicz", 3.9));
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }
    
    
}