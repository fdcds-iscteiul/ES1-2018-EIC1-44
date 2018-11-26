package unittests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import API.API_Message;

class testAPI_Message {

	@Test
	void testAPI_MessageStringString() {
		//fail("Not yet implemented");
		API_Message test = new API_Message("string123", "string456");
	}

	@Test
	void testAPI_MessageStringStringString() {
		//fail("Not yet implemented");
		API_Message test = new API_Message("string123", "string456", "string789");
	}

}
