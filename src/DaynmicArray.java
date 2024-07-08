class DynamicArray<T> {
    T[] data;
    int size;
    public DynamicArray(int n){
        data=(T[])new Object[n];
        size=0;
    }
    public DynamicArray(){
        data=(T[])new Object[10];
        size=0;
    }
    //    طباعة عنصر جديد
    public void Print(){
        for(T t: data)
            System.out.println(t);
    }
    public  void PrintRealData(){
        for (int i=0;i<size;i++)
            System.out.println(data[i]);
    }
    //     أضافة عنصر جديد
    public  void insertNew(T item){
        if (data.length==size)
            reSize();
        data[size]=item;
        size++;
    }
    //     تضخيم حجم المصفوفة
    private   void reSize(){
        int newSize=size*2;
        T []newArray=(T[]) new Object[newSize];
        for (int i=0;i<size;i++){
            newArray[i]=data[i];
        }
        data=newArray;
    }
    //تغير عنصر ضمن مصفوفة
    public  void Set(int index, T item) throws Exception {
        if (index<0||index>=data.length)
            throw  new Exception("Error in Index");
        data[index]=item;
    }
    //     عرض عنصر معين
    public  T Get(int index) throws Exception {
        if (index<0||index>=data.length)
            throw  new Exception("Error in Index");
        return data[index];
    }
    //حذف عنصر بواسطة index
    public T removeIndex(int index){
        if (index<0||index>=data.length)
            throw  new ArrayIndexOutOfBoundsException(index+" "+size);
        if (data.length/4>=size)
            decrease();
        T remove=data[index];
        for (int i=index;i<size-1;i++){
            data[i]=data[i+1];
        }
        data[size-1]=null;
        size--;
        return remove;
    }
    public void removeByItem(T item){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)){
                data[i]=null;
            }

        }
    }
    //     تقليص حجم المصفوفة
    public void  decrease(){
        int newSize=data.length/2;
        T[] newAr=(T[])new Object[newSize];
        for (int i=0;i< size;i++){
            newAr[i]=data[i];
        }
        data=newAr;
    }
    //     حدف عنصر عن طريق اسمه
    public int indexAt(T item){
        for (int i=0;i< size;i++){
            if (data[i].equals(item))
                return i;
        }
        return -1;
    }
    public  T removeItem(T item) throws Exception {
        int index=indexAt(item);
        if (index!=-1 )
            return   removeIndex(index);
        else throw  new Exception("this not found item");
    }
}
