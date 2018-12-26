package Part1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangjiangfeng on 2018/12/25.
 */
public class KnightMain {

    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Part1/knights.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
    }
}
