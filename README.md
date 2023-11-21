## 设计模式

### 六大原则
1、单一原则：一个类应该只有一个引起变化的原因，一个类或者模块应该专注单一功能。这样的好处，类复杂性降低，可读性高，易维护。

2、开放封闭原则：对扩展是开放的，但对修改是封闭的。系统设计允许在不修改现有代码的情况下进行扩展，通过添加新的功能。

3、里氏替换原则：任何基类可以出现的地方，子类一定可以出现，而且需要替换基类并不会产生任何不良行为。子类应该能够替换其父类并保持系统行为的一致性。

>子类必须完全实现父类的方法。也就是说，子类中不能缺少父类中已经声明过的方法，也不能改变父类中方法的行为（如参数列表、返回类型等）。
>
>父类中的所有公开引用都应使用父类或者接口来进行定义。这样做的好处是可以避免耦合度过高，并且可以使代码更加模块化。
>
>在不违反封装的原则下，尽量减少子类对父类内部状态的依赖。这样做可以让子类具有更好的可扩展性和可维护性。 总的来说，里氏替换原则旨在确保当一个类被其子类替换时，不会影响整个程序的正确性。遵守这一原则可以帮助我们创建出更稳定、更灵活的软件系统。

4、依赖倒置原则：高层模块不应该依赖于底层模块，二者都应该依赖于抽象。抽象不应该依赖于细节，细节应该依赖于抽象。（说白了就是面向接口编程）

5、接口隔离原则：不应该强迫客户端依赖于它们不使用的接口。应该将接口设计得精细小巧，尽量避免庞大臃肿的接口。

6、迪米特法则：一个软件实体应当尽可能少地与其他实体发生相互作用。优先使用对象组合，而不是继承来实现代码的复用。通过组合（组合多个类的功能）来达到代码复用，而不是通过继承来获得现有类的功能。

### 创建者模式

> creator 模块

创建者模式是一种常见的设计模式，它可以分为以下几种：

+ 单例模式：这种模式只有一个实例，并且提供了一种全局访问点。
+ 工厂模式：这种模式可以根据传入的参数动态地创建对象。
+ 抽象工厂模式：这种模式允许创建一系列相关或相互依赖的对象，而不指定其具体的实现细节。
+ 建造者模式：这种模式将复杂的对象构建过程分解为多个独立的步骤。
+ 原型模式：这种模式可以复制现有对象，而不是创建新对象。

#### 工厂模式

```
┌─────────────┐      ┌─────────────┐
│   Product   │      │   Factory   │
└─────────────┘      └─────────────┘
       ▲                    ▲
       │                    │
┌─────────────┐      ┌─────────────┐
│ ProductImpl │<─ ─ ─│ FactoryImpl │
└─────────────┘      └─────────────┘

```

工厂模式的核心思想是将对象的创建和使用分离出来，使得用户只需要关心对象的使用，而不需要关注对象的具体实现。具体来说，工厂模式提供了一个统一的接口，用户通过调用工厂方法来获取所需对象，而不需要关心对象是如何被创建的。
工厂模式的优点如下：

  * 用户只需关注对象的使用，不需要关心对象的创建过程。
  * 对象的创建过程由工厂负责，因此可以在运行时决定要创建哪个具体对象，这样就可以动态地更改对象的创建方式。
  * 如果有很多相似的对象需要创建，工厂模式可以简化代码，使得代码易于理解和维护。

工厂模式的缺点如下：

  * 如果对象有很多不同的创建方式，那么就需要很多工厂方法，这会使代码变得复杂。
  * 如果没有适当地封装工厂方法，那么就会使代码难以维护和扩展。
  * 如果新的产品对象不断添加进来，那么可能需要不断地修改工厂方法，违背开闭原则。

#### 单例模式

单例模式的核心思想是保证一个类只产生一个实例，并且提供一个全局访问点来获取这个实例。具体来说，单例模式会限制类的构造函数对外部的可见性，并提供一个静态方法来获取唯一的实例。
单例模式的优点如下：

  * 控制了类的实例数量，节约了系统资源。
  * 具备一定的灵活性，在需要的时候可以动态地创建实例。
  * 单例类可以拥有私有的属性，这样就可以防止外部直接修改实例的状态。

单例模式的缺点如下：

  * 类的生命周期无法控制，因为单例对象一旦创建就会一直存在，直到 JVM 结束运行。
  * 如果有多个线程并发地请求单例对象，那么可能会出现多个实例的情况，因此需要采取一些措施来保证单例的线程安全性。
  * 不利于测试，因为单例对象在每次测试中只能有一个，不利于模拟多实例的情况。


#### 抽象工厂模式

抽象工厂模式的核心思想是提供一个接口来创建一组相关或相互依赖的对象，而无需关心具体的产品及其细节。具体来说，它可以创建一系列的产品家族，每个产品家族包含了一系列相关的对象，而不需要知道它们的具体实现。
抽象工厂的优点如下：

  * 提供了一个简单的方式来创建一系列相关或相互依赖的对象。
  * 可以在运行时改变产品家族的内容，例如，你可以很容易地替换掉某个产品家族中的产品。
  * 降低了客户端代码与产品家族之间的耦合度，提高了代码的可扩展性和可维护性。

抽象工厂的缺点如下：

  * 当产品家族的数量增多时，需要创建更多的工厂类，这可能导致代码量增大。
  * 如果要改变产品家族的内容，则需要更新很多地方的代码。

总之，抽象工厂模式可以方便地组织相关的产品家族，并且可以在运行时更改产品的实现。但是，随着产品家族数量的增长，可能会导致代码量增大。

抽象工厂模式（Abstract Factory）是一个比较复杂的创建型模式。

抽象工厂模式和工厂方法不太一样，它要解决的问题比较复杂，不但工厂是抽象的，产品是抽象的，而且有多个产品需要创建，因此，这个抽象工厂会对应到多个实际工厂，每个实际工厂负责创建多个实际产品：

```css
                                ┌────────┐
                             ─ >│ProductA│
┌────────┐    ┌─────────┐   │   └────────┘
│ Client │─ ─>│ Factory │─ ─
└────────┘    └─────────┘   │   ┌────────┐
                   ▲         ─ >│ProductB│
           ┌───────┴───────┐    └────────┘
           │               │
      ┌─────────┐     ┌─────────┐
      │Factory1 │     │Factory2 │
      └─────────┘     └─────────┘
           │   ┌─────────┐ │   ┌─────────┐
            ─ >│ProductA1│  ─ >│ProductA2│
           │   └─────────┘ │   └─────────┘
               ┌─────────┐     ┌─────────┐
           └ ─>│ProductB1│ └ ─>│ProductB2│
               └─────────┘     └─────────┘

```

抽象工厂模式是为了让创建工厂和一组产品与使用相分离，并可以随时切换到另一个工厂以及另一组产品；

抽象工厂模式实现的关键点是定义工厂接口和产品接口，但如何实现工厂与产品本身需要留给具体的子类实现，客户端只和抽象工厂与抽象产品打交道。

#### 生成器模式

将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

生成器模式（Builder）是使用多个“小型”工厂来最终创建出一个完整对象。

当我们使用Builder的时候，一般来说，是因为创建这个对象的步骤比较多，每个步骤都需要一个零部件，最终组合成一个完整的对象。

生成器模式是一种创建型设计模式，其核心思想是将复杂对象的构建过程与客户端代码解耦。生成器模式通过提供一个独立的接口来控制复杂对象的创建过程，使得客户端代码只需关注最终结果，而无需关心具体实现细节。
生成器模式的主要优点包括：

  * 客户端代码与生成器对象之间解耦，因此可以灵活地更改生成器对象以适应不同的需求；
  * 可以将复杂的对象构建过程分解为多个简单的步骤，从而提高代码可读性和可维护性；
  * 通过使用生成器模式，可以减少重复代码，并且可以使客户端代码更加简洁。

生成器模式的主要缺点包括：

  * 如果生成器对象过于复杂，则可能会导致类结构过于复杂；
  * 由于生成器模式需要额外的类和接口，因此可能会增加系统的复杂度；
  * 如果生成器对象没有被正确地设计和实现，则可能会导致系统性能下降。

#### 原型模式

用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。

原型模式，即Prototype，是指创建新对象的时候，根据现有的一个原型来创建。

我们举个例子：如果我们已经有了一个String[]数组，想再创建一个一模一样的String[]数组，怎么写？

实际上创建过程很简单，就是把现有数组的元素复制到新数组。如果我们把这个创建过程封装一下，就成了原型模式。用代码实现如下：

```java

// 原型:
String[] original = { "Apple", "Pear", "Banana" };
// 新对象:
String[] copy = Arrays.copyOf(original, original.length);

```

原型模式是一种创建型设计模式，其核心思想是通过复制已有对象来创建新对象。在原型模式中，一个对象可以作为另一个对象的原型，从而简化了对象的创建过程。
原型模式的主要优点包括：

  * 简化了对象的创建过程，可以通过复制已有对象来创建新对象；
  * 可以通过修改原型对象来改变新创建的对象；
  * 可以避免复杂的构造函数或工厂方法。

原型模式的主要缺点包括：

  * 如果原型对象过于复杂，则可能会导致内存消耗过大；
  * 如果原型对象被频繁地修改，则可能会导致系统性能下降；
  * 如果不正确地管理原型对象，则可能会导致系统出现错误。
  
### 结构型模式

结构型模式主要涉及如何组合各种对象以便获得更好、更灵活的结构。虽然面向对象的继承机制提供了最基本的子类扩展父类的功能，但结构型模式不仅仅简单地使用继承，而更多地通过组合与运行期的动态组合来实现更灵活的功能。

结构型模式有：

适配器、桥接、组合、装饰器、外观、享元、代理

#### 适配器模式
将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。

适配器模式是Adapter，也称Wrapper，是指如果一个接口需要B接口，但是待传入的对象却是A接口，怎么办？

我们举个例子。空调的插头接口是16V，要大一些，如果我们想给手机充电我们就需要一个适配器来转换一下。


Java IO 流中的适配器模式的一个典型例子是 InputStreamReader 和 OutputStreamWriter。这两个类都是适配器类，可以将字符流适配成字节流，或者将字节流适配成字符流。

例如，如果你有一个 InputStream，但你需要一个 Reader，你可以使用 InputStreamReader 作为适配器：

```java
InputStream inputStream = new FileInputStream("file.txt");  
Reader reader = new InputStreamReader(inputStream);
同样地，如果你有一个 Reader，但你需要一个 OutputStream，你可以使用 OutputStreamWriter 作为适配器：
```
```java
Reader reader = new FileReader("file.txt");  
OutputStream outputStream = new FileOutputStream("output.txt");  
Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
```
在这个例子中，InputStreamReader 和 OutputStreamWriter 都是适配器模式的使用者，它们将不兼容的接口适配成了需要的接口。

#### 桥接模式

将抽象部分与它的实现部分分离，使它们都可以独立地变化。

桥接模式的定义非常玄乎，直接理解不太容易，所以我们还是举例子。

假设某个汽车厂商生产三种品牌的汽车：Big、Tiny和Boss，每种品牌又可以选择燃油、纯电和混合动力。如果用传统的继承来表示各个最终车型，一共有3个抽象类加9个最终子类：

```css
  ┌───────┐
                   │  Car  │
                   └───────┘
                       ▲
    ┌──────────────────┼───────────────────┐
    │                  │                   │
┌───────┐          ┌───────┐          ┌───────┐
│BigCar │          │TinyCar│          │BossCar│
└───────┘          └───────┘          └───────┘
    ▲                  ▲                  ▲
    │                  │                  │
    │ ┌───────────────┐│ ┌───────────────┐│ ┌───────────────┐
    ├─│  BigFuelCar   │├─│  TinyFuelCar  │├─│  BossFuelCar  │
    │ └───────────────┘│ └───────────────┘│ └───────────────┘
    │ ┌───────────────┐│ ┌───────────────┐│ ┌───────────────┐
    ├─│BigElectricCar │├─│TinyElectricCar│├─│BossElectricCar│
    │ └───────────────┘│ └───────────────┘│ └───────────────┘
    │ ┌───────────────┐│ ┌───────────────┐│ ┌───────────────┐
    └─│ BigHybridCar  │└─│ TinyHybridCar │└─│ BossHybridCar │
      └───────────────┘  └───────────────┘  └───────────────┘

```
如果要新增一个品牌，或者加一个新的引擎（比如核动力），那么子类的数量增长更快。

所以，桥接模式就是为了避免直接继承带来的子类爆炸。

使用桥接模式的好处在于，如果要增加一种引擎，只需要针对Engine派生一个新的子类，如果要增加一个品牌，只需要针对RefinedCar派生一个子类，任何RefinedCar的子类都可以和任何一种Engine自由组合，即一辆汽车的两个维度：品牌和引擎都可以独立地变化。


```css
      ┌───────────┐
       │    Car    │
       └───────────┘
             ▲
             │
       ┌───────────┐       ┌─────────┐
       │RefinedCar │ ─ ─ ─>│ Engine  │
       └───────────┘       └─────────┘
             ▲                  ▲
    ┌────────┼────────┐         │ ┌──────────────┐
    │        │        │         ├─│  FuelEngine  │
┌───────┐┌───────┐┌───────┐     │ └──────────────┘
│BigCar ││TinyCar││BossCar│     │ ┌──────────────┐
└───────┘└───────┘└───────┘     ├─│ElectricEngine│
                                │ └──────────────┘
                                │ ┌──────────────┐
                                └─│ HybridEngine │
                                  └──────────────┘

```

桥接模式实现比较复杂，实际应用也非常少，但它提供的设计思想值得借鉴，即不要过度使用继承，而是优先拆分某些部件，使用组合的方式来扩展功能。

#### 组合模式

将对象组合成树形结构以表示“部分-整体”的层次结构，使得用户对单个对象和组合对象的使用具有一致性。

组合模式（Composite）经常用于树形结构，为了简化代码，使用Composite可以把一个叶子节点与一个父节点统一起来处理。

可见，使用Composite模式时，需要先统一单个节点以及“容器”节点的接口：

```css

             ┌───────────┐
             │   Node    │
             └───────────┘
                   ▲
      ┌────────────┼────────────┐
      │            │            │
┌───────────┐┌───────────┐┌───────────┐
│ElementNode││ TextNode  ││CommentNode│
└───────────┘└───────────┘└───────────┘

```
作为容器节点的ElementNode又可以添加任意个Node，这样就可以构成层级结构。

类似的，像文件夹和文件、GUI窗口的各种组件，都符合Composite模式的定义，因为它们的结构天生就是层级结构。


#### 装饰器模式

> 动态地给一个对象添加一些额外的职责。就增加功能来说，相比生成子类更为灵活。

装饰器（Decorator）模式，是一种在运行期动态给某个对象的实例增加功能的方法。

我们在IO的Filter模式一节中其实已经讲过装饰器模式了。在Java标准库中，InputStream是抽象类，FileInputStream、ServletInputStream、Socket.getInputStream()这些InputStream都是最终数据源。

现在，如果要给不同的最终数据源增加缓冲功能、计算签名功能、加密解密功能，那么，3个最终数据源、3种功能一共需要9个子类。如果继续增加最终数据源，或者增加新功能，子类会爆炸式增长，这种设计方式显然是不可取的。

Decorator模式的目的就是把一个一个的附加功能，用Decorator的方式给一层一层地累加到原始数据源上，最终，通过组合获得我们想要的功能。

例如：给FileInputStream增加缓冲和解压缩功能，用Decorator模式写出来如下：
```java

// 创建原始的数据源:
InputStream fis = new FileInputStream("test.gz");
// 增加缓冲功能:
InputStream bis = new BufferedInputStream(fis);
// 增加解压缩功能:
InputStream gis = new GZIPInputStream(bis);
或者一次性写成这样：

InputStream input = new GZIPInputStream( // 第二层装饰
                        new BufferedInputStream( // 第一层装饰
                            new FileInputStream("test.gz") // 核心功能
                        ));

```

观察BufferedInputStream和GZIPInputStream，它们实际上都是从FilterInputStream继承的，这个FilterInputStream就是一个抽象的Decorator。我们用图把Decorator模式画出来如下：
```css

             ┌───────────┐
             │ Component │
             └───────────┘
                   ▲
      ┌────────────┼─────────────────┐
      │            │                 │
┌───────────┐┌───────────┐     ┌───────────┐
│ComponentA ││ComponentB │...  │ Decorator │
└───────────┘└───────────┘     └───────────┘
                                     ▲
                              ┌──────┴──────┐
                              │             │
                        ┌───────────┐ ┌───────────┐
                        │DecoratorA │ │DecoratorB │...
                        └───────────┘ └───────────┘


```
           
最顶层的Component是接口，对应到IO的就是InputStream这个抽象类。ComponentA、ComponentB是实际的子类，
对应到IO的就是FileInputStream、ServletInputStream这些数据源。Decorator是用于实现各个附加功能的抽象装饰器，
对应到IO的就是FilterInputStream。而从Decorator派生的就是一个一个的装饰器，它们每个都有独立的功能，对应到IO的就是BufferedInputStream、GZIPInputStream等。


#### 外观模式

> 为子系统中的一组接口提供一个一致的界面。Facade模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。

外观模式，即Facade，是一个比较简单的模式。它的基本思想如下：

如果客户端要跟许多子系统打交道，那么客户端需要了解各个子系统的接口，比较麻烦。如果有一个统一的“中介”，让客户端只跟中介打交道，
中介再去跟各个子系统打交道，对客户端来说就比较简单。所以Facade就相当于搞了一个中介。

#### 享元模式
享元（Flyweight）的核心思想很简单：如果一个对象实例一经创建就不可变，那么反复创建相同的实例就没有必要，直接向调用方返回一个共享的实例就行，这样即节省内存，又可以减少创建对象的过程，提高运行速度。

享元模式在Java标准库中有很多应用。我们知道，包装类型如Byte、Integer都是不变类，因此，反复创建同一个值相同的包装类型是没有必要的。以Integer为例，如果我们通过Integer.valueOf()这个静态工厂方法创建Integer实例，当传入的int范围在-128~+127之间时，会直接返回缓存的Integer实例：

```java

    Integer n1 = Integer.valueOf(100);
    Integer n2 = Integer.valueOf(100);
    System.out.println(n1 == n2); // true

```
对于Byte来说，因为它一共只有256个状态，所以，通过Byte.valueOf()创建的Byte实例，全部都是缓存对象。

因此，享元模式就是通过工厂方法创建对象，在工厂方法内部，很可能返回缓存的实例，而不是新创建实例，从而实现不可变实例的复用。

总是使用工厂方法而不是new操作符创建实例，可获得享元模式的好处。
 
在实际应用中，享元模式主要应用于缓存，即客户端如果重复请求某些对象，不必每次查询数据库或者读取文件，而是直接返回内存中缓存的数据。


#### 代理模式

为其他对象提供一种代理以控制对这个对象的访问。

> 待学习


### 行为模式
行为型模式主要涉及算法和对象间的职责分配。通过使用对象组合，行为型模式可以描述一组对象应该如何协作来完成一个整体任务。

行为型模式有：责任链、命令、解释器、迭代器、中介、备忘录、观察者、状态、策略、模板方法、访问者

#### 责任链模式
使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。

责任链模式（Chain of Responsibility）是一种处理请求的模式，它让多个处理器都有机会处理该请求，直到其中某个处理成功为止。责任链模式把多个处理器串成链，然后让请求在链上传递：

```css

     ┌─────────┐
     │ Request │
     └─────────┘
          │
┌ ─ ─ ─ ─ ┼ ─ ─ ─ ─ ┐
          ▼
│  ┌─────────────┐  │
   │ ProcessorA  │
│  └─────────────┘  │
          │
│         ▼         │
   ┌─────────────┐
│  │ ProcessorB  │  │
   └─────────────┘
│         │         │
          ▼
│  ┌─────────────┐  │
   │ ProcessorC  │
│  └─────────────┘  │
          │
└ ─ ─ ─ ─ ┼ ─ ─ ─ ─ ┘
          │
          ▼
```

在实际场景中，财务审批就是一个责任链模式。假设某个员工需要报销一笔费用，审核者可以分为：

Manager：只能审核1000元以下的报销；

Director：只能审核10000元以下的报销；

CEO：可以审核任意额度。

用责任链模式设计此报销流程时，每个审核者只关心自己责任范围内的请求，并且处理它。对于超出自己责任范围的，扔给下一个审核者处理，这样，将来继续添加审核者的时候，不用改动现有逻辑。

#### 命令模式

命令模式（Command）是指，把请求封装成一个命令，然后执行该命令。

这就是命令模式的结构：

```css
┌──────┐      ┌───────┐
│Client│─ ─ ─>│Command│
└──────┘      └───────┘
                  │  ┌──────────────┐
                  ├─>│ CopyCommand  │
                  │  ├──────────────┤
                  │  │editor.copy() │─ ┐
                  │  └──────────────┘
                  │                    │  ┌────────────┐
                  │  ┌──────────────┐   ─>│ TextEditor │
                  └─>│ PasteCommand │  │  └────────────┘
                     ├──────────────┤
                     │editor.paste()│─ ┘
                     └──────────────┘

然后把执行的一系列命令用List保存起来，就既能支持Undo，又能支持Redo。这个时候，我们又需要一个Invoker对象，负责执行命令并保存历史命令：

┌─────────────┐
│   Client    │
└─────────────┘
       │

       │
       ▼
┌─────────────┐
│   Invoker   │
├─────────────┤    ┌───────┐
│List commands│─ ─>│Command│
│invoke(c)    │    └───────┘
│undo()       │        │  ┌──────────────┐
└─────────────┘        ├─>│ CopyCommand  │
                       │  ├──────────────┤
                       │  │editor.copy() │─ ┐
                       │  └──────────────┘
                       │                    │  ┌────────────┐
                       │  ┌──────────────┐   ─>│ TextEditor │
                       └─>│ PasteCommand │  │  └────────────┘
                          ├──────────────┤
                          │editor.paste()│─ ┘
                          └──────────────┘


```

命令模式的设计思想是把命令的创建和执行分离，使得调用者无需关心具体的执行过程。

通过封装Command对象，命令模式可以保存已执行的命令，从而支持撤销、重做等操作。

#### 解释器模式

给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。

解释器模式（Interpreter）是一种针对特定问题设计的一种解决方案。例如，匹配字符串的时候，由于匹配条件非常灵活，使得通过代码来实现非常不灵活。

解释器模式通过抽象语法树实现对用户输入的解释执行。

解释器模式的实现通常非常复杂，且一般只能解决一类特定问题

#### 迭代器模式

提供一种方法顺序访问一个聚合对象中的各个元素，而又不需要暴露该对象的内部表示。

迭代器模式（Iterator）实际上在Java的集合类中已经广泛使用了。我们以List为例，要遍历ArrayList，
即使我们知道它的内部存储了一个Object[]数组，也不应该直接使用数组索引去遍历，因为这样需要了解集合内部的存储结构。
如果使用Iterator遍历，那么，ArrayList和LinkedList都可以以一种统一的接口来遍历：

#### 中介模式

用一个中介对象来封装一系列的对象交互。中介者使各个对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。

中介模式（Mediator）又称调停者模式，它的目的是把多方会谈变成双方会谈，从而实现多方的松耦合。

考虑一个简单的点餐输入：

 汉堡
 鸡块
 薯条
 咖啡
选择全部 取消所有 反选

这个小系统有4个参与对象：

多选框；
+ “选择全部”按钮；
+ “取消所有”按钮；
+ “反选”按钮。
它的复杂性在于，当多选框变化时，它会影响“选择全部”和“取消所有”按钮的状态（是否可点击），当用户点击某个按钮时，例如“反选”，除了会影响多选框的状态，它又可能影响“选择全部”和“取消所有”按钮的状态。

所以这是一个多方会谈，逻辑写起来很复杂：

┌─────────────────┐     ┌─────────────────┐
│  CheckBox List  │<───>│SelectAll Button │
└─────────────────┘     └─────────────────┘
         ▲ ▲                     ▲
         │ └─────────────────────┤
         ▼                       │
┌─────────────────┐     ┌────────┴────────┐
│SelectNone Button│<────│ Inverse Button  │
└─────────────────┘     └─────────────────┘
如果我们引入一个中介，把多方会谈变成多个双方会谈，虽然多了一个对象，但对象之间的关系就变简单了：

            ┌─────────────────┐
     ┌─────>│  CheckBox List  │
     │      └─────────────────┘
     │      ┌─────────────────┐
     │ ┌───>│SelectAll Button │
     ▼ ▼    └─────────────────┘
┌─────────┐
│Mediator │
└─────────┘
     ▲ ▲    ┌─────────────────┐
     │ └───>│SelectNone Button│
     │      └─────────────────┘
     │      ┌─────────────────┐
     └─────>│ Inverse Button  │
            └─────────────────┘
下面我们用中介模式来实现各个UI组件的交互。首先把UI组件给画出来：

#### 备忘录模式

在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。

备忘录模式（Memento），主要用于捕获一个对象的内部状态，以便在将来的某个时候恢复此状态。

其实我们使用的几乎所有软件都用到了备忘录模式。最简单的备忘录模式就是保存到文件，打开文件。对于文本编辑器来说，
保存就是把TextEditor类的字符串存储到文件，打开就是恢复TextEditor类的状态。对于图像编辑器来说，原理是一样的，
只是保存和恢复的数据格式比较复杂而已。Java的序列化也可以看作是备忘录模式。

标准的备忘录模式有这么几种角色：

+ Memento：存储的内部状态；
+ Originator：创建一个备忘录并设置其状态；
+ Caretaker：负责保存备忘录。

备忘录模式是为了保存对象的内部状态，并在将来恢复，大多数软件提供的保存、打开，以及编辑过程中的Undo、Redo都是备忘录模式的应用。

#### 观察者模式

定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。

观察者模式（Observer）又称发布-订阅模式（Publish-Subscribe：Pub/Sub）。它是一种通知机制，让发送通知的一方（被观察方）和接收通知的一方（观察者）能彼此分离，互不影响。


广义的观察者模式包括所有消息系统。所谓消息系统，就是把观察者和被观察者完全分离，通过消息系统本身来通知：



```css
                 ┌ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┐
                   Messaging System
                 │                       │
                   ┌──────────────────┐
              ┌──┼>│Topic:newProduct  │──┼─┐    ┌─────────┐
              │    └──────────────────┘    ├───>│ConsumerA│
┌─────────┐   │  │ ┌──────────────────┐  │ │    └─────────┘
│Producer │───┼───>│Topic:priceChanged│────┘
└─────────┘   │  │ └──────────────────┘  │
              │    ┌──────────────────┐         ┌─────────┐
              └──┼>│Topic:soldOut     │──┼─────>│ConsumerB│
                   └──────────────────┘         └─────────┘
                 └ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┘

```


#### 状态模式


允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它的类。

状态模式（State）经常用在带有状态的对象中。

什么是状态？我们以QQ聊天为例，一个用户的QQ有几种状态：

* 离线状态（尚未登录）；
* 正在登录状态；
* 在线状态；
* 忙状态（暂时离开）

状态模式的设计思想是把不同状态的逻辑分离到不同的状态类中，从而使得增加新状态更容易；

状态模式的实现关键在于状态转换。简单的状态转换可以直接由调用方指定，复杂的状态转换可以在内部根据条件触发完成。


#### 策略模式

定义一系列的算法，把它们一个个封装起来，并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。

策略模式：Strategy，是指，定义一组算法，并把其封装到一个对象中。然后在运行时，可以灵活的使用其中的一个算法。

策略模式在Java标准库中应用非常广泛，我们以排序为例，看看如何通过Arrays.sort()实现忽略大小写排序：

```java
    String[] array = { "apple", "Pear", "Banana", "orange" };
    Arrays.sort(array, String::compareToIgnoreCase);
    System.out.println(Arrays.toString(array));

```

一个完整的策略模式要定义策略以及使用策略的上下文。我们以购物车结算为例，假设网站针对普通会员、Prime会员有不同的折扣，同时活动期间还有一个满100减20的活动，这些就可以作为策略实现。先定义打折策略接口：


```css

┌───────────────┐      ┌─────────────────┐
│DiscountContext│─ ─ ─>│DiscountStrategy │
└───────────────┘      └─────────────────┘
                                ▲
                                │ ┌─────────────────────┐
                                ├─│UserDiscountStrategy │
                                │ └─────────────────────┘
                                │ ┌─────────────────────┐
                                ├─│PrimeDiscountStrategy│
                                │ └─────────────────────┘
                                │ ┌─────────────────────┐
                                └─│OverDiscountStrategy │
                                  └─────────────────────┘

```
策略模式的核心思想是在一个计算方法中把容易变化的算法抽出来作为“策略”参数传进去，从而使得新增策略不必修改原有逻辑。

策略模式是为了允许调用方选择一个算法，从而通过不同策略实现不同的计算结果。

通过扩展策略，不必修改主逻辑，即可获得新策略的结果。

#### 模板模式

定义一个操作中的算法的骨架，而将一些步骤延迟到子类中，使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。

模板方法（Template Method）是一个比较简单的模式。它的主要思想是，定义一个操作的一系列步骤，对于某些暂时确定不下来的步骤，就留给子类去实现好了，这样不同的子类就可以定义出不同的步骤。

可见，模板方法的核心思想是：父类定义骨架，子类实现某些细节。

为了防止子类重写父类的骨架方法，可以在父类中对骨架方法使用final。对于需要子类实现的抽象方法，一般声明为protected，使得这些方法对外部客户端不可见。

Java标准库也有很多模板方法的应用。在集合类中，AbstractList和AbstractQueuedSynchronizer都定义了很多通用操作，子类只需要实现某些必要方法。











