package jp.co.axiz.util;

/**
 * Utilityメソッドをまとめたクラス
 */
public class Utility {

    /**
     * 引数に指定した文字列がnull、または空文字かを判定
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
    	//修正 総合テストNo.3による修正---------------------------
    	//担当：前野　2022.05.21
    	//if (str == null && str.isEmpty()) {
       if (str == null || str.isEmpty()) {
    	//
            return true;
        } else {
            return false;
        }
    	
    }

    /**
     * 引数に指定した文字列が数値に変換できるかを判定
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }

    /**
     * 引数に指定した文字列が数値に変換して返却する。
     * 変換できない場合はnullを返却する。
     */
    public static Integer checkAndParseInt(String str) {

        if (isNumber(str)) {
            return Integer.parseInt(str);
        } else {
            return null;
        }
    }

}
