import java.util.Vector;

public class MyThread extends Thread {
    int num;
    int mul;
    int numberOfThread;
    Vector<Integer> vector;
    public MyThread(int num, Vector<Integer> myVector, int mul, int numberOfThread){
        this.num = num;
        this.vector = myVector;
        this.mul = mul;
        this.numberOfThread = numberOfThread;
    }
    @Override
    public void run(){
        quest();
    }
    public void quest(){
        for(int j=num;j<vector.size();j+=numberOfThread){
            vector.set(j,vector.get(j)*mul);
        }
    }
}
