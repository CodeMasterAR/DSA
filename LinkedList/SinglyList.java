package LinkedList;

public class SinglyList {
    ListNode head;
    ListNode tail;
    public SinglyList(){}

    public boolean isEmpty(){
        return (head == null);
    }
    public void append(int val){
        ListNode newNode = new ListNode(val);
        if (isEmpty()){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    public ListNode buildList(String[] nodes, SinglyList sl){
        for (String node: nodes){
            int val = Integer.parseInt(node);
            sl.append(val);
        }
        return sl.head;
    }

    public void printList(ListNode head){
        ListNode temp = head;
        while (temp != null){
            if (temp.next == null){
                System.out.print(temp.val);
                temp = temp.next;
                continue;
            }
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}






















