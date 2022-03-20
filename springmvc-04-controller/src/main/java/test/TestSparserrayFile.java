package test;

import java.util.Arrays;
import java.util.Scanner;

public class TestSparserrayFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sort[]=new int[5];
        for (int i=0;i<5;i++){
            sort[i]=input.nextInt();
        }
        Arrays.sort(sort);
        for (int i=0;i<4;i++){
           if (sort[i+1]-sort[i]!=1){
               System.out.println("这五张不是连续的纸牌");
               return;
           }
        }
        System.out.println("这五张是连续的纸牌");

    }
}
