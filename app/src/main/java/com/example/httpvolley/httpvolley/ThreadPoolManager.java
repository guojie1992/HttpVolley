package com.example.httpvolley.httpvolley;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/3/9.
 */

public class ThreadPoolManager {
    //添加任务到请求队列
    private LinkedBlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();
    //添加任务就是添加线程
    public void excute(Runnable runnable){
        if (runnable != null) {
            try {
                queue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //把任务放到线程池；
    private ThreadPoolExecutor threadPoolExecutor;
    private ThreadPoolManager(){
        threadPoolExecutor = new ThreadPoolExecutor(4,20,15, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(4));
        //开启传动带
        threadPoolExecutor.execute(runnable);
    }

    //拒绝策略,将超时的线程重新放回线程池；
    private RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable runnable/*runnable 超时的线程*/, ThreadPoolExecutor threadPoolExecutor) {
            try {
                queue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (true){
                Runnable runnable = null;
                try {
                    //从队列里取线程；
                    runnable = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (runnable != null){
                    threadPoolExecutor.execute(runnable);
                }
            }
        }
    };

    //写成单列模式
    private static ThreadPoolManager ourInstace = new ThreadPoolManager();
    public static ThreadPoolManager getourInstace(){
        return  ourInstace;
    }

}
