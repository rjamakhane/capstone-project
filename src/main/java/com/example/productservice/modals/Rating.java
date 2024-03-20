package com.example.productservice.modals;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rating {
    private int rate;
    private int count;
    public Rating() {
    }

    public Rating(int rate, int count) {
        this.rate = rate;
        this.count = count;
    }
}
