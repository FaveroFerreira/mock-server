package org.faveroferreira.mockserver.util.failure;

import org.faveroferreira.mockserver.util.PotentialFailure;

public class NoFailure implements PotentialFailure {

    @Override
    public void occur() {
        System.out.println("Success");
    }

    @Override
    public void reset() {
        // n precisa resetar
    }

}
