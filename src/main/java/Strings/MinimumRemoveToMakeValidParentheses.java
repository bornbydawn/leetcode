package Strings;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class MinimumRemoveToMakeValidParentheses {
    
    public static void main(String[] args) {
        //String s = "lee(t(c)o)de)";
        //String s = "(a(b(c)d)";
        //String s = "()";
        //String s = "))((";
        String s = "a)b(c)d";
        System.out.println(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s));
    }
    // public String minRemoveToMakeValid(String s) {
    //     int openCount = 0;
    //     int closeCount = 0;

    //     List<Character> charList = s.chars().mapToObj(e -> (char)e) .collect(Collectors.toList());
        
    //     Iterator<Character> iterator = charList.iterator();
    //     while(iterator.hasNext()){
    //         char next = iterator.next();
    //         if(next == '(') openCount++;
    //         if(next == ')') closeCount++;
    //         if(closeCount > openCount) {
    //             iterator.remove();
    //             closeCount--;
    //         }
    //     }
        
    //     ListIterator<Character> iterator2 = charList.listIterator(charList.size());
    //     openCount = 0;
    //     closeCount = 0;

    //    while(iterator2.hasPrevious()){
    //     char previous = iterator2.previous();
    //     if(previous == ')') openCount++;
    //     if(previous == '(') closeCount++;
    //     if(closeCount > openCount) {
    //         iterator2.remove();
    //         closeCount--;
    //     }
    //    }
    //    StringBuilder stringBuilder = new StringBuilder();
    //    for(int i = 0; i < charList.size(); i++){
    //        stringBuilder.append(charList.get(i));
    //    }
    //    return stringBuilder.toString();
    // }

    public String minRemoveToMakeValid(String s) {
        int openCount = 0;
        int closeCount = 0;

        char[] charList = s.toCharArray();
        for(int i = 0; i < charList.length; i++){
            if(charList[i] == '(') openCount++;
            if(charList[i] == ')') closeCount++;
            if(closeCount > openCount) {
                charList[i] = ' ';
                closeCount--;
            }
        }
        openCount = 0;
        closeCount = 0;
        for(int i = charList.length - 1; i >= 0; i--){
            if(charList[i] == ')') openCount++;
            if(charList[i] == '(') closeCount++;
            if(closeCount > openCount) {
                charList[i] = ' ';
                closeCount--;
            }
        }
       StringBuilder stringBuilder = new StringBuilder();
       for(int i = 0; i < charList.length; i++){
           if(charList[i] != ' ') stringBuilder.append(charList[i]);
       }
       return stringBuilder.toString();
    }
}
