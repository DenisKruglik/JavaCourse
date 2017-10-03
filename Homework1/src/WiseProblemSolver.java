import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WiseProblemSolver {
    public static void main(String args[]){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        2.1
//
//        int a=0,b=0;
//        try{
//            String str = br.readLine();
//            a = Integer.valueOf(str);
//            str = br.readLine();
//            b = Integer.valueOf(str);
//        }catch(Exception e){}
//        System.out.println(WiseProblemSolver.linearEquation(a,b));

//        2.2
//
//        int a=0,b=0;
//        try{
//            String str = br.readLine();
//            a = Integer.valueOf(str);
//            str = br.readLine();
//            b = Integer.valueOf(str);
//        }catch(Exception e){}
//        System.out.println(WiseProblemSolver.percentFinder(a,b));

//        2.3
//
//        float a,b,c;
//        try{
//            String str = br.readLine();
//            a = Float.valueOf(str);
//            str = br.readLine();
//            b = Float.valueOf(str);
//            str = br.readLine();
//            c = Float.valueOf(str);
//        }catch(Exception e){}
//        try{
//            double arr[] = WiseProblemSolver.squareEquation(1, 1, 1);
//            System.out.println(arr[0]);
//            System.out.println(arr[1]);
//        }catch(Exception e){
//            System.out.println("No roots!");
//        }

//        2.4
//
//        int a=0;
//        try{
//            String str = br.readLine();
//            a = Integer.valueOf(str);
//        }catch(Exception e){}
//        System.out.println(WiseProblemSolver.arcsin(a));

//        3.1
//
//        int a=0,b=0,c=0,d=0;
//        try{
//            String str = br.readLine();
//            a = Integer.valueOf(str);
//            str = br.readLine();
//            b = Integer.valueOf(str);
//            str = br.readLine();
//            c = Integer.valueOf(str);
//            str = br.readLine();
//            d = Integer.valueOf(str);
//        }catch(Exception e){}
//        System.out.println(WiseProblemSolver.max(a,b,c,d));

//        3.2
//
//        int a = 0;
//        try{
//            String str = br.readLine();
//            a = Integer.valueOf(str);
//        }catch(Exception e){}
//        System.out.println(WiseProblemSolver.secondsToStr(a));

//        3.3
//
//        int a=0,b=0,c=0;
//        try{
//            String str = br.readLine();
//            a = Integer.valueOf(str);
//            str = br.readLine();
//            b = Integer.valueOf(str);
//            str = br.readLine();
//            c = Integer.valueOf(str);
//        }catch(Exception e){}
//        System.out.println(WiseProblemSolver.isTriangle(a,b,c));

//        3.4
//
//        int a=0,b=0;
//        char o = '\0';
//        try{
//            String str = br.readLine();
//            a = Integer.valueOf(str);
//            str = br.readLine();
//            b = Integer.valueOf(str);
//            str = br.readLine();
//            o = str.charAt(0);
//        }catch(Exception e){}
//        System.out.println(WiseProblemSolver.calculator(a,b,o));

    }

    public static int linearEquation(int a, int b){
        int x = (-b)/a;
        return x;
    }

    public static float percentFinder(int a, int x){
        float c = (float)a/100;
        return x*c;
    }

    public static double[] squareEquation(float a, float b, float c){
        float d = b*b - 4*a*c;
        if (d < 0){
            return null;
        }
        double x1 = (-b + Math.sqrt(d)) / (2*a);
        double x2 = (-b - Math.sqrt(d)) / (2*a);
        double res[] = {x1, x2};
        return res;
    }

    public static double arcsin(int x){
        double res = 0;
        for (int n = 0; n < 3; n++){
            res += (WiseProblemSolver.factorial(2*n)/(Math.pow(4,n)*Math.pow(WiseProblemSolver.factorial(n),2)*(2*n+1)))*Math.pow(x,2*n+1);
        }
        return res;
    }

    public static int factorial(int x){
        return x==0 ? 1 : x*WiseProblemSolver.factorial(x-1);
    }

    public static int max(int a, int b, int c, int d){
        int max = a > b ? a : b;
        max = max > c ? max : c;
        max = max > d ? max : d;
        return max;
    }

    public static String secondsToStr(int x){
        int days = x / (60*60*24);
        x -= 60*60*24*days;
        int hours = x / (60*60);
        x -= 60*60*hours;
        int minutes = x / 60;
        x -= minutes*60;
        String res = days + " days " + hours + " hours " + minutes + " minutes " + x + " seconds";
        return res;
    }

    public static boolean isTriangle(int a, int b, int c){
        return (a+b>=c)&&(a+c>=b)&&(b+c>=a);
    }

    public static double calculator(int a, int b, char o){
        switch(o){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            default:
                return 0;
        }
    }


}
