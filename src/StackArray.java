public class StackArray <T>{
    T arr[];
    int size=0;
    int top=-1;
    public StackArray(int size){
        arr=(T[]) new Object[size];
    }
    public StackArray(){
        arr=(T[]) new Object[9];
    }
    public  boolean IsEmpty(){
        return top==-1;
    }
    public  boolean IsFull(){
        return arr.length-1==top;
    }
    public void puch(T item){
        if(IsFull()){
            System.out.println("Full size array");
            return;
        }
        top++;
        arr[top]=item;
        size++;

    }
    public T pop(){
        if (IsEmpty()){
            System.out.println("Empty size array");
            return null;
        }
        T item=arr[top];
        arr[top--]=null;
        size--;
        return item;
    }
    public  void print(){
        int count=top;
        while (count!=-1){
            System.out.println(arr[count]);
            count --;
        }
    }
    public T[] tolist(){
        T [] arr= (T[]) new Object[size];
        int index=0;
        while (! IsEmpty()){
            arr[index]=this.pop();
            index++;
        }
        return  arr;
    }
    public  void clear(){
        while (!IsEmpty()){
            pop();

        }
    }
    public  boolean serach(T item){
        while (!this.IsEmpty()){
            if (item==this.pop()){
                return true;
            }
        }
        return false;
    }
}
