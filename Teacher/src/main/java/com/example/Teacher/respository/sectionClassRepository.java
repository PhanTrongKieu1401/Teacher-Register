package com.example.Teacher.respository;

import com.example.Teacher.entities.SectionClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface sectionClassRepository extends JpaRepository<SectionClass,Integer> {
    @Query(value = "select s from SectionClass s where s.subjectOfSemester.id = :idSoS")
    List< SectionClass > getALLSectionClassByIdSos (int idSoS);

//    @Query(value = "SELECT * FROM sectionclass WHERE NOT EXISTS (SELECT 1 FROM pickedsectionclass WHERE pickedsectionclass.id_section_class = sectionclass.id) LIMIT 1000;", nativeQuery = true)
//    List<SectionClass> findSectionClassesNotPicked();
    @Query("SELECT sc FROM SectionClass sc WHERE NOT EXISTS (SELECT 1 FROM PickedSectionClass psc WHERE psc.sectionClass.id = sc.id)")
    List<SectionClass> findSectionClassesNotPicked();
    
}
