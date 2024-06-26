class Counter{
    public int value = 0;
}

public class CounterMain{
    public static void main(String[] args){
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        counter1.value++;
        counter1.value++;
        counter2.value++;
        System.out.println("counter1: " + counter1.value);
        System.out.println("counter2: " + counter2.value);
    }
}