package za.ac.cput.factory.orderDetail;
/* TableFactory.java
 Entity for TableFactory
 Author: Sindiswa Nomusa Mbhele (219279616)
*/

import za.ac.cput.entity.orderDetail.Ta_ble;
import za.ac.cput.helper.GenericHelper;

public class TableFactory {
    public static Ta_ble buildTable(boolean occupied) {
        if (GenericHelper.isNullorEmpty(occupied))
            return new Ta_ble.Builder().build();
        String tableNumber = GenericHelper.generateId();
        return new Ta_ble.Builder().tableNumber(tableNumber).occupied(occupied).build();
    }


}
