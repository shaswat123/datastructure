

public class Stack {

    //We can implement stack using linked list
    private ListNode top;
    private Integer length;

    private static class ListNode{

        private String data;
        private ListNode next;

        public ListNode(String data){

            this.data=data;
            this.next=null;

        }
    }

    public Stack(){
        top=null;
        length=0;

    }


    public void push(String data){

        ListNode node = new ListNode(data);

        node.next=top;
        top = node;
        length++;
    }

    public Boolean isEmpty(){
        return length==0;
    }

    public String pop(){

        if(isEmpty()){
            System.out.println("Stack is empty");
            return "";

        }

        String result=top.data;
        top=top.next;
        length--;
        return result ;

    }

    public String peek(){


        return isEmpty()?"":top.data;
    }

    public static void main(String[] args) {

        Stack stack= new Stack();
        stack.push("100");
        stack.push("200");
        stack.push("300");
        stack.push("400");
        stack.push("500");
        stack.push("600");
        stack.push("700");
        stack.push("800");
        stack.push("900");
        stack.push("1000");

        System.out.println("No of elements in the stack "+stack.length);

        System.out.println("Last element inserted "+stack.peek());

        System.out.println("Popped element "+ stack.pop());

        System.out.println("Last element inserted "+stack.peek());

        System.out.println("Popped element "+ stack.pop());

        System.out.println("Last element inserted "+stack.peek());









    }
}
