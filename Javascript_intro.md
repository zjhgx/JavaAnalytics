# 什么是 JavaScript？

欢迎来到 MDN 的 JavaScript 初学者课程！本节将在一定高度俯瞰 JavaScript，回答一些诸如“它是什么？”和“它能做什么？”的问题 。并使你熟悉 JavaScript 的用途。

| 预备知识: | 计算机基础知识，初步理解 HTML 和 CSS 。                   |
| :-------- | --------------------------------------------------------- |
| 目标:     | 初步了解 JavaScript，包括一些概念、用途、嵌入网站的方法。 |

## 广义的定义

JavaScript 是一种脚本，一门编程语言，它可以在网页上实现复杂的功能，网页展现给你的不再是简单的静态信息，而是实时的内容更新，交互式的地图，2D/3D 动画，滚动播放的视频等等。JavaScript 怎能缺席。它是标准 Web 技术蛋糕的第三层，其中 [HTML ](https://developer.mozilla.org/en-US/docs/Learn/HTML)和 [CSS ](https://developer.mozilla.org/en-US/docs/Learn/CSS)我们已经在学习中心的其他部分进行了详细的讲解。

![img](https://mdn.mozillademos.org/files/13502/cake.png)

- [HTML](https://developer.mozilla.org/zh-CN/docs/Glossary/HTML)是一种标记语言，用来结构化我们的网页内容并赋予内容含义，例如定义段落、标题和数据表，或在页面中嵌入图片和视频。
- [CSS](https://developer.mozilla.org/zh-CN/docs/Glossary/CSS) 是一种样式规则语言，可将样式应用于 HTML 内容， 例如设置背景颜色和字体，在多个列中布局内容。
- [JavaScript](https://developer.mozilla.org/zh-CN/docs/Glossary/JavaScript) 是一种脚本语言，可以用来创建动态更新的内容，控制多媒体，制作图像动画，还有很多。（好吧，虽然它不是万能的，但可以通过简短的代码来实现神奇的功能。）

这三层依次建立，秩序井然。以文本标签(text label)的简单示例。首先用 HTML 将文本标记起来，从而赋予它结构和目的：

```html
<p id="p1">玩家1：小明</p>
```

玩家1：小明

然后我们可以为它加一点 CSS 让它更好看：

```css
p {
  font-family: sans-serif, '黑体';
  letter-spacing: 1px;
  text-transform: uppercase;
  text-align: center;
  border: 2px solid rgba(0, 0, 200, 0.6);
  background: rgba(0, 0, 200, 0.3);
  color: rgba(0, 0, 200, 0.6);
  box-shadow: 1px 1px 2px rgba(0, 0, 200, 0.4);
  border-radius: 10px;
  padding: 3px 10px;
  display: inline-block;
  cursor: pointer;
}
```

<iframe class="live-sample-frame hide-codepen-jsfiddle" frameborder="0" height="80" id="frame_Beautiful_name_label" src="https://mdn.mozillademos.org/zh-CN/docs/Learn/JavaScript/First_steps/What_is_JavaScript$samples/Beautiful_name_label?revision=1623705" width="100%" style="margin: 0px; padding: 0px; border: 0px; max-width: 100%; color: rgb(51, 51, 51); font-family: Arial, x-locale-body, sans-serif; font-size: 16px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: -0.04448px; orphans: 2; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); text-decoration-style: initial; text-decoration-color: initial;"></iframe>

最后，我们可以再加上一些 JavaScript 来实现动态行为：

```js
const para = document.querySelector('p');

para.addEventListener('click', updateName);

function updateName() {
  let name = prompt('输入一个新的名字：');
  para.textContent = '玩家1：' + name;
}
```

<iframe class="live-sample-frame hide-codepen-jsfiddle" frameborder="0" height="80" id="frame_Customizable_name_label" src="https://mdn.mozillademos.org/zh-CN/docs/Learn/JavaScript/First_steps/What_is_JavaScript$samples/Customizable_name_label?revision=1623705" width="100%" style="margin: 0px; padding: 0px; border: 0px; max-width: 100%; color: rgb(51, 51, 51); font-family: Arial, x-locale-body, sans-serif; font-size: 16px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: -0.04448px; orphans: 2; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); text-decoration-style: initial; text-decoration-color: initial;"></iframe>

尝试点击最后一个版本的文本标签，观察会发生什么（也可在 GitHub 上查看这个 demo 的 [源代码](https://github.com/roy-tian/learning-area/blob/master/javascript/introduction-to-js-1/what-is-js/javascript-label.html) 或 [在线运行](https://roy-tian.github.io/learning-area/javascript/introduction-to-js-1/what-is-js/javascript-label.html)。）

JavaScript 能做的远不止这些。让我们来仔细探索。

## 它到底可以做什么？

客户端（client-side）JavaScript 语言的核心包含一些普遍的编程特性，以让你可以做到如下的事情：

- 在变量中储存有用的值。比如上文的示例中，我们请求客户输入一个新名字，然后将其储存到 `name` 变量中。
- 操作一段文本（在编程中称为“字符串”（string））。上文的示例中，我们取字符串 "玩家1："，然后把它和 `name` 变量连结起来，创造出完整的文本标签，比如："玩家1：小明"。
- 运行代码以响应网页中发生的特定事件。上文的示例中，我们用一个 `click` 事件来检测按钮什么时候被点击，然后运行代码更新文本标签。
- 以及更多！

JavaScript 语言核心之上所构建的功能更令人兴奋。**应用程序接口（Application Programming Interfaces**（**API**））将为你的代码提供额外的超能力。

API 是已经建立好的一套代码组件，可以让开发者实现原本很难甚至无法实现的程序。就像现成的家具套件之于家居建设，用一些已经切好的木板组装一个书柜，显然比自己设计，寻找合适的木材，裁切至合适的尺寸和形状，找到正确尺寸的螺钉，再组装成书柜要简单得多。

API 通常分为两类。

![img](https://mdn.mozillademos.org/files/13508/browser.png)

**浏览器 API** 内建于 web 浏览器中，它们可以将数据从周边计算机环境中筛选出来，还可以做实用的复杂工作。例如：

- [`文档对象模型 API（DOM（Document Object Model）API）`](https://developer.mozilla.org/zh-CN/docs/Web/API/Document_Object_Model) 能通过创建、移除和修改 HTML，为页面动态应用新样式等手段来操作 HTML 和 CSS。比如当某个页面出现了一个弹窗，或者显示了一些新内容（像上文小 demo 中看到那样），这就是 DOM 在运行。
- [`地理位置 API（Geolocation API）`](https://developer.mozilla.org/zh-CN/docs/Web/API/Geolocation) 获取地理信息。这就是为什么 [谷歌地图](https://www.google.cn/maps) 可以找到你的位置，而且标示在地图上。
- [`画布（Canvas）`](https://developer.mozilla.org/zh-CN/docs/Web/API/Canvas_API) 和 [`WebGL`](https://developer.mozilla.org/zh-CN/docs/Web/API/WebGL_API) API 可以创建生动的 2D 和 3D 图像。人们正运用这些 web 技术制作令人惊叹的作品。参见 [Chrome Experiments](https://www.chromeexperiments.com/webgl) 以及 [webglsamples](http://webglsamples.org/)。
- 诸如 [`HTMLMediaElement`](https://developer.mozilla.org/zh-CN/docs/Web/API/HTMLMediaElement) 和 [`WebRTC`](https://developer.mozilla.org/zh-CN/docs/Web/API/WebRTC_API) 等 [影音类 API](https://developer.mozilla.org/en-US/Apps/Fundamentals/Audio_and_video_delivery) 让你可以利用多媒体做一些非常有趣的事，比如在网页中直接播放音乐和影片，或用自己的网络摄像头获取录像，然后在其他人的电脑上展示（试用简易版 [截图 demo](http://chrisdavidmills.github.io/snapshot/) 以理解这个概念）。

**注**: 上述很多演示都不能在旧浏览器中运行。推荐你在测试代码时使用诸如 Firefox, Chrome, Edge 或者 Opera 等现代浏览器。当代码即将交付生产环境时（也就是真实的客户即将使用真实的代码时），你还需要深入考虑 [跨平台测试](https://developer.mozilla.org/en-US/docs/Learn/Tools_and_testing/Cross_browser_testing)。

**第三方 API** 并没有默认嵌入浏览器中，一般要从网上取得它们的代码和信息。比如：

- [Twitter API](https://dev.twitter.com/overview/documentation)、[新浪微博 API](https://open.weibo.com/) 可以在网站上展示最新推文之类。
- [谷歌地图 API](https://developers.google.com/maps/)、[高德地图 API](https://lbs.amap.com/) 可以在网站嵌入定制的地图等等。

**注**：这些 API 较为高级，我们的课程中不会涉及，更多信息请参考：[客户端 web API 模块](https://developer.mozilla.org/zh-CN/docs/Learn/JavaScript/Client-side_web_APIs).

先稳住！你看到的只是冰山一角。你不可能学一天 JavaScript 就能构建下一个Facebook, 谷歌地图, 或者 Instagram。敬请「牢记初心，砥砺前行」。

现在我们实实在在的学习一些代码，与此同时，探索 JavaScript 运行时背后发生的事情。

让我们简单回顾一下，浏览器在读取一个网页时都发生什么（[CSS 如何工作](https://developer.mozilla.org/zh-CN/Learn/CSS/Introduction_to_CSS/How_CSS_works#How_does_CSS_actually_work) 一文中首次谈及）。浏览器在读取一个网页时，代码（HTML, CSS 和 JavaScript）将在一个运行环境（浏览器标签页）中得到执行。就像一间工厂，将原材料（代码）加工为一件产品（网页）。

![img](https://mdn.mozillademos.org/files/13504/execution.png)

在 HTML 和 CSS 集合组装成一个网页后，浏览器的 JavaScript 引擎将执行 JavaScript 代码。这保证了当 JavaScript 开始运行之前，网页的结构和样式已经就位。

这样很好，因为JavaScript 最普遍的用处是通过 DOM API（见上文）动态修改 HTML 和 CSS 来更新用户界面 （user interface）。如果 JavaScript 在 HTML 和 CSS 就位之前加载运行，就会引发错误。

### 浏览器安全



每个浏览器标签页就是其自身用来运行代码的独立容器（这些容器用专业术语称为“运行环境”）。大多数情况下，每个标签页中的代码完全独立运行，而且一个标签页中的代码不能直接影响另一个标签页（或者另一个网站）中的代码。这是一个好的安全措施，如果不这样，黑客就可以从其他网站盗取信息，等等。

**注**：以安全的方式在不同网站/标签页中传送代码和数据的方法是存在的，但这些技术较为高级，本课程不会涉及。

### JavaScript 运行次序



当浏览器执行到一段 JavaScript 代码时，通常会按从上往下的顺序执行这段代码。这意味着你需要注意代码书写的顺序。比如，我们回到第一个例子中的 JavaScript 代码：

```js
const para = document.querySelector('p');

para.addEventListener('click', updateName);

function updateName() {
  let name = prompt('输入一个新的名字：');
  para.textContent = '玩家1：' + name;
}
```

这里我们选定一个文本段落（第 1 行)，然后给它附上一个事件监听器（第 3 行），使得在它被点击时，`updateName()` 代码块（code block） （5 – 8 行）便会运行。`updateName()` （这类可以重复使用的代码块称为“函数”）向用户请求一个新名字，然后把这个名字插入到段落中以更新显示。

如果你互换了代码里最初两行的顺序，会导致问题。浏览器[开发者控制台](https://developer.mozilla.org/zh-CN/docs/Learn/JavaScript/First_steps/zh-CN/docs/Learn/Discover_browser_developer_tools)将返回一个错误： `TypeError: para is undefined`。这意味着 `para` 对象还不存在，所以我们不能为它增添一个事件监听器。

**注**：这是一个很常见的错误，在引用对象之前必须确保该对象已经存在。

### 解释代码 vs 编译代码



作为程序员，你或许听说过这两个术语：**解释（****interpret）**和 **编译(compile)**。在解释型语言中，代码自上而下运行，且实时返回运行结果。代码在由浏览器执行前，不需要将其转化为其他形式。代码将直接以文本格式（text form）被接收和处理。

相对的，编译型语言需要先将代码转化（编译）成另一种形式才能运行。比如 C/C++ 先被编译成汇编语言，然后才能由计算机运行。程序将以二进制的格式运行，这些二进制内容是由程序源代码产生的。

JavaScript 是轻量级解释型语言。浏览器接受到JavaScript代码，并以代码自身的文本格式运行它。技术上，几乎所有 JavaScript 转换器都运用了一种叫做即时编译（just-in-time compiling）的技术；当 JavaScript 源代码被执行时，它会被编译成二进制的格式，使代码运行速度更快。尽管如此，JavaScript 仍然是一门解释型语言，因为编译过程发生在代码运行中，而非之前。

两种类型的语言各有优势，这个问题我们暂且不谈

### 服务器端代码 vs 客户端代码

你或许还听说过**服务器端（server-side）**和 **客户端（client-side）**代码这两个术语，尤其是在web开发时。客户端代码是在用户的电脑上运行的代码，在浏览一个网页时，它的客户端代码就会被下载，然后由浏览器来运行并展示。这就是**客户端 JavaScript**。

而服务器端代码在服务器上运行，接着运行结果才由浏览器下载并展示出来。流行的服务器端 web 语言包括：PHP、Python、Ruby、ASP.NET 以及...... JavaScript！JavaScript 也可用作服务器端语言，比如现在流行的 Node.js 环境，你可以在我们的 [动态网页 - 服务器端编程](https://developer.mozilla.org/zh-CN/docs/Learn/Server-side) 主题中找到更多关于服务器端 JavaScript 的知识。

### 动态代码 vs 静态代码

“**动态**”一词既适用于客户端 JavaScript，又适用于描述服务器端语言。是指通过按需生成新内容来更新 web 页面 / 应用，使得不同环境下显示不同内容。服务器端代码会在服务器上动态生成新内容，例如从数据库中提取信息。而客户端 JavaScript 则在用户端浏览器中动态生成新内容，比如说创建一个新的 HTML 表格，用从服务器请求到的数据填充，然后在网页中向用户展示这个表格。两种情况的意义略有不同，但又有所关联，且两者（服务器端和客户端）经常协同作战。

没有动态更新内容的网页叫做“**静态**”页面**，**所显示的内容不会改变。

## 怎样向页面添加 JavaScript？

可以像添加 CSS 那样将 JavaScript 添加到 HTML 页面中。CSS 使用 [`<link>`](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/link) 元素链接外部样式表，使用 [`<style>`](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/style) 元素向 HTML 嵌入内部样式表，JavaScript 这里只需一个元素——[`<script>`](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/script)。我们来看看它是怎么工作的。

### 内部 JavaScript

1. 首先，下载示例文件 [apply-javascript.html](https://github.com/roy-tian/learning-area/blob/master/javascript/introduction-to-js-1/what-is-js/apply-javascript.html)。放在一个好记的文件夹里。

2. 分别在浏览器和文本编辑器中打开这个文件。你会看到这个 HTML 文件创建了一个简单的网页，其中有一个可点击按钮。

3. 然后转到文本编辑器，在 

   ```
   </body>
   ```

    

   标签结束前插入以下代码：

   ```html
   <script>
   
     // 在此编写 JavaScript 代码
   
   </script>
   ```

4. 下面，在<script>元素中添加一些 JavaScript 代码，这个页面就能做一些更有趣的事。在“/ /在此编写 JavaScript 代码”一行下方添加以下代码：

   ```js
   document.addEventListener("DOMContentLoaded", function() {
     function createParagraph() {
       let para = document.createElement('p');
       para.textContent = '你点击了这个按钮！';
       document.body.appendChild(para);
     }
   
     const buttons = document.querySelectorAll('button');
   
     for(let i = 0; i < buttons.length ; i++) {
       buttons[i].addEventListener('click', createParagraph);
     }
   });
   ```

5. 保存文件并刷新浏览器，然后你会发现，点击按钮文档下方将会添加一个新段落。

**注**: 如果示例不能正常工作，请依次检查所有步骤，并保证没有纰漏。原始文件是否以 `.html` 为扩展名保存到本地了？`` 标签前是否添加了 [``](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/script) 元素？JavaScript 代码输入是否正确 ？ **JavaScript 是区分大小写的，而且非常精确，所以你需要准确无误地输入所示的句法，否则可能会出错。**

**注**: 你可以在 GitHub 上查看此版本 [apply-internal.html](https://github.com/roy-tian/learning-area/blob/master/javascript/introduction-to-js-1/what-is-js/apply-javascript-internal.html) ([也可在线查看](https://roy-tian.github.io/learning-area/javascript/introduction-to-js-1/what-is-js/apply-javascript-internal.html))。

### 外部 JavaScript

这很不错，但是能不能把 JavaScript 代码放置在一个外部文件中呢？现在我们来研究一下。

1. 首先，在刚才的 HTML 文件所在的目录下创建一个名为 `script.js` 的新文件。请确保扩展名为 `.js`，只有这样才能被识别为 JavaScript 代码。

2. 将<script>元素替换为：

   ```html
   <script src="script.js" async></script>
   ```

3. 在script.js文件中，添加下面的脚本：

   ```js
   function createParagraph() {
     let para = document.createElement('p');
     para.textContent = '你点击了这个按钮！';
     document.body.appendChild(para);
   }
   
   const buttons = document.querySelectorAll('button');
   
   for(let i = 0; i < buttons.length ; i++) {
     buttons[i].addEventListener('click', createParagraph);
   } 
   ```

4. 保存并刷新浏览器，你会发现二者完全一样。但是现在我们把 JavaScript 写进了一个外部文件。这样做一般会使代码更加有序，更易于复用，且没有了脚本的混合，HTML 也会更加易读，因此这是个好的习惯。

**注**：你可以在 GitHub 上查看这个版本 [apply-external.html](https://github.com/roy-tian/learning-area/blob/master/javascript/introduction-to-js-1/what-is-js/apply-javascript-external.html) 以及 [script.js](https://github.com/roy-tian/learning-area/blob/master/javascript/introduction-to-js-1/what-is-js/script.js) ([也可在线查看](https://roy-tian.github.io/learning-area/javascript/introduction-to-js-1/what-is-js/apply-javascript-external.html)).

### 内联 JavaScript 处理器

注意，有时候你会遇到在 HTML 中存在着一丝真实的 JavaScript 代码。它或许看上去像这样：

```js
function createParagraph() {
  const para = document.createElement('p');
  para.textContent = '你点击了这个按钮！';
  document.body.appendChild(para);
}
<button onclick="createParagraph()">点我呀</button>
```

你可以在下面尝试这个版本的 demo。

​	

这个 demo 与之前的两个功能完全一致，只是在 [`<button>`](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/button) 元素中包含了一个内联的 `onclick` 处理器，使得函数在按钮被按下时运行。

**然而请不要这样做。** 这将使 JavaScript 污染到 HTML，而且效率低下。对于每个需要应用 JavaScript 的按钮，你都得手动添加 `onclick="createParagraph()"` 属性。

可以使用纯 JavaScript 结构来通过一个指令选取所有按钮。下文的这段代码即实现了这一目的：

```js
const buttons = document.querySelectorAll('button');

for(let i = 0; i < buttons.length ; i++) {
  buttons[i].addEventListener('click', createParagraph);
}
```

这样写乍看去比 `onclick` 属性要长一些，但是这样写会对页面上所有按钮生效，无论多少个，或添加或删除，完全无需修改 JavaScript 代码。

> **注**：请尝试修改 `apply-javascript.html` 以添加更多按钮。刷新后可发现按下任一按钮时都会创建一个段落。很高效吧。

### 脚本调用策略

要让脚本调用的时机符合预期，需要解决一系列的问题。这里看似简单，实际大有文章。最常见的问题就是：HTML 元素是按其在页面中出现的次序调用的，如果用 JavaScript 来管理页面上的元素（更精确的说法是使用 [文档对象模型](https://developer.mozilla.org/zh-CN/docs/Web/API/Document_Object_Model) DOM），若 JavaScript 加载于欲操作的 HTML 元素之前，则代码将出错。

在上文的“内部”、“外部”示例中，JavaScript 调用于文档头处，解析 HTML 文档体之前。这样做是有隐患的，需要使用一些结构来避免错误发生。

“内部”示例使用了以下结构：

```js
document.addEventListener("DOMContentLoaded", function() {
  . . .
});
```

这是一个事件监听器，它监听浏览器的 "`DOMContentLoaded`" 事件，即 HTML 文档体加载、解释完毕事件。事件触发时将调用 " `. . .`" 处的代码，从而避免了错误发生（[事件](https://developer.mozilla.org/zh-CN/docs/Learn/JavaScript/Building_blocks/Events) 的概念稍后学习）。

“外部”示例中使用了 JavaScript 的一项现代技术（`async` “异步”属性）来解决这一问题，它告知浏览器在遇到 `` 元素时不要中断后续 HTML 内容的加载。

```html
<script src="script.js" async></script>
```

上述情况下，脚本和 HTML 将一并加载，代码将顺利运行。

**注**：“外部”示例中 `async` 属性可以解决调用顺序问题，因此无需使用 `DOMContentLoaded` 事件。而 `async` 只能用于外部脚本，因此不适用于“内部”示例。

解决此问题的旧方法是：把脚本元素放在文档体的底端（`` 标签之前，与之相邻），这样脚本就可以在 HTML 解析完毕后加载了。此方案（以及上述的 `DOMContentLoaded` 方案）的问题是：只有在所有 HTML DOM 加载完成后才开始脚本的加载/解析过程。对于有大量 JavaScript 代码的大型网站，可能会带来显著的性能损耗。这也是 `async` 属性诞生的初衷。

#### `async` 和 `defer`

上述的脚本阻塞问题实际有两种解决方案 —— `async` 和 `defer`。我们来依次讲解。

浏览器遇到 `async` 脚本时不会阻塞页面渲染，而是直接下载然后运行。这样脚本的运行次序就无法控制，只是脚本不会阻止剩余页面的显示。当页面的脚本之间彼此独立，且不依赖于本页面的其它任何脚本时，`async` 是最理想的选择。

比如，如果你的页面要加载以下三个脚本：

```html
<script async src="js/vendor/jquery.js"></script>

<script async src="js/script2.js"></script>

<script async src="js/script3.js"></script>
```

三者的调用顺序是不确定的。`jquery.js` 可能在 `script2` 和 `script3` 之前或之后调用，如果这样，后两个脚本中依赖 `jquery` 的函数将产生错误，因为脚本运行时 `jquery` 尚未加载。

解决这一问题可使用 `defer` 属性，脚本将按照在页面中出现的顺序加载和运行：

```html
<script defer src="js/vendor/jquery.js"></script>

<script defer src="js/script2.js"></script>

<script defer src="js/script3.js"></script>
```

添加 `defer` 属性的脚本将按照在页面中出现的顺序加载，因此第二个示例可确保 `jquery.js` 必定加载于 `script2.js` 和 `script3.js` 之前，同时 `script2.js` 必定加载于 `script3.js` 之前。

脚本调用策略小结：

- 如果脚本无需等待页面解析，且无依赖独立运行，那么应使用 `async`。
- 如果脚本无需等待页面解析，且依赖于其它脚本，调用这些脚本时应使用 `defer`，将关联的脚本按所需顺序置于 HTML 中。



## 注释

就像 HTML 和 CSS，JavaScript 代码中也可以添加注释，浏览器会忽略它们，注释只是为你的同事（还有你，如果半年后再看自己写的代码你会说，这是什么垃圾玩意。）提供关于代码如何工作的指引。注释非常有用，而且应该经常使用，尤其在大型应用中。注释分为两类：

- 在双斜杠后添加单行注释，比如：

  ```js
  // 我是一条注释
  ```

- 在/*和*/之间添加多行注释，比如：

  ```js
  /*
    我也是
    一条注释
  */
  ```

比如说，我们可以这样为上一个 demo 添加注释：

```js
// 函数：创建一个新的段落并添加至 HTML body 底部。
function createParagraph() {
  let para = document.createElement('p');
  para.textContent = '你点了这个按钮！';
  document.body.appendChild(para);
}

/*
  1. 取得页面上所有按钮的引用并将它们置于一个数组中。
  2. 通过一个循环为每个按钮添加一个点击事件的监听器。
  当按钮被点击时，调用 createParagraph() 函数。
*/

const buttons = document.querySelectorAll('button');

for (let i = 0; i < buttons.length; i++) {
  buttons[i].addEventListener('click', createParagraph);
}
```

## 小结

恭喜你，迈出了探索 JavaScript 世界的第一步。我们从理论开始，介绍为什么要使用 JavaScript，以及用它能做什么事情。过程中穿插了一些代码示例并讲解了 JavaScript 如何与网站中其他代码适配，等等。

现在 JavaScript 或许还有些令人生畏，但不用担心。在课程中我们会循序渐进。下一节将[ 全力投入实战](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Introduction_to_JavaScript_1/A_first_splash)，让你专注其中，并建立自己的 JavaScript 示例。





# 如何存储你需要的信息 — 变量

一个变量，就是一个用于存放数值的容器。这个数值可能是一个用于累加计算的数字，或者是一个句子中的字符串。变量的独特之处在于它存放的数值是可以改变的。让我们看一个简单的例子:

```html
<button>Press me</button>
const button = document.querySelector('button');

button.onclick = function() {
  let name = prompt('What is your name?');
  alert('Hello ' + name + ', nice to see you!');
}
```



变量的另一个特性就是它们能够存储任何的东西 -- 不只是字符串和数字。变量可以存储更复杂的数据，甚至是函数。你将在后续的内容中体验到这些用法。

**我们说，变量是用来存储数值的，那么有一个重要的概念需要区分。变量不是数值本身，它们仅仅是一个用于存储数值的容器。你可以把变量想象成一个个用来装东西的纸箱子。**

![img](https://mdn.mozillademos.org/files/13506/boxes.png)



## 声明变量

要想使用变量，你需要做的第一步就是创建它 -- 更准确的说，是声明一个变量。声明一个变量的语法是在 `var` 或 `let` 关键字之后加上这个变量的名字：

```js
let myName;
let myAge;
```

在这里我们声明了两个变量 `myName` 和 `myAge`. 那么现在尝试输入这些代码到你的浏览器终端或者下面提供的JavaScript终端 (你也可以在另一个独立的标签页或窗口 [open this consol](https://mdn.github.io/learning-area/javascript/introduction-to-js-1/variables/index.html) ). 此外，你也可以多声明几个变量.

> **提示**: 在JavaScript中，所有代码指令都会以分号结尾 (`;`) — 如果忘记加分号，你的单行代码可能执行正常，但是在多行代码在一起的时候就可能出错。所以，最好是养成主动以分号作为代码结尾的习惯。

你可以通过使用变量的方式来验证这个变量的数值是否在执行环境中已经存在。例如，

```js
myName;
myAge;
```

以上这两个变量并没有数值，他们是空的容器。当你输入变量名并回车后，你会得到一个`undefined`的返回值。如果他们并不存在的话，那你就会得到一个报错信息。不信的话，可以尝试输入:

```js
scoobyDoo;
```

> **提示**: 千万不要把两个概念弄混淆了，“一个变量存在，但是没有数值”和“一个变量并不存在” — 他们完全是两回事 — 在前面你看到的盒子的类比中，不存在意味着没有可以存放变量的“盒子”。没有定义的值意味着有一个“盒子”，但是它里面没有任何值。

## 初始化变量

一旦你定义了一个变量，你就能够初始化它. 方法如下，在变量名之后跟上一个“=”，然后是数值:

```js
myName = 'Chris';
myAge = 37;
```

现在回到控制台并且尝试输入这几行。每输入一条你都应该确认一下控制台输出的变量是不是你刚赋的值。 同样，你可以通过在控制台中输入变量的名称来返回该变量的值 — 再次尝试下这些:

```js
myName;
myAge;
```

你可以像这样在声明变量的时候给变量初始化:

```js
let myName = 'Chris';
```

这可能是大多数时间你都会使用的方式， 因为它要比在单独的两行上做两次操作要快。

**Note**: 如果你写一个声明和初始化变量的多行JavaScript代码的程序，你可以在初始化变量之后再实际声明它，并且它仍然可以工作。这是因为变量的声明通常在其余的代码执行之前完成。这叫做**顶置**—阅读[var hoisting](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/var#var_hoisting)来了解更多细节。

## var 与 let 的区别

此时，您可能会想：“为什么我们需要两个关键字来定义变量?”，“为什么有 `var` 和 `let` 呢？"。

原因是有些历史性的。 回到最初创建 JavaScript 时，是只有 `var` 的。 在大多数情况下，这种方法可以接受， 但有时在工作方式上会有一些问题——它的设计会令人困惑或令人讨厌 。 因此，`let` 是在现代版本中的 JavaScript 创建的一个新的关键字，用于创建与 `var` 工作方式有些不同的变量，解决了过程中的问题。

下面解释几个简单的差异。 我们现在不会讨论所有的差异，但是当您了解有关 JavaScript 的更多信息时，您将开始发现它们（如果您现在真的想要阅读它们，请随时查看我们的[参考页面](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/let)）。

首先，如果你编写一个声明并初始化变量的多行 JavaScript 程序，你可以在初始化一个变量之后用 `var` 声明它，它仍然可以工作。 例如：

```js
myName = 'Chris';

function logName() {
  console.log(myName);
}

logName();

var myName;
```

> Note: 只有在 web 文档中运行多行 JavaScript 时才会有这种效果，当在 JavaScript 控制台中键入单独的行，这将不起作用。
>

这是由于变量的**提升**，更多细节请阅读[变量提升](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Statements/var#变量提升)。

但提升操作不再适用于 `let` 。如果将上面例子中的 `var` 替换成 `let` 将不起作用并引起一个错误。 这是一件好事——因为初始化后再声明一个变量会使代码变得混乱和难以理解。

其次，当你使用 `var` 时，可以根据需要多次声明相同名称的变量，但是 `let` 不能。 以下将有效：

```js
var myName = 'Chris';
var myName = 'Bob';
```

但是以下内容会在第二行引发错误：

```js
let myName = 'Chris';
let myName = 'Bob';
```

你必须这样做：

```js
let myName = 'Chris';
myName = 'Bob';
```

同样，这是一个明智的语言决定。没有理由重新声明变量——这只会让事情变得更加混乱。

出于这些以及其他原因，我们建议您在代码中尽可能多地使用 `let`，而不是 `var`。因为没有理由使用 `var`，除非您需要用代码支持旧版本的 Internet Explorer (它直到第 11 版才支持 `let` ，现代的 Windows Edge 浏览器支持的很好)。

>  **Note:** 我们目前正在更新课程以使用let而不是var。 忍耐一下！

## 更新变量

一旦变量赋值，您可以通过简单地给它一个不同的值来更新它。试试在你的控制台中输入下面几行:

```js
myName = 'Bob';
myAge = 40;
```

### 关于变量命名的规则

你可以给你的变量赋任何你喜欢的名字，但有一些限制。 一般你应当坚持使用拉丁字符(0-9,a-z,A-Z)和下划线字符。

- 你不应当使用规则之外的其他字符，因为它们可能引发错误，或对国际用户来说难以理解。
- 变量名不要以下划线开头—— 以下划线开头的被某些JavaScript设计为特殊的含义，因此可能让人迷惑。
- 变量名不要以数字开头。这种行为是不被允许的，并且将引发一个错误。
- 一个可靠的命名约定叫做 ["小写驼峰命名法"](https://en.wikipedia.org/wiki/CamelCase#Variations_and_synonyms)，用来将多个单词组在一起，小写整个命名的第一个字母然后大写剩下单词的首字符。我们已经在文章中使用了这种命名方法。
- 让变量名直观，它们描述了所包含的数据。不要只使用单一的字母/数字，或者长句。
- 变量名大小写敏感——因此`myage`与`myAge`是2个不同的变量。
- 最后也是最重要的一点—— 你应当避免使用JavaScript的保留字给变量命名。保留字，即是组成JavaScript的实际语法的单词！因此诸如 `var`, `function`, `let和` `for`等，都不能被作为变量名使用。浏览器将把它们识别为不同的代码项，因此你将得到错误。

**Note**: 你能从[词汇语法—关键字](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Lexical_grammar#Keywords)找到一个相当完整的保留关键字列表来避免使用关键字当作变量。

好的命名示例:

```html
age
myAge
init
initialColor
finalOutputValue
audio1
audio2
```

错误与差的命名示例:

```html
1
a
_12
myage
MYAGE
var
Document
skjfndskjfnbdskjfb
thisisareallylongstupidvariablenameman
```

现在尝试创建更多的变量，请将上面的指导铭记于心。

## 变量类型

可以为变量设置不同的数据类型。本节我们将对其进行简短的介绍，在以后的文章中，你会更详细地了解它们。

到目前为止我们已经认识了前2个，但是还有其他的。

### Number

你可以在变量中存储数字，不论这些数字是像30（也叫整数）这样，或者像2.456这样的小数（也叫做浮点数）。与其他编程语言不同，在 JavaScript 中你不需要声明一个变量的类型。当你给一个变量数字赋值时，不需要用引号括起来。 

```js
let myAge = 17;
```

### String

字符串是文本的一部分。当你给一个变量赋值为字符串时，你需要用单引号或者双引号把值给包起来，否则JavaScript将会把这个字符串值理解成别的变量名。

```js
let dolphinGoodbye = 'So long and thanks for all the fish';
```

### Boolean

Boolean 的值有2种：true或false。它们通常被用于在适当的代码之后，测试条件是否成立。举个例子，一个简单的示例如下： 

```js
let iAmAlive = true;
```

然而实际上通常是以下用法：

```js
let test = 6 < 3;
```

这是使用“小于”操作符（<）来测试6小于3。正如你所料的，将会返回`false`，因为6并不小于3！在这个课程中，以后你将会学到许多有关操作符的知识。

### Array

数组是一个单个对象，其中包含很多值，方括号括起来，并用逗号分隔。尝试在您的控制台输入以下行:

```js
let myNameArray = ['Chris', 'Bob', 'Jim'];
let myNumberArray = [10,15,40];
```

当数组被定义后，您可以使用如下所示的语法来访问各自的值，例如下行:

```js
myNameArray[0]; // should return 'Chris'
myNumberArray[2]; // should return 40
```

此处的方括号包含一个索引值，该值指定要返回的值的位置。 您可能已经注意到，计算机从0开始计数，而不是像我们人类那样的1。

在以后的文章，你将更多地了解数组。

### Object

在编程中，对象是现实生活中的模型的一种代码结构。您可以有一个简单的对象，代表一个停车场，并包含有关其宽度和长度的信息，或者您可以有一个代表一个人的对象，并包含有关他们的名字，身高，体重，他们说什么语言，如何说 你好，他们，等等。

尝试在您的控制台输入以下行:

```js
let dog = { name : 'Spot', breed : 'Dalmatian' };
```

要检索存储在对象中的信息，可以使用以下语法:

```js
dog.name
```

我们现在不会看对象了 - 您可以在将来的模块中了解更多关于这些对象的信息.

## 动态类型

JavaScript是一种“动态类型语言”，这意味着不同于其他一些语言(译者注：如C、JAVA)，您不需要指定变量将包含什么数据类型（例如number或string）

例如，如果你声明一个变量并给它一个带引号的值，浏览器就会知道它是一个字符串：

```js
let myString = 'Hello';
```

即使它包含数字，但它仍然是一个字符串，所以要小心：

```js
let myNumber = '500'; // oops, this is still a string
typeof myNumber;
myNumber = 500; // much better — now this is a number
typeof myNumber
```

尝试依次将上述代码输入您的控制台，看看结果是什么（无须输入//之后的注释）。 我们使用了一个名为`typeof`的特殊的操作符 ——它会返回所传递给它的变量的数据类型。 第一次在上面的代码中调用它，它应该返回string，因为此时myNumber变量包含一个字符串'500'。 看看它第二次将返回什么。

## 总结

到目前为止，您应该了解了适量的JavaScript以及如何创建它们。 在下一篇文章中，我们将更详细地关注数字，了解如何在JavaScript中使用基础数学。



# JavaScript中的基础数学 — 数字和操作符



## 人人都爱数学

好吧，可能不是。有些人喜欢数学，有些人可能从在学校必须学习乘法表和长除法时就讨厌数学，还有人介于两者之间。但我们都不能否认，数学是生活的基本组成部分，我们离不了它。尤其如此，当我们学习编写 JavaScript 程序（或任何其他语言），我们所做的很多事情都依赖于处理数值数据，计算新值等。你将不会惊讶地认识到 JavaScript 有一套可用的全功能的数学功能。

本文仅讨论您现在需要了解的基本部分。

### 数字类型

在编程中，即使是人人熟知的最普遍的十进制数，也比你想象的要复杂的多。我们使用不同的术语来描述不同类型的十进制数，例如：

- **整数** 就是整数,例如 10, 400, 或者 -5.
- **浮点数** (浮点) 有小数点或小数位，例如 12.5，和 56.7786543。
- **双精度**双精度是一种特定类型的浮点数，它们具有比标准浮点数更高的精度（这意味着它们精确到更大的小数位数）。

我们甚至有不同类型的数字系统！ 十进制是基数10（意味着它在每列使用0-9），但是我们也有这样的东西：

- **二进制** — 计算机的最基础语言; 0s and 1s
- **八进制** — 基数8，每列使用0-7
- **十六进制** — 基数16，每列使用0-9，然后使用a-f。 在CSS中设置颜色时，可能会遇到这些数字。

在你开始担心你的大脑混乱之前，先停下来吧！ 一开始，我们将在本课程中坚持使用十进制数; 你很少会遇到需要开始考虑其他类型的情况，如果有的话。

第二个好消息是，与其他一些编程语言不同，JavaScript只有一个数据类型-- 整数和浮点数，您猜对了，[`Number`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Number)。 这意味着，你在JavaScript中处理的任何类型的数字，都以完全相同的方式处理它们。

### 这是我们的全部数字

让我们快点玩一些数字，以重新定义我们所需要的基本语法。 在您的[开发工具JavaScript控制台](https://developer.mozilla.org/zh-CN/docs/Learn/Discover_browser_developer_tools)中输入下面列出的命令。

**[在新窗口中打开](https://mdn.github.io/learning-area/javascript/introduction-to-js-1/variables/)**

1. 首先，我们先声明一对变量，并分别用一个整数和一个浮点数来初始化它们，然后再输入变量名来检查是否正确：

   ```js
   let myInt = 5;
   let myFloat = 6.667;
   myInt;
   myFloat;
   ```

2. 数值键入不带引号 —— 在继续之前尝试声明和初始化更多包含数字的变量。

3. 现在我们来看看我们的原始变量是否是相同的数据类型。 在JavaScript中有一个称为

   `typeof`的运算符。 输入如下所示的两行：

   ```js
typeof myInt;
   typeof myFloat;
   ```
```
   
   在这两种情况下，都应该返回"number"—— 这使得事情变得更简单，因为若是不同的数字具有不同的数据类型，那么我们还须以不同的方式处理它们。呦！

## 算术运算符

算术运算符是我们用来做和的基本运算符：

| 运算符 | 名称                 | 作用                                                         | 示例                                                |
| :----- | :------------------- | :----------------------------------------------------------- | :-------------------------------------------------- |
| `+`    | 加法                 | 两个数相加。                                                 | `6 + 9`                                             |
| `-`    | 减法                 | 从左边减去右边的数。                                         | `20 - 15`                                           |
| `*`    | 乘法                 | 两个数相乘。                                                 | `3 * 7`                                             |
| `/`    | 除法                 | 用右边的数除左边的数                                         | `10 / 5`                                            |
| `%`    | 求余(有时候也叫取模) | 在你将左边的数分成同右边数字相同的若干整数部分后，返回剩下的余数 | `8 % 3` (返回 2，8除以3的倍数，余下2 。)            |
| `**`   | 幂                   | 取底数的指数次方，即指数所指定的底数相乘。它在EcmaScript 2016 中首次引入。 | `5 ** 5` (返回 3125，相当于 `5 * 5 * 5 * 5 * 5` 。) |

> **Note**: 你以后有时候会看到一些数字涉及求和被称为 操作数([operands](https://developer.mozilla.org/en-US/docs/Glossary/Operand))。

> Note: 有时你可能会看到使用较旧的 [`Math.pow()`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Math/pow) 方法表达的指数，该方法的工作方式非常相似。 例如，在 `Math.pow(7, 3)` 中，`7` 是基数，`3` 是指数，因此表达式的结果是 `343`。 `Math.pow(7, 3)` 相当于 `7 ** 3`。
>

我们可能不需要教你如何做基础数学，但我们想测试你对所涉及的语法的理解。 尝试将下面的示例输入到[开发者工具JavaScript控制台](https://developer.mozilla.org/zh-CN/docs/Learn/Discover_browser_developer_tools)中。

1. 首先尝试输入一些简单的例子，例如

   ```js
   10 + 7
   9 * 8
   60 % 3
```

2. 您还可以尝试在变量中声明和初始化一些数字，并尝试使用总和中的数字 - 变量的行为与其持有的值完全一样。 例如：

   ```js
   let num1 = 10;
   let num2 = 50;
   9 * num1;
   num1 ** 3;
   num2 / num1;
   ```

3. 最后在本节中，尝试输入一些更复杂的表达式，如：

   ```js
   5 + 10 * 3;
   num2 % 9 * num1;
   num2 + num1 / 8 + 2;
   ```

这最后一个算法和中的一些可能不会给你期望的结果; 下面的部分可能会给出答案为什么。

### 运算符优先级

我们来看看上面的最后一个例子，假设num2的值为50，num1的值为10（如上所述）：

```js
num2 + num1 / 8 + 2;
```

一般人，你会将它看作“50加10等于60”，然后“8加2等于10”，最后“60除以10等于6”。

但浏览器的“10除以8等于1.25”，那么“50加1.25加2等于53.25”。

这是因为**运算符优先级** —— 一些运算符将在计算总和的结果（在编程中称为表达式）时被应用于其他运算符。 JavaScript中的运算符优先级与学校的数学课程相同 - 乘法和除法总是先完成，然后加法和减法（总和总是从左到右进行评估）。

如果要覆盖运算符优先级，可以首先对要显式处理的部分进行括号。 所以要得到6的结果，我们可以这样做：

```js
(num2 + num1) / (8 + 2);
```

尝试看看。

> **Note**: 注意：可以在[表达式和运算符](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Guide/Expressions_and_Operators#运算符优先级)中找到所有JavaScript运算符的完整列表及其优先级。

## 递增和递减运算符

有时候，您需要反复添加或从数字变量值中减去一个。 这可以方便地使用增量（`++`）和递减（ `--` ）运算符来完成。 我们在JavaScript 初体验文章的“猜数字”游戏中使用了++，当我们添加1到我们的guessCount变量来跟踪用户在每次转动之后剩下的猜测时。

```js
guessCount++;
```

**Note**: 它们最常用于 [循环](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Guide/Loops_and_iteration) 中，您将在以后的课程中了解。 例如，假设您想循环查看价格表，并为每个价格增加销售税。 您可以使用循环依次查看每个值，并在每种情况下进行必要的计算，以添加销售税。 当需要时，增量器用于移动到下一个值。 我们实际上提供了一个简单的例子，显示了如何完成 ——  [在线查看效果](https://mdn.github.io/learning-area/javascript/introduction-to-js-1/maths/loop.html)，并 [查看源代码](https://github.com/mdn/learning-area/blob/master/javascript/introduction-to-js-1/maths/loop.html)，看看是否可以发现增量器！ 我们稍后将会详细介绍循环。

我们来试试看你们的控制台。 首先，请注意，您不能将这些直接应用于一个数字，这可能看起来很奇怪，但是我们为变量赋值一个新的更新值，而不是对该值进行操作。 以下将返回错误：

```js
3++;
```

所以，你只能增加一个现有的变量。 尝试这个：

```js
let num1 = 4;
num1++;
```

好的，第二个奇怪的东西！ 执行此操作时，您会看到返回值为4，这是因为浏览器返回当前值，然后增加变量。 如果您再次返回变量值，则可以看到它已经递增：

```js
num1;
```

递减 `--` 同样如此，尝试以下操作：

```js
let num2 = 6;
num2--;
num2
```

> **Note**: 您可以使浏览器以其他方式进行操作 - 递增/递减变量，然后返回值 - 将操作符放在变量的开头，而不是结束。 再次尝试上面的例子，但这次使用 `++num1` 和 `--num2`。

## 赋值运算符

赋值运算符是向变量分配值的运算符。 我们已经使用了最基本的一个很多次了：`=`， 它只是将右边的值赋给左边的变量 ，即：

```js
let x = 3; // x 的值是 3
let y = 4; // y 的值是 4
x = y; // x 和 y 有相同的值, 4
```

但是还有一些更复杂的类型，它们提供了有用的快捷方式，可以使您的代码更加清洁和高效。 最常见的如下：

| 运算符 | 名称     | 作用                                           | 示例             | 等价于              |
| :----- | :------- | :--------------------------------------------- | :--------------- | :------------------ |
| `+=`   | 加法赋值 | 右边的数值加上左边的变量，然后再返回新的变量。 | `x = 3;x += 4;`  | `x = 3;x = x + 4;`  |
| `-=`   | 减法赋值 | 左边的变量减去右边的数值，然后再返回新的变量。 | `x = 6;x -= 3;`  | `x = 6;x = x - 3;`  |
| `*=`   | 乘法赋值 | 左边的变量乘以右边的数值，然后再返回新的变量。 | `x = 2;x *= 3;`  | `x = 2;x = x * 3;`  |
| `/=`   | 除法赋值 | 左边的变量除以右边的数值，然后再返回新的变量。 | `x = 10;x /= 5;` | `x = 10;x = x / 5;` |

尝试在你的控制台中输入上面的一些示例，以了解它们的工作原理。 在每种情况下，你是否可以猜出在输入第二行之前的值。

请注意，您可以愉快地使用每个表达式右侧的其他变量，例如：

```js
let x = 3; // x 包含值 3
let y = 4; // y 包含值 4
x *= y; // x 现在包含值 12
```

> **Note**: 虽然有很多可用的[赋值运算符](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Guide/Expressions_and_Operators#Assignment_operators), 但是这些是你现在应该学习的基本的一类。

## 主动学习：调整画布框的大小

在这个练习中，我们将让你填写一些数字和操作符来操纵一个框的大小。 该框使用称为[Canvas API](https://developer.mozilla.org/zh-CN/docs/Web/API/Canvas_API)的浏览器API绘制。 没有必要担心这是如何工作的 - 现在只关注数学。 盒子的宽度和高度（以像素为单位）由变量 `x` 和 `y` 定义，变量 `x` 和 `y` 最初都被赋值为50。











# 函数-可复用代码块

在JavaScript中另一个基本概念是**函数**, 它允许你在一个代码块中存储一段用于处理单任务的代码，然后在任何你需要的时候用一个简短的命令来调用，而不是把相同的代码写很多次。在本文中，我们将探索函数的基本概念，如基本语法、如何定义和调用、范围和参数。

| 前提条件: | 基本的电脑知识，对HTML与CSS有基本的了解,及已阅读： [JavaScript first steps](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/First_steps)（JS的入门）。 |
| :-------- | ------------------------------------------------------------ |
| 目标:     | 了解 Javascript 函数背后的基本概念。                         |

## 我能在哪找到函数?

在 JavaScript中, 你将发现函数无处不在 。事实上, 到目前为止，我们一直在使用函数，只是我们还没很好的讨论它们。然而现在是时候了，让我们开始聊聊函数，并探索它们的语法。

几乎任何时候，只要你使用一个带有一对圆括号（）的JavaScript结构，并且你不是在使用一个常见的比如for for循环，while或do…while循环，或者if语句这样的内置语言结构时，那么您就正在使用函数。

## 浏览器内置函数

在这套课程中我们已经使用了很多浏览器内置函数，当我们操作一个字符串的时候，例如：

```js
var myText = 'I am a string';
var newString = myText.replace('string', 'sausage');
console.log(newString);
// the replace() string function takes a string,
// replaces one substring with another, and returns
// a new string with the replacement made
```

或者当我们操作一个数组的时候：

```js
var myArray = ['I', 'love', 'chocolate', 'frogs'];
var madeAString = myArray.join(' ');
console.log(madeAString);
// the join() function takes an array, joins
// all the array items together into a single
// string, and returns this new string
```

或者当我们生成一个随机数时：

```js
var myNumber = Math.random()
// the random() function generates a random
// number between 0 and 1, and returns that
// number
```

> 提示：如果需要，你可以随意将这些代码输入浏览器控制台以便于你熟悉其功能。

JavaScript有许多内置的函数，可以让您做很多有用的事情，而无需自己编写所有的代码。事实上, 许多你调用（运行或者执行的专业词语）浏览器内置函数时调用的代码并不是使用JavaScript来编写——大多数调用浏览器后台的函数的代码，是使用像C++这样更低级的系统语言编写的，而不是像JavaScript这样的web编程语言。

请记住，**这些内置浏览器函数不是核心JavaScript语言的一部分——被定义为浏览器API的一部分，它建立在默认语言之上，以提供更多的功能（请参阅本课程的早期部分以获得更多的描述）**。我们将在以后的模块中更详细地使用浏览器API

## 函数与方法

程序员把函数称为对象**方法（method）**的一部分。你还不必了解JavaScript中已建构的对象在更深层次上是如何运作的——你可以等到下一小节，我们会教给你有关对象运作方式的一切。在我们继续前进之前，我们需要澄清一些有关方法和函数概念之间可能存在的误会——当你在网络上浏览相关信息的时候，你很可能会碰上这两个术语。

到目前为止我们所使用的内置代码同属于这两种形式：函数和方法。你可以在[这里](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects)查看内置函数，内置对象以及其相关方法的完整列表。

严格说来，内置浏览器函数并不是函数——它们是**方法**。这听起来有点可怕和令人困惑，但不要担心 ——函数和方法在很大程度上是可互换的，至少在我们的学习阶段是这样的。

**<u>二者区别在于方法是在对象内定义的函数</u>**。浏览器内置函数（方法）和变量（称为属性）存储在结构化对象内，以使代码更加高效，易于处理。

## 匿名函数

您可能会以稍微不同的方式看到定义和调用的函数。到目前为止，我们刚刚创建了如下函数：

```js
function myFunction() {
  alert('hello');
}
```

但是您也可以创建一个没有名称的函数：

```js
function() {
  alert('hello');
}
```

这个函数叫做**匿名函数** — 它没有函数名! 它也不会自己做任何事情。 你通常使用匿名函数以及事件处理程序, 例如，如果单击相关按钮，以下操作将在函数内运行代码：

```js
var myButton = document.querySelector('button');

myButton.onclick = function() {
  alert('hello');
}
```

上述示例将要求[``](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/button) 在页面上提供可用于选择并单击的元素。您在整个课程中已经看到过这种结构了几次，您将在下一篇文章中了解更多信息并在其中使用。

你还可以将匿名函数分配为变量的值，例如：

```js
var myGreeting = function() {
  alert('hello');
}
```

现在可以使用以下方式调用此函数：

```js
myGreeting();
```

有效地给变量一个名字;还可以将该函数分配为多个变量的值，例如：

```js
var anotherGreeting = function() {
  alert('hello');
}
```

现在可以使用以下任一方法调用此函数

```js
myGreeting();
anotherGreeting();
```

但这只会令人费解，所以不要这样做！创建方法时，最好坚持下列形式：

```js
function myGreeting() {
  alert('hello');
}
```

您将主要使用匿名函数来运行负载的代码以响应事件触发（如点击按钮） - 使用事件处理程序。再次，这看起来像这样：

```js
myButton.onclick = function() {
  alert('hello');
  // I can put as much code
  // inside here as I want
}
```

匿名函数也称为函数表达式。函数表达式与函数声明有一些区别。函数声明会进行声明提升（declaration hoisting），而函数表达式不会。

## 函数作用域和冲突

我们来谈一谈 [scope](https://developer.mozilla.org/zh-CN/docs/Glossary/Scope)即作用域 — 处理函数时一个非常重要的概念。**<u>当你创建一个函数时，函数内定义的变量和其他东西都在它们自己的单独的范围内, 意味着它们被锁在自己独立的隔间中, 不能被函数外的代码访问</u>**。

***所有函数的最外层被称为全局作用域。 在全局作用域内定义的值可以在任意地方访问***。

JavaScript由于各种原因而建立，但主要是由于安全性和组织性。有时您不希望变量可以在代码中的任何地方访问 - 您从其他地方调用的外部脚本可能会开始搞乱您的代码并导致问题，因为它们恰好与代码的其他部分使用了相同的变量名称，造成冲突。这可能是恶意的，或者是偶然的。

例如，假设您有一个HTML文件，它调用两个外部JavaScript文件，并且它们都有一个使用相同名称定义的变量和函数：

```html
<!-- Excerpt from my HTML -->
<script src="first.js"></script>
<script src="second.js"></script>
<script>
  greeting();
</script>
// first.js
var name = 'Chris';
function greeting() {
  alert('Hello ' + name + ': welcome to our company.');
}
// second.js
var name = 'Zaptec';
function greeting() {
  alert('Our company is called ' + name + '.');
}
```

这两个函数都使用 `greeting()` 形式调用，但是你只能访问到 `first.js`文件的`greeting()`函数。`second.js` 的代码被忽略。除此之外，在second.js中用let声明name这个变量会报错。

**Note**: 您可以参考这个例子 [running live on GitHub](http://mdn.github.io/learning-area/javascript/building-blocks/functions/conflict.html) (查看完整 [源代码](https://github.com/mdn/learning-area/tree/master/javascript/building-blocks/functions)).

将代码锁定在函数中的部分避免了这样的问题，并被认为是最佳实践。

这有点像一个动物园。狮子，斑马，老虎和企鹅都保留在自己的园子中，只能拿到到它们园子中的东西 —— 与其函数作用域相同。如果他们能进入其他园子，就会出现问题。不同的动物会在不熟悉的栖息地内感到真的不舒服 - 一只狮子或老虎会在企鹅的水多的，冰冷的的领域中感到可怕。最糟糕的是，狮子和老虎可能会尝试吃企鹅！

![img](https://mdn.mozillademos.org/files/14079/MDN-mozilla-zoo.png)

动物园管理员就像全局作用域 - 他或她有钥匙访问每个园子，重新投喂食物，照顾生病的动物等。

### 主动学习: 和 scope 玩耍

我们来看一个真正的例子来展示范围

1. 首先，制作我们的[function-scope.html](https://github.com/mdn/learning-area/blob/master/javascript/building-blocks/functions/function-scope.html)示例的本地副本。它包含两个函数`a()`和`b()`，和三个变量—— `x`，`y`和`z`——其中两个在函数中被定义，另一个被定义在全局作用域内。它还包含一个名为`output()`的函数，它接收一个参数，并将其输出到页面的一个段落中。
2. 在浏览器和文本编辑器中打开示例。
3. 在浏览器开发工具中打开JavaScript控制台。在JavaScript控制台中，输入以下命令：

```js
output(x);
```

您应该看到变量`x`输出到屏幕的值。

​    4.现在尝试在您的控制台中输入以下内容

```js
output(y);
output(z);
```

这两个都应该返回错误沿“ [ReferenceError：y未定义](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Errors/Not_defined) ”。这是为什么？由于函数作用域 - `y和``z`被锁定在函数`a()`和`b()`函数中，所以`output()`从全局作用域调用时无法访问它们。

​    5.但是，从另一个函数里面调用什么呢？尝试编辑`a()`，`b()`所以他们看起来像这样：

```js
function a() {
  var y = 2;
  output(y);
}

function b() {
  var z = 3;
  output(z);
}
```

保存代码并重新加载到浏览器中，然后尝试从JavaScript控制台调用`a()`和`b()`函数：

```js
a();
b();
```

您应该看到页面中输出的`y`和`z`的值。这样就没问题，因为`output()`函数在其他函数的内部被调用 - 在这种情况下，输出变量的定义和函数的调用都在同一个作用域中（译者注：即函数作用域）。`output()`它可以从任何地方被调用，因为它在全局作用域中被定义。

​    6.现在尝试更新您的代码，如下所示：

```js
function a() {
  var y = 2;
  output(x);
}

function b() {
  var z = 3;
  output(x);
}
```

再次保存并重新加载，并在JavaScript控制台中再次尝试：

```js
a();
b();
```

函数 `a()`和`b()`都应该输出x---1的值。这些没有问题，因为即使`output()`的调用与`x`的定义不在同一个作用域内，但`x`是一个全局变量，所以在所有代码中都可用。

7.最后，尝试更新您的代码，如下所示：

```js
function a() {
  var y = 2;
  output(z);
}

function b() {
  var z = 3;
  output(y);
}
```

再次保存并重新加载，并在JavaScript控制台中再次尝试：

```js
a();
b();
```

这次`a()`和`b()`调用都会返回那个令人讨厌的 "[ReferenceError: z is not defined](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Errors/Not_defined)" error — 这是因为`output()`函数的调用和输出变量的定义不在同一个函数作用域内 - 变量对这些函数调用是不可见的。

> **注意**:相同的范围规则不适用于循环（for（）{...}）和条件块（if（）{...}） - 它们看起来非常相似，但它们不一样！小心不要让这些困惑。

> 注意：ReferenceError：“x”未定义错误是您遇到的最常见的错误。如果您收到此错误，并且确定您已经定义了该问题的变量，请检查它的范围。

### 函数内部的函数

请记住，您可以从任何地方调用函数，甚至可以在另一个函数中调用函数。这通常被用作保持代码整洁的方式 - 如果您有一个复杂的函数，如果将其分解成几个子函数，它更容易理解：

```js
function myBigFunction() {
  var myValue;

  subFunction1();
  subFunction2();
  subFunction3();
}

function subFunction1() {
  console.log(myValue);
}

function subFunction2() {
  console.log(myValue);
}

function subFunction3() {
  console.log(myValue);
}
```

要确保函数调取的数值处在有效的作用域内。上面的例子中会产生一个错误提示，`ReferenceError：myValue is not define`，因为尽管`myValue`变量与函数调用指令处在同一个作用域中, 但它却没有在函数内被定义 —— 实际代码在调用函数时就开始运行了。为了使代码正确运作，你必须将值作为参数传递给函数，如下所示：

```js
function myBigFunction() {
  var myValue = 1;
      
  subFunction1(myValue);
  subFunction2(myValue);
  subFunction3(myValue);
}

function subFunction1(value) {
  console.log(value);
}

function subFunction2(value) {
  console.log(value);
}

function subFunction3(value) {
  console.log(value);
}
```



一般来说，一个函数是可以通过外部代码调用的一个“子程序”（或在递归的情况下由内部函数调用）。像程序本身一样，一个函数由称为函数体的一系列语句组成。值可以传递给一个函数，函数将返回一个值。

 

在 JavaScript中，函数是**头等(**first-class**)**对象，因为它们可以像任何其他**对象**一样具有属性和方法。它们与其他对象的区别在于函数可以被调用。简而言之，它们是`Function`对象。

 

有关更多示例和说明，请参阅[有关函数的JavaScript指南](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Guide/Functions)。



# JavaScript 对象基础

## "this"的含义

你也许在我们的方法里注意到了一些奇怪的地方，看这个例子：

```js
greeting: function() {
  alert('Hi! I\'m ' + this.name.first + '.');
}
```

你也许想知道"this"是什么，关键字"this"指向了当前代码运行时的对象( 原文：the current object the code is being written inside )——这里即指person对象.为什么不直接写person呢？当你学到下一篇[Object-oriented JavaScript for beginners](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects/Object-oriented_JS)文章时，我们开始使用构造器(constructor)时，"this"是非常有用的——它保证了当代码的上下文(context)改变时变量的值的正确性（比如：不同的person对象拥有不同的name这个属性，很明显greeting这个方法需要使用的是它们自己的name）。

让我们以两个简单的person对象来说明：

```js
var person1 = {
  name : 'Chris',
  greeting: function() {
    alert('Hi! I\'m ' + this.name + '.');
  }
}

var person2 = {
  name : 'Brian',
  greeting: function() {
    alert('Hi! I\'m ' + this.name + '.');
  }
}
```

在这里，person1.greeting()会输出："Hi! I'm Chris."；person2.greeting()会输出："Hi! I'm Brain."，即使greeting这个方法的代码是一样的。就像我们之前说的，this 指向了代码所在的对象(其实代码运行时所在的对象)。在字面量的对象里this看起来不是很有用，但是当你动态创建一个对象（例如使用构造器）时它是非常有用的，之后你会更清楚它的用途。



# 事件介绍

事件是您在编程时系统内发生的动作或者发生的事情，系统响应事件后，如果需要，您可以某种方式对事件做出回应。例如：如果用户在网页上单击一个按钮，您可能想通过显示一个信息框来响应这个动作。在这篇文章中，我们将讨论一些关于事件的重要概念，并且观察它们在浏览器上如何运行。这篇文章不会面面俱到，仅聚焦于您现阶段需要掌握的知识。

## 一系列事件

就像上面提到的, **事件**是您在编程时系统内发生的动作或者发生的事情——系统会在事件出现时产生或触发某种信号，并且会提供一个自动加载某种动作（列如：运行一些代码）的机制，比如在一个机场，当跑道清理完成，飞机可以起飞时，飞行员会收到一个信号，因此他们开始起飞。

![img](https://mdn.mozillademos.org/files/14077/MDN-mozilla-events-runway.png)

在Web中, 事件在浏览器窗口中被触发并且通常被绑定到窗口内部的特定部分 — 可能是一个元素、一系列元素、被加载到这个窗口的 HTML 代码或者是整个浏览器窗口。举几个可能发生的不同事件：

- 用户在某个元素上点击鼠标或悬停光标。
- 用户在键盘中按下某个按键。
- 用户调整浏览器的大小或者关闭浏览器窗口。
- 一个网页停止加载。
- 提交表单。
- 播放、暂停、关闭视频。
- 发生错误。

如果您想看看更多其他的事件 ，请移步至MDN的[Event reference](https://developer.mozilla.org/en-US/docs/Web/Events)。

每个可用的事件都会有一个**事件处理器**，也就是事件触发时会运行的代码块。当我们定义了一个用来回应事件被激发的代码块的时候，我们说我们**注册了一个事件处理器**。注意事件处理器有时候被叫做**事件监听器**——从我们的用意来看这两个名字是相同的，尽管严格地来说这块代码既监听也处理事件。监听器留意事件是否发生，然后处理器就是对事件发生做出的回应。

**注：** 网络事件不是 JavaScript 语言的核心——它们被定义成内置于浏览器的JavaScript APIs。

### 一个简单的例子

让我们看一个简单的例子。前面您已经见到过很多事件和事件监听器，现在我们概括一下以巩固我们的知识。在接下来的例子中，我们的页面中只有一个 button，按下时，背景会变成随机的一种颜色。

```html
<button>Change color</button>
```

JavaScript代码如下所示：

```js
var btn = document.querySelector('button');

function random(number) {
  return Math.floor(Math.random()*(number+1));
}

btn.onclick = function() {
  var rndCol = 'rgb(' + random(255) + ',' + random(255) + ',' + random(255) + ')';
  document.body.style.backgroundColor = rndCol;
}
```

我们使用`btn`变量存储 button，并使用了`Document.querySelector()`函数。我们也定义了一个返回随机数字的函数。代码第三部分就是事件处理器。`btn`变量指向 button 元素，在 button 这种对象上可触发一系列的事件，因此也就可以使用事件处理器。我们通过将一个匿名函数（这个赋值函数包括生成随机色并赋值给背景色的代码）赋值给“点击”事件处理器参数，监听“点击”这个事件。

只要点击事件在``元素上触发，该段代码就会被执行。即每当用户点击它时，都会运行此段代码。

示例输出如下：



### 这不仅应用在网页上

值得注意的是并不是只有 JavaScript 使用事件——大多的编程语言都有这种机制，并且它们的工作方式不同于 JavaScript。实际上，JavaScript 网页上的事件机制不同于在其他环境中的事件机制。

比如, [Node.js](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Express_Nodejs) 是一种非常流行的允许开发者使用 JavaScript 来建造网络和服务器端应用的运行环境。[Node.js event model](https://nodejs.org/docs/latest-v5.x/api/events.html) 依赖定期监听事件的监听器和定期处理事件的处理器——虽然听起来好像差不多，但是实现两者的代码是非常不同的，Node.js 使用像 on ( ) 这样的函数来注册一个事件监听器，使用 once ( ) 这样函数来注册一个在运行一次之后注销的监听器。 [HTTP connect event docs](https://nodejs.org/docs/latest-v5.x/api/http.html#http_event_connect) 提供了很多例子。

另外一个例子：您可以使用 JavaScript 来开发跨浏览器的插件（使用 [WebExtensions](https://developer.mozilla.org/en-US/docs/Mozilla/Add-ons/WebExtensions) 开发技术。事件模型和网站的事件模型是相似的，仅有一点点不同——事件监听属性是大驼峰的（如`onMessage`而不是`onmessage`），还需要与 `addListener` 函数结合， 参见 [runtime.onMessage page](https://developer.mozilla.org/en-US/Add-ons/WebExtensions/API/runtime/onMessage#Examples) 上的一个例子。

您现在不需要掌握这些，我们只想表明不同的编程环境下事件机制是不同的，

## 使用网页事件的方式

您可以通过多种不同的方法将事件侦听器代码添加到网页，以便在关联的事件被触发时运行它。在本节中，我们将回顾不同的机制，并讨论应该使用哪些机制。

### 事件处理器属性

*这些是我们的课程中最常见到的代码 - 存在于事件处理程序过程的属性中*。回到上面的例子：

```js
var btn = document.querySelector('button');

btn.onclick = function() {	
  var rndCol = 'rgb(' + random(255) + ',' + random(255) + ',' + random(255) + ')';
  document.body.style.backgroundColor = rndCol;
}
```

这个 `onclick` 是被用在这个情景下的事件处理器的属性，它就像 button 其他的属性（如 `btn.textContent`, or `btn.style`), 但是有一个特别的地方——当您将一些代码赋值给它的时候，只要事件触发代码就会运行。

您也可以将一个有名字的函数赋值给事件处理参数（正如我们在 [Build your own function](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Building_blocks/Build_your_own_function) 中看到的），下面的代码也是这样工作的：

```js
var btn = document.querySelector('button');

function bgChange() {
  var rndCol = 'rgb(' + random(255) + ',' + random(255) + ',' + random(255) + ')';
  document.body.style.backgroundColor = rndCol;
}

btn.onclick = bgChange;
```

有很多事件处理参数可供选择，我们来做一个实验。

首先将 [random-color-eventhandlerproperty.html](https://github.com/mdn/learning-area/blob/master/javascript/building-blocks/events/random-color-eventhandlerproperty.html) 复制到本地，然后用浏览器打开。别慌，这只是我们之前已经进行过的一个简单随机颜色的示例的代码复制。将 `btn.onclick` 依次换成其他值，在浏览器中观察效果。

- `btn.onfocus`及`btn.onblur` — 颜色将于按钮被置于焦点或解除焦点时改变（尝试使用Tab移动至按钮上，然后再移开）。这些通常用于显示有关如何在置于焦点时填写表单字段的信息，或者如果表单字段刚刚填入不正确的值，则显示错误消息。
- `btn.ondblclick` — 颜色将仅于按钮被双击时改变。
- `window.onkeypress`, `window.onkeydown`, `window.onkeyup` — 当按钮被按下时颜色会发生改变. `keypress` 指的是通俗意义上的按下按钮 (按下并松开), 而 `keydown` 和 `keyup` 指的是按键动作的一部分,分别指按下和松开. 注意如果你将事件处理器添加到按钮本身，它将不会工作 — 我们只能将它添加到代表整个浏览器窗口的 [window](https://developer.mozilla.org/en-US/docs/Web/API/Window)对象中。
- `btn.onmouseover` 和 `btn.onmouseout` — 颜色将会在鼠标移入按钮上方时发生改变, 或者当它从按钮移出时.

一些事件非常通用，几乎在任何地方都可以用（比如 onclick 几乎可以用在几乎每一个元素上），然而另一些元素就只能在特定场景下使用，比如我们只能在 video 元素上使用 [onplay](https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/GlobalEventHandlers.onplay) 。

### 行内事件处理器 - 请勿使用







你也许在你的代码中看到过这么一种写法:

```html
<button onclick="bgChange()">Press me</button>
function bgChange() {
  var rndCol = 'rgb(' + random(255) + ',' + random(255) + ',' + random(255) + ')';
  document.body.style.backgroundColor = rndCol;
}
```

**Note**: 您可以在[GitHub](https://github.com/mdn/learning-area/blob/master/javascript/building-blocks/events/random-color-eventhandlerattributes.html)上找到这个示例的完整源代码(也可以[在线运行](http://mdn.github.io/learning-area/javascript/building-blocks/events/random-color-eventhandlerattributes.html)).

在Web上注册事件处理程序的最早方法是类似于上面所示的**事件处理程序HTML属性**(也称为内联事件处理程序)—属性值实际上是当事件发生时要运行的JavaScript代码。上面的例子中调用一个在[``](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/script)元素在同一个页面上，但也可以直接在属性内插入JavaScript，例如：

```html
<button onclick="alert('Hello, this is my old-fashioned event handler!');">Press me</button>
```

你会发现HTML属性等价于对许多事件处理程序的属性；但是，你不应该使用这些 —— 他们被认为是不好的做法。使用一个事件处理属性似乎看起来很简单，如果你只是在做一些非常快的事情，但很快就变得难以管理和效率低下。

一开始，您不应该混用 HTML 和 JavaScript，因为这样文档很难解析——最好的办法是只在一块地方写 JavaScript 代码。

即使在单一文件中，内置事件处理器也不是一个好主意。一个按钮看起来还好，但是如果有一百个按钮呢？您得在文件中加上100个属性。这很快就会成为维护人员的噩梦。使用 Java Script，您可以给网页中的 button 都加上事件处理器。就像下面这样：

```js
var buttons = document.querySelectorAll('button');

for (var i = 0; i < buttons.length; i++) {
  buttons[i].onclick = bgChange;
}
```

**注释**: 将您的编程逻辑与内容分离也会让您的站点对搜索引擎更加友好。

### addEventListener()和removeEventListener()

新的事件触发机制被定义在 [Document Object Model (DOM) Level 2 Events](https://www.w3.org/TR/DOM-Level-2-Events/) Specification, 这个细则给浏览器提供了一个函数 — `addEventListener()`。这个函数和事件处理属性是类似的，但是语法略有不同。我们可以重写上面的随机颜色背景代码：

```js
var btn = document.querySelector('button');

function bgChange() {
  var rndCol = 'rgb(' + random(255) + ',' + random(255) + ',' + random(255) + ')';
  document.body.style.backgroundColor = rndCol;
}   

btn.addEventListener('click', bgChange);
```

**注释**: 您可以在[Github](https://github.com/mdn/learning-area/blob/master/javascript/building-blocks/events/random-color-addeventlistener.html)上找到这个示例的完整源代码(也可以[ 在线运行](http://mdn.github.io/learning-area/javascript/building-blocks/events/random-color-addeventlistener.html))。

`在addEventListener()` 函数中, 我们具体化了两个参数——我们想要将处理器应用上去的事件名称，和包含我们用来回应事件的函数的代码。注意将这些代码全部放到一个匿名函数中是可行的:

```js
btn.addEventListener('click', function() {
  var rndCol = 'rgb(' + random(255) + ',' + random(255) + ',' + random(255) + ')';
  document.body.style.backgroundColor = rndCol;
});
```

这个机制带来了一些相较于旧方式的优点。有一个相对应的方法，`removeEventListener()，`这个方法移除事件监听器。例如，下面的代码将会移除上个代码块中的事件监听器：

```js
btn.removeEventListener('click', bgChange);
```

在这个简单的、小型的项目中可能不是很有用，但是在大型的、复杂的项目中就非常有用了，可以非常高效地清除不用的事件处理器，另外在其他的一些场景中也非常有效——比如您需要在不同环境下运行不同的事件处理器，您只需要恰当地删除或者添加事件处理器即可。

您也可以给同一个监听器注册多个处理器，下面这种方式不能实现这一点：

```js
myElement.onclick = functionA;
myElement.onclick = functionB;
```

第二行会覆盖第一行，但是下面这种方式就会正常工作了：

```js
myElement.addEventListener('click', functionA);
myElement.addEventListener('click', functionB);
```

当元素被点击时两个函数都会工作：

此外，该事件机制还提供了许多其他强大的特性和选项。这对于本文来说有点超出范围，但是如果您想要阅读它们，请查看`addEventListener()`和`removeEventListener()`参考页面。

### 我该使用哪种机制？

在三种机制中,您绝对不应该使用HTML事件处理程序属性 - 这些属性已经过时了，而且也是不好的做法，如上所述.

另外两种是相对可互换的，至少对于简单的用途:

- 事件处理程序属性功能和选项会更少，但是具有更好的跨浏览器兼容性(在Internet Explorer 8的支持下)，您应该从这些开始学起。
- DOM Level 2 Events (`addEventListener()`, etc.) 更强大，但也可以变得更加复杂，并且支持不足（只支持到Internet Explorer 9）。 但是您也应该尝试这个方法，并尽可能地使用它们。

第三种机制（DOM Level 2 Events (`addEventListener()`, etc.)）的主要优点是，如果需要的话，可以使用`removeEventListener()`删除事件处理程序代码，而且如果有需要，您可以向同一类型的元素添加多个监听器。例如，您可以在一个元素上多次调用`addEventListener('click', function() { ... })`，并可在第二个参数中指定不同的函数。对于事件处理程序属性来说，这是不可能的，因为后面任何设置的属性都会尝试覆盖较早的属性，例如：

```js
element.onclick = function1;
element.onclick = function2;
etc.
```

**注解**:如果您在工作中被要求支持比Internet Explorer 8更老的浏览器，那么您可能会遇到困难，因为这些古老的浏览器会使用与现代浏览器不同的事件处理模型。但是不要害怕，大多数JavaScript库(例如jQuery)都内置了能够跨浏览器差异的函数。在你学习JavaScript旅程里的这个阶段，不要太担心这个问题。

## 其他事件概念

本节我们将简要介绍一些与事件相关的高级概念。在这一点并不需要完全理解透彻，但它可能有助于你解释一些经常会遇到的代码模式。

### 事件对象

有时候在事件处理函数内部，您可能会看到一个固定指定名称的参数，例如`event`，`evt`或简单的`e`。 这被称为**事件对象**，它被自动传递给事件处理函数，以提供额外的功能和信息。 例如，让我们稍稍重写一遍我们的随机颜色示例：

```js
function bgChange(e) {
  var rndCol = 'rgb(' + random(255) + ',' + random(255) + ',' + random(255) + ')';
  e.target.style.backgroundColor = rndCol;
  console.log(e);
}  

btn.addEventListener('click', bgChange);
```

**Note**: 您可以在Github上查看这个示例的 [完整代码](https://github.com/mdn/learning-area/blob/master/javascript/building-blocks/events/random-color-eventobject.html) ，或者在这里查看 [实时演示](http://mdn.github.io/learning-area/javascript/building-blocks/events/random-color-eventobject.html)。

在这里，您可以看到我们在函数中包括一个事件对象`e`，并在函数中设置背景颜色样式在`e.target上` - 它指的是按钮本身。 事件对象 `e` 的`target`属性始终是事件刚刚发生的元素的引用。 所以在这个例子中，我们在按钮上设置一个随机的背景颜色，而不是页面。

**Note**: 您可以使用任何您喜欢的名称作为事件对象 - 您只需要选择一个名称，然后可以在事件处理函数中引用它。 开发人员最常使用 e / evt / event，因为它们很简单易记。 坚持标准总是很好。

当您要在多个元素上设置相同的事件处理程序时，`e.target`非常有用，并且在发生事件时对所有元素执行某些操作.  例如，你可能有一组16块方格，当它们被点击时就会消失。用e.target总是能准确选择当前操作的东西（方格）并执行操作让它消失，而不是必须以更困难的方式选择它。在下面的示例中(请参见[useful-eventtarget.html](https://github.com/mdn/learning-area/blob/master/javascript/building-blocks/events/useful-eventtarget.html)完整代码;也可以在线运行[running live](http://mdn.github.io/learning-area/javascript/building-blocks/events/useful-eventtarget.html)）我们使用JavaScript创建了16个``元素。接着我们使用 `document.querySelectorAll()`选择全部的元素,然后遍历每一个,为每一个元素都添加一个`onclick`单击事件，每当它们点击时就会为背景添加一个随机颜色。

```js
var divs = document.querySelectorAll('div');

for (var i = 0; i < divs.length; i++) {
  divs[i].onclick = function(e) {
    e.target.style.backgroundColor = bgChange();
  }
}
```

输出如下(试着点击它-玩的开心):



你遇到的大多数事件处理器的事件对象都有可用的标准属性和函数（方法）（请参阅完整列表`Event`对象引用 ）。然而，一些更高级的处理程序会添加一些专业属性，这些属性包含它们需要运行的额外数据。例如，媒体记录器API有一个`dataavailable`事件，它会在录制一些音频或视频时触发，并且可以用来做一些事情(例如保存它，或者回放)。对应的`ondataavailable`处理程序的事件对象有一个可用的数据属性。

### 阻止默认行为

有时，你会遇到一些情况，你希望事件不执行它的默认行为。 最常见的例子是Web表单，例如自定义注册表单。 当你填写详细信息并按提交按钮时，自然行为是将数据提交到服务器上的指定页面进行处理，并将浏览器重定向到某种“成功消息”页面（或 相同的页面，如果另一个没有指定。）

当用户没有正确提交数据时，麻烦就来了 - 作为开发人员，你希望停止提交信息给服务器，并给他们一个错误提示，告诉他们什么做错了，以及需要做些什么来修正错误。 一些浏览器支持自动的表单数据验证功能，但由于许多浏览器不支持，因此建议你不要依赖这些功能，并实现自己的验证检查。 我们来看一个简单的例子。

首先，一个简单的HTML表单，需要你填入名（first name）和姓（last name）

```html
<form>
  <div>
    <label for="fname">First name: </label>
    <input id="fname" type="text">
  </div>
  <div>
    <label for="lname">Last name: </label>
    <input id="lname" type="text">
  </div>
  <div>
     <input id="submit" type="submit">
  </div>
</form>
<p></p>
```

这里我们用一个`onsubmit`事件处理程序（在提交的时候，在一个表单上发起`submit`事件）来实现一个非常简单的检查，用于测试文本字段是否为空。 如果是，我们在事件对象上调用`preventDefault()`函数，这样就停止了表单提交，然后在我们表单下面的段落中显示一条错误消息，告诉用户什么是错误的：

```js
var form = document.querySelector('form');
var fname = document.getElementById('fname');
var lname = document.getElementById('lname');
var submit = document.getElementById('submit');
var para = document.querySelector('p');

form.onsubmit = function(e) {
  if (fname.value === '' || lname.value === '') {
    e.preventDefault();
    para.textContent = 'You need to fill in both names!';
  }
}
```

显然，这是一种非常弱的表单验证——例如，用户输入空格或数字提交表单，表单验证并不会阻止用户提交——这不是我们例子想要达到的目的。输出如下:



**Note**: 查看完整的源代码 [preventdefault-validation.html](https://github.com/mdn/learning-area/blob/master/javascript/building-blocks/events/preventdefault-validation.html) (也可以 [running live](http://mdn.github.io/learning-area/javascript/building-blocks/events/preventdefault-validation.html) )

### 事件冒泡及捕获

最后即将介绍的这个主题你常常不会深究，但如果你不理解这个主题，就会十分痛苦。事件冒泡和捕捉是两种机制，主要描述当在一个元素上有两个相同类型的事件处理器被激活会发生什么。为了容易理解，我们来看一个例子——在新标签页打开这个[show-video-box.html](http://mdn.github.io/learning-area/javascript/building-blocks/events/show-video-box.html) 例子（在这里可以查看源码 [source code](https://github.com/mdn/learning-area/blob/master/javascript/building-blocks/events/show-video-box.html)）。也可以在下面查看：



这是一个非常简单的例子，它显示和隐藏一个包含``元素的``元素：

```html
<button>Display video</button>

<div class="hidden">
  <video>
    <source src="rabbit320.mp4" type="video/mp4">
    <source src="rabbit320.webm" type="video/webm">
    <p>Your browser doesn't support HTML5 video. Here is a <a href="rabbit320.mp4">link to the video</a> instead.</p>
  </video>
</div>
```

当‘’button‘’元素按钮被单击时，将显示视频，它是通过将改变`的`class属性值从`hidden`变为`showing`(这个例子的CSS包含两个`class`，它们分别控制这个``盒子在屏幕上显示还是隐藏。)：

```js
btn.onclick = function() {
  videoBox.setAttribute('class', 'showing');
}
```

然后我们再添加几个`onclick`事件处理器，第一个添加在``元素上，第二个添加在``元素上。这个想法是当视频(``）外 ``元素内这块区域被单击时，这个视频盒子应该再次隐藏；当单击视频(``）本身，这个视频将开始播放。

```html
videoBox.onclick = function() {
  videoBox.setAttribute('class', 'hidden');
};

video.onclick = function() {
  video.play();
};
```

但是有一个问题 - 当您点击`video`开始播放的视频时，它会在同一时间导致``也被隐藏。 这是因为`video`在``之内 - `video`是``的一个子元素 - 所以点击`video`实际上是同时也运行``上的事件处理程序。

#### 对事件冒泡和捕捉的解释

当一个事件发生在具有父元素的元素上(例如，在我们的例子中是<video>元素)时，现代浏览器运行两个不同的阶段 - 捕获阶段和冒泡阶段。 在捕获阶段：

- 浏览器检查元素的最外层祖先`<html>`，是否在捕获阶段中注册了一个`onclick`事件处理程序，如果是，则运行它。
- 然后，它移动到`<html>`中单击元素的下一个祖先元素，并执行相同的操作，然后是单击元素再下一个祖先元素，依此类推，直到到达实际点击的元素。

在冒泡阶段，恰恰相反:

- 浏览器检查实际点击的元素是否在冒泡阶段中注册了一个`onclick`事件处理程序，如果是，则运行它
- 然后它移动到下一个直接的祖先元素，并做同样的事情，然后是下一个，等等，直到它到达`<html>`元素。

[![img](https://mdn.mozillademos.org/files/14075/bubbling-capturing.png)](https://mdn.mozillademos.org/files/14075/bubbling-capturing.png)

(单击图片可以放大这个图表)

在现代浏览器中，默认情况下，所有事件处理程序都在冒泡阶段进行注册。因此，在我们当前的示例中，当您单击视频时，这个单击事件从 `<video>`元素向外冒泡直到`<html>`元素。沿着这个事件冒泡线路：

- 它发现了`video.onclick...`事件处理器并且运行它，因此这个视频`<video>`第一次开始播放。
- 接着它发现了（往外冒泡找到的） `videoBox.onclick...`事件处理器并且运行它，因此这个视频`<video>`也隐藏起来了。

#### 用stopPropagation()修复问题

这是令人讨厌的行为，但有一种方法来解决它！标准事件对象具有可用的名为 `stopPropagation()`的函数, 当在事件对象上调用该函数时，它只会让当前事件处理程序运行，但事件不会在**冒泡**链上进一步扩大，因此将不会有更多事件处理器被运行(不会向上冒泡)。所以，我们可以通过改变前面代码块中的第二个处理函数来解决当前的问题:

```js
video.onclick = function(e) {
  e.stopPropagation();
  video.play();
};
```

你可以尝试把[show-video-box.html source code](https://github.com/mdn/learning-area/blob/master/javascript/building-blocks/events/show-video-box.html)拷贝到本地，然后自己动手修复它，或者在[show-video-box-fixed.html](http://mdn.github.io/learning-area/javascript/building-blocks/events/show-video-box-fixed.html) 页面查看修复结果（也可以在这里[source code](https://github.com/mdn/learning-area/blob/master/javascript/building-blocks/events/show-video-box-fixed.html)查看源码）。

> **注解**: 为什么我们要弄清楚捕捉和冒泡呢？那是因为，在过去糟糕的日子里，浏览器的兼容性比现在要小得多，Netscape（网景）只使用事件捕获，而Internet Explorer只使用事件冒泡。当W3C决定尝试规范这些行为并达成共识时，他们最终得到了包括这两种情况（捕捉和冒泡）的系统，最终被应用在现在浏览器里。

> **注解**: 如上所述，默认情况下，所有事件处理程序都是在冒泡阶段注册的，这在大多数情况下更有意义。如果您真的想在捕获阶段注册一个事件，那么您可以通过使用`addEventListener()`注册您的处理程序，并将可选的第三个属性设置为true。

#### 事件委托

冒泡还允许我们利用事件委托——这个概念依赖于这样一个事实,如果你想要在大量子元素中单击任何一个都可以运行一段代码，您可以将事件监听器设置在其父节点上，并让子节点上发生的事件冒泡到父节点上，而不是每个子节点单独设置事件监听器。

一个很好的例子是一系列列表项，如果你想让每个列表点击时弹出一条信息，您可以将`click`单击事件监听器设置在父元素``上，它将会冒泡到列表项上。

这个的概念在David Walsh的博客上有更多的解释，并有多个例子——看看[How JavaScript Event Delegation Works](https://davidwalsh.name/event-delegate).

## 结论

现在您应该知道在这个早期阶段您需要了解的所有web事件。如上所述，事件并不是JavaScript的核心部分——它们是在浏览器Web APIs中定义的。

另外，理解JavaScript在不同环境下使用不同的事件模型很重要——从Web api到其他领域，如浏览器WebExtensions和Node.js(服务器端JavaScript)。我们并不期望您现在了解所有这些领域，但是当您在学习web开发的过程中，理解这些事件的基础是很有帮助的。

## 参见

- [Event order](http://www.quirksmode.org/js/events_order.html) (discussion of capturing and bubbling) — an excellently detailed piece by Peter-Paul Koch.
- [Event accessing](http://www.quirksmode.org/js/events_access.html) (discussing of the event object) — another excellently detailed piece by Peter-Paul Koch.
- [Event reference](https://developer.mozilla.org/en-US/docs/Web/Events)



# JavaScript 对象入门

在 JavaScript 中，大多数事物都是对象, 从作为核心功能的字符串和数组，到建立在 JavaScript 之上的浏览器 [API](https://developer.mozilla.org/zh-CN/docs/Glossary/API) 。你甚至可以自己创建对象，将相关的函数和变量高效地封装打包成便捷的数据容器。对于进一步学习 JavaScript 语言知识而言，理解这种面向对象（object-oriented, OO）的特性是必不可少的，所以，我们提供了这个模块来帮助你了解这一切。这里我们会先详细介绍对象的理论和语法，再介绍如何创建对象。

## 预备知识

开始这个模块之前，你应当已经对 HTML 和 CSS 有所了解。我们建议你通读 [HTML 入门](https://developer.mozilla.org/zh-CN/docs/Web/Guide/HTML/Introduction)和 [CSS 入门](https://developer.mozilla.org/zh-CN/docs/Learn/CSS/Introduction_to_CSS)模块，再开始了解 JavaScript。

详细了解 JavaScript 对象之前，你应当已经对 JavaScript 基础有所熟悉。尝试这个模块之前，请通读 [JavaScript 第一步](https://developer.mozilla.org/zh-CN/docs/Learn/JavaScript/First_steps) 和 [JavaScript基础要件](https://developer.mozilla.org/zh-CN/docs/Learn/JavaScript/Building_blocks)

**注意**：如果您无法在当前使用的电脑/平板/其他设备上创建自己的文件，可以使用在线编程网站如 [JSBin](http://jsbin.com/) 或 [Thimble](https://thimble.mozilla.org/)，来试验文章中的（大多数）代码。



# JavaScript 对象基础

## 对象基础

对象是一个包含相关数据和方法的集合（通常由一些变量和函数组成，我们称之为对象里面的属性和方法），让我们通过一个例子来了解它们。

首先, 将 [oojs.html](https://github.com/mdn/learning-area/blob/master/javascript/oojs/introduction/oojs.html) 文件复制到本地. 此文件包含非常少 — 一个供我们写源代码的 [`<script>`](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/script) 标签, 一个供我们输入示例指令的 [`<input>`](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/input) 标签，当页面被渲染时, 一些变量定义, 一个输出任何输入到[`<input>`](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/input)的内容输出到[`<p>`](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/p)标签的函数。我们用这个文件做为基础探索对象的基础语法.

如同Javascript中的很多东西一样，创建一个对象通常先定义初始化变量。 尝试在您已有的文件中JavaScript代码下面输入以下内容, 保存刷新页面:

```js
var person = {};
```

如果你在浏览器控制台输入person，然后按下Enter(确认)键，你会得到如下结果：

```js
[object Object]
```

恭喜, 你刚创建了你的第一个对象. 干的漂亮! 但这是一个空对象，所以我们做不了更多的事情。像下面一样更新下我们的对象:

```js
var person = {
  name : ['Bob', 'Smith'],
  age : 32,
  gender : 'male',
  interests : ['music', 'skiing'],
  bio : function() {
    alert(this.name[0] + ' ' + this.name[1] + ' is ' + this.age + ' years old. He likes ' + this.interests[0] + ' and ' + this.interests[1] + '.');
  },
  greeting: function() {
    alert('Hi! I\'m ' + this.name[0] + '.');
  }
};
```

保存刷新后, 尝试在你的浏览器控制台输入下面的内容:

```js
person.name[0]
person.age
person.interests[1]
person.bio()
person.greeting()
```

现在在你的对象里得到了一些数据和功能（functionality），现在可以通过简单的语法访问他们了!

**Note**:如果做上面的东西遇到了麻烦，尝试拿你的代码与我们的版本做对比——对比 [oojs-finished.html](https://github.com/mdn/learning-area/blob/master/javascript/oojs/introduction/oojs-finished.html) (也可以 [看实际效果](http://mdn.github.io/learning-area/javascript/oojs/introduction/oojs-finished.html))。一个对于初学者很常见的错误是在最后一个成员后面多了一个逗号，这会引发错误。

所以发生了什么？一个对象由许多的成员组成，每一个成员都拥有一个名字（像上面的name、age），和一个值（如['Bob', 'Smith']、32）。每一个名字/值（name/value）对被逗号分隔开，并且名字和值之间由冒号（:）分隔，语法规则如下所示：

```js
var objectName = {
  member1Name : member1Value,
  member2Name : member2Value,
  member3Name : member3Value
}
```

对象成员的值可以是任意的，在我们的person对象里有字符串(string)，数字(number)，两个数组(array)，两个函数(function)。前4个成员是资料项目，被称为对象的属性(property)，后两个成员是函数，允许对象对资料做一些操作，被称为对象的方法(method)

一个如上所示的对象被称之为对象的字面量(literal)——手动的写出对象的内容来创建一个对象。不同于从类实例化一个对象，我们会在后面学习这种方式。

当你想要传输一些有结构和关联的资料时常见的方式是使用字面量来创建一个对象，举例来说，发起一个请求到服务器以存储一些数据到数据库，发送一个对象要比分别发送这些数据更有效率，而且比起数组更为易用，因为你使用名字(name)来标识这些资料。

## 点表示法

在上面的例子中，你使用了点表示法(dot notation)来访问对象的属性和方法。对象的名字表现为一个命名空间(namespace)，它必须写在第一位——当你想访问对象内部的属性或方法时，然后是一个点(.)，紧接着是你想要访问的项目，标识可以是简单属性的名字(name)，或者是数组属性的一个子元素，又或者是对象的方法调用。如下所示：

```js
person.age
person.interests[1]
person.bio()
```

### 子命名空间

可以用一个对象来做另一个对象成员的值。例如将name成员

```js
name : ['Bob', 'Smith'],
```

改成

```js
name : {
  first : 'Bob',
  last : 'Smith'
},
```

这样，我们实际上创建了一个子命名空间，听起来有点复杂，但用起来很简单，你只需要链式的再使用一次点表示法，像这样：

```js
person.name.first
person.name.last
```

**注意**：你需要改变你之前的代码，从

```js
name[0]
name[1]
```

改成

```js
name.first
name.last
```

否则，你的方法不再有效。





# 适合初学者的JavaScript面向对象

## 构建函数和对象

有些人认为 JavaScript 不是真正的面向对象的语言，比如它没有像许多面向对象的语言一样有用于创建class类的声明。JavaScript 用一种称为**构建函数**的特殊函数来定义对象和它们的特征。构建函数非常有用，因为很多情况下您不知道实际需要多少个对象（实例）。**构建函数**提供了创建您所需对象（实例）的有效方法，将对象的数据和特征函数按需联结至相应对象。

不像“经典”的面向对象的语言，从构建函数创建的新实例的特征并非全盘复制，而是通过一个叫做原形链的参考链链接过去的。（参见 [Object prototypes](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects/Object_prototypes)），所以这并非真正的实例，严格的讲， JavaScript 在对象间使用和其它语言的共享机制不同。

让我们来看看 JavaScript 如何通过构建函数对象来创建类。首先，请先复制一个新的前文提到的[oojs.html](https://github.com/mdn/learning-area/blob/master/javascript/oojs/introduction/oojs.html) 。

### 一个简单的例子

1. 让我们看看如何通过一个普通的函数定义一个”人“。在您的文件中添加以下代码:

   ```js
   function createNewPerson(name) {
     var obj = {};
     obj.name = name;
     obj.greeting = function () {
       alert('Hi! I\'m ' + this.name + '.');
     }
     return obj;
   }
   ```

2. 您现在可以通过调用这个函数创建一个新的叫 salva 的人，在您浏览器的JavaScript console 试试 ：

   ```js
   var salva = createNewPerson('salva');
   salva.name;
   salva.greeting();
   ```

   上述代码运行良好，但是有点冗长；如果我们知道如何创建一个对象，就没有必要创建一个新的空对象并且返回它。幸好 JavaScript 通过构建函数提供了一个便捷的方法，方法如下：

3. 将之前的代码用如下代码代替：

   ```js
   function Person(name) {
     this.name = name;
     this.greeting = function() {
       alert('Hi! I\'m ' + this.name + '.');
     };
   }
   ```

这个构建函数是 JavaScript 版本的类。您会发现，它只定义了对象的属性和方法，除了没有明确创建一个对象和返回任何值和之外，它有了您期待的函数所拥有的全部功能。这里使用了`this`关键词，即无论是该对象的哪个实例被这个构建函数创建，它的 `name` 属性就是传递到构建函数形参`name`的值，它的 `greeting()` 方法中也将使用相同的传递到构建函数形参`name`的值。

**注：** 一个构建函数通常是大写字母开头，这样便于区分构建函数和普通函数。

那如何调用构建函数创建新的实例呢？

1. 将下面的代码加在您之前的代码下面：

   ```js
   var person1 = new Person('Bob');
   var person2 = new Person('Sarah');
   ```

2. 保存并刷新浏览器，在 console 里输入如下代码：

   ```js
   person1.name
   person1.greeting()
   person2.name
   person2.greeting()
   ```

酷！您现在看到页面上有两个对象，每一个保存在不同的命名空间里，当您访问它们的属性和方法时，您需要使用`person1`或者`person2`来调用它们。尽管它们有着相同的`name`属性和 `greeting()`方法它们是各自独立的，所以相互的功能不会冲突。注意它们使用的是自己的 name 值，这也是使用 this 关键字的原因，它们使用的从实参传入形参的自己的值，而不是其它的什么值。

再看看这个构造对象的语法：

```js
var person1 = new Person('Bob');
var person2 = new Person('Sarah');
```

上述代码中，关键字 `new` 跟着一个含参函数，用于告知浏览器我们想要创建一个对象，非常类似函数调用，并把结果保存到变量中。每个示例类都是根据下面的方式定义的。

```js
function Person(name) {
  this.name = name;
  this.greeting = function() {
    alert('Hi! I\'m ' + this.name + '.');
  };
}
```

当新的对象被创立, 变量`person1`与`person2`有效地包含了以下值：

```js
{
  name : 'Bob',
  greeting : function() {
    alert('Hi! I\'m ' + this.name + '.');
  }
}

{
  name : 'Sarah',
  greeting : function() {
    alert('Hi! I\'m ' + this.name + '.');
  }
}
```

值得注意的是每次当我们调用构造函数时，我们都会重新定义一遍 greeting()，这不是个理想的方法。为了避免这样，我们可以在原型里定义函数，接下来我们会讲到。

### 创建我们最终的构造函数

上面的例子仅仅是简单地介绍如何开始。让我们现在开始创建`Person()`构造函数。

1. 移除掉您之前写的所有代码， 用如下构造函数替代 —— 实现原理上，这与我们之前的例子并无二致， 只是变得稍稍复杂了些：

   ```js
   function Person(first, last, age, gender, interests) {
     this.name = {
       'first': first,
       'last': last
     };
     this.age = age;
     this.gender = gender;
     this.interests = interests;
     this.bio = function() {
       alert(this.name.first + ' ' + this.name.last + ' is ' + this.age + ' years old. He likes ' + this.interests[0] + ' and ' + this.interests[1] + '.');
     };
     this.greeting = function() {
       alert('Hi! I\'m ' + this.name.first + '.');
     };
   };
   ```



### 创建我们最终的构造函数



上面的例子仅仅是简单地介绍如何开始。让我们现在开始创建`Person()`构造函数。

1. 移除掉您之前写的所有代码， 用如下构造函数替代 —— 实现原理上，这与我们之前的例子并无二致， 只是变得稍稍复杂了些：

   ```js
   function Person(first, last, age, gender, interests) {
     this.name = {
       'first': first,
       'last': last
     };
     this.age = age;
     this.gender = gender;
     this.interests = interests;
     this.bio = function() {
       alert(this.name.first + ' ' + this.name.last + ' is ' + this.age + ' years old. He likes ' + this.interests[0] + ' and ' + this.interests[1] + '.');
     };
     this.greeting = function() {
       alert('Hi! I\'m ' + this.name.first + '.');
     };
   };
   ```

2. 接下来加上这样一行代码， 用来创建它的一个对象：

   ```js
   var person1 = new Person('Bob', 'Smith', 32, 'male', ['music', 'skiing']);
   ```

这样，您就可以像我们定义第一个对象一样访问它的属性和方法了：

```js
person1['age']
person1.interests[1]
person1.bio()
// etc.
```

**注：** 如果您对这一部分有疑问， 尝试将您的代码与我们的版本做比较 —— 戳链接： [oojs-class-finished.html](https://github.com/mdn/learning-area/blob/master/javascript/oojs/introduction/oojs-class-finished.html) (或者： [查看它的实现](http://mdn.github.io/learning-area/javascript/oojs/introduction/oojs-class-further-exercises.html)).



## 创建对象的其他方式

到现在为止，我们了解到了两种不同的创建对象的方式 —— [声明一个对象的语法](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects/Basics#Object_basics)， 与使用构造函数(回顾上面)。

这些方法都是很有用的， 但仍有其他的方法 —— 我们希望您能熟悉这些，以免您在Web世界的旅行中碰到它们。

**Object()构造函数**

首先, 您能使用`Object()`构造函数来创建一个新对象。 是的， 一般对象都有构造函数，它创建了一个空的对象。

1. 尝试在您浏览器中的Javascript控制台中输入以下代码：

   ```js
   var person1 = new Object();
   ```

2. 这样就在

   ```
   person1
   ```

   变量中存储了一个空对象。然后, 可以根据需要, 使用点或括号表示法向此对象添加属性和方法；试试这个例子：

   ```js
   person1.name = 'Chris';
   person1['age'] = 38;
   person1.greeting = function() {
     alert('Hi! I\'m ' + this.name + '.');
   }
   ```

3. 还可以将对象文本传递给Object() 构造函数作为参数， 以便用属性/方法填充它。请尝试以下操作：

   ```js
   var person1 = new Object({
     name : 'Chris',
     age : 38,
     greeting : function() {
       alert('Hi! I\'m ' + this.name + '.');
     }
   });
   ```

### 使用create()方法

JavaScript有个内嵌的方法`create()`, 它允许您基于现有对象创建新的对象。

1. 在 JavaScript 控制台中尝试此操作：

   ```js
   var person2 = Object.create(person1);
   ```

2. 现在尝试这个：

   ```js
   person2.name
   person2.greeting()
   ```

您可以看到，person2是基于person1创建的， 它们具有相同的属性和方法。这非常有用， 因为它允许您创建新的对象而无需定义构造函数。缺点是比起构造函数，浏览器在更晚的时候才支持create()方法（IE9,  IE8 或甚至以前相比）， 加上一些人认为构造函数让您的代码看上去更整洁 —— 您可以在一个地方创建您的构造函数， 然后根据需要创建实例， 这让您能很清楚地知道它们来自哪里。

但是, 如果您不太担心对旧浏览器的支持， 并且您只需要一个对象的一些副本， 那么创建一个构造函数可能会让您的代码显得过度繁杂。这取决于您的个人爱好。有些人发现create() 更容易理解和使用。



## 总结

这篇文章简单地介绍了一些面向对象原理 —— 这些描述还不够完整， 但它让您知道我们在这里处理什么。此外， 我们已经开始研究 javascript与 "经典 OOP"的关联与区别， 如何使用构造函数实现 javascript 中的类， 以及生成对象的不同方法。

在下一篇文章中， 我们将探讨 JavaScript 对象原型



# 对象原型

通过原型这种机制，JavaScript 中的对象从其他对象继承功能特性；这种继承机制与经典的面向对象编程语言的继承机制不同。本文将探讨这些差别，解释原型链如何工作，并了解如何通过 `prototype` 属性向已有的构造器添加方法

| 预备知识: | 基本的计算机素养，对 HTML 和 CSS 有基本的理解，熟悉 JavaScript 基础（参见 [First steps](https://developer.mozilla.org/zh-CN/docs/Learn/JavaScript/First_steps) 和 [Building blocks](https://developer.mozilla.org/zh-CN/docs/Learn/JavaScript/Building_blocks)）以及面向对象的JavaScript (OOJS) 基础（参见 [Introduction to objects](https://developer.mozilla.org/zh-CN/docs/Learn/JavaScript/Object-oriented/Introduction)）。 |
| :-------- | ------------------------------------------------------------ |
| 目标:     | 理解 JavaScript 对象原型、原型链如何工作、如何向 `prototype` 属性添加新的方法。 |

## 基于原型的语言？

JavaScript 常被描述为一种**基于原型的语言 (prototype-based language)**——每个对象拥有一个**原型对象**，对象以其原型为模板、从原型继承方法和属性。原型对象也可能拥有原型，并从中继承方法和属性，一层一层、以此类推。这种关系常被称为**原型链 (prototype chain)**，它解释了为何一个对象会拥有定义在其他对象中的属性和方法。

准确地说，这些属性和方法定义在Object的构造器函数(constructor functions)之上的`prototype`属性上，而非对象实例本身。

在传统的 OOP 中，首先定义“类”，此后创建对象实例时，类中定义的所有属性和方法都被复制到实例中。在 JavaScript 中并不如此复制**而是在对象实例和它的构造器之间建立一个链接（它是__proto__属性，是从构造函数的`prototype`属性派生的），之后通过上溯原型链，在构造器中找到这些属性和方法**。

> **注意:** 理解对象的原型（可以通过`Object.getPrototypeOf(obj)`或者已被弃用的`__proto__`属性获得）与构造函数的`prototype`属性之间的区别是很重要的。前者是每个实例上都有的属性，后者是构造函数的属性。也就是说，`Object.getPrototypeOf(new Foobar())`和`Foobar.prototype`指向着同一个对象。

## 使用Javascript中的原型

在javascript中，函数可以有属性。 每个函数都有一个特殊的属性叫作`原型（prototype）` ，正如下面所展示的。请注意，下面的代码是独立的一段(在网页中没有其他代码的情况下，这段代码是安全的)。为了最好的学习体验，你最好打开一个控制台 (在Chrome和Firefox中，可以按Ctrl+Shift+I来打开)切换到"控制台" 选项卡, 复制粘贴下面的JavaScript代码，然后按回车来运行.

```js
function doSomething(){}
console.log( doSomething.prototype );
// It does not matter how you declare the function, a
//  function in javascript will always have a default
//  prototype property.
var doSomething = function(){}; 
console.log( doSomething.prototype );
```

正如上面所看到的, `doSomething` 函数有一个默认的原型属性，它在控制台上面呈现了出来. 运行这段代码之后，控制台上面应该出现了像这样的一个对象.

```js
{
    constructor: ƒ doSomething(),
    __proto__: {
        constructor: ƒ Object(),
        hasOwnProperty: ƒ hasOwnProperty(),
        isPrototypeOf: ƒ isPrototypeOf(),
        propertyIsEnumerable: ƒ propertyIsEnumerable(),
        toLocaleString: ƒ toLocaleString(),
        toString: ƒ toString(),
        valueOf: ƒ valueOf()
    }
}
```

现在，我们可以添加一些属性到 doSomething 的原型

```js
function doSomething(){}
doSomething.prototype.foo = "bar";
console.log( doSomething.prototype );
```

结果:

```js
{
    foo: "bar",
    constructor: ƒ doSomething(),
    __proto__: {
        constructor: ƒ Object(),
        hasOwnProperty: ƒ hasOwnProperty(),
        isPrototypeOf: ƒ isPrototypeOf(),
        propertyIsEnumerable: ƒ propertyIsEnumerable(),
        toLocaleString: ƒ toLocaleString(),
        toString: ƒ toString(),
        valueOf: ƒ valueOf()
    }
}
```

然后，我们可以使用 new 运算符来在现在的这个原型基础之上，创建一个 `doSomething` 的实例。正确使用 new 运算符的方法就是在正常调用函数时，在函数名的前面加上一个 `new` 前缀. 通过这种方法，在调用函数前加一个 `new` ，它就会返回一个这个函数的实例化对象. 然后，就可以在这个对象上面添加一些属性. 看.

```js
function doSomething(){}
doSomething.prototype.foo = "bar"; // add a property onto the prototype
var doSomeInstancing = new doSomething();
doSomeInstancing.prop = "some value"; // add a property onto the object
console.log( doSomeInstancing );
```

结果:

```js
{
    prop: "some value",
    __proto__: {
        foo: "bar",
        constructor: ƒ doSomething(),
        __proto__: {
            constructor: ƒ Object(),
            hasOwnProperty: ƒ hasOwnProperty(),
            isPrototypeOf: ƒ isPrototypeOf(),
            propertyIsEnumerable: ƒ propertyIsEnumerable(),
            toLocaleString: ƒ toLocaleString(),
            toString: ƒ toString(),
            valueOf: ƒ valueOf()
        }
    }
}
```

就像上面看到的, `doSomeInstancing` 的 `__proto__` 属性就是`doSomething.prototype`. 但是这又有什么用呢? 好吧,当你访问 `doSomeInstancing` 的一个属性, 浏览器首先查找 `doSomeInstancing` 是否有这个属性. 如果 `doSomeInstancing` 没有这个属性, 然后浏览器就会在 `doSomeInstancing` 的 `__proto__` 中查找这个属性(也就是 doSomething.prototype). 如果 doSomeInstancing 的 `__proto__` 有这个属性, 那么 doSomeInstancing 的 `__proto__` 上的这个属性就会被使用. 否则, 如果 doSomeInstancing 的 `__proto__` 没有这个属性, 浏览器就会去查找 doSomeInstancing 的 `__proto__` 的 `__proto__` ，看它是否有这个属性. 默认情况下, 所有函数的原型属性的 `__proto__` 就是 `window.Object.prototype`. 所以 doSomeInstancing 的 `__proto__` 的 `__proto__` (也就是 doSomething.prototype 的 `__proto__` (也就是 `Object.prototype`)) 会被查找是否有这个属性. 如果没有在它里面找到这个属性, 然后就会在 doSomeInstancing 的 `__proto__` 的 `__proto__` 的 `__proto__` 里面查找. 然而这有一个问题: doSomeInstancing 的 `__proto__` 的 `__proto__` 的 `__proto__` 不存在. 最后, 原型链上面的所有的 `__proto__` 都被找完了, 浏览器所有已经声明了的 `__proto__` 上都不存在这个属性，然后就得出结论，这个属性是 `undefined`.

```js
function doSomething(){}
doSomething.prototype.foo = "bar";
var doSomeInstancing = new doSomething();
doSomeInstancing.prop = "some value";
console.log("doSomeInstancing.prop:      " + doSomeInstancing.prop);
console.log("doSomeInstancing.foo:       " + doSomeInstancing.foo);
console.log("doSomething.prop:           " + doSomething.prop);
console.log("doSomething.foo:            " + doSomething.foo);
console.log("doSomething.prototype.prop: " + doSomething.prototype.prop);
console.log("doSomething.prototype.foo:  " + doSomething.prototype.foo);
```

结果:

```js
doSomeInstancing.prop:      some value
doSomeInstancing.foo:       bar
doSomething.prop:           undefined
doSomething.foo:            undefined
doSomething.prototype.prop: undefined
doSomething.prototype.foo:  bar
```

## 理解原型对象

让我们回到 `Person()` 构造器的例子。请把这个例子载入浏览器。如果你还没有看完上一篇文章并写好这个例子，也可以使用 [oojs-class-further-exercises.html](http://mdn.github.io/learning-area/javascript/oojs/introduction/oojs-class-further-exercises.html) 中的例子（亦可参考[源代码](https://github.com/mdn/learning-area/blob/master/javascript/oojs/introduction/oojs-class-further-exercises.html)）。

本例中我们将定义一个构造器函数：

```js
function Person(first, last, age, gender, interests) {
  
  // 属性与方法定义
  
};
```

然后创建一个对象实例：

```js
var person1 = new Person('Bob', 'Smith', 32, 'male', ['music', 'skiing']);
```

在 JavaScript 控制台输入 "`person1.`"，你会看到，浏览器将根据这个对象的可用的成员名称进行自动补全：

![](https://mdn.mozillademos.org/files/13853/object-available-members.png)

在这个列表中，你可以看到定义在 `person1` 的原型对象、即 `Person()` 构造器中的成员—— `name`、`age`、`gender`、`interests`、`bio`、`greeting`。同时也有一些其他成员—— `watch`、`valueOf` 等等——这些成员定义在 `Person()` 构造器的原型对象、即 `Object` 之上。下图展示了原型链的运作机制。

![](https://mdn.mozillademos.org/files/13891/MDN-Graphics-person-person-object-2.png)

那么，调用 `person1` 的“实际定义在 `Object` 上”的方法时，会发生什么？比如：

```js
person1.valueOf()
```

这个方法仅仅返回了被调用对象的值。在这个例子中发生了如下过程：

- 浏览器首先检查，`person1` 对象是否具有可用的 `valueOf()` 方法。
- 如果没有，则浏览器检查 `person1` 对象的原型对象（即 `Person`构造函数的prototype属性所指向的对象）是否具有可用的 `valueof()` 方法。
- 如果也没有，则浏览器检查 `Person()` 构造函数的prototype属性所指向的对象的原型对象（即 `Object`构造函数的prototype属性所指向的对象）是否具有可用的 `valueOf()` 方法。这里有这个方法，于是该方法被调用。

> **注意**：必须重申，原型链中的方法和属性**没有**被复制到其他对象——它们被访问需要通过前面所说的“原型链”的方式。

> **注意**：没有官方的方法用于直接访问一个对象的原型对象——原型链中的“连接”被定义在一个内部属性中，在 JavaScript 语言标准中用 `[[prototype]]` 表示（参见 [ECMAScript](https://developer.mozilla.org/zh-CN/docs/Glossary/ECMAScript)）。然而，大多数现代浏览器还是提供了一个名为 `__proto__` （前后各有2个下划线）的属性，其包含了对象的原型。你可以尝试输入 `person1.__proto__` 和 `person1.__proto__.__proto__`，看看代码中的原型链是什么样的！

## prototype 属性：继承成员被定义的地方

那么，那些继承的属性和方法在哪儿定义呢？如果你查看 `Object` 参考页，会发现左侧列出许多属性和方法——大大超过我们在 `person1` 对象中看到的继承成员的数量。某些属性或方法被继承了，而另一些没有——为什么呢？

原因在于，**继承的属性和方法是定义在 `prototype` 属性之上的**（你可以称之为子命名空间 (sub namespace) ）——那些以 `Object.prototype.` 开头的属性，而非仅仅以 `Object.` 开头的属性。`prototype` 属性的值是一个对象，我们希望被原型链下游的对象继承的属性和方法，都被储存在其中。

于是 `Object.prototype.watch()、``Object.prototype.valueOf()` 等等成员，适用于任何继承自 `Object()` 的对象类型，包括使用构造器创建的新的对象实例。

`Object.is()`、`Object.keys()`，以及其他不在 `prototype` 对象内的成员，不会被“对象实例”或“继承自 `Object()` 的对象类型”所继承。这些方法/属性仅能被 `Object()` 构造器自身使用。

> **注意**：这看起来很奇怪——构造器本身就是函数，你怎么可能在构造器这个函数中定义一个方法呢？其实函数也是一个对象类型，你可以查阅 `Function()` 构造器的参考文档以确认这一点。

1. 你可以检查已有的

    

   ```
   prototype
   ```

    

   属性。回到先前的例子，在 JavaScript 控制台输入：

   ```js
   Person.prototype
   ```

2. 输出并不多，毕竟我们没有为自定义构造器的原型定义任何成员。缺省状态下，构造器的

    

   ```
   prototype
   ```

    

   属性初始为空白。现在尝试：

   ```js
   Object.prototype
   ```

你会看到 `Object` 的 `prototype` 属性上定义了大量的方法；如前所示，继承自 `Object` 的对象都可以使用这些方法。

JavaScript 中到处都是通过原型链继承的例子。比如，你可以尝试从 `String`、`Date`、`Number` 和 `Array` 全局对象的原型中寻找方法和属性。它们都在原型上定义了一些方法，因此当你创建一个字符串时：

```js
var myString = 'This is my string.';
```

`myString` 立即具有了一些有用的方法，如 `split()`、`indexOf()`、`replace()` 等。

> **重要**：`prototype` 属性大概是 JavaScript 中最容易混淆的名称之一。你可能会认为，`this` 关键字指向当前对象的原型对象，其实不是（还记得么？原型对象是一个内部对象，应当使用` __proto__` 访问）。`prototype` 属性包含（指向）一个对象，你在这个对象中定义需要被继承的成员。

**create()**

我们曾经讲过如何用 `Object.create()` 方法创建新的对象实例。

1. 例如，在上个例子的 JavaScript 控制台中输入：

   ```js
   var person2 = Object.create(person1);
   ```

2. create()实际做的是从指定原型对象创建一个新的对象。这里以person1为原型对象创建了

   对象。在控制台输入：

   ```js
   person2.__proto__
   ```

结果返回对象`person1`。

## constructor 属性

每个实例对象都从原型中继承了一个constructor属性，该属性指向了用于构造此实例对象的构造函数。

 例如，在控制台中尝试下面的指令：

```js
person1.constructor
person2.constructor
```

1. 都将返回 `Person()` 构造器，因为该构造器包含这些实例的原始定义。

   一个小技巧是，你可以在 `constructor` 属性的末尾添加一对圆括号（括号中包含所需的参数），从而用这个构造器创建另一个对象实例。毕竟构造器是一个函数，故可以通过圆括号调用；只需在前面添加 `new` 关键字，便能将此函数作为构造器使用。

2. 在控制台中输入：

   ```js
   var person3 = new person1.constructor('Karen', 'Stephenson', 26, 'female', ['playing drums', 'mountain climbing']);
   ```

3. 现在尝试访问新建对象的属性，例如：

```js
person3.name.first
person3.age
person3.bio()
```

正常工作。通常你不会去用这种方法创建新的实例；但如果你刚好因为某些原因没有原始构造器的引用，那么这种方法就很有用了

此外，`constructor` 属性还有其他用途。比如，想要获得某个对象实例的构造器的名字，可以这么用：

```js
instanceName.constructor.name
```

具体地，像这样：

```js
person1.constructor.name
```

## 修改原型

从我们从下面这个例子来看一下如何修改构造器的 `prototype` 属性。

1. 回到oojs-class-further-exercises.html的例子，在本地为源代码

   创建一个副本。在已有的 JavaScript 的末尾添加如下代码，这段代码将为构造器的prototype属性添加一个新的方法：

   ```js
   Person.prototype.farewell = function() {
     alert(this.name.first + ' has left the building. Bye for now!');
   }
   ```

2. 保存代码，在浏览器中加载页面，然后在控制台输入：

   ```js
   person1.farewell();
   ```

你会看到一条警告信息，其中还显示了构造器中定义的人名；这很有用。但更关键的是，整条继承链动态地更新了，任何由此构造器创建的对象实例都自动获得了这个方法。

再想一想这个过程。我们的代码中定义了构造器，然后用这个构造器创建了一个对象实例，*此后*向构造器的 `prototype` 添加了一个新的方法：

```js
function Person(first, last, age, gender, interests) {

  // 属性与方法定义

};

var person1 = new Person('Tammi', 'Smith', 32, 'neutral', ['music', 'skiing', 'kickboxing']);

Person.prototype.farewell = function() {
  alert(this.name.first + ' has left the building. Bye for now!');
}
```

但是 `farewell()` 方法*仍然*可用于 `person1` 对象实例——旧有对象实例的可用功能被自动更新了。这证明了先前描述的原型链模型。这种继承模型下，上游对象的方法不会复制到下游的对象实例中；下游对象本身虽然没有定义这些方法，但浏览器会通过上溯原型链、从上游对象中找到它们。这种继承模型提供了一个强大而可扩展的功能系统。

> **注意**：如果运行样例时遇到问题，请参阅 [oojs-class-prototype.html](https://github.com/mdn/learning-area/blob/master/javascript/oojs/advanced/oojs-class-prototype.html) 样例（也可查看[即时运行](http://mdn.github.io/learning-area/javascript/oojs/advanced/oojs-class-prototype.html)）。

你很少看到属性定义在 prototype 属性中，因为如此定义不够灵活。比如，你可以添加一个属性：

```js
Person.prototype.fullName = 'Bob Smith';
```

但这不够灵活，因为人们可能不叫这个名字。用 `name.first` 和 `name.last` 组成 `fullName` 会好很多：

```js
Person.prototype.fullName = this.name.first + ' ' + this.name.last;
```

然而，这么做是无效的，因为本例中 `this` 引用全局范围，而非函数范围。访问这个属性只会得到 `undefined undefined`。但这个语句若放在 先前定义在 `prototype` 上的方法中则有效，因为此时语句位于函数范围内，从而能够成功地转换为对象实例范围。你可能会在 `prototype` 上定义常属性 (constant property) （指那些你永远无需改变的属性），但一般来说，在构造器内定义属性更好。

> **译者注**：关于 `this` 关键字指代（引用）什么范围/哪个对象，这个问题超出了本文讨论范围。事实上，这个问题有点复杂，如果现在你没能理解，也不用担心。

事实上，一种极其常见的对象定义模式是，在构造器（函数体）中定义属性、在 `prototype` 属性上定义方法。如此，构造器只包含属性定义，而方法则分装在不同的代码块，代码更具可读性。例如：

```js
// 构造器及其属性定义

function Test(a,b,c,d) {
  // 属性定义
};

// 定义第一个方法

Test.prototype.x = function () { ... }

// 定义第二个方法

Test.prototype.y = function () { ... }

// 等等……
```

在 Piotr Zalewa 的 [school plan app](https://github.com/zalun/school-plan-app/blob/master/stage9/js/index.js) 样例中可以看到这种模式。

## 总结

本文介绍了 JavaScript 对象原型，包括原型链如何允许对象之间继承特性、`prototype` 属性、如何通过它来向构造器添加方法，以及其他有关主题。

下一篇文章中，我们将了解如何在两个自定义的对象间实现功能的继承。







# Web API简介

应用程序接口（API）是基于编程语言构建的结构，使开发人员更容易地创建复杂的功能。它们抽象了复杂的代码，并提供一些简单的接口规则直接使用。

来看一个现实世界中的例子：想想您的房子、公寓或其他住宅的电力供应，如果您想在您的房子里使用一个设备，只要把电源插头插入插座即可，而不会直接把它连接到进户的电线上 - 这样做非常低效，而且如果您不是电工，这么做将是困难和危险的。

![](https://mdn.mozillademos.org/files/14317/plug-socket.png)

同样，比如说，编程来显示一些3D图形，使用以更高级语言编写的API（例如JavaScript或Python）将会比直接编写直接控制计算机的GPU或其他图形功能的低级代码（比如C或C++）来执行操作要容易得多。

**注：**详细说明请见[API - Glossary](https://developer.mozilla.org/en-US/docs/Glossary/API)。

### 客户端JavaScript中的API

客户端JavaScript中有很多可用的API — 他们本身并不是JavaScript语言的一部分，却建立在JavaScript语言核心的顶部，为使用JavaScript代码提供额外的超强能力。他们通常分为两类：

- **浏览器API**内置于Web浏览器中，能从浏览器和电脑周边环境中提取数据，并用来做有用的复杂的事情 。例如[Geolocation API](https://developer.mozilla.org/en-US/docs/Web/API/Geolocation/Using_geolocation)提供了一些简单的JavaScript结构以获得位置数据，因此您可以在Google地图上标示您的位置。在后台，浏览器确实使用一些复杂的低级代码（例如C++）与设备的GPS硬件（或可以决定位置数据的任何设施）通信来获取位置数据并把这些数据返回给您的代码中使用浏览器环境；但是，这种复杂性通过API抽象出来，因而与您无关。
- **第三方API**缺省情况下不会内置于浏览器中，通常必须在Web中的某个地方获取代码和信息。例如[Twitter API](https://dev.twitter.com/overview/documentation) 使您能做一些显示最新推文这样的事情，它提供一系列特殊的结构，可以用来请求Twitter服务并返回特殊的信息。

 ![](https://mdn.mozillademos.org/files/13508/browser.png)

### JavaScript，API和其他JavaScript工具之间的关系

如上所述，我们讨论了什么是客户端JavaScript API，以及它们与JavaScript语言的关系。让我们回顾一下，使其更清晰，并提及其他JavaScript工具的适用位置：

- JavaScript — 一种内置于浏览器的高级脚本语言，您可以用来实现Web页面/应用中的功能。注意JavaScript也可用于其他象[Node](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Express_Nodejs/Introduction)这样的的编程环境。但现在您不必考虑这些。
- 客户端API — 内置于浏览器的结构程序，位于JavaScript语言顶部，使您可以更容易的实现功能。
- 第三方API — 置于第三方普通的结构程序（例如Twitter，Facebook），使您可以在自己的Web页面中使用那些平台的某些功能（例如在您的Web页面显示最新的Tweets）。
- JavaScript库 — 通常是包含具有[特定功能](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Building_blocks/Functions#Custom_functions)的一个或多个JavaScript文件，把这些文件关联到您的Web页以快速或授权编写常见的功能。例如包含jQuery和Mootools
- JavaScript框架 — 从库开始的下一步，JavaScript框架视图把HTML、CSS、JavaScript和其他安装的技术打包在一起，然后用来从头编写一个完整的Web应用。

## API可以做什么？

在主流浏览器中有大量的可用API，您可以在代码中做许多的事情，对此可以查看[MDN API index page](https://developer.mozilla.org/en-US/docs/Web/API)。

### 常见浏览器API

特别地，您将使用的最常见的浏览器API类别（以及我们将更详细地介绍的）是：

- **操作文档的API**内置于浏览器中。最明显的例子是[DOM（文档对象模型）](https://developer.mozilla.org/zh-CN/docs/Web/API/Document_Object_Model)API，它允许您操作HTML和CSS — 创建、移除以及修改HTML，动态地将新样式应用到您的页面，等等。每当您看到一个弹出窗口出现在一个页面上，或者显示一些新的内容时，这都是DOM的行为。 您可以在在[Manipulating documents](https://developer.mozilla.org/zh-CN/docs/Learn/JavaScript/Client-side_web_APIs/Manipulating_documents)中找到关于这些类型的API的更多信息。
- **从服务器获取数据的API** 用于更新网页的一小部分是相当好用的。这个看似很小的细节能对网站的性能和行为产生巨大的影响 — 如果您只是更新一个股票列表或者一些可用的新故事而不需要从服务器重新加载整个页面将使网站或应用程序感觉更加敏感和“活泼”。使这成为可能的API包括[`XMLHttpRequest`](https://developer.mozilla.org/zh-CN/docs/Web/API/XMLHttpRequest)和[Fetch API](https://developer.mozilla.org/zh-CN/docs/Web/API/Fetch_API)。您也可能会遇到描述这种技术的术语**Ajax**。您可以在[Fetching data from the server](https://developer.mozilla.org/zh-CN/docs/Learn/JavaScript/Client-side_web_APIs/Fetching_data)找到关于类似的API的更多信息。
- **用于绘制和操作图形的API**目前已被浏览器广泛支持 — 最流行的是允许您以编程方式更新包含在HTML [``](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/canvas) 元素中的像素数据以创建2D和3D场景的[Canvas](https://developer.mozilla.org/en-US/docs/Web/API/Canvas_API)和[WebGL](https://developer.mozilla.org/en-US/docs/Web/API/WebGL_API)。例如，您可以绘制矩形或圆形等形状，将图像导入到画布上，然后使用Canvas API对其应用滤镜（如棕褐色滤镜或灰度滤镜），或使用WebGL创建具有光照和纹理的复杂3D场景。这些API经常与用于创建动画循环的API（例如[`window.requestAnimationFrame()`](https://developer.mozilla.org/zh-CN/docs/Web/API/Window/requestAnimationFrame)）和其他API一起不断更新诸如动画和游戏之类的场景。
- **音频和视频API**例如[`HTMLMediaElement`](https://developer.mozilla.org/zh-CN/docs/Web/API/HTMLMediaElement)，[Web Audio API](https://developer.mozilla.org/zh-CN/docs/Web/API/Web_Audio_API)和[WebRTC](https://developer.mozilla.org/zh-CN/docs/MDN/Doc_status/API/WebRTC)允许您使用多媒体来做一些非常有趣的事情，比如创建用于播放音频和视频的自定义UI控件，显示字幕字幕和您的视频，从网络摄像机抓取视频，通过画布操纵（见上），或在网络会议中显示在别人的电脑上，或者添加效果到音轨（如增益，失真，平移等） 。
- **设备API**基本上是以对网络应用程序有用的方式操作和检索现代设备硬件中的数据的API。我们已经讨论过访问设备位置数据的地理定位API，因此您可以在地图上标注您的位置。其他示例还包括通过系统通知（参见[Notifications API](https://developer.mozilla.org/zh-CN/docs/Web/API/Notifications_API)）或振动硬件（参见[Vibration API](https://developer.mozilla.org/zh-CN/docs/Web/API/Vibration_API)）告诉用户Web应用程序有用的更新可用。
- **客户端存储API**在Web浏览器中的使用变得越来越普遍 - 如果您想创建一个应用程序来保存页面加载之间的状态，甚至让设备在处于脱机状态时可用，那么在客户端存储数据将会是非常有用的。例如使用[Web Storage API](https://developer.mozilla.org/zh-CN/docs/Web/API/Web_Storage_API)的简单的键 - 值存储以及使用[IndexedDB API](https://developer.mozilla.org/zh-CN/docs/Web/API/IndexedDB_API)的更复杂的表格数据存储。

### 常见第三方API

第三方API种类繁多; 下列是一些比较流行的你可能迟早会用到的第三方API:

- The [Twitter API](https://dev.twitter.com/overview/documentation), 允许您在您的网站上展示您最近的推文等。
- The [Google Maps API](https://developers.google.com/maps/) 允许你在网页上对地图进行很多操作（这很有趣，它也是Google地图的驱动器）。现在它是一整套完整的，能够胜任广泛任务的API。其能力已经被[Google Maps API Picker](https://developers.google.com/maps/documentation/api-picker)见证。
- The [Facebook suite of API](https://developers.facebook.com/docs/) 允许你将很多Facebook生态系统中的功能应用到你的app，使之受益，比如说它提供了通过Facebook账户登录、接受应用内支付、推送有针对性的广告活动等功能。
- The [YouTube API](https://developers.google.com/youtube/), 允许你将Youtube上的视频嵌入到网站中去，同时提供搜索Youtube，创建播放列表等众多功能。
- The [Twilio API](https://www.twilio.com/), 其为您的app提供了针对语音通话和视频聊天的框架，以及从您的app发送短信息或多媒体信息等诸多功能。

**注**: 你可以在 [Programmable Web API directory](http://www.programmableweb.com/category/all/apis).上发现更多关于第三方API的信息。

## API如何工作？

不同的JavaScript API以稍微不同的方式工作，但通常它们具有共同的特征和相似的主题。

###  它们是基于对象的

API使用一个或多个 [JavaScript objects](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects) 在您的代码中进行交互，这些对象用作API使用的数据（包含在对象属性中）的容器以及API提供的功能（包含在对象方法中）。

>  注意：如果您不熟悉对象如何工作，则应继续学习 [JavaScript objects](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects) 模块。

让我们回到Geolocation API的例子 - 这是一个非常简单的API，由几个简单的对象组成：

- [`Geolocation`](https://developer.mozilla.org/zh-CN/docs/Web/API/Geolocation), 其中包含三种控制地理数据检索的方法
- [`Position`](https://developer.mozilla.org/zh-CN/docs/Web/API/Position), 表示在给定的时间的相关设备的位置。 — 它包含一个当前位置的 [`Coordinates`](https://developer.mozilla.org/zh-CN/docs/Web/API/Coordinates) 对象。还包含了一个时间戳,这个时间戳表示获取到位置的时间。
- [`Coordinates`](https://developer.mozilla.org/zh-CN/docs/Web/API/Coordinates), 其中包含有关设备位置的大量有用数据，包括经纬度，高度，运动速度和运动方向等。

```js
navigator.geolocation.getCurrentPosition(function(position) {
  var latlng = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
  var myOptions = {
    zoom: 8,
    center: latlng,
    mapTypeId: google.maps.MapTypeId.TERRAIN,
    disableDefaultUI: true
  }
  var map = new google.maps.Map(document.querySelector("#map_canvas"), myOptions);
});
```

> **Note**: 当您第一次加载上述实例，应当出现一个对话框询问您是否乐意对此应用共享位置信息（参见 [They have additional security mechanisms where appropriate](https://developer.mozilla.org/zh-CN/docs/Learn/JavaScript/Client-side_web_APIs/Introduction#They_have_additional_security_mechanisms_where_appropriate) 这一稍后将会提到的部分）。 您需要同意这项询问以将您的位置于地图上绘制。如果您始终无法看见地图，您可能需要手动修改许可项。修改许可项的方法取决于您使用何种浏览器，对于Firefox浏览器来说，在页面信息 > 权限 中修改位置权限，在Chrome浏览器中则进入 设置 > 隐私 > 显示高级设置 > 内容设置，其后修改位置设定。

我们首先要使用 [`Geolocation.getCurrentPosition()`](https://developer.mozilla.org/zh-CN/docs/Web/API/Geolocation/getCurrentPosition) 方法返回设备的当前位置。浏览器的 [`Geolocation`](https://developer.mozilla.org/zh-CN/docs/Web/API/Geolocation) 对象通过调用 [`Navigator.geolocation`](https://developer.mozilla.org/zh-CN/docs/Web/API/Navigator/geolocation) 属性来访问.

```js
navigator.geolocation.getCurrentPosition(function(position) { ... });
```

这相当于做同样的事情

```js
var myGeo = navigator.geolocation;
myGeo.getCurrentPosition(function(position) { ... });
```

但是我们可以使用 "点运算符" 将我们的属性和方法的访问链接在一起，减少了我们必须写的行数。

[`Geolocation.getCurrentPosition()`](https://developer.mozilla.org/zh-CN/docs/Web/API/Geolocation/getCurrentPosition) 方法只有一个必须的参数，这个参数是一个匿名函数，当设备的当前位置被成功取到时，这个函数会运行。  这个函数本身有一个参数，它包含一个表示当前位置数据的 [`Position`](https://developer.mozilla.org/zh-CN/docs/Web/API/Position) 对象。

**注意：由另一个函数作为参数的函数称为** ([callback function](https://developer.mozilla.org/en-US/docs/Glossary/Callback_function) "回调函数").

仅在操作完成时调用函数的模式在JavaScript API中非常常见 - 确保一个操作已经完成，然后在另一个操作中尝试使用该操作返回的数据。这些被称为 **[asynchronous](https://developer.mozilla.org/en-US/docs/Glossary/Asynchronous)** “异步”操作。由于获取设备的当前位置依赖于外部组件（设备的GPS或其他地理定位硬件）， 我们不能保证会立即使用返回的数据。 因此，这样子是行不通的：

```js
var position = navigator.geolocation.getCurrentPosition();
var myLatitude = position.coords.latitude;
```

如果第一行还没有返回结果，则第二行将会出现错误，因为位置数据还不可用。 出于这个原因，涉及同步操作的API被设计为使用 [callback function](https://developer.mozilla.org/zh-CN/docs/Glossary/Callback_function)s “回调函数”，或更现代的 [Promises](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise) 系统，这些系统在ECMAScript 6中可用，并被广泛用于较新的API。

我们将Geolocation API与第三方API（Google Maps API）相结合， — 我们正在使用它来绘制Google地图上由 `getCurrentPosition()`返回的位置。 我们通过链接到页面上使这个API可用。 — 你会在HTML中找到这一行：

```html
<script type="text/javascript" src="https://maps.google.com/maps/API/js?key=AIzaSyDDuGt0E5IEGkcE6ZfrKfUtE9Ko_de66pA"></script>
```

要使用该API, 我们首先使用`google.maps.LatLng()`构造函数创建一个`LatLng`对象实例， 该构造函数需要我们的地理定位 [`Coordinates.latitude`](https://developer.mozilla.org/zh-CN/docs/Web/API/Coordinates/latitude) 和 [`Coordinates.longitude`](https://developer.mozilla.org/zh-CN/docs/Web/API/Coordinates/longitude)值作为参数：

```js
var latlng = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
```

该对象实例被设置为 `myOptions`对象的`center`属性的值。然后我们通过调用`google.maps.Map()`构造函数创建一个对象实例来表示我们的地图， 并传递它两个参数 — 一个参数是我们要渲染地图的 [``](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/div) 元素的引用 (ID为 `map_canvas`), 以及另一个参数是我们在上面定义的`myOptions`对象

```js
var myOptions = {
  zoom: 8,
  center: latlng,
  mapTypeId: google.maps.MapTypeId.TERRAIN,
  disableDefaultUI: true
}

var map = new google.maps.Map(document.querySelector("#map_canvas"), myOptions);
```

这样做一来，我们的地图呈现了。

最后一块代码突出显示了您将在许多API中看到的两种常见模式。 首先，API对象通常包含构造函数，可以调用这些构造函数来创建用于编写程序的对象的实例。 其次，API对象通常有几个可用的options(如上面的`myOptions`对象)，可以调整以获得您的程序所需的确切环境(根据不同的环境,编写不同的`Options`对象)。 API构造函数通常接受options对象作为参数，这是您设置这些options的地方。

**注意：如果您不能立即理解这个例子的细节，请不要担心。 我们将在未来的文章中详细介绍第三方API。**

### 它们有可识别的入口点

使用API时，应确保知道API入口点的位置。 在Geolocation API中，这非常简单 - 它是 [`Navigator.geolocation`](https://developer.mozilla.org/zh-CN/docs/Web/API/Navigator/geolocation) 属性, 它返回浏览器的 [`Geolocation`](https://developer.mozilla.org/zh-CN/docs/Web/API/Geolocation) 对象，所有有用的地理定位方法都可用。

文档对象模型 (DOM) API有一个更简单的入口点 —它的功能往往被发现挂在 [`Document`](https://developer.mozilla.org/zh-CN/docs/Web/API/Document) 对象, 或任何你想影响的HTML元素的实例，例如：

```js
var em = document.createElement('em'); // create a new em element
var para = document.querySelector('p'); // reference an existing p element
em.textContent = 'Hello there!'; // give em some text content
para.appendChild(em); // embed em inside para
```

其他API具有稍微复杂的入口点，通常涉及为要编写的API代码创建特定的上下文。例如，Canvas API的上下文对象是通过获取要绘制的 [<canvas>](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/canvas) 元素的引用来创建的，然后调用它的[`HTMLCanvasElement.getContext()`](https://developer.mozilla.org/zh-CN/docs/Web/API/HTMLCanvasElement/getContext)方法：

```js
var canvas = document.querySelector('canvas');
var ctx = canvas.getContext('2d');
```

然后，我们想通过调用内容对象 (它是[`CanvasRenderingContext2D`](https://developer.mozilla.org/zh-CN/docs/Web/API/CanvasRenderingContext2D)的一个实例)的属性和方法来实现我们想要对画布进行的任何操作, 例如：

```js
Ball.prototype.draw = function() {
  ctx.beginPath();
  ctx.fillStyle = this.color;
  ctx.arc(this.x, this.y, this.size, 0, 2 * Math.PI);
  ctx.fill();
};
```

**注意**：您可以在我们的[弹跳球演示中](https://github.com/mdn/learning-area/blob/master/javascript/apis/introduction/bouncing-balls.html)看到此代码的实际 [运行情况](http://mdn.github.io/learning-area/javascript/apis/introduction/bouncing-balls.html) （ 也可以参阅它 [现场运行](http://mdn.github.io/learning-area/javascript/apis/introduction/bouncing-balls.html)）。

### 它们使用事件来处理状态的

我们之前已经在课程中讨论了事件，在我们的 [事件介绍](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Building_blocks/Events)文章中 - 详细介绍了客户端Web事件是什么以及它们在代码中的用法。如果您还不熟悉客户端Web API事件的工作方式，则应继续阅读。

一些Web API不包含事件，但有些包含一些事件。当事件触发时，允许我们运行函数的处理程序属性通常在单独的 “Event handlers”(事件处理程序) 部分的参考资料中列出。作为一个简单的例子，`XMLHttpRequest` 对象的实例 （每一个实例都代表一个到服务器的HTTP请求,来取得某种新的资源）都有很多事件可用，例如 `onload` 事件在成功返回时就触发包含请求的资源，并且现在就可用。

下面的代码提供了一个简单的例子来说明如何使用它：

```js
var requestURL = 'https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json';
var request = new XMLHttpRequest();
request.open('GET', requestURL);
request.responseType = 'json';
request.send();

request.onload = function() {
  var superHeroes = request.response;
  populateHeader(superHeroes);
  showHeroes(superHeroes);
}
```

**注意：您可以在我们的**[ajax.html](https://github.com/mdn/learning-area/blob/master/javascript/apis/introduction/ajax.html)**示例中看到此代码** (或者 在线运行版本 [see it live](http://mdn.github.io/learning-area/javascript/apis/introduction/ajax.html) also).

前五行指定了我们要获取的资源的位置，使用`XMLHttpRequest()` 构造函数创建请求对象的新实例 ，打开HTTP 的 `GET` 请求以取得指定资源，指定响应以JSON格式发送，然后发送请求。

然后 `onload` 处理函数指定我们如何处理响应。 我们知道请求会成功返回，并在需要加载事件（如`onload` 事件）之后可用（除非发生错误），所以我们将包含返回的JSON的响应保存在`superHeroes`变量中，然后将其传递给两个不同的函数以供进一步处理。

### 它们在适当的地方有额外的安全机制

WebAPI功能受到与JavaScript和其他Web技术（例如[同源政策](https://developer.mozilla.org/en-US/docs/Web/Security/Same-origin_policy)）相同的安全考虑 但是他们有时会有额外的安全机制。例如，一些更现代的WebAPI将只能在通过HTTPS提供的页面上工作，因为它们正在传输潜在的敏感数据（例如 [服务工作者](https://developer.mozilla.org/en-US/docs/Web/API/Service_Worker_API) 和 [推送](https://developer.mozilla.org/en-US/docs/Web/API/Push_API)）。

另外，一旦调用WebAPI请求，用户就可以在您的代码中启用一些WebAPI请求权限。作为一个例子，在加载我们之前的[Geolocation](https://developer.mozilla.org/en-US/docs/Web/API/Geolocation) 示例时，您可能注意到了类似下面的对话框 ：

WebAPI功能受到与JavaScript和其他Web技术（例如[同源政策](https://developer.mozilla.org/en-US/docs/Web/Security/Same-origin_policy)）相同的安全考虑 但是他们有时会有额外的安全机制。例如，一些更现代的WebAPI将只能在通过HTTPS提供的页面上工作，因为它们正在传输潜在的敏感数据（例如 [服务工作者](https://developer.mozilla.org/en-US/docs/Web/API/Service_Worker_API) 和 [推送](https://developer.mozilla.org/en-US/docs/Web/API/Push_API)）。

另外，一旦调用WebAPI请求，用户就可以在您的代码中启用一些WebAPI请求权限。作为一个例子，在加载我们之前的[Geolocation](https://developer.mozilla.org/en-US/docs/Web/API/Geolocation) 示例时，您可能注意到了类似下面的对话框 ：

![img](https://mdn.mozillademos.org/files/14313/location-permission.png)

该 [通知API](https://developer.mozilla.org/en-US/docs/Web/API/Notifications_API) 请求以类似的方式许可：

![img](https://mdn.mozillademos.org/files/14315/notification-permission.png)

这些许可提示会被提供给用户以确保安全 - 如果这些提示不在适当位置，那么网站可能会在您不知情的情况下开始秘密跟踪您的位置，或者通过大量恼人的通知向您发送垃圾邮件。