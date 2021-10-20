package za.ac.cput.repository.orderDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.orderDetail.CustomerInvoice;

import java.util.Set;

@Repository
public interface CustomerInvoiceRepository extends JpaRepository<CustomerInvoice, String> {


}