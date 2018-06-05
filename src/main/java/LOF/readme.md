数据的异常检测是一个难题, 面临许多挑战, 其中包括:
- 定义一个正常表现的范围是比较困难的, 异常值和正常值有时候边界并不是特别明显
- 某些恶意行为会伪装成正常值, 难以发现
- 大多数领域的正常行为只能在一段时间内有效, 对于未来的普适性并不是很高
- 对于异常的概念会由于应用的不同而不同
- 缺少带有标记的数据
- 数据的噪声可能有较大的影响

分析异常数据有多种方案, 包括:
- 基于分类的手段
- 基于最近邻算法
- 基于聚类
- 基于统计方法
- 基于信息理论
- 基于特征理论

我们这次着重介绍的是时序数据的异常检测, 我们来讨论讨论LOF方法, 并且给出相应的代码实现

### 1. LOF方法简介
> 该方法源自于论文**Conformalized density- and distance-based anomaly detection in time-series data**

LOF方法也就是**Local Outlier Factor**的缩写
首先我们需要引入一些符号:
**k**: 类似于KNN中的k, 代表第k个相邻的
**dist(a,b)**: 表示a和b之间的距离, 可以是几何距离, 也可以是曼哈顿距离等

LOF方法使用对于第k个邻居的反向平均距离(**Inverted average distance**)来进行一个密度的测量, 我们记作loc_dens
![密度的测量](https://upload-images.jianshu.io/upload_images/2601951-1691df13ef51485f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

同时我们给出其中的reach_dist
![reach_dist](https://upload-images.jianshu.io/upload_images/2601951-4620910dbe2c0713.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
其中NN_k(x)是x的第k个近邻, 而reach_dist是为了当x和o彼此靠近的时候减少统计波动

我们计算出密度之后, 就要利用该密度和其他近邻的点进行比较, 进而我们就可以计算出异常程度的分数, 记为LOF, 按如下方法进行计算:
![LOF](https://upload-images.jianshu.io/upload_images/2601951-83613c89decf80a7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

如果LOF越大则说明异常程度越高

### 2. LOF-ICAD方法
基于LOF方法, 论文给出了一种特征抽取的方法, 进一步提高了精度
这里直接给出算法的细节:
#### 输入:
- **窗口长度L**
- **合适的训练集合的大小T**
- **修正集合的大小C**
- **时间序列(x1, ... , x(T+C+L-1))**
- **测试的值x(T+C+L)**
- **密度测量NCM**

#### 输出(异常分数p, 从0到1):
步骤:
1. 将时间序列(x1, ... , x(T+C+L-1))映射到矩阵X, 其中矩阵X是L x (T+C)的矩阵
举个例子, 比如对于时间序列(1, 2, 3, 4, 5, 6), T=2, C=2, L=3
则生成X矩阵为
1, 2, 3, 4
2, 3, 4, 5
3, 4, 5, 6
2. 将矩阵X划分成训练矩阵X(T)(L x T大小)以及修正矩阵X(C)(L x C大小)
如上述例子, X(T)为:
1, 2
2, 3
3, 4
3. 计算NCM值(α1, ..., αC)对于修正矩阵X(C)的每一行(应该会有L行)
![NCM](https://upload-images.jianshu.io/upload_images/2601951-d1fed0fc5b5e63cf.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
具体的NCM值的计算也就是LOF的计算方式得到
4. 对序列最后的x(T+C+L-1)计算NCM值
![计算序列末尾的NCM](https://upload-images.jianshu.io/upload_images/2601951-b9e0baef2e943745.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
5. 计算异常程度分数p
![p的计算](https://upload-images.jianshu.io/upload_images/2601951-d4e8785fdba44866.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

如果p的分数特别高, 则异常程度相应地越高

### 3. 测试
![测试序列1](https://upload-images.jianshu.io/upload_images/2601951-8ceddc91c23b7aae.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
对于上图序列计算得到的窗口异常分数为0.007092198
我们给它加一个峰值
![测试序列2](https://upload-images.jianshu.io/upload_images/2601951-06a191efe2fd0313.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
得到的窗口异常分数为0.950354609








