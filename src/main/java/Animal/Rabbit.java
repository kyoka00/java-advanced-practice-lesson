package Animal;

public class Rabbit extends Animal{
	public Rabbit(String name,int age){
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String introduceAge() {
		return "";
	}
	
	@Override
	public String getFilePath() {
		return "C:";
	}
}
