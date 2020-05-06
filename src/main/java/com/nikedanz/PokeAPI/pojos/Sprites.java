package com.nikedanz.PokeAPI.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sprites {
    private String back_default;
    private String front_default;

    public Sprites() {
    }

    public String getBack_default() {
        return back_default;
    }

    public void setBack_default(String back_default) {
        this.back_default = back_default;
    }

    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }

    @Override
    public String toString() {
        return "Sprites{" +
                "back_default='" + back_default + '\'' +
                ", front_default='" + front_default + '\'' +
                '}';
    }
}
