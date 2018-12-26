package Part1;

/**
 * Created by wangjiangfeng on 2018/12/25.
 */
public class BraveKnight implements Knight{
    private Quest quest;

    public BraveKnight(Quest quest){
        this.quest = quest;
    }

    public void embarkOnQuest(){
        quest.embark();
    }
}
