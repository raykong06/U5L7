public class Temperature
{
    private double highTemp;
    private double lowTemp;
    private String tempScale;

    // Precondition: scale must be: "F" or "C"; anything else will default to "F"
    public Temperature(double high, double low, String scale)
    {
        highTemp = high;
        lowTemp = low;

        if (scale.equals("F") || scale.equals("C"))
        {
            tempScale = scale;
        }
        else
        {
            tempScale = "F";
        }
    }

    // 1. Add your two static methods here:

    public static double convertCtoF(double temp)
    {
        double fahrenheit = temp * (9.0/5) + 32;
        return fahrenheit;
    }

    public static double convertFtoC(double temp)
    {
        double celsius = (temp - 32) * (5.0/9);
        return celsius;
    }


    // 2. Add your two instance methods here:

    public void changeToC()
    {
        if (tempScale.equals("F"))
        {
            highTemp = convertFtoC(highTemp);
            lowTemp = convertFtoC(lowTemp);
        }
    }

    public void changeToF()
    {
        if (tempScale.equals("C"))
        {
            highTemp = convertCtoF(highTemp);
            lowTemp = convertCtoF(lowTemp);
        }
    }


    // 3. Add your private static helper rounding "utility" method here:

    private static double roundToNearestTenth(double num)
    {
        int decimal = (int)((num - (int)(num)) * 100);
        if (decimal % 10 >= 5)
        {
            num = num + 0.1;
            num = num * 10;
            num = (int)(num);
            num = num / 10;
        }
        else
        {
            decimal = decimal / 10;
            num = (int)(num) + ((0.1) * decimal);
        }

        return num;
    }

    // 4. Complete the toString method below (using your static helper method)
    //    so it returns a String that prints like:

    //    High Temperature: 67.4 F (or C)
    //    Low Temperature: 58.3 F (or C)

    public String toString()
    {
        String str = "High Temperature: " + roundToNearestTenth(highTemp) + " ";
        if (tempScale.equals("F"))
        {
            str += "F\n";
        }
        else
        {
            str += "C\n";
        }
        str += "Low Temperature: " + roundToNearestTenth(lowTemp) + " ";
        if (tempScale.equals("F"))
        {
            str += "F\n";
        }
        else
        {
            str += "C";
        }
        return str;
    }
}
