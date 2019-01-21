package com.jeffwang.data;

import com.jeffwang.Spitter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpitterRepositoryImpl implements SpitterRepository{

    private final List<Spitter> SpitterList = new ArrayList<Spitter>();

    public List<Spitter> save(Spitter spitter){
        SpitterList.add(spitter);
        return SpitterList;
    }

    public Spitter findByUsername(String username) {
        Spitter theSpitter = new Spitter();
        for (int i = 0; i<SpitterList.size(); i++){
            if(SpitterList.get(i).getUsername().equals(username)){
                theSpitter = SpitterList.get(i);
                return theSpitter;
            }
        }
        return theSpitter;
    }
}
