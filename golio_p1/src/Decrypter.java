public class Decrypter
{

    public Decrypter()
    {
    }

    // Defines decrypt method and runs helper functions.
    public String decrypt(String input)
    {
        int[] inputIntArray = stringToIntArray(input);
        inputIntArray = swapIndexValue(inputIntArray, 1, 3);
        inputIntArray = swapIndexValue(inputIntArray, 0, 2);
        inputIntArray = subtractSevenTooArray(inputIntArray);
        String finalString = intArrayToString(inputIntArray);
        return finalString;
    }

    // Converts inputted string to integer array using .charAt().
    private int[] stringToIntArray(String input)
    {
        int i, len = input.length();
        int[] inputIntArray = new int[len];

        for(i = 0; i < len; i++)
        {
            inputIntArray[i] = input.charAt(i) - '0';
        }
        return inputIntArray;
    }

    // Subtracts 7 from each value in an integer array. (wraps back around if value is less than 7)
    private int[] subtractSevenTooArray(int[] inputArray)
    {
        int i, len = inputArray.length;

        for(i = 0; i < len; i++)
        {
            if(inputArray[i] >= 7)
            {
                inputArray[i] -= 7;
            }
            else
            {
                inputArray[i] = 10 - Math.abs(inputArray[i] - 7);
            }
        }
        return inputArray;
    }

    // Swaps the values at 2 indices in an integer array.
    private int[] swapIndexValue(int[] inputArray, int first, int second)
    {
        int temp;
        temp = inputArray[first];
        inputArray[first] = inputArray[second];
        inputArray[second] = temp;
        return inputArray;
    }

    // Converts an integer array to a string using a string builder.
    private String intArrayToString(int[] inputArray)
    {
        StringBuilder builder = new StringBuilder(4);
        int i, len = inputArray.length;
        for(i = 0; i < len; i++)
        {
            builder.append(inputArray[i]);
        }
        return builder.toString();
    }
}
