package com.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenOranges {
    static int m,n;
    static class coord{
        int x,y;
        coord(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }

    public static boolean isValid(int i,int j)
    {
        return(i>=0 && j>=0 && i<m && j<n);
    }

    public static boolean delim(coord item)
    {
        return(item.x==-1 && item.y==-1);
    }

    public static boolean containsFresh(int arr[][])
    {
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {

                if(arr[i][j]==1)
                    return true;
            }
        }
        return false;
    }

    public static void main (String[] args) {

        Scanner sc= new Scanner(System.in);
        int tc=sc.nextInt();
        while(tc-->0)
        {
            Queue<coord> q=new LinkedList<coord>();

            m=sc.nextInt();
            n=sc.nextInt();
            int[][] arr= new int[m][n];

            //input oranges
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                    if(arr[i][j]==2)
                    {
                        q.add(new coord(i,j));

                    }
                }
            }

            q.add(new coord(-1,-1));
            int ans=0;

            while(q.isEmpty()==false)
            {
                boolean flag=false;
                while(!delim(q.peek()))
                {

                    coord temp=q.peek();
                    if(isValid(temp.x-1,temp.y) && arr[temp.x-1][temp.y]==1)
                    {

                        if(!flag)
                        {
                            ans++;
                            flag=true;
                        }

                        arr[temp.x-1][temp.y]=2;
                        temp.x--;


                        q.add(new coord(temp.x,temp.y));
                        temp.x++; //back to original value
                    }

                    // x+1;y
                    if(isValid(temp.x+1,temp.y) && arr[temp.x+1][temp.y]==1)
                    {
                        if(!flag)
                        {
                            ans++;
                            flag=true;
                        }

                        arr[temp.x+1][temp.y]=2;
                        temp.x++;
                        q.add(new coord(temp.x,temp.y));
                        temp.x--; //back to original value

                    }


                    // x;y-1
                    if(isValid(temp.x,temp.y-1) && arr[temp.x][temp.y-1]==1)
                    {
                        if(!flag)
                        {
                            ans++;
                            flag=true;
                        }
                        arr[temp.x][temp.y-1]=2;
                        temp.y--;
                        q.add(new coord(temp.x,temp.y));
                        temp.y++; //back to original value
                    }

                    // x;y+1
                    if(isValid(temp.x,temp.y+1) && arr[temp.x][temp.y+1]==1)
                    {
                        if(!flag)
                        {
                            ans++;
                            flag=true;
                        }
                        arr[temp.x][temp.y+1]=2;
                        temp.y++;
                        q.add(new coord(temp.x,temp.y));
                    }
                    q.poll();
                }
                q.poll(); //remove delimeter
                if(q.isEmpty()==false)
                    q.add(new coord(-1,-1));
            }
            //q is empty


            if(containsFresh(arr))
            {
                System.out.println("-1");
            }
            else
                System.out.println(ans);



        }
    }
}
