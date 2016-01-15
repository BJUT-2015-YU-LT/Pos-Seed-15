package test;

import org.junit.Before;
import org.junit.Test;
import pos.ItemManager;

import static org.junit.Assert.assertEquals;

public class ItemManagerTest {
    ItemManager items;
    @Before
    public void setUp() throws Exception {
         items =new ItemManager("index.txt");
        items.fileInput("Items.txt");
    }

    @Test
    public void testTotal() throws Exception {
        Double result =3.00*1.0*2.0+3.00*1.0*2.0+2.00*1.0*1.0;
        assertEquals(result,items.total());

    }

    @Test
    public void testSave() throws Exception {
        Double result =3.00*1.0*2.0+3.00*1.0*1.0;
        assertEquals(result,items.save());
    }
}