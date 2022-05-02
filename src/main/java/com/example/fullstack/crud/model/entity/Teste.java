package com.example.fullstack.crud.model.entity;

import java.util.LinkedHashSet;

public class Teste {

    public static int countAllStars(int galaxies[]) {
        int totalStars = 0;
        for (int stars : galaxies) {
            totalStars += stars; // fix me!
        }
        return totalStars;
    }

    public static String testando(int value) {
        String retornarLetra = "";

        switch (value) {
            case 1:
                retornarLetra = "a";
                break;
            case 2:
                retornarLetra = "c";
                break;
            case 3:
                retornarLetra = "c";
                break;
            default:
                retornarLetra = "@";
        }
        return retornarLetra;
    }

    public static int Sum(int arr[]) {
        int soma = 0;
        for (int i = 0; i < arr.length; i++) soma += arr[i];
        return soma;
    }


    public static int remove_Duplicate_Elements(int arr[], int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] tempA = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                tempA[j++] = arr[i];
            }
        }
        tempA[j++] = arr[n - 1];
        for (int i = 0; i < j; i++) {
            arr[i] = tempA[i];
        }
        return j;
    }


    public static void removeDuplicates(int[] a) {

        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();

        // adding elements to LinkedHashSet
        for (int i = 0; i < a.length; i++)
            set.add(a[i]);

        // Print the elements of LinkedHashSet
        System.out.print(set);
    }

    static int sum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) sum += arr[i];
        return sum;
    }

    public static void main(String[] args) {

        //int a[] = {5,2,6,8,6,7,5,2,8};
        //removeDuplicates(a);


        //int a[] = {5,2,6,8,6,7,5,2,8};
        //int resultado = sum(a);
        //System.out.println(resultado);


    }


}


