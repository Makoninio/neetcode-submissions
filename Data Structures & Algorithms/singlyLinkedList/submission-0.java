class ListNode {
    int val;
    ListNode next;

    // Constructor that sets next to null
    public ListNode(int val) {
        this(val, null);
    }

    // Constructor that sets accepts both value and next node
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    public ListNode head;
    public ListNode tail;

    public LinkedList() {
        this.head = new ListNode(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        ListNode curr = head.next;
        while (curr != null) {
            if (index == 0) {
                return curr.val;
            }
            index--;
            curr = curr.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        ListNode newNode = new ListNode(val);
        this.tail.next = newNode;
        this.tail = newNode;
    }

    public boolean remove(int index) {
        int i = 0;
        ListNode curr = this.head;
        while (i < index && curr != null) {
            i++;
            curr = curr.next;
        }
        if (curr != null && curr.next != null) {
            if (curr.next == this.tail) {
                this.tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> output = new ArrayList<>();
        ListNode curr = this.head.next;
        while (curr != null) {
            output.add(curr.val);
            curr = curr.next;
        }
        return output;
    }
}
