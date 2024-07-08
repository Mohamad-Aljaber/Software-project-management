public class QueueArray<T> {
    T [] items;
    int front =0;
    int rear = 0;
    int size=0;
    QueueArray(int c){
        items = (T[])new Object[c];
    }
    public void enQueue(T item) {
        if(isFull()) {
            return;
        }
        items[rear] = item;
        rear++;
        size++;
    }
    public T deQueue () {
        if(isEmpty()) {
            return null;
        }

        T res = items[front];
        items[front] = null;
        front++;
        size--;
        return res;
    }
    public T peek() {
        if(isEmpty()) {
            return null;
        }
        return items[front];
    }
    public Boolean isEmpty() {
        return size==0;
    }
    public Boolean isFull() {
        return rear == items.length;
    }
    public void addAll(StackArray<Integer> item) {
        for (int i = 0; i < size; i++){
            item.puch((Integer) items[i]);
        }
    }

}