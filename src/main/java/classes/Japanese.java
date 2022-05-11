package classes;

import Util.Utility;

public class Japanese extends Human{
	public Japanese() {
		super();
		this.language = "日本語";
	}
	public Japanese(String name, String language) {
		super(name, language);
		if(!Utility.isNullOrEmpty(name)) {
			this.name = name;
		}
		if(Utility.isNullOrEmpty(language)) {
			this.language = "日本語";
		}else {
			this.language = language;
		}
		
		
		
	}
	
	@Override
	public String returnBirthPlaceInfo() {
		 String msg = "出身地：日本";

	        // 作成した文字列を返却
	        return msg;
	}
}
