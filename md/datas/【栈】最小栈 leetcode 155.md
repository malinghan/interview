## 题目要求
  最小栈
  
  设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
  
 -  push(x) -- 将元素 x 推入栈中。
 -  pop() -- 删除栈顶的元素。
 -  top() -- 获取栈顶元素。
 -  getMin() -- 检索栈中的最小元素。
  
## 题解
- 维护2个栈，一个栈存储正常的数据，一个栈用来实现获取最小元素
- pop时
  - min栈栈顶与data栈顶比较
    - 如果data栈顶元素大于min栈顶,min栈啥也不干
    - 如果data栈顶小于等于min栈顶,则一直弹出min栈，直到data栈顶大于等于min栈顶
- push时
  - min栈顶与pop元素比较，如果小于min栈栈顶，同时也push min栈
- getMin时
  - 取min栈栈顶元素  
### 代码
MinStack.java
### 分析


## 实践
