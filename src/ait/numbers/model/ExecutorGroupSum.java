package ait.numbers.model;

import ait.numbers.task.OneGroupSum;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ExecutorGroupSum extends GroupSum {
    public ExecutorGroupSum(int[][] numberGroups) {
        super(numberGroups);
    }

    @Override
    public int computeSum() {
        // TODO Homework: reduce sum numbers of numberGroups, use ExecutorService
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        List<OneGroupSum> tasks =
//        executorService.shutdown();
//        try {
//            executorService.awaitTermination(1, TimeUnit.MINUTES);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return 0;
    }
}

