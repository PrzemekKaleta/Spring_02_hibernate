package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.StudentGroupDAO;
import pl.coderslab.entity.Student;
import pl.coderslab.entity.StudentGroup;
import pl.coderslab.entity.StudentNew;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentGroupDAO studentGroupDAO;

    @Autowired
    public StudentController(StudentGroupDAO studentGroupDAO) {
        this.studentGroupDAO = studentGroupDAO;
        StudentGroup studentGroup1 = new StudentGroup();
        StudentGroup studentGroup2 = new StudentGroup();
        studentGroup1.setName("pierwsza grupa");
        studentGroup2.setName("druga grupa");
        studentGroupDAO.save(studentGroup1);
        studentGroupDAO.save(studentGroup2);
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("student", new Student());
        return "/form/student";
    }

    @PostMapping("/form")
    public String form(Model model, @ModelAttribute Student student){
        model.addAttribute("student", student);
        System.out.println(student.toString());
        return "redirect:form";
    }


    @GetMapping("/formNew")
    public String formNew(Model model){
        model.addAttribute("studentNew", new StudentNew());
        return "/form/student2";
    }

    @PostMapping("/formNew")
    public String formNew(Model model, @ModelAttribute StudentNew studentNew){
        model.addAttribute("studentNew", studentNew);
        System.out.println(studentNew.toString());
        return "/form/student2";
    }


    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("programingSkills")
    public List<String> programingSkills() {
        return Arrays.asList("java", "php", "ruby", "python");
    }
    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("bike", "programing", "swimming", "skyjumping");
    }
    @ModelAttribute("groups")
    public Collection<StudentGroup> populateGroups() {

        return studentGroupDAO.findAll();
       // return this.groups.findGroups();
    }
}
