package app;

public  abstract class GameApp {
	public String item;
	
	public GameApp() {
		
	}
	
	public GameApp(String item) {
		this.item = item;
	}
	public abstract String play();
	
	public String start(String person) {
		String result =(person +"さんとアプリで" + this.item + "を開始します。"+ play());
		return result;
	}
}
