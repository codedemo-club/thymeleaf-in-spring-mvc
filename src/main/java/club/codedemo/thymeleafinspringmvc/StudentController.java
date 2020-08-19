package club.codedemo.thymeleafinspringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
@RequestMapping("student")
public class StudentController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/student/success").setViewName("student/success");
    }

    @GetMapping("add")
    String add() {
        return "student/add";
    }

    @PostMapping("save")
    String save(@Valid Student student, BindingResult errors) {
        if (errors.hasErrors()) {
            return "student/add";
        }

        return "redirect:/student/success";
    }

    @ModelAttribute(value = "student")
    public Student newStudent() {
        return new Student();
    }
}
