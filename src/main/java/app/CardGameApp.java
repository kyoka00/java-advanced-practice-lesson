package app;

public class CardGameApp extends GameApp{
	public CardGameApp() {
		super();
	}
	public CardGameApp(String item) {
		super(item);
	}
	
	@Override
	public String start(String person) {
		String result =(person +"さんとアプリで" + this.item + "を開始します。ババ抜きを行います");
		return result;
	}
}
