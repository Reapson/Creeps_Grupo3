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
public class ProjectConfig implements WebMvcConfigurer {

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
        http
                //                Vistas permitidas para todos los usuarios
                .authorizeHttpRequests((request) -> request
                .requestMatchers(
                        "/css/**",
                        "/js/**",
                        "/images/**",
                        "/webjars/**",
                        "/",
                        "/index",
                        "/login",
                        "/registro/nuevo",
                        "/registro/crearUsuario",
                        "/registro/recordar",
                        "/busqueda",
                        "/busqueda/busqueda",
                        "/busqueda/filtrada",
                        "/busqueda/filtrada/**",
                        "/registro",
                        "/registro/nuevo",
                        "/registro/recordar",
                        "/registro/crearUsuario",
                        "/registro/activacion/**",
                        "/registro/activar",
                        "/registro/recordarUsuario",
                        "/layout/plantilla"
                )
                .permitAll()
                //              Vistas exclusivas para admin
                .requestMatchers(
                        "/admin",
                        "/admin/admin",
                        "/admin/registrarProducto",
                        "/admin/modificarProducto/**",
                        "/admin/guardarProducto",
                        "/admin/eliminarProducto/**"
                ).hasRole("ADMIN")
                //              Vista exclusiva para Users
                .requestMatchers(
                        "/carrito/listado",
                        "/carrito/agregar/**",
                        "/carrito/modificar/**",
                        "/carrito/eliminar/**",
                        "/carrito/guardar",
                        "/facturar/carrito"
                )
                .hasRole("USER")
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                .anyRequest().permitAll() // Permitir acceso a todas las rutas
//                )
//                .formLogin((form) -> form
//                .loginPage("/login").permitAll()
//                )
//                .logout((logout) -> logout.permitAll());
//
//        return http.build();
//    }
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
