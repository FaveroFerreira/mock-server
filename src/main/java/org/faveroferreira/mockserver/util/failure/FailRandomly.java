package org.faveroferreira.mockserver.util.failure;

import org.faveroferreira.mockserver.util.PotentialFailure;

import java.util.Random;

public class FailRandomly implements PotentialFailure  {

    final private Random random = new Random();
    final private int numberOfOperations;
    private int failedCount;

    public FailRandomly(int numberOfOperations) {
        this.numberOfOperations = numberOfOperations;
    }

    @Override
    public void occur() {
        boolean canFail = numberOfOperations / 2 >= failedCount;

        if (canFail && random.nextInt() % 2 == 0) {
            failedCount++;
            System.out.println("Operation failed");
            throw new RuntimeException("Operation failed");
        }
    }

    @Override
    public void reset() {
        // n precisa impl
    }

}
