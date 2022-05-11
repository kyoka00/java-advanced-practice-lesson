package classes;

import Util.Utility;

public class American extends Human{
	public American() {
		super();
		this.language = "英語";
	}
	public American(String name, String language) {
		super(name, language);
		if(!Utility.isNullOrEmpty(name)) {
			this.name = name;
		}
		if(Utility.isNullOrEmpty(language)) {
			this.language = "英語";
		}else {
			this.language = language;
		}
	}
	
	@Override
	public String returnBirthPlaceInfo() {
		 String msg = "出身地：アメリカ";

	        // 作成した文字列を返却
	        return msg;
	}
}
