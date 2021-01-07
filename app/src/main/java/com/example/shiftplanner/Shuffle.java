package com.example.shiftplanner;

import java.util.Random;
import java.util.Arrays;
public class Shuffle
{
    // A Function to generate a random permutation of arr[]
    static void randomize(int arr[], int n)
    {
        //Dimiourgia object gia thn class Random
        Random r = new Random();

        //Ksekinaei apo to teleftaio stixeio tou array and ta allazei ena ena
        for (int i= n-1; i > 0; i--)
        {
            //dialegei ena random index apo to 0 mexri to i
            int j = r.nextInt(i);

            //allazei to arr[i] me to stoixeio sto tixaio index
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Prints the random array
        System.out.println(Arrays.toString(arr));

    }
}
