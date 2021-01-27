package org.faveroferreira.mockserver.workbench;


import org.faveroferreira.mockserver.util.PotentialFailure;
import org.faveroferreira.mockserver.util.failure.FailRandomly;

public class Main {

    public static void main(String[] args) {
        PotentialFailure potentialFailure = new FailRandomly(10);

        for (int i = 0; i < 10; i++) {
            try {
                potentialFailure.occur();
            } catch (Exception e) {

            }
        }
    }

}
