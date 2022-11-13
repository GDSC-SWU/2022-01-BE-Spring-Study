package com.min.study.config.auth;

import com.min.study.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정들을 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() //h2-console 화면을 사용하기 위해 해당 옵션들을 disable함
                .and()
                    .authorizeRequests() //URL별 권한 관리를 설정하는 옵션의 시작
                    .antMatchers("/", "/css/**", "/images/**", //권한 관리 대상을 지정하는 옵션
                            "/js/**", "/h2-console/**").permitAll()//전체 열람 권한
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())//USER 권한만 가능
                    .anyRequest().authenticated() //설정된 값들 이외의 URL들은 인증된 사용자들에게만 허용
                .and()
                    .logout()
                        .logoutSuccessUrl("/") //로그아웃 성공시 / 주소로 이동
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService); //소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록
    }
}
