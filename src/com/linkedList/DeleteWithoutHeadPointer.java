package com.linkedList;

import java.util.*;

public class DeleteWithoutHeadPointer
{
    Node head;

    void printList(Node head)
    {
        Node tnode = head;
        while(tnode != null)
        {
            System.out.print(tnode.data+ " ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    void addToTheLast(Node node)
    {

        if(head == null)
        {
            head = node;
        }else
        {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    Node search_Node(Node head, int k)
    {
        Node current = head;
        while(current != null)
        {
            if(current.data == k)
                break;
            current = current.next;
        }
        return current;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            DeleteWithoutHeadPointer llist = new DeleteWithoutHeadPointer();
            //int n=Integer.parseInt(br.readLine());
            int a1=sc.nextInt();
            Node head= new Node(a1,null);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a,null));
            }

            int k = sc.nextInt();
            Node del = llist.search_Node(llist.head,k);

            GfG g = new GfG();
            if(del != null && del.next != null)
            {
                g.deleteNode(del);
            }
            llist.printList(llist.head);
            t--;
        }
    }
}

class GfG
{
    void deleteNode(Node node)
    {
        // Your code here
    }
}
