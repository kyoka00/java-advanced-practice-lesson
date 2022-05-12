package app;

public class DartsGameApp extends GameApp{
	public DartsGameApp() {
		super();
		this.item = "ダーツ";
	}
	public DartsGameApp(String item) {
		super(item);
		
	}
	
	@Override
	public String play() {
		return "10回投げて合計点を競います。";
	}
}
