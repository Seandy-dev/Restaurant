package za.ac.cput.factory.staff;
/* WaiterFactory.java
 Entity for WaiterFactory
 Author: Sindiswa Nomusa Mbhele (219279616)
*/
import za.ac.cput.entity.staff.Waiter;
import za.ac.cput.helper.GenericHelper;

public class WaiterFactory {
    public static Waiter buildWaiter(double hourlyWage, int hours, double tip) {
        if (GenericHelper.isNullorEmpty(hourlyWage) || GenericHelper.isNullorEmpty(tip))
            return new Waiter.Builder().build();
        String employeeId = GenericHelper.generateId();
        return new Waiter.Builder().hourlyWage(hourlyWage).hours(hours).tip(tip).employeeId(employeeId).build();
    }
}
