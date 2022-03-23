import java.sql.SQLOutput;

public class RecursionPractice {
    public static double ss(double x){
        if(x==1) return 1;
        if(x<1) return -1;
        return 1/(x*x) + ss(x-1);
    }

    public static String printStars(int x){
        if(x==1) return "*";
        return "*" + printStars(x-1);
    }
    public static void printTriangles(int x){
        if(x==1) {
            System.out.println(printStars(1));
            return;
        }
        printTriangles(x-1);
        System.out.println(printStars(x));

    }

    public static void printTriangles2(int x){
        System.out.println(printStars(x));
        if(x==1) {
            return;
        }
        printTriangles2(x-1);

    }

    public static double subSeries(int n){
        if(n==1) return 1;
        if(n%2==1) return 1.0/n + subSeries (n-1);
        else return -1.0/n + subSeries(n-1);
    }
    public static void main(String[] args) {
        System.out.println(ss(100));
        printTriangles(5);
        printTriangles2(5);
        System.out.println(subSeries(3));
    }
}
