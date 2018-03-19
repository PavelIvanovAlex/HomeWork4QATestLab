import java.util.Random;

public class RandomData {
    public static String RandomString(){
        Random rnd=new Random();
        int stringLength=rnd.nextInt(20)+3;
        char[]charSS=new char[stringLength];
        for(int i=0;i<stringLength;i++){
            int charS=rnd.nextInt(26)+65;
            charSS[i]=(char)charS;

        }
        String randString=new String(charSS);
        return randString;
    }
    public static String RandomInt(){
        Random rnd=new Random();
        int randInt=rnd.nextInt(100);
        return Integer.toString(randInt);
    }
    public static String RandomDouble(){
        Random rnd=new Random();
        double randDbl=rnd.nextDouble()*100;
        return Double.toString(Math.round(randDbl*100)*0.01);
    }
}
