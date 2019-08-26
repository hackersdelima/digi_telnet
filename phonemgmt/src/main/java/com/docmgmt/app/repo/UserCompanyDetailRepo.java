package com.docmgmt.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docmgmt.app.entity.UserCompanyDetail;

@Repository
public interface UserCompanyDetailRepo extends JpaRepository<UserCompanyDetail, Integer> {

	public UserCompanyDetail getUsernameById(int id);
}
