import java.lang.reflect.Array;
public  class  LinkedList<T>{
    private class Node<T>{
        T data;
        Node next;
        public Node(T item){
            this.data=item;
        }
    }
    private Node head;
    private int size=0;
    //    ***************************** Add *******************************
    public  void addFirst( T item){
        Node<T> newNode=new Node<>(item);
        newNode.next=head;
        head=newNode;
        size++;
    }
    public  void addLast( T item){
        Node el=head;
        Node<T> newNode=new Node<>(item);
        if (el==null)
            el=newNode;
        else{
            while (el.next!=null){
                el=el.next;
            }
            el.next=newNode;
        }
        size++;
    }
    //    **************************** Print *******************************
    public  void Print(){
        Node current=head;
        while (current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }
    public  void printR(){
        Node el=head;
        recursionPrint(el);
    }
    private void recursionPrint(Node<T> node) {
        if (node==null)return;
        System.out.println(node.data);
        recursionPrint(node.next);
    }

    //    *************************** remove ******************************
    public  void removeFirst(T programmer) throws Exception {
        Node <T>el=head;
        if (size==0)throw new Exception();
        else if (size==1) head=null;
        else {
            head=el.next;
            el.next=null;
            size-=1;
        }
    }
    public  void reomveLast() throws Exception {
        if (size==0) throw new Exception("empty");
        Node current=head;
        while (current.next.next!=null){
            current= current.next;
        }
        current.next=null;
        size--;
    }
    public void removeByItem(T item){
        Node<T> el=head;
        while (el.next.data!=item){
            el=el.next;
        }
        el.next=el.next.next;
        size--;
    }
    public  void removeByIndex(int index) throws Exception {
        Node curennt = head;
        if (index < 0 || index >= size) throw new Exception("Error in index");
        if (index == 0) {head = curennt.next;size--;}
        else {
            for (int i = 1; i < index; i++) {
                curennt=curennt.next;
            }
            curennt.next=curennt.next.next;
            size--;
        }
    }
    //*************************** Advinse *****************************
    public  T[] ToArray(){
        T[ ] arr=(T[]) Array.newInstance(head.data.getClass(),size);
        Node<T> current=head;
        int index=0;
        while (current!=null){
            arr[index]=current.data;
            current= current.next;
            index++;
        }
        return arr;
    }
    public boolean isEmpty(){
        if (size!=0) return false;
        else  return true;
    }
    public  Integer Size(){return size;}
    public  void setIndex(int index,T item) throws Exception {
        if (index<0||index>=size)throw  new Exception("index");
        Node current=head;
        for (int i = 0; i < index; i++) {
            current=current.next;

        }
        current.data=item;
    }
    public void  setItem(T item,T newItem){
        Node current=head;
        while (current.data!=item)
            current=current.next;
        current.data=newItem;
    }
    public  T get(int index) throws Exception {
        if (index<0||index>=size)throw  new Exception("index");
        Node current=head;
        for (int i = 0; i < index-1; i++) {
            current=current.next;
        }
        return (T) current.data;
    }

}
