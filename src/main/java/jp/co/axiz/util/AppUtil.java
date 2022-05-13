package jp.co.axiz.util;

import app.App;
import app.CardGameApp;
import app.ClockApp;
import app.DartsGameApp;
import app.GameApp;

public class AppUtil {

	App app = null;

	public App tryMethod(String appType) {

		switch (appType) {
		case "card":

			return app = new CardGameApp("トランプ");

		case "darts":

			return app = new DartsGameApp("ダーツ");

		case "clock":

			return app = new ClockApp();

		default:
			return app = null;
		}
	}

	// test
	public static boolean isGameApp(App app) {
		if (app instanceof GameApp) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isCardGameApp(App app) {
		if (app instanceof CardGameApp) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isDartsGameApp(App app) {
		if (app instanceof DartsGameApp) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isClockApp(App app) {
		if (app instanceof ClockApp) {
			return true;
		} else {
			return false;
		}
	}

	public static String getAppName(App app) {
		String result ="?";
		if (app instanceof GameApp) {
			if (app instanceof CardGameApp) {
				result= "ゲーム：カード";

			} else if (app instanceof DartsGameApp) {
				result= "ゲーム：ダーツ";
			} else {

			}
			if (app instanceof ClockApp) {
				result= "時計";
			}
		} 
		return result;
	}
}
