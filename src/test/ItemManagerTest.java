package test;

import org.junit.Before;
import org.junit.Test;
import pos.ItemManager;

import static org.junit.Assert.assertEquals;

/**
 * Created by hanchao on 2016/1/14.
 */
public class ItemManagerTest {
    ItemManager items;
    @Before
    public void setUp() throws Exception {
        items =new ItemManager();
        items.addItem("ITEM000000", "可口可乐", "瓶" ,3.00, 0.8);
        items.addItem("ITEM000000", "可口可乐", "瓶" ,3.00, 0.8);
    }

    @Test
    public void testTotal() throws Exception {
        Double result =3.00*0.8*2.0;
        assertEquals(result,items.total());

    }

    @Test
    public void testSave() throws Exception {
        Double result =3.0*2.0-3.00*0.8*2.0;
        assertEquals(result,items.save());
    }
}