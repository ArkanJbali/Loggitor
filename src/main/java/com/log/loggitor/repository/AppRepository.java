package com.log.loggitor.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.log.loggitor.domain.App;

public interface AppRepository extends CrudRepository<App, Long>{
	@Query(value="SELECT * FROM APP a WHERE a.App_Name=?1",nativeQuery=true)
		List<App> findByAppName(String appName);
	
	@Query(value="select a.app_name as \"App Name\",count(*) as \"Defect Num\", \r\n" + 
			"concat((count(a.app_name)*100/ (SELECT count(*) from app aa)),' %') as \"Def\"\r\n" + 
			"from defects d,app a, defect_instance di \r\n" + 
			"where a.appid=di.appid and di.def_id=d.def_id\r\n" + 
			"group by a.app_name,d.error_code;",nativeQuery=true)
	<T>List<T> DefectsByApp();
	@Query(value="select d.severity as \"App Severity\",count(*) as \"Defect Num\", \r\n" + 
			"concat((count(d.severity)*100/ (SELECT count(*) from defects dd)),' %') as \"Def\"\r\n" + 
			"from defects d,app a, defect_instance di \r\n" + 
			"where a.appid=di.appid and di.def_id=d.def_id\r\n" + 
			"group by d.severity",nativeQuery=true)
	<T>List<T> DefectsBySeverity();
	@Query(value="select distinct concat(a.app_name,concat(' ',a.app_type)) as \"App\",d.error_code as code,d.severity,\r\n" + 
			"s.solution,s.description \r\n" + 
			"from defects d,app a, defect_instance di, solutions s\r\n" + 
			"where a.appid=di.appid and di.def_id=d.def_id and d.d_sol=s.solutionid;",nativeQuery=true)
	<T> List<T> DefectsLog();
	
}
