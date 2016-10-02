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
        list.add(3);
        list.show();
        list.addAtIndex(4,list.listCount);
        list.show();
        list.deleteNodeWithData(2);
        list.show();
        list.deleteNodeAtIndex(list.listCount);
        list.show();
        list.deleteNodeAtIndex(0);
        list.show();
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


