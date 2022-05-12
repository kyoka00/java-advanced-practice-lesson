package app;

public class DartsGameApp extends GameApp{
	public DartsGameApp() {
		super();
		setItem( "ダーツ");
		
	}
	public DartsGameApp(String item) {
		super(item);
		setPlayTime(10);
		
	}
	
	@Override
	protected String play() {
		return "10回投げて合計点を競います。";
	}
}
