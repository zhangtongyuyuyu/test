public class Array <E>{
//    private int[] data;
    private E[] data;
    private int size;

//    构造器
    public Array(int capacity){
//        data = new int[capacity];
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

//    获取数组中的元素个数
    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    boolean isEmpty(){
        return size == 0;
    }

//    在所有的元素之后添加一个元素e
    public void addList(E e){
//        if(size == data.length){
//            throw new IllegalArgumentException("addList fail");
//        }
//        data[size] = e ;
//        size ++;
        add(size,e);
    }
//    在所有元素之前添加一个元素
    public void addFirst(E e){
        add(0,e);
    }
//    在index位置插入一个元素e
    public void add(int index , E e){

//        插入的位置index不能小于0，并且不能大于总元素的数目
        if(index <0 || index > size ){
            throw new IllegalArgumentException("require 0 < index < size");
        }
        if(size == data.length){
           reSize(2*data.length);
        }
//        把要插入位置之后的所有元素，往后移动一个位置，这样要插入的那个位置就空出来了
        for(int i = size -1 ; i >= index ; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;

    }
//获取元素
    public E get(int index){
        if(index <0 || index > size ){
            throw new IllegalArgumentException("require 0 < index < size");
        }
       return data[index];
    }
//修改元素
    public void set(int index,E e){
        if(index <0 || index > size ){
            throw new IllegalArgumentException("require 0 < index < size");
        }
        data[index]=e;
    }

//查找数组中是否含有某个元素
    public boolean contains(E e){
        for(int i = 0 ; i < size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }
//查找某个元素对应的角标,找不到就返回-1
    public int find(E e){
        for(int i = 0 ; i < size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
//删除索引元素
    public E   remove(int index){
        if(index <0 || index > size ){
            throw new IllegalArgumentException("require 0 < index < size");
        }
        E res = data[index];
        //把index之后的元素全部往前移动一个
        for(int i =index+1; i<size ;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size]=null; //回收
        if(size == data.length / 4 && data.length/2 !=0){
            reSize(data.length / 2);
        }
        return res;
    }
//删除第一个元素
    public E  removeFirst(){
         return remove(0);
    }
//删除最后一个元素
    public E removeLast(){
         return remove(size-1);
    }
//删除任意元素
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }
    @Override
    public String toString(){
        StringBuilder res  = new StringBuilder();
        res.append(String.format("size:%d , capacity:%d\n",size,data.length));
        res.append("[");
        for(int i = 0 ; i < size ; i++){
            res.append(data[i]);
            if(i!=size-1){
                res.append(",");
            }
        }
        res.append("]");
        return  res.toString();
    }
    private void reSize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0 ; i < size ; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

}
