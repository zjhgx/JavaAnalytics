# Style Guide

This is the official style guide for Vue-specific code. If you use Vue in a project, it’s a great reference to avoid errors, bikeshedding, and anti-patterns. However, we don’t believe that any style guide is ideal for all teams or projects, so mindful deviations are encouraged based on past experience, the surrounding tech stack, and personal values.

For the most part, we also avoid suggestions about JavaScript or HTML in general. We don’t mind whether you use semicolons or trailing commas. We don’t mind whether your HTML uses single-quotes or double-quotes for attribute values. Some exceptions will exist however, where we’ve found that a particular pattern is helpful in the context of Vue.

> **Soon, we’ll also provide tips for enforcement.** Sometimes you’ll simply have to be disciplined, but wherever possible, we’ll try to show you how to use ESLint and other automated processes to make enforcement simpler.

Finally, we’ve split rules into four categories:

## [Rule Categories](https://vuejs.org/v2/style-guide/index.html#Rule-Categories)

### [Priority A: Essential](https://vuejs.org/v2/style-guide/index.html#Priority-A-Essential)

These rules help prevent errors, so learn and abide by them at all costs. Exceptions may exist, but should be very rare and only be made by those with expert knowledge of both JavaScript and Vue.

### [Priority B: Strongly Recommended](https://vuejs.org/v2/style-guide/index.html#Priority-B-Strongly-Recommended)

These rules have been found to improve readability and/or developer experience in most projects. Your code will still run if you violate them, but violations should be rare and well-justified.

### [Priority C: Recommended](https://vuejs.org/v2/style-guide/index.html#Priority-C-Recommended)

Where multiple, equally good options exist, an arbitrary choice can be made to ensure consistency. In these rules, we describe each acceptable option and suggest a default choice. That means you can feel free to make a different choice in your own codebase, as long as you’re consistent and have a good reason. Please do have a good reason though! By adapting to the community standard, you will:

1. train your brain to more easily parse most of the community code you encounter
2. be able to copy and paste most community code examples without modification
3. often find new hires are already accustomed to your preferred coding style, at least in regards to Vue

### [Priority D: Use with Caution](https://vuejs.org/v2/style-guide/index.html#Priority-D-Use-with-Caution)

Some features of Vue exist to accommodate rare edge cases or smoother migrations from a legacy code base. When overused however, they can make your code more difficult to maintain or even become a source of bugs. These rules shine a light on potentially risky features, describing when and why they should be avoided.

## [Priority A Rules: Essential (Error Prevention)](https://vuejs.org/v2/style-guide/index.html#Priority-A-Rules-Essential-Error-Prevention)

### [Multi-word component names ESSENTIAL](https://vuejs.org/v2/style-guide/index.html#Multi-word-component-names-essential)

**Component names should always be multi-word, except for root `App` components, and built-in components provided by Vue, such as `<transition>` or `<component>`.**

This [prevents conflicts](http://w3c.github.io/webcomponents/spec/custom/#valid-custom-element-name) with existing and future HTML elements, since all HTML elements are a single word.

#### Bad

```js
Vue.component('todo', {
  // ...
})
```

```js
export default {
  name: 'Todo',
  // ...
}
```



#### Good

```js
Vue.component('todo-item', {
  // ...
})
```

```js
export default {
  name: 'TodoItem',
  // ...
}
```

### [Component data ESSENTIAL](https://vuejs.org/v2/style-guide/index.html#Component-data-essential)

**Component `data` must be a function.**

When using the `data` property on a component (i.e. anywhere except on `new Vue`), the value must be a function that returns an object.

<details open="" style="border-radius: 2px; margin: 1.6em 0px; padding: 1.6em; background-color: rgb(238, 238, 238); display: block; position: relative;"><summary style="cursor: pointer; padding: 1.6em; margin: -1.6em; outline: none;"><span>&nbsp;</span><h4 style="font-weight: 600; color: rgb(39, 56, 73); margin: 0px; display: inline-block;">Detailed Explanation</h4></summary><p style="word-spacing: 0.05em; line-height: 1.6em; margin: 1.2em 0px -1.2em; padding-bottom: 1.2em; position: relative; z-index: 1;">When the value of<span>&nbsp;</span><code style="font-family: &quot;Roboto Mono&quot;, Monaco, courier, monospace; font-size: 0.85em; background-color: rgb(248, 248, 248); -webkit-font-smoothing: initial; color: rgb(214, 50, 0); padding: 3px 5px; margin: 0px 2px; border-radius: 2px; white-space: nowrap;">data</code><span>&nbsp;</span>is an object, it’s shared across all instances of a component. Imagine, for example, a<span>&nbsp;</span><code style="font-family: &quot;Roboto Mono&quot;, Monaco, courier, monospace; font-size: 0.85em; background-color: rgb(248, 248, 248); -webkit-font-smoothing: initial; color: rgb(214, 50, 0); padding: 3px 5px; margin: 0px 2px; border-radius: 2px; white-space: nowrap;">TodoList</code><span>&nbsp;</span>component with this data:</p><pre style="border-radius: 2px; position: relative; font-family: &quot;Roboto Mono&quot;, Monaco, courier, monospace; font-size: 0.85em; background-color: rgb(248, 248, 248); -webkit-font-smoothing: initial;"><code class="hljs js" style="font-family: &quot;Roboto Mono&quot;, Monaco, courier, monospace; font-size: 0.85rem; background-color: rgb(248, 248, 248); -webkit-font-smoothing: initial; color: rgb(82, 82, 82); padding: 1.2em 1.4em; margin: 0px 2px; border-radius: 2px; white-space: pre; overflow-x: auto; line-height: 1.6rem; display: block;">data: {
  <span class="hljs-attr">listTitle</span>: <span class="hljs-string" style="color: rgb(66, 185, 131);">''</span>,
  <span class="hljs-attr">todos</span>: []
}</code></pre><p style="word-spacing: 0.05em; line-height: 1.6em; margin: 1.2em 0px -1.2em; padding-bottom: 1.2em; position: relative; z-index: 1;">We might want to reuse this component, allowing users to maintain multiple lists (e.g. for shopping, wishlists, daily chores, etc). There’s a problem though. Since every instance of the component references the same data object, changing the title of one list will also change the title of every other list. The same is true for adding/editing/deleting a todo.</p><p style="word-spacing: 0.05em; line-height: 1.6em; margin: 1.2em 0px -1.2em; padding-bottom: 1.2em; position: relative; z-index: 1;">Instead, we want each component instance to only manage its own data. For that to happen, each instance must generate a unique data object. In JavaScript, this can be accomplished by returning the object in a function:</p><pre style="border-radius: 2px; position: relative; font-family: &quot;Roboto Mono&quot;, Monaco, courier, monospace; font-size: 0.85em; background-color: rgb(248, 248, 248); -webkit-font-smoothing: initial;"><code class="hljs js" style="font-family: &quot;Roboto Mono&quot;, Monaco, courier, monospace; font-size: 0.85rem; background-color: rgb(248, 248, 248); -webkit-font-smoothing: initial; color: rgb(82, 82, 82); padding: 1.2em 1.4em; margin: 0px 2px; border-radius: 2px; white-space: pre; overflow-x: auto; line-height: 1.6rem; display: block;">data: <span class="hljs-function"><span class="hljs-keyword" style="color: rgb(214, 50, 0);">function</span> (<span class="hljs-params"></span>) </span>{
  <span class="hljs-keyword" style="color: rgb(214, 50, 0);">return</span> {
    <span class="hljs-attr">listTitle</span>: <span class="hljs-string" style="color: rgb(66, 185, 131);">''</span>,
    <span class="hljs-attr">todos</span>: []
  }
}</code></pre></details>

#### Bad

```js
Vue.component('some-comp', {
  data: {
    foo: 'bar'
  }
})
```

```js
export default {
  data: {
    foo: 'bar'
  }
}
```



#### Good

```js
Vue.component('some-comp', {
  data: function () {
    return {
      foo: 'bar'
    }
  }
})

```

```js
// In a .vue file
export default {
  data () {
    return {
      foo: 'bar'
    }
  }
}

```

```js
// It's OK to use an object directly in a root
// Vue instance, since only a single instance
// will ever exist.
new Vue({
  data: {
    foo: 'bar'
  }
})
```



### [Prop definitionsESSENTIAL](https://vuejs.org/v2/style-guide/index.html#Prop-definitions-essential)

**Prop definitions should be as detailed as possible.**

In committed code, prop definitions should always be as detailed as possible, specifying at least type(s).

<details style="border-radius: 2px; margin: 1.6em 0px; padding: 1.6em; background-color: rgb(238, 238, 238); display: block; position: relative;"><summary style="cursor: pointer; padding: 1.6em; margin: -1.6em; outline: none;"><span>&nbsp;</span><h4 style="font-weight: 600; color: rgb(39, 56, 73); margin: 0px; display: inline-block;">Detailed Explanation</h4><span>&nbsp;</span></summary></details>

#### Bad

```
// This is only OK when prototyping
props: ['status']
```

#### Good

```
props: {
  status: String
}
// Even better!
props: {
  status: {
    type: String,
    required: true,
    validator: function (value) {
      return [
        'syncing',
        'synced',
        'version-conflict',
        'error'
      ].indexOf(value) !== -1
    }
  }
}
```

### [Keyed `v-for`ESSENTIAL](https://vuejs.org/v2/style-guide/index.html#Keyed-v-for-essential)

**Always use `key` with `v-for`.**

`key` with `v-for` is *always* required on components, in order to maintain internal component state down the subtree. Even for elements though, it’s a good practice to maintain predictable behavior, such as [object constancy](https://bost.ocks.org/mike/constancy/) in animations.

<details style="border-radius: 2px; margin: 1.6em 0px; padding: 1.6em; background-color: rgb(238, 238, 238); display: block; position: relative;"><summary style="cursor: pointer; padding: 1.6em; margin: -1.6em; outline: none;"><span>&nbsp;</span><h4 style="font-weight: 600; color: rgb(39, 56, 73); margin: 0px; display: inline-block;">Detailed Explanation</h4><span>&nbsp;</span></summary></details>

#### Bad

```
<ul>
  <li v-for="todo in todos">
    {{ todo.text }}
  </li>
</ul>
```

#### Good

```
<ul>
  <li
    v-for="todo in todos"
    :key="todo.id"
  >
    {{ todo.text }}
  </li>
</ul>
```

### [Avoid `v-if` with `v-for`ESSENTIAL](https://vuejs.org/v2/style-guide/index.html#Avoid-v-if-with-v-for-essential)

**Never use `v-if` on the same element as `v-for`.**

There are two common cases where this can be tempting:

- To filter items in a list (e.g. `v-for="user in users" v-if="user.isActive"`). In these cases, replace `users` with a new computed property that returns your filtered list (e.g. `activeUsers`).
- To avoid rendering a list if it should be hidden (e.g. `v-for="user in users" v-if="shouldShowUsers"`). In these cases, move the `v-if` to a container element (e.g. `ul`, `ol`).

<details style="border-radius: 2px; margin: 1.6em 0px; padding: 1.6em; background-color: rgb(238, 238, 238); display: block; position: relative;"><summary style="cursor: pointer; padding: 1.6em; margin: -1.6em; outline: none;"><span>&nbsp;</span><h4 style="font-weight: 600; color: rgb(39, 56, 73); margin: 0px; display: inline-block;">Detailed Explanation</h4><span>&nbsp;</span></summary></details>

#### Bad

```
<ul>
  <li
    v-for="user in users"
    v-if="user.isActive"
    :key="user.id"
  >
    {{ user.name }}
  </li>
</ul>
<ul>
  <li
    v-for="user in users"
    v-if="shouldShowUsers"
    :key="user.id"
  >
    {{ user.name }}
  </li>
</ul>
```

#### Good

```
<ul>
  <li
    v-for="user in activeUsers"
    :key="user.id"
  >
    {{ user.name }}
  </li>
</ul>
<ul v-if="shouldShowUsers">
  <li
    v-for="user in users"
    :key="user.id"
  >
    {{ user.name }}
  </li>
</ul>
```

### [Component style scopingESSENTIAL](https://vuejs.org/v2/style-guide/index.html#Component-style-scoping-essential)

**For applications, styles in a top-level `App` component and in layout components may be global, but all other components should always be scoped.**

This is only relevant for [single-file components](https://vuejs.org/v2/guide/single-file-components.html). It does *not* require that the [`scoped` attribute](https://vue-loader.vuejs.org/en/features/scoped-css.html) be used. Scoping could be through [CSS modules](https://vue-loader.vuejs.org/en/features/css-modules.html), a class-based strategy such as [BEM](http://getbem.com/), or another library/convention.

**Component libraries, however, should prefer a class-based strategy instead of using the `scoped` attribute.**

This makes overriding internal styles easier, with human-readable class names that don’t have too high specificity, but are still very unlikely to result in a conflict.

<details style="border-radius: 2px; margin: 1.6em 0px; padding: 1.6em; background-color: rgb(238, 238, 238); display: block; position: relative;"><summary style="cursor: pointer; padding: 1.6em; margin: -1.6em; outline: none;"><span>&nbsp;</span><h4 style="font-weight: 600; color: rgb(39, 56, 73); margin: 0px; display: inline-block;">Detailed Explanation</h4><span>&nbsp;</span></summary></details>

#### Bad

```
<template>
  <button class="btn btn-close">X</button>
</template>

<style>
.btn-close {
  background-color: red;
}
</style>
```

#### Good

```
<template>
  <button class="button button-close">X</button>
</template>

<!-- Using the `scoped` attribute -->
<style scoped>
.button {
  border: none;
  border-radius: 2px;
}

.button-close {
  background-color: red;
}
</style>
<template>
  <button :class="[$style.button, $style.buttonClose]">X</button>
</template>

<!-- Using CSS modules -->
<style module>
.button {
  border: none;
  border-radius: 2px;
}

.buttonClose {
  background-color: red;
}
</style>
<template>
  <button class="c-Button c-Button--close">X</button>
</template>

<!-- Using the BEM convention -->
<style>
.c-Button {
  border: none;
  border-radius: 2px;
}

.c-Button--close {
  background-color: red;
}
</style>
```

### [Private property namesESSENTIAL](https://vuejs.org/v2/style-guide/index.html#Private-property-names-essential)

**Use module scoping to keep private functions inaccessible from the outside. If that’s not possible, always use the `$_` prefix for custom private properties in a plugin, mixin, etc that should not be considered public API. Then to avoid conflicts with code by other authors, also include a named scope (e.g. `$_yourPluginName_`).**

<details style="border-radius: 2px; margin: 1.6em 0px; padding: 1.6em; background-color: rgb(238, 238, 238); display: block; position: relative;"><summary style="cursor: pointer; padding: 1.6em; margin: -1.6em; outline: none;"><span>&nbsp;</span><h4 style="font-weight: 600; color: rgb(39, 56, 73); margin: 0px; display: inline-block;">Detailed Explanation</h4><span>&nbsp;</span></summary></details>

#### Bad

```
var myGreatMixin = {
  // ...
  methods: {
    update: function () {
      // ...
    }
  }
}
var myGreatMixin = {
  // ...
  methods: {
    _update: function () {
      // ...
    }
  }
}
var myGreatMixin = {
  // ...
  methods: {
    $update: function () {
      // ...
    }
  }
}
var myGreatMixin = {
  // ...
  methods: {
    $_update: function () {
      // ...
    }
  }
}
```

#### Good

```
var myGreatMixin = {
  // ...
  methods: {
    $_myGreatMixin_update: function () {
      // ...
    }
  }
}
// Even better!
var myGreatMixin = {
  // ...
  methods: {
    publicMethod() {
      // ...
      myPrivateFunction()
    }
  }
}

function myPrivateFunction() {
  // ...
}

export default myGreatMixin
```

## [Priority B Rules: Strongly Recommended (Improving Readability)](https://vuejs.org/v2/style-guide/index.html#Priority-B-Rules-Strongly-Recommended-Improving-Readability)

### [Component filesSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Component-files-strongly-recommended)

**Whenever a build system is available to concatenate files, each component should be in its own file.**

This helps you to more quickly find a component when you need to edit it or review how to use it.

#### Bad

```
Vue.component('TodoList', {
  // ...
})

Vue.component('TodoItem', {
  // ...
})
```

#### Good

```
components/
|- TodoList.js
|- TodoItem.js
components/
|- TodoList.vue
|- TodoItem.vue
```

### [Single-file component filename casingSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Single-file-component-filename-casing-strongly-recommended)

**Filenames of [single-file components](https://vuejs.org/v2/guide/single-file-components.html) should either be always PascalCase or always kebab-case.**

PascalCase works best with autocompletion in code editors, as it’s consistent with how we reference components in JS(X) and templates, wherever possible. However, mixed case filenames can sometimes create issues on case-insensitive file systems, which is why kebab-case is also perfectly acceptable.

#### Bad

```
components/
|- mycomponent.vue
components/
|- myComponent.vue
```

#### Good

```
components/
|- MyComponent.vue
components/
|- my-component.vue
```

### [Base component namesSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Base-component-names-strongly-recommended)

**Base components (a.k.a. presentational, dumb, or pure components) that apply app-specific styling and conventions should all begin with a specific prefix, such as `Base`, `App`, or `V`.**

<details style="border-radius: 2px; margin: 1.6em 0px; padding: 1.6em; background-color: rgb(238, 238, 238); display: block; position: relative;"><summary style="cursor: pointer; padding: 1.6em; margin: -1.6em; outline: none;"><span>&nbsp;</span><h4 style="font-weight: 600; color: rgb(39, 56, 73); margin: 0px; display: inline-block;">Detailed Explanation</h4><span>&nbsp;</span></summary></details>

#### Bad

```
components/
|- MyButton.vue
|- VueTable.vue
|- Icon.vue
```

#### Good

```
components/
|- BaseButton.vue
|- BaseTable.vue
|- BaseIcon.vue
components/
|- AppButton.vue
|- AppTable.vue
|- AppIcon.vue
components/
|- VButton.vue
|- VTable.vue
|- VIcon.vue
```

### [Single-instance component namesSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Single-instance-component-names-strongly-recommended)

**Components that should only ever have a single active instance should begin with the `The` prefix, to denote that there can be only one.**

This does not mean the component is only used in a single page, but it will only be used once *per page*. These components never accept any props, since they are specific to your app, not their context within your app. If you find the need to add props, it’s a good indication that this is actually a reusable component that is only used once per page *for now*.

#### Bad

```
components/
|- Heading.vue
|- MySidebar.vue
```

#### Good

```
components/
|- TheHeading.vue
|- TheSidebar.vue
```

### [Tightly coupled component namesSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Tightly-coupled-component-names-strongly-recommended)

**Child components that are tightly coupled with their parent should include the parent component name as a prefix.**

If a component only makes sense in the context of a single parent component, that relationship should be evident in its name. Since editors typically organize files alphabetically, this also keeps these related files next to each other.

<details style="border-radius: 2px; margin: 1.6em 0px; padding: 1.6em; background-color: rgb(238, 238, 238); display: block; position: relative;"><summary style="cursor: pointer; padding: 1.6em; margin: -1.6em; outline: none;"><span>&nbsp;</span><h4 style="font-weight: 600; color: rgb(39, 56, 73); margin: 0px; display: inline-block;">Detailed Explanation</h4><span>&nbsp;</span></summary></details>

#### Bad

```
components/
|- TodoList.vue
|- TodoItem.vue
|- TodoButton.vue
components/
|- SearchSidebar.vue
|- NavigationForSearchSidebar.vue
```

#### Good

```
components/
|- TodoList.vue
|- TodoListItem.vue
|- TodoListItemButton.vue
components/
|- SearchSidebar.vue
|- SearchSidebarNavigation.vue
```

### [Order of words in component namesSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Order-of-words-in-component-names-strongly-recommended)

**Component names should start with the highest-level (often most general) words and end with descriptive modifying words.**

<details style="border-radius: 2px; margin: 1.6em 0px; padding: 1.6em; background-color: rgb(238, 238, 238); display: block; position: relative;"><summary style="cursor: pointer; padding: 1.6em; margin: -1.6em; outline: none;"><span>&nbsp;</span><h4 style="font-weight: 600; color: rgb(39, 56, 73); margin: 0px; display: inline-block;">Detailed Explanation</h4><span>&nbsp;</span></summary></details>

#### Bad

```
components/
|- ClearSearchButton.vue
|- ExcludeFromSearchInput.vue
|- LaunchOnStartupCheckbox.vue
|- RunSearchButton.vue
|- SearchInput.vue
|- TermsCheckbox.vue
```

#### Good

```
components/
|- SearchButtonClear.vue
|- SearchButtonRun.vue
|- SearchInputQuery.vue
|- SearchInputExcludeGlob.vue
|- SettingsCheckboxTerms.vue
|- SettingsCheckboxLaunchOnStartup.vue
```

### [Self-closing componentsSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Self-closing-components-strongly-recommended)

**Components with no content should be self-closing in [single-file components](https://vuejs.org/v2/guide/single-file-components.html), string templates, and [JSX](https://vuejs.org/v2/guide/render-function.html#JSX) - but never in DOM templates.**

Components that self-close communicate that they not only have no content, but are **meant** to have no content. It’s the difference between a blank page in a book and one labeled “This page intentionally left blank.” Your code is also cleaner without the unnecessary closing tag.

Unfortunately, HTML doesn’t allow custom elements to be self-closing - only [official “void” elements](https://www.w3.org/TR/html/syntax.html#void-elements). That’s why the strategy is only possible when Vue’s template compiler can reach the template before the DOM, then serve the DOM spec-compliant HTML.

#### Bad

```
<!-- In single-file components, string templates, and JSX -->
<MyComponent></MyComponent>
<!-- In DOM templates -->
<my-component/>
```

#### Good

```
<!-- In single-file components, string templates, and JSX -->
<MyComponent/>
<!-- In DOM templates -->
<my-component></my-component>
```

### [Component name casing in templatesSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Component-name-casing-in-templates-strongly-recommended)

**In most projects, component names should always be PascalCase in [single-file components](https://vuejs.org/v2/guide/single-file-components.html) and string templates - but kebab-case in DOM templates.**

PascalCase has a few advantages over kebab-case:

- Editors can autocomplete component names in templates, because PascalCase is also used in JavaScript.
- `` is more visually distinct from a single-word HTML element than ``, because there are two character differences (the two capitals), rather than just one (a hyphen).
- If you use any non-Vue custom elements in your templates, such as a web component, PascalCase ensures that your Vue components remain distinctly visible.

Unfortunately, due to HTML’s case insensitivity, DOM templates must still use kebab-case.

Also note that if you’ve already invested heavily in kebab-case, consistency with HTML conventions and being able to use the same casing across all your projects may be more important than the advantages listed above. In those cases, **using kebab-case everywhere is also acceptable.**

#### Bad

```
<!-- In single-file components and string templates -->
<mycomponent/>
<!-- In single-file components and string templates -->
<myComponent/>
<!-- In DOM templates -->
<MyComponent></MyComponent>
```

#### Good

```
<!-- In single-file components and string templates -->
<MyComponent/>
<!-- In DOM templates -->
<my-component></my-component>
```

OR

```
<!-- Everywhere -->
<my-component></my-component>
```

### [Component name casing in JS/JSXSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Component-name-casing-in-JS-JSX-strongly-recommended)

**Component names in JS/[JSX](https://vuejs.org/v2/guide/render-function.html#JSX) should always be PascalCase, though they may be kebab-case inside strings for simpler applications that only use global component registration through `Vue.component`.**

<details style="border-radius: 2px; margin: 1.6em 0px; padding: 1.6em; background-color: rgb(238, 238, 238); display: block; position: relative;"><summary style="cursor: pointer; padding: 1.6em; margin: -1.6em; outline: none;"><span>&nbsp;</span><h4 style="font-weight: 600; color: rgb(39, 56, 73); margin: 0px; display: inline-block;">Detailed Explanation</h4><span>&nbsp;</span></summary></details>

#### Bad

```
Vue.component('myComponent', {
  // ...
})
import myComponent from './MyComponent.vue'
export default {
  name: 'myComponent',
  // ...
}
export default {
  name: 'my-component',
  // ...
}
```

#### Good

```
Vue.component('MyComponent', {
  // ...
})
Vue.component('my-component', {
  // ...
})
import MyComponent from './MyComponent.vue'
export default {
  name: 'MyComponent',
  // ...
}
```

### [Full-word component namesSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Full-word-component-names-strongly-recommended)

**Component names should prefer full words over abbreviations.**

The autocompletion in editors make the cost of writing longer names very low, while the clarity they provide is invaluable. Uncommon abbreviations, in particular, should always be avoided.

#### Bad

```
components/
|- SdSettings.vue
|- UProfOpts.vue
```

#### Good

```
components/
|- StudentDashboardSettings.vue
|- UserProfileOptions.vue
```

### [Prop name casingSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Prop-name-casing-strongly-recommended)

**Prop names should always use camelCase during declaration, but kebab-case in templates and [JSX](https://vuejs.org/v2/guide/render-function.html#JSX).**

We’re simply following the conventions of each language. Within JavaScript, camelCase is more natural. Within HTML, kebab-case is.

#### Bad

```
props: {
  'greeting-text': String
}
<WelcomeMessage greetingText="hi"/>
```

#### Good

```
props: {
  greetingText: String
}
<WelcomeMessage greeting-text="hi"/>
```

### [Multi-attribute elementsSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Multi-attribute-elements-strongly-recommended)

**Elements with multiple attributes should span multiple lines, with one attribute per line.**

In JavaScript, splitting objects with multiple properties over multiple lines is widely considered a good convention, because it’s much easier to read. Our templates and [JSX](https://vuejs.org/v2/guide/render-function.html#JSX) deserve the same consideration.

#### Bad

```
<img src="https://vuejs.org/images/logo.png" alt="Vue Logo">
<MyComponent foo="a" bar="b" baz="c"/>
```

#### Good

```
<img
  src="https://vuejs.org/images/logo.png"
  alt="Vue Logo"
>
<MyComponent
  foo="a"
  bar="b"
  baz="c"
/>
```

### [Simple expressions in templatesSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Simple-expressions-in-templates-strongly-recommended)

**Component templates should only include simple expressions, with more complex expressions refactored into computed properties or methods.**

Complex expressions in your templates make them less declarative. We should strive to describe *what* should appear, not *how* we’re computing that value. Computed properties and methods also allow the code to be reused.

#### Bad

```
{{
  fullName.split(' ').map(function (word) {
    return word[0].toUpperCase() + word.slice(1)
  }).join(' ')
}}
```

#### Good

```
<!-- In a template -->
{{ normalizedFullName }}
// The complex expression has been moved to a computed property
computed: {
  normalizedFullName: function () {
    return this.fullName.split(' ').map(function (word) {
      return word[0].toUpperCase() + word.slice(1)
    }).join(' ')
  }
}
```

### [Simple computed propertiesSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Simple-computed-properties-strongly-recommended)

**Complex computed properties should be split into as many simpler properties as possible.**

<details style="border-radius: 2px; margin: 1.6em 0px; padding: 1.6em; background-color: rgb(238, 238, 238); display: block; position: relative;"><summary style="cursor: pointer; padding: 1.6em; margin: -1.6em; outline: none;"><span>&nbsp;</span><h4 style="font-weight: 600; color: rgb(39, 56, 73); margin: 0px; display: inline-block;">Detailed Explanation</h4><span>&nbsp;</span></summary></details>

#### Bad

```
computed: {
  price: function () {
    var basePrice = this.manufactureCost / (1 - this.profitMargin)
    return (
      basePrice -
      basePrice * (this.discountPercent || 0)
    )
  }
}
```

#### Good

```
computed: {
  basePrice: function () {
    return this.manufactureCost / (1 - this.profitMargin)
  },
  discount: function () {
    return this.basePrice * (this.discountPercent || 0)
  },
  finalPrice: function () {
    return this.basePrice - this.discount
  }
}
```

### [Quoted attribute valuesSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Quoted-attribute-values-strongly-recommended)

**Non-empty HTML attribute values should always be inside quotes (single or double, whichever is not used in JS).**

While attribute values without any spaces are not required to have quotes in HTML, this practice often leads to *avoiding* spaces, making attribute values less readable.

#### Bad

```
<input type=text>
<AppSidebar :style={width:sidebarWidth+'px'}>
```

#### Good

```
<input type="text">
<AppSidebar :style="{ width: sidebarWidth + 'px' }">
```

### [Directive shorthandsSTRONGLY RECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Directive-shorthands-strongly-recommended)

**Directive shorthands (`:` for `v-bind:`, `@` for `v-on:` and `#` for `v-slot`) should be used always or never.**

#### Bad

```
<input
  v-bind:value="newTodoText"
  :placeholder="newTodoInstructions"
>
<input
  v-on:input="onInput"
  @focus="onFocus"
>
<template v-slot:header>
  <h1>Here might be a page title</h1>
</template>

<template #footer>
  <p>Here's some contact info</p>
</template>
```

#### Good

```
<input
  :value="newTodoText"
  :placeholder="newTodoInstructions"
>
<input
  v-bind:value="newTodoText"
  v-bind:placeholder="newTodoInstructions"
>
<input
  @input="onInput"
  @focus="onFocus"
>
<input
  v-on:input="onInput"
  v-on:focus="onFocus"
>
<template v-slot:header>
  <h1>Here might be a page title</h1>
</template>

<template v-slot:footer>
  <p>Here's some contact info</p>
</template>
<template #header>
  <h1>Here might be a page title</h1>
</template>

<template #footer>
  <p>Here's some contact info</p>
</template>
```

## [Priority C Rules: Recommended (Minimizing Arbitrary Choices and Cognitive Overhead)](https://vuejs.org/v2/style-guide/index.html#Priority-C-Rules-Recommended-Minimizing-Arbitrary-Choices-and-Cognitive-Overhead)

### [Component/instance options orderRECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Component-instance-options-order-recommended)

**Component/instance options should be ordered consistently.**

This is the default order we recommend for component options. They’re split into categories, so you’ll know where to add new properties from plugins.

1. **Side Effects** (triggers effects outside the component)
   - `el`
2. **Global Awareness** (requires knowledge beyond the component)
   - `name`
   - `parent`
3. **Component Type** (changes the type of the component)
   - `functional`
4. **Template Modifiers** (changes the way templates are compiled)
   - `delimiters`
   - `comments`
5. **Template Dependencies** (assets used in the template)
   - `components`
   - `directives`
   - `filters`
6. **Composition** (merges properties into the options)
   - `extends`
   - `mixins`
7. **Interface** (the interface to the component)
   - `inheritAttrs`
   - `model`
   - `props`/`propsData`
8. **Local State** (local reactive properties)
   - `data`
   - `computed`
9. **Events** (callbacks triggered by reactive events)
   - `watch`
   - Lifecycle Events (in the order they are called)
     - `beforeCreate`
     - `created`
     - `beforeMount`
     - `mounted`
     - `beforeUpdate`
     - `updated`
     - `activated`
     - `deactivated`
     - `beforeDestroy`
     - `destroyed`
10. **Non-Reactive Properties** (instance properties independent of the reactivity system)
    - `methods`
11. **Rendering** (the declarative description of the component output)
    - `template`/`render`
    - `renderError`

### [Element attribute orderRECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Element-attribute-order-recommended)

**The attributes of elements (including components) should be ordered consistently.**

This is the default order we recommend for component options. They’re split into categories, so you’ll know where to add custom attributes and directives.

1. **Definition** (provides the component options)
   - `is`
2. **List Rendering** (creates multiple variations of the same element)
   - `v-for`
3. **Conditionals** (whether the element is rendered/shown)
   - `v-if`
   - `v-else-if`
   - `v-else`
   - `v-show`
   - `v-cloak`
4. **Render Modifiers** (changes the way the element renders)
   - `v-pre`
   - `v-once`
5. **Global Awareness** (requires knowledge beyond the component)
   - `id`
6. **Unique Attributes** (attributes that require unique values)
   - `ref`
   - `key`
7. **Two-Way Binding** (combining binding and events)
   - `v-model`
8. **Other Attributes** (all unspecified bound & unbound attributes)
9. **Events** (component event listeners)
   - `v-on`
10. **Content** (overrides the content of the element)
    - `v-html`
    - `v-text`

### [Empty lines in component/instance optionsRECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Empty-lines-in-component-instance-options-recommended)

**You may want to add one empty line between multi-line properties, particularly if the options can no longer fit on your screen without scrolling.**

When components begin to feel cramped or difficult to read, adding spaces between multi-line properties can make them easier to skim again. In some editors, such as Vim, formatting options like this can also make them easier to navigate with the keyboard.

#### Good

```
props: {
  value: {
    type: String,
    required: true
  },

  focused: {
    type: Boolean,
    default: false
  },

  label: String,
  icon: String
},

computed: {
  formattedValue: function () {
    // ...
  },

  inputClasses: function () {
    // ...
  }
}
// No spaces are also fine, as long as the component
// is still easy to read and navigate.
props: {
  value: {
    type: String,
    required: true
  },
  focused: {
    type: Boolean,
    default: false
  },
  label: String,
  icon: String
},
computed: {
  formattedValue: function () {
    // ...
  },
  inputClasses: function () {
    // ...
  }
}
```

### [Single-file component top-level element orderRECOMMENDED](https://vuejs.org/v2/style-guide/index.html#Single-file-component-top-level-element-order-recommended)

**[Single-file components](https://vuejs.org/v2/guide/single-file-components.html) should always order ``, `, and `` tags consistently, with `` last, because at least one of the other two is always necessary.**

#### Bad

```
<style>/* ... */</style>
<script>/* ... */</script>
<template>...</template>
<!-- ComponentA.vue -->
<script>/* ... */</script>
<template>...</template>
<style>/* ... */</style>

<!-- ComponentB.vue -->
<template>...</template>
<script>/* ... */</script>
<style>/* ... */</style>
```

#### Good

```
<!-- ComponentA.vue -->
<script>/* ... */</script>
<template>...</template>
<style>/* ... */</style>

<!-- ComponentB.vue -->
<script>/* ... */</script>
<template>...</template>
<style>/* ... */</style>
<!-- ComponentA.vue -->
<template>...</template>
<script>/* ... */</script>
<style>/* ... */</style>

<!-- ComponentB.vue -->
<template>...</template>
<script>/* ... */</script>
<style>/* ... */</style>
```

## [Priority D Rules: Use with Caution (Potentially Dangerous Patterns)](https://vuejs.org/v2/style-guide/index.html#Priority-D-Rules-Use-with-Caution-Potentially-Dangerous-Patterns)

### [`v-if`/`v-else-if`/`v-else` without `key`USE WITH CAUTION](https://vuejs.org/v2/style-guide/index.html#v-if-v-else-if-v-else-without-key-use-with-caution)

**It’s usually best to use `key` with `v-if` + `v-else`, if they are the same element type (e.g. both `` elements).**

By default, Vue updates the DOM as efficiently as possible. That means when switching between elements of the same type, it simply patches the existing element, rather than removing it and adding a new one in its place. This can have [unintended consequences](https://codesandbox.io/s/github/vuejs/vuejs.org/tree/master/src/v2/examples/vue-20-priority-d-rules-unintended-consequences) if these elements should not actually be considered the same.

#### Bad

```
<div v-if="error">
  Error: {{ error }}
</div>
<div v-else>
  {{ results }}
</div>
```

#### Good

```
<div
  v-if="error"
  key="search-status"
>
  Error: {{ error }}
</div>
<div
  v-else
  key="search-results"
>
  {{ results }}
</div>
```

### [Element selectors with `scoped`USE WITH CAUTION](https://vuejs.org/v2/style-guide/index.html#Element-selectors-with-scoped-use-with-caution)

**Element selectors should be avoided with `scoped`.**

Prefer class selectors over element selectors in `scoped` styles, because large numbers of element selectors are slow.

<details style="border-radius: 2px; margin: 1.6em 0px; padding: 1.6em; background-color: rgb(238, 238, 238); display: block; position: relative;"><summary style="cursor: pointer; padding: 1.6em; margin: -1.6em; outline: none;"><span>&nbsp;</span><h4 style="font-weight: 600; color: rgb(39, 56, 73); margin: 0px; display: inline-block;">Detailed Explanation</h4><span>&nbsp;</span></summary></details>

#### Bad

```
<template>
  <button>X</button>
</template>

<style scoped>
button {
  background-color: red;
}
</style>
```

#### Good

```
<template>
  <button class="btn btn-close">X</button>
</template>

<style scoped>
.btn-close {
  background-color: red;
}
</style>
```

### [Implicit parent-child communicationUSE WITH CAUTION](https://vuejs.org/v2/style-guide/index.html#Implicit-parent-child-communication-use-with-caution)

**Props and events should be preferred for parent-child component communication, instead of `this.$parent` or mutating props.**

An ideal Vue application is props down, events up. Sticking to this convention makes your components much easier to understand. However, there are edge cases where prop mutation or `this.$parent` can simplify two components that are already deeply coupled.

The problem is, there are also many *simple* cases where these patterns may offer convenience. Beware: do not be seduced into trading simplicity (being able to understand the flow of your state) for short-term convenience (writing less code).

#### Bad

```
Vue.component('TodoItem', {
  props: {
    todo: {
      type: Object,
      required: true
    }
  },
  template: '<input v-model="todo.text">'
})
Vue.component('TodoItem', {
  props: {
    todo: {
      type: Object,
      required: true
    }
  },
  methods: {
    removeTodo () {
      var vm = this
      vm.$parent.todos = vm.$parent.todos.filter(function (todo) {
        return todo.id !== vm.todo.id
      })
    }
  },
  template: `
    <span>
      {{ todo.text }}
      <button @click="removeTodo">
        X
      </button>
    </span>
  `
})
```

#### Good

```
Vue.component('TodoItem', {
  props: {
    todo: {
      type: Object,
      required: true
    }
  },
  template: `
    <input
      :value="todo.text"
      @input="$emit('input', $event.target.value)"
    >
  `
})
Vue.component('TodoItem', {
  props: {
    todo: {
      type: Object,
      required: true
    }
  },
  template: `
    <span>
      {{ todo.text }}
      <button @click="$emit('delete')">
        X
      </button>
    </span>
  `
})
```

### [Non-flux state managementUSE WITH CAUTION](https://vuejs.org/v2/style-guide/index.html#Non-flux-state-management-use-with-caution)

**[Vuex](https://github.com/vuejs/vuex) should be preferred for global state management, instead of `this.$root` or a global event bus.**

Managing state on `this.$root` and/or using a [global event bus](https://vuejs.org/v2/guide/migration.html#dispatch-and-broadcast-replaced) can be convenient for very simple cases, but it is not appropriate for most applications.

Vuex is the [official flux-like implementation](https://vuejs.org/v2/guide/state-management.html#Official-Flux-Like-Implementation) for Vue, and offers not only a central place to manage state, but also tools for organizing, tracking, and debugging state changes. It integrates well in the Vue ecosystem (including full [Vue DevTools](https://vuejs.org/v2/guide/installation.html#Vue-Devtools) support).

#### Bad

```
// main.js
new Vue({
  data: {
    todos: []
  },
  created: function () {
    this.$on('remove-todo', this.removeTodo)
  },
  methods: {
    removeTodo: function (todo) {
      var todoIdToRemove = todo.id
      this.todos = this.todos.filter(function (todo) {
        return todo.id !== todoIdToRemove
      })
    }
  }
})
```

#### Good

```
// store/modules/todos.js
export default {
  state: {
    list: []
  },
  mutations: {
    REMOVE_TODO (state, todoId) {
      state.list = state.list.filter(todo => todo.id !== todoId)
    }
  },
  actions: {
    removeTodo ({ commit, state }, todo) {
      commit('REMOVE_TODO', todo.id)
    }
  }
}
<!-- TodoItem.vue -->
<template>
  <span>
    {{ todo.text }}
    <button @click="removeTodo(todo)">
      X
    </button>
  </span>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  props: {
    todo: {
      type: Object,
      required: true
    }
  },
  methods: mapActions(['removeTodo'])
}
</script>
```

Caught a mistake or want to contribute to the documentation? [Edit this on GitHub! ](https://github.com/vuejs/vuejs.org/blob/master/src/v2/style-guide/index.md)Deployed on [Netlify ](https://url.netlify.com/HJ8X2mxP8).

```
data: function () {
  return {
    listTitle: '',
    todos: []
  }
}
```

# <!--[Vue Loader](https://vue-loader.vuejs.org/)-->

# Introduction

## What is Vue Loader?

`vue-loader` is a loader for [webpack](https://webpack.js.org/) that allows you to author Vue components in a format called [Single-File Components (SFCs)](https://vue-loader.vuejs.org/spec.html):

```vue
<template>
  <div class="example">{{ msg }}</div>
</template>

<script>
export default {
  data () {
    return {
      msg: 'Hello world!'
    }
  }
}
</script>

<style>
.example {
  color: red;
}
</style>
```

There are many cool features provided by `vue-loader`:

- Allows using other webpack loaders for each part of a Vue component, for example Sass for `<style>` and Pug for `<template>`;
- Allows custom blocks in a `.vue` file that can have custom loader chains applied to them;
- Treat static assets referenced in `<style>` and `<template>` as module dependencies and handle them with webpack loaders;
- Simulate scoped CSS for each component;
- State-preserving hot-reloading during development.

In a nutshell, the combination of webpack and `vue-loader` gives you a modern, flexible and extremely powerful front-end workflow for authoring Vue.js applications.

# Getting Started

## [#](https://vue-loader.vuejs.org/guide/#vue-cli)Vue CLI

If you are not interested in manually setting up webpack, it is recommended to scaffold a project with [Vue CLI](https://github.com/vuejs/vue-cli) instead. Projects created by Vue CLI are pre-configured with most of the common development needs working out of the box

## Manual Setup

### [#](https://vue-loader.vuejs.org/guide/#installation)Installation

Unless you are an advanced user using your own forked version of Vue's template compiler, you should install `vue-loader` and `vue-template-compiler` together:

```bash
npm install -D vue-loader vue-template-compiler
```

The reason `vue-template-compiler` has to be installed separately is so that you can individually specify its version.

Every time a new version of `vue` is released, a corresponding version of `vue-template-compiler` is released together. The compiler's version must be in sync with the base `vue` package so that `vue-loader` produces code that is compatible with the runtime. This means **every time you upgrade `vue` in your project, you should upgrade `vue-template-compiler` to match it as well.**

### webpack Configuration

Vue Loader's configuration is a bit different from other loaders. In addition to a rule that applies `vue-loader` to any files with extension `.vue`, make sure to add Vue Loader's plugin to your webpack config:

```js
// webpack.config.js
const VueLoaderPlugin = require('vue-loader/lib/plugin')

module.exports = {
  module: {
    rules: [
      // ... other rules
      {
        test: /\.vue$/,
        loader: 'vue-loader'
      }
    ]
  },
  plugins: [
    // make sure to include the plugin!
    new VueLoaderPlugin()
  ]
}
```

**The plugin is required!** It is responsible for cloning any other rules you have defined and applying them to the corresponding language blocks in `.vue` files. For example, if you have a rule matching `/\.js$/`, it will be applied to `<script>` blocks in `.vue` files.

A more complete example webpack config will look like this:

```js
// webpack.config.js
const VueLoaderPlugin = require('vue-loader/lib/plugin')

module.exports = {
  mode: 'development',
  module: {
    rules: [
      {
        test: /\.vue$/,
        loader: 'vue-loader'
      },
      // this will apply to both plain `.js` files
      // AND `<script>` blocks in `.vue` files
      {
        test: /\.js$/,
        loader: 'babel-loader'
      },
      // this will apply to both plain `.css` files
      // AND `<style>` blocks in `.vue` files
      {
        test: /\.css$/,
        use: [
          'vue-style-loader',
          'css-loader'
        ]
      }
    ]
  },
  plugins: [
    // make sure to include the plugin for the magic
    new VueLoaderPlugin()
  ]
}
```

Also see [Options Reference](https://vue-loader.vuejs.org/options.html) for all available loader options.

> WARNING
>
> If you are developing a library or in a monorepo, please be aware that CSS imports **are side effects**. Make sure to **remove** `"sideEffects": false` in the `package.json`, otherwise CSS chunks will be dropped by webpack in production builds.

# Asset URL Handling

When Vue Loader compiles the `<template>` blocks in SFCs, it also converts any encountered asset URLs into **webpack module requests**.

For example, the following template snippet:

```vue
<img src="../image.png">
```

will be compiled into:

```js
createElement('img', {
  attrs: {
    src: require('../image.png') // this is now a module request
  }
})
```

By default the following tag/attribute combinations are transformed, and can be configured using the [transformAssetUrls](https://vue-loader.vuejs.org/options.html#transformasseturls) option.

```js
{
  video: ['src', 'poster'],
  source: 'src',
  img: 'src',
  image: ['xlink:href', 'href'],
  use: ['xlink:href', 'href']
}
```

In addition, if you have configured to use [css-loader](https://github.com/webpack-contrib/css-loader) for the `<style>` blocks, asset URLs in your CSS will also be processed in a similar fashion.

## [#](https://vue-loader.vuejs.org/guide/asset-url.html#transform-rules)Transform Rules

Asset URL transforms adhere to the following rules:

- If the URL is an absolute path (e.g. `/images/foo.png`), it will be preserved as-is.

- If the URL starts with `.`, it's interpreted as a relative module request and resolved based on the folder structure on your file system.

- If the URL starts with `~`, anything after it is interpreted as a module request. This means you can even reference assets inside node modules:

  ```html
  <img src="~some-npm-package/foo.png">
  ```

- If the URL starts with `@`, it's also interpreted as a module request. This is useful if your webpack config has an alias for `@`, which by default points to `/src` in any project created by `vue-cli`.

## [#](https://vue-loader.vuejs.org/guide/asset-url.html#related-loaders)Related Loaders

Because extensions like `.png` are not JavaScript modules, you will need to configure webpack to use [file-loader](https://github.com/webpack/file-loader) or [url-loader](https://github.com/webpack/url-loader) to properly handle them. Projects created with Vue CLI has this pre-configured.

## [#](https://vue-loader.vuejs.org/guide/asset-url.html#why)Why

The benefits of asset URL transforms are:

1. `file-loader` allows you to designate where to copy and place the asset file, and how to name it using version hashes for better caching. Moreover, this also means **you can just place images next to your `\*.vue` files and use relative paths based on the folder structure instead of worrying about deployment URLs**. With proper config, webpack will auto-rewrite the file paths into correct URLs in the bundled output.
2. `url-loader` allows you to conditionally inline a file as base-64 data URL if they are smaller than a given threshold. This can reduce the amount of HTTP requests for trivial files. If the file is larger than the threshold, it automatically falls back to `file-loader`.

← [Getting Started](https://vue-loader.vuejs.org/guide/)

# Using Pre-Processors

In webpack, all pre-processors need to be applied with a corresponding loader. `vue-loader` allows you to use other webpack loaders to process a part of a Vue component. It will automatically infer the proper loaders to use based on the `lang` attribute of a language block and the rules in your webpack config.

## [#](https://vue-loader.vuejs.org/guide/pre-processors.html#sass)Sass

For example, to compile our `<style>` tag with Sass/SCSS:

```bash
npm install -D sass-loader node-sass
```

​	In your webpack config:

```js
module.exports = {
  module: {
    rules: [
      // ... other rules omitted

      // this will apply to both plain `.scss` files
      // AND `<style lang="scss">` blocks in `.vue` files
      {
        test: /\.scss$/,
        use: [
          'vue-style-loader',
          'css-loader',
          'sass-loader'
        ]
      }
    ]
  },
  // plugin omitted
}
```

Now in addition to being able to `import 'style.scss'`, we can use SCSS in Vue components as well:

```html
<style lang="scss">
/* write SCSS here */
</style>
```

Any content inside the block will be processed by webpack as if it's inside a `*.scss` file.

### [#](https://vue-loader.vuejs.org/guide/pre-processors.html#sass-vs-scss)Sass vs SCSS

Note that `sass-loader` processes the non-indent-based `scss` syntax by default. In order to use the indent-based `sass` syntax, you need to pass options to the loader:

```js
// webpack.config.js -> module.rules
{
  test: /\.sass$/,
  use: [
    'vue-style-loader',
    'css-loader',
    {
      loader: 'sass-loader',
      options: {
        indentedSyntax: true,
        // sass-loader version >= 8
        sassOptions: {
          indentedSyntax: true
        }
      }
    }
  ]
}
```

### [#](https://vue-loader.vuejs.org/guide/pre-processors.html#sharing-global-variables)Sharing Global Variables

`sass-loader` also supports a `prependData` option which allows you to share common variables among all processed files without having to explicit import them:

```js
// webpack.config.js -> module.rules
{
  test: /\.scss$/,
  use: [
    'vue-style-loader',
    'css-loader',
    {
      loader: 'sass-loader',
      options: {
        // you can also read from a file, e.g. `variables.scss`
        // use `data` here if sass-loader version < 8
        prependData: `$color: red;`
      }
    }
  ]
}
```

## [#](https://vue-loader.vuejs.org/guide/pre-processors.html#less)LESS

```bash
npm install -D less less-loader
// webpack.config.js -> module.rules
{
  test: /\.less$/,
  use: [
    'vue-style-loader',
    'css-loader',
    'less-loader'
  ]
}
```

## [#](https://vue-loader.vuejs.org/guide/pre-processors.html#stylus)Stylus

```bash
npm install -D stylus stylus-loader
// webpack.config.js -> module.rules
{
  test: /\.styl(us)?$/,
  use: [
    'vue-style-loader',
    'css-loader',
    'stylus-loader'
  ]
}
```

## [#](https://vue-loader.vuejs.org/guide/pre-processors.html#postcss)PostCSS

TIP

Vue Loader v15 no longer applies PostCSS transforms by default. You will need to use PostCSS via `postcss-loader`.

```bash
npm install -D postcss-loader
// webpack.config.js -> module.rules
{
  test: /\.css$/,
  use: [
    'vue-style-loader',
    {
      loader: 'css-loader',
      options: { importLoaders: 1 }
    },
    'postcss-loader'
  ]
}
```

Configuration of PostCSS can be done via `postcss.config.js` or `postcss-loader` options. For details, consult [postcss-loader docs](https://github.com/postcss/postcss-loader).

`postcss-loader` can also be applied in combination with other pre-processors mentioned above.

## [#](https://vue-loader.vuejs.org/guide/pre-processors.html#babel)Babel

```bash
npm install -D babel-core babel-loader
// webpack.config.js -> module.rules
{
  test: /\.js?$/,
  loader: 'babel-loader'
}
```

Configuration of Babel can be done via `.babelrc` or `babel-loader` options.

### [#](https://vue-loader.vuejs.org/guide/pre-processors.html#excluding-node-modules)Excluding node_modules

It is common to have `exclude: /node_modules/` for JS transpilation rules (e.g. `babel-loader`) that apply to `.js` files. Due to the inference change of v15, if you import a Vue SFC inside `node_modules`, its `<script>` part will be excluded from transpilation as well.

In order to ensure JS transpilation is applied to Vue SFCs in `node_modules`, you need to whitelist them by using an exclude function instead:

```js
{
  test: /\.js$/,
  loader: 'babel-loader',
  exclude: file => (
    /node_modules/.test(file) &&
    !/\.vue\.js/.test(file)
  )
}
```

## [#](https://vue-loader.vuejs.org/guide/pre-processors.html#typescript)TypeScript

```bash
npm install -D typescript ts-loader
// webpack.config.js
module.exports = {
  resolve: {
    // Add `.ts` as a resolvable extension.
    extensions: ['.ts', '.js']
  },
  module: {
    rules: [
      // ... other rules omitted
      {
        test: /\.ts$/,
        loader: 'ts-loader',
        options: { appendTsSuffixTo: [/\.vue$/] }
      }
    ]
  },
  // ... plugin omitted
}
```

Configuration of TypeScipt can be done via `tsconfig.json`. Also see docs for [ts-loader](https://github.com/TypeStrong/ts-loader).

## [#](https://vue-loader.vuejs.org/guide/pre-processors.html#pug)Pug

Processing templates is a little different, because most webpack template loaders such as `pug-loader` return a template function instead of a compiled HTML string. Instead of using `pug-loader`, we need to use a loader that returns the raw HTML string, e.g. `pug-plain-loader`:

```bash
npm install -D pug pug-plain-loader
// webpack.config.js -> module.rules
{
  test: /\.pug$/,
  loader: 'pug-plain-loader'
}
```

Then you can write:

```html
<template lang="pug">
div
  h1 Hello world!
</template>
```

If you also intend to use it to import `.pug` files as HTML strings in JavaScript, you will need to chain `raw-loader` after the preprocessing loader. Note however adding `raw-loader` would break the usage in Vue components, so you need to have two rules, one of them targeting Vue files using a `resourceQuery`, the other one (fallback) targeting JavaScript imports:

```js
// webpack.config.js -> module.rules
{
  test: /\.pug$/,
  oneOf: [
    // this applies to `<template lang="pug">` in Vue components
    {
      resourceQuery: /^\?vue/,
      use: ['pug-plain-loader']
    },
    // this applies to pug imports inside JavaScript
    {
      use: ['raw-loader', 'pug-plain-loader']
    }
  ]
}
```

# Scoped CSS

# Scoped CSS

When a `<style>` tag has the `scoped` attribute, its CSS will apply to elements of the current component only. This is similar to the style encapsulation found in Shadow DOM. It comes with some caveats, but doesn't require any polyfills. It is achieved by using PostCSS to transform the following:

```html
<style scoped>
.example {
  color: red;
}
</style>

<template>
  <div class="example">hi</div>
</template>
```

Into the following:

```html
<style>
.example[data-v-f3f3eg9] {
  color: red;
}
</style>

<template>
  <div class="example" data-v-f3f3eg9>hi</div>
</template>
```

## Mixing Local and Global Styles

You can include both scoped and non-scoped styles in the same component:

```html
<style>
/* global styles */
</style>

<style scoped>
/* local styles */
</style>
```



## Child Component Root Elements

With `scoped`, the parent component's styles will not leak into child components. However, a child component's root node will be affected by both the parent's scoped CSS and the child's scoped CSS. This is by design so that the parent can style the child root element for layout purposes.

## [#](https://vue-loader.vuejs.org/guide/scoped-css.html#deep-selectors)Deep Selectors

If you want a selector in `scoped` styles to be "deep", i.e. affecting child components, you can use the `>>>` combinator:

```html
<style scoped>
.a >>> .b { /* ... */ }
</style>
```

The above will be compiled into:

```css
.a[data-v-f3f3eg9] .b { /* ... */ }
```

Some pre-processors, such as Sass, may not be able to parse `>>>` properly. In those cases you can use the `/deep/` or `::v-deep` combinator instead - both are aliases for `>>>` and work exactly the same.	

## Dynamically Generated Content

DOM content created with `v-html` are not affected by scoped styles, but you can still style them using deep selectors.

## [#](https://vue-loader.vuejs.org/guide/scoped-css.html#also-keep-in-mind)Also Keep in Mind

- **Scoped styles do not eliminate the need for classes**. Due to the way browsers render various CSS selectors, `p { color: red }` will be many times slower when scoped (i.e. when combined with an attribute selector). If you use classes or ids instead, such as in `.example { color: red }`, then you virtually eliminate that performance hit.
- **Be careful with descendant selectors in recursive components!** For a CSS rule with the selector `.a .b`, if the element that matches `.a` contains a recursive child component, then all `.b` in that child component will be matched by the rule.

# CSS Modules

[CSS Modules](https://github.com/css-modules/css-modules) is a popular system for modularizing and composing CSS. `vue-loader` provides first-class integration with CSS Modules as an alternative for simulated scoped CSS.

## [#](https://vue-loader.vuejs.org/guide/css-modules.html#usage)Usage

First, CSS Modules must be enabled by passing `modules: true` to `css-loader`:

```js
// webpack.config.js
{
  module: {
    rules: [
      // ... other rules omitted
      {
        test: /\.css$/,
        use: [
          'vue-style-loader',
          {
            loader: 'css-loader',
            options: {
              // enable CSS Modules
              modules: true,
              // customize generated class names
              localIdentName: '[local]_[hash:base64:8]'
            }
          }
        ]
      }
    ]
  }
}
```

Then, add the `module` attribute to your `<style>`:

```vue
<style module>
.red {
  color: red;
}
.bold {
  font-weight: bold;
}
</style>
```

The `module` attribute instructs Vue Loader to inject the CSS modules locals object into the component as a computed property with the name `$style`. You can then use it in your templates with a dynamic class binding:

```vue
<template>
  <p :class="$style.red">
    This should be red
  </p>
</template>
```

Since it's a computed property, it also works with the object/array syntax of `:class`:

```vue
<template>
  <div>
    <p :class="{ [$style.red]: isRed }">
      Am I red?
    </p>
    <p :class="[$style.red, $style.bold]">
      Red and bold
    </p>
  </div>
</template>
```

And you can also access it from JavaScript:

```vue
<script>
export default {
  created () {
    console.log(this.$style.red)
    // -> "red_1VyoJ-uZ"
    // an identifier generated based on filename and className.
  }
}
</script>
```

Refer to the [CSS Modules spec](https://github.com/css-modules/css-modules) for mode details such as [global exceptions](https://github.com/css-modules/css-modules#exceptions) and [composition](https://github.com/css-modules/css-modules#composition).

## Opt-in Usage

If you only want to use CSS Modules in some of your Vue components, you can use a `oneOf` rule and check for the `module` string in `resourceQuery`:

```js
// webpack.config.js -> module.rules
{
  test: /\.css$/,
  oneOf: [
    // this matches `<style module>`
    {
      resourceQuery: /module/,
      use: [
        'vue-style-loader',
        {
          loader: 'css-loader',
          options: {
            modules: true,
            localIdentName: '[local]_[hash:base64:5]'
          }
        }
      ]
    },
    // this matches plain `<style>` or `<style scoped>`
    {
      use: [
        'vue-style-loader',
        'css-loader'
      ]
    }
  ]
}
```

## [#](https://vue-loader.vuejs.org/guide/css-modules.html#using-with-pre-processors)Using with Pre-Processors

CSS Modules can be used along with other pre-processors:

```js
// webpack.config.js -> module.rules
{
  test: /\.scss$/,
  use: [
    'vue-style-loader',
    {
      loader: 'css-loader',
      options: { modules: true }
    },
    'sass-loader'
  ]
}
```

## [#](https://vue-loader.vuejs.org/guide/css-modules.html#custom-inject-name)Custom Inject Name

You can have more than one `<style>` tags in a single `*.vue` component. To avoid injected styles to overwrite each other, you can customize the name of the injected computed property by giving the `module` attribute a value:

```html
<style module="a">
  /* identifiers injected as a */
</style>

<style module="b">
  /* identifiers injected as b */
</style>
```

# Vue Single-File Component (SFC) Spec

## Intro

A `*.vue` file is a custom file format that uses HTML-like syntax to describe a Vue component. Each `*.vue` file consists of three types of top-level language blocks: `<template>`, `<script>`, and `<style>`, and optionally additional custom blocks:

```vue
<template>
  <div class="example">{{ msg }}</div>
</template>

<script>
export default {
  data () {
    return {
      msg: 'Hello world!'
    }
  }
}
</script>

<style>
.example {
  color: red;
}
</style>

<custom1>
  This could be e.g. documentation for the component.
</custom1>
```

`vue-loader` will parse the file, extract each language block, pipe them through other loaders if necessary, and finally assemble them back into an ES Module whose default export is a Vue.js component options object.

`vue-loader` supports using non-default languages, such as CSS pre-processors and compile-to-HTML template languages, by specifying the `lang` attribute for a language block. For example, you can use Sass for the style of your component like this:

```vue
<style lang="sass">
  /* write Sass! */
</style>
```

More details can be found in [Using Pre-Processors](https://vue-loader.vuejs.org/guide/pre-processors.html).

## Language Blocks

### [#](https://vue-loader.vuejs.org/spec.html#template)Template

- Each `*.vue` file can contain at most one `<template>` block at a time.
- Contents will be extracted and passed on to `vue-template-compiler` and pre-compiled into JavaScript render functions, and finally injected into the exported component in the `<script>` section.

### [#](https://vue-loader.vuejs.org/spec.html#script)Script

- Each `*.vue` file can contain at most one `<script>` block at a time.
- The script is executed as an ES Module.
- The **default export** should be a Vue.js [component options object](https://vuejs.org/v2/api/#Options-Data). Exporting an extended constructor created by `Vue.extend()` is also supported, but a plain object is preferred.
- Any webpack rules that match against `.js` files (or the extension specified by the `lang` attribute) will be applied to contents in the `<script>` block as well.

### [#](https://vue-loader.vuejs.org/spec.html#style)Style

- Default match: `/\.css$/`.
- A single `*.vue` file can contain multiple `<style>` tags.
- A `<style>` tag can have `scoped` or `module` attributes (see [Scoped CSS](https://vue-loader.vuejs.org/guide/scoped-css.html) and [CSS Modules](https://vue-loader.vuejs.org/guide/css-modules.html)) to help encapsulate the styles to the current component. Multiple `<style>` tags with different encapsulation modes can be mixed in the same component.
- Any webpack rules that match against `.css` files (or the extension specified by the `lang` attribute) will be applied to contents in the `<style>` blocks as well.

### [#](https://vue-loader.vuejs.org/spec.html#custom-blocks)Custom Blocks

Additional custom blocks can be included in a `*.vue` file for any project specific needs, for example a `<docs>` block. `vue-loader` will use the tag name to look up which webpack loaders should be applied to the contents of the section. The webpack loaders should be specified in the `loaders` section of `vue-loader` options.

For more details, see [Custom Blocks](https://vue-loader.vuejs.org/guide/custom-blocks.html).

### [#](https://vue-loader.vuejs.org/spec.html#src-imports)Src Imports

If you prefer splitting up your `*.vue` components into multiple files, you can use the `src` attribute to import an external file for a language block:

```vue
<template src="./template.html"></template>
<style src="./style.css"></style>
<script src="./script.js"></script>
```

Beware that `src` imports follow the same path resolution rules to webpack module requests, which means:

- Relative paths need to start with `./`
- You can import resources from npm dependencies:

```vue
<!-- import a file from the installed "todomvc-app-css" npm package -->
<style src="todomvc-app-css/index.css">
```

`src` imports also work with custom blocks, e.g.:

```vue
<unit-test src="./unit-test.js">
</unit-test>
```

## [#](https://vue-loader.vuejs.org/spec.html#syntax-highlighting-ide-support)Syntax Highlighting / IDE Support

Currently there is syntax highlighting support for the following IDE/editors:

- [Sublime Text](https://github.com/vuejs/vue-syntax-highlight)
- [VS Code](https://marketplace.visualstudio.com/items?itemName=octref.vetur)
- [Atom](https://atom.io/packages/language-vue)
- [Vim](https://github.com/posva/vim-vue)
- [Emacs](https://github.com/AdamNiederer/vue-mode)
- [Brackets](https://github.com/pandao/brackets-vue)
- [JetBrains IDEs](https://plugins.jetbrains.com/plugin/8057) (WebStorm, PhpStorm, etc)

Contributions for other editors/IDEs are highly appreciated! If you are not using any pre-processors in Vue components, you can also get decent syntax highlighting by treating `*.vue` files as HTML in your editor.

## [#](https://vue-loader.vuejs.org/spec.html#comments)Comments

Inside each block you shall use the comment syntax of the language being used (HTML, CSS, JavaScript, Jade, etc). For top-level comments, use HTML comment syntax: `<!-- comment contents here -->`


# <!--[Vue Router](https://router.vuejs.org/)-->

#  Introduction

VERSION NOTE

For TypeScript users, `vue-router@3.0+` requires `vue@2.5+`, and vice versa.

[Watch a free video course about Vue Router on Vue School](https://vueschool.io/courses/vue-router-for-everyone?friend=vuejs)

Vue Router is the official router for [Vue.js](http://vuejs.org/). It deeply integrates with Vue.js core to make building Single Page Applications with Vue.js a breeze. Features include:

- Nested route/view mapping
- Modular, component-based router configuration
- Route params, query, wildcards
- View transition effects powered by Vue.js' transition system
- Fine-grained navigation control
- Links with automatic active CSS classes
- HTML5 history mode or hash mode, with auto-fallback in IE9
- Customizable Scroll Behavior

[Get started](https://router.vuejs.org/guide/) or play with the [examples](https://github.com/vuejs/vue-router/tree/dev/examples) (see [`README.md`](https://github.com/vuejs/vue-router/) to run them).

# Getting Started

Creating a Single-page Application with Vue + Vue Router is dead simple. With Vue.js, we are already composing our application with components. When adding Vue Router to the mix, all we need to do is map our components to the routes and let Vue Router know where to render them. Here's a basic example:

## [#](https://router.vuejs.org/guide/#html)HTML

```html
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script src="https://unpkg.com/vue-router/dist/vue-router.js"></script>

<div id="app">
  <h1>Hello App!</h1>
  <p>
    <!-- use router-link component for navigation. -->
    <!-- specify the link by passing the `to` prop. -->
    <!-- `<router-link>` will be rendered as an `<a>` tag by default -->
    <router-link to="/foo">Go to Foo</router-link>
    <router-link to="/bar">Go to Bar</router-link>
  </p>
  <!-- route outlet -->
  <!-- component matched by the route will render here -->
  <router-view></router-view>
</div>
```

## [#](https://router.vuejs.org/guide/#javascript)JavaScript

```js
// 0. If using a module system (e.g. via vue-cli), import Vue and VueRouter
// and then call `Vue.use(VueRouter)`.

// 1. Define route components.
// These can be imported from other files
const Foo = { template: '<div>foo</div>' }
const Bar = { template: '<div>bar</div>' }

// 2. Define some routes
// Each route should map to a component. The "component" can
// either be an actual component constructor created via
// `Vue.extend()`, or just a component options object.
// We'll talk about nested routes later.
const routes = [
  { path: '/foo', component: Foo },
  { path: '/bar', component: Bar }
]

// 3. Create the router instance and pass the `routes` option
// You can pass in additional options here, but let's
// keep it simple for now.
const router = new VueRouter({
  routes // short for `routes: routes`
})

// 4. Create and mount the root instance.
// Make sure to inject the router with the router option to make the
// whole app router-aware.
const app = new Vue({
  router
}).$mount('#app')

// Now the app has started!
```

By injecting the router, we get access to it as `this.$router` as well as the current route as `this.$route` inside of any component:

```js
// Home.vue
export default {
  computed: {
    username() {
      // We will see what `params` is shortly
      return this.$route.params.username
    }
  },
  methods: {
    goBack() {
      window.history.length > 1 ? this.$router.go(-1) : this.$router.push('/')
    }
  }
}
```

Throughout the docs, we will often use the `router` instance. Keep in mind that `this.$router` is exactly the same as using `router`. The reason we use `this.$router` is because we don't want to import the router in every single component that needs to manipulate routing.

You can also check out this example [live](https://jsfiddle.net/yyx990803/xgrjzsup/).

Notice that a `<router-link>` automatically gets the `.router-link-active` class when its target route is matched. You can learn more about it in its [API reference](https://router.vuejs.org/api/#router-link).



# Dynamic Route Matching

Very often we will need to map routes with the given pattern to the same component. For example we may have a `User` component which should be rendered for all users but with different user IDs. In `vue-router` we can use a dynamic segment in the path to achieve that:

```js
const User = {
  template: '<div>User</div>'
}

const router = new VueRouter({
  routes: [
    // dynamic segments start with a colon
    { path: '/user/:id', component: User }
  ]
})
```

Now URLs like `/user/foo` and `/user/bar` will both map to the same route.

A dynamic segment is denoted by a colon `:`. When a route is matched, the value of the dynamic segments will be exposed as `this.$route.params` in every component. Therefore, we can render the current user ID by updating `User`'s template to this:

```js
const User = {
  template: '<div>User {{ $route.params.id }}</div>'
}
```

You can check out a live example [here](https://jsfiddle.net/yyx990803/4xfa2f19/).

You can have multiple dynamic segments in the same route, and they will map to corresponding fields on `$route.params`. Examples:

| pattern                       | matched path        | $route.params                          |
| ----------------------------- | ------------------- | -------------------------------------- |
| /user/:username               | /user/evan          | `{ username: 'evan' }`                 |
| /user/:username/post/:post_id | /user/evan/post/123 | `{ username: 'evan', post_id: '123' }` |

In addition to `$route.params`, the `$route` object also exposes other useful information such as `$route.query` (if there is a query in the URL), `$route.hash`, etc. You can check out the full details in the [API Reference](https://router.vuejs.org/api/#the-route-object).

## [#](https://router.vuejs.org/guide/essentials/dynamic-matching.html#reacting-to-params-changes)Reacting to Params Changes







