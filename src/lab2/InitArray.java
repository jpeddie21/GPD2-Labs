package lab2;

import java.util.Arrays;

public class InitArray {

    public static void main(String[] args) {
        
        int[] a = new int[5];

        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        a[4] = 4;
        a[0] = 5;

        System.out.println(Arrays.toString(a));        
    }
}