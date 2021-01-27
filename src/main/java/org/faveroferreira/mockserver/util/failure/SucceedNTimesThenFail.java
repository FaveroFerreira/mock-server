package org.faveroferreira.mockserver.util.failure;

import org.faveroferreira.mockserver.util.PotentialFailure;

public class SucceedNTimesThenFail implements PotentialFailure {

    int numberOfOperations;
    int successCount;

    public SucceedNTimesThenFail(int numberOfOperations) {
        this.numberOfOperations = numberOfOperations;
    }

    @Override
    public void occur() {
        if (successCount < numberOfOperations) {
            successCount++;
            return;
        }

        reset();
        throw new RuntimeException("Fail occurred");
    }

    @Override
    public void reset() {
        this.successCount = 0;
    }
}