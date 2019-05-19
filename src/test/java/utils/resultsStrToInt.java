package utils;

public class resultsStrToInt {

    public int stringToInt(String StrResults){
        char [] ResultsChar = StrResults.toCharArray();
        String n = "";
        int result = 0;
        for (int i = 0; i < ResultsChar.length; i++){
            if(Character.isDigit(ResultsChar[i])){
                n+=ResultsChar[i];
            }
        }
        System.out.println(n);
        result = Integer.valueOf(n);
        return result;
    }
}
