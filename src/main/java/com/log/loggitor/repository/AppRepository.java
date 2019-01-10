package com.log.loggitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.log.loggitor.domain.App;

public interface AppRepository extends CrudRepository<App, Long>{
	@Query(value="SELECT * FROM APP a WHERE a.App_Name=?1",nativeQuery=true)
		List<App> findByAppName(String appName);
	@Query(value="select a.App_Name,d.error_code as defect_num, concat((count(a.App_Name)*100/ (SELECT count(*) from App)),' %') as def" + 
			"			from Defects d,App a, Defect_Instance di" + 
			"			where a.AppID=di.AppID and di.Def_id=d.Def_id" + 
			"			group by a.App_Name,d.error_code",nativeQuery=true)
	List<App> DefectsByApp();
}
