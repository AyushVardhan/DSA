package com.JavaConcepts;

/*
Example of Transient in java
 */

import java.io.*;

public class Student implements Serializable {
    int id;
    String name;
    transient int age;//Now it will not be serialized

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age=age;
    }
}

class PersistExample{
    public static void main(String args[])throws Exception{
        Student s1 =new Student(211,"ravi",22);//creating object
        s1.setAge(21);

        //writing object into file
        FileOutputStream f=new FileOutputStream("f.txt");
        ObjectOutputStream out=new ObjectOutputStream(f);
        out.writeObject(s1);
        out.flush();

        out.close();
        f.close();
        System.out.println("success");
    }
}

class DePersist{
    public static void main(String args[])throws Exception{
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));
        Student s=(Student)in.readObject();
        System.out.println(s.id+" "+s.name+" "+s.age);
        in.close();
    }
}