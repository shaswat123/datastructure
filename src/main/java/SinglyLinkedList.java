public class SinglyLinkedList {

    private static class ListNode{

        private String data;
        private ListNode next;

        ListNode(String data){

            this.data =data;
            this.next =null;
        }

    }

    public static void main(String[] args) {

        ListNode head = new ListNode("10");
        ListNode two = new ListNode("20");
        ListNode three = new ListNode("30");
        ListNode four = new ListNode("40");
        ListNode five = new ListNode("50");


        head.next= two;
        two.next =three;
        three.next = four;
        four.next = five ;


        displayLinkedList(head);
        lengthLinkedList(head);


        ListNode newHead = new ListNode("9");
        InsertAtTheBeginning(head,newHead);

        ListNode newTail = new ListNode("60");
        InsertAtTheEnd(head,newTail);

        ListNode newNode = new ListNode("35");

        InsertAfterAGivenNode(head,three,newNode);

        ListNode newNodeP = new ListNode("34");

        InsertAtAGivenPosition(head,4,newNodeP);

        System.out.println("After deleting the head node");

        head=deleteFirstNode(head);
        displayLinkedList(head);

        System.out.println("After deleting the last node");

        deleteLastNode(head);
        displayLinkedList(head);

        deleteAtAGivenPosition(head,5);

        searchLinkedList("50",head);


        //Reverse a linked list.
        displayLinkedList(reversedLinkedList(createLinkedList()));

        //Find middle of the linked list
        findMiddleNodeOfALinkedList(createLinkedList());

        //Find Nth node from the end of linked list

        findNNodeFromEndLinkedList(createLinkedList(),3);

        //Remove duplicate entries in a sorted linked list
        removeDuplicatesFromSortedLinkedList(createSortedDuplicateEntriesInLinkedList());

        //Add a node to the sorted linked list.By default it will be in increasing order

        addANodeInSortedLinkedList(createLinkedList(), new ListNode("450"));

        //Remove a key from the linkedlist

        removeAKeyFromLinkedList(createSortedDuplicateEntriesInLinkedList(),"100");

        //detect a loop in linked list

        detectLoopInLinkedList(createLoopedLinkedList());

        detectLoopInLinkedList(createLinkedList());



    }

    public static ListNode createLinkedList(){

        ListNode head = new ListNode("100");
        ListNode two = new ListNode("200");
        ListNode three = new ListNode("300");
        ListNode four = new ListNode("400");
        ListNode five = new ListNode("500");


        head.next= two;
        two.next =three;
        three.next = four;
        four.next = five ;

        return head;


    }

    public static ListNode createSortedDuplicateEntriesInLinkedList(){

        ListNode head = new ListNode("100");
        ListNode two = new ListNode("200");
        ListNode three = new ListNode("500");
        ListNode four = new ListNode("500");
        ListNode five = new ListNode("500");


        head.next= two;
        two.next =three;
        three.next = four;
        four.next = five ;

        return head;


    }

    public static ListNode createLoopedLinkedList(){

        ListNode head = new ListNode("100");
        ListNode two = new ListNode("200");
        ListNode three = new ListNode("300");
        ListNode four = new ListNode("400");
        ListNode five = new ListNode("500");


        head.next= two;
        two.next =three;
        three.next = four;
        four.next = five ;
        five.next=three;

        return head;


    }

    public static void  displayLinkedList(ListNode head){

        if(head==null){
            return;
        }

        ListNode current = head ;

        while(current!=null){

            System.out.println(current.data);

            current=current.next;
        }
    }

    public static Integer lengthLinkedList(ListNode head){

        ListNode current = head;
        Integer count =0;

        while(current!=null){

            count++;
            current=current.next;

        }

        System.out.println("The length of the linked list is "+count);

        return count;


    }

    public static void InsertAtTheBeginning(ListNode head,ListNode newHead){

        if(head==null|| newHead==null){
            System.out.print("Cannot insert");
            return;
        }

        newHead.next=head;

        System.out.println("After Inserting new node at the beginning");

        displayLinkedList(newHead);

        lengthLinkedList(newHead);

    }

    public static void InsertAtTheEnd(ListNode head,ListNode newTail){

        if(head==null|| newTail==null){
            System.out.print("Cannot insert");
            return;
        }

        ListNode current = head;

        while(current.next!=null){
            current = current.next;
        }

        current.next=newTail;

        System.out.println("After Inserting new node at the last");

        displayLinkedList(head);

        lengthLinkedList(head);

    }


    public static void InsertAfterAGivenNode(ListNode head,ListNode previousNode,ListNode newNode){

        if(head==null|| previousNode==null || newNode==null){
            System.out.print("Cannot insert");
            return;
        }

        newNode.next=previousNode.next;
        previousNode.next=newNode;



        System.out.println("After Inserting new node at a given node");

        displayLinkedList(head);

        lengthLinkedList(head);

    }


    public static void InsertAtAGivenPosition(ListNode head,Integer position,ListNode newNode){

        if(head==null|| newNode==null){
            System.out.print("Cannot insert");
            return;
        }

        Integer size = lengthLinkedList(head);

        if(position<1 || position>size+1){

            System.out.println("Invalid Position");
            return;
        }

        if(position==1){
            newNode.next=head;
            displayLinkedList(newNode);
        }else {

            Integer count = 1;
            ListNode current = head;

            while (count < position - 1) {

                current = current.next;
                count++;


            }

            newNode.next = current.next;
            current.next = newNode;

        }


        System.out.println("After Inserting new node at a given position");

        displayLinkedList(head);

        lengthLinkedList(head);

    }

    public static ListNode deleteFirstNode(ListNode head){

        if(head==null){

            System.out.println("Cannot delete");
            return null;
        }

        ListNode newHead= head.next;
        head.next=null;

        return newHead;

        /*ListNode temp= head;
        head= head.next;
        temp.next=null;
*/

    }

    public static ListNode deleteLastNode(ListNode head){

        if(head==null){

            System.out.println("Cannot delete");
            return null;
        }

        ListNode current = head;
        ListNode temp = null;
        while(current.next!=null){

            temp=current;
            current=current.next;

        }

        temp.next=null;

        return head;


    }


    public static void deleteAtAGivenPosition(ListNode head,Integer position){

        if(head==null){
            System.out.print("Cannot delete");
            return;
        }

        Integer size = lengthLinkedList(head);

        if(position<1 || position>size+1){

            System.out.println("Invalid Position");
            return;
        }

        if(position==1){

            ListNode tempHead=head;
            head=head.next;
            tempHead=null;

        }else {

            Integer count = 1;
            ListNode current = head;
            ListNode previousNode=null;

            while (count < position ) {

                previousNode=current;
                current = current.next;
                count++;


            }

            previousNode.next = current.next;

           current=null;

        }

       /* ListNode previousNode = head;
        Integer count =1;
        while (count < position-1 ) {

            previousNode = previousNode.next;
            count++;


        }

        ListNode current = previousNode.next;
        previousNode.next= current.next;
        current.next=null;*/


        System.out.println("After deleting  a node at a given position");

        displayLinkedList(head);

        lengthLinkedList(head);

    }

    public static void searchLinkedList(String value,ListNode head) {

        ListNode current = head;
        Boolean isFound = Boolean.FALSE;

        if(head==null){

            System.out.print("Unable to search");
            return;
        }

        while (current!= null) {

            if (current.data.equals(value.trim())) {

                isFound = Boolean.TRUE;

                break;


            }

            current = current.next;


        }

        if (isFound) {

            System.out.println("Value Found");

        } else {
            System.out.println("Not Found");

        }
    }

    public static ListNode reversedLinkedList(ListNode head){

        if(head==null){

            System.out.println("Unable to reverse");
            return null;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current!=null){

            next = current.next;
            current.next = previous;
            previous = current;
            current =next;
        }

        System.out.println("After reversing");

        return previous;
    }

    public static void findMiddleNodeOfALinkedList(ListNode head){

        if(head==null){

            System.out.println("Unable to find the middle of the linked list");
            return;
        }

        ListNode slPtr = head;
        ListNode fPtr =head;

        while(fPtr!=null && fPtr.next!=null){

            slPtr=slPtr.next;
            fPtr=fPtr.next.next;
        }

        System.out.println("The middle of the linked list is "+slPtr.data);

    }

    //The main pointer will start only ,when the ref pointer reaches to the nth position from the beginning

    public static ListNode findNNodeFromEndLinkedList(ListNode head,Integer n){

        ListNode mPtr=head;
        ListNode refPtr=head;

        Integer count=0;

        while(count<n){
            refPtr=refPtr.next;
            count++;
        }

        while(refPtr!=null){
            refPtr=refPtr.next;
            mPtr=mPtr.next;
        }

        System.out.println("The "+n+"element from the end is "+ mPtr.data);

        return mPtr;
    }

    //Remove duplicates from sorted linkedlist


    public static void removeDuplicatesFromSortedLinkedList(ListNode head){

        if(head==null){

            System.out.println("Unable to remove entries");
            return;
        }
         ListNode current = head;

         while(current!=null && current.next!=null){

             if(current.data==current.next.data){

                 current.next = current.next.next;
             }else
             {
                 current=current.next;
             }


         }

         System.out.println("After removing duplicate entries");
         displayLinkedList(head);

    }

    //Add a new node in a sorted linked list.We will store the current node in  temp to point to the prevoius node

    public static void addANodeInSortedLinkedList(ListNode head,ListNode newNode){

        if(head==null){

            System.out.println("Unable to add entries");
            return;
        }
        ListNode current = head;
        ListNode previous =null;

        while(current!=null && Integer.parseInt(newNode.data)>Integer.parseInt(current.data)){

            previous =current;
            current=current.next;
        }

        previous.next = newNode;
        newNode.next=current;


        System.out.println("After adding a node to the sorted linked list ");
        displayLinkedList(head);

    }

    //Remove a key or data from a linked list

    public static void removeAKeyFromLinkedList(ListNode head,String key){

        if(head==null || key ==null){

            System.out.println("Unable to remove key/data");
            return;
        }

        ListNode current=head;
        ListNode previous=head;
        ListNode temp=null;



        while(current!=null){

            if(head.data.equals(key)){
                head= head.next;
                current=head;
                continue;
            }

            if(current.data.equals(key))
            {

                temp=current.next;
                previous.next=temp;
                current=null;
                current=temp;

            }else {
                previous = current;
                current = current.next;
            }

        }

        System.out.println("After removing the key "+key);
        displayLinkedList(head);



    }

    //We will use slow pointer and fast pointer.If there is a loop slow and fast will meet while traversing

    public static void detectLoopInLinkedList(ListNode head){

        ListNode fastPtr=head;
        ListNode slowPtr=head;
        Boolean isLoopDetected=Boolean.FALSE;

        while(fastPtr!=null && fastPtr.next!=null){

            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;

            if(slowPtr==fastPtr){

                isLoopDetected=Boolean.TRUE;
                countLoopsInLinkedList(slowPtr);

                break;
            }

        }

        if(isLoopDetected){
            System.out.println("Loop detected");

        }
        else{
            System.out.println("No Loop detected");
        }




    }

    public static void countLoopsInLinkedList(ListNode node){

        Integer count =1;

        ListNode temp= node ;
        while(temp.next!=node) {
            count++;
            temp=temp.next;
        }

        System.out.println("Loop count is"+ count);



    }




}
