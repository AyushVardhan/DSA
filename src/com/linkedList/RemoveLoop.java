package com.linkedList;

import java.util.Scanner;

class NodeK1 {
    int data;
    NodeK1 next;

}

public class RemoveLoop {
    public static NodeK1 newNode(int data) {
        NodeK1 temp = new NodeK1();
        temp.data = data;
        temp.next = null;
        return temp;
    }

    public static NodeK1 insert(NodeK1 head, int data) {
        if (head == null)
            head = newNode(data);
        else
            head.next = insert(head.next, data);
        return head;

    }

    public static void makeLoop(NodeK1 head, int x) {
        if (x == 0)
            return;
        NodeK1 curr = head;
        NodeK1 last = head;

        int counter = 0;
        while (counter < x) {
            curr = curr.next;
            counter++;
        }

        while (last.next != null)
            last = last.next;
        last.next = curr;
    }

    public static int detectloop(NodeK1 head) {
        NodeK1 hare = head.next;
        NodeK1 tortoise = head;
        while (hare != tortoise && hare != null && tortoise != null) {
            hare = hare.next;
            tortoise = tortoise.next;
            if (hare != null && hare.next != null)
                hare = hare.next;

            if (hare == tortoise)
                return 1;
        }

        if (hare == tortoise)
            return 1;
        return 0;
    }


    public static int length(NodeK1 head, boolean hasloop) {
        int len = 0;
        if (hasloop == false) {
            NodeK1 temp = head;
            while (temp != null) {
                len++;
                temp = temp.next;
            }

            return len;
        } else {
            NodeK1 hare = head.next;
            NodeK1 tortoise = head;
            while (hare != tortoise) {
                hare = hare.next;
                tortoise = tortoise.next;
                hare = hare.next;

                if (hare == tortoise)
                    break;
            }


            int looplen = 0;
            while (hare.next != tortoise) {
                hare = hare.next;
                looplen++;

            }

            looplen++;

            NodeK1 begin = head;
            int startlen = 0;
            tortoise = tortoise.next;
            while (begin != tortoise) {

                begin = begin.next;
                tortoise = tortoise.next;
                startlen++;

            }

            return looplen + startlen;

        }
    }

    public static void main(String[] args) {
        /* code */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int sizeOfArray = sc.nextInt();
            int arr[] = new int[sizeOfArray];

            for (int i = 0; i < sizeOfArray; i++)
                arr[i] = sc.nextInt();

            NodeK1 head = null;

            for (int i = 0; i < sizeOfArray; i++) {
                head = insert(head, arr[i]);
            }
            int x = sc.nextInt();
            makeLoop(head, x);

            int length = 0;
            if (detectloop(head) == 1) {
                length = length(head, true);
            } else {
                length = length(head, false);
            }
            removeTheLoop(head);

            if (detectloop(head) == 0 && length == length(head, false))
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    private static void removeTheLoop(NodeK1 head) {
        if (head == null || head.next == null)
            return;

        NodeK1 slow = head.next, fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast) {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
    }
}
