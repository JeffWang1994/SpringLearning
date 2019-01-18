package Part3;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;


/**
 * Created by wangjiangfeng on 2018/12/26.
 */
public class MagicExistsCondition implements Condition{
    public boolean matches(
            ConditionContext context, AnnotatedTypeMetadata metadata){
        Environment env = context.getEnvironment();
        return env.containsProperty("magic");
    }
}