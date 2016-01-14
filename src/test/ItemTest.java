package test;

import pos.Item;

import static org.junit.Assert.assertEquals;

/**
 * Created by hanchao on 2016/1/14.
 */
public class ItemTest {
    Item item;
    @org.junit.Before
    public void setUp() throws Exception {
        item=new Item("ITEM000000", "可口可乐", "瓶" ,3.00, 0.8);
        item.addItemNum();
    }

    @org.junit.Test
    public void testGetTotal() throws Exception {
        Double result =3.00*0.8*2.0;
        assertEquals(result,item.getTotal());

    }

    @org.junit.Test
    public void testGetSave() throws Exception {
        Double result =3.0*2.0-3.00*0.8*2.0;
        assertEquals(result,item.getSave());

    }
}