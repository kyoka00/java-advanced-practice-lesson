package app;

public class GameApp {
	public String item;
	
	public GameApp(String item) {
		this.item = item;
	}
	public GameApp() {
		
	}
	public String start(String person) {
		String result =(person +"さんとアプリで" + this.item + "を開始します。");
		return result;
	}
}
