package com.test.responsetimedatabase.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
public class ExecuteQueryService {
	
	private static final String COUNT = "count";
	private static final Pattern PATTERN = Pattern.compile(".+?from\\s(.+?)(\\s.*)?$");
	
	//valor recebido por parametro ou setado por variavel de ambiente
	@Value("${bd.query}")
	private String query;

	public void execute(JdbcTemplate jdbcTemplate) {
		StopWatch stopWatch = new StopWatch();

		try {
			String tableName = getTableName();
			System.out.println("Realizando consulta na tabela " + tableName);
			
			stopWatch.start();
			Object result = executeQuery(jdbcTemplate);
			stopWatch.stop();
			System.out.println("Tempo total: " + stopWatch.getTotalTimeMillis() + " m/s");
			
			if (result instanceof List<?>)
				System.out.println("Qtde de registros na " + tableName + " = " + getAmountRows(result));
			else 
				System.out.println("Qtde de registros na " + tableName + " = " + (Integer) result);
				
		} catch (Exception e) {
			System.out.println("Algo deu errado! " +  e.getMessage());
			e.printStackTrace();
		}
	}
	
	private int getAmountRows(Object result) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> queryForList = (List<Map<String, Object>>) result;
		return queryForList.size();
	}

	private Object executeQuery(JdbcTemplate jdbcTemplate) {
		if (this.query.contains(COUNT))
			return jdbcTemplate.queryForObject(this.query, Integer.class);
		else 
			return jdbcTemplate.queryForList(this.query);
	}
	
	private String getTableName() {
		Optional<String> value = Optional.ofNullable(this.query)
				.map(PATTERN::matcher)
				.filter(Matcher::find)
				.map(matcher -> matcher.group(1));

		if (value.isPresent()) 
			return value.get();
		
		throw new IllegalArgumentException("Invalid Query");
	}
}
