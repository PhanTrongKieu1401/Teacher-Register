package com.example.Teacher.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.Teacher.entities.Member;
import com.example.Teacher.entities.Staff;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest(showSql = false)
public class StaffRepositoryTest {

	@Autowired
	private com.example.Teacher.respository.staffRepository staffRepository;

	@Autowired
	private TestEntityManager entityManager;

	//Tìm kiếm staff theo id member có tồn tại
	@Test
	@DisplayName("Tìm kiếm staff chuẩn")
	public void testFindStaffStandard() {
		int idMemberTest = 1;

		Member expectedMember = new Member();
		entityManager.persist(expectedMember);

		Staff expectedStaff = new Staff();
		expectedStaff.setIdMenber(1);
		expectedStaff.setPosition("Truong bo mon");
		expectedStaff.setMember(expectedMember);

		entityManager.persist(expectedStaff);

		Staff actualStaff = staffRepository.findStaff(idMemberTest);

		Assertions.assertEquals(expectedStaff.getIdMenber(), actualStaff.getIdMenber());
		Assertions.assertEquals(expectedStaff.getPosition(), actualStaff.getPosition());
		Assertions.assertEquals(expectedStaff.getMember(), actualStaff.getMember());
	}

	//Tìm kiếm staff theo id member không tồn tại
	@Test
	@DisplayName("Tìm kiếm staff ngoại lệ")
	public void testFindStaffException() {
		int idMemberTest = 1; //Lí do điển 1 là vì Staff không tự tăng id, khi thêm vào mặc định là 0 nếu không set

		Member expectedMember = new Member();
		entityManager.persist(expectedMember);
		Staff expectedStaff = new Staff();
		expectedStaff.setMember(expectedMember);
		entityManager.persist(expectedStaff);

		Staff actualStaff = staffRepository.findStaff(idMemberTest);

		Assertions.assertNull(actualStaff);
	}

	@Test
	@DisplayName("Bắt ngoại lệ")
	public void testFindSectionClassesNotPickedException() {
		Member expectedMember = new Member();
		entityManager.persist(expectedMember);
		Staff expectedStaff = new Staff();
		expectedStaff.setMember(expectedMember);
		entityManager.persist(expectedStaff);

		assertThrows(Exception.class, () -> {
			staffRepository.findStaff(1);
		});
	}
}
