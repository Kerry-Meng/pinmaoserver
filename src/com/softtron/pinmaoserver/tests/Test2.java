package com.softtron.pinmaoserver.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test2 {

	@Test
	void test() {
		String key = "dateCreated";
		String pattern = "#\\{" + key + "\\}";
		String sql ="		insert into t_news(newstitle,newscontent,createdDate)\r\n" + 
				"		value('我爱你祖国','',#{dateCreated})";
		sql = sql.replaceAll(pattern, "''");
		System.out.println(sql);
	}

}
