package com.testSpring.web;

import com.testSpring.domain.user.Members;
import com.testSpring.domain.user.MembersRepository;
import com.testSpring.web.dto.MembersSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MembersApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MembersRepository membersRepository;

    @After
    public void tearDown() throws Exception {
        membersRepository.deleteAll();
    }

    @Test
    public void User_등록된다() throws Exception {
        String id = "id";
        String pass = "pass";
        String name = "name";
        String email = "email";
        String regist_day = "regist_day";
        int point = 0;

        MembersSaveRequestDto requestDto = MembersSaveRequestDto.builder()
                .id(id)
                .pass(pass)
                .name(name)
                .email(email)
                .regist_day(regist_day)
                .point(point)
                .build();

        String url = "http://localhost:" + port + "/members";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Members> all = membersRepository.findAll();
        assertThat(all.get(0).getId()).isEqualTo(id);
        assertThat(all.get(0).getName()).isEqualTo(name);
    }
}
