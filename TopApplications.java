public class TopApplications {
    public static void main(String[] args) {


        System.out.println(LowestScoreByAcceptance(5000));

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
        int MeanScore = 1200;
        int StandardDeviationScore = 100;
        int TopQuartile = (int) (Applications*0.0015);
        int TopThirdQuartile = (int) (Applications*0.0235);
        int TopSecondQuartile = (int) (Applications*0.135);
        int TopFirstQuartile = (int) (Applications*0.34);
        if ((NewStudents - StudentsAccepted) < (NewStudents-TopQuartile)){
            StudentsAccepted += TopQuartile;
        }
        else {
            StudentsAccepted += TopQuartile;
            System.out.println(StudentsAccepted);
            LowestScore = 1500;
        }
        if ((NewStudents - StudentsAccepted) < (NewStudents-TopThirdQuartile)){
            StudentsAccepted += TopThirdQuartile;
        }
        else{
            StudentsAccepted += TopThirdQuartile;
            System.out.println(StudentsAccepted);
            LowestScore = 1400;
        }
        if ((NewStudents - StudentsAccepted) < (NewStudents-TopSecondQuartile)){
            StudentsAccepted += TopSecondQuartile;
        }
        else{
            StudentsAccepted += TopSecondQuartile;
            System.out.println(StudentsAccepted);
            LowestScore = 1300;
        }
        if ((NewStudents - StudentsAccepted) < (NewStudents-TopFirstQuartile)){
            return 1200;
            //StudentsAccepted += TopFirstQuartile;
        }
        else{
            System.out.println("got here");
            float Slope = (float) ((float) StandardDeviationScore/ (float) ((Applications)*0.34));
            LowestScore = ((MeanScore + StandardDeviationScore) - ((Slope)*(NewStudents-StudentsAccepted)));
        }




        return LowestScore;
    }

}
