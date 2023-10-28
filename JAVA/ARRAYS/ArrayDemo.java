package arrays;

public class ArrayDemo {
	public static void main(String[] args) {
		
	
	   // declares an array of integers
    int[] anArray;

    // allocates memory for 10 integers
    anArray = new int[10];
        
    // initialize  element
    anArray[0] = 100;
    anArray[1] = 200;
    anArray[2] = 300;
    anArray[3] = 400;
    anArray[4] = 500;
    anArray[5] = 600;
    anArray[6] = 700;
    anArray[7] = 800;
    anArray[8] = 900;
    anArray[9] = 1000;

    for (int i = 0; i < anArray.length; i++) {
            System.out.println("Element at index " + i + ": " +anArray[i]);
            }
    
    System.out.println("length of the array " +anArray.length);
    // access data from particular index
    System.out.println("element present in index 8 is " +anArray[8]);
    
}
}
