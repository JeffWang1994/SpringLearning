package Part2;

import org.springframework.stereotype.Component;

/**
 * Created by wangjiangfeng on 2018/12/25.
 */
@Component
public class SgtPeppers implements CompactDisc{
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing "+ title + " by "+artist);
    }
}
