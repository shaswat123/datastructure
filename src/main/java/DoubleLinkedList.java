public class DoubleLinkedList {

    private ListNode head;
    private ListNode tail;
    private Integer length;

    //Two way linked list
    private static class  ListNode{

        private String data;
        private ListNode next;
        private ListNode previous;


        public ListNode(String data ){

            this.data=data;
            this.next=null;
            this.previous=null;


        }

    }

    //Always remember tail contains the latest node that you want to link to

    public void insertIntoDoubleLinkedListLast(String value){

        ListNode node = new ListNode(value);

        if(isEmpty()){
            head= node;

        }
        else {

            tail.next = node;
        }

        node.previous=tail;
        tail=node;

        length++;
    }

    public void printDoublyLinkedListForward(){

        ListNode current =head;

        while(current!=null){

            System.out.println(current.data);
            current=current.next;
        }

    }

    public void printDoublyLinkedListBackward(){

        ListNode current =tail;

        while(current!=null){

            System.out.println(current.data);
            current=current.previous;
        }

    }

    public DoubleLinkedList(){

        this.head=null;
        this.tail=null;
        this.length=0;

    }

    public boolean isEmpty(){
        return length ==0;
    }

    public int length(){
        return length;
    }

    public void insertAtTheBeginning(String data){

        if(data==null){

            System.out.println("Unable to insert");
            return ;

        }

        ListNode newHead = new ListNode(data);
        if(isEmpty()){

            head=newHead;
        }

        newHead.next=head;
        head.previous=newHead;

        head=newHead;


    }

    //Insert at the end of the list .
    public void insertAtTheEnd(String data){

        if(data==null){

            System.out.println("Unable to insert");
            return ;

        }

        ListNode newTail = new ListNode(data);
        if(isEmpty()){

            head=newTail;
        }
        else {

            tail.next = newTail;
            newTail.previous = tail;
            tail = newTail;
        }
    }




    public static void main(String[] args) {

        DoubleLinkedList doubleLinkedList= new DoubleLinkedList();


        doubleLinkedList.insertIntoDoubleLinkedListLast("100");
        doubleLinkedList.insertIntoDoubleLinkedListLast("200");
        doubleLinkedList.insertIntoDoubleLinkedListLast("300");
        doubleLinkedList.insertIntoDoubleLinkedListLast("400");
        doubleLinkedList.insertIntoDoubleLinkedListLast("500");
        doubleLinkedList.insertIntoDoubleLinkedListLast("600");
        doubleLinkedList.insertIntoDoubleLinkedListLast("700");
        doubleLinkedList.insertIntoDoubleLinkedListLast("800");
        doubleLinkedList.insertIntoDoubleLinkedListLast("900");
        doubleLinkedList.insertIntoDoubleLinkedListLast("1000");


        System.out.println("Length is "+doubleLinkedList.length());

        System.out.println("Printing forward");
        doubleLinkedList.printDoublyLinkedListForward();


        System.out.println("Printing backward");
        doubleLinkedList.printDoublyLinkedListBackward();

        System.out.println("After inserting at the beginning");

        doubleLinkedList.insertAtTheBeginning("10");
        doubleLinkedList.printDoublyLinkedListForward();

        System.out.println("After inserting at the end");

        doubleLinkedList.insertAtTheEnd("1100");
        doubleLinkedList.printDoublyLinkedListForward();


    }
}
