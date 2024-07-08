import java.lang.reflect.Array;
public class DLinkedList<T> {
    private class Node {
        private Node next;
        private Node prev;
        private T data;

        public Node(T data) {
            this.data = data;
        }
    }
    private Node head;
    private Node tail;
    private int size=0;
    //        ****************************** add *******************************
    public  void addFirst(T item){
        Node newNode=new Node(item);
        if (head==null)head=tail=newNode;
        else {
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
        size++;
    }
    public  void addLast(T item){
        Node newNode=new Node(item);
        if (head==null)head=tail=newNode;
        else {
            newNode.prev=tail;
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    public void insert(int index,T item){
        if (index==0)addFirst(item);
        else if (index==size-1) addLast(item);
        else {
            Node newNode=new Node(item);
            Node curruent=head;
            for (int i = 0; i < index; i++) {
                curruent=curruent.next;
            }
            Node currentPrev=curruent.prev;
            newNode.next=curruent;
            curruent.prev=newNode;
            currentPrev.next=newNode;
            newNode.prev= currentPrev;

        }
    }
    //        ***************************** print *****************************
    public  void prantFirst(){
        Node current =head;
        while (current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }
    public  void prantLast(){
        Node current =tail;
        while (current!=null){
            System.out.println(current.data);
            current=current.prev;
        }
    }
    //        ***************************** Delete *****************************
    public  void  DeleltFirst() throws Exception {
        if (size==0)throw new Exception("Empty");
        else {
            Node currentNext=head.next;
            head.next.prev=null;
            head.next=null;
            head=currentNext;
            size--;
        }
    }
    public  void  DeleltLast() throws Exception {
        if (size==0)throw new Exception("Empty");
        else {
            Node currentNext=tail.prev;
            tail.prev.next=null;
            tail.prev=null;
            tail=currentNext;
            size--;
        }
    }
    public  void  removeByIndex(int index){
        Node current=head;
        for (int i = 0; i < index; i++) {
            current=current.next;
        }
        Node currentN=current.next;
        Node currentP=current.prev;
        currentP.next=currentN;
        currentN.prev=currentP;
        size--;
    }
//        ***************************** advace *****************************

    public  int Size(){return size;}
    public  T[] toArray(){
        T[] newArray= (T[]) Array.newInstance(head.data.getClass(),size);
        Node current=head;
        for (int i = 0; i < size; i++) {
            newArray[i]=(T)current.data;
            current=current.next;
        }
        return (T[]) newArray;
    }
    public  T[] revreceToArray(){
        Node current=tail;
        T [] arr= (T[]) Array.newInstance(tail.data.getClass(),size);
        for (int i = 0; i < size; i++) {
            arr[i]= current.data;
            current=current.prev;
        }
        return  arr;

    }
    public boolean isExit( T item){
        Node current=head;
        while (current!=null){
            if (current.data.equals(item))return true;
            current=current.next;
        }
        return false;
    }
    public  int indexOf(T item){
        int res=-1;
        if (head==null)return res;
        else{
            Node current =head;
            for (int i = 0; i < size; i++) {
                if (current.data.equals(item)){
                    res=i;
                    break;
                }
                current=current.next;
            }
            return res;
        }
    }
}
