# this

A **function's `this` keyword** behaves a little differently in JavaScript compared to other languages. It also has some differences between [strict mode](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Strict_mode) and non-strict mode.

In most cases, the value of `this` is determined by how a function is called (runtime binding). It can't be set by assignment during execution, and it may be different each time the function is called. ES5 introduced the [`bind()`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Function/bind) method to [set the value of a function's `this` regardless of how it's called](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/this#The_bind_method), and ES2015 introduced [arrow functions](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions) which don't provide their own `this` binding (it retains the `this` value of the enclosing lexical context).

<iframe class="interactive interactive-js" frameborder="0" height="250" src="https://interactive-examples.mdn.mozilla.net/pages/js/expressions-this.html" title="MDN Web Docs Interactive Example" width="100%" style="margin: 0px; padding: 10px; border: 1px solid rgb(234, 242, 244); max-width: 100%; box-sizing: border-box; background-color: rgb(245, 249, 250); color: rgb(51, 51, 51); height: 490px; width: 1014px;"></iframe>

## Syntax

```js
this
```

### Value

A property of an execution context (global, function or eval) that, in non–strict mode, is always a reference to an object and in strict mode can be any value.

## Description

### Global context

In the global execution context (outside of any function), `this` refers to the global object whether in strict mode or not.

```js
// In web browsers, the window object is also the global object:
console.log(this === window); // true

a = 37;
console.log(window.a); // 37

this.b = "MDN";
console.log(window.b)  // "MDN"
console.log(b)         // "MDN"
```

> **Note:** You can always easily get the global object using the global [`globalThis`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/globalThis) property, regardless of the current context in which your code is running.

### Function context

Inside a function, the value of `this` depends on how the function is called.

Since the following code is not in [strict mode](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Strict_mode), and because the value of `this` is not set by the call, `this` will default to the global object, which is [`window`](https://developer.mozilla.org/en-US/docs/Web/API/Window) in a browser.

```js
function f1() {
  return this;
}

// In a browser:
f1() === window; // true

// In Node:
f1() === globalThis; // true
```

In strict mode, however, if the value of `this` is not set when entering an execution context, it remains as `undefined`, as shown in the following example:

```js
function f2() {
  'use strict'; // see strict mode
  return this;
}

f2() === undefined; // true
```

> In the second example, `this` should be [`undefined`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/undefined), because `f2` was called directly and not as a method or property of an object (e.g. `window.f2()`). This feature wasn't implemented in some browsers when they first started to support [strict mode](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Strict_mode). As a result, they incorrectly returned the `window` object.

To set the value of `this` to a particular value when calling a function, use [`call()`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Function/call), or [`apply()`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Function/apply) as in the examples below.

### Class context

The behavior of `this` in [classes](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Classes) and functions is similar, since classes are functions under the hood. But there are some differences and caveats.

Within a class constructor, `this` is a regular object. All non-static methods within the class are added to the prototype of `this`:

```js
class Example {
  constructor() {
    const proto = Object.getPrototypeOf(this);
    console.log(Object.getOwnPropertyNames(proto));
  }
  first(){}
  second(){}
  static third(){}
}

new Example(); // ['constructor', 'first', 'second']
```

**Note:** Static methods are not properties of `this`. They are properties of the class itself.

### Derived classes