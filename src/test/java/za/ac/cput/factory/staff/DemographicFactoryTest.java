package za.ac.cput.factory.staff;
/* DemographicFactoryTest.java
 Entity for Demographic Factory Test
 Author: Nikitha Mbokotwana (218337906)
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.staffDetail.Demographic;

import static org.junit.jupiter.api.Assertions.*;

class DemographicFactoryTest {
    @Test
    public void createDemographic(){
        Demographic demographic= DemographicFactory.createDemographic("Female", "1999/02/05");
        assertNotNull(demographic);
        System.out.println(demographic);

    }



}