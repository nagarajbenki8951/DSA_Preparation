package com.nagaraj.dsa.basic.stacks.problems;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String args[]){
        Stack<Character> stack = new Stack<>();
        String s ="[][][][}][]";

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ']' || s.charAt(i) == '}'){
               if(stack.empty()){
                   System.out.println("Given string is not a valid paranthesis");
                   break;
               }else{
                  char top=  stack.pop();
                   if ((s.charAt(i) == ']' && top != '[') ||
                           (s.charAt(i) == '}' && top != '{')){
                       System.out.println("Given string is not a valid paranthesis");
                       break;
                   }
               }
            }
        }
    }
}
