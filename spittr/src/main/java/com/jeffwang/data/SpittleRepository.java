package com.jeffwang.data;

import java.util.List;
import com.jeffwang.Spittle;

public interface SpittleRepository {
    List<Spittle> findSpittles (long max, int count);
}
