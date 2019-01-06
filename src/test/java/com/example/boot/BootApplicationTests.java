package com.example.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Test
	public void contextLoads() {
		List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from tb1");
		for (Map<String, Object> map: maps) {
			Iterator<String> iterator = map.keySet().iterator();
			while(iterator.hasNext()){
				String next = iterator.next();
				System.out.println(next + " == " + map.get(next));
			}
		}
		System.out.println(dataSource.getClass());
		try {
			System.out.println(" dataSource ~~~~~~~~~~~~~~~  " + dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
