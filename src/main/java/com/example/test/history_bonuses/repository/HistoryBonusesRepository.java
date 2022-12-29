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
			+ "select acct.sclientacctid,acct.sacctdesc,acct.slocation,invest.sinvestigatorname, dept.sclientdeptid,dept.sdeptname,acp.sccpcode\r\n"
			+ "       from history_bonuses hb join acct.department dept join acct.investigator invest join acct.accountCPC acp\r\n"
			+ "       where acct.nInstID= :instId\r\n"
			+ "       order by acct.sclientacctid", nativeQuery = true)
    public List findByAge(@Param("first_date") Date first_date, @Param("last_date") Date last_date, @Param("manager_id") Long manager_id);
    */

}
