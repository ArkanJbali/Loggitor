package com.log.loggitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.log.loggitor.domain.App;

public interface AppRepository extends CrudRepository<App, Long>{
	@Query(value="SELECT * FROM APP WHERE AppName=?1",nativeQuery=true)
		List<App> findByAppName(String appName);
	@Query(value="select a.app_name,d.error_code as defect_num, "
			+ "(count(a.app_name)*100/ (SELECT count(*) from public.app as aa)) as def\r\n" + 
			"from public.defects as d,public.app as a, defect_instance as di \r\n" + 
			"where a.appid=di.appid and di.def_id=d.def_id\r\n" + 
			"group by a.app_name,d.error_code; ",nativeQuery=true)
	List<App> DefectsByApp();
}
