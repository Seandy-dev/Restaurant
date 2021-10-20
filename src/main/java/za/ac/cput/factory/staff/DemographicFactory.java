package za.ac.cput.factory.staff;
/* DemographicFactory.java
 Entity for DemographicFactory
 Author: Nikitha Mbokotwana (218337906)
*/
import za.ac.cput.entity.staffDetail.Demographic;
import za.ac.cput.helper.GenericHelper;

public class DemographicFactory {

    public static Demographic createDemographic(String gender, String birthDate){
        String g = GenericHelper.generateId();
        Demographic demographic = new Demographic.Builder()
                .setGender(g)
                .setBirthDate(birthDate)
                .build();
        return demographic;
    }
}
