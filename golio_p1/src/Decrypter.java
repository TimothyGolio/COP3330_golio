public class Decrypter {

    public Decrypter() {
    }

    public String decrypt(String input) {
        int[] inputIntArray = stringToIntArray(input);
        inputIntArray = swapIndexValue(inputIntArray, 1, 3);
        inputIntArray = swapIndexValue(inputIntArray, 0, 2);
        inputIntArray = subtractSevenTooArray(inputIntArray);
        String finalString = intArrayToString(inputIntArray);
        return finalString;
    }

    private int[] stringToIntArray(String input) {
        int i, len = input.length();
        int[] inputIntArray = new int[len];

        for(i = 0; i < len; i++){
            inputIntArray[i] = input.charAt(i) - '0';
        }
        return inputIntArray;
    }

    private int[] subtractSevenTooArray(int[] inputArray) {
        int i, len = inputArray.length;

        for(i = 0; i < len; i++){
            if(inputArray[i] >= 7){
                inputArray[i] -= 7;
            } else {
                inputArray[i] = 10 - Math.abs(inputArray[i] - 7);
            }
        }

        return inputArray;
    }

    private int[] swapIndexValue(int[] inputArray, int first, int second) {
        int temp;
        temp = inputArray[first];
        inputArray[first] = inputArray[second];
        inputArray[second] = temp;
        return inputArray;
    }

    private String intArrayToString(int[] inputArray) {
        StringBuilder builder = new StringBuilder(4);
        int i, len = inputArray.length;
        for(i = 0; i < len; i++){
            builder.append(inputArray[i]);
        }
        return builder.toString();
    }
}
