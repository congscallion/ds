package io.ds.congscallion.excutor;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        FutureTask<int[]> task = new FutureTask(new MyTask());
        Thread t = new Thread(task, "Task-1");
        t.start();

        FutureTask<int[]> task2 = new FutureTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task2.run invoked!");
            }
        }, new int[]{});
        Thread t2 = new Thread(task2, "Task-2");
        t2.start();


        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int[] ints = task.get();
                    System.out.println("Thread: " + Thread.currentThread().getName() + ", result: " + Arrays.toString(ints));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-3");
        t3.start();


        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int[] ints = task.get();
                    System.out.println("Thread: " + Thread.currentThread().getName() + ", result: " + Arrays.toString(ints));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-4");
        t4.start();


        t.join();
        t2.join();
        t3.join();
        t4.join();


        int[] res = task.get();
        System.out.println("task1 result: " + Arrays.toString(res));

        int[] res2 = task2.get();
        System.out.println("task2 result: " + Arrays.toString(res2));


    }
}


class MyTask implements Callable<int[]> {

    @Override
    public int[] call() throws Exception {
        System.out.println("MyTask.call() invoked!");
        return new int[]{1, 2, 3, 45};
    }
}