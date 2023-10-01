package com.dsa.stacknqueues;

public class DynamicStack extends CustomStack {

    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int n) throws Exception {
        if(this.isFull()){
            int[] temp = new int[data.length*2];
            int i = 0;
            for (int element : data) {
                temp[i] = element;
                i++;
            }
            data = temp;
        }

        return super.push(n);
    }
}
