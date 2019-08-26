package com.docmgmt.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docmgmt.app.entity.LoginHistoryManagement;

@Repository
public interface LoginHistoryManagementRepo extends JpaRepository<LoginHistoryManagement, Integer>{

}
