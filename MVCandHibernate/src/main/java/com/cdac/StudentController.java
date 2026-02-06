package com.cdac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;

@Controller
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    // -------- REGISTER PAGE --------
    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("student", new Student());
        return "register";  // register.jsp
    }

    // -------- REGISTER ACTION --------
    @PostMapping("/register")
    @Transactional
    public String register(@ModelAttribute Student student, Model model) {
        studentDAO.saveStudent(student);
        model.addAttribute("username", student.getName());
        model.addAttribute("email", student.getEmail());
        return "success";   // success.jsp
    }

    // -------- LOGIN PAGE --------
    @GetMapping("/login")
    public String showLogin() {
        return "login";    // login.jsp
    }

    // -------- LOGIN ACTION --------
    @PostMapping("/login")
    @Transactional
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model) {

        Student student = studentDAO.login(email, password);

        if (student != null) {
            // Login successful: show all students
            model.addAttribute("students", studentDAO.getAllStudents());
            return "viewStudents";  // viewStudents.jsp
        }

        model.addAttribute("error", "Invalid Email or Password");
        return "login";
    }

    // -------- VIEW ALL STUDENTS --------
    @GetMapping("/viewStudents")
    @Transactional
    public String viewStudents(Model model) {
        model.addAttribute("students", studentDAO.getAllStudents());
        return "viewStudents";  // viewStudents.jsp
    }
}
