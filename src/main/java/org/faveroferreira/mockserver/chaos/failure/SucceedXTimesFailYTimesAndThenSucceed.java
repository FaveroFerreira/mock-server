package org.faveroferreira.mockserver.chaos.failure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.faveroferreira.mockserver.chaos.PotentialFailure;

@Slf4j
@RequiredArgsConstructor
public class SucceedXTimesFailYTimesAndThenSucceed implements PotentialFailure {

    private final int numberOfSuccessfulOperations;
    private final int numberOfFailedOperations;
    private int successCount;
    private int failCount;

    @Override
    public void occur() {
        if (successCount < numberOfSuccessfulOperations) {
            successCount++;
            return;
        }

        if (failCount < numberOfFailedOperations) {
            failCount++;
            throw new RuntimeException("M=SucceedXTimesFailYTimesAndThenSucceed, failure occurred");
        }

        reset();
    }

    @Override
    public void reset() {
        this.failCount = 0;
        this.successCount = 0;
    }
}
