package Part1;

import java.io.PrintStream;

/**
 * Created by wangjiangfeng on 2018/12/25.
 */
public class SlayDragonQuest implements Quest{

    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream){
        this.stream = stream;
    }

    public void embark(){
        stream.println("Embarking on quest to slay the dragon!");
    }
}
