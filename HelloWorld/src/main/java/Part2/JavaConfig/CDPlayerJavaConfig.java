package Part2.JavaConfig;

import Part2.CDPlayer;
import Part2.CompactDisc;
import Part2.SgtPeppers;
import org.springframework.context.annotation.Bean;

/**
 * Created by wangjiangfeng on 2018/12/26.
 */
public class CDPlayerJavaConfig {

    @Bean
    public CompactDisc sgtPepper(){
        return new SgtPeppers();
    }

    @Bean
    public CompactDisc randomBeatlesCD(){
        int choice = (int)Math.floor(Math.random()*4);
        if (choice == 0){
            return new SgtPeppers();
        } else if (choice == 1){
            return new WhiteAlbum();
        } else if (choice == 2){
            return new HardDayNight();
        } else {
            return new Revolver();
        }
    }

    @Bean
    public CDPlayer cdPlayer(){
        return new CDPlayer(sgtPepper());
    }


}
