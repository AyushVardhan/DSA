package com.linkedList;

import java.util.Scanner;

class NodeClone {
    int data;
    NodeClone next, arb;

    NodeClone(int d) {
        data = d;
        next = arb = null;
    }
}


public class CloneListwithNextRandomPointer {
    static NodeClone head;

    public static void addToTheLast(NodeClone node) {
        if (head == null) {
            head = node;
        } else {
            NodeClone temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }

    public static boolean validation(NodeClone head, NodeClone res, NodeClone cloned_add,
                                     NodeClone generated_add) {

        if (generated_add == cloned_add) return false;

        NodeClone temp1 = head;
        NodeClone temp2 = res;

        int len1 = 0, len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        /*if lengths not equal */

        if (len1 != len2) return false;

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            if (temp1.data != temp2.data) return false;
            if (temp1.arb != null && temp2.arb != null) {
                if (temp1.arb.data != temp2.arb.data) return false;
            } else if (temp1.arb != null && temp2.arb == null)
                return false;
            else if(temp1.arb== null && temp2.arb !=null)
                return false;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }
    //   public static void printList()

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            NodeClone generated_add = null;
            int n = sc.nextInt();
            int q = sc.nextInt();

            int a1 = sc.nextInt();
            NodeClone head = new NodeClone(a1);
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                addToTheLast(new NodeClone(a));
            }

            for (int i = 0; i < q; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                NodeClone tempA = head;
                int count = -1;

                while (tempA != null) {
                    count++;
                    if (count == a - 1) break;
                    tempA = tempA.next;
                }
                NodeClone tempB = head;
                count = -1;

                while (tempB != null) {
                    count++;
                    if (count == b - 1) break;
                    tempB = tempB.next;
                }

                // when both a is greater than N
                if (a <= n) tempA.arb = tempB;
            }

            generated_add = head;
            CloneListwithNextRandomPointer g = new CloneListwithNextRandomPointer();
            NodeClone res = g.copyList(head);

            NodeClone cloned_add = res;

            if (validation(head, res, cloned_add, generated_add) == true)
                System.out.println("1");
            else
                System.out.println("false");
        }
    }

    private NodeClone copyList(NodeClone head) {
        if (head == null) return head;

        NodeClone t = head;
        while (t != null) {
            NodeClone n = new NodeClone(t.data);
            // n.data=t.data;
            n.next = t.next;
            t.next = n;
            t = n.next;
        }
        t = head;
        NodeClone head2 = head.next;
        while (t != null) {
            if (t.arb == null)
                t.next.arb = null;
            else {
                t.next.arb = t.arb.next;
            }
            t = t.next.next;
        }
        t = head;
        while (t != null) {
            t.next = t.next.next;
            t = t.next;
        }

        return head2;
    }
}
