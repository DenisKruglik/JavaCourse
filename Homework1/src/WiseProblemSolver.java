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

//        3.5
//
//        int x1=0,y1=0,r1=0,x2=0,y2=0,r2=0;
//        try{
//            String str = br.readLine();
//            x1 = Integer.valueOf(str);
//            str = br.readLine();
//            y1 = Integer.valueOf(str);
//            str = br.readLine();
//            r1 = Integer.valueOf(str);
//            str = br.readLine();
//            x2 = Integer.valueOf(str);
//            str = br.readLine();
//            y2 = Integer.valueOf(str);
//            str = br.readLine();
//            r2 = Integer.valueOf(str);
//        }catch(Exception e){}
//        WiseProblemSolver.getIntersection(x1,y1,r1,x2,y2,r2);

//        4.1
//
//        int k = 0;
//        try{
//            String str = br.readLine();
//            k = Integer.valueOf(str);
//        }catch(Exception e){}
//        System.out.println(WiseProblemSolver.getKFibonacciNumber(k));

//        4.2
//
//        int n = 0;
//        try{
//            String str = br.readLine();
//            n = Integer.valueOf(str);
//        }catch(Exception e){}
//        System.out.println(WiseProblemSolver.factorial(n));

//        4.3
//
//        int n = 0;
//        try{
//            String str = br.readLine();
//            n = Integer.valueOf(str);
//        }catch(Exception e){}
//        System.out.println(WiseProblemSolver.harmonicSeriesSum(n));

//        4.4
//
//        int n = 0;
//        try{
//            String str = br.readLine();
//            n = Integer.valueOf(str);
//        }catch(Exception e){}
//        System.out.println(WiseProblemSolver.binary(n));

//        4.5
//
//        int n = 0;
//        try{
//            String str = br.readLine();
//            n = Integer.valueOf(str);
//        }catch(Exception e){}
//        System.out.println(WiseProblemSolver.isSimple(n));
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

    public static void getIntersection(int x1, int y1, int r1, int x2, int y2, int r2){
        double d = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
        if (d > r1+r2){
            System.out.println("Don't intersect");
        }else if(d == r1+r2){
            System.out.println("Intersect in a single point");
        }else if(d < r1+r2){
            double f1 = 2 * Math.acos((r1*r1 - r2*r2 + d*d) / (2 * r1 * d));
            double f2 = 2 * Math.acos((r2*r2 - r1*r1 + d*d) / (2 * r2 * d));
            double s1 = (r1*r1 * (f1 - Math.sin(f1))) / 2;
            double s2 = (r2*r2 * (f2 - Math.sin(f2))) / 2;

            System.out.println(s1+s2);
        }
    }

    public static int getKFibonacciNumber(int k){
        int current = 1, prev = 0, ind = 1, temp = 0;
        while(ind < k){
            temp = current;
            current += prev;
            prev = temp;
            ind++;
        }
        return current;
    }

    public static double harmonicSeriesSum(int n){
        double sum = 0;
        for(int i = 1; i <= n; i++){
            sum += 1/(double)i;
        }
        return sum;
    }

    public static String binary(int n){
        String res = "";
        int i = 0;
        while (n > 0){
            res += n % 2;
            n /= 2;
            i++;
        }
        res = WiseProblemSolver.recursiveReverse(res);
        return res;
    }

    public static String recursiveReverse(String s) {
        if ((null == s) || (s.length() <= 1)) {
            return s;
        }
        return WiseProblemSolver.recursiveReverse(s.substring(1)) + s.charAt(0);
    }

    public static boolean isSimple(int n){
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
