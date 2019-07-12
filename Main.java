package ivan.samoylov;

public class Main {

    public static void main(String[] args) {
	  IntLinkedList myLinkedList = new IntLinkedList();
	  IntStack myStack = new IntLinkedList();
	  IntQueue myQueue = new IntLinkedList();

        System.out.println("IntLinkedList demo: ");
        System.out.print("add() demo: ");
        for (int i = 3; i <= 13; i++){
            myLinkedList.add(i);
        }
        System.out.println(myLinkedList);
        System.out.print("add() with index demo: ");
        for (int i = 0; i <= 6; i++){
            myLinkedList.add(i,i*i);
        }
        System.out.println(myLinkedList);
        System.out.print("clear() and isEmpty() demo: ");
        System.out.print(myLinkedList.isEmpty() + " ");
        myLinkedList.clear();
        System.out.print(myLinkedList.isEmpty() + " ");
        System.out.println(myLinkedList);
        for (int i = 5; i <= 15; i++){
            myLinkedList.add(i*i);
        }
        System.out.print("get() and size() demo: ");
        for (int i = 0; i < myLinkedList.size(); i++){
            System.out.print(myLinkedList.get(i) + " ");
        }
        System.out.println();
        System.out.print("remove() by index demo: ");
         myLinkedList.remove(1);
         myLinkedList.remove(4);
         myLinkedList.remove(6);
        System.out.println(myLinkedList);
        System.out.print("remove() by value demo: ");
        myLinkedList.removeByValue(64);
        myLinkedList.removeByValue(225);
        myLinkedList.removeByValue(144);
        System.out.println(myLinkedList);
        System.out.print("remove() by value demo: ");
        myLinkedList.set(0, 1000);
        myLinkedList.set(3, 555);
        myLinkedList.set(4, 777);
        System.out.println(myLinkedList);
        System.out.print("subList() demo: " + myLinkedList.subList(1,3));
        System.out.println();

        System.out.println("IntStack demo: ");
        System.out.print("push() demo: ");
        for (int i = 3; i < 13; i++){
            myStack.push(i*i);
        }
        System.out.println(myStack);
        System.out.println("peek() demo: " + myStack.peek() + " stack after peek(): " + myStack);
        System.out.println("pop() demo: " + myStack.pop() + " stack after pop(): " + myStack);

        System.out.println("IntQueue demo:");
        System.out.print("add() demo:");
        for (int i = 3; i < 13; i++){
            myQueue.add(i*i);
        }
        System.out.println(myQueue);
        System.out.println("remove() demo: " + myQueue.remove() + " Queue after remove()" + myQueue);
        System.out.println("element() demo: " + myQueue.element()+ " Queue after element()" + myQueue);
    }
}
