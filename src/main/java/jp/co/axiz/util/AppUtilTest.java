package jp.co.axiz.util;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import app.App;

class AppUtilTest extends AppUtil{
	String test;
	boolean correct;
	String result;
	@Test
	void card_isGameApp() {
		String test= "card";
		correct = true;
		App app = tryMethod(test);
		assertEquals(correct,  isGameApp(app));
	}
	
	@Test
	void cards_isGameApp() {
		 test= "cards";
		correct = false;
		App app = tryMethod(test);
		assertEquals(correct, isGameApp(app));
	}
	
	@Test
	void none_isGameApp() {
		 test= "";
		correct = false;
		App app = tryMethod(test);
		assertEquals(correct, isGameApp(app));
	}
	
	@Test
	void card_isCardGameApp() {
		 test= "card";
		correct = true;
		App app = tryMethod(test);
		assertEquals(correct, isCardGameApp(app));
	}
	
	@Test
	void clock_isCardGameApp() {
		 test= "cards";
		correct = false;
		App app = tryMethod(test);
		assertEquals(correct, isCardGameApp(app));
	}
	
	@Test
	void app_isCardGameApp() {
		 test= "cards";
		correct = false;
		App app = tryMethod(test);
		assertEquals(correct, isCardGameApp(app));
	}
	
	@Test
	void darts_isDartsGameApp() {
		 test= "darts";
		correct = true;
		App app = tryMethod(test);
		assertEquals(correct, isDartsGameApp(app));
	}
	
	@Test
	void none_isDartsGameApp() {
		 test= "";
		correct = false;
		App app = tryMethod(test);
		assertEquals(correct, isDartsGameApp(app));
	}
	
	@Test
	void card_isDartsGameApp() {
		test= "card";
		correct = false;
		App app = tryMethod(test);
		assertEquals(correct, isDartsGameApp(app));
	}
	
	@Test
	void clock_isClockApp() {
		test= "clock";
		correct = true;
		App app = tryMethod(test);
		assertEquals(correct, isClockApp(app));
	}
	
	@Test
	void darts_isClockApp() {
		test= "darts";
		correct = false;
		App app = tryMethod(test);
		assertEquals(correct, isClockApp(app));
	}
	
	@Test
	void app_isClockApp() {
		test= "app";
		correct = false;
		App app = tryMethod(test);
		assertEquals(correct, isClockApp(app));
	}
	
	@Test
	void card_getAppName() {
		test= "card";
		result=("ゲーム：カード");
		App app = tryMethod(test);
		assertEquals(result, getAppName(app));
	}
	
	@Test
	void none_getAppName() {
		test= "";
		result = ("?");
		App app = tryMethod(test);
		assertEquals(result, getAppName(app));
	}
	
	@Test
	void clock_getAppName() {
		test= "clock";
		result=("時計");
		App app = tryMethod(test);
		assertEquals(result, getAppName(app));
	}
	
}
