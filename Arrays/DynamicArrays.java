/*https://www.hackerrank.com/challenges/dynamic-array/problem*/
/* Dynamic Arrays*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    ArrayList<ArrayList<Integer>> seqList = new ArrayList<ArrayList<Integer>>();
        int lastAnswer=0;

ArrayList<Integer> op = new ArrayList<Integer>();

    for(int i=0;i<n;i++){
        seqList.add(new ArrayList<Integer>());
    }
        
        
        for(int i=0;i<queries.size();i++){
            List<Integer> query = queries.get(i);
            int m = query.get(0);
            int x = query.get(1);
            int y = query.get(2);
            int seqq = (x^lastAnswer)%n;
            
            if(m==1){
                    ArrayList<Integer> ar= seqList.get(seqq);
                    ar.add(y);
            }
            if(m==2){
                int pos = y%seqList.get(seqq).size();
                lastAnswer = seqList.get(seqq).get(pos);
                op.add(lastAnswer);
                
            }
        }
       
        return op;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        // if(result.isEmpty()) return;

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
