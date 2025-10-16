// i clearly need more practice with recursion so i threw in some rpactice

public class WeekThree {
    public static void main(String[] args) {

        System.out.println(recSumToN(4));

    }

    public static boolean areTriangular(double A, double B, double C){

        double AB = A+B;
        double BC = B+C;
        double CA = C+A;

        if ((A > BC)||(B > CA)||(C > AB)){
            return false;
        }

        return true;
    }

    public static int recSumToN(int n){
        //well defined base case
        if(n == 0) return 0;
        int sum = n;
        sum = sum + recSumToN(n-1);

        return sum;

    }

    public static int recFibonacci(int n){
        if(n == 0) return 0;

        if(n == 1) return 1;

    }

}
