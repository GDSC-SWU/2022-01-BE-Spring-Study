package com.testSpring.domain.user;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MembersRepositoryTest {

    @Autowired
    MembersRepository membersRepository;

    @After
    public void cleanup() {
        membersRepository.deleteAll();
    }

    @Test
    public void info_print() {
        String id = "테스트 아이디";
        String pass = "테스트 비밀번호";
        String name = "테스트 이름";
        String email = "테스트 이메일";
        String regist_day = "테스트 날짜";
        int point = 10;

        membersRepository.save(Members.builder()
                .id(id)
                .pass(pass)
                .name(name)
                .email(email)
                .regist_day(regist_day)
                .point(point)
                .build());

        List<Members> membersList = membersRepository.findAll();

        Members members = membersList.get(0);
        assertThat(members.getId()).isEqualTo(id);
        assertThat(members.getPass()).isEqualTo(pass);
        assertThat(members.getName()).isEqualTo(name);
        assertThat(members.getEmail()).isEqualTo(email);
        assertThat(members.getRegist_day()).isEqualTo(regist_day);
        assertThat(members.getPoint()).isEqualTo(point);
    }
}
