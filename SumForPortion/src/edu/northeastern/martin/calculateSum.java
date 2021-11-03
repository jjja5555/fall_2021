package edu.northeastern.martin;

public class calculateSum implements  Runnable{
    private int portionNum;

    @Override
    public void run() {
        long sum = 0;
        for (int i = portionNum* Main.portionSize; i < portionNum * Main.portionSize + Main.portionSize; i++) {
            sum+= Main.values[i];
        }
        Main.portionSum[portionNum] = sum;
    }

    public calculateSum(int portionNum) {
        this.portionNum = portionNum;
    }
}
