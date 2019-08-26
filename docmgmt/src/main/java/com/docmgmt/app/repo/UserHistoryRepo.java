package com.docmgmt.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docmgmt.app.entity.UserHistory;

@Repository
public interface UserHistoryRepo extends JpaRepository<UserHistory,Integer> {

}
