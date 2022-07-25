package DataStructures_Lab3;

import java.util.ArrayDeque;

public class BalancedBrackets {

    public static boolean checkBracketsBalanced(String expression)
    {
        // Using ArrayDeque is faster than using Stack class
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
 
        // Traversing the Expression
        for (int i = 0; i < expression.length(); i++)
        {
            char character = expression.charAt(i);
 
            if (character == '(' ||  character == '[' || character == '{')
            {
                // Push the element in the stack
                stack.push(character);
                continue;
            }
 
            // If current character is not opening bracket, then it must be closing. 
      
            // So stack cannot be empty at this point.
            
            if (stack.isEmpty())
                return false;
            
            char ch;
            switch (character) {
            case ')':
                ch = stack.pop();
                if (ch == '{' || ch == '[')
                    return false;
                break;
 
            case '}':
                ch = stack.pop();
                if (ch == '(' || ch == '[')
                    return false;
                break;
 
            case ']':
                ch = stack.pop();
                if (ch == '(' || ch == '{')
                    return false;
                break;
            }
        }
 
        // Check Empty Stack
        return (stack.isEmpty());
    }
 
    // Driver code
    public static void main(String[] args)
    {
        String expr = "([{}])";
 
        // Function call
        if (checkBracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}

