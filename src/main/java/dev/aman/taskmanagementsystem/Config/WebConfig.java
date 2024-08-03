//package dev.aman.taskmanagementsystem.Config;
//
//import dev.aman.taskmanagementsystem.Interceptor.AuthHttpInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    private final AuthHttpInterceptor authHttpInterceptor;
//
//    public WebConfig(AuthHttpInterceptor authHttpInterceptor) {
//        this.authHttpInterceptor = authHttpInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authHttpInterceptor);
//    }
//}
