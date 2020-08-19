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

/**
 * 学生控制器
 *
 * @author panjie
 */
@Controller
@RequestMapping("student")
public class StudentController implements WebMvcConfigurer {

    /**
     * 注册/student/success地址为响应student/success.html模板信息
     *
     * @param registry 注册商
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/student/success").setViewName("student/success");
    }

    /**
     * 添加学生界面
     *
     * @param student 带入至V层的学生，该方法与在方法中添加如下代码：
     *                model.addAttribute("student", new Student());
     *                起到的作用相同
     * @return
     */
    @GetMapping("add")
    String add(Student student) {
        return "student/add";
    }

    /**
     * 保存学生
     * 发生错误，则调用student/add模板，否则跳转至success
     *
     * @param student 学生
     * @param errors  错误信息
     * @return
     */
    @PostMapping("save")
    String save(@Valid Student student, BindingResult errors) {
        if (errors.hasErrors()) {
            return "student/add";
        }

        // 具体持久化学生的代码略过

        return "redirect:/student/success";
    }

    /**
     * 当V层中出现 th:object="${student}" 字样时
     * 将首先查看对应的控制器的方法是否有student对象可用
     * 如果没有，则会使用本方法返回的student。
     * 所以该方法保证了随时可以在V层中使用th:object="${student}"
     *
     * @return
     */
    @ModelAttribute(value = "student")
    public Student newStudent() {
        return new Student();
    }
}
