# fight
SLG战斗模型
把SLG战斗按照某种规则分解成不同的Action，通过链型结构把各个Action 串联起来
遗产战斗中是有多个Action组成
每场战斗都有一个 IBoardBox对象，用于记录整场战斗信息
每Action都有一个 IBoard对象，用于该Action 战斗信息，各个Action之间的IBoard是相互独立的。




