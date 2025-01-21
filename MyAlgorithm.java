/**
 * This class contains an algorithm utilizing a stack or queue. 
 */
public class MyAlgorithm {
    /**
     * Returns whether or not the given string contains a valid arrangement of brackets
     * 
     * @param input the input string containing brackets
     * @throws NullPointerException if the given string is null
     * @return the whether or not the given string contains a valid arrangement of brackets
     */
    public static boolean isValidBrackets(String input) {
        MyStack<Character> bracketStack = new MyStack<Character>(input.length());
        char currChar;
        char lastBracket;
        for (int i = 0; i < input.length() ; i++) {
            currChar = input.charAt(i);
            if (currChar == '(' || currChar == '[' || currChar == '{') {
                bracketStack.push(currChar);
            } else if (currChar == ')' || currChar ==']' || currChar == '}') {
                lastBracket = bracketStack.pop();
                if ((currChar == ')' && lastBracket != '(') || 
                    (currChar == ']' && lastBracket != '[') || 
                    (currChar == '}' && currChar != '{')) {
                    return false;
                }
            }
        }
        if (bracketStack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
