import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Program {
    public static void main (String args[]) throws InterruptedException {
        Vector myVector = new Vector();
        System.out.print("Введите длину списка: ");
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        insert(myVector, length);System.out.println("Введите количество потоков: ");
        int numberOfThread = input.nextInt();
        MyThread[] threadArray = new MyThread[numberOfThread];
        System.out.println("Введите множитель: ");
        int mul = input.nextInt();
        for(int j =0;j<numberOfThread;j++){
            threadArray[j] = new MyThread(j,myVector,mul,numberOfThread);
        }
        long dt1 = System.currentTimeMillis();
        for(MyThread mt : threadArray){
            mt.start();
        }
        for(MyThread mt : threadArray){
            mt.join();
        }
        long dt2 = System.currentTimeMillis();
        long dt = dt2-dt1;
        System.out.println("Для "+numberOfThread+" потоков" );
        System.out.println(dt+" мс");
        MyThread thr1 = new MyThread(0,myVector,mul,1);
        dt1= System.currentTimeMillis();
        thr1.start();
        thr1.join();
        dt2= System.currentTimeMillis();
        dt = dt2-dt1;
        System.out.println("Для 1 потока" );
        System.out.println(dt+" мс");

    }

    private static void insert(Vector myVector,int length){
        Random ran = new Random();
        int i =0;
        while(i<length){
            myVector.add(ran.nextInt(999)+1);
            i++;
        }
    }
}
