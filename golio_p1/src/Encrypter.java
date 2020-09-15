public class Encrypter
{

    public Encrypter()
    {
    }

    // Defines encrypt method and runs helper functions.
    public String encrypt(String input)
    {
        int[] inputIntArray = stringToIntArray(input);
        inputIntArray = addSevenTooArray(inputIntArray);
        inputIntArray = swapIndexValue(inputIntArray, 0, 2);
        inputIntArray = swapIndexValue(inputIntArray, 1, 3);
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

    // Adds 7 to each value in an integer array. (wraps back around if value is greater than 2)
    private int[] addSevenTooArray(int[] inputArray)
    {
        int i, len = inputArray.length;

        for(i = 0; i < len; i++)
        {
            inputArray[i] = (inputArray[i] + 7) % 10;
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
