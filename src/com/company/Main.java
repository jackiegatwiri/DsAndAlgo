package com.company;

import javafx.scene.effect.SepiaTone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SlidingWindow slidingWindow = new SlidingWindow();
//        System.out.println(slidingWindow.longestSubstring("AAAHHIBC", 2));
        Strings s = new Strings();
//        System.out.println(s.palindrome("civic"));

//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);

//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = null;
//
//        Node head = new List().reverseRecursively(node1);
//        DynamicProgramming dynamicProgramming = new DynamicProgramming();
//        System.out.println( dynamicProgramming.recursiveStairCaseBottomUp(3, new int[]{1,3,5}));
//
//        Arrays arrays = new Arrays();
//        System.out.println(arrays.infiniteArray(new int[]{1,3,5,6,7,8,9,10,12,13}, 9));
//
//        MicrosoftQuestions microsoftQuestions = new MicrosoftQuestions();
//        System.out.println(microsoftQuestions.twoSum(new int[]{2,4,5,7,6,8}, 14)[0]);



//        List list = new List();
//        Node head;
//        list.insert(5);
//        list.insert(12);
//        list.insert(20);
//        list.insertAtStart(34);
//        list.show();

        ArrayList<Status> statuses = new ArrayList<>();
        Status status1 = new Status(1);
        Status status2 = new Status(2);
        Status status3 = new Status(3);
        statuses.add(status1);
        statuses.add(status2);
        statuses.add(status3);

        ArrayList<Holder> container = new ArrayList<>();
        Holder holder = new Holder("jackie", 1);
        Holder holder1 = new Holder("tosh", 2);
        Holder holder2 = new Holder("kesh", 3);
        Holder holder3 = new Holder("tev", 4);
        container.add(holder);
        container.add(holder1);
        container.add(holder2);
        container.add(holder3);

        List<Integer> statuseses = statuses.stream()
                .map(Status::getStatus)
                .collect(Collectors.toList());

        List<Holder> res = container.stream()
                .filter(e -> !statuseses.contains(e.getStatus()))
                .collect(Collectors.toList());

       res.forEach(e -> System.out.println(e.name));




    }
}
