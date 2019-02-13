import java.util.Locale;
import java.util.Scanner;
//OU1
class Temperature{
    public static void main(String[] args){
        System.out.println("TEMPERATURE\n");
        //input tools
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        //enter the number of weeks and measurements
        System.out.println("number of weeks: ");
        int nofWeeks = in.nextInt();
        System.out.println("number of measurements per week: ");
        int nofMeasurementsPerWeek = in.nextInt();
        //storage space for temperature data
        double[][] t = new double[nofWeeks + 1][nofMeasurementsPerWeek + 1];
        //read the temperatures
        for(int week = 1; week<=nofWeeks;week++){
            System.out.println("temperatures - week " + week + ":");
            for(int reading = 1; reading<=nofMeasurementsPerWeek; reading++)
                t[week][reading] = in.nextDouble();
        }
        System.out.println();
        //show the temperatures
        System.out.println("the temperatures:");
        for (int week = 1; week<=nofWeeks; week++){
            for(int reading=1;reading<=nofMeasurementsPerWeek;reading++)
                System.out.println(t[week][reading] + " ");
        }
        System.out.println();
        //the least, greatest and average temperature -weekly
        double[] minT = new double[nofWeeks +1];
        double[] maxT = new double[nofWeeks +1];
        double[] sumT = new double[nofWeeks +1];
        double[] avgT = new double[nofWeeks +1];
        //compute and store the least, greatest and average
        //temperature for each week
        //*** WRITE YOUR CODE HERE ***
        double min=0;
        double max=0;
        double sum=0;
        for (int week = 1; week<=nofWeeks; week++){
            for(int reading=1;reading<=nofMeasurementsPerWeek;reading++){
                if(reading==1){
                    min=t[week][reading];
                    max=t[week][reading];
                }
                if(t[week][reading]<min){
                    min=t[week][reading];
                }
                if(t[week][reading]>max){
                    max=t[week][reading];
                }
                sum = sum + t[week][reading];
                if(reading==nofMeasurementsPerWeek){
                    minT[week]=min;
                    maxT[week]=max;
                    sumT[week]=sum;
                    avgT[week]=sum/nofMeasurementsPerWeek;
                }
            }
        }
        //show the least, greatest and average temperature for each week
        //*** WRITE YOUR CODE HERE ***
        for(int week = 1; week<=nofWeeks; week++){
            System.out.println(minT[week]);
            System.out.println(maxT[week]);
            System.out.println(avgT[week]);
        }
        //the least, greatest and average temperature - whole period
        double minTemp = minT[1];
        double maxTemp = maxT[1];
        double sumTemp = sumT[1];
        double avgTemp = 0;
        //compute and store the least, greatest and average
        //temperature for the whole period
        //*** WRITE YOUR CODE HERE ***
        for(int week = 2; week<=nofWeeks; week++){
            if(week==1){
                min=minT[week];
                max=maxT[week];
            }
            if(minT[week]<minTemp){
                minTemp=minT[week];
            }
            if(maxT[week]>maxTemp){
                maxTemp=minT[week];
            }
            sum=sum+sumT[week];
            if(week==nofWeeks){
                avgTemp=sum/nofWeeks;
            }
        }
        //show the least, greatest and average temperature for
        //the whole period
        //*** WRITE YOUR CODE HERE ***
        System.out.println(minTemp);
        System.out.println(maxTemp);
        System.out.println(avgTemp);
    }
}