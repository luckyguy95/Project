package Alchemystar.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import java.util.Properties;


//문제 생길시 참고 https://www.slipp.net/wiki/pages/viewpage.action?pageId=22282259
@Configuration
public class EmailConfig {
    private final Environment env;

    public EmailConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public MailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("smtp.gmail.com"));
        mailSender.setPort(Integer.parseInt("25"));

        mailSender.setUsername(env.getProperty("alchemystarwiki@gmail.com"));
        mailSender.setPassword(env.getProperty("rk5cma1508&"));
        mailSender.setDefaultEncoding(env.getProperty("utf-8"));
        mailSender.setJavaMailProperties(mailSender.getJavaMailProperties());
        return mailSender;
    }

    //미완?
    private Properties additionalMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.debug", "true");
        return properties;
    }


//    //이부분은 뭔지모름
//    @Bean
//    public FreeMarkerConfigurationFactoryBean freemarkerConfiguration() {
//        FreeMarkerConfigurationFactoryBean freemarkerConfiguration = new FreeMarkerConfigurationFactoryBean();
//        freemarkerConfiguration.setTemplateLoaderPath("classpath:templates");
//        freemarkerConfiguration.setDefaultEncoding("UTF-8");
//        return freemarkerConfiguration;
//    }
}
