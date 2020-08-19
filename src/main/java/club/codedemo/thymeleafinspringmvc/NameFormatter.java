package club.codedemo.thymeleafinspringmvc;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * 名称首写字大写转换器
 */
public class NameFormatter implements Formatter<String> {

    @Override
    public String parse(String s, Locale locale) throws ParseException {
        if (s != null && !s.isEmpty()) {
            return s.toUpperCase().charAt(0) + s.substring(1);
        }

        return "";
    }

    @Override
    public String print(String s, Locale locale) {
        return s;
    }
}
