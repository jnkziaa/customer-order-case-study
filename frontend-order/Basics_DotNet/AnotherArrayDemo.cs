using System;

namespace ClassLibrary1
{
    internal class Program1 
    {
        static void Main(string[] args){
    
            bool play = true;
            while(play){
                Console.Write("Enter a digits: ");
                int numCheck = Convert.ToInt32(Console.ReadLine());
                designedNum(numCheck);
                Console.Write("Do you want to try again?");
                if(!Console.ReadLine().ToLower().Equals("yes")){
                    play = false;
                }
               
            }

        }
        private static void designedNum(int numCheck)
        {
             for (int i = numCheck; i >= 1; i--)
            {
                for (int j = 1; j <= numCheck; j++)
                {
                    if(j < i){
                        Console.Write(" ");
                    }
                    else{
                    Console.Write(j);
                    }
                }
                Console.WriteLine();
            } 
        }
    }
    
    
}