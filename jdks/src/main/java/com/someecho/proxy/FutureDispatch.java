package com.someecho.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by lulu on 17/7/20.
 */
public class FutureDispatch extends FutureSetting {
    private static final Logger LOGGER = LoggerFactory.getLogger(FutureDispatch.class);

    protected int workThread = 40;

    protected ExecutorService executorService;

    public FutureDispatch(int workThread) {
        executorService = Executors.newFixedThreadPool(workThread);
    }

    public FutureDispatch() {
        executorService = Executors.newFixedThreadPool(workThread);
    }

    public FutureDispatch(ExecutorService executorService) {
        this.executorService = executorService;
    }


    public <T> Future<T> submit() {
        InvokeContext invokeContext = FutureSetting.getInvokeContext();
        final Method method = invokeContext.method;
        final Object[] args = invokeContext.args;
        final Object object = invokeContext.bean;
        final long submitTime = System.currentTimeMillis();
        if (!isRemote(invokeContext)) {
            Future<T> future = executorService.submit(new Callable<T>() {
                @Override
                public T call() throws Exception {
                    long startTime = System.currentTimeMillis();
                    try {
                        T res = (T) method.invoke(object, args);
                        long endTime = System.currentTimeMillis();
                        LOGGER.info("FutureDispatch submit method: {},waitTime={}ms, executionTime={}ms", method.getName(), startTime - submitTime, endTime - startTime);
                        return res;
                    } catch (IllegalAccessException | IllegalArgumentException ex) {
                        LOGGER.error(ex.getCause()!=null?ex.getCause().getMessage():ex.getMessage(),ex.getCause());
                        throw  new InvocationError(ex.getCause().getMessage());
                    } catch (InvocationTargetException e) {
                        LOGGER.error(e.getCause()!=null?e.getCause().getMessage():e.getMessage(),e.getCause());
                        throw  new InvocationError(e.getCause().getMessage());
                    }
                }
            });
            return future;
        }
        return null;

    }

    private boolean isRemote(InvokeContext args) {
        return false;
    }

    public static void setWorkThread(int workThread) {
        workThread = workThread;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    /**
     * 如果new的时候最后记得调用，如果非new，不要调用。
     */
    public final void shutdown(){
        this.executorService.shutdown();
    }
}
