package concurrent;

import functions.*;

public class ReadWriteTaskExecutor {
    public static void main(String[] args) {
        TabulatedFunction function = new LinkedListTabulatedFunction(new ConstantFunction(-1),1,1000,1000);
        ReadTask rTask=new ReadTask(function);
        WriteTask wTask=new WriteTask(function,0.5);
        Thread threadRead=new Thread(rTask);
        Thread threadWrite=new Thread(wTask);
        threadRead.start();
        threadWrite.start();

    }
}
