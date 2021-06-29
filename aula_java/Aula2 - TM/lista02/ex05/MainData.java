import java.util.Date;
public class MainData{
    
    public static void main(String[] args) {
        
        // Data data1 = new Data();
        Data data2 = new Data(new Date());
        Data data3 = new Data("01/01/2021");

        System.out.println("----------------- DATA2 ");
        System.out.println(data2);

        System.out.println("----------------- DATA2 add day");
        data2.addDay(1);
        System.out.println(data2);

        System.out.println("----------------- DATA2 add month");
        data2.addMonth(1);
        System.out.println(data2);

        System.out.println("----------------- DATA2 add year");
        data2.addYear(1);
        System.out.println(data2);

        System.out.println();

        System.out.println("----------------- DATA3 ");
        System.out.println(data3);

        System.out.println("----------------- DATA3 add day");
        data3.addDay(1);
        System.out.println(data3);

        System.out.println("----------------- DATA3 add month");
        data3.addMonth(1);
        System.out.println(data3);

        System.out.println("----------------- DATA3 add year");
        data3.addYear(1);
        System.out.println(data3);
        // System.out.println(data3);
        
    }
}