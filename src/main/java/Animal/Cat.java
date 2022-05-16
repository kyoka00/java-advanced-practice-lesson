package Animal;

public class Cat extends Animal{
	public Cat(){
		super();

	}
	@Override
	public String introduceAge() {
		String humanAge;
		switch(age) {
		case 0:
			humanAge = "0～10代中盤";
			break;
		case 1:
			humanAge = "10代中盤";
			break;
		case 2, 3:
			humanAge = "20代";
			break;
		case 4,5:
			humanAge = "30代";
			break;
		case 6,7,8:
			humanAge = "40代";
			break;
		case 9, 10:
			humanAge = "50代";
			break;
		default:
			humanAge = "60歳以上";
			break;
		}
		String msg ="種類はネコです。人間で言うと、"+ humanAge + "です。";
		return "";
	}
	
	@Override
	public String getFilePath() {
		return "C:\\work/cat.txt";
	}
}
