package app;

public class CardGameApp extends GameApp{
	public CardGameApp() {
		super();
		setItem("トランプ");
	}
	public CardGameApp(String item) {
		super(item);
		setPlayTime(5);
	}
	
	@Override
	protected String play() {
		return "ババ抜きを行います。";
	}
}
