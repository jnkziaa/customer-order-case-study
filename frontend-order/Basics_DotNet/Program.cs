/*

namespace ClassLibrary1
{
    internal class Program //Basic parameter or requirement of OOP
    {
        static void Main(string[] args)
        {
            String inputDig;

            Console.Write("Enter some digits: ");
            inputDig = Console.ReadLine();

            int numCheck = Convert.ToInt32(inputDig);
            for (int i = numCheck; i >= 1; i--)
            {
                for (int j = 1; j <= i; j++)
                {
                    Console.Write(j);
                }
                Console.WriteLine();
            }
        }

        private static void checkChar(char ch)
        {
            char toLower = Char.ToLower(ch);
            switch(toLower){
                case 'a': 
                case 'e': 
                case 'i': 
                case 'o': 
                case 'u': 
                    Console.WriteLine($"{toLower} is vowel");
                    break;
                default:
                    Console.WriteLine($"{toLower} is a consonant");
                    break;

            }
        }
    }
}*/