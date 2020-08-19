package club.codedemo.thymeleafinspringmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * 配置类
 *
 * @author panjie
 */
@Configuration
public class SpringWebConfig implements WebMvcConfigurer {

    /**
     * 注册Student转换器
     *
     * @param registry 转换器注册商
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new StudentFormatter());
    }

    /**
     * 注入LocaleResolver，默认值设置为美国
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

    /**
     * 手动注册多国语言文件messages
     * Spring Boot其实已经默认注册了messages，所以删除该方法后不会对应用造成影响
     * 在此的代码仅做演示用
     *
     * @return
     */
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
