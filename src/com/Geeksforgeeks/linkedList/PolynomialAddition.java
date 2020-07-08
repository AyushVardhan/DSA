package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

class PolyNode {
    int coeff;
    int pow;
    PolyNode next;

    PolyNode(int a, int b) {
        coeff = a;
        pow = b;
        next = null;
    }
}

public class PolynomialAddition {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            PolyNode start1 = null, cur1 = null, start2 = null, cur2 = null;
            while (n-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                PolyNode ptr = new PolyNode(a, b);
                if (start1 == null) {
                    start1 = ptr;
                    cur1 = ptr;
                } else {
                    cur1.next = ptr;
                    cur1 = ptr;
                }
            }
            n = sc.nextInt();
            while (n-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                PolyNode ptr = new PolyNode(a, b);
                if (start2 == null) {
                    start2 = ptr;
                    cur2 = ptr;
                } else {
                    cur2.next = ptr;
                    cur2 = ptr;
                }
            }
            PolynomialAddition obj = new PolynomialAddition();
            obj.addPolynomial(start1, start2);
            System.out.println();
        }
    }

    private void addPolynomial(PolyNode start1, PolyNode start2) {
        PolyNode poly = new PolyNode(0, 0);
        PolyNode tmp = poly;
        while (start1 != null && start2 != null) {
            if (start1.pow > start2.pow) {
                tmp.pow = start1.pow;
                tmp.coeff = start1.coeff;
                start1 = start1.next;
            } else if (start1.pow < start2.pow) {
                tmp.pow = start2.pow;
                tmp.coeff = start2.coeff;
                start2 = start2.next;
            } else {
                tmp.coeff = start1.coeff + start2.coeff;
                tmp.pow = start1.pow;
                start1 = start1.next;
                start2 = start2.next;
            }


            tmp.next = new PolyNode(0, 0);
            tmp = tmp.next;
            tmp.next = null;
        }

        while (start1 != null) {
            tmp.pow = start1.pow;
            tmp.coeff = start1.coeff;
            start1 = start1.next;

            tmp.next = new PolyNode(0, 0);
            tmp = tmp.next;
            tmp.next = null;
        }

        while (start2 != null) {
            tmp.pow = start2.pow;
            tmp.coeff = start2.coeff;
            start2 = start2.next;

            tmp.next = new PolyNode(0, 0);
            tmp = tmp.next;
            tmp.next = null;
        }

        while (poly != null && poly.coeff != 0) {
            System.out.print(poly.coeff + "x^" + poly.pow);
            if (poly.next != null && poly.next.coeff != 0)
                System.out.print(" + ");
            poly = poly.next;
        }
    }
}