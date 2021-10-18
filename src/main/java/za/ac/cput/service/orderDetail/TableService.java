package za.ac.cput.service.orderDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.orderDetail.Ta_ble;
import za.ac.cput.repository.orderDetail.TableRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TableService implements ITableRepository{

    public static TableService service = null;

    @Autowired
    private TableRepository repository;

    @Override
    public Ta_ble create(Ta_ble table) {
        return this.repository.save(table);
    }

    @Override
    public Ta_ble update(Ta_ble table) {
        if(this.repository.existsById(table.getTableNumber()))
            return this.repository.save(table);
        return null;
    }

    @Override
    public Ta_ble read(String tableId) {
        return this.repository.findById(tableId).orElse(null);
    }

    @Override
    public boolean delete(String tableId) {
        this.repository.deleteById(tableId);
        if(this.repository.existsById(tableId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Ta_ble> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
