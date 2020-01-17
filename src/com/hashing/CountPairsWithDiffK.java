package com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountPairsWithDiffK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] ar = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(br.readLine().trim());

            int count = 0;
            if (k==0){
                HashMap<Integer,Integer> map = new HashMap<>();
                for (Integer num : ar){
                    if (map.containsKey(num)){
                        map.put(num, map.get(num)+1);
                    }else {
                        map.put(num,1);
                    }
                }

                for (Map.Entry<Integer,Integer> mp : map.entrySet()){
                    count += (mp.getValue()/2);
                }
            }else {
                int max = 10001;
                boolean[] tmp = new boolean[max];
                Arrays.fill(tmp,false);

                for (Integer num : ar){
                    tmp[num] = true;
                }

                for (Integer num : ar){
                    if (num-k > 0 && tmp[num-k]){
                        count++;
                    }

                    if (num + k < max && tmp[num+k]){
                        count++;
                    }

                    tmp[num] = false;
                }
            }

            System.out.println(count);
        }
    }
}
