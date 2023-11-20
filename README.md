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






































































