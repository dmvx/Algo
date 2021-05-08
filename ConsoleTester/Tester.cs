using System;
using System.IO;

namespace ConsoleTester
{
    class Tester
    {
        ITask task;
        string path;

        public Tester(ITask task, string path)
        {
            this.task = task;
            this.path = path;
        }

        public void RunTest()
        {
            int nr = 0;
            while (true)
            {
                string inFile = $"{path}/test.{nr}.in";
                string outFile = $"{path}/test.{nr}.out";
                if (!File.Exists(inFile) || !File.Exists(outFile))
                    break;
                Console.WriteLine($"Test #{nr} - " + RunTest1(inFile, outFile));
                nr++;
            }
        }

        public bool RunTest1(string inFile, string outFile)
        {
            try
            {

                string[] data = File.ReadAllLines(inFile);
                string[] expect = File.ReadAllLines(outFile);
                string actual = task.Run(data);

                return actual.Equals(expect[0]+ expect[1]);

            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                return false;
            }
        }
    }
}

