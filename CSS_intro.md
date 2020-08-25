# CSS basics

CSS (Cascading Style Sheets) is the code that styles web content. *CSS basics* walks through what you need to get started. We'll answer questions like: How do I make text red? How do I make content display at a certain location in the (webpage) layout? How do I decorate my webpage with background images and colors?

## What is CSS?	

Like HTML, CSS is not a programming language. It's not a markup language either. **CSS is a style sheet language.** CSS is what you use to selectively style HTML elements. For example, this CSS selects paragraph text, setting the color to red:

```css
p {
  color: red;
}
```

Let's try it out! Using a text editor, paste the three lines of CSS (above) into a new file. Save the file as `style.css` in a directory named `styles`.

To make the code work, we still need to apply this CSS (above) to your HTML document. Otherwise, the styling won't change the appearance of the HTML. (If you haven't been following our project, pause here to read [Dealing with files](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Dealing_with_files) and [HTML basics](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/HTML_basics).)

1. Open your `index.html` file. Paste the following line in the head (between the [`<head>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/head) and `</head>` tags):

   ```html
   <link href="styles/style.css" rel="stylesheet">
   ```

2. Save `index.html` and load it in your browser. You should see something like this:

![A mozilla logo and some paragraphs. The paragraph text has been styled red by our css.](https://mdn.mozillademos.org/files/9435/website-screenshot-styled.png)If your paragraph text is red, congratulations! Your CSS is working.

### Anatomy of a CSS ruleset



Let's dissect the CSS code for red paragraph text to understand how it works :

![CSS p declaration color red](https://mdn.mozillademos.org/files/9461/css-declaration-small.png)

The whole structure is called a **ruleset.** (The term *ruleset* is often referred to as just *rule.)* Note the names of the individual parts:

**Selector**

This is the HTML element name at the start of the ruleset. It defines the element(s) to be styled (in this example, [`<p>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/p) elements). To style a different element, change the selector.

**Declaration**

This is a single rule like `color: red;`. It specifies which of the element's **properties** you want to style.

**Properties**

These are ways in which you can style an HTML element. (In this example, `color` is a property of the [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/p) elements.) In CSS, you choose which properties you want to affect in the rule.

**Property value**

To the right of the property—after the colon—there is the **property value**. This chooses one out of many possible appearances for a given property. (For example, there are many `color` values in addition to `red`.)

Note the other important parts of the syntax:

- Apart from the selector, each ruleset must be wrapped in curly braces. (`{}`)
- Within each declaration, you must use a colon (`:`) to separate the property from its value or values.
- Within each ruleset, you must use a semicolon (`;`) to separate each declaration from the next one.

To modify multiple property values in one ruleset, write them separated by semicolons, like this:

```css
p {
  color: red;
  width: 500px;
  border: 1px solid black;
}
```

### Selecting multiple elements



You can also select multiple elements and apply a single ruleset to all of them. Separate multiple selectors by commas. For example:

```css
p, li, h1 {
  color: red;
}
```

### Different types of selectors



There are many different types of selectors. The examples above use **element selectors**, which select all elements of a given type. But we can make more specific selections as well. Here are some of the more common types of selectors:

| Selector name                                              | What does it select                                          | Example                                                      |
| :--------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- |
| Element selector (sometimes called a tag or type selector) | All HTML elements of the specified type.                     | `p` selects ``                                               |
| ID selector                                                | The element on the page with the specified ID. On a given HTML page, each id value should be unique. | `#my-id` selects `` or ``                                    |
| Class selector                                             | The element(s) on the page with the specified class. Multiple instances of the same class can appear on a page. | `.my-class` selects `` and ``                                |
| Attribute selector                                         | The element(s) on the page with the specified attribute.     | `img[src]` selects `` but not ``                             |
| Pseudo-class selector                                      | The specified element(s), but only when in the specified state. (For example, when a cursor hovers over a link.) | `a:hover` selects ``, but only when the mouse pointer is hovering over the link. |

There are many more selectors to discover. To learn more, see the MDN [Selectors guide](https://developer.mozilla.org/en-US/docs/Web/Guide/CSS/Getting_started/Selectors).

## Fonts and text

Now that we've explored some CSS fundamentals, let's improve the appearance of the example by adding more rules and information to the `style.css` file.



1. First, find the [output from Google Fonts](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/What_should_your_web_site_be_like#Font) that you previously saved from [What will your website look like?](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/What_should_your_web_site_be_like). Add the [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/link) element somewhere inside your `index.html`'s head (anywhere between the [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/head) and `` tags). It looks something like this:

   ```html
   <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
   ```

   This code links your page to a style sheet that loads the Open Sans font family with your webpage.

2. Next, delete the existing rule you have in your `style.css` file. It was a good test, but let's not continue with lots of red text.

3. Add the following lines (shown below), replacing the `font-family` assignment with your `font-family` selection from [What will your website look like?](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/What_should_your_web_site_be_like#Font). The property `font-family` refers to the font(s) you want to use for text. This rule defines a global base font and font size for the whole page. Since [`<html>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/html) is the parent element of the whole page, all elements inside it inherit the same `font-size` and `font-family`.

   ```css
   html {
     font-size: 10px; /* px means "pixels": the base font size is now 10 pixels high  */
     font-family: "Open Sans", sans-serif; /* this should be the rest of the output you got from Google fonts */
   }
   ```

   **Note**: Anything in CSS between `/*` and `*/` is a **CSS comment**. The browser ignores comments as it renders the code. CSS comments are a way for you to write helpful notes about your code or logic.Now let's set font sizes for elements that will have text inside the HTML body (

4. Now let's set font sizes for elements that will have text inside the HTML body ([`<h1>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/h1), [`<li>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/li), and [`<p>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/p)). We'll also center the heading. Finally, let's expand the second ruleset (below) with settings for line height and letter spacing to make body content more readable.

   ```css
   h1 {
     font-size: 60px;
     text-align: center;
   }
   
   p, li {
     font-size: 16px;    
     line-height: 2;
     letter-spacing: 1px;
   }
   ```

Adjust the `px` values as you like. Your work-in-progress should look similar to this:

![a mozilla logo and some paragraphs. a sans-serif font has been set, the font sizes, line height and letter spacing are adjusted, and the main page heading has been centered](https://mdn.mozillademos.org/files/9447/website-screenshot-font-small.png)

## CSS: all about boxes

Something you'll notice about writing CSS: a lot of it is about boxes. This includes setting size, color, and position. Most HTML elements on your page can be thought of as boxes sitting on top of other boxes.

![a big stack of boxes or crates sat on top of one another](https://mdn.mozillademos.org/files/9441/boxes.jpg)

CSS layout is mostly based on the *box model.* Each box taking up space on your page has properties like:

- `padding`, the space around the content. In the example below, it is the space around the paragraph text.
- `border`, the solid line that is just outside the padding.
- `margin`, the space around the outside of the border.

![three boxes sat inside one another. From outside to in they are labelled margin, border and padding](https://mdn.mozillademos.org/files/9443/box-model.png)

In this section we also use:

- `width` (of an element).
- `background-color`, the color behind an element's content and padding.
- `color`, the color of an element's content (usually text).
- `text-shadow` sets a drop shadow on the text inside an element.
- `display` sets the display mode of an element. (keep reading to learn more)

To continue, let's add more CSS. Keep adding these new rules at the bottom of `style.css`. Experiment with changing values to see what happens.

### Changing the page color



```css
html {
  background-color: #00539F;
}
```

This rule sets a background color for the entire page. Change the color code to [the color you chose in What will my website look like?](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/What_should_your_web_site_be_like#Theme_color).

### Styling the body



```css
body {
  width: 600px;
  margin: 0 auto;
  background-color: #FF9500;
  padding: 0 20px 20px 20px;
  border: 5px solid black;
}
```

There are several declarations for the [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/body) element. Let's go through these line-by-line:

- `width: 600px;` This forces the body to always be 600 pixels wide.
- `margin: 0 auto;` When you set two values on a property like `margin` or `padding`, the first value affects the element's top *and* bottom side (setting it to `0` in this case); the second value affects the left *and* right side. (Here, `auto` is a special value that divides the available horizontal space evenly between left and right). You can also use one, three, or four values, as documented in [Margin Syntax](https://developer.mozilla.org/en-US/docs/Web/CSS/margin#Syntax).
- `background-color: #FF9500;` This sets the element's background color. This project uses a reddish orange for the body background color, as opposed to dark blue for the [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/html) element. (Feel free to experiment.)
- `padding: 0 20px 20px 20px;` This sets four values for padding. The goal is to put some space around the content. In this example, there is no padding on the top of the body, and 20 pixels on the right, bottom and left. The values set top, right, bottom, left, in that order. As with `margin`, you can use one, two, three, or four values, as documented in [Padding Syntax](https://developer.mozilla.org/en-US/docs/Web/CSS/padding#Syntax).
- `border: 5px solid black;` This sets values for the width, style and color of the border. In this case, it's a five-pixel–wide, solid black border, on all sides of the body.

### Positioning and styling the main page title



```css
h1 {
  margin: 0;
  padding: 20px 0;    
  color: #00539F;
  text-shadow: 3px 3px 1px black;
}
```

You may have noticed there's a horrible gap at the top of the body. That happens because browsers apply default styling to the [`<h1>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/h1) element (among others). That might seem like a bad idea, but the intent is to provide basic readability for unstyled pages. To eliminate the gap, we overwrite the browser's default styling with the setting `margin: 0;`.

Next, we set the heading's top and bottom padding to 20 pixels.

Following that, we set the heading text to be the same color as the HTML background color.

Finally, `text-shadow` applies a shadow to the text content of the element. Its four values are:

- The first pixel value sets the **horizontal offset** of the shadow from the text: how far it moves across.
- The second pixel value sets the **vertical offset** of the shadow from the text: how far it moves down.
- The third pixel value sets the **blur radius** of the shadow. A larger value produces a more fuzzy-looking shadow.
- The fourth value sets the base color of the shadow.

Try experimenting with different values to see how it changes the appearance.

### Centering the image

```css
img {
  display: block;
  margin: 0 auto;
}
```

Next, we center the image to make it look better. We could use the `margin: 0 auto` trick again as we did for the body. But there are differences that require an additional setting to make the CSS work. 

The [`<body>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/body) is a **block** element, meaning it takes up space on the page. A block element can have margin and other spacing values applied to it. In contrast, images are **inline** elements. It is not possible to apply margin or spacing values to inline elements. So to apply margins to the image, we must give the image block-level behavior using `display: block;`.

**Note**: The instructions above assume that you're using an image smaller than the width set on the body. (600 pixels) If your image is larger, it will overflow the body, spilling into the rest of the page. To fix this, you can either: 1) reduce the image width using a [graphics editor](https://en.wikipedia.org/wiki/Raster_graphics_editor), or 2) use CSS to size the image by setting the [`width`](https://developer.mozilla.org/en-US/docs/Web/CSS/width) property on the `` element with a smaller value.

**Note**: Don't be too concerned if you don't completely understand `display: block;` or the differences between a block element and an inline element. It will make more sense as you continue your study of CSS. You can find more information about different display values on MDN's [display reference page](https://developer.mozilla.org/en-US/docs/Web/CSS/display).

## Conclusion

If you followed all the instructions in this article, you should have a page that looks similar to this one:

![a mozilla logo, centered, and a header and paragraphs. It now looks nicely styled, with a blue background for the whole page and orange background for the centered main content strip.](https://mdn.mozillademos.org/files/9455/website-screenshot-final.png)

(You can [view our version here](http://mdn.github.io/beginner-html-site-styled/).) If you get stuck, you can always compare your work with our [finished example code on GitHub](https://github.com/mdn/beginner-html-site-styled/blob/gh-pages/styles/style.css).

In this exercise, we have just scratched the surface of CSS. To go further, see [Learning to style HTML using CSS](https://developer.mozilla.org/en-US/Learn/CSS).

[Previous](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/HTML_basics)[Overview: Getting started with the web](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web)[Next](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/JavaScript_basics)

## In this module

- [Installing basic software](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Installing_basic_software)
- [What will your website look like?](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/What_will_your_website_look_like)
- [Dealing with files](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Dealing_with_files)
- [HTML basics](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/HTML_basics)
- [CSS basics](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/CSS_basics)
- [JavaScript basics](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/JavaScript_basics)
- [Publishing your website](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Publishing_your_website)
- [How the web works](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/How_the_Web_works)

# Learn to style HTML using CSS

Cascading Stylesheets — or [CSS](https://developer.mozilla.org/en-US/docs/Glossary/CSS) — is the first technology you should start learning after [HTML](https://developer.mozilla.org/en-US/docs/Glossary/HTML). While HTML is used to define the structure and semantics of your content, CSS is used to style it and lay it out. For example, you can use CSS to alter the font, color, size, and spacing of your content, split it into multiple columns, or add animations and other decorative features.

### Looking to become a front-end web developer?

We have put together a course that includes all the essential information you need to work towards your goal.

[Get started](https://developer.mozilla.org/docs/Learn/Front-end_web_developer)

## Prerequisites

You should learn the basics of HTML before attempting any CSS. We recommend that you work through our [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML) module first. In that module, you will learn about:

- CSS, starting with the [Introduction to CSS](https://developer.mozilla.org/en-US/docs/Learn/CSS/Introduction_to_CSS) module
- More advanced [HTML modules](https://developer.mozilla.org/en-US/docs/Learn/HTML#Modules)
- [JavaScript](https://developer.mozilla.org/en-US/docs/Learn/JavaScript), and how to use it to add dynamic functionality to web pages

Once you understand the fundamentals of HTML, we recommend that you learn HTML and CSS at the same time, moving back and forth between the two topics. This is because HTML is far more interesting and much more fun to learn when you apply CSS, and you can't really learn CSS without knowing HTML.

Before starting this topic, you should also be familiar with using computers and using the web passively (i.e., just looking at it, consuming the content). You should have a basic work environment set up as detailed in [Installing basic software](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/Installing_basic_software) and understand how to create and manage files, as detailed in [Dealing with files](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/Dealing_with_files) — both of which are parts of our [Getting started with the web](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web) complete beginner's module.

It is recommended that you work through [Getting started with the web](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web) before proceeding with this topic. However, doing so isn't absolutely necessary as much of what is covered in the [CSS basics](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/CSS_basics) article is also covered in our [CSS first steps](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps) module, albeit in a lot more detail.

## Modules

This topic contains the following modules, in a suggested order for working through them. You should definitely start with the first one.

- [CSS first steps](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps)

  CSS (Cascading Style Sheets) is used to style and lay out web pages — for example, to alter the font, color, size, and spacing of your content, split it into multiple columns, or add animations and other decorative features. This module provides a gentle beginning to your path towards CSS mastery with the basics of how it works, what the syntax looks like, and how you can start using it to add styling to HTML.

- [CSS building blocks](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks)

  This module carries on where [CSS first steps](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps) left off — now you've gained familiarity with the language and its syntax, and got some basic experience with using it, its time to dive a bit deeper. This module looks at the cascade and inheritance, all the selector types we have available, units, sizing, styling backgrounds and borders, debugging, and lots more.The aim here is to provide you with a toolkit for writing competent CSS and help you understand all the essential theory, before moving on to more specific disciplines like [text styling](https://developer.mozilla.org/en-US/docs/Learn/CSS/Styling_text) and [CSS layout](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout).

- [Styling text](https://developer.mozilla.org/en-US/docs/Learn/CSS/Styling_text)

  With the basics of the CSS language covered, the next CSS topic for you to concentrate on is styling text — one of the most common things you'll do with CSS. Here we look at text styling fundamentals, including setting font, boldness, italics, line and letter spacing, drop shadows and other text features. We round off the module by looking at applying custom fonts to your page, and styling lists and links.

- [CSS layout](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout)

  At this point we've already looked at CSS fundamentals, how to style text, and how to style and manipulate the boxes that your content sits inside. Now it's time to look at how to place your boxes in the right place in relation to the viewport, and one another. We have covered the necessary prerequisites so we can now dive deep into CSS layout, looking at different display settings, modern layout tools like flexbox, CSS grid, and positioning, and some of the legacy techniques you might still want to know about.

## Solving common CSS problems

[Use CSS to solve common problems](https://developer.mozilla.org/en-US/docs/Learn/CSS/Howto) provides links to sections of content explaining how to use CSS to solve very common problems when creating a web page.

From the beginning, you'll primarily apply colors to HTML elements and their backgrounds; change the size, shape, and position of elements; and add and define borders on elements. But there's not much you can't do once you have a solid understanding of even the basics of CSS. One of the best things about learning CSS is that once you know the fundamentals, usually you have a pretty good feel for what can and can't be done, even if you don't actually know how to do it yet!

## "CSS is weird"

CSS works a bit differently to most programming languages and design tools you'll come across. Why does it work the way it does? In the following video, Miriam Suzanne provides a useful explanation of why CSS works like it does, and why it has evolved like it has:

<iframe src="https://www.youtube.com/embed/aHUtMbJw8iA?rel=0&amp;html5=1" style="margin: 0px; padding: 0px; border: 0px; max-width: 100%; position: absolute; top: 0px; left: 0px; width: 640px; height: 360px;"></iframe>

## See also

- [CSS on MDN](https://developer.mozilla.org/en-US/docs/Web/CSS)

  The main entry point for CSS documentation on MDN, where you'll find detailed reference documentation for all features of the CSS language. Want to know all the values a property can take? This is a good place to go.

# CSS first steps

CSS (Cascading Style Sheets) is used to style and lay out web pages — for example, to alter the font, color, size, and spacing of your content, split it into multiple columns, or add animations and other decorative features. This module provides a gentle beginning to your path towards CSS mastery with the basics of how it works, what the syntax looks like, and how you can start using it to add styling to HTML.

### Looking to become a front-end web developer?

We have put together a course that includes all the essential information you need to work towards your goal.

[Get started](https://developer.mozilla.org/docs/Learn/Front-end_web_developer)

## Prerequisites

Before starting this module, you should have:

1. Basic familiarity with using computers, and using the Web passively (i.e. looking at it, consuming the content.)
2. A basic work environment set up as detailed in [Installing basic software](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/Installing_basic_software), and an understanding of how to create and manage files, as detailed in [Dealing with files](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/Dealing_with_files).
3. Basic familiarity with HTML, as discussed in the [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML) module.

**Note**: If you are working on a computer/tablet/other device where you don't have the ability to create your own files, you could try out (most of) the code examples in an online coding program such as [JSBin](http://jsbin.com/) or [Glitch](https://glitch.com/).

## Guides

This module contains the following articles, which will take you through all the basic theory of CSS, and provide opportunities for you to test out some skills.

- [What is CSS?](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps/What_is_CSS)

  **[CSS](https://developer.mozilla.org/en-US/docs/Glossary/CSS)** (Cascading Style Sheets) allows you to create great-looking web pages, but how does it work under the hood? This article explains what CSS is, with a simple syntax example, and also covers some key terms about the language.

- [Getting started with CSS](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps/Getting_started)

  In this article we will take a simple HTML document and apply CSS to it, learning some practical things about the language along the way.

- [How CSS is structured](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps/How_CSS_is_structured)

  Now that you have an idea about what CSS is and the basics of using it, it is time to look a little deeper into the structure of the language itself. We have already met many of the concepts discussed here; you can return to this one to recap if you find any later concepts confusing.

- [How CSS works](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps/How_CSS_works)

  We have learned the basics of CSS, what it is for and how to write simple stylesheets. In this lesson we will take a look at how a browser takes CSS and HTML and turns that into a webpage.

- [Using your new knowledge](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps/Using_your_new_knowledge)

  With the things you have learned in the last few lessons you should find that you can format simple text documents using CSS, to add your own style to them. This article gives you a chance to do that.

## See also

- [Intermediate Web Literacy 1: Intro to CSS](https://teach.mozilla.org/activities/intermediate-web-lit/)

  An excellent Mozilla foundation course that explores and tests a lot of the skills talked about in the *Introduction to CSS* module. Learn about styling HTML elements on a webpage, CSS selectors, attributes, and values.

# What is CSS?

**[CSS](https://developer.mozilla.org/en-US/docs/Glossary/CSS)** (Cascading Style Sheets) allows you to create great-looking web pages, but how does it work under the hood? This article explains what CSS is, with a simple syntax example, and also covers some key terms about the language.

| Prerequisites: | Basic computer literacy, [basic software installed](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Installing_basic_software), basic knowledge of [working with files](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Dealing_with_files), and HTML basics (study [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML).) |
| :------------- | ------------------------------------------------------------ |
| Objective:     | To learn what CSS is.                                        |

In the [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML) module we covered what HTML is, and how it is used to mark up documents. These documents will be readable in a web browser. Headings will look larger than regular text, paragraphs break onto a new line and have space between them. Links are colored and underlined to distinguish them from the rest of the text. What you are seeing is the browser's default styles — very basic styles that the browser applies to HTML to make sure it will be basically readable even if no explicit styling is specified by the author of the page.

![The default styles used by a browser](https://mdn.mozillademos.org/files/16493/html-example.png)

However, the web would be a boring place if all websites looked like that. Using CSS you can control exactly how HTML elements look in the browser, presenting your markup using whatever design you like.

For more on browser/default styles, check out the following video:

<iframe src="https://www.youtube.com/embed/spK_S0HfzFw?rel=0&amp;html5=1" style="margin: 0px; padding: 0px; border: 0px; max-width: 100%; position: absolute; top: 0px; left: 0px; width: 640px; height: 360px;"></iframe>

## What is CSS for?

As we have mentioned before, CSS is a language for specifying how documents are presented to users — how they are styled, laid out, etc.

A **document** is usually a text file structured using a markup language — [HTML](https://developer.mozilla.org/en-US/docs/Glossary/HTML) is the most common markup language, but you may also come across other markup languages such as [SVG](https://developer.mozilla.org/en-US/docs/Glossary/SVG) or [XML](https://developer.mozilla.org/en-US/docs/Glossary/XML).

**Presenting** a document to a user means converting it into a form usable by your audience. [Browsers](https://developer.mozilla.org/en-US/docs/Glossary/browser), like [Firefox](https://developer.mozilla.org/en-US/docs/Glossary/Mozilla_Firefox), [Chrome](https://developer.mozilla.org/en-US/docs/Glossary/Google_Chrome), or [Edge](https://developer.mozilla.org/en-US/docs/Glossary/Microsoft_Edge) , are designed to present documents visually, for example, on a computer screen, projector or printer.

> **Note**: A browser is sometimes called a [user agent](https://developer.mozilla.org/en-US/docs/Glossary/User_agent), which basically means a computer program that represents a person inside a computer system. Browsers are the main type of user agent we think of when talking about CSS, however, it is not the only one. There are other user agents available — such as those which convert HTML and CSS documents into PDFs to be printed.

CSS can be used for very basic document text styling — for example changing the [color](https://developer.mozilla.org/en-US/docs/Web/CSS/color_value) and [size](https://developer.mozilla.org/en-US/docs/Web/CSS/font-size) of headings and links. It can be used to create layout — for example [turning a single column of text into a layout](https://developer.mozilla.org/en-US/docs/Web/CSS/Layout_cookbook/Column_layouts) with a main content area and a sidebar for related information. It can even be used for effects such as [animation](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Animations). Have a look at the links in this paragraph for specific examples.

## CSS syntax

CSS is a rule-based language — you define rules specifying groups of styles that should be applied to particular elements or groups of elements on your web page. For example "I want the main heading on my page to be shown as large red text."

The following code shows a very simple CSS rule that would achieve the styling described above:

```css
h1 {
    color: red;
    font-size: 5em;
}
```

The rule opens with a [selector](https://developer.mozilla.org/en-US/docs/Glossary/CSS_Selector) . This *selects* the HTML element that we are going to style. In this case we are styling level one headings ([`<h1>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/h1)).

We then have a set of curly braces `{ }`. Inside those will be one or more **declarations**, which take the form of **property** and **value** pairs. Each pair specifies a property of the element(s) we are selecting, then a value that we'd like to give the property.

Before the colon, we have the property, and after the colon, the value. CSS [properties](https://developer.mozilla.org/en-US/docs/Glossary/property/CSS) have different allowable values, depending on which property is being specified. In our example, we have the `color` property, which can take various [color values](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Values_and_units#Color). We also have the `font-size` property. This property can take various [size units](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Values_and_units#Numbers_lengths_and_percentages) as a value.

A CSS stylesheet will contain many such rules, written one after the other.

```css
h1 {
    color: red;
    font-size: 5em;
}

p {
    color: black;
}
```

You will find that you quickly learn some values, whereas others you will need to look up. The individual property pages on MDN give you a quick way to look up properties and their values when you forget, or want to know what else you can use as a value.

> **Note**: You can find links to all the CSS property pages (along with other CSS features) listed on the MDN [CSS reference](https://developer.mozilla.org/en-US/docs/Web/CSS/Reference). Alternatively, you should get used to searching for "mdn *css-feature-name*" in your favourite search engine whenever you need to find out more information about a CSS feature. For example, try searching for "mdn color" and "mdn font-size"!

## CSS Modules

As there are so many things that you could style using CSS, the language is broken down into *modules*. You'll see reference to these modules as you explore MDN and many of the documentation pages are organized around a particular module. For example, you could take a look at the MDN reference to the [Backgrounds and Borders](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Backgrounds_and_Borders) module to find out what its purpose is, and what different properties and other features it contains. You will also find links to the *CSS Specification* that defines the technology (see below).

At this stage you don't need to worry too much about how CSS is structured, however it can make it easier to find information if, for example, you are aware that a certain property is likely to be found among other similar things and are therefore probably in the same specification. 

For a specific example, let's go back to the Backgrounds and Borders module — you might think that it makes logical sense for the `background-color` and `border-color` properties to be defined in this module. And you'd be right.

### CSS Specifications



All web standards technologies (HTML, CSS, JavaScript, etc.) are defined in giant documents called specifications (or simply "specs"), which are published by standards organizations (such as the [W3C](https://developer.mozilla.org/en-US/docs/Glossary/W3C), [WHATWG](https://developer.mozilla.org/en-US/docs/Glossary/WHATWG), [ECMA](https://developer.mozilla.org/en-US/docs/Glossary/ECMA), or Khronos) and define precisely how those technologies are supposed to behave.

CSS is no different — it is developed by a group within the W3C called the [CSS Working Group](https://www.w3.org/Style/CSS/). This group is made of representatives of browser vendors and other companies who have an interest in CSS. There are also other people, known as *invited experts*, who act as independent voices; they are not linked to a member organization.

New CSS features are developed, or specified, by the CSS Working Group. Sometimes because a particular browser is interested in having some capability, other times because web designers and developers are asking for a feature, and sometimes because the Working Group itself has identified a requirement. CSS is constantly developing, with new features coming available. However, a key thing about CSS is that everyone works very hard to never change things in a way that would break old websites. A website built in 2000, using the limited CSS available then, should still be usable in a browser today!

As a newcomer to CSS, it is likely that you will find the CSS specs overwhelming — they are intended for engineers to use to implement support for the features in user agents, not for web developers to read to understand CSS. Many experienced developers would much rather refer to MDN documentation or other tutorials. It is however worth knowing that they exist, understanding the relationship between the CSS you are using, browser support (see below), and the specs.

## Browser support

Once CSS has been specified then it is only useful for us in developing web pages if one or more browsers have implemented it. This means that the code has been written to turn the instruction in our CSS file into something that can be output to the screen. We'll look at this process more in the lesson [How CSS works](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps/How_CSS_works). It is unusual for all browsers to implement a feature at the same time, and so there is usually a gap where you can use some part of CSS in some browsers and not in others. For this reason, being able to check implementation status is useful. On each property page on MDN you can see the status of the property you are interested in, so you can tell if you will be able to use it on a website.

What follows is the compat data chart for the CSS `font-family` property.

[Update compatibility data on GitHub](https://github.com/mdn/browser-compat-data)

|                                                              |    Desktop    | Mobile |         |                   |       |        |                 |                    |                     |                   |               |                  |
| :----------------------------------------------------------- | :-----------: | :----: | :-----: | :---------------: | :---: | :----: | :-------------: | :----------------: | :-----------------: | :---------------: | :-----------: | ---------------- |
|                                                              |    Chrome     |  Edge  | Firefox | Internet Explorer | Opera | Safari | Android webview | Chrome for Android | Firefox for Android | Opera for Android | Safari on iOS | Samsung Internet |
| [`font-family`](https://developer.mozilla.org/en-US/docs/Web/CSS/font-family) | Full support1 |  Full  |         |                   |       |        |                 |                    |                     |                   |               |                  |



# Getting started with CSS

In this article we will take a simple HTML document and apply CSS to it, learning some practical things about the language along the way.

| Prerequisites: | Basic computer literacy, [basic software installed](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Installing_basic_software), basic knowledge of [working with files](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Dealing_with_files), and HTML basics (study [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML).) |
| :------------- | ------------------------------------------------------------ |
| Objective:     | To understand the basics of linking a CSS document to an HTML file, and be able to do simple text formatting with CSS. |

## Starting with some HTML

Our starting point is an HTML document. You can copy the code from below if you want to work on your own computer. Save the code below as `index.html` in a folder on your machine.

```html
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Getting started with CSS</title>
</head>

<body>
    
    <h1>I am a level one heading</h1>

    <p>This is a paragraph of text. In the text is a <span>span element</span> 
and also a <a href="http://example.com">link</a>.</p>

    <p>This is the second paragraph. It contains an <em>emphasized</em> element.</p>

    <ul>
        <li>Item one</li>
        <li>Item two</li>
        <li>Item <em>three</em></li>
    </ul>

</body>

</html>
```

**Note**: If you are reading this on a device or an environment where you can't easily create files, then don't worry — live code editors are provided below to allow you to write example code right here in the page.

## Adding CSS to our document

The very first thing we need to do is to tell the HTML document that we have some CSS rules we want it to use. There are three different ways to apply CSS to an HTML document that you'll commonly come across, however, for now, we will look at the most usual and useful way of doing so — linking CSS from the head of your document.

Create a file in the same folder as your HTML document and save it as `styles.css`. The `.css` extension shows that this is a CSS file.

To link `styles.css` to `index.html` add the following line somewhere inside the [`<head>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/head) of the HTML document:

```html
<link rel="stylesheet" href="styles.css">
```

This [`<link>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/link) element tells the browser that we have a stylesheet, using the `rel` attribute, and the location of that stylesheet as the value of the `href` attribute. You can test that the CSS works by adding a rule to `styles.css`. Using your code editor add the following to your CSS file:

```css
h1 {
  color: red;
}
```

Save your HTML and CSS files and reload the page in a web browser. The level one heading at the top of the document should now be red. If that happens, congratulations — you have successfully applied some CSS to an HTML document. If that doesn't happen, carefully check that you've typed everything correctly.

You can continue to work in `styles.css` locally, or you can use our interactive editor below to continue with this tutorial. The interactive editor acts as if the CSS in the first panel is linked to the HTML document, just as we have with our document above.

## Styling HTML elements

By making our heading red we have already demonstrated that we can target and style an HTML element. We do this by targeting an *element selector* — this is a selector that directly matches an HTML element name. To target all paragraphs in the document you would use the selector `p`. To turn all paragraphs green you would use:

```css
p {
  color: green;
}
```

You can target multiple selectors at once, by separating the selectors with a comma. If I want all paragraphs and all list items to be green my rule looks like this:

```css
p, li {
    color: green;
}
```

Try this out in the interactive editor below (edit the code boxes), or in your local CSS document.

 

## Changing the default behavior of elements

When we look at a well-marked up HTML document, even something as simple as our example, we can see how the browser is making the HTML readable by adding some default styling. Headings are large and bold and our list has bullets. This happens because browsers have internal stylesheets containing default styles, which they apply to all pages by default; without them all of the text would run together in a clump and we would have to style everything from scratch. All modern browsers display HTML content by default in pretty much the same way.

However, you will often want something other than the choice the browser has made. This can be done by simply choosing the HTML element that you want to change, and using a CSS rule to change the way it looks.  A good example is our ``, an unordered list. It has list bullets, and if I decide I don't want those bullets I can remove them like so:

```css
li {
  list-style-type: none;
}
```

Try adding this to your CSS now.

The `list-style-type` property is a good property to look at on MDN to see which values are supported. Take a look at the page for `list-style-type` and you will find an interactive example at the top of the page to try some different values in, then all allowable values are detailed further down the page.

Looking at that page you will discover that in addition to removing the list bullets you can change them — try changing them to square bullets by using a value of `square`.

## Adding a class

So far we have styled elements based on their HTML element names. This works as long as you want all of the elements of that type in your document to look the same. Most of the time that isn't the case and so you will need to find a way to select a subset of the elements without changing the others. The most common way to do this is to add a class to your HTML element and target that class.

In your HTML document, add a [class attribute](https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/class) to the second list item. Your list will now look like this:

```html
<ul>
  <li>Item one</li>
  <li class="special">Item two</li>
  <li>Item <em>three</em></li>
</ul>
```

In your CSS you can target the class of `special` by creating a selector that starts with a full stop character. Add the following to your CSS file:

```css
.special {
  color: orange;
  font-weight: bold;
}
```

Save and refresh to see what the result is.

You can apply the class of `special` to any element on your page that you want to have the same look as this list item. For example, you might want the `` in the paragraph to also be orange and bold. Try adding a `class` of `special` to it, then reload your page and see what happens.

Sometimes you will see rules with a selector that lists the HTML element selector along with the class:

```css
li.special {
  color: orange;
  font-weight: bold;
}
```

This syntax means "target any `li` element that has a class of special". If you were to do this then you would no longer be able to apply the class to a `` or another element by simply adding the class to it; you would have to add that element to the list of selectors:

```css
li.special,
span.special {
  color: orange;
  font-weight: bold;
}
```

As you can imagine, some classes might be applied to many elements and you don't want to have to keep editing your CSS every time something new needs to take on that style. Therefore it is sometimes best to bypass the element and simply refer to the class, unless you know that you want to create some special rules for one element alone, and perhaps want to make sure they are not applied to other things.

## Styling things based on their location in a document

There are times when you will want something to look different based on where it is in the document. There are a number of selectors that can help you here, but for now we will look at just a couple. In our document are two `` elements — one inside a paragraph and the other inside a list item. To select only an `` that is nested inside an `` element I can use a selector called the **descendant combinator**, which simply takes the form of a space between two other selectors.

Add the following rule to your stylesheet.

```css
li em {
  color: rebeccapurple;
}
```

This selector will select any `` element that is inside (a descendant of) an ``. So in your example document, you should find that the `` in the third list item is now purple, but the one inside the paragraph is unchanged.

Something else you might like to try is styling a paragraph when it comes directly after a heading at the same hierarchy level in the HTML. To do so place a `+` (an **adjacent sibling combinator**) between the selectors.

Try adding this rule to your stylesheet as well:

```css
h1 + p {
  font-size: 200%;
}
```

The live example below includes the two rules above. Try adding a rule to make a span red, if it is inside a paragraph. You will know if you have it right as the span in the first paragraph will be red, but the one in the first list item will not change color.

<iframe class="live-sample-frame" frameborder="0" height="1100" src="https://mdn.github.io/css-examples/learn/getting-started/started2.html" width="100%"></iframe>

> **Note**: As you can see, CSS gives us several ways to target elements, and we've only scratched the surface so far! We will be taking a proper look at all of these selectors and many more in our [Selectors](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Selectors) articles later on in the course.

## Styling things based on state





# How CSS works

We have learned the basics of CSS, what it is for and how to write simple stylesheets. In this lesson we will take a look at how a browser takes CSS and HTML and turns that into a webpage.

| Prerequisites: | Basic computer literacy, [basic software installed](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Installing_basic_software), basic knowledge of [working with files](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Dealing_with_files), and HTML basics (study [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML).) |
| :------------- | ------------------------------------------------------------ |
| Objective:     | To understand the basics of how CSS and HTML are parsed by the browser, and what happens when a browser encounters CSS it does not understand. |

## How does CSS actually work?

When a browser displays a document, it must combine the document's content with its style information. It processes the document in a number of stages, which we've listed below. Bear in mind that this is a very simplified version of what happens when a browser loads a webpage, and that different browsers will handle the process in different ways. But this is roughly what happens.

1. The browser loads the HTML (e.g. receives it from the network).
2. It converts the [HTML](https://developer.mozilla.org/en-US/docs/Glossary/HTML) into a [DOM](https://developer.mozilla.org/en-US/docs/Glossary/DOM) (*Document Object Model*). The DOM represents the document in the computer's memory. The DOM is explained in a bit more detail in the next section.
3. The browser then fetches most of the resources that are linked to by the HTML document, such as embedded images and videos ... and linked CSS! JavaScript is handled a bit later on in the process, and we won't talk about it here to keep things simpler.
4. The browser parses the fetched CSS, and sorts the different rules by their selector types into different "buckets", e.g. element, class, ID, and so on. Based on the selectors it finds, it works out which rules should be applied to which nodes in the DOM, and attaches style to them as required (this intermediate step is called a render tree).
5. The render tree is laid out in the structure it should appear in after the rules have been applied to it.
6. The visual display of the page is shown on the screen (this stage is called painting).

The following diagram also offers a simple view of the process.

![img](https://mdn.mozillademos.org/files/11781/rendering.svg)

## About the DOM

A DOM has a tree-like structure. Each element, attribute, and piece of text in the markup language becomes a [DOM node](https://developer.mozilla.org/en-US/docs/Glossary/Node/DOM) in the tree structure. The nodes are defined by their relationship to other DOM nodes. Some elements are parents of child nodes, and child nodes have siblings.

Understanding the DOM helps you design, debug and maintain your CSS because the DOM is where your CSS and the document's content meet up. When you start working with browser DevTools you will be navigating the DOM as you select items in order to see which rules apply.

## A real DOM representation

Rather than a long, boring explanation, let's look at an example to see how a real HTML snippet is converted into a DOM.

Take the following HTML code:

```html
<p>
  Let's use:
  <span>Cascading</span>
  <span>Style</span>
  <span>Sheets</span>
</p>
```

In the DOM, the node corresponding to our `` element is a parent. Its children are a text node and the three nodes corresponding to our `` elements. The `SPAN` nodes are also parents, with text nodes as their children:

```html
P
├─ "Let's use:"
├─ SPAN
|  └─ "Cascading"
├─ SPAN
|  └─ "Style"
└─ SPAN
   └─ "Sheets"
```

This is how a browser interprets the previous HTML snippet —it renders the above DOM tree and then outputs it in the browser like so:



## Applying CSS to the DOM

Let's say we added some CSS to our document, to style it. Again, the HTML is as follows:

```html
<p>
  Let's use:
  <span>Cascading</span>
  <span>Style</span>
  <span>Sheets</span>
</p>
```

Let's suppose we apply the following CSS to it:

```css
span {
  border: 1px solid black;
  background-color: lime;
}
```

The browser will parse the HTML and create a DOM from it, then parse the CSS. Since the only rule available in the CSS has a `span` selector, the browser will be able to sort the CSS very quickly! It will apply that rule to each one of the three ``s, then paint the final visual representation to the screen.

The updated output is as follows:



In our [Debugging CSS](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Debugging_CSS) article in the next module we will be using browser DevTools to debug CSS problems, and will learn more about how the browser interprets CSS.

## What happens if a browser encounters CSS it doesn't understand?

[In an earlier lesson](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps/What_is_CSS#Browser_support) I mentioned that browsers do not all implement new CSS at the same time. In addition, many people are not using the latest version of a browser. Given that CSS is being developed all the time, and is therefore ahead of what browsers can recognise, you might wonder what happens if a browser encounters a CSS selector or declaration it doesn't recognise.

The answer is that it does nothing, and just moves on to the next bit of CSS!

If a browser is parsing your rules, and encounters a property or value that it doesn't understand, it ignores it and moves on to the next declaration. It will do this if you have made an error and misspelled a property or value, or if the property or value is just too new and the browser doesn't yet support it.

Similarly, if a browser encounters a selector that it doesn't understand, it will just ignore the whole rule and move on to the next one.

In the example below I have used the British English spelling for color, which makes that property invalid as it is not recognised. So my paragraph has not been colored blue. All of the other CSS have been applied however; only the invalid line is ignored.

```html
<p> I want this text to be large, bold and blue.</p>
p {
  font-weight: bold;
  colour: blue; /* incorrect spelling of the color property */
  font-size: 200%;
}
```



Open in CodePenOpen in JSFiddle



This behavior is very useful. It means that you can use new CSS as an enhancement, knowing that no error will occur if it is not understood — the browser will either get the new feature or not. Coupled with the way that the cascade works, and the fact that browsers will use the last CSS they come across in a stylesheet when you have two rules with the same specificity you can also offer alternatives for browsers that don't support new CSS.

This works particularly well when you want to use a value that is quite new and not supported everywhere. For example, some older browsers do not support `calc()` as a value. I might give a fallback width for a box in pixels, then go on to give a width with a `calc()` value of `100% - 50px`. Old browsers will use the pixel version, ignoring the line about `calc()` as they don't understand it. New browsers will interpret the line using pixels, but then override it with the line using `calc()` as that line appears later in the cascade.

```css
.box {
  width: 500px;
  width: calc(100% - 50px);
}
```

We will look at many more ways to support varying browsers in later lessons.

## And finally

You've nearly finished this module; we only have one more thing to do. In the next article you'll [use your new knowledge](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps/Using_your_new_knowledge) to restyle an example, testing out some CSS in the process.