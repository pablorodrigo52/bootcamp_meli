public class Main{
    public static void main(String[] args) {
        System.out.println(StringUtil.rpad("BOOTCAMP", '-', 10));
        System.out.println(StringUtil.lpad("BOOTCAMP", '-', 10));
        System.out.println(StringUtil.rtrim("[   BOOTCAMP   ]"));
        System.out.println(StringUtil.ltrim("[   BOOTCAMP   ]"));
    }
}