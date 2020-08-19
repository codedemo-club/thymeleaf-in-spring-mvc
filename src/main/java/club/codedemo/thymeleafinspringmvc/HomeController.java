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

/**
 * 首页
 *
 * @author panjie
 */
@Controller
public class HomeController {
    private boolean isChina = true;

    /**
     * 地区Resolover，该Resolover于SpringWebConfig注入
     */
    @Autowired
    LocaleResolver localeResolver;

    /**
     * 首页，添加10个学生
     *
     * @param model V层模型
     * @return
     */
    @RequestMapping
    public String home(Model model) {

        model.addAttribute("currentUser", "zhangsan");

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student(Long.valueOf(i), "name" + i, i % 2 == 0));
        }
        model.addAttribute("students", students);

        return "home";
    }

    /**
     * 完成从美国到中国、中国到美国的地区切换
     *
     * @param request  请求
     * @param response 响应
     * @return
     */
    @RequestMapping("toggleLocale")
    public String toggleLocale(HttpServletRequest request, HttpServletResponse response) {
        if (isChina) {
            localeResolver.setLocale(request, response, Locale.CHINA);
            isChina = false;
        } else {
            localeResolver.setLocale(request, response, Locale.US);
            isChina = true;
        }
        return "redirect:/";
    }
}
