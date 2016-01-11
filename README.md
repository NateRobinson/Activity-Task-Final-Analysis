# Activity Task Final Analysis

Activity任务栈模式终极分析：在吸收了网络上各路大神的分析文章之后，我自己还是忍不住想写下这个属于自己的终极分析Demo。

- 一来总结各家所长，检测自己的学习成果；
- 二来给自己这块内容的学习画上一个里程碑，并封存笔记，方便以后回味复习。


----------
**分析会用到的CMD命令：**
>  `adb shell dumpsys activity`

## AndroidMainifest启动模式 ##

设置方式：
    android:launchMode="standard/singTop/singleTask/singInstance"

**一、standard**

 该模式为Activity默认的启动模式，每启动一个Activity，新的Activity就会覆盖到旧的Activity上面：

 ![standard启动模式任务栈分析图](https://github.com/NateRobinson/Activity-Task-Final-Analysis/blob/master/imgs/1.png?raw=true)

**二、singleTop**
 
打开该模式下的Activity，系统会判断当前任务栈的栈顶是不是此Activity，如果是则不创建新的Activity直接引用并且会执行`onNewIntent(Intent intent)`方法，否则创建新的Activity：

![singletop启动模式任务栈分析图](https://github.com/NateRobinson/Activity-Task-Final-Analysis/blob/master/imgs/2.png?raw=true)
 
**三、singleTask**

打开该模式下的Activity，系统会判断当前APP的整个Activity应用栈中存不存在此Activity，如果存在，那么就会将这个Activity置顶**【重点：同时会将刚才在此Activity之前的所有Activity都销毁】**，否则创建新的Activity。

![singletask启动模式任务栈分析图](https://github.com/NateRobinson/Activity-Task-Final-Analysis/blob/master/imgs/3.png?raw=true)

[**下面的分析摘自《Android群英传》**]另外，如果是其他的程序以singleTask模式来启动这个Activity，那么它将创建一个新的任务栈。不过这里有一点需要注意得是，如果启动的模式为SingleTask的Activity已经在后台的一个任务栈中了，那么启动后，后台的这个任务栈将一起被切换到前台，理解图如下：

![singletask启动模式任务栈分析图](https://github.com/NateRobinson/Activity-Task-Final-Analysis/blob/master/imgs/4.png?raw=true)

**四、singleInstance**

打开该模式下的Activity，系统会单独为此Activity创建一个Task，如果此时又有其他应用要打开此Activity，就不需要再创建了，这样两个应用就可以共享该Activity了。

![singleinstance启动模式任务栈分析图](https://github.com/NateRobinson/Activity-Task-Final-Analysis/blob/master/imgs/5.png?raw=true)

**五、一些注意点**

使用singletop和singleinstance这两种模式的Activity中，不能使用startActivityForResult()方法来启动另一个Activity,具体讲解见网上大神博客：<a href="http://blog.csdn.net/xiabo851205/article/details/8491267" target="_blank" >http://blog.csdn.net/xiabo851205/article/details/8491267</a>

## IntentFlag启动模式 ##

**一、Intent.FLAG_ACTIVITY_NEW_TASK**

我在代码中使用`intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);`来设置了Activity的启动模式，但是真实跑起来，发现并无效果，后来才知道此FLAG的一般应用场景：通常使用在从Service中启动Activity的场景，由于在Service中不存在Activity栈，所以使用该Flag来创建一个新的Activity栈：


![FLAG_ACTIVITY_NEW_TASK启动模式任务栈分析图](https://github.com/NateRobinson/Activity-Task-Final-Analysis/blob/master/imgs/6.png?raw=true)

**二、Intent.FLAG_ACTIVITY_SINGLE_TOP**

同`android:launchMode="singTop"`

**三、Intent.FLAG_ACTIVITY_CLEAR_TOP**

同`android:launchMode="singleTask"`

**四、Intent.FLAG_ACTIVITY_NO_HISTORY**

使用了该模式的Activity，当这个Activity启动了其他的Activity之后就会消失，不会存在任务栈之中。