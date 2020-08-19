package club.codedemo.thymeleafinspringmvc;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * 学生实体 转换器
 */
public class StudentFormatter implements Formatter<Student> {

    /**
     * 将字符串转换为Student实体
     * 本例中未使用该方法，直接抛出异常
     *
     * @param text   字符器
     * @param locale 地区
     * @return
     * @throws ParseException
     */
    @Override
    public Student parse(String text, Locale locale) throws ParseException {
        throw new RuntimeException("方法未实现");
    }

    /**
     * 将学生实体转为输出的字符串
     * @param student 学生
     * @param locale 地区
     * @return
     */
    @Override
    public String print(Student student, Locale locale) {
        return student.getId().toString() + "-" + (student.getSex() ? "男" : "女") + "-" + student.getName();
    }
}
