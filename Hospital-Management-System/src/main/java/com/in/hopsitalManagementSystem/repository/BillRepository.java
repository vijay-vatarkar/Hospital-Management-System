package com.in.hopsitalManagementSystem.repository;

import com.in.hopsitalManagementSystem.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

}
