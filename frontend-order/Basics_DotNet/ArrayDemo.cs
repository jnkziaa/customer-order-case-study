/*using System;

namespace ClassLibrary1
{
    internal class Program1 //Basic parameter or requirement of OOP
    {

        static void Main(string[] args){
        int temp1 = Convert.ToInt32(Console.ReadLine());
        
        int[][] jaggedArray = new int[temp1][];
        for(int i = 0; i < jaggedArray.Length; i++){
            Console.Write($"Enter Length for Array {i}: ");

            int temp = Convert.ToInt32(Console.ReadLine());
            jaggedArray[i] = new int[temp];
        }

        for(int i = 0; i < jaggedArray.Length; i++){
            for(int j = 0; j < jaggedArray[i].Length; j++){
                Console.Write("Enter some digits: ");
                int temp = Convert.ToInt32(Console.ReadLine());
                jaggedArray[i][j] = temp;
            }

            Console.WriteLine();
        }

        for(int i = 0; i < jaggedArray.Length; i++){
            for(int j = 0; j < jaggedArray[i].Length; j++){
                Console.Write($"{jaggedArray[i][j]}\t");
            }

            Console.WriteLine();
        }

        }
    }
    
    
}*/