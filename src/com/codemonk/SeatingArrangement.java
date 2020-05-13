package com.codemonk;

import java.util.HashMap;
import java.util.Scanner;

public class SeatingArrangement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int compartmentNo;

            if (n % 12 == 0) {
                compartmentNo = n / 12;
            } else {
                compartmentNo = n / 12 + 1;
            }

            int lastSeatInCompartment = 12 * compartmentNo;
            int firstSeatInCompartment = (compartmentNo == 1) ? 1 : lastSeatInCompartment - 11;

            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 11);
            map.put(1, 9);
            map.put(2, 7);
            map.put(3, 5);
            map.put(4, 3);
            map.put(5, 1);

            int facingSeat = 0;
            boolean leftSide = false, firstOrLast = false;
            int seatSeq;
            String seatType = null;

            if (n == firstSeatInCompartment) {
                facingSeat = lastSeatInCompartment;
                seatType = "WS";
            } else if (n == lastSeatInCompartment) {
                facingSeat = firstSeatInCompartment;
                seatType = "WS";
            } else {
                firstOrLast = true;
                if (n - firstSeatInCompartment < lastSeatInCompartment - n) {
                    leftSide = true;
                }
            }

            if (firstOrLast){
                if (leftSide) {
                    facingSeat = n + map.get(n - firstSeatInCompartment);
                    seatSeq = (n - firstSeatInCompartment) + 1;
                } else {
                    facingSeat = n - map.get(lastSeatInCompartment - n);
                    seatSeq = (lastSeatInCompartment - n) + 1;
                }

                if (seatSeq > 3) {
                    seatType = getTopSeatType(seatSeq % 3);
                } else {
                    seatType = getBottomSeatType(seatSeq % 3);
                }
            }

            System.out.println(facingSeat + " " + seatType);
        }
    }

    private static String getBottomSeatType(int seatSeq) {
        if (seatSeq == 0){
            return "AS";
        }else if (seatSeq == 2){
            return "MS";
        }else {
            return "WS";
        }
    }

    private static String getTopSeatType(int seatSeq) {
        if (seatSeq == 0){
            return "WS";
        }else if (seatSeq == 2){
            return "MS";
        }else {
            return "AS";
        }
    }
}
