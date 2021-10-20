package za.ac.cput.entity.staffDetail;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/* Demographic.java
 Entity for Demographic
 Author: Nikitha Mbokotwana (218337906)
*/
@Entity
@Table(name="demographic")
public class Demographic implements Serializable {
    @Id
    private String gender;
    private String birthDate;

    private Demographic(Builder builder) {
        this.gender= builder.gender;
        this.birthDate=builder.birthDate;
    }
    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    //Inner class
    public static class Builder{
        private String gender, birthDate;


        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setBirthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }
        public Demographic build(){
            return new Demographic(this);

        }

        public Builder copy(Demographic demographic){
            this.gender=demographic.gender;
            this.birthDate=demographic.birthDate;
            return this;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "gender='" + gender + '\'' +
                    ", birthDate='" + birthDate + '\'' +
                    '}';
        }
    }
}
