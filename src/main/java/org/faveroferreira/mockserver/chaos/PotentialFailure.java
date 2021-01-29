package org.faveroferreira.mockserver.chaos;

public interface PotentialFailure {

    void occur();
    void reset();

}
