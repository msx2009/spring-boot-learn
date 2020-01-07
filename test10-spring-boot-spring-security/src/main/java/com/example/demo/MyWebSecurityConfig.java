package com.example.demo;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("root").password("123456").roles("ADMIN","DBA")
		.and()
		.withUser("admin").password("123456").roles("ADMIN","USER")
		.and()
		.withUser("sang").password("123456").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //开启HttpSecurity配置
			.antMatchers("/admin/**")
			.hasRole("ADMIN")
			
			.antMatchers("/user/**")
			.access("hasAnyRole('ADMIN','USER')")
			
			.antMatchers("/db/**")
			.access("hasRole('ADMIN') and hasRole('DBA')")
			
			.anyRequest()
			.authenticated()
			.and()
			
			//.formLogin()
			///.loginProcessingUrl("/login") //登录接口是login
			//.permitAll() //和登录相关的不需要认证
			//.and()
			
			//.csrf()  //关闭csrf
			//.disable(); //关闭csrf
			.formLogin()
			//.loginPage("/login_page")
			.loginProcessingUrl("/login")
			.usernameParameter("name")
			.passwordParameter("passwd")
			.successHandler(new AuthenticationSuccessHandler() {
				
				@Override
				public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp,
						Authentication auth) throws IOException, ServletException {
					// TODO Auto-generated method stub
					Object principal = auth.getPrincipal();
					resp.setContentType("application/json;charset=utf-8");
					PrintWriter out = resp.getWriter();
					resp.setStatus(200);
					
					Map<String, Object> map = new HashMap<>();
					map.put("status", 200);
					map.put("msg",principal);
					
					ObjectMapper om = new ObjectMapper();
					out.write(om.writeValueAsString(map));
					out.flush();
					out.close();
							
					
				}
			})
			.failureHandler(new AuthenticationFailureHandler() {
				
				@Override
				public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp,
						AuthenticationException e) throws IOException, ServletException {
					// TODO Auto-generated method stub
					resp.setContentType("application/json;charset=utf-8");
					PrintWriter out = resp.getWriter();
					resp.setStatus(401);
					Map<String, Object> map = new HashMap<>();
					map.put("status",401);
					if (e instanceof LockedException) {
						map.put("msg","账户被锁定,登录失败");
					} else if (e instanceof BadCredentialsException){
						map.put("msg","用户名或密码错误，登录失败");
					} else if (e instanceof DisabledException) {
						map.put("msg","用户锁定");
					}
					
					ObjectMapper om = new ObjectMapper();
					out.write(om.writeValueAsString(map));
					out.flush();
					out.close();
					
						
				}
			})
			.permitAll()
			.and()
			.csrf()  //关闭csrf
			.disable(); //关闭csrf
	}
	
}

