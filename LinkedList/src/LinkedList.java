/**
 * Created by aishpratap on 10/2/16.
 */
public class LinkedList {

    public Node head;
    public int listCount;

    public LinkedList(){

        listCount = 0;

    }

    public static void main(String args[]){

        LinkedList list = new LinkedList();
        list.add(1);
        list.show();
        list.add(2);
        list.show();
        list.add(4);
        list.show();
        list.addAtIndex(4,list.listCount);
        list.show();
        //list.removeNodes(head);
        list.show();
        list.deleteNodeAtIndex(list.listCount);
        list.show();
//        list.deleteNodeAtIndex(0);
//        list.show();
//        list.removeDuplicate();
//        list.show();
        System.out.println(list.findValueFromLast(4));

    }

    public void show(){

        if (head != null){
            Node current = head;

            while (current.nextNode != null){
                System.out.print(current.data + " -> ");
                current = current.nextNode;
            }

            System.out.println(current.data);
        }else {
            System.out.println("Index out of bounds");
        }

    }

    public void add(int data){

        if (head == null){
            head = new Node(data);
            listCount++;
        }else {

            Node end = new Node(data);
            Node current = head;

            while (current.nextNode != null) {
                current = current.nextNode;
            }

            current.nextNode = end;
            listCount++;
        }
        System.out.println("Successfully added the value " + data);
    }

    public void addAtIndex(int data, int index){

        if (index>0 && index<=listCount){
            Node current = head;
            int counter = 0;

            while (current.nextNode != null && counter<index){
                current = current.nextNode;
                counter ++;
            }

            if (index == listCount -1){
                Node newNode = new Node(data);
                current.nextNode = newNode;
            }else {
                Node newNode = new Node(current.nextNode,data);
                current.nextNode = newNode;
            }
            listCount++;
            System.out.println("Successfully added the value " + data);
        }else {
            System.out.println("Index out of bounds");
        }
    }

    public void addLists()

    public boolean deleteNodeWithData(int data){

        Node current = head;

        while (current.nextNode != null){

            if (current.nextNode.getData().equals(data)){

                current.nextNode = current.nextNode.nextNode;
                listCount--;
                System.out.println("Deleted node with data " + data);
            }
            current = current.nextNode;
            return true;
        }

        System.out.println("No node found to delete node with data " + data);
        return false;

    }

    public static Node removeNodes(Node list, int x) {

        Node current = list;

        while (true){

            if(list == null)
                break;

            if (current.nextNode.data.equals(x)){

                current.nextNode = current.nextNode.nextNode;
            }
            current = current.nextNode;
        }
        return list;
    }


    public boolean deleteNodeAtIndex(int index){

        if (index>=0 && index<listCount){
            Node current = head;

            if (index == 0){

                if (listCount>1){
                    head = head.nextNode;
                }else{
                    head = null;
                }

            }else{

                int counter = 0;
                while (counter<index-1){
                    current = current.nextNode;
                    counter++;
                }

                current.nextNode = current.nextNode.nextNode;

            }
            listCount--;
            System.out.println("Deleted node at " + index);
            return true;
        }else {
            System.out.println("Index out of bounds");
            return false;
        }

    }

    public void removeDuplicate(){


        if (listCount > 1) {
            Node previous  = head;
            Node current = head.nextNode;
            while (current != null) {
                Node runner = head;
                while (runner != current) { // Check for earlier dups
                    if (runner.data == current.data) {
                        Node tmp = current.nextNode; // remove current previous.next = tmp;
                        previous.nextNode = tmp;
                        current = tmp;
                        listCount --;
                        break;// update current to next node break; // all other dups have already been removed
                    }
                    runner = runner.nextNode;
                }
                if (runner == current) { // current not updated - update now previous = current;
                    previous = current;
                    current = current.nextNode;
                }
            }
        }
        System.out.println("Done");
    }

    public int findValueFromLast(int indexFromLast){

        if (listCount >= indexFromLast){
            Node leader = head;
            Node follower = head;

            for(int i = 1; i < indexFromLast; i ++){
                leader = leader.nextNode;
            }

            while (leader.nextNode != null){
                leader = leader.nextNode;
                follower = follower.nextNode;
            }

            return (int)follower.data;
        }
        return -1;
    }

    private class Node{

        Node nextNode;
        Object data;

        public Node(Object dataValue){

            nextNode = null;
            data = dataValue;

        }

        public Node(Node next, Object dataValue){
            nextNode = next;
            data = dataValue;
        }

        public Object getData(){
            return data;
        }

    }
}



    