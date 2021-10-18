package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.entity.orderDetail.Ta_ble;
import za.ac.cput.factory.orderDetail.TableFactory;
import za.ac.cput.service.orderDetail.TableService;

public class TableController {
    @Autowired
    private TableService tableService;

    @PostMapping("/create")
    public Ta_ble create(@RequestBody Ta_ble table){
        Ta_ble newTable = TableFactory.buildTable(table.getOccupied());
        return tableService.create(newTable);
    }

    @GetMapping("/read/{id}")
    public Ta_ble read(@PathVariable String id){
        return tableService.read(id);
    }

    @PostMapping("/update")
    public Ta_ble update(@RequestBody Ta_ble table){
        return tableService.update(table);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return tableService.delete(id);
    }
}
