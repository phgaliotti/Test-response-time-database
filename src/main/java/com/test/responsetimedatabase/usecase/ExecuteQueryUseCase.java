package com.test.responsetimedatabase.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.responsetimedatabase.dbconfiguration.DataBaseConfiguration;
import com.test.responsetimedatabase.service.ExecuteQueryService;

@Component
public class ExecuteQueryUseCase {

	@Autowired
	private ExecuteQueryService executeQueryService;
	
	@Autowired
	private DataBaseConfiguration dataBaseConfiguration;

	public void execute() {
		executeQueryService.execute(dataBaseConfiguration.getJdbcTemplate());
	}
	
}
