package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number: ");
        String num = input.nextLine();

        ArrayList<Integer> numList = new ArrayList<Integer>();

        for (int i = 0; i < num.length(); i++) {
            int digit = Integer.parseInt("" + num.charAt(i));
            numList.add(digit);
        }

        ArrayList<Integer> sumPre1 = new ArrayList<Integer>();

        int sum1 = 0;
        String prodList = "";
        for (int i = numList.size()-2; i >= 0; i=i-2) {
            int val = numList.get(i);
            String prod = "" + (val * 2);
            prodList += prod;
        }
        for (int i = 0; i < prodList.length(); i++) {
            int digit2 = Integer.parseInt("" + prodList.charAt(i));
            sumPre1.add(digit2);
            sum1 += sumPre1.get(i);
        }

        int totalSum = sum1;
        for (int i = numList.size()-1; i >= 0; i=i-2) {
            int val2 = numList.get(i);
            totalSum += val2;
        }

       if (num.length() == 15 && totalSum % 10 == 0 && num.charAt(0) == '3' && (num.charAt(1) == '4' || num.charAt(1) == '7')) {
            System.out.println("AMEX");
        } else if ((num.length() == 13 || num.length() == 16) && totalSum % 10 == 0 && num.charAt(0) == '4') {
            System.out.println("VISA");
        } else if (num.length() == 16 && totalSum % 10 == 0 && num.charAt(0) == '5' && 
               (num.charAt(1) == '1' || num.charAt(1) == '2' || num.charAt(1) == '3' || num.charAt(1) == '4' || num.charAt(1) == '5')) {
            System.out.println("MASTERCARD");
        } else {
            System.out.println("INVALID");
        }

    }
}
