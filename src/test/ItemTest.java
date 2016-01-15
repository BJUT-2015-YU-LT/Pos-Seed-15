package test;

import pos.Item;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    Item item;

    @org.junit.Before
    public void setUp() throws Exception {
        item=new Item( "ITEM000000", "可口可乐", "瓶", 3.00);
        item.addItemNum();
    }

    @org.junit.Test
    public void testGetTotal() throws Exception {
        Double result=6.0;
        assertEquals(result,item.getTotal());

    }
}