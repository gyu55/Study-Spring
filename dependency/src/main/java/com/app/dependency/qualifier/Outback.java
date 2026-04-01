package com.app.dependency.qualifier;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Outback implements Restaurant {
    @Override
    public Boolean isSaladBar() {
        return false;
    }

    @Override
    public int getPrice() {
        return 25_000;
    }
}
