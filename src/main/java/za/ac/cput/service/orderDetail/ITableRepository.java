package za.ac.cput.service.orderDetail;

import za.ac.cput.entity.orderDetail.Ta_ble;
import za.ac.cput.service.IService;

import java.util.Set;

public interface ITableRepository extends IService<Ta_ble, String> {
    public Set<Ta_ble> getAll();
}
