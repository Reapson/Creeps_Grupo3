package com.creeps;

//Se llaman todas los import que son los que estan relacionados a la configuracion de la pagina
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

//Archivo de configuracion
@Configuration
public class ProjectConfig implements WebMvcConfigurer{
   
    /* localeResolver se utiliza para crear una sesión de cambio de idioma*/ 
    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }
    
    /* localeChangeInterceptor se utiliza para crear un interceptor de cambio de idioma*/ 
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());
    }
    
         //Bean para poder acceder a los Messages.properties en código...     
    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }      
    
//    --------------------------------------
//    SEGURIDAD
//    --------------------------------------
    
//    Permiten manejar rutas sin necesidad de utilizar un controlador
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
 }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
<<<<<<< HEAD
    http
        .authorizeHttpRequests((requests) -> requests
            .anyRequest().permitAll() // Permitir acceso a todas las rutas
        )
        .formLogin((form) -> form
            .loginPage("/login").permitAll()
        )
        .logout((logout) -> logout.permitAll());
    
    return http.build();
}
=======
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/", "/index", "/errores/**",
                        "/carrito/**", "/busqueda/**", "/reportes/**",
                        "/registro/**", "/js/**", "/webjars/**", "/imagenes/**",
                        "/categorias/**", "/carrito/**", "/pruebas/**", "/reportes/**",
                        "/registro/**", "/js/**", "/webjars/**")
                .permitAll() //todos los roles van a tener acceso a las vistas que estan arriba
                .requestMatchers(
                        "/producto/nuevo", "/producto/guardar",
                        "/producto/modificar/**", "/producto/eliminar/**",
                        "/categoria/nuevo", "/categoria/guardar",
                        "/categoria/modificar/**", "/categoria/eliminar/**",
                        "/usuario/nuevo", "/usuario/guardar",
                        "/usuario/modificar/**", "/usuario/eliminar/**",
                        "/reportes/**"
                ).hasRole("ADMIN") //Todas las listas que estan en el apartado de arriba lsa puede ver el admin
                .requestMatchers(
                        "/producto/listado",
                        "/usuario/listado"
                ).hasAnyRole("ADMIN", "VENDEDOR") // Todas las vistas que estan arriba las pueden ver un admin o un vendedor
                .requestMatchers("/facturar/carrito")
                .hasRole("USER") // El rol user solo puede ver la vista carrito (tenga acceso/request)
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }
>>>>>>> 9a2cdd1a3f71999b3ea5785078a09678f4f8eb10
    
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
