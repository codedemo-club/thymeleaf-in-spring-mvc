package club.codedemo.thymeleafinspringmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class HomeController {
    private boolean isChina = true;
    @Autowired
    LocaleResolver localeResolver;

    private String home(HttpServletRequest request, HttpServletResponse response, Model model) {
        if (isChina) {
            localeResolver.setLocale(request, response, Locale.CHINA);
            isChina = false;
        } else {
            localeResolver.setLocale(request, response, Locale.US);
            isChina = true;
        }

        model.addAttribute("currentUser", "zhangsan");

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student(Long.valueOf(i), "name" + i, i % 2 == 0));
        }
        model.addAttribute("students", students);

        return "home";
    }
}
