package za.ac.cput.factory.staff;

import za.ac.cput.entity.staff.Chef;
import za.ac.cput.helper.GenericHelper;

public class ChefFactory {

    public static Chef buildChef(double salary, int yearsOfExperience){
        if (GenericHelper.isNullorEmpty(salary))
            return new Chef.Builder().build();
        if(GenericHelper.isNullorEmpty(yearsOfExperience))
            return new Chef.Builder().build();
        String employeeId = GenericHelper.generateId();
        return new Chef.Builder().salary(salary).yearsOfExperience(yearsOfExperience).employeeId(employeeId).build();
    }
}
