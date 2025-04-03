package io.practise.accolite;

public class CustomList<T> {
    private int capacity = 10;

    private Object content[] =  new Object[capacity];

    private int count;

    public CustomList(int capacity) {
        this.capacity = capacity;
        this.content = new Object[capacity];

    }

    public CustomList() {

    }

    public int getSize() {
        return count;
    }
    public void add(T eachContent) {
        if (count < capacity) {
            content[count] = eachContent;

        } else if (count == capacity) {
            capacity += 10;
            restuctureArray();
            content[count] = eachContent;
        }
        ++count;
    }

    private void restuctureArray() {

        Object[] tempArray = content;

        this.content = new Object[capacity];

        copyArray(tempArray, this.content);

    }

    public Object[] getContent() {
        return content;
    }

    public Object getIndexedData(int index) {
        if (index <= count) {
            return content[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("You are trying to reach null value.");
        }
    }

    private void copyArray(Object[] tempArray, Object[] content) {

        for (int index = 0; index < tempArray.length; ++index) {
            content[index] = tempArray[index];
        }
    }

    public void delete(int index) {
        if (index > count) {
            content[index] = null;
        }
    }


}
