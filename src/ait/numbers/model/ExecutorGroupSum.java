package ait.numbers.model;

import ait.numbers.task.OneGroupSum;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class ExecutorGroupSum extends GroupSum {
    public ExecutorGroupSum(int[][] numberGroups) {
        super(numberGroups);
    }

    @Override
    public int computeSum() {
        // TODO Homework: reduce sum numbers of numberGroups, use ExecutorService

//        ExecutorService executorService = Executors.newWorkStealingPool();
            int poolSize = Runtime.getRuntime().availableProcessors();
            ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
            List<OneGroupSum> groupSums = Arrays.stream(numberGroups)
                    .map(OneGroupSum::new)
                    .peek(executorService::execute)
                    .collect(Collectors.toList());
            executorService.shutdown();
            try {
                executorService.awaitTermination(1, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return groupSums.stream().mapToInt(OneGroupSum::getSum).sum();
        }
    }


