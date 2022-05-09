import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        while(true)
        {
            while(true)
            {
                System.out.println("-------------------------");
                System.out.println("1- Get Random Prime Up to Your Input.");
                System.out.println("2- Get All Primes Up to Your Input.");
                System.out.println("3- Get Random Prime Between Your Inputs. (2 inputs)");
                System.out.println("4- Get All Primes Between Your Inputs. (2 inputs)");
                System.out.println("5- Check If Your Input Is A Prime.");
                System.out.println("-------------------------\n");
                System.out.print("Please enter your input: ");
                int val1,val2;

                try {
                    switch(new Scanner(System.in).nextInt())
                    {
                        case 1:
                            System.out.print("input: ");
                            System.out.println("Your random prime is "+getRandomPrime(new Scanner(System.in).nextInt())+"\n");
                            break;

                        case 2:
                            System.out.print("input: ");
                            System.out.println("Your prime list is "+getAllPrimes(new Scanner(System.in).nextInt())+"\n");
                            break;

                        case 3:
                            System.out.print("input 1: ");
                            val1 = new Scanner(System.in).nextInt();
                            //System.out.println();
                            System.out.print("input 2: ");
                            val2 = new Scanner(System.in).nextInt();
                            System.out.println("Your random prime between "+val1+" and "+val2+" is "+getRandomPrimeBetween(val1,val2)+"\n");
                            break;

                        case 4:
                            System.out.print("input 1: ");
                            val1 = new Scanner(System.in).nextInt();
                            //System.out.println();
                            System.out.print("input 2: ");
                            val2 = new Scanner(System.in).nextInt();
                            System.out.println("Your prime list between "+val1+" and "+val2+" is "+getPrimesBetween(val1,val2)+"\n");
                            break;

                        case 5:
                            System.out.print("input: ");
                            if(isPrime(new Scanner(System.in).nextInt()))
                            {
                                System.out.println("Your number is prime");
                            }else
                            {
                                System.out.println("Your number is not prime");
                            }
                            break;

                        default:
                            System.out.println("Please enter a valid number\n");
                            break;
                    }
                }catch(InputMismatchException e)
                {
                    System.out.println("Please enter an positive integer.\n");
                    break;
                }
            }
        }
    }

    public static boolean isPrime(int number)
    {
        for(int i=2;i<=11;i++)
        {
            if(number%i==0 && number != 2 && number != 3 && number != 5 && number != 7 && number != 11)
            {
                return false;
            }
        }
        return true;
    }

    public static int getRandomPrime(int value)
    {
        ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
        Random random = new Random();
        for(int i=2;i<value;i++)
        {
            if(isPrime(i))
            {
                primeNumbers.add(i);
            }
        }

        return primeNumbers.get(random.nextInt(primeNumbers.size()));
    }

    public static int getRandomPrimeBetween(int valueMin, int valueMax)
    {
        ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
        Random random = new Random();

        for(int i=valueMin;i<valueMax;i++)
        {
            if(isPrime(i))
            {
                primeNumbers.add(i);
            }
        }

        return primeNumbers.get(random.nextInt(primeNumbers.size()));
    }

    public static ArrayList<Integer> getAllPrimes(int value)
    {
        ArrayList<Integer> primeNumber = new ArrayList<Integer>();

        for(int i=2;i<value;i++)
        {
            if(isPrime(i))
            {
                primeNumber.add(i);
            }
        }

        System.out.println("There are "+(primeNumber.size()+1)+" primes.");
        return primeNumber;
    }

    public static ArrayList<Integer> getPrimesBetween(int value1, int value2)
    {
        ArrayList<Integer> primeNumber = new ArrayList<Integer>();

        for(int i= value1;i<value2;i++)
        {
            if(isPrime(i))
            {
                primeNumber.add(i);
            }
        }

        System.out.println("There are "+(primeNumber.size()+1)+" primes.");
        return primeNumber;
    }
}