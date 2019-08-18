package com.docmgmt.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docmgmt.app.entity.Office;
import com.docmgmt.app.entity.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer>{
	public Users findByUsername(String username);
	public List<Users> findByStaffsOffice(Office office);

}
