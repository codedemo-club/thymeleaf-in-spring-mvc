package club.codedemo.thymeleafinspringmvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 学生，用于绑定输入项
 * @author panjie
 */
public class Student {

    /**
     * 非空校验
     */
    @NotNull
    private Long id;

    /**
     * 最小、最大长度校验
     */
    @Size(min = 2, max = 30)
    private String name;

    private Boolean sex;

    public Student() {
    }

    public Student(Long id, String name, Boolean sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
