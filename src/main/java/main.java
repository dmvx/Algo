import org.decimal4j.util.DoubleRounder;
import java.math.BigInteger;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

import static java.lang.String.*;
import static java.lang.System.*;


public class main {

    public static void main( String[] args ) throws IOException {
        Tester t = new Tester();
        t.RunTest();
        //luckyTickets lt = new luckyTickets();
        //out.println(lt.getTicketsQty(7));
        //HarryPaint p = new HarryPaint();
        //p.paintShape();
        //GetPower gp = new GetPower();
        //Fibo f = new Fibo();
        //System.out.println(f.getFiboWIter(10).toString());

        //Fibo f = new Fibo();
        //String actual = f.getFiboWMatrix(2).toString();

    }

}

class Tester{

    public void RunTest() throws IOException {
        int i = 0;
        //String path="/Users/D/Desktop/Algo/A_01/A01_Счастливые_билеты-19350-02c525/1.Tickets";
        //String path="/Users/D/Desktop/Algo/A_01/A01_Счастливые_билеты-19350-02c525/0.String";
        String path="/Users/D/Desktop/Algo/A_02/3.Power";
        //String path="/Users/D/Desktop/Algo/A_02/4.Fibo";
        //String path="/Users/D/Desktop/Algo/A_02/5.Primes";
        while (true)
        {

            String inPath = path+"/test." + i + ".in";
            String outPath = path+"/test." + i + ".out";
            File inFile = new File(inPath);
            File outFile = new File(outPath);


            if (!inFile.exists() || !outFile.exists())
                break;
             String in = Files.readAllLines(inFile.toPath()).get(0).trim();
             String in1 = Files.readAllLines(inFile.toPath()).get(1).trim();
             long StartMls = System.currentTimeMillis();
             boolean flg = RunChek(in, in1, outFile);
             System.out.println(/*"Test." + i + ", in = "+*/in+"^"+in1+/*", Time spent, ms: "*/" " + (System.currentTimeMillis() - StartMls) + " - "  + flg);
            i++;
        }
    }

    public boolean RunChek(String in, String in1, File outFile)
    {
        try
        {
            //List<String> data = Files.readAllLines(inFile.toPath());

            //String expect = Files.readAllLines(outFile.toPath()).get(0).trim();
            //Double expect = Double.valueOf(Files.readAllLines(outFile.toPath()).get(0).trim());
            //luckyTickets lt = new luckyTickets();
            //String actual = String.valueOf(lt.getTicketsQty(Integer.parseInt(data.get(0).trim())));

            //GetLenghtOfString gl = new GetLenghtOfString();
            //String actual = String.valueOf(gl.getLength(data.get(0).trim()));

            GetPower gp = new GetPower();
            Double expect = Double.valueOf(Files.readAllLines(outFile.toPath()).get(0).trim());
            //Double actual = gp.getPowerIter(Double.valueOf(in),Integer.valueOf(in1));
            //Double actual = gp.getPowerby2(Double.valueOf(in),Integer.valueOf(in1));
            Double actual = gp.getPowerbyBin(Double.valueOf(in),Integer.valueOf(in1));


            //Fibo f = new Fibo();
            //String expect = Files.readAllLines(outFile.toPath()).get(0).trim();
            //String actual = f.getFiboWRec(Integer.valueOf(Integer.valueOf(in))).toString();
            //String actual = f.getFiboWIter(Integer.valueOf(Integer.valueOf(in))).toString();
            //'String actual = f.getFiboWMatrix(Integer.valueOf(Integer.valueOf(in))).toString();
            //String actual = f.getFiboWGS(Integer.valueOf(Integer.valueOf(in))).toString();

            //Primes p = new Primes();
            //Integer expect = Integer.valueOf(Files.readAllLines(outFile.toPath()).get(0).trim());
            //Integer actual = p.getPrimesByIterArray(Integer.valueOf(in));

            out.println(expect + ",a="+actual);
            return actual.equals(DoubleRounder.round(expect,11));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
