package com.docmgmt.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docmgmt.app.entity.StaffsFamily;

@Repository
public interface StaffsFamilyRepo extends JpaRepository<StaffsFamily, Integer>{

}
