package Animal;

public class Rabbit extends Animal{
	public Rabbit(){
		super();
		
	}
	@Override
	public String introduceAge() {
		String humanAge;
		switch (age) {
		case 0:
			humanAge = "0~10代中盤";
			break;
		case 1:
			humanAge = "10代中盤";
			break;
		case 2:
			humanAge = "20代";
		 	break;
		case 3:
			humanAge = "30代";
		 	break;
		case 4:
			humanAge = "40代";
		 	break;
		case 5:
			humanAge = "50代";
		 	break;
		default:
			humanAge = "60歳以上";
			break;
		}
		String msg ="種類はウサギです。人間でいうと"+ humanAge + "です";
		return msg;
	}
	
	@Override
	public String getFilePath() {
		return "C:\\work/rabbit.txt";
	}
}
