package za.ac.cput.entity.orderDetail;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/* Table.java
 Entity for Table
 Author: Sindiswa Nomusa Mbhele (219279616)
*/
@Entity
@Table(name="table")
public class Ta_ble implements Serializable {
    @Id
    private String tableNumber;
    private boolean occupied;

    private Ta_ble(){};


    private Ta_ble(Builder builder){
        this.tableNumber = builder.tableNumber;
        this.occupied = builder.occupied;
    }


    public String getTableNumber() {
        return tableNumber;
    }

    public boolean getOccupied() {
        return occupied;
    }

    public static class Builder{
        private String tableNumber;
        private boolean occupied;

        public Builder tableNumber(String tableNumber){
            this.tableNumber = tableNumber;
            return this;
        }

        public Builder occupied(boolean occupied){
            this.occupied = occupied;
            return this;
        }

        public Builder copy(Ta_ble table){
            this.tableNumber = table.tableNumber;
            this.occupied = table.occupied;
            return this;
        }

        public Ta_ble build(){
            return new Ta_ble(this);
        }
    }

    @Override
    public String toString() {
        return "Ta_ble{" +
                "tableNumber='" + tableNumber + '\'' +
                ", occupied=" + occupied +
                '}';
    }
}
