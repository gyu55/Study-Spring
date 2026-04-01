package com.app.dependency.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RestaurantTest {
    @Autowired @Qualifier(value="vips")
    private Restaurant restaurant;

    @Test
    public void outbackTest(){
        log.info("restaurant : {}", restaurant);
        log.info("restaurant.isSaladBar(): {}", restaurant.isSaladBar());
        log.info("restaurant.getPrice(): {}", restaurant.getPrice());
    }
}
