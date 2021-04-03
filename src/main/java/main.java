import java.io.*;
import java.nio.file.Files;
import java.util.List;

import static java.lang.String.*;
import static java.lang.System.*;


public class main {

    public static void main( String[] args ) throws IOException {
        //Tester t=new Tester();
        //t.RunTest();
        //luckyTickets lt = new luckyTickets();
        //out.println(lt.getTicketsQty(7));
        HarryPaint p = new HarryPaint();
        p.paintShape();
    }

}

class Tester{

    public void RunTest() throws IOException {
        int i = 0;
        //String path="/Users/D/Desktop/Algo/A_01/A01_Счастливые_билеты-19350-02c525/1.Tickets";
        String path="/Users/D/Desktop/Algo/A_01/A01_Счастливые_билеты-19350-02c525/0.String";
        while (true)
        {

            String inPath = path+"/test." + i + ".in";
            String outPath = path+"/test." + i + ".out";
            File inFile = new File(inPath);
            File outFile = new File(outPath);

            if (!inFile.exists() || !outFile.exists())
                break;
             System.out.println("Test." + i + " - " + RunChek(inFile, outFile));
            i++;
        }
    }

    public boolean RunChek(File inFile, File outFile)
    {
        try
        {
            List<String> data = Files.readAllLines(inFile.toPath());
            String expect = Files.readAllLines(outFile.toPath()).get(0).trim();
            //luckyTickets lt = new luckyTickets();
            //String actual = String.valueOf(lt.getTicketsQty(Integer.parseInt(data.get(0).trim())));

            GetLenghtOfString gl = new GetLenghtOfString();
            String actual = String.valueOf(gl.getLength(data.get(0).trim()));

            return actual.equals(expect);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
