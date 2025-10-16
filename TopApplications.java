

public class TopApplications {
    public static void main(String[] args) {


        System.out.println(lowestScoreByAcceptanceGaussian(5000, 20000, 1200.0, 100.0));
        System.out.println(LowestScoreByAcceptance(5000));
        // playing with quantile numbers
        // so if you want 5000 out of 20000 student you want the top 25% which corresponds to the 75% percentile as the cutoff
        System.out.println(Gaussian.inverseCDF(.90, 1200, 100));

    }

    // 0.15%
    // 2.35%
    // 13.5%
    // 34%
    // 20,000-(20,000*0.0015)-(20,000*0.235)-(20,000-13,5%) - first 16% 3200 1800
    // 100/6800=x/1800=>1273.5


    // This gives a very rough estimate of the lowest score to be accepted if the number of new students is between 3200-10000
    // There is 100% better math to make this precise, but I don't know it off the top of my head
    public static float LowestScoreByAcceptance(int NewStudents){
        if (NewStudents >= 10000) throw new IllegalArgumentException("This is only written for values less than half the applications");
        float LowestScore = 1700;
        int Applications = 20000;
        int StudentsAccepted = 0;

        // mean score
        int MeanScore = 1200;
        int StandardDeviationScore = 100;
        // i guess it's QUANtile not QUARtile
        int TopQuartile = (int) (Applications*0.0015);
        int TopThirdQuartile = (int) (Applications*0.0235);
        int TopSecondQuartile = (int) (Applications*0.135);
        int TopFirstQuartile = (int) (Applications*0.34);
        if ((NewStudents - StudentsAccepted) < (NewStudents-TopQuartile)){
            StudentsAccepted += TopQuartile;
        }
        else {
            StudentsAccepted += TopQuartile;
            //System.out.println(StudentsAccepted);
            LowestScore = 1500;
        }
        if ((NewStudents - StudentsAccepted) < (NewStudents-TopThirdQuartile)){
            StudentsAccepted += TopThirdQuartile;
        }
        else{
            StudentsAccepted += TopThirdQuartile;
            //System.out.println(StudentsAccepted);
            LowestScore = 1400;
        }
        if ((NewStudents - StudentsAccepted) < (NewStudents-TopSecondQuartile)){
            StudentsAccepted += TopSecondQuartile;
        }
        else{
            StudentsAccepted += TopSecondQuartile;
            //System.out.println(StudentsAccepted);
            LowestScore = 1300;
        }
        if ((NewStudents - StudentsAccepted) < (NewStudents-TopFirstQuartile)){
            return 1200;
            //StudentsAccepted += TopFirstQuartile;
        }
        else{
            //System.out.println("got here");
            float Slope = (float) ((float) StandardDeviationScore/ (float) ((Applications)*0.34));
            LowestScore = ((MeanScore + StandardDeviationScore) - ((Slope)*(NewStudents-StudentsAccepted)));
        }




        return LowestScore;
    }

    // "Continuous normal model"
    // https://en.wikipedia.org/wiki/Normal_distribution
    // Cumulative distribution function, but we inverse it because we're taking away from the top
    static double lowestScoreByAcceptanceGaussian(int newStudents, int applications, double mu, double sigma) {
        if (newStudents <= 0 || newStudents >= applications) {
            throw new IllegalArgumentException("newStudents must be in (0, applications).");
        }
        // creates application to newstudent ratio, then subtracts that from 1 to get the percentile
        double acceptRate = (double) newStudents / applications;     // top tail mass
        double targetQuantile = 1.0 - acceptRate;                    // CDF at cutoff
        // uses magic gaussian class to return the test score associate with that percentile
        return Gaussian.inverseCDF(targetQuantile, mu, sigma);
    }



}
