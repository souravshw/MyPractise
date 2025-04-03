package io.practise.accolite;

import org.junit.Assert;
import org.junit.Test;

public class CustomListTester {

    @Test
    public void checkIndexedContent() {

        CustomList firstList = new CustomList(1);

        Assert.assertEquals(0, firstList.getSize());
        firstList.add(2);
        Assert.assertEquals(1, firstList.getSize());
        firstList.add(3);
        Assert.assertEquals(2, firstList.getSize());
        firstList.add(2);
        Assert.assertEquals(3, firstList.getSize());

        Assert.assertEquals(2, firstList.getIndexedData(0));

    }


    @Test
    public void checkNullContent() {

        try {
            CustomList<Integer> firstList = new CustomList();

            firstList.add(2);

            firstList.add(3);

            firstList.add(2);

            Assert.assertEquals(null, firstList.getIndexedData(4));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Got an Exception");
        }

    }
}
