package com.docmgmt.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docmgmt.app.entity.Office;
import com.docmgmt.app.entity.Staffs;

@Repository
public interface StaffsRepo extends JpaRepository<Staffs, String>{
	public List<Staffs> findByOffice(Office office);

}
