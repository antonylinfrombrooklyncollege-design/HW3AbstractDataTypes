/*
Name: Antony Lin
Programming Language: Java
IDE / Editor: IntelliJ IDEA

Question 1
What does ADT stand for?
ADT stands for abstract data type.

Question 2
In your own words, what is an Abstract Data Type?
In my own words, abstract data type defines the data, available operations, and what the operations do without specifying
the implementation of the data.

Question 3
What is the difference between an ADT and its implementation?
The ADT describes what the data structure does while the implementation describes how the data structure does it.

Question 4
Can two programmers create different implementations of the same ADT?
Yes, as long as the requirements of the ADT are met. For example, they have to be capable of performing the same task.

Question 5
If one programmer creates a Stack using an array and another creates a Stack using a linked list, are both still Stacks?
Yes because it follows the same LIFO stack behavior.
*/

public class HW3 {

// --------------------

// Stack

// --------------------

    static class Stack {
        private int[] items;
        private int top;

        public Stack() {
            items = new int[10];
            top = -1;
        }

        public void push(int item) {
            if (top == items.length - 1) {
                System.out.println("Stack is full.");
                return;
            }

            top++;
            items[top] = item;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            }

            int topItem = items[top];
            top--;

            return topItem;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            }

            return items[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public int size() {
            return top + 1;
        }
    }


// --------------------

// Queue

// --------------------


    static class Queue {
        private int[] items;
        private int front;
        private int rear;
        private int count;

        public Queue() {
            items = new int[10];
            front = 0;
            rear = -1;
            count = 0;
        }

        public void enqueue(int item) {
            if (count == items.length) {
                System.out.println("Queue is full.");
                return;
            }

            rear = (rear + 1) % items.length;
            items[rear] = item;
            count++;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }

            int frontItem = items[front];
            front = (front + 1) % items.length;
            count--;

            return frontItem;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }

            return items[front];
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public int size() {
            return count;
        }
    }



    public static void main(String[] args) {

        // STACK DEMONSTRATION

        System.out.println("STACK DEMONSTRATION");
        System.out.println();

        Stack stack = new Stack();

        System.out.println("Adding:");

        stack.push(15);
        System.out.println("15");

        stack.push(25);
        System.out.println("25");

        stack.push(35);
        System.out.println("35");

        stack.push(45);
        System.out.println("45");

        stack.push(55);
        System.out.println("55");

        System.out.println();

        System.out.println("Top item:");
        System.out.println(stack.peek());

        System.out.println();

        System.out.println("Removing:");
        System.out.println(stack.pop());

        System.out.println();

        System.out.println("Removing:");
        System.out.println(stack.pop());

        System.out.println();

        System.out.println("New top:");
        System.out.println(stack.peek());

        System.out.println();

        System.out.println("Is Stack empty?");
        System.out.println(stack.isEmpty());


        // QUEUE DEMONSTRATION

        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();

        System.out.println("QUEUE DEMONSTRATION");
        System.out.println();

        Queue queue = new Queue();

        System.out.println("Adding:");

        queue.enqueue(15);
        System.out.println("15");

        queue.enqueue(25);
        System.out.println("25");

        queue.enqueue(35);
        System.out.println("35");

        queue.enqueue(45);
        System.out.println("45");

        queue.enqueue(55);
        System.out.println("55");

        System.out.println();

        System.out.println("Front item:");
        System.out.println(queue.peek());

        System.out.println();

        System.out.println("Removing:");
        System.out.println(queue.dequeue());

        System.out.println();

        System.out.println("Removing:");
        System.out.println(queue.dequeue());

        System.out.println();

        System.out.println("New front:");
        System.out.println(queue.peek());

        System.out.println();

        System.out.println("Is Queue empty?");
        System.out.println(queue.isEmpty());
    }
}

/*

Question 6
What does LIFO mean?
LIFO means last in first out.

Question 7
Why did 55 get removed before 15?
Following the LIFO behavior, since 55 was added last it will be removed before 15.

Question 8
If the Stack contains:

A

B

C

D

and D was added last, which item should pop() remove first?
pop() should remove D first because it was added last.

Question 9
Give one real-world or software example where a Stack could be useful.

Examples discussed in class may include:

●	Browser Back history
●	Undo operations
●	Function calls

Explain your example.
I stack could be useful for the back button on a browser. Each user action could be placed
in a stack and when the user press back, the most recent action is undone. This is LIFO behavior.

Question 10
What does FIFO mean?
FIFO means first in first out.

Question 11
Why was 15 removed before 55?
following FIFO behavior 15 was added before 55 so it is removed first.

Question 12
If customers enter a line in this order:

Alex

Maria

John

Sarah

who should leave the Queue first?
Alex should leave the Queue first because he entered first.

Question 13
Give one real-world or software example where a Queue could be useful.

Possible examples:

●	Printer jobs
●	Customer-service requests
●	Tasks waiting to be processed
●	People waiting in line

Explain your answer.
A Queue would be useful for printer jobs. The first documents submitted to the
printer are printed first. This follows FIFO behavior.

Scenario 1 — Undo Feature
A text editor remembers your recent actions.

If you type:

A

B

C

the most recent action should be undone first.

Stack or Queue?

Explain.
Stack because the most recent action is undone first.

________________________________________
Scenario 2 — Printer
Three students send documents to a printer.

The first document submitted should normally print first.

Stack or Queue?

Explain.
Queue because the first document prints first.

________________________________________
Scenario 3 — Browser Back Button
You visit:

Google

YouTube

GitHub

Amazon

You click the Back button.

Which page should appear first?
GitHub should appear first
What ADT does this resemble?
This resembles stack ADT.

________________________________________
Scenario 4 — Customer Service
Customers are waiting to talk to an employee.

The person who arrived first should normally be helped first.

Stack or Queue?
This is a Queue because it represents first in first out.

________________________________________
Scenario 5 — Plates
You place five plates on top of one another.

Which ADT does this represent?

Explain.
Stack. It represents LIFO because the last plate you place is usually the first one you take.

Question 14
What does pop() return?
pop() returns 18.

Question 15
What does the final peek() return?
peek() returns 22.

Question 16
What does dequeue() return?
dequeue() returns 7.

Question 17
What does the final peek() return?
peek() returns 12.

Feature	                    Stack	                    Queue
Rule	                    LIFO	                    FIFO
Add operation	            push()	                    enqueue()
Remove operation	        pop()	                    dequeue()
View next item	            peek()	                    peek()
First item removed	        Most recently added item	First added item

Question 18
If you implement a Stack using an array, which part is the ADT?
The operations such as push(), pop() and LIFO behavior are part of the ADT

Question 19
Which part is the implementation?
The array is part of the implementation.

Question 20
If you replace the array with a linked list but keep the same Stack operations, did the ADT change?

Explain.
No, the ADT is the Stack operations. Only the implementation changed.


 */