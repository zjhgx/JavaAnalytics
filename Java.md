### Nested Classes
A nested class is a member of its enclosing class. Non-static nested classes (inner classes) have access to other members of the enclosing class, even if they are declared private. Static nested classes do not have access to other members of the enclosing class. As a member of the OuterClass, a nested class can be declared private, public, protected, or package private. (Recall that outer classes can only be declared public or package private.)

#### Why Use Nested Classes?
* It is a way of logically grouping classes that are only used in one place: If a class is useful to only one other class, then it is logical to embed it in that class and keep the two together. Nesting such "helper classes" makes their package more streamlined.
* It increases encapsulation: Consider two top-level classes, A and B, where B needs access to members of A that would otherwise be declared private. By hiding class B within class A, A's members can be declared private and B can access them. In addition, B itself can be hidden from the outside world.
* It can lead to more readable and maintainable code: Nesting small classes within top-level classes places the code closer to where it is used.

#### Static Nested Classes
And like static class methods, a static nested class cannot refer directly to instance variables or methods defined in its enclosing class: it can use them only through an object reference.
A static nested class interacts with the instance members of its outer class (and other classes) just like any other top-level class. In effect, a static nested class is behaviorally a top-level class that has been nested in another top-level class for packaging convenience.
Static nested classes are accessed using the enclosing class name:
```
OuterClass.StaticNestedClass
```
For example, to create an object for the static nested class, use this syntax:
```
OuterClass.StaticNestedClass nestedObject =
     new OuterClass.StaticNestedClass();
```

#### Inner Classes
As with instance methods and variables, an inner class is associated with an instance of its enclosing class and has direct access to that object's methods and fields. Also, because an inner class is associated with an instance, it cannot define any static members itself.
An instance of InnerClass can exist only within an instance of OuterClass and has direct access to the methods and fields of its enclosing instance.
To instantiate an inner class, you must first instantiate the outer class. Then, create the inner object within the outer object with this syntax:
```
OuterClass.InnerClass innerObject = outerObject.new InnerClass();
```
There are two special kinds of inner classes: local classes and anonymous classes.

### Local Classes
Local classes are classes that are defined in a block, which is a group of zero or more statements between balanced braces. You typically find local classes defined in the body of a method.


### Anonymous Classes
Anonymous classes enable you to make your code more concise. They enable you to declare and instantiate a class at the same time. They are like local classes except that they do not have a name. Use them if you need to use a local class only once.
