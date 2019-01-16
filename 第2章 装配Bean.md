# 第2章 装配Bean

## 本章内容
  声明bean  
  构造器注入和Setter方法注入  
  装配Bean  
  控制Bean的创建和销毁  

## Spring配置的可选方案
  Spring的核心是Spring容器，而Spring容器负责创建应用程序中的bean并通过DI来协调这些对象之间的关系。  
    Spring提供三种最常用的配置方法：  
      1. XML  
      2. Java  
      3. 隐形bean发现机制和自动装配  

  书中的推荐使用顺序是：  
  >自动配置优先，不行用更安全的JavaConfig，最后再是XML。

  但是不管是哪一种，都需要程序员来告知需要创建哪些bean，如何进行装配。  

  ### 自动化装配bean
    自动化装配分为两个角度：组件扫描(component scanning)和自动装配(autowiring)  
      组件扫描:Spring会自动发现应用上下文中所创建的bean。  
      自动装配:Spring自动满足bean之间的依赖。  
    组件扫描
    1. 使用@Component注解来表明该类会作为组件类，并告知Spring要为这个类创建bean。  
        ```
        @Component
        public class SgtPeppers implements CompactDisc{
            private String title = "Sgt. Pepper's Lonely Hearts Club Band";
            private String artist = "The Beatles";
            public void play() {
                System.out.println("Playing "+ title + " by "+artist);
            }
        }
        ```
        @Component会根据类名为所有的bean分配一个ID。如果想要自己分配，可以输入参数  
        ```@Component("lonelyHeartsClub")```
    2. 若Java配置，使用@ComponentScan注解来启用组件扫描，默认会扫描与配置类相同的包。  
       ```
       @Configuration
       @ComponentScan
       public class CDPlayerConfig {}
       ```  
       默认情况下，@ComponentScan会以配置类所在的包作为基础包来扫描组件。如果需要扫描其他基础包或者多个基础包的话，需要进行如下设置：  
       ```@ComponentScan(basePackages={"soundsystem", "video"})```
       ```@ComponentScan(basePackagesClasses={CDPlayer.class, DVDPlayer.class})```
       若XML配置，使用<context:component-scan>元素启动组件扫描。    
       ```<context:component-scan base-package="Part2"/>```
    3. 在测试Java中，使用@ContextConfiguration注解，自动创建Spring应用上下文。    
        ```@ContextConfiguration(classes = CDPlayerConfig.class)```  
    自动装配  
    @Autowired注释标记在构造器或者方法名上，可以表明Spring在调用该方法时，会去匹配相应的bean，并且传入该方法。  
    ```
    @Component
    public class CDPlayer implements MediaPlayer{
        private CompactDisc cd;
        @Autowired
        public CDPlayer(CompactDisc cd){
            this.cd = cd;
        }
        public void play() {
            cd.play();
        }
    }
    ```
    当然如果没有匹配的bean，在应用上下文创建的时候，Spring会抛出一个异常。也可以不抛出，只需要设置```@Autowired(required=false)```。  
    最后可以验证自动装配是否成功，具体代码见CDPlayerTest测试类。 
    
    个人理解：
      准备调料：@Component，标上@Component的类都会成为bean。但是不是调料，要看方法上有没有@Autowired
      准备主食：@Autowired，在构造器和方法上标上Autowired的，是主食bean。一般有构造器上@Autowired的，类名上都有@Component，因为要申明自己是主               食bean。
      配方书写：在Config中，使用@ComponentScan，告诉Spring在哪里找调料和主食，怎么配自己看着办。

  ## 通过Java代码装配bean  
    自动化配置虽然好，但是加载第三方库中的组件时，还是需要手动配置的。使用Java进行配置时，有以下步骤：  
      1. 声明bean  
        对于所需类型的实例创建带有@bean注释的方法，这个方法返回一个对象，这个对象就是要注册为bean的对象。  
        ```
        @Bean(name="lonelyHeartsClubBand")
        public CompactDisc sgtPeppers(){
            return new SgtPeppers();
        }
        ```
      2. 借助JavaConfig实现注入  
        最简单的方法：引入创建bean的方法  
        ```
        @Bean
        public CDPlayer cdPlayer(){
            return new CDPlayer(sgtPepper());
        }
        ```
        最常用的方法：将bean作为参数传入  
        ```
        @Bean
        public CDPlayer anothercdPlayer(CompactDisc compactDisc){
            return new CDPlayer(compactDisc);
        }
        ```
      个人理解：
        1. 准备调料：加上@Bean的都要成为Bean，至于是主食还是调料，看Config
        2. 准备主食：同样也是加上@Bean就可以了，等着Config分配
        3. 配方书写：在Config里，引用创建Bean，public 主食bean {return 配方bean};

  ## 通过XML配置bean
    XML配置会有三个步骤：
    1. 声明bean
    ```<bean id="compactDisc" class="soundsystem.SgtPeppers" />```  
    2. 借助构造器注入初始化bean
    ```
    <!-- 使用<constructor-arg>元素实现构造器注入 -->
    <bean id="cdPlayer" class="soundsystem.CDPlayer">
        <constructor-arg ref="compactDisc" />
    </bean>
    <!-- 使用c命名空间来声明构造器参数 -->
    <bean id="cdPlayer" class="soundsystem.CDPlayer"
          c:cd-ref="compactDisc" />
    ```
    3. bean属性注入
    ```
    <!-- 使用<property>元素实现属性注入 -->
    <bean id="cdPlayer"
          class="soundsystem.CDPlayer">
      <property name="compactDisc" ref="compactDisc" />
    </bean>
    <!-- 使用p命名空间来声明属性参数 -->
    <bean id="cdPlayer"
          class="soundsystem.CDPlayer"
          p:compactDisc-ref="compactDisc" />
    ```
    
    个人理解：
      1. 准备配料: <bean id="配料bean" class="..." />
      2. 准备主食: <bean id="主食bean" class="..." /> <constructor-arg ref="配料bean">
  
    

