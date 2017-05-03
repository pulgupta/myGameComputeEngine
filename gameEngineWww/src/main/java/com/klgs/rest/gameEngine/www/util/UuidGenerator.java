package com.klgs.rest.gameEngine.www.util;

import java.util.UUID;

public class UuidGenerator {

	public static String generateUuid(){
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        System.out.println("Random UUID String = " + randomUUIDString);
        return randomUUIDString;
	}
}

