package test;

import java.util.PriorityQueue;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        Queue<Person> pq = new PriorityQueue<>();
        pq.add(new Person("홍길동", 24));
        pq.add(new Person("김철수", 21));
        pq.add(new Person("김영희", 25));

        while (!pq.isEmpty()) {
            Person person = pq.remove();
            System.out.println(person.getName() + "(" + person.getAge() + ")");
        }
    }
}
