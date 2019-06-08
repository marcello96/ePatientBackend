package com.epatient.backend;

import com.epatient.backend.persistence.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

    private DataService dataService;

    @Autowired
    public DatabaseInitializer(DataService dataService) {
        this.dataService = dataService;
    }

    public void initializeDatabase() {
        //TODO
    }

}
