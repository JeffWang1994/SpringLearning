# 面向切面的Spring
    面向切面编程的基本原理
    通过POJO创建切面
    使用@AspectJ注解
    为AspectJ切面注入依赖

## 什么是面向切面编程
> 在软件开发中，散步于应用中多处的功能被称为横切关注点。这些横切关注点从概念上是与应用的业务逻辑相分离的。比如常见的日志服务，安全服务，缓存服务。  
    Q：什么是切面？
    A：为了将这些横切关注点模块化为特殊的类，这些特殊的类被称为切面。比如日志服务单独成为一个特殊的类，后续各个逻辑服务只需要调用这个特殊的类即可。
    
    一些专业术语：
    1. 通知(advice): 就是指切面的工作，比如记录日志。这个通知分为几大部分：
        前置通知(Before)：在目标方法被调用之前调用通知功能
        后置通知(After)：在目标方法完成之后调用通知，不关心目标方法的输出是什么
        返回通知(After-returning)：在目标方法成功执行之后调用通知
        异常通知(After-throwing)：在目标方法抛出异常后调用通知
        环绕通知(Around)：通知包裹了被通知的方法，在被通知方法调用之前和之后执行通知
    2. 连接点(Join point)：应用执行过程中能够插入切面的时机点
    3. 切点(pointcut)：定义在哪个连接点插入切面。通知定义了什么和何时，切点定义何处。
    4. 切面(Aspect)：切面是切点和通知的结合。
    5. 引入(Introduction)：引入允许我们向现有的类添加新方法或新属性
    6. 织入(Weaving)：把切面应用到目标对象并创建新的代理对象的过程。

## 通过切点来选择连接点
    这一节具体实现了切点，通知，详细代码可以见Part4.
    1. 编写切点
    '''
     execution(* concert.Performance.perform(..)) && within(concert.*) and !bean('woodstock')
    '''

## 使用注解创建切面
    *使用@Aspect声明切面
    *使用@Pointcut("execution(** concert.Perform.perform(..))")声明切点
    *使用@EnableAspectJAutoProxy来启动AspectJ自动代理，启动了自动代理之后才能将切面声明为bean
    *使用<aop:aspectj-autoproxy />在xml里启动AspectJ自动代理
    *使用@Around("preformance()")来声明环绕通知方法
    *使用@DeclareParents(value="concert.Performance+", defaultImpl= DefaultEncoreable.class)来通过切面引入新方法
这一章比较简单，主要是AOP的相关知识
