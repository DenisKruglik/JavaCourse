import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyClass {
    public static void main(String args[]){
//        System.out.println("Hello World!");
//        int a = 0, b;
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str = br.readLine();
//            a = Integer.valueOf(str);
//        }catch(Exception e){
//
//        }
//
//        System.out.println(a+1);


        int a = 0, b = 0, c = 0;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            a = Integer.valueOf(str);
            str = br.readLine();
            b = Integer.valueOf(str);
            str = br.readLine();
            c = Integer.valueOf(str);
        }catch(Exception e){

        }
        int max = a > b ? a : b;
        max = c > max ? c : max;
        System.out.println(max);
    }
}
