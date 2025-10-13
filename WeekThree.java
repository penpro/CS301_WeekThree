public class WeekThree {
    public static void main(String[] args) {

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

}
