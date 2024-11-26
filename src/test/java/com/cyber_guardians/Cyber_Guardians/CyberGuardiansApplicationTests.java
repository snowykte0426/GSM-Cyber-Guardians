package com.cyber_guardians.Cyber_Guardians;

import com.cyber_guardians.Cyber_Guardians.Service.PasswordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CyberGuardiansApplicationTests {

	@Autowired
	private PasswordService passwordService;

	@Test
	void contextLoads() {
		String crackingTime = "5 months and 10 days";
		String strength = passwordService.determineStrengthByTime(crackingTime);
		System.out.println("Strength: " + strength);
	}
}
