package Animal;

public class Cat extends Animal{
	public Cat(String name, int age){
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
