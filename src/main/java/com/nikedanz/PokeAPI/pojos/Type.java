package com.nikedanz.PokeAPI.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Type implements DataSerializable{
    @Getter @Setter private String name;

    public Type() {
    }

    @Override
    public String toString() {
        return "Type{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeObject(name);
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        name = in.readObject();
    }
}
