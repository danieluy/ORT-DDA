package pkg20170321_pares_impares;

import java.util.ArrayList;

public class Logic {

    private ArrayList<Integer> list;
    private int length;

    public void setLength(int length) {
        this.length = length;
        this.list = new ArrayList();
    }

    public void addNumber(int val) {
        if (!complete()) {
            this.list.add(val);
        }
    }

    public ArrayList<Integer> getResult() {
        int[] counter = (new int[2]);
        countEvenOdd(counter);
        if (counter[0] == counter[1]) {
            return list;
        } else if (counter[0] > counter[1]) {
            return listEven();
        } else {
            return listOdd();
        }
    }

    public boolean complete() {
        return list.size() == length;
    }

    private ArrayList<Integer> listEven() {
        ArrayList<Integer> even = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                even.add(list.get(i));
            }
        }
        return even;
    }

    private ArrayList<Integer> listOdd() {
        ArrayList<Integer> odd = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 != 0) {
                odd.add(list.get(i));
            }
        }
        return odd;
    }

    private void countEvenOdd(int[] counter) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                counter[0]++;
            } else {
                counter[1]++;
            }
        }
    }
}
