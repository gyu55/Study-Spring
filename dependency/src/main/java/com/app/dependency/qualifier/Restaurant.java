package com.app.dependency.qualifier;

public interface Restaurant {
    public default int getPrice() {
        return 30_000;
    }
    public Boolean isSaladBar();
}
