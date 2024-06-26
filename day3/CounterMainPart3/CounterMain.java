public class CounterMain{
    public static void main(String[] args){
        Counter counter1 = new Counter("First Counter");
        Counter counter2 = new Counter("Second Counter");

        counter1.increment();
        counter1.increment();
        counter1.increment();
        counter1.report();
        counter1.report();
    }
}