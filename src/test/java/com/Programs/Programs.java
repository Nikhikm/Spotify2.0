package com.Programs;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Programs
{

    @Test
    public void printonetoten()
    {
        for (int i=0;i<10;i++)
        {
            System.out.println(i);
        }
    }

    @Test
    public void printvowelsFromString()
    {
        int countvowel=0;
        int countCon=0;
        String nae = "Nikhil";
        String vowel = "";
        String cons="";
       String name= nae.toLowerCase();
        for(int i=0;i<name.length();i++)
        {
          char ch  =name.charAt(i);
          if(ch=='a'||ch=='e'||ch=='i'|| ch=='o'||ch=='u')
          {
              countvowel++;
              vowel = ch+ vowel;
             // System.out.println("vowel "+ch);
          }
          else {
              countCon++;
              cons = ch+ cons;
             // System.out.println(ch );
          }
        }

        System.out.println(countvowel);
        System.out.println(vowel);
        System.out.println(cons);
    }


    @Test
    public void swapText()
    {
        String s1 = "Nikhil";
        String s2="Shweta";
        String temp=s2;
         s2=s1;
         s1= temp;

        System.out.println(s2);
        System.out.println(s1);

    }

    @Test
    public void factorial()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter number for fact");
        int req =sc.nextInt();
        int fact =1;
        //int sum=0;

        for(int i=1;i<=req;i++){
            fact = fact*i;
        }

        System.out.println(fact);

    }

    @Test
    public void reverseNumber()
    {
        int num = 5678;
        while(num>0)
        {
            num= num%10;
        }
        System.out.println(num);
    }

    @Test
    public void reverseString()
    {
        String s1 ="Nikhuil";
        String s2="";

        for(int i=s1.length()-1;i>=0;i--)
        {
            s2= s2+s1.charAt(i);
        }

        System.out.println(s2);
    }

//    @Test
//    public void reerseStringinAsentence(){
//        String s1="Nikhil is my friend";
//        String [] array = s1.split(" ");
//        String
//        for(int i=0;i<array.length;i++){
//            String s1=array[i];
//            String s2=" ";
//
//            for()
//        }
//    }
}
