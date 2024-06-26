class Counter{
    private int value = 0;
    public void increment(){
        this.value++;
    }
    public int getValue(){
        return this.value;
    }
}

public class CounterMain{
    public static void main(String[] args){
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        counter1.increment();
        counter1.increment();
        counter2.increment();
        System.out.println("counter1: " + counter1.getValue());
        System.out.println("counter2: " + counter2.getValue());
    }
}