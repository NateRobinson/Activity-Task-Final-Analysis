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
 
打开该模式下的Activity，系统会判断当前任务栈的栈顶是不是此Activity，如果是则不创建新的Activity，否则创建新的Activity：
![singletop启动模式任务栈分析图](https://github.com/NateRobinson/Activity-Task-Final-Analysis/blob/master/imgs/2.png?raw=true)
 
