/*https://www.hackerrank.com/challenges/array-left-rotation/problem*/

/* Array Left Rotation */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static String arrayToSpaceSeparatedString(int[] a){
        StringBuilder builder= new StringBuilder();
        
        for(int i=0; i < a.length; i++){
            builder.append(a[i]);
            if(i!=a.length-1){
                builder.append(" ");
            }
        }
        return builder.toString();
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        scanner.close();

        // write your code here
        if(d==0 || d==a.length){
            System.out.println(arrayToSpaceSeparatedString(a));
        }
        else{
           for(int i=0; i<d;i++){
               int temp= a[0];
               for(int j=0; j<a.length-1;j++){
                    // left rotate array
                    a[j]=a[j+1];
               }
               a[a.length-1]=temp;
           }
           System.out.println(arrayToSpaceSeparatedString(a));
        }
    }
}
