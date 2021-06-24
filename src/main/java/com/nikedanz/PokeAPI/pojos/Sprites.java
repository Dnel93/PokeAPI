package com.nikedanz.PokeAPI.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sprites implements DataSerializable{
    @Getter @Setter private String back_default;
    @Getter @Setter private String front_default;

    public Sprites() {
    }

    @Override
    public String toString() {
        return "Sprites{" +
                "back_default='" + back_default + '\'' +
                ", front_default='" + front_default + '\'' +
                '}';
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeObject(back_default);
        out.writeObject(front_default);
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        back_default = in.readObject();
        front_default = in.readObject();
    }
}
