package org.faveroferreira.mockserver.chaos.failure;

import lombok.extern.slf4j.Slf4j;
import org.faveroferreira.mockserver.chaos.PotentialFailure;

@Slf4j
public class NoFailure implements PotentialFailure {

    @Override
    public void occur() {
        log.info("M=NoFailure, succeeded operation");
    }

    @Override
    public void reset() {
        // n precisa resetar
    }

}
