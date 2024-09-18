package pa2;

/**
 * A sorted singly linked list of integers
 * 
 */
public class LinkedList {

    /**
     * A node in the linked list
     */
    public Node head;

    /**
     * Constructor
     * Initialize the linked list with a null head
     */
    public LinkedList() {
        this.head = null;

    }

    /** 
     * Add a new node to the linked list 
     * so that the list remains sorted
     * @param value The value to add
     * @return void
     */
    public void add(int value) {
        Node newnode = new Node(value);
        if(this.head == null){
            this.head = newnode;
        }
        else if (newnode.value < this.head.value){
            newnode.next = this.head;
            this.head = newnode;
        }
        else{
        Node current = this.head;
            while (current.next != null){
                if (newnode.value < current.next.value){
                    newnode.next = current.next;
                    current.next = newnode;
                    break;                 
                }
                current = current.next;
            }
            if(current.next == null){
                current.next = newnode;
            }
        }
    }

    /**
     * Remove the first node with the given value
     * If the value is not found, do nothing
     * @param value The value to remove
     * @return void
     */
    public void remove(int value) {
        Node current = this.head;
        if (current.value == value){
            this.head = current.next;
        }
        else {
            while (current.next != null){
                if (current.next.value == value){
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
            }  
        }
        }
    
    /**
     * Traverse the linked list RECURSIVELY and returns a string representation of the list
     * @param current
     * @return String
     */
    public String traverse_recursive(Node current){
        if (current == null){
            return "";
        }
        return current.value + " " + traverse_recursive(current.next);
    }

    /**
     * Traverse the linked list and returns a string representation of the list
     * @return String
     */
    public String traverse(){
        String str = "";
        Node current = this.head;
    while (current.next != null){
            str += current.value + " ";
            current = current.next;
        }
        str += current.value + " ";
        return str;
    }
        
    
     /**
     * Traverse the linked list RECURSIVELY and 
     * returns the reverse string representation of the list
     * e.g. the linked list 1 -> 2 -> 3 -> 4 will be printed as 4 3 2 1
     * @return String
     */

    public String reverse(Node current){
        if (current == null){
            return "";
        }
        String str = reverse(current.next);
        str += current.value + " ";
    
        return str;
     }

    /**
     * Merges two sorted linked list and returns the 
     * merged linked list that is also sorted
     * @param list1 The first sorted linked list
     * @param list2 The second sorted linked list 
     * @return LinkedLists
     */
    public static LinkedList merge(LinkedList list1, LinkedList list2){
        LinkedList newlist = new LinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;
        if (current1 == null){
            newlist.head = current2;
            return newlist;
        }
        if (current2 == null){
            newlist.head = current1;
            return newlist;
        }

        if (current1.value <= current2.value){
            newlist.head = current1;
            current1 = current1.next;
        }
        else{
            newlist.head = current2;
        current2 = current2.next;}
        Node newnode = newlist.head;
        while (current1 != null && current2 != null){
            if (current1.value <= current2.value){
                newnode.next = current1;
                current1 = current1.next;
            }
            else{
                newnode.next = current2;
                current2 = current1.next;
            }
            newnode = newnode.next;
        }
        while (current1 != null){
                newnode.next = current1;
                newnode = newnode.next;
                current1 = current1.next;
            }
        while (current2 != null){
                newnode.next = current2;
                newnode = newnode.next;
                current2 = current2.next;
            }
        return newlist;
    }


    // public static void main(String[] args) {
    //     LinkedList list = new LinkedList();
    //     list.add(1);
    //     list.add(2);
    //     list.add(3);
    //     list.add(4);
    //     System.out.println(list.traverse_recursive(list.head));
    //     list.remove(4);
    //     System.out.println(list.traverse_recursive(list.head));
    // }
}