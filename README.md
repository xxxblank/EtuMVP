# EtuMVP
仿照jude的Beam框架

## 进度
基本完成顶层activity、视图工具类viewHelper，顶层presenter，顶层presenter的构建类、管理类、
相关的注解。
已转移activity的生命周期到视图工具类、通过视图工具类绑定到presenter的生命周期。
presenter和view层解耦，presenter持有view的弱引用，view通过反射和注解获取presenter，presenter
由管理类进行统一管理，存放在一个map中，因此如果activity因为意外情况销毁重建，则presenter不需要重建，
已经重写onsaveinstance方法，通过存储在内存中的map和onsaveinstance时存储的presenter的id取回存储
在map中的presenter即可恢复意外销毁之前的数据

目前v和p已经可以通过getPresenter和getView相互通信，且v的生命周期方法全部反映到了presenter中。

## whatTODO
model层与p层的通信和封装，前面代码的完善和测试

## 顶层activity类

作为view层顶层类，抽象类，抽取了底层的公共动作（获取presenter、对视图帮助类的操作，其中前面两个功能都是封装在视图帮助类里的）、activity的各种生命周期等，并将activity的生命周期转移到视图帮助类

## 视图帮助类

工具类，用于顶层视图类与presenter之间绑定、presenter的创建过程的封装，其中presenter的创建和管理的细节封装在另一个管理类中，将顶层视图与presenter解耦，将生命周期转移到presenter中

视图帮助类的内容可以直接写到activity中，即activity里可以直接写presenter构建的部分，但是顶层activity、fragment中这部分代码逻辑相同，故可以直接抽取出来做一个帮助类。

## presenter管理类

负责统一管理presenter的创建、调度、销毁，为方便扩展，可以有一个抽象类将统一的必须的方法抽象出来，然后具体实现一个类，如果以后需要扩展可以去实现另一个类

## presenter的构建类

放一个构造presenter的方法，jude框架里的方法是通过注解和反射来实例化一个presenter对象并返回。

## 公用base类

底层之上的第二层封装，底层封装的是完全的逻辑，这一层可以封装一些视图上的共性，也可以不用这一层