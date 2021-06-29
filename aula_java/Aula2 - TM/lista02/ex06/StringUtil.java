import java.util.regex.Pattern;

public class StringUtil{

    public static String rpad(String s, char c, int n){
        String saux = s;
        for(int i = 0; i < n; i++)
        {
            saux += c;
        }
        return saux;
    }

    public static String lpad(String s, char c, int n){
        String saux = s;
        for(int i = 0; i < n; i++)
        {
            saux = c + saux;
        }
        return saux;
    }

    public static String ltrim(String s){
        Pattern p = Pattern.compile("/(^\\s*)/g",
            Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        return p.matcher(s).replaceAll("");
    }


    public static String rtrim(String s){
        Pattern p = Pattern.compile("/(\\s*$)/g",
            Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        return p.matcher(s).replaceAll("");
    }
}