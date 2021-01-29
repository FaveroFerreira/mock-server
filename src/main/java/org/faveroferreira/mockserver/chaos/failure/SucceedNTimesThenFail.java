package org.faveroferreira.mockserver.chaos.failure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.faveroferreira.mockserver.chaos.PotentialFailure;

@Slf4j
@RequiredArgsConstructor
public class SucceedNTimesThenFail implements PotentialFailure {

    private final int numberOfOperations;
    private int successCount;

    @Override
    public void occur() {
        if (successCount < numberOfOperations) {
            successCount++;
            return;
        }

        reset();
        throw new RuntimeException("M=SucceedNTimesThenFail, failure occurred");
    }

    @Override
    public void reset() {
        this.successCount = 0;
    }
}