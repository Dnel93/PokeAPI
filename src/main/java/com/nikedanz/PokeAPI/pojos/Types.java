package com.nikedanz.PokeAPI.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Types implements DataSerializable{

    @Getter @Setter private int slot;
    @Getter @Setter private Type type;

    public Types() {
    }


    @Override
    public String toString() {
        return "Types{" +
                "slot=" + slot +
                ", type=" + type +
                '}';
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeInt(slot);
        out.writeObject(type);
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        slot = in.readInt();
        type = in.readObject();
    }
}
