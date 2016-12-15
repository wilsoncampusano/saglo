package com.gmail.wilsoncampusanojorge;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select u.username, u.password, u.activo from usuario u where u.username=?")
                .authoritiesByUsernameQuery(
                        "select u.username, r.role " +
                                "from usuario_role ur " +
                                "inner join usuario u on ur.usuario_id = u.id " +
                                "inner join role r on ur.role_id = r.id " +
                                "where u.username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .antMatchers("/propietario").access("hasRole('ROLE_PROPIETARIO')")
                .anyRequest().permitAll()
                .antMatchers("/tecnico").access("hasRole('ROLE_TECNICO')")
                .anyRequest().permitAll()
                .antMatchers("/inquilino").access("hasRole('ROLE_INQUILINO')")
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf();
    }
}