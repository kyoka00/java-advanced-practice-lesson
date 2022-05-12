package servlet;

import java.util.HashMap;

/**
 * 英単語情報を保持するためのクラス
 */
public class Dictionary {

    private HashMap<String, String> dictionaryInfo;


    public Dictionary() {

    	dictionaryInfo = new HashMap<String, String>();
    	dictionaryInfo.put("apple","りんご");
    	dictionaryInfo.put("orange","みかん");
    	dictionaryInfo.put("peach","もも");
    	dictionaryInfo.put("grape","ぶどう");
    	dictionaryInfo.put("pear","なし");

    }



    public void setDictionaryInfo(HashMap<String, String> dictionaryInfo) {
        this.dictionaryInfo = dictionaryInfo;
    }

    public HashMap<String, String> getDictionaryInfo() {
        return dictionaryInfo;
    }
    
    
    public String searchDictionary(String english) {
    	String result ="";
    	if (dictionaryInfo.containsKey(english)) {
    		result= dictionaryInfo.get(english);
    	}
    	return result;
    }
}