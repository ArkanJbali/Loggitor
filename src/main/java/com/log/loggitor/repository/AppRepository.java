package com.log.loggitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.log.loggitor.domain.App;

public interface AppRepository extends CrudRepository<App, Long>{
	@Query(value="SELECT *FROM APP WHERE AppName=?1",nativeQuery=true)
		List<App> findByAppName(String appName);
}
