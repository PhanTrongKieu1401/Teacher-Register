package com.example.Teacher.repository;

import com.example.Teacher.entities.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Teacher.respository.memberRespository;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;



import java.text.ParseException;
import java.text.SimpleDateFormat;


@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private memberRespository respository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCheckLoginMember_ReturnMemberWithValidUsernameAndPassword() throws ParseException {

        Member expectedMember = new Member();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        expectedMember.setAddress("Ha Noi");
        expectedMember.setDateOfBirth(dateFormat.parse("1990-01-01"));
        expectedMember.setName("Nguyen Chien Trinh");
        expectedMember.setEmail("trinhnc@gmail.com");
        expectedMember.setUsername("trinhnc");
        expectedMember.setPassword("trinhnc");
        expectedMember.setPhone("0915400946");

        entityManager.persist(expectedMember);

        String username = "trinhnc";
        String password = "trinhnc";

        Member retrieveMember = respository.checkLogin(username, password);

        Assertions.assertNotNull(retrieveMember);
    }

    @Test
    public void testCheckLoginMember_ReturnNullWithInvalidUsernameAndPassword() throws ParseException {

        Member expectedMember = new Member();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        expectedMember.setAddress("Ha Noi");
        expectedMember.setDateOfBirth(dateFormat.parse("1990-01-01"));
        expectedMember.setName("Pham Ngoc Anh");
        expectedMember.setEmail("anhpn@gmail.com");
        expectedMember.setUsername("anhpn");
        expectedMember.setPassword("anhpn");
        expectedMember.setPhone("0915400946");

        entityManager.persist(expectedMember);

        String username = "trinhnc";
        String password = "123";

        Member retrieveMember = respository.checkLogin(username, password);

        Assertions.assertEquals(null, retrieveMember);
    }

}
