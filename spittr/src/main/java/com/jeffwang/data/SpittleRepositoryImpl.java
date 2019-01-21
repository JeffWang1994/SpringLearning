package com.jeffwang.data;

import com.jeffwang.Spitter;
import com.jeffwang.Spittle;
import org.springframework.stereotype.Component;
import sun.security.provider.ConfigFile;

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

    public List<Spittle> findOne (long spittleId){
        List<Spittle> OneSpittle = new ArrayList<Spittle>();
        OneSpittle.add(new Spittle("Spittle "+ spittleId, new Date()));
        return OneSpittle;
    }

}
