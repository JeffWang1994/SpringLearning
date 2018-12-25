package Part1;

import java.io.PrintStream;

/**
 * Created by wangjiangfeng on 2018/12/25.
 */
public class Minstrel {
    private PrintStream stream;

    public Minstrel(PrintStream stream){
        this.stream = stream;
    }

    public void singBeforeQuest(){
        stream.println("Fa la la, the kinght is so brave!");
    }

    public void singAfterQuest(){
        stream.println("Tee hee hee, the brave knight "+"did embark on a quest");
    }
}
