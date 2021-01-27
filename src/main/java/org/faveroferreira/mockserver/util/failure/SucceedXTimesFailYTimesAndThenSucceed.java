package org.faveroferreira.mockserver.util.failure;

import org.faveroferreira.mockserver.util.PotentialFailure;

public class SucceedXTimesFailYTimesAndThenSucceed implements PotentialFailure {

    int numberOfSuccessfulOperations;
    int numberOfFailedOperations;
    int successCount;
    int failCount;

    public SucceedXTimesFailYTimesAndThenSucceed(int numberOfSuccessfulOperations, int numberOfFailedOperations) {
        this.numberOfSuccessfulOperations = numberOfSuccessfulOperations;
        this.numberOfFailedOperations = numberOfFailedOperations;
    }

    @Override
    public void occur() {
        if (successCount < numberOfSuccessfulOperations) {
            successCount++;
            return;
        }

        if (failCount < numberOfFailedOperations) {
            failCount++;
            throw new RuntimeException("Error ocurredzz");
        }

        reset();
    }

    @Override
    public void reset() {
        this.failCount = 0;
        this.successCount = 0;
    }
}
