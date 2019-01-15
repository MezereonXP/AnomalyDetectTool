# AnomalyDetectTool
[![BCH compliance](https://bettercodehub.com/edge/badge/MezereonXP/AnomalyDetectTool?branch=master)](https://bettercodehub.com/)

A tool of detecting anomaly points from data

### LOF-ICAD 算法的使用
You can use this tool like：

```java
    testData = FileTool.getData("data.json");
    LOFDetectTool lofDetectTool = new LOFDetectTool(200, 20);
    lofDetectTool.timeSeriesAnalyse(testData);
```

关于其算法细节可以查看我的文章，给出地址：
https://www.jianshu.com/p/ec40dd7b6b37


### 指数平滑模型的使用
You can use this tool like：
```java
    HoltWintersTool holtWintersTool = new HoltWintersTool(ALPHA, STEP, TIMES);
    holtWintersTool.timeSeriesAnalyse(testData);
```

关于其算法细节可以查看我的文章，给出地址：
https://www.jianshu.com/p/a2dbd47b3f1a


### Grubbs模型的使用
You can use this tool like：
```java
    GrubbsTool grubbsTool = new GrubbsTool (G_MAX);
    grubbsTool.timeSeriesAnalyse(testData);
```

### BF模型的使用
You can use this tool like：
```java
    BruteForceTool bruteForceTool = new BruteForceTool(10);
    bruteForceTool.timeSeriesAnalyse(data);
```

### Heuristic模型的使用
You can use this tool like：
```java
    HeuristicTool heuristicTool = new HeuristicTool(3);
    heuristicTool.timeSeriesAnalyse(testData);
```

### Isolation Tree模型的使用
You can use this tool like：
```java
    IsolaitonTool isolationTool = new IsolationTool();
    isolationTreeTool.timeSeriesAnalyse(testData);
```
    
### 结果显示工具的使用
You can use this tool like：
```java
    BruteForceTool bruteForceTool = new BruteForceTool(10);
    bruteForceTool.timeSeriesAnalyse(data);
    DisplayTool.showResult(bruteForceTool);
```