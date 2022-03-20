package test;

import java.io.*;

public class Sparserray {
    public static void main(String[] args) throws IOException {
        //创建一个二位数组11*11
        //0:表示没有棋子，1表示黑子,2表示白子

        int cheeseArr1[][]=new int[11][11];
        cheeseArr1[1][2]=1;
        cheeseArr1[2][3]=2;
        cheeseArr1[4][5]=2;
        //输出原始的二位数组
        for (int[]row : cheeseArr1){
            for (int data:row){
                System.out.printf("%d\t",data);

            }
            System.out.println();
        }
        int sum=0;
        for (int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if (cheeseArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        int sparseArr[][]=new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        //遍历二维数组,将非0的数据存放到稀疏数组中
        int count=0;//用于记录是第几个非0数据
        for (int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if (cheeseArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=cheeseArr1[i][j];
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("稀疏数组为~~~~");
        OutputStream os=new FileOutputStream("C:/Users/qw/Desktop/map.data");
        InputStream is=new FileInputStream("C:/Users/qw/Desktop/map.data");
        System.out.println("输入文件~~~~");
        for (int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);

            os.write(sparseArr[i][0]);
            os.write(sparseArr[i][1]);
            os.write(sparseArr[i][2]);

        }
        /*System.out.println("读取的数组~~~~");*/
        os.close();
        //输出文件的稀疏数组
        /*int col=0;
        while (true){
            int data=is.read();
            if (data==-1){
                break;
            }
            col++;
            System.out.printf("%d\t",data);
                if (col==3){
                    System.out.println();
                    col=0;
                }
        }*/
        System.out.println("读取文件~~~~");
        int row1=is.read();
        int col1= is.read();
        int total=is.read();
        int sparseArr1[][]=new int [total+1][3];
        sparseArr1[0][0]=row1;
        sparseArr1[0][1]=col1;
        sparseArr1[0][2]=total;
        for(int i=1;i<total+1;i++){
            sparseArr1[i][0]=is.read();
            sparseArr1[i][1]=is.read();
            sparseArr1[i][2]=is.read();
        }
        for (int i=0;i<sparseArr1.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        int cheeseArr2[][]=new int[sparseArr1[0][0]][sparseArr1[0][1]];
        //恢复后的二位数组
        for (int i=1;i<sparseArr1.length;i++){
            cheeseArr2[sparseArr1[i][0]][sparseArr1[i][1]]=sparseArr1[i][2];
        }
        System.out.println();
        System.out.println("恢复后的二维数组~~~");
        for (int[]row : cheeseArr2){
            for (int data:row){
                System.out.printf("%d\t",data);

            }
            System.out.println();
        }





        /*int cheeseArr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
        //恢复后的二位数组
        for (int i=1;i<sparseArr.length;i++){
            cheeseArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        System.out.println();
        System.out.println("恢复后的二维数组");
        for (int[]row : cheeseArr2){
            for (int data:row){
                System.out.printf("%d\t",data);

            }
            System.out.println();
        }*/
    }
}
