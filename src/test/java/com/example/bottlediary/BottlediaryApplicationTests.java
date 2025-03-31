package com.example.bottlediary;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@Disabled("CI/CD 도입 전까지 임시 비활성화")
class BottlediaryApplicationTests {

	@Test
	void contextLoads() {
	}

}
