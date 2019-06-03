public class CircularLinkedList {

    private  ListNode last;
    private  Integer length;

    private static class ListNode {

        private String value;
        private ListNode next;

        public ListNode(String value){

            this.value=value;
            next=null;
        }


    }


    public CircularLinkedList(){

        last=null;
        length=0;

    }

    public Integer length(){
        return length;
    }

    public Boolean isEmpty(){

        return length==0;
    }

    public void createLinkedList(){

        ListNode head = new ListNode("10");
        ListNode first = new ListNode("20");
        ListNode second = new ListNode("30");
        ListNode third = new ListNode("40");
        ListNode fourth = new ListNode("50");
        ListNode fifth = new ListNode("60");
        ListNode sixth = new ListNode("70");
        ListNode seventh = new ListNode("80");


        head.next=first;
        length++;
        first.next=second;
        length++;
        second.next=third;
        length++;
        third.next=fourth;
        length++;
        fourth.next=fifth;
        length++;
        fifth.next=sixth;
        length++;
        sixth.next=seventh;
        length++;
        seventh.next=head;

        last=seventh;

    }

    public void printCircularLinkedList(){

        if(last==null){

            System.out.println("Unable to traverse");
            return;


        }

        ListNode current = last.next;
        while(current!=last){

            System.out.println(current.value);
            current=current.next;
        }

        System.out.println(current.value);

    }

    public void insertAtBeginningCircularLinkedList(String data){

        ListNode newNode = new ListNode(data);

        if(data==null){
            System.out.println("Unable to insert");
            return;
        }

        if(isEmpty()){

            last=newNode;
        }
        else {
            newNode.next = last.next;

        }
        last.next=newNode;
    }

    public void insertAtTheEndCircularLinkedList(String data){

        ListNode newNode = new ListNode(data);

        if(data==null){
            System.out.println("Unable to insert");
            return;
        }

        if(isEmpty()){

            last=newNode;
        }
        else {
            newNode.next = last.next;

        }
        last.next=newNode;
        last=newNode;
    }



    public static void main(String[] args) {

    CircularLinkedList circularLinkedList = new CircularLinkedList();
    circularLinkedList.createLinkedList();
    System.out.println("Circular linked list ");
    circularLinkedList.printCircularLinkedList();
    System.out.println("After inserting at the beginning of a circular linked list ");
    circularLinkedList.insertAtBeginningCircularLinkedList("5");
    circularLinkedList.printCircularLinkedList();
    System.out.println("After inserting at the beginning of a circular linked list ");
    circularLinkedList.insertAtTheEndCircularLinkedList("90");
    circularLinkedList.printCircularLinkedList();
    }

}
