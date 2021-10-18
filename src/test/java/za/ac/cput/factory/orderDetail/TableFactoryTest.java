package za.ac.cput.factory.orderDetail;
/* TableFactoryTest.java
 Entity for Table Factory Test
 Author: Sindiswa Nomusa Mbhele (219279616)
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.orderDetail.Ta_ble;
import za.ac.cput.entity.staff.Waiter;
import za.ac.cput.factory.staff.WaiterFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TableFactoryTest {
    @Test
     public void buildTable(){
        Ta_ble table = TableFactory.buildTable(false);
        assertFalse(false);
        System.out.println(table);

    }



}