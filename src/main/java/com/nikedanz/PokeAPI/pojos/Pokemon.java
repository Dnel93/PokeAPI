package com.nikedanz.PokeAPI.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon implements DataSerializable {
    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private Sprites sprites;
    @Getter @Setter private List<Types> types;

    public Pokemon() {
    }

    public Pokemon(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sprites=" + sprites +
                ", types=" + types +
                '}';
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(name);
        out.writeObject(sprites);
        out.writeObject(types);
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        id = in.readInt();
        name = in.readObject();
        sprites = in.readObject();
        types = in.readObject();
    }
}
