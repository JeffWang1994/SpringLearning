package com.jeffwang.data;

import com.jeffwang.Spittle;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpittleRepositoryImpl implements SpittleRepository{

    public List<Spittle> findSpittles (long max, int count){
        List<Spittle> spittlelist = new ArrayList<Spittle>();
        for (int i = 0; i<count; i++){
            spittlelist.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittlelist;
    }

    public Spittle findOne (long spittleId){
        return new Spittle("Spittle "+ spittleId, new Date());
    }
}
