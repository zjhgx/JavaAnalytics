# Getting Started

webpack is used to compile JavaScript modules. Once [installed](https://webpack.js.org/guides/installation), you can interface with webpack either from its [CLI](https://webpack.js.org/api/cli) or [API](https://webpack.js.org/api/node). If you're still new to webpack, please read through the [core concepts](https://webpack.js.org/concepts) and [this comparison](https://webpack.js.org/comparison) to learn why you might use it over the other tools that are out in the community.

> Since webpack v5.0.0-beta.1 the minimum Node.js version to run webpack is 10.13.0 (LTS)

## Basic Setup

First let's create a directory, initialize npm, [install webpack locally](https://webpack.js.org/guides/installation/#local-installation), and install the webpack-cli (the tool used to run webpack on the command line):

```bash
mkdir webpack-demo
cd webpack-demo
npm init -y
npm install webpack webpack-cli --save-dev
```

> Throughout the Guides we will use `diff` blocks to show you what changes we're making to directories, files, and code.

Now we'll create the following directory structure, files and their contents:

**project**

```diff
  webpack-demo
  |- package.json
+ |- index.html
+ |- /src
+   |- index.js
```

**src/index.js**

```javascript
function component() {
  const element = document.createElement('div');

  // Lodash, currently included via a script, is required for this line to work
  element.innerHTML = _.join(['Hello', 'webpack'], ' ');

  return element;
}

document.body.appendChild(component());
```

**index.html**

```html
<!doctype html>
<html>
  <head>
    <title>Getting Started</title>
    <script src="https://unpkg.com/lodash@4.16.6"></script>
  </head>
  <body>
    <script src="./src/index.js"></script>
  </body>
</html>
```

We also need to adjust our `package.json` file in order to make sure we mark our package as `private`, as well as removing the `main` entry. This is to prevent an accidental publish of your code.

> If you want to learn more about the inner workings of `package.json`, then we recommend reading the [npm documentation](https://docs.npmjs.com/files/package.json).

**package.json**

```diff
  {
    "name": "webpack-demo",
    "version": "1.0.0",
    "description": "",
+   "private": true,
-   "main": "index.js",
    "scripts": {
      "test": "echo \"Error: no test specified\" && exit 1"
    },
    "keywords": [],
    "author": "",
    "license": "ISC",
    "devDependencies": {
      "webpack": "^4.20.2",
      "webpack-cli": "^3.1.2"
    },
    "dependencies": {}
  }
```

In this example, there are implicit dependencies between the `` tags. Our `index.js` file depends on `lodash` being included in the page before it runs. This is because `index.js` never explicitly declared a need for `lodash`; it just assumes that the global variable `_` exists.

There are problems with managing JavaScript projects this way:

- It is not immediately apparent that the script depends on an external library.
- If a dependency is missing, or included in the wrong order, the application will not function properly.
- If a dependency is included but not used, the browser will be forced to download unnecessary code.

Let's use webpack to manage these scripts instead.

## Creating a Bundle

First we'll tweak our directory structure slightly, separating the "source" code (`/src`) from our "distribution" code (`/dist`). The "source" code is the code that we'll write and edit. The "distribution" code is the minimized and optimized `output` of our build process that will eventually be loaded in the browser. Tweak the directory structure as follows:

**project**

```diff
  webpack-demo
  |- package.json
+ |- /dist
+   |- index.html
- |- index.html
  |- /src
    |- index.js
```

To bundle the `lodash` dependency with `index.js`, we'll need to install the library locally:

```bash
npm install --save lodash
```

> When installing a package that will be bundled into your production bundle, you should use `npm install --save`. If you're installing a package for development purposes (e.g. a linter, testing libraries, etc.) then you should use `npm install --save-dev`. More information can be found in the [npm documentation](https://docs.npmjs.com/cli/install).

Now, lets import `lodash` in our script:

**src/index.js**

```diff
+ import _ from 'lodash';
+
  function component() {
    const element = document.createElement('div');

-   // Lodash, currently included via a script, is required for this line to work
+   // Lodash, now imported by this script
    element.innerHTML = _.join(['Hello', 'webpack'], ' ');

    return element;
  }

  document.body.appendChild(component());
```

Now, since we'll be bundling our scripts, we have to update our `index.html` file. Let's remove the lodash ``, as we now `import` it, and modify the other `` tag to load the bundle, instead of the raw `/src` file:

**dist/index.html**

```diff
  <!doctype html>
  <html>
   <head>
     <title>Getting Started</title>
-    <script src="https://unpkg.com/lodash@4.16.6"></script>
   </head>
   <body>
-    <script src="./src/index.js"></script>
+    <script src="main.js"></script>
   </body>
  </html>
```

In this setup, `index.js` explicitly requires `lodash` to be present, and binds it as `_` (no global scope pollution). By stating what dependencies a module needs, webpack can use this information to build a dependency graph. It then uses the graph to generate an optimized bundle where scripts will be executed in the correct order.

With that said, let's run `npx webpack`, which will take our script at `src/index.js` as the [entry point](https://webpack.js.org/concepts/entry-points), and will generate `dist/main.js` as the [output](https://webpack.js.org/concepts/output). The `npx` command, which ships with Node 8.2/npm 5.2.0 or higher, runs the webpack binary (`./node_modules/.bin/webpack`) of the webpack package we installed in the beginning:

```bash
npx webpack

...
Built at: 13/06/2018 11:52:07
  Asset      Size  Chunks             Chunk Names
main.js  70.4 KiB       0  [emitted]  main
...

WARNING in configuration
The 'mode' option has not been set, webpack will fallback to 'production' for this value. Set 'mode' option to 'development' or 'production' to enable defaults for each environment.
You can also set it to 'none' to disable any default behavior. Learn more: https://webpack.js.org/configuration/mode/
```

> Your output may vary a bit, but if the build is successful then you are good to go. Also, don't worry about the warning, we'll tackle that later.

Open `index.html` from the `dist` directory in your browser and, if everything went right, you should see the following text: 'Hello webpack'.

> If you are getting a syntax error in the middle of minified JavaScript when opening `index.html` in the browser, set [`development mode`](https://webpack.js.org/configuration/mode/#mode-development) and run `npx webpack` again. This is related to running `npx webpack` on latest Node.js (v12.5+) instead of [LTS version](https://nodejs.org/en/).

## Modules

The [`import`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/import) and [`export`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/export) statements have been standardized in [ES2015](https://babeljs.io/docs/en/learn/). They are supported in most of the browsers at this moment, however there are some browsers that don't recognize the new syntax. But don't worry, webpack does support them out of the box.

Behind the scenes, webpack actually "transpiles" the code so that older browsers can also run it. If you inspect `dist/main.js`, you might be able to see how webpack does this, it's quite ingenious! Besides `import` and `export`, webpack supports various other module syntaxes as well, see [Module API](https://webpack.js.org/api/module-methods) for more information.

Note that webpack will not alter any code other than `import` and `export` statements. If you are using other [ES2015 features](http://es6-features.org/), make sure to [use a transpiler](https://webpack.js.org/loaders/#transpiling) such as [Babel](https://babeljs.io/) or [Bublé](https://buble.surge.sh/guide/) via webpack's [loader system](https://webpack.js.org/concepts/loaders/).

## Using a Configuration

As of version 4, webpack doesn't require any configuration, but most projects will need a more complex setup, which is why webpack supports a [configuration file](https://webpack.js.org/concepts/configuration). This is much more efficient than having to manually type in a lot of commands in the terminal, so let's create one:

**project**

```diff
  webpack-demo
  |- package.json
+ |- webpack.config.js
  |- /dist
    |- index.html
  |- /src
    |- index.js
```

**webpack.config.js**

```javascript
const path = require('path');

module.exports = {
  entry: './src/index.js',
  output: {
    filename: 'main.js',
    path: path.resolve(__dirname, 'dist'),
  },
};
```

Now, let's run the build again but instead using our new configuration file:

```bash
npx webpack --config webpack.config.js

...
  Asset      Size  Chunks             Chunk Names
main.js  70.4 KiB       0  [emitted]  main
...

WARNING in configuration
The 'mode' option has not been set, webpack will fallback to 'production' for this value. Set 'mode' option to 'development' or 'production' to enable defaults for each environment.
You can also set it to 'none' to disable any default behavior. Learn more: https://webpack.js.org/configuration/mode/
```

> If a `webpack.config.js` is present, the `webpack` command picks it up by default. We use the `--config` option here only to show that you can pass a configuration of any name. This will be useful for more complex configurations that need to be split into multiple files.

A configuration file allows far more flexibility than simple CLI usage. We can specify loader rules, plugins, resolve options and many other enhancements this way. See the [configuration documentation](https://webpack.js.org/configuration) to learn more.

## NPM Scripts

Given it's not particularly fun to run a local copy of webpack from the CLI, we can set up a little shortcut. Let's adjust our *package.json* by adding an [npm script](https://docs.npmjs.com/misc/scripts):

**package.json**

```diff
  {
    "name": "webpack-demo",
    "version": "1.0.0",
    "description": "",
    "scripts": {
-      "test": "echo \"Error: no test specified\" && exit 1"
+      "test": "echo \"Error: no test specified\" && exit 1",
+      "build": "webpack"
    },
    "keywords": [],
    "author": "",
    "license": "ISC",
    "devDependencies": {
      "webpack": "^4.20.2",
      "webpack-cli": "^3.1.2"
    },
    "dependencies": {
      "lodash": "^4.17.5"
    }
  }
```

Now the `npm run build` command can be used in place of the `npx` command we used earlier. Note that within `scripts` we can reference locally installed npm packages by name the same way we did with `npx`. This convention is the standard in most npm-based projects because it allows all contributors to use the same set of common scripts (each with flags like `--config` if necessary).

Now run the following command and see if your script alias works:

```bash
npm run build

...
  Asset      Size  Chunks             Chunk Names
main.js  70.4 KiB       0  [emitted]  main
...

WARNING in configuration
The 'mode' option has not been set, webpack will fallback to 'production' for this value. Set 'mode' option to 'development' or 'production' to enable defaults for each environment.
You can also set it to 'none' to disable any default behavior. Learn more: https://webpack.js.org/configuration/mode/.
```

> Custom parameters can be passed to webpack by adding two dashes between the `npm run build` command and your parameters, e.g. `npm run build -- --colors`.

## Conclusion

Now that you have a basic build together you should move on to the next guide [`Asset Management`](https://webpack.js.org/guides/asset-management) to learn how to manage assets like images and fonts with webpack. At this point, your project should look like this:

**project**

```diff
webpack-demo
|- package.json
|- webpack.config.js
|- /dist
  |- main.js
  |- index.html
|- /src
  |- index.js
|- /node_modules
```

> If you're using npm 5, you'll probably also see a `package-lock.json` file in your directory.

> Do not compile untrusted code with webpack. It could lead to execution of malicious code on your computer, remote servers, or in the Web browsers of the end users of your application.

If you want to learn more about webpack's design, you can check out the [basic concepts](https://webpack.js.org/concepts) and [configuration](https://webpack.js.org/configuration) pages. Furthermore, the [API](https://webpack.js.org/api) section digs into the various interfaces webpack offers.



# Asset Management

If you've been following the guides from the start, you will now have a small project that shows "Hello webpack". Now let's try to incorporate some other assets, like images, to see how they can be handled.

Prior to webpack, front-end developers would use tools like grunt and gulp to process these assets and move them from their `/src` folder into their `/dist` or `/build` directory. The same idea was used for JavaScript modules, but tools like webpack will **dynamically bundle** all dependencies (creating what's known as a [dependency graph](https://webpack.js.org/concepts/dependency-graph)). This is great because every module now *explicitly states its dependencies* and we'll avoid bundling modules that aren't in use.

One of the coolest webpack features is that you can also *include any other type of file*, besides JavaScript, for which there is a loader. This means that the same benefits listed above for JavaScript (e.g. explicit dependencies) can be applied to everything used in building a website or web app. Let's start with CSS, as you may already be familiar with that setup.

## Setup

Let's make a minor change to our project before we get started:

**dist/index.html**

```diff
  <!doctype html>
  <html>
    <head>
-    <title>Getting Started</title>
+    <title>Asset Management</title>
    </head>
    <body>
-     <script src="main.js"></script>
+     <script src="bundle.js"></script>
    </body>
  </html>
```

**webpack.config.js**

```diff
  const path = require('path');

  module.exports = {
    entry: './src/index.js',
    output: {
-     filename: 'main.js',
+     filename: 'bundle.js',
      path: path.resolve(__dirname, 'dist'),
    },
  };
```

## Loading CSS

In order to `import` a CSS file from within a JavaScript module, you need to install and add the [style-loader](https://webpack.js.org/loaders/style-loader) and [css-loader](https://webpack.js.org/loaders/css-loader) to your [`module` configuration](https://webpack.js.org/configuration/module):

```bash
npm install --save-dev style-loader css-loader
```

**webpack.config.js**

```diff
  const path = require('path');

  module.exports = {
    entry: './src/index.js',
    output: {
      filename: 'bundle.js',
      path: path.resolve(__dirname, 'dist'),
    },
+   module: {
+     rules: [
+       {
+         test: /\.css$/,
+         use: [
+           'style-loader',
+           'css-loader',
+         ],
+       },
+     ],
+   },
  };
```

> webpack uses a regular expression to determine which files it should look for and serve to a specific loader. In this case, any file that ends with `.css` will be served to the `style-loader` and the `css-loader`.

This enables you to `import './style.css'` into the file that depends on that styling. Now, when that module is run, a `<style>` tag with the stringified css will be inserted into the `<head>` of your html file.

> 我的理解是import ./css这种形式只有安装了相应loader之后才行，一般的ES2015是不支持的

Let's try it out by adding a new `style.css` file to our project and import it in our `index.js`:

**project**

```diff
  webpack-demo
  |- package.json
  |- webpack.config.js
  |- /dist
    |- bundle.js
    |- index.html
  |- /src
+   |- style.css
    |- index.js
  |- /node_modules
```

**src/style.css**

```css
.hello {
  color: red;
}
```

**src/index.js**

```diff
  import _ from 'lodash';
+ import './style.css';

  function component() {
    const element = document.createElement('div');

    // Lodash, now imported by this script
    element.innerHTML = _.join(['Hello', 'webpack'], ' ');
+   element.classList.add('hello');

    return element;
  }

  document.body.appendChild(component());
```



Now run your build command:

```bash
npm run build

...
    Asset      Size  Chunks             Chunk Names
bundle.js  76.4 KiB       0  [emitted]  main
Entrypoint main = bundle.js
...
```

Open up `index.html` in your browser again and you should see that `Hello webpack` is now styled in red. To see what webpack did, inspect the page (don't view the page source, as it won't show you the result, because the `` tag is dynamically created by JavaScript) and look at the page's head tags. It should contain the style block that we imported in `index.js`.

Note that you can, and in most cases should, [minimize css](https://webpack.js.org/plugins/mini-css-extract-plugin/#minimizing-for-production) for better load times in production. On top of that, loaders exist for pretty much any flavor of CSS you can think of -- [postcss](https://webpack.js.org/loaders/postcss-loader), [sass](https://webpack.js.org/loaders/sass-loader), and [less](https://webpack.js.org/loaders/less-loader) to name a few.

## Loading Images

So now we're pulling in our CSS, but what about our images like backgrounds and icons? Using the [file-loader](https://webpack.js.org/loaders/file-loader) we can easily incorporate those in our system as well:

```bash
npm install --save-dev file-loader
```

**webpack.config.js**

```diff
  const path = require('path');

  module.exports = {
    entry: './src/index.js',
    output: {
      filename: 'bundle.js',
      path: path.resolve(__dirname, 'dist'),
    },
    module: {
      rules: [
        {
          test: /\.css$/,
          use: [
            'style-loader',
            'css-loader'
          ],
        },
+       {
+         test: /\.(png|svg|jpg|gif)$/,
+         use: [
+           'file-loader',
+         ],
+       },
      ],
    },
  };
```

Now, when you `import MyImage from './my-image.png'`, that image will be processed and added to your `output` directory *and* the `MyImage` variable will contain the final url of that image after processing. When using the [css-loader](https://webpack.js.org/loaders/css-loader), as shown above, a similar process will occur for `url('./my-image.png')` within your CSS. The loader will recognize this is a local file, and replace the `'./my-image.png'` path with the final path to the image in your `output` directory. The [html-loader](https://webpack.js.org/loaders/html-loader) handles `` in the same manner.

Let's add an image to our project and see how this works, you can use any image you like:

**project**

```diff
  webpack-demo
  |- package.json
  |- webpack.config.js
  |- /dist
    |- bundle.js
    |- index.html
  |- /src
+   |- icon.png
    |- style.css
    |- index.js
  |- /node_modules
```

**src/index.js**

```diff
  import _ from 'lodash';
  import './style.css';
+ import Icon from './icon.png';

  function component() {
    const element = document.createElement('div');

    // Lodash, now imported by this script
    element.innerHTML = _.join(['Hello', 'webpack'], ' ');
    element.classList.add('hello');

+   // Add the image to our existing div.
+   const myIcon = new Image();
+   myIcon.src = Icon;
+
+   element.appendChild(myIcon);

    return element;
  }

  document.body.appendChild(component());
```

**src/style.css**

```diff
  .hello {
    color: red;
+   background: url('./icon.png');
  }
```

Let's create a new build and open up the index.html file again:

```bash
npm run build

...
                               Asset      Size  Chunks                    Chunk Names
da4574bb234ddc4bb47cbe1ca4b20303.png  3.01 MiB          [emitted]  [big]
                           bundle.js  76.7 KiB       0  [emitted]         main
Entrypoint main = bundle.js
...
```

If all went well, you should now see your icon as a repeating background, as well as an `img` element beside our `Hello webpack` text. If you inspect this element, you'll see that the actual filename has changed to something like `5c999da72346a995e7e2718865d019c8.png`. This means webpack found our file in the `src` folder and processed it!

> A logical next step from here is minifying and optimizing your images. Check out the [image-webpack-loader](https://github.com/tcoopman/image-webpack-loader) and [url-loader](https://webpack.js.org/loaders/url-loader) for more on how you can enhance your image loading process.

## Loading Fonts

So what about other assets like fonts? The file and url loaders will take any file you load through them and output it to your build directory. This means we can use them for any kind of file, including fonts. Let's update our `webpack.config.js` to handle font files:

**webpack.config.js**

```diff
  const path = require('path');

  module.exports = {
    entry: './src/index.js',
    output: {
      filename: 'bundle.js',
      path: path.resolve(__dirname, 'dist'),
    },
    module: {
      rules: [
        {
          test: /\.css$/,
          use: [
            'style-loader',
            'css-loader'
          ],
        },
        {
          test: /\.(png|svg|jpg|gif)$/,
          use: [
            'file-loader',
          ],
        },
+       {
+         test: /\.(woff|woff2|eot|ttf|otf)$/,
+         use: [
+           'file-loader',
+         ],
+       },
      ],
    },
  };
```

Add some font files to your project:

**project**

```diff
  webpack-demo
  |- package.json
  |- webpack.config.js
  |- /dist
    |- bundle.js
    |- index.html
  |- /src
+   |- my-font.woff
+   |- my-font.woff2
    |- icon.png
    |- style.css
    |- index.js
  |- /node_modules
```

With the loader configured and fonts in place, you can incorporate them via an `@font-face` declaration. The local `url(...)` directive will be picked up by webpack just as it was with the image:

**src/style.css**

```diff
+ @font-face {
+   font-family: 'MyFont';
+   src:  url('./my-font.woff2') format('woff2'),
+         url('./my-font.woff') format('woff');
+   font-weight: 600;
+   font-style: normal;
+ }

  .hello {
    color: red;
+   font-family: 'MyFont';
    background: url('./icon.png');
  }
```

Now run a new build and let's see if webpack handled our fonts:

```bash
npm run build

...
                                 Asset      Size  Chunks                    Chunk Names
5439466351d432b73fdb518c6ae9654a.woff2  19.5 KiB          [emitted]
 387c65cc923ad19790469cfb5b7cb583.woff  23.4 KiB          [emitted]
  da4574bb234ddc4bb47cbe1ca4b20303.png  3.01 MiB          [emitted]  [big]
                             bundle.js    77 KiB       0  [emitted]         main
Entrypoint main = bundle.js
...
```

Open up `index.html` again and see if our `Hello webpack` text has changed to the new font. If all is well, you should see the changes.

## Loading Data

Another useful asset that can be loaded is data, like JSON files, CSVs, TSVs, and XML. Support for JSON is actually built-in, similar to NodeJS, meaning `import Data from './data.json'` will work by default. To import CSVs, TSVs, and XML you could use the [csv-loader](https://github.com/theplatapi/csv-loader) and [xml-loader](https://github.com/gisikw/xml-loader). Let's handle loading all three:

```bash
npm install --save-dev csv-loader xml-loader
```

**webpack.config.js**

```diff
  const path = require('path');

  module.exports = {
    entry: './src/index.js',
    output: {
      filename: 'bundle.js',
      path: path.resolve(__dirname, 'dist'),
    },
    module: {
      rules: [
        {
          test: /\.css$/,
          use: [
            'style-loader',
            'css-loader'
          ],
        },
        {
          test: /\.(png|svg|jpg|gif)$/,
          use: [
            'file-loader',
          ],
        },
        {
          test: /\.(woff|woff2|eot|ttf|otf)$/,
          use: [
            'file-loader',
          ],
        },
+       {
+         test: /\.(csv|tsv)$/,
+         use: [
+           'csv-loader',
+         ],
+       },
+       {
+         test: /\.xml$/,
+         use: [
+           'xml-loader',
+         ],
+       },
      ],
    },
  };
```

Add some data files to your project:

**project**

```diff
  webpack-demo
  |- package.json
  |- webpack.config.js
  |- /dist
    |- bundle.js
    |- index.html
  |- /src
+   |- data.xml
    |- my-font.woff
    |- my-font.woff2
    |- icon.png
    |- style.css
    |- index.js
  |- /node_modules
```

**src/data.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<note>
  <to>Mary</to>
  <from>John</from>
  <heading>Reminder</heading>
  <body>Call Cindy on Tuesday</body>
</note>
```

Now you can `import` any one of those four types of data (JSON, CSV, TSV, XML) and the `Data` variable you import, will contain parsed JSON for easy consumption:

**src/index.js**

```diff
  import _ from 'lodash';
  import './style.css';
  import Icon from './icon.png';
+ import Data from './data.xml';

  function component() {
    const element = document.createElement('div');

    // Lodash, now imported by this script
    element.innerHTML = _.join(['Hello', 'webpack'], ' ');
    element.classList.add('hello');

    // Add the image to our existing div.
    const myIcon = new Image();
    myIcon.src = Icon;

    element.appendChild(myIcon);

+   console.log(Data);

    return element;
  }

  document.body.appendChild(component());
```

Re-run the `npm run build` command and open `index.html`. If you look at the console in your developer tools, you should be able to see your imported data being logged to the console!

> This can be especially helpful when implementing some sort of data visualization using a tool like [d3](https://github.com/d3). Instead of making an ajax request and parsing the data at runtime you can load it into your module during the build process so that the parsed data is ready to go as soon as the module hits the browser.

> Only the default export of JSON modules can be used without warning.

```javascript
// No warning
import data from './data.json';

// Warning shown, this is not allowed by the spec.
import { foo } from './data.json';
```

## Global Assets

The coolest part of everything mentioned above, is that loading assets this way allows you to group modules and assets in a more intuitive way. Instead of relying on a global `/assets` directory that contains everything, you can group assets with the code that uses them. For example, a structure like this can be useful:

```diff
- |- /assets
+ |– /components
+ |  |– /my-component
+ |  |  |– index.jsx
+ |  |  |– index.css
+ |  |  |– icon.svg
+ |  |  |– img.png
```

This setup makes your code a lot more portable as everything that is closely coupled now lives together. Let's say you want to use `/my-component` in another project, simply copy or move it into the `/components` directory over there. As long as you've installed any *external dependencies* and your *configuration has the same loaders* defined, you should be good to go.

However, let's say you're locked into your old ways or you have some assets that are shared between multiple components (views, templates, modules, etc.). It's still possible to store these assets in a base directory and even use [aliasing](https://webpack.js.org/configuration/resolve/#resolvealias) to make them easier to `import`.

## Wrapping up

For the next guides we won't be using all the different assets we've used in this guide, so let's do some cleanup so we're prepared for the next piece of the guides [Output Management](https://webpack.js.org/guides/output-management/):

**project**

```diff
  webpack-demo
  |- package.json
  |- webpack.config.js
  |- /dist
    |- bundle.js
    |- index.html
  |- /src
-   |- data.xml
-   |- my-font.woff
-   |- my-font.woff2
-   |- icon.png
-   |- style.css
    |- index.js
  |- /node_modules
```

**webpack.config.js**

```diff
  const path = require('path');

  module.exports = {
    entry: './src/index.js',
    output: {
      filename: 'bundle.js',
      path: path.resolve(__dirname, 'dist'),
    },
-   module: {
-     rules: [
-       {
-         test: /\.css$/,
-         use: [
-           'style-loader',
-           'css-loader',
-         ],
-       },
-       {
-         test: /\.(png|svg|jpg|gif)$/,
-         use: [
-           'file-loader',
-         ],
-       },
-       {
-         test: /\.(woff|woff2|eot|ttf|otf)$/,
-         use: [
-           'file-loader',
-         ],
-       },
-       {
-         test: /\.(csv|tsv)$/,
-         use: [
-           'csv-loader',
-         ],
-       },
-       {
-         test: /\.xml$/,
-         use: [
-           'xml-loader',
-         ],
-       },
-     ],
-   },
  };
```

**src/index.js**

```diff
  import _ from 'lodash';
- import './style.css';
- import Icon from './icon.png';
- import Data from './data.xml';
-
  function component() {
    const element = document.createElement('div');
-
-   // Lodash, now imported by this script
    element.innerHTML = _.join(['Hello', 'webpack'], ' ');
-   element.classList.add('hello');
-
-   // Add the image to our existing div.
-   const myIcon = new Image();
-   myIcon.src = Icon;
-
-   element.appendChild(myIcon);
-
-   console.log(Data);

    return element;
  }

  document.body.appendChild(component());
```

# Output Management

> This guide extends on code examples found in the [`Asset Management`](https://webpack.js.org/guides/asset-management) guide.

So far we've manually included all our assets in our `index.html` file, but as your application grows and once you start [using hashes in filenames](https://webpack.js.org/guides/caching) and outputting [multiple bundles](https://webpack.js.org/guides/code-splitting), it will be difficult to keep managing your `index.html` file manually. However, a few plugins exist that will make this process much easier to manage.

## Preparation

First, let's adjust our project a little bit:

**project**

```diff
  webpack-demo
  |- package.json
  |- webpack.config.js
  |- /dist
  |- /src
    |- index.js
+   |- print.js
  |- /node_modules
```

Let's add some logic to our `src/print.js` file:

**src/print.js**

```js
export default function printMe() {
  console.log('I get called from print.js!');
}
```

And use that function in our `src/index.js` file:

**src/index.js**

```diff
  import _ from 'lodash';
+ import printMe from './print.js';

  function component() {
    const element = document.createElement('div');
+   const btn = document.createElement('button');

    element.innerHTML = _.join(['Hello', 'webpack'], ' ');

+   btn.innerHTML = 'Click me and check the console!';
+   btn.onclick = printMe;
+
+   element.appendChild(btn);

    return element;
  }

  document.body.appendChild(component());
```

Let's also update our `dist/index.html` file, in preparation for webpack to split out entries:

**dist/index.html**

```diff
  <!doctype html>
  <html>
    <head>
-     <title>Asset Management</title>
+     <title>Output Management</title>
+     <script src="./print.bundle.js"></script>
    </head>
    <body>
-     <script src="./bundle.js"></script>
+     <script src="./app.bundle.js"></script>
    </body>
  </html>
```

Now adjust the config. We'll be adding our `src/print.js` as a new entry point (`print`) and we'll change the output as well, so that it will dynamically generate bundle names, based on the entry point names:

**webpack.config.js**

```diff
  const path = require('path');

  module.exports = {
-   entry: './src/index.js',
+   entry: {
+     app: './src/index.js',
+     print: './src/print.js',
+   },
    output: {
-     filename: 'bundle.js',
+     filename: '[name].bundle.js',
      path: path.resolve(__dirname, 'dist'),
    },
  };
```

Let's run `npm run build` and see what this generates:

```bash
...
          Asset     Size  Chunks                    Chunk Names
  app.bundle.js   545 kB    0, 1  [emitted]  [big]  app
print.bundle.js  2.74 kB       1  [emitted]         print
...
```

We can see that webpack generates our `print.bundle.js` and `app.bundle.js` files, which we also specified in our `index.html` file. if you open `index.html` in your browser, you can see what happens when you click the button.

But what would happen if we changed the name of one of our entry points, or even added a new one? The generated bundles would be renamed on a build, but our `index.html` file would still reference the old names. Let's fix that with the [`HtmlWebpackPlugin`](https://webpack.js.org/plugins/html-webpack-plugin).

## Setting up HtmlWebpackPlugin

First install the plugin and adjust the `webpack.config.js` file:

```bash
npm install --save-dev html-webpack-plugin
```

**webpack.config.js**

```diff
  const path = require('path');
+ const HtmlWebpackPlugin = require('html-webpack-plugin');

  module.exports = {
    entry: {
      app: './src/index.js',
      print: './src/print.js',
    },
+   plugins: [
+     new HtmlWebpackPlugin({
+       title: 'Output Management',
+     }),
+   ],
    output: {
      filename: '[name].bundle.js',
      path: path.resolve(__dirname, 'dist'),
    },
  };
```

Before we do a build, you should know that the `HtmlWebpackPlugin` by default will generate its own `index.html` file, even though we already have one in the `dist/` folder. This means that it will replace our `index.html` file with a newly generated one. Let's see what happens when we do an `npm run build`:

```bash
...
           Asset       Size  Chunks                    Chunk Names
 print.bundle.js     544 kB       0  [emitted]  [big]  print
   app.bundle.js    2.81 kB       1  [emitted]         app
      index.html  249 bytes          [emitted]
...
```

If you open `index.html` in your code editor, you'll see that the `HtmlWebpackPlugin` has created an entirely new file for you and that all the bundles are automatically added.

If you want to learn more about all the features and options that the `HtmlWebpackPlugin` provides, then you should read up on it on the [`HtmlWebpackPlugin`](https://github.com/jantimon/html-webpack-plugin) repo.

You can also take a look at [`html-webpack-template`](https://github.com/jaketrent/html-webpack-template) which provides a couple of extra features in addition to the default template.

## Cleaning up the`/dist`folder

As you might have noticed over the past guides and code example, our `/dist` folder has become quite cluttered. Webpack will generate the files and put them in the `/dist` folder for you, but it doesn't keep track of which files are actually in use by your project.

In general it's good practice to clean the `/dist` folder before each build, so that only used files will be generated. Let's take care of that.

A popular plugin to manage this is the [`clean-webpack-plugin`](https://www.npmjs.com/package/clean-webpack-plugin) so let's install and configure it.

```bash
npm install --save-dev clean-webpack-plugin
```

**webpack.config.js**

```diff
  const path = require('path');
  const HtmlWebpackPlugin = require('html-webpack-plugin');
+ const { CleanWebpackPlugin } = require('clean-webpack-plugin');

  module.exports = {
    entry: {
      app: './src/index.js',
      print: './src/print.js',
    },
    plugins: [
+     new CleanWebpackPlugin(),
      new HtmlWebpackPlugin({
        title: 'Output Management',
      }),
    ],
    output: {
      filename: '[name].bundle.js',
      path: path.resolve(__dirname, 'dist'),
    },
  };
```

Now run an `npm run build` and inspect the `/dist` folder. If everything went well you should now only see the files generated from the build and no more old files!

## The Manifest

You might be wondering how webpack and its plugins seem to "know" what files are being generated. The answer is in the manifest that webpack keeps to track how all the modules map to the output bundles. If you're interested in managing webpack's [`output`](https://webpack.js.org/configuration/output) in other ways, the manifest would be a good place to start.

The manifest data can be extracted into a json file for easy consumption using the [`WebpackManifestPlugin`](https://github.com/danethurber/webpack-manifest-plugin).

We won't go through a full example of how to use this plugin within your projects, but you can read up on [the concept page](https://webpack.js.org/concepts/manifest) and the [caching guide](https://webpack.js.org/guides/caching) to find out how this ties into long term caching.

## Conclusion

Now that you've learned about dynamically adding bundles to your HTML, let's dive into the [development guide](https://webpack.js.org/guides/development). Or, if you want to dig into more advanced topics, we would recommend heading over to the [code splitting guide](https://webpack.js.org/guides/code-splitting).



# Development





# Code Splitting

> This guide extends the examples provided in [Getting Started](https://webpack.js.org/guides/getting-started) and [Output Management](https://webpack.js.org/guides/output-management). Please make sure you are at least familiar with the examples provided in them.

Code splitting is one of the most compelling features of webpack. This feature allows you to split your code into various bundles which can then be loaded on demand or in parallel. It can be used to achieve smaller bundles and control resource load prioritization which, if used correctly, can have a major impact on load time.

There are three general approaches to code splitting available:

- Entry Points: Manually split code using [`entry`](https://webpack.js.org/configuration/entry-context) configuration.
- Prevent Duplication: Use the [`SplitChunksPlugin`](https://webpack.js.org/plugins/split-chunks-plugin/) to dedupe and split chunks.
- Dynamic Imports: Split code via inline function calls within modules.

## Entry Points

This is by far the easiest and most intuitive way to split code. However, it is more manual and has some pitfalls we will go over. Let's take a look at how we might split another module from the main bundle:

**project**

```diff
webpack-demo
|- package.json
|- webpack.config.js
|- /dist
|- /src
  |- index.js
+ |- another-module.js
|- /node_modules
```

**another-module.js**

```js
import _ from 'lodash';

console.log(
  _.join(['Another', 'module', 'loaded!'], ' ')
);
```

**webpack.config.js**

```diff
const path = require('path');

module.exports = {
  mode: 'development',
  entry: {
    index: './src/index.js',
+   another: './src/another-module.js',
  },
  output: {
    filename: '[name].bundle.js',
    path: path.resolve(__dirname, 'dist'),
  },
};
```

This will yield the following build result:

```bash
...
            Asset     Size   Chunks             Chunk Names
another.bundle.js  550 KiB  another  [emitted]  another
  index.bundle.js  550 KiB    index  [emitted]  index
Entrypoint index = index.bundle.js
Entrypoint another = another.bundle.js
...
```

As mentioned there are some pitfalls to this approach:

- If there are any duplicated modules between entry chunks they will be included in both bundles.
- It isn't as flexible and can't be used to dynamically split code with the core application logic.

The first of these two points is definitely an issue for our example, as `lodash` is also imported within `./src/index.js` and will thus be duplicated in both bundles. Let's remove this duplication by using the [`SplitChunksPlugin`](https://v4.webpack.js.org/plugins/split-chunks-plugin/).

## Prevent Duplication

The [`SplitChunksPlugin`](https://v4.webpack.js.org/plugins/split-chunks-plugin/) allows us to extract common dependencies into an existing entry chunk or an entirely new chunk. Let's use this to de-duplicate the `lodash` dependency from the previous example:

> The `CommonsChunkPlugin` has been removed in webpack v4 legato. To learn how chunks are treated in the latest version, check out the [`SplitChunksPlugin`](https://v4.webpack.js.org/plugins/split-chunks-plugin/).

**webpack.config.js**

```diff
  const path = require('path');

  module.exports = {
    mode: 'development',
    entry: {
      index: './src/index.js',
      another: './src/another-module.js',
    },
    output: {
      filename: '[name].bundle.js',
      path: path.resolve(__dirname, 'dist'),
    },
+   optimization: {
+     splitChunks: {
+       chunks: 'all',
+     },
+   },
  };
```

With the [`optimization.splitChunks`](https://v4.webpack.js.org/plugins/split-chunks-plugin/#optimizationsplitchunks) configuration option in place, we should now see the duplicate dependency removed from our `index.bundle.js` and `another.bundle.js`. The plugin should notice that we've separated `lodash` out to a separate chunk and remove the dead weight from our main bundle. Let's do an `npm run build` to see if it worked:

```bash
...
                          Asset      Size                 Chunks             Chunk Names
              another.bundle.js  5.95 KiB                another  [emitted]  another
                index.bundle.js  5.89 KiB                  index  [emitted]  index
vendors~another~index.bundle.js   547 KiB  vendors~another~index  [emitted]  vendors~another~index
Entrypoint index = vendors~another~index.bundle.js index.bundle.js
Entrypoint another = vendors~another~index.bundle.js another.bundle.js
...
```

Here are some other useful plugins and loaders provided by the community for splitting code:

- [`mini-css-extract-plugin`](https://v4.webpack.js.org/plugins/mini-css-extract-plugin): Useful for splitting CSS out from the main application.
- [`bundle-loader`](https://v4.webpack.js.org/loaders/bundle-loader): Used to split code and lazy load the resulting bundles.
- [`promise-loader`](https://github.com/gaearon/promise-loader): Similar to the `bundle-loader` but uses promises.

## Dynamic Imports

Two similar techniques are supported by webpack when it comes to dynamic code splitting. The first and recommended approach is to use the [`import()` syntax](https://v4.webpack.js.org/api/module-methods/#import-1) that conforms to the [ECMAScript proposal](https://github.com/tc39/proposal-dynamic-import) for dynamic imports. The legacy, webpack-specific approach is to use [`require.ensure`](https://v4.webpack.js.org/api/module-methods/#requireensure). Let's try using the first of these two approaches...

> `import()` calls use [promises](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise) internally. If you use `import()` with older browsers, remember to shim `Promise` using a polyfill such as [es6-promise](https://github.com/stefanpenner/es6-promise) or [promise-polyfill](https://github.com/taylorhakes/promise-polyfill).

Before we start, let's remove the extra [`entry`](https://v4.webpack.js.org/concepts/entry-points/) and [`optimization.splitChunks`](https://v4.webpack.js.org/plugins/split-chunks-plugin) from our config as they won't be needed for this next demonstration:

**webpack.config.js**

```diff
  const path = require('path');

  module.exports = {
    mode: 'development',
    entry: {
      index: './src/index.js',
-     another: './src/another-module.js',
    },
    output: {
      filename: '[name].bundle.js',
+     chunkFilename: '[name].bundle.js',
      publicPath: 'dist/',
      path: path.resolve(__dirname, 'dist'),
    },
-   optimization: {
-     splitChunks: {
-       chunks: 'all',
-     },
-   },
  };
```

Note the use of `chunkFilename`, which determines the name of non-entry chunk files. For more information on `chunkFilename`, see [output documentation](https://v4.webpack.js.org/configuration/output/#outputchunkfilename). We'll also update our project to remove the now unused files:

**project**

```diff
webpack-demo
|- package.json
|- webpack.config.js
|- /dist
|- /src
  |- index.js
- |- another-module.js
|- /node_modules
```

Now, instead of statically importing `lodash`, we'll use dynamic importing to separate a chunk:

**src/index.js**

```diff
- import _ from 'lodash';
-
- function component() {
+ function getComponent() {
-   const element = document.createElement('div');
-
-   // Lodash, now imported by this script
-   element.innerHTML = _.join(['Hello', 'webpack'], ' ');
+   return import(/* webpackChunkName: "lodash" */ 'lodash').then(({ default: _ }) => {
+     const element = document.createElement('div');
+
+     element.innerHTML = _.join(['Hello', 'webpack'], ' ');
+
+     return element;
+
+   }).catch(error => 'An error occurred while loading the component');
  }

- document.body.appendChild(component());
+ getComponent().then(component => {
+   document.body.appendChild(component);
+ })
```

The reason we need `default` is that since webpack 4, when importing a CommonJS module, the import will no longer resolve to the value of `module.exports`, it will instead create an artificial namespace object for the CommonJS module. For more information on the reason behind this, read [webpack 4: import() and CommonJs](https://medium.com/webpack/webpack-4-import-and-commonjs-d619d626b655)

Note the use of `webpackChunkName` in the comment. This will cause our separate bundle to be named `lodash.bundle.js` instead of just `[id].bundle.js`. For more information on `webpackChunkName` and the other available options, see the [`import()` documentation](https://v4.webpack.js.org/api/module-methods/#import-1). Let's run webpack to see `lodash` separated out to a separate bundle:

```bash
...
                   Asset      Size          Chunks             Chunk Names
         index.bundle.js  7.88 KiB           index  [emitted]  index
vendors~lodash.bundle.js   547 KiB  vendors~lodash  [emitted]  vendors~lodash
Entrypoint index = index.bundle.js
...
```

As `import()` returns a promise, it can be used with [`async` functions](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/async_function). However, this requires using a pre-processor like Babel and the [Syntax Dynamic Import Babel Plugin](https://babeljs.io/docs/plugins/syntax-dynamic-import/#installation). Here's how it would simplify the code:

**src/index.js**

```diff
- function getComponent() {
+ async function getComponent() {
-   return import(/* webpackChunkName: "lodash" */ 'lodash').then(({ default: _ }) => {
-     const element = document.createElement('div');
-
-     element.innerHTML = _.join(['Hello', 'webpack'], ' ');
-
-     return element;
-
-   }).catch(error => 'An error occurred while loading the component');
+   const element = document.createElement('div');
+   const { default: _ } = await import(/* webpackChunkName: "lodash" */ 'lodash');
+
+   element.innerHTML = _.join(['Hello', 'webpack'], ' ');
+
+   return element;
  }

  getComponent().then(component => {
    document.body.appendChild(component);
  });
```

> It is possible to provide a [dynamic expression](https://v4.webpack.js.org/api/module-methods/#dynamic-expressions-in-import) to `import()` when you might need to import specific module based on a computed variable later.

## Prefetching/Preloading modules







# Configuration

Out of the box, webpack won't require you to use a configuration file. However, it will assume the entry point of your project is `src/index.js` and will output the result in `dist/main.js` minified and optimized for production.

Usually your projects will need to extend this functionality, for this you can create a `webpack.config.js` file in the root folder and webpack will automatically use it.

## Use different configuration file

If for some reason you want to use different configuration file depending on certain situations you can change this via command line by using the `--config` flag.

**package.json**

```js
"scripts": {
  "build": "webpack --config prod.config.js"
}
```

## Options

Click on the name of each option in the configuration code below to jump to the detailed documentation. Also note that the items with arrows can be expanded to show more examples and, in some cases, more advanced configuration.

> Notice that throughout the configuration we use Node's built-in [path module](https://nodejs.org/api/path.html) and prefix it with the [__dirname](https://nodejs.org/docs/latest/api/globals.html#globals_dirname) global. This prevents file path issues between operating systems and allows relative paths to work as expected. See [this section](https://nodejs.org/api/path.html#path_windows_vs_posix) for more info on POSIX vs. Windows paths

**webpack.config.js**

```js
const path = require('path');

module.exports = {
  mode: "production", // "production" | "development" | "none"
  // Chosen mode tells webpack to use its built-in optimizations accordingly.
  entry: "./app/entry", // string | object | array
  // defaults to ./src
  // Here the application starts executing
  // and webpack starts bundling
  output: {
    // options related to how webpack emits results
    path: path.resolve(__dirname, "dist"), // string
    // the target directory for all output files
    // must be an absolute path (use the Node.js path module)
    filename: "bundle.js", // string
    // the filename template for entry chunks
    publicPath: "/assets/", // string
    // the url to the output directory resolved relative to the HTML page
    library: "MyLibrary", // string,
    // the name of the exported library
    libraryTarget: "umd", // universal module definition
    // the type of the exported library
    /* Advanced output configuration (click to show) */
    /* Expert output configuration (on own risk) */
  },
  module: {
    // configuration regarding modules
    rules: [
      // rules for modules (configure loaders, parser options, etc.)
      {
        test: /\.jsx?$/,
        include: [
          path.resolve(__dirname, "app")
        ],
        exclude: [
          path.resolve(__dirname, "app/demo-files")
        ],
        // these are matching conditions, each accepting a regular expression or string
        // test and include have the same behavior, both must be matched
        // exclude must not be matched (takes preferrence over test and include)
        // Best practices:
        // - Use RegExp only in test and for filename matching
        // - Use arrays of absolute paths in include and exclude
        // - Try to avoid exclude and prefer include
        issuer: { test, include, exclude },
        // conditions for the issuer (the origin of the import)
        enforce: "pre",
        enforce: "post",
        // flags to apply these rules, even if they are overridden (advanced option)
        loader: "babel-loader",
        // the loader which should be applied, it'll be resolved relative to the context
        options: {
          presets: ["es2015"]
        },
        // options for the loader
      },
      {
        test: /\.html$/,
        use: [
          // apply multiple loaders and options
          "htmllint-loader",
          {
            loader: "html-loader",
            options: {
              / ... /
            }
          }
        ]
      },
      { oneOf: [ / rules / ] },
      // only use one of these nested rules
      { rules: [ / rules / ] },
      // use all of these nested rules (combine with conditions to be useful)
      { resource: { and: [ / conditions / ] } },
      // matches only if all conditions are matched
      { resource: { or: [ / conditions / ] } },
      { resource: [ / conditions / ] },
      // matches if any condition is matched (default for arrays)
      { resource: { not: / condition / } }
      // matches if the condition is not matched
    ],
    /* Advanced module configuration (click to show) */
  },
  resolve: {
    // options for resolving module requests
    // (does not apply to resolving to loaders)
    modules: [
      "node_modules",
      path.resolve(__dirname, "app")
    ],
    // directories where to look for modules
    extensions: [".js", ".json", ".jsx", ".css"],
    // extensions that are used
    alias: {
      // a list of module name aliases
      "module": "new-module",
      // alias "module" -> "new-module" and "module/path/file" -> "new-module/path/file"
      "only-module$": "new-module",
      // alias "only-module" -> "new-module", but not "only-module/path/file" -> "new-module/path/file"
      "module": path.resolve(__dirname, "app/third/module.js"),
      // alias "module" -> "./app/third/module.js" and "module/file" results in error
      // modules aliases are imported relative to the current context
    },
    /* Alternative alias syntax (click to show) */
    /* Advanced resolve configuration (click to show) */
  },
  performance: {
    hints: "warning", // enum
    maxAssetSize: 200000, // int (in bytes),
    maxEntrypointSize: 400000, // int (in bytes)
    assetFilter: function(assetFilename) {
      // Function predicate that provides asset filenames
      return assetFilename.endsWith('.css') || assetFilename.endsWith('.js');
    }
  },
  devtool: "source-map", // enum
  // enhance debugging by adding meta info for the browser devtools
  // source-map most detailed at the expense of build speed.
  context: __dirname, // string (absolute path!)
  // the home directory for webpack
  // the entry and module.rules.loader option
  //   is resolved relative to this directory
  target: "web", // enum
  // the environment in which the bundle should run
  // changes chunk loading behavior and available modules
  externals: ["react", /^@angular/],
  // Don't follow/bundle these modules, but request them at runtime from the environment
  stats: "errors-only",
  // lets you precisely control what bundle information gets displayed
  devServer: {
    proxy: { // proxy URLs to backend development server
      '/api': 'http://localhost:3000'
    },
    contentBase: path.join(__dirname, 'public'), // boolean | string | array, static file location
    compress: true, // enable gzip compression
    historyApiFallback: true, // true for index.html upon 404, object for multiple paths
    hot: true, // hot module replacement. Depends on HotModuleReplacementPlugin
    https: false, // true for self-signed, object for cert authority
    noInfo: true, // only errors & warns on hot reload
    // ...
  },
  plugins: [
    // ...
  ],
  // list of additional plugins
  /* Advanced configuration (click to show) */
```

> webpack applies configuration defaults after [plugins defaults](https://webpack.js.org/contribute/writing-a-plugin/#configuration-defaults) are applied.

> Want to rapidly generate webpack configuration file for your project requirements with few clicks away.

[Generate Custom Webpack Configuration](https://generatewebpackconfig.netlify.com/) is an interactive portal you can play around by selecting custom webpack configuration options tailored for your frontend project. It automatically generates a minimal webpack configuration based on your selection of loaders/plugins, etc.

Or use [webpack-cli's `init` command](https://github.com/webpack/webpack-cli/tree/master/packages/init#cli-via-webpack-cli) that will ask you a couple of questions before creating a configuration file.

```js
npx webpack-cli init
```

> You might be prompted to install `@webpack-cli/init` if it is not yet installed in the project or globally.

> After running `npx webpack-cli init` you might get more packages installed to your project depending on the choices you've made during configuration generation.

```
npx webpack-cli init

ℹ INFO For more information and a detailed description of each question, have a look at https://github.com/webpack/webpack-cli/blob/master/INIT.md
ℹ INFO Alternatively, run `webpack(-cli) --help` for usage info.

? Will your application have multiple bundles? No
? Which module will be the first to enter the application? [default: ./src/index]
? Which folder will your generated bundles be in? [default: dist]:
? Will you be using ES2015? Yes
? Will you use one of the below CSS solutions? No

+ babel-plugin-syntax-dynamic-import@6.18.0
+ uglifyjs-webpack-plugin@2.0.1
+ webpack-cli@3.2.3
+ @babel/core@7.2.2
+ babel-loader@8.0.4
+ @babel/preset-env@7.1.0
+ webpack@4.29.3
added 124 packages from 39 contributors, updated 4 packages and audited 25221 packages in 7.463s
found 0 vulnerabilities


Congratulations! Your new webpack configuration file has been created!
```

[createapp.dev - create a webpack configuration in your browser](https://createapp.dev/webpack) is an online tool for creating custom webpack configuration. It allows you to select various features that will be combined and added to resulting configuration file. Also, it generates an example project based on provided webpack configuration that you can review in your browser and download.

# Modules

In [modular programming](https://en.wikipedia.org/wiki/Modular_programming), developers break programs up into discrete chunks of functionality called a *module*.

Each module has a smaller surface area than a full program, making verification, debugging, and testing trivial. Well-written *modules* provide solid abstractions and encapsulation boundaries, so that each module has a coherent design and a clear purpose within the overall application.

Node.js has supported modular programming almost since its inception. On the web, however, support for *modules* has been slow to arrive. Multiple tools exist that support modular JavaScript on the web, with a variety of benefits and limitations. webpack builds on lessons learned from these systems and applies the concept of *modules* to any file in your project.

## What is a webpack Module

In contrast to [Node.js modules](https://nodejs.org/api/modules.html), webpack *modules* can express their *dependencies* in a variety of ways. A few examples are:

- An [ES2015 `import`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/import) statement
- A [CommonJS](http://www.commonjs.org/specs/modules/1.0/) `require()` statement
- An [AMD](https://github.com/amdjs/amdjs-api/blob/master/AMD.md) `define` and `require` statement
- An [`@import` statement](https://developer.mozilla.org/en-US/docs/Web/CSS/@import) inside of a css/sass/less file.
- An image url in a stylesheet `url(...)` or HTML `<img src=...>` file.

## Supported Module Types

webpack supports modules written in a variety of languages and preprocessors, via *loaders*. *Loaders* describe to webpack **how** to process non-JavaScript *modules* and include these *dependencies* into your *bundles*. The webpack community has built *loaders* for a wide variety of popular languages and language processors, including:

- [CoffeeScript](http://coffeescript.org/)
- [TypeScript](https://www.typescriptlang.org/)
- [ESNext (Babel)](https://babeljs.io/)
- [Sass](http://sass-lang.com/)
- [Less](http://lesscss.org/)
- [Stylus](http://stylus-lang.com/)
- [Elm](https://elm-lang.org/)

And many others! Overall, webpack provides a powerful and rich API for customization that allows one to use webpack for **any stack**, while staying **non-opinionated** about your development, testing, and production workflows.

For a full list, see [**the list of loaders**](https://webpack.js.org/loaders) or [**write your own**](https://webpack.js.org/api/loaders).	

# Module Resolution

A resolver is a library which helps in locating a module by its absolute path. A module can be required as a dependency from another module as:

```js
import foo from 'path/to/module';
// or
require('path/to/module');
```

The dependency module can be from the application code or a third-party library. The resolver helps webpack find the module code that needs to be included in the bundle for every such `require`/`import` statement. webpack uses [enhanced-resolve](https://github.com/webpack/enhanced-resolve) to resolve file paths while bundling modules.

## Resolving rules in webpack

Using `enhanced-resolve`, webpack can resolve three kinds of file paths:

### Absolute paths

```js
import '/home/me/file';

import 'C:\\Users\\me\\file';
```

Since we already have the absolute path to the file, no further resolution is required.

### Relative paths

```js
import '../src/file1';
import './file2';
```

In this case, the directory of the resource file where the `import` or `require` occurs is taken to be the context directory. The relative path specified in the `import/require` is joined to this context path to produce the absolute path to the module.

### Module paths

```js
import 'module';
import 'module/lib/file';
```

Modules are searched for inside all directories specified in [`resolve.modules`](https://webpack.js.org/configuration/resolve/#resolvemodules). You can replace the original module path by an alternate path by creating an alias for it using the [`resolve.alias`](https://webpack.js.org/configuration/resolve/#resolvealias) configuration option.

Once the path is resolved based on the above rule, the resolver checks to see if the path points to a file or a directory. If the path points to a file:

- If the path has a file extension, then the file is bundled straightaway.
- Otherwise, the file extension is resolved using the [`resolve.extensions`](https://webpack.js.org/configuration/resolve/#resolveextensions) option, which tells the resolver which extensions are acceptable for resolution e.g. `.js`, `.jsx`.

If the path points to a folder, then the following steps are taken to find the right file with the right extension:

- If the folder contains a `package.json` file, then fields specified in [`resolve.mainFields`](https://webpack.js.org/configuration/resolve/#resolvemainfields) configuration option are looked up in order, and the first such field in `package.json` determines the file path.
- If there is no `package.json` or if the [`resolve.mainFields`](https://webpack.js.org/configuration/resolve/#resolvemainfields) do not return a valid path, file names specified in the [`resolve.mainFiles`](https://webpack.js.org/configuration/resolve/#resolvemainfiles) configuration option are looked for in order, to see if a matching filename exists in the imported/required directory.
- The file extension is then resolved in a similar way using the [`resolve.extensions`](https://webpack.js.org/configuration/resolve/#resolveextensions) option.

webpack provides reasonable [defaults](https://webpack.js.org/configuration/resolve) for these options depending on your build target.

## Resolving Loaders

This follows the same rules as those specified for file resolution. But the [`resolveLoader`](https://webpack.js.org/configuration/resolve/#resolveloader) configuration option can be used to have separate resolution rules for loaders.

## Caching

Every filesystem access is cached so that multiple parallel or serial requests to the same file occur faster. In [watch mode](https://webpack.js.org/configuration/watch/#watch), only modified files are evicted from the cache. If watch mode is off, then the cache gets purged before every compilation.

See [Resolve API](https://webpack.js.org/configuration/resolve) to learn more about the configuration options mentioned above.