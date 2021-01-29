package org.faveroferreira.mockserver.chaos.failure;

import lombok.extern.slf4j.Slf4j;
import org.faveroferreira.mockserver.chaos.PotentialFailure;

import java.util.Random;

@Slf4j
public class FailRandomly implements PotentialFailure {

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
            log.info("M=FailRandomly, failed operation");
            throw new RuntimeException("Operation failed");
        }
    }

    @Override
    public void reset() {
        // n precisa impl
    }

}
