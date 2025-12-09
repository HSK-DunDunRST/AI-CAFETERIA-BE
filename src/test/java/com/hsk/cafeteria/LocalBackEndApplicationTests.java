package com.hsk.cafeteria;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "spring.jpa.hibernate.ddl-auto=none",
        "spring.datasource.url=jdbc:h2:mem:testdb"
})
class LocalBackEndApplicationTests {

	@Test
	void contextLoads() {
	}

}
