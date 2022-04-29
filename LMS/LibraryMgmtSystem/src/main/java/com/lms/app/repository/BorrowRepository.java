package com.lms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.app.entity.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

}
