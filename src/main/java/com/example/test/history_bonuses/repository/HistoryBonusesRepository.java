package com.example.test.history_bonuses.repository;

import com.example.test.history_bonuses.HistoryBonuses;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HistoryBonusesRepository extends JpaRepository<HistoryBonuses, Long> {
	/*
	@Query(value = "select * from "
			+ "       from history_bonuses hb join acct.department dept join acct.investigator invest join acct.accountCPC acp\r\n"
			+ "       where acct.nInstID= :instId\r\n"
			+ "       order by acct.sclientacctid", nativeQuery = true)
    public List createNoteFromTimePeriod(@Param("first_date") Date first_date, @Param("last_date") Date last_date, @Param("manager_id") Long manager_id);
    */
	
	@Query(value = "select * from history_bonuses"
			+ "where manager_id = :manager_id", nativeQuery = true)
	List<HistoryBonuses> findByManagerId(@Param("manager_id") Long manager_id);
	
	
	@Query(value = "select sum(reward) from history_bonuses"
			+ "where manager_id = :manager_id", nativeQuery = true)
	int sumRewardByManagerId(@Param("manager_id") Long manager_id);

}
