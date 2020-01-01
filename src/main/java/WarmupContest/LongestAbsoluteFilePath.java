package WarmupContest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LongestAbsoluteFilePath {
    public static int lengthLongestPath(String input) {

        if(input.contains("\n")){
            input = input.replaceAll(" ", "");
        }

        if(!input.contains(".")){
            return 0;
        }
        char[] arr = input.toCharArray();
        List<String> paths = new LinkedList<>();
        int currentTabs = 0;
        String currentPath;
        int i = 0;
        int j = 0;

        while(arr[j] != '\t' && j < arr.length){
            j++;
            if(j == arr.length){
                return 0;
            }
            if(arr[j] == '.'){
                return arr.length;
            }

        }
        j--;
        j--;
        currentPath = getStringFromCharacters(arr, i, j);

        List<String> pathTracker = new ArrayList<>();
        pathTracker.add(0, currentPath);
        j++;
        while(j < arr.length - 1){
            i = j;
            j = getPathMakers(i, arr);
            currentTabs = getTabCount(i, j, arr);

            i = j;
            j++;

            while(arr[j] != '\n' && j < arr.length){
                j++;
                if(j == arr.length){
                    break;
                }
            }
            j --;
            if(doesPathContainFile(i, j, arr)){
              StringBuilder stringBuilder = new StringBuilder();
                for(int k = 0; k < currentTabs; k++){
                  stringBuilder.append(pathTracker.get(k)).append("/");
              }
                stringBuilder.append(getStringFromCharacters(arr, i , j));
                paths.add(stringBuilder.toString());
            }
            else{
                pathTracker.add(currentTabs, getStringFromCharacters(arr, i, j));
            }

        }
        int maxLength = 0;

        for (String path:
             paths) {
            if(path.length() > maxLength){
                maxLength = path.length();
            }
        }

        return maxLength;
    }

    private static int getTabCount(int i, int j, char[] arr) {

        int currentTabs = 0;
        while(i < j){
            if(arr[i] == '\t'){
                currentTabs++;
            }
            i++;
        }
       return currentTabs;

    }
    private static boolean doesPathContainFile(int i, int j, char[] arr){

        while(i < j){
            if(arr[i] == '.'){
                return true;
            }
            i++;
        }

        return false;
    }

    private static int getPathMakers(int start, char[] arr){
        int end = start + 1;
        while(end < arr.length){
            if(arr[end] != '\t' && arr[end - 1] == '\t'){
                break;
            }
            end++;
        }
        return end;
    }

    private static String getStringFromCharacters(char[] arr, int i, int j){
        StringBuilder stringBuilder = new StringBuilder();
        while(i <= j){
            stringBuilder.append(arr[i]);
            i++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        //String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        //String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        //String s = "a";
        //String s = "a.txt";
        //String s = "a\n\tb\n\t\tc";
        String s = "dir\n    file.txt";
        //String s1 ="dir\n        file.txt";
        //String s = "file name with  space.txt";
        System.out.println(lengthLongestPath(s));
    }
}
