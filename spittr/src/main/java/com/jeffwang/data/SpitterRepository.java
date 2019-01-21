package com.jeffwang.data;

import com.jeffwang.Spitter;

import java.util.List;

public interface SpitterRepository {

    List<Spitter> save (Spitter spitter);
    Spitter findByUsername(String username);

}
