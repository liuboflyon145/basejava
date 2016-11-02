package com.watcher.strategy1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Client {

    public static void main(String[] args) {


        // 按姓名name进行排序
        SortByName sortbyname = new SortByName();
        Environment environment = new Environment(sortbyname);

        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();


        ArrayList list = new ArrayList();

        p1.setName("zhangsan");
        p1.setId(1);
        p1.setAge(20);

        p2.setName("lisi");
        p2.setId(5);
        p2.setAge(25);

        p3.setName("wangwu");
        p3.setId(16);
        p3.setAge(5);

        p4.setName("zhangsan");
        p4.setId(6);
        p4.setAge(5);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);


        System.out.println("--------------------- 按照name升序排列 -----------------------");
        // 按照name进行排序
        Collections.sort(list, environment.getComparator());

        for (Iterator iter = list.iterator(); iter.hasNext(); ) {

            Person p = (Person) iter.next();
            System.out.println(p.getName() + "    " + p.getId()+"  "+p.getAge());

        }

        sortbyname.setSortType(1);
        System.out.println("--------------------- 按照name降序排列start -----------------------");
        // 按照name进行排序
        Collections.sort(list, environment.getComparator());

        for (Iterator iter = list.iterator(); iter.hasNext(); ) {

            Person p = (Person) iter.next();
            System.out.println(p.getName() + "    " + p.getId()+"  "+p.getAge());
        }

        System.out.println("----------------------  按照id升序排列  ----------------------");

        SortById sortbyid = new SortById();
        environment.setComparator(sortbyid);
        Collections.sort(list, environment.getComparator());

        for (Iterator iter = list.iterator(); iter.hasNext(); ) {

            Person p = (Person) iter.next();
            System.out.println(p.getName() + "    " + p.getId()+"  "+p.getAge());

        }

        System.out.println("----------------------  按照id降序排列      ----------------------");

        sortbyid.setSortType(1);
        Collections.sort(list, environment.getComparator());

        for (Iterator iter = list.iterator(); iter.hasNext(); ) {

            Person p = (Person) iter.next();
            System.out.println(p.getName() + "    " + p.getId()+"  "+p.getAge());

        }


        System.out.println("----------------------  按照age升序排列  ----------------------");

        SortByAge sortbyage = new SortByAge();
        environment.setComparator(sortbyage);
        Collections.sort(list, environment.getComparator());

        for (Iterator iter = list.iterator(); iter.hasNext(); ) {

            Person p = (Person) iter.next();
            System.out.println(p.getName() + "    " + p.getId()+"  "+p.getAge());

        }

        System.out.println("----------------------  按照age降序排列      ----------------------");

        sortbyage.setSortType(1);
        Collections.sort(list, environment.getComparator());

        for (Iterator iter = list.iterator(); iter.hasNext(); ) {

            Person p = (Person) iter.next();
            System.out.println(p.getName() + "    " + p.getId()+"  "+p.getAge());
        }

    }

}