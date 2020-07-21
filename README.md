# CocHelper
CocHelper 旨在练习springboot的websocket技术，并不是一个产品。在练习技术的同时，也可以帮助群友的COC线上团更加方便。本项目在此开源，任何人都可以在不商用的前提下随意转载/修改本代码进行发布，且不需要经过作者同意。
CocHelper 将有可能实现的功能如下：
<br>
1.PL可以通过网页骰骰子，并获取骰子结果
<br>
2.所有参与游戏的玩家可以同时看到某个PL的投掷结果
<br>
3.输入骰子参数，“技能 技能值”或者“xdy+zda-c"的参数形式
<br>
4.进阶：可以建立PC，NPC，KP端和PL端的界面不同，帮助KP管理游戏。甚至支持多个游戏同时进行。
## version1.0
基本实现了上述功能，目前只支持一组游戏。且尚未实现KP端，目前如果要使用，KP端可以登录另一PL界面看到正在进行游戏的掷骰结果。
## version1.1
实现了可以新增人物卡的功能，pl可以建立一张人物卡加入服务器数据库，支持添加武器，暂不支持技能。
<br>
下版本可能研究如何基于websocket来让kp建立房间，pl通过房间号加入游戏，并支持多组游戏同时进行且不相互干扰
