package com.app.dependency.qualifier;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Vips implements Restaurant {
    @Override
    public Boolean isSaladBar() {
        return true;
    }

    @Override
    public int getPrice() {
        return 35_000;
    }
}
