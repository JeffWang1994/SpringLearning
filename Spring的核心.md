# Spring的核心
>Spring最核心的两个特性：依赖注入(DI)，面向切面编程(AOP)

  在我的理解中，Spring的两个核心都是为了提高POJO(Plain Old Java object)的作用。

## Bean
  一开始不知道什么是Bean，按字面理解就是一个豆，每一个可以实例化的类都可以成为一个豆。那么要做一个好看的饰品，就需要把不同豆串起来。串起来的工作就叫做装配，豆与豆之间的关系就叫做耦合

## DI依赖注入
  在没有DI的情况下，要想实现主类与依赖类之间的紧耦合，就需要在构造函数中，将依赖类作为输入引入到主类中。
  但是在有DI的情况下，在主类中只需要注入接口。由于在构造函数中注入的是接口，因此主类并没有和任何一个依赖类形成紧耦合。
  通过Spring的装配(Wiring)方法，将主类和依赖类组成松耦合。最常用的装配方法是XML配置。
    <bean id="knight" class="Part1.BraveKnight">
        <constructor-arg ref="quest" />
    </bean>
    <bean id="quest" class="Part1.SlayDragonQuest">
        <constructor-arg value="#{T(System).out}" />
    </bean>
  将BraveKnight类定义为knight bean，并声明knight bean有一个构造器输入，其输入是quest bean。再定义具体的实现类 SlayDragonQuest 定义为 quest bean，并声明bean有一个输入为 PrintStream。
  这样通过XML配置，就可以将实现类SlayDragonQuest和类BraveKnight实现松耦合。

## AOP面向切面编程
  Q：为什么需要面向切面编程？
  A：主要是为了分离出在各个功能中重复出现的功能，形成可重用组件。比如日志，事务管理，安全等系统服务，也称为横切关注点。
  Q：那为什么不能直接在类中直接申明使用呢？
  A：这样就会使得类变得复杂，就不纯粹实现自己的功能了。
  因此我们希望能通过XML进行AOP配置。
    <bean id="minstrel" class="Part1.Minstrel">
        <constructor-arg value="#{T(System).out}" />
    </bean>
    <aop:config>
        <aop:aspect ref="minstrel">
            <aop:pointcut id="embark" expression="execution(* *.embarkOnQuest(..))"/>
            <aop:before pointcut-ref="embark" method="singBeforeQuest"/>
            <aop:after pointcut-ref="embark" method="singAfterQuest"/>
        </aop:aspect>
    </aop:config>
  首先将可重用的类申明为bean，同时定义一个aop:aspect，这个aspect的ref为可重用组件的bean。然后定义切点aop:pointcut，在什么时候切开。最后定义切开前后的行为：aop:before和aop:after。

## 模版
  消除重复工作，比如最典型的JDBC，写来写去那几句话，Spring有一个模版可以简化编写。

## Bean生命周期
  开始->实例化->填充属性
  ->调用BeanNameAware的setBeanName()
  ->调用BeanFactoryAware的setBeanFactory()
  ->调用ApplicationContextAware的setApplicationContext()
  ->调用BeanPostProcessor的预初始化方法->
  调用InitializingBean的afterPropertiesSet()
  ->调用自定义的初始化方法
  ->调用BeanPostProcessor的初始化后方法
  ->Bean可以使用了-------------->容器关闭
  ->调用DisposableBean的destroy()
  ->调用自定义的销毁方法->结束
