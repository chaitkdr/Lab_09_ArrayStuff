import java.util.Scanner;

public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt = 0;
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                pipe.nextLine();
                System.out.println("You must enter an integer value.");
            }
        } while (!done);

        return retInt;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double retDouble = 0.0;
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                pipe.nextLine();
                System.out.println("You must enter a numeric value.");
            }
        } while (!done);

        return retDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retInt = 0;
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine();
                if (retInt >= low && retInt <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a value between " + low + " and " + high + ".");
                }
            }
            else
            {
                pipe.nextLine();
                System.out.println("You must enter an integer value.");
            }
        } while (!done);

        return retInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retDouble = 0.0;
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                if (retDouble >= low && retDouble <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a value between " + low + " and " + high + ".");
                }
            }
            else
            {
                pipe.nextLine();
                System.out.println("You must enter a numeric value.");
            }
        } while (!done);

        return retDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retVal = false;
        boolean done = false;
        String input = "";
        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            input = pipe.nextLine();
            if (input.equalsIgnoreCase("Y"))
            {
                retVal = true;
                done = true;
            }
            else if (input.equalsIgnoreCase("N"))
            {
                retVal = false;
                done = true;
            }
            else
            {
                System.out.println("Please enter Y or N.");
            }
        } while (!done);

        return retVal;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retString = "";
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
            if (retString.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("Invalid format. Please try again.");
            }
        } while (!done);

        return retString;
    }

    public static void prettyHeader(String msg)
    {
        int width = 60;

        for (int i = 0; i < width; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        int innerWidth = width - 6;
        int totalPadding = innerWidth - msg.length();
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        System.out.print("***");
        for (int i = 0; i < leftPadding; i++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < rightPadding; i++)
        {
            System.out.print(" ");
        }
        System.out.println("***");

        for (int i = 0; i < width; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}