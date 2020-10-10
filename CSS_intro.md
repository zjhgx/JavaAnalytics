CSS basics

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

There are times when you will want something to look different based on where it is in the document. There are a number of selectors that can help you here, but for now we will look at just a couple. In our document are two `<em>` elements — one inside a paragraph and the other inside a list item. To select only an `<em>` that is nested inside an `<li>` element I can use a selector called the **descendant combinator**, which simply takes the form of a space between two other selectors.

Add the following rule to your stylesheet.

```css
li em {
  color: rebeccapurple;
}
```

This selector will select any `<em>` element that is inside (a descendant of) an `<li>`. So in your example document, you should find that the `<em>` in the third list item is now purple, but the one inside the paragraph is unchanged.

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

The final type of styling we shall take a look at in this tutorial is the ability to style things based on their state. A straightforward example of this is when styling links. When we style a link we need to target the `<a>` (anchor) element. This has different states depending on whether it is unvisited, visited, being hovered over, focused via the keyboard, or in the process of being clicked (activated). You can use CSS to target these different states — the CSS below styles unvisited links pink and visited links green.

```css
a:link {
  color: pink;
}

a:visited {
  color: green;
}
```

You can change the way the link looks when the user hovers over it, for example removing the underline, which is achieved by in the next rule:

```css
a:hover {
  text-decoration: none;
}
```

In the live example below, you can play with different values for the various states of a link. I have added the rules above to it, and now realise that the pink color is quite light and hard to read — why not change that to a better color? Can you make the links bold?

<iframe class="live-sample-frame" frameborder="0" height="900" src="https://mdn.github.io/css-examples/learn/getting-started/started3.html" width="100%"></iframe>

We have removed the underline on our link on hover. You could remove the underline from all states of a link. It is worth remembering however that in a real site, you want to ensure that visitors know that a link is a link. Leaving the underline in place, can be an important clue for people to realize that some text inside a paragraph can be clicked on — this is the behavior they are used to. As with everything in CSS, there is the potential to make the document less accessible with your changes — we will aim to highlight potential pitfalls in appropriate places.

> **Note**: you will often see mention of [accessibility](https://developer.mozilla.org/en-US/docs/Learn/Accessibility) in these lessons and across MDN. When we talk about accessibility we are referring to the requirement for our webpages to be understandable and usable by everyone.
>
> Your visitor may well be on a computer with a mouse or trackpad, or a phone with a touchscreen. Or they might be using a screenreader, which reads out the content of the document, or they may need to use much larger text, or be navigating the site using the keyboard only.
>
> A plain HTML document is generally accessible to everyone — as you start to style that document it is important that you don't make it less accessible.

## Combining selectors and combinators

It is worth noting that you can combine multiple selectors and combinators together. For example:

```css
/* selects any <span> that is inside a <p>, which is inside an <article>  */
article p span { ... }

/* selects any <p> that comes directly after a <ul>, which comes directly after an <h1>  */
h1 + ul + p { ... }
```

You can combine multiple types together, too. Try adding the following into your code:

```css
body h1 + p .special {
  color: yellow;
  background-color: black;
  padding: 5px;
}
```

This will style any element with a class of `special`, which is inside a `<p>`, which comes just after an `<h1>`, which is inside a `<body>`. Phew!

In the original HTML we provided, the only element styled is `<span class="special">`.

Don't worry if this seems complicated at the moment — you'll soon start to get the hang of it as you write more CSS.

## Wrapping up

In this tutorial, we have taken a look at a number of ways in which you can style a document using CSS. We will be developing this knowledge as we move through the rest of the lessons. However you now already know enough to style text, apply CSS based on different ways of targeting elements in the document, and look up properties and values in the MDN documentation.

In the next lesson we will be taking a look at how CSS is structured.



# How CSS is structured

Now that you are beginning to understanding the purpose and use of CSS, let's examine the structure of CSS.

| Prerequisites: | Basic computer literacy, [basic software installed](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Installing_basic_software), basic knowledge of [working with files](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Dealing_with_files), HTML basics (study [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML)), and an idea of [How CSS works](https://developer.mozilla.org/en-US/docs/Learn/CSS/Introduction_to_CSS/How_CSS_works). |
| :------------- | ------------------------------------------------------------ |
| Objective:     | To learn CSS's fundamental syntax structures in detail.      |

## Applying CSS to HTML

First, let's examine three methods of applying CSS to a document: with an external stylesheet, with an internal stylesheet, and with inline styles.



### External stylesheet



An external stylesheet contains CSS in a separate file with a `.css` extension. This is the most common and useful method of bringing CSS to a document. You can link a single CSS file to multiple web pages, styling all of them with the same CSS stylesheet. In the [Getting started with CSS](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps/Getting_started), we linked an external stylesheet to our web page.

You reference an external CSS stylesheet from an HTML `<link>` element:

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>My CSS experiment</title>
    <link rel="stylesheet" href="styles.css">
  </head>
  <body>
    <h1>Hello World!</h1>
    <p>This is my first CSS example</p>
  </body>
</html>
```

The CSS stylesheet file might look like this:

```css
h1 {
  color: blue;
  background-color: yellow;
  border: 1px solid black;
}

p {
  color: red;
}
```

The `href` attribute of the [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/link) element needs to reference a file on your file system. In the example above, the CSS file is in the same folder as the HTML document, but you could place it somewhere else and adjust the path. Here are three examples:

```html
<!-- Inside a subdirectory called styles inside the current directory -->
<link rel="stylesheet" href="styles/style.css">

<!-- Inside a subdirectory called general, which is in a subdirectory called styles, inside the current directory -->
<link rel="stylesheet" href="styles/general/style.css">

<!-- Go up one directory level, then inside a subdirectory called styles -->
<link rel="stylesheet" href="../styles/style.css">
```

### Internal stylesheet

An internal stylesheet resides within an HTML document. To create an internal stylesheet, you place CSS inside a [`<style>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/style) element contained inside the HTML [`<head>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/head).

The HTML for an internal stylesheet might look like this:

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>My CSS experiment</title>
    <style>
      h1 {
        color: blue;
        background-color: yellow;
        border: 1px solid black;
      }

      p {
        color: red;
      }
    </style>
  </head>
  <body>
    <h1>Hello World!</h1>
    <p>This is my first CSS example</p>
  </body>
</html>
```

In some circumstances, internal stylesheets can be useful. For example, perhaps you're working with a content management system where you are blocked from modifying external CSS files.

But for sites with more than one page, an internal stylesheet becomes a less efficient way of working. To apply uniform CSS styling to multiple pages using internal stylesheets, you must have an internal stylesheet in every web page that will use the styling. The efficiency penalty carries over to site maintenance too. With CSS in internal stylesheets, there is the risk that even one simple styling change may require edits to multiple web pages.

### Inline styles

Inline styles are CSS declarations that affect a single HTML element, contained within a `style` attribute. The implementation of an inline style in an HTML document might look like this:

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>My CSS experiment</title>
  </head>
  <body>
    <h1 style="color: blue;background-color: yellow;border: 1px solid black;">Hello World!</h1>
    <p style="color:red;">This is my first CSS example</p>
  </body>
</html>
```

**Avoid using CSS in this way when possible.** It is the opposite of a best practice. First, it is the least efficient implementation of CSS for maintenance. One styling change might require multiple edits within in a single web page. Second, inline CSS also mixes (CSS) presentational code with HTML and content, making everything more difficult to read and understand. Separating code and content makes maintenance easier for all who work on the the website.

There are a few circumstances where inline styles are more common. You might have to resort to using inline styles if your working environment is very restrictive. For example, perhaps your CMS only allows you to edit the HTML body. You may also see a lot of inline styles in HTML email to achieve compatibility with as many email clients as possible.

## Playing with the CSS in this article

For the exercise that follows, create a folder on your computer. You can name the folder whatever you want. Inside the folder, copy the text below to create two files:

**index.html:**

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>My CSS experiments</title>
    <link rel="stylesheet" href="styles.css">
  </head>
  <body> 

    <p>Create your test HTML here</p>

  </body>
</html>
```

**styles.css:**

```css
/* Create your test CSS here */

p {
  color: red;
}
```

When you find CSS that you want to experiment with, replace the HTML `<body>` contents with some HTML to style, and then add your test CSS code to your CSS file.

As an alternative, you can also use the interactive editor below.

 <iframe class="live-sample-frame" frameborder="0" height="800" src="https://mdn.github.io/css-examples/learn/getting-started/experiment-sandbox.html" width="100%"></iframe>

Read on and have fun!

## Selectors

A selector targets HTML to apply styles to content. We have already discovered a variety of selectors in the [Getting started with CSS](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps/Getting_started) tutorial. If CSS is not applying to content as-expected, your selector may not match the way you think it should match.

Each CSS rule starts with a selector—or a list of selectors—in order to tell the browser which element or elements the rules should apply to. All the examples below are valid selectors, or lists of selectors.

```css
h1
a:link
.manythings
#onething
*
.box p
.box p:first-child
h1, h2, .intro
```

Try creating some CSS rules that use the selectors above. Add HTML to be styled by the selectors. If any of the syntax above is not familiar, try searching MDN.

> **Note**: You will learn more about selectors in the next module: [CSS selectors](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Selectors).

### Specificity



You may encounter scenarios where two selectors select the same HTML element. Consider the stylesheet below, with a `p` selector that sets paragraph text to blue. However, there is also a class that sets the text of selected elements to red.

```css
.special {
  color: red;
}

p {
  color: blue;
}
```

Suppose that in our HTML document, we have a paragraph with a class of `special`. Both rules apply. Which selector prevails? Do you expect to see blue or red paragraph text?

```html
<p class="special">What color am I?</p>
```

The CSS language has rules to control which selector is stronger in the event of a conflict. These rules are called **cascade** and **specificity**. In the code block below, we define two rules for the `p` selector, but the paragraph text will be blue. This is because the declaration that sets the paragraph text to blue appears later in the stylesheet. Later styles replace conflicting styles that appear earlier in the stylesheet. This is the **cascade** rule.

```css
p {
  color: red;
}

p {
  color: blue;
}
```

However, in the case of our earlier example with the conflict between the class selector and the element selector, the class prevails, rendering red paragraph text. How can this happen even though a conflicting style appears later in the stylesheet? A class is rated as being more specific, as in having more **specificity** than the element selector, so it cancels the other conflicting style declaration.

Try this experiment for yourself! Add HTML, then add the two `p { ... }` rules to your stylesheet. Next, change the first `p` selector to `.special` to see how it changes the styling.

The rules of specificity and the cascade can seem complicated at first. These rules are easier to understand as you become more familiar with CSS. The [Cascade and inheritance](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Cascade_and_inheritance) section in the next module explains this in detail, including how to calculate specificity.

For now, remember that specificity exists. Sometimes, CSS might not apply as you expected because something else in the stylesheet has more specificity. Recognizing that more than one rule could apply to an element, is the first step in fixing these kinds of issues.

## Properties and values

At its most basic level, CSS consists of two components:

- **Properties**: These are human-readable identifiers that indicate which stylistic features you want to modify. For example, `font-size`, `width`, `background-color`.
- **Values**: Each property is assigned a value. This value indicates how to style the property.

The example below highlights a single property and value. The property name is `color` and the value is `blue`.

![A declaration highlighted in the CSS](https://mdn.mozillademos.org/files/16498/declaration.png)

When a property is paired with a value, this pairing is called a *CSS declaration*. CSS declarations are found within *CSS Declaration Blocks*. In the example below, highlighting identifies the CSS declaration block..

![A highlighted declaration block](https://mdn.mozillademos.org/files/16499/declaration-block.png)

Finally, CSS declaration blocks are paired with *selectors* to produce *CSS rulesets* (or *CSS rules*). The example below contains two rules: one for the `h1` selector and one for the `p` selector. The colored highlighting identifies the `h1` rule.

![The rule for h1 highlighted](https://mdn.mozillademos.org/files/16500/rules.png)

Setting CSS properties to specific values is the primary way of defining layout and styling for a document. The CSS engine calculates which declarations apply to every single element of a page.

> **Important:** CSS properties and values are case-sensitive. The property and value in each pair is separated by a colon. (`:`)

**Look up different values of properties listed below. Write CSS rules that apply styling to different HTML elements:**

- **[`font-size`](https://developer.mozilla.org/en-US/docs/Web/CSS/font-size)**
- **[`width`](https://developer.mozilla.org/en-US/docs/Web/CSS/width)**
- **[`background-color`](https://developer.mozilla.org/en-US/docs/Web/CSS/background-color)**
- **[`color`](https://developer.mozilla.org/en-US/docs/Web/CSS/color)**
- **[`border`](https://developer.mozilla.org/en-US/docs/Web/CSS/border)**

> **Important**: If a property is unknown, or if a value is not valid for a given property, the declaration is processed as *invalid*. It is completely ignored by the browser's CSS engine.
>
> **Important**: In CSS (and other web standards), it has been agreed that US spelling is the standard where there is language variation or uncertainty. For example, `color` should be spelled `color`, as `colour` will not work.

###  Functions



While most values are relatively simple keywords or numeric values, there are some values which take the form of a function. An example would be the `calc()` function, which can do simple math within CSS:

```html
<div class="outer"><div class="box">The inner box is 90% - 30px.</div></div>
.outer {
  border: 5px solid black;
}

.box {
  padding: 10px;
  width: calc(90% - 30px);
  background-color: rebeccapurple;
  color: white;
}
```

This renders as:

<iframe class="live-sample-frame" frameborder="0" height="800" src="https://mdn.github.iocss-examples/learn/getting-started/experiment-sandbox.html" width="100%"></iframe>



A function consists of the function name, and parentheses to enclose the values for the function. In the case of the `calc()` example above, the values define the width of this box to be 90% of the containing block width, minus 30 pixels. The result of the calculation isn't something that can be computed in advance and entered as a static value.

Another example would be the various values for [`transform`](https://developer.mozilla.org/en-US/docs/Web/CSS/transform), such as `rotate()`.

```html
<div class="box"></div>
.box {
  margin: 30px;
  width: 100px;
  height: 100px;
  background-color: rebeccapurple;
  transform: rotate(0.8turn)
}
```

The output from the above code looks like this:

<iframe class="live-sample-frame sample-code-frame" frameborder="0" height="200" id="frame_transform_example" src="https://mdn.mozillademos.org/en-US/docs/Learn/CSS/First_steps/How_CSS_is_structured$samples/transform_example?revision=1642153" width="100%"></iframe>





**Look up different values of properties listed below. Write CSS rules that apply styling to different HTML elements:**

- **[`transform`](https://developer.mozilla.org/en-US/docs/Web/CSS/transform)**
- **[`background-image`](https://developer.mozilla.org/en-US/docs/Web/CSS/background-image), in particular gradient values**
- **[`color`](https://developer.mozilla.org/en-US/docs/Web/CSS/color), in particular rgb/rgba/hsl/hsla values**

## @rules

CSS `@rules` (pronounced "at-rules") provide instruction for what CSS should perform or how it should behave. Some `@rules` are simple with just a keyword and a value. For example, `@import` imports a stylesheet into another CSS stylesheet:

```css
@import 'styles2.css';
```

One common `@rule` that you are likely to encounter is `@media`, which is used to create [media queries](https://developer.mozilla.org/en-US/docs/Web/CSS/Media_Queries). Media queries use conditional logic for applying CSS styling.

In the example below, the stylesheet defines a default pink background for the `<body>` element. However, a media query follows that defines a blue background if the browser viewport is wider than 30em.

```css
body {
  background-color: pink;
}

@media (min-width: 30em) {
  body {
    background-color: blue;
  }
}
```

You will encounter other `@rules` throughout these tutorials.

**See if you can add a media query that changes styles based on the viewport width. Change the width of your browser window to see the result.**

## Shorthands

Some properties like [`font`](https://developer.mozilla.org/en-US/docs/Web/CSS/font), [`background`](https://developer.mozilla.org/en-US/docs/Web/CSS/background), [`padding`](https://developer.mozilla.org/en-US/docs/Web/CSS/padding), [`border`](https://developer.mozilla.org/en-US/docs/Web/CSS/border), and [`margin`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin) are called **shorthand properties.** This is because shorthand properties set several values in a single line.

For example, this one line of code:

```css
/* In 4-value shorthands like padding and margin, the values are applied
   in the order top, right, bottom, left (clockwise from the top). There are also other 
   shorthand types, for example 2-value shorthands, which set padding/margin
   for top/bottom, then left/right */
padding: 10px 15px 15px 5px;
```

is equivalent to these four lines of code:

```css
padding-top: 10px;
padding-right: 15px;
padding-bottom: 15px;
padding-left: 5px;
```

This one line:

```css
background: red url(bg-graphic.png) 10px 10px repeat-x fixed;
```

is equivalent to these five lines:

```css
background-color: red;
background-image: url(bg-graphic.png);
background-position: 10px 10px;
background-repeat: repeat-x;
background-attachment: fixed;
```

Later in the course, you will encounter many other examples of shorthand properties. MDN's [CSS reference ](https://developer.mozilla.org/en-US/docs/Web/CSS/Reference)is a good resource for more information about any shorthand property.

**Try using the declarations (above) in your own CSS exercise to become more familiar with how it works. You can also experiment with different values.**

> **Warning**: One less obvious aspect of using CSS shorthand is how omitted values reset. A value not specified in CSS shorthand reverts to its initial value. This means an omission in CSS shorthand can **override previously set values**.

## Comments

As with any coding work, it is best practice to write comments along with CSS. This helps you to remember how the code works as you come back later for fixes or enhancement. It also helps others understand the code.

CSS Comments begin with `/*` and end with `*/`. In the example below, comments mark the start of distinct sections of code. This helps to navigate the codebase as it gets larger. With this kind of commenting in place, searching for comments in your code editor becomes a way to efficiently find a section of code.

```css
/* Handle basic element styling */
/* -------------------------------------------------------------------------------------------- */
body {
  font: 1em/150% Helvetica, Arial, sans-serif; 
  padding: 1em; 
  margin: 0 auto; 
  max-width: 33em;
}

@media (min-width: 70em) {
  /* Let's special case the global font size. On large screen or window,
     we increase the font size for better readability */
  body {
    font-size: 130%;
  }
}

h1 {font-size: 1.5em;}

/* Handle specific elements nested in the DOM  */
/* -------------------------------------------------------------------------------------------- */
div p, #id:first-line {
  background-color: red; 
  border-radius: 3px;
}

div p {
  margin: 0; 
  padding: 1em;
}

div p + p {
  padding-top: 0;
}
```

"Commenting out" code is also useful for temporarily disabling sections of code for testing. In the example below, the rules for `.special` are disabled by "commenting out" the code.

```css
/*.special { 
  color: red; 
}*/

p { 
  color: blue; 
}
```

**Add comments to your CSS.**

## White space

White space means actual spaces, tabs and new lines. Just as browsers ignore white space in HTML, browsers ignore white space inside CSS. The value of white space is how it can improve readability.

In the example below, each declaration (and rule start/end) has its own line. This is arguably a good way to write CSS. It makes it easier to maintain and understand CSS.

```css
body {
  font: 1em/150% Helvetica, Arial, sans-serif;
  padding: 1em;
  margin: 0 auto;
  max-width: 33em;
}

@media (min-width: 70em) {
  body {
    font-size: 130%;
  }
}

h1 {
  font-size: 1.5em;
}

div p,
#id:first-line {
  background-color: red;
  border-radius: 3px;
}

div p {
  margin: 0;
  padding: 1em;
}

div p + p {
  padding-top: 0;
}
```

The next example shows the equivalent CSS in a more compressed format. Although the two examples work the same, the one below is more difficult to read.

```css
body {font: 1em/150% Helvetica, Arial, sans-serif; padding: 1em; margin: 0 auto; max-width: 33em;}
@media (min-width: 70em) { body {font-size: 130%;} }

h1 {font-size: 1.5em;}

div p, #id:first-line {background-color: red; border-radius: 3px;}
div p {margin: 0; padding: 1em;}
div p + p {padding-top: 0;}
```

For your own projects, you will format your code according to personal preference. For team projects, you may find that a team or project has its own style guide.

> **Important:** Though white space separates values in CSS declarations, **property names never have white space**
>
> For example, these declarations are valid CSS:

```css
margin: 0 auto;
padding-left: 10px;
```

But these declarations are invalid:

```css
margin: 0auto;
padding- left: 10px;
```

Do you see the spacing errors? First, `0auto` is not recognized as a valid value for the `margin` property. The entry `0auto` is meant to be two separate values: `0` and `auto`. Second, the browser does not recognize `padding-` as a valid property. The correct property name (`padding-left`) is separated by an errant space.

You should always make sure to separate distinct values from one another by at least one space. Keep property names and property values together as single unbroken strings.

**To find out how spacing can break CSS, try playing with spacing inside your test CSS.**





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

<iframe class="live-sample-frame sample-code-frame" frameborder="0" height="55" id="frame_A_real_DOM_representation" src="https://mdn.mozillademos.org/en-US/docs/Learn/CSS/First_steps/How_CSS_works$samples/A_real_DOM_representation?revision=1636645" width="100%"></iframe>

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

<iframe class="live-sample-frame sample-code-frame" frameborder="0" height="55" id="frame_Applying_CSS_to_the_DOM" src="https://mdn.mozillademos.org/en-US/docs/Learn/CSS/First_steps/How_CSS_works$samples/Applying_CSS_to_the_DOM?revision=1636645" width="100%"></iframe>

In our [Debugging CSS](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Debugging_CSS) article in the next module we will be using browser DevTools to debug CSS problems, and will learn more about how the browser interprets CSS.

## What happens if a browser encounters CSS it doesn't understand?

[In an earlier lesson](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps/What_is_CSS#Browser_support) I mentioned that browsers do not all implement new CSS at the same time. In addition, many people are not using the latest version of a browser. Given that CSS is being developed all the time, and is therefore ahead of what browsers can recognise, you might wonder what happens if a browser encounters a CSS selector or declaration it doesn't recognise.

The answer is that it does nothing, and just moves on to the next bit of CSS!

If a browser is parsing your rules, and encounters a property or value that it doesn't understand, it ignores it and moves on to the next declaration. It will do this if you have made an error and misspelled a property or value, or if the property or value is just too new and the browser doesn't yet support it.

Similarly, if a browser encounters a selector that it doesn't understand, it will just ignore the whole rule and move on to the next one.

In the example below I have used the British English spelling for color, which makes that property invalid as it is not recognised. So my paragraph has not been colored blue. All of the other CSS have been applied however; only the invalid line is ignored.

```html
<p> I want this text to be large, bold and blue.</p>
```

```css
p {
  font-weight: bold;
  colour: blue; /* incorrect spelling of the color property */
  font-size: 200%;
}
```

<iframe class="live-sample-frame sample-code-frame" frameborder="0" height="200" id="frame_Skipping_example" src="https://mdn.mozillademos.org/en-US/docs/Learn/CSS/First_steps/How_CSS_works$samples/Skipping_example?revision=1636645" width="100%"></iframe>

<div class="open-in-host-container"><button class="open-in-host button neutral">Open in CodePen</button><button class="open-in-host button neutral">Open in JSFiddle</button></div>



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



# Using your new knowledge

With the things you have learned in the last few lessons you should find that you can format simple text documents using CSS, to add your own style to them. This assessment gives you a chance to do that.

| Prerequisites: | Before attempting this assessment you should have worked through the rest of the CSS basics module, and also have an understanding of HTML basics (study [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML)). |
| :------------- | ------------------------------------------------------------ |
| Objective:     | To have a play with some CSS and test your new-found knowledge. |

## Starting point

You can work in the live editor below, or you can [download the starting point](https://github.com/mdn/css-examples/blob/master/learn/getting-started/biog-download.html/) to work with in your own editor. This is a single page with the HTML, plus the starting point CSS in the head of the document. If you prefer you could move this CSS to a separate file when you create the example on your local computer. Alternatively use an online tool such as [CodePen](https://codepen.io/), [jsFiddle](https://jsfiddle.net/), or [Glitch](https://glitch.com/) to work on the tasks.

**Note**: If you get stuck, then ask us for help — see the [Assessment or further help](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps/Using_your_new_knowledge#Assessment_or_further_help) section at the bottom of this page.

## Working with CSS

The following live example shows a biography, which has been styled using CSS. The CSS properties that I have used are as follows — each one links to its property page on MDN, which will give you more examples of its use.

- [`font-family`](https://developer.mozilla.org/en-US/docs/Web/CSS/font-family)
- [`color`](https://developer.mozilla.org/en-US/docs/Web/CSS/color)
- [`border-bottom`](https://developer.mozilla.org/en-US/docs/Web/CSS/border-bottom)
- [`font-weight`](https://developer.mozilla.org/en-US/docs/Web/CSS/font-weight)
- [`font-size`](https://developer.mozilla.org/en-US/docs/Web/CSS/font-size)
- [`text-decoration`](https://developer.mozilla.org/en-US/docs/Web/CSS/text-decoration)

I have used a mixture of selectors, styling elements such as h1 and h2, but also creating a class for the job title and styling that.

Use CSS to change how this biography looks by changing the values of the properties I have used.

1. Make the level one heading pink, using the CSS color keyword `hotpink`.
2. Give the heading a 10px dotted [`border-bottom`](https://developer.mozilla.org/en-US/docs/Web/CSS/border-bottom) which uses the CSS color keyword `purple`.
3. Make the level 2 heading italic.
4. Give the `ul` used for the contact details a [`background-color`](https://developer.mozilla.org/en-US/docs/Web/CSS/background-color) of `#eeeeee`, and a 5px solid purple [`border`](https://developer.mozilla.org/en-US/docs/Web/CSS/border). Use some [`padding`](https://developer.mozilla.org/en-US/docs/Web/CSS/padding) to push the content away from the border.
5. Make the links `green` on hover.

You should end up with something like this image.

![Screenshot of how the example should look after completing the assessment.](https://mdn.mozillademos.org/files/17035/learn-css-basics-assessment.png)

Afterwards try looking up some properties not mentioned on this page in the [MDN CSS reference](https://developer.mozilla.org/en-US/docs/Web/CSS/Reference) and get adventurous!

Remember that there is no wrong answer here — at this stage in your learning you can afford to have a bit of fun.

 <iframe class="live-sample-frame" frameborder="0" height="1600" src="https://mdn.github.io/css-examples/learn/getting-started/biog.html" width="100%"></iframe>





## Assessment or further help

If you would like your work assessed, or are stuck and want to ask for help:

1. Put your work into an online shareable editor such as [CodePen](https://codepen.io/), [jsFiddle](https://jsfiddle.net/), or [Glitch](https://glitch.com/).

2. Write a post asking for assessment and/or help at the

    

   MDN Discourse forum Learning category

   . Your post should include:

   - A descriptive title such as "Assessment wanted for CSS First Steps".
   - Details of what you have already tried, and what you would like us to do, e.g. if you are stuck and need help, or want an assessment.
   - A link to the example you want assessed or need help with, in an online shareable editor (as mentioned in step 1 above). This is a good practice to get into — it's very hard to help someone with a coding problem if you can't see their code.
   - A link to the actual task or assessment page, so we can find the question you want help with.

## What's next?

Congratulations on finishing this first module. You should now have a good general understanding of CSS, and be able to understand much of what is happening in a stylesheet. In the next module, [CSS building blocks](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks), we will go on to look at a number of key areas in depth.



# CSS building blocks overview

This module carries on where [CSS first steps](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps) left off — now you've gained familiarity with the language and its syntax, and got some basic experience with using it, its time to dive a bit deeper. This module looks at the cascade and inheritance, all the selector types we have available, units, sizing, styling backgrounds and borders, debugging, and lots more.

The aim here is to provide you with a toolkit for writing competent CSS and help you understand all the essential theory, before moving on to more specific disciplines like [text styling](https://developer.mozilla.org/en-US/docs/Learn/CSS/Styling_text) and [CSS layout](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout).

### Looking to become a front-end web developer?

We have put together a course that includes all the essential information you need to work towards your goal.

[Get started](https://developer.mozilla.org/docs/Learn/Front-end_web_developer)

## Prerequisites

Before starting this module, you should have:

1. Basic familiarity with using computers, and using the Web passively (i.e. just looking at it, consuming the content.)
2. A basic work environment set up as detailed in [Installing basic software](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/Installing_basic_software), and an understanding of how to create and manage files, as detailed in [Dealing with files](https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/Dealing_with_files).
3. Basic familiarity with HTML, as discussed in the [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML) module.
4. An understanding of the basics of CSS, as discussed in the [CSS first steps](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps) module.

> **Note**: If you are working on a computer/tablet/another device where you don't have the ability to create your own files, you could try out (most of) the code examples in an online coding program such as [JSBin](http://jsbin.com/) or [Glitch](https://glitch.com/).

## Guides

This module contains the following articles, which cover the most essential parts of the CSS language. Along the way you'll come across plenty of exercises to allow you to test your understanding.

- [Cascade and inheritance](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Cascade_and_inheritance)

  The aim of this lesson is to develop your understanding of some of the most fundamental concepts of CSS — the cascade, specificity, and inheritance — which control how CSS is applied to HTML and how conflicts are resolved.

- [CSS selectors](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Selectors)

  There are a wide variety of CSS selectors available, allowing for fine-grained precision when selecting elements to style. In this article and its sub-articles, we'll run through the different types in great detail, seeing how they work. The sub-articles are as follows:

  - [Type, class, and ID selectors](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Selectors/Type_Class_and_ID_Selectors)
  - [Attribute selectors](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Selectors/Attribute_selectors)
  - [Pseudo-classes and pseudo-elements](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Selectors/Pseudo-classes_and_pseudo-elements)
  - [Combinators](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Selectors/Combinators)

- [The box model](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/The_box_model)

  Everything in CSS has a box around it, and understanding these boxes is key to being able to create layouts with CSS, or to align items with other items. In this lesson, we will take a proper look at the CSS *Box Model*, in order that you can move onto more complex layout tasks with an understanding of how it works and the terminology that relates to it.

- [Backgrounds and borders](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Backgrounds_and_borders)

  In this lesson we will take a look at some of the creative things you can do with CSS backgrounds and borders. From adding gradients, background images, and rounded corners, backgrounds and borders are the answer to a lot of styling questions in CSS.

- [Handling different text directions](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Handling_different_text_directions)

  In recent years, CSS has evolved in order to better support different directionality of content, including right-to-left but also top-to-bottom content (such as Japanese) — these different directionalities are called **writing modes**. As you progress in your study and begin to work with layout, an understanding of writing modes will be very helpful to you, therefore we will introduce them in this article.

- [Overflowing content](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Overflowing_content)

  In this lesson we will look at another important concept in CSS — **overflow**. Overflow is what happens when there is too much content to be contained comfortably inside a box. In this guide, you will learn what it is and how to manage it.

- [CSS values and units](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Values_and_units)

  Every property used in CSS has a value or set of values that are allowed for that property. In this lesson, we will take a look at some of the most common values and units in use.

- [Sizing items in CSS](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Sizing_items_in_CSS)

  In the various lessons so far you have come across a number of ways to size items on a web page using CSS. Understanding how big the different features in your design will be is important, and in this lesson, we will summarize the various ways elements get a size via CSS and define a few terms around sizing that will help you in the future.

- [Images, media, and form elements](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Images_media_form_elements)

  In this lesson we will take a look at how certain special elements are treated in CSS. Images, other media, and form elements behave a little differently in terms of your ability to style them with CSS than regular boxes. Understanding what is and isn't possible can save some frustration, and this lesson will highlight some of the main things that you need to know.

- [Styling tables](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Styling_tables)

  Styling an HTML table isn't the most glamorous job in the world, but sometimes we all have to do it. This article provides a guide to making HTML tables look good, with some specific table styling techniques highlighted.

- [Debugging CSS](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Debugging_CSS)

  Sometimes when writing CSS you will encounter an issue where your CSS doesn't seem to be doing what you expect. This article will give you guidance on how to go about debugging a CSS problem, and show you how the DevTools included in all modern browsers can help you find out what is going on.

- [Organizing your CSS](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Organizing)

  As you start to work on larger stylesheets and big projects you will discover that maintaining a huge CSS file can be challenging. In this article, we will take a brief look at some best practices for writing your CSS to make it easily maintainable, and some of the solutions you will find in use by others to help improve maintainability.

## Assessments

Want to test your CSS skills? The following assessments will test your understanding of the CSS covered in the guides above.

- [Fundamental CSS comprehension](https://developer.mozilla.org/en-US/docs/Learn/CSS/Introduction_to_CSS/Fundamental_CSS_comprehension)

  This assessment tests your understanding of basic syntax, selectors, specificity, box model, and more.

- [Creating fancy letterheaded paper](https://developer.mozilla.org/en-US/docs/Learn/CSS/Styling_boxes/Creating_fancy_letterheaded_paper)

  If you want to make the right impression, writing a letter on nice letterheaded paper can be a really good start. In this assessment, we'll challenge you to create an online template to achieve such a look.

- [A cool looking box](https://developer.mozilla.org/en-US/docs/Learn/CSS/Styling_boxes/A_cool_looking_box)

  Here you'll get some practice in using background and border styling to create an eye-catching box.

## See also

- [Advanced styling effects](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Advanced_styling_effects)

  This article acts as a box of tricks, providing an introduction to some interesting advanced styling features such as box shadows, blend modes, and filters.

#### Metadata

# Cascade and inheritance

The aim of this lesson is to develop your understanding of some of the most fundamental concepts of CSS — the cascade, specificity, and inheritance — which control how CSS is applied to HTML and how conflicts are resolved.

While working through this lesson may seem less immediately relevant and a little more academic than some other parts of the course, an understanding of these things will save you much pain later on! We encourage you to work through this section carefully, and check that you understand the concepts before moving on.

| Prerequisites: | Basic computer literacy, [basic software installed](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Installing_basic_software), basic knowledge of [working with files](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Dealing_with_files), HTML basics (study [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML)), and an idea of how CSS works (study [CSS first steps](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps).) |
| :------------- | ------------------------------------------------------------ |
| Objective:     | To learn about the cascade and specificity, and how inheritance works in CSS. |

## Conflicting rules

CSS stands for **Cascading Style Sheets**, and that first word *cascading* is incredibly important to understand — the way that the cascade behaves is key to understanding CSS.

At some point, you will be working on a project and you will find that the CSS you thought should be applied to an element is not working. Usually the problem is that you have created two rules which could potentially apply to the same element. The **cascade**, and the closely-related concept of **specificity**, are mechanisms that control which rule applies when there is such a conflict. Which rule is styling your element may not be the one you expect, so you need to understand how these mechanisms work.

Also significant here is the concept of **inheritance**, which means that some CSS properties by default inherit values set on the current element's parent element, and some don't. This can also cause some behavior that you might not expect.

Let's start by taking a quick look at the key things we are dealing with, then we'll look at each in turn and see how they interact with each other and your CSS. This can seem like a set of tricky concepts to understand. As you get more practice writing CSS, however, the way it works will become more obvious to you.

### The cascade

Stylesheets **cascade** — at a very simple level this means that the order of CSS rules matter; when two rules apply that have equal specificity the one that comes last in the CSS is the one that will be used.

In the below example, we have two rules that could apply to the `h1`. The `h1` ends up being colored blue — these rules have an identical selector and therefore carry the same specificity, so the last one in the source order wins.

<iframe class="live-sample-frame" frameborder="0" height="400" src="https://mdn.github.io/css-examples/learn/cascade/cascade-simple.html" width="100%"></iframe>

### Specificity



Specificity is how the browser decides which rule applies if multiple rules have different selectors, but could still apply to the same element. It is basically a measure of how specific a selector's selection will be:

- An element selector is less specific — it will select all elements of that type that appear on a page — so will get a lower score.
- A class selector is more specific — it will select only the elements on a page that have a specific `class` attribute value — so will get a higher score.

Example time! Below we again have two rules that could apply to the `h1`. The below `h1` ends up being colored red — the class selector gives its rule a higher specificity, and so it will be applied even though the rule with the element selector appears further down in the source order.

<iframe class="live-sample-frame" frameborder="0" height="500" src="https://mdn.github.io/css-examples/learn/cascade/specificity-simple.html" width="100%"></iframe>

We'll explain specificity scoring and other such things later on.

### Inheritance



Inheritance also needs to be understood in this context — some CSS property values set on parent elements are inherited by their child elements, and some aren't.

For example, if you set a `color` and `font-family` on an element, every element inside it will also be styled with that color and font, unless you've applied different color and font values directly to them.

<iframe class="live-sample-frame" frameborder="0" height="550" src="https://mdn.github.io/css-examples/learn/cascade/inheritance-simple.html" width="100%"></iframe>

Some properties do not inherit — for example if you set a [`width`](https://developer.mozilla.org/en-US/docs/Web/CSS/width) of 50% on an element, all of its descendants do not get a width of 50% of their parent's width. If this was the case, CSS would be very frustrating to use!

> **Note**: On MDN CSS property reference pages you can find a technical information box, usually at the bottom of the specifications section, which lists a number of data points about that property, including whether it is inherited or not. See the [color property Specifications section](https://developer.mozilla.org/en-US/docs/Web/CSS/color#Specifications), for example.

## Understanding how the concepts work together

These three concepts together control which CSS applies to what element; in the below sections we'll see how they work together. It can sometimes seem a little bit complicated, but you will start to remember them as you get more experienced with CSS, and you can always look up the details if you forget! Even experienced developers don't remember all the details.

The below video shows how you can use the Firefox DevTools to inspect a page's cascade, specificity, and more:

<iframe src="https://www.youtube.com/embed/Sp9ZfSvpf7A?rel=0&amp;html5=1"></iframe>

## Understanding inheritance

We'll start with inheritance. In the example below we have a [`<ul>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/ul), with two levels of unordered lists nested inside it. We have given the outer `<ul>` a border, padding, and a font color.

**The color has applied to the direct children, but also the indirect children** — the immediate child `<li>`s, and those inside the first nested list. We have then added a class of `special` to the second nested list and applied a different color to it. This then inherits down through its children.

<iframe class="live-sample-frame" frameborder="0" height="700" src="https://mdn.github.io/css-examples/learn/cascade/inheritance.html" width="100%"></iframe>

 Things like widths (as mentioned above), margins, padding, and borders do not inherit. If a border were to be inherited by the children of our list, every single list and list item would gain a border — probably not an effect we would ever want!

Which properties are inherited by default and which aren't is largely down to common sense.

### Controlling inheritance

CSS provides four special universal property values for controlling inheritance. Every CSS property accepts these values.

- [`inherit`](https://developer.mozilla.org/en-US/docs/Web/CSS/inherit)

  Sets the property value applied to a selected element to be the same as that of its parent element. Effectively, this "turns on inheritance".

- [`initial`](https://developer.mozilla.org/en-US/docs/Web/CSS/initial)

  Sets the property value applied to a selected element to the [initial value](https://developer.mozilla.org/en-US/docs/Web/CSS/initial_value) of that property.

- [`unset`](https://developer.mozilla.org/en-US/docs/Web/CSS/unset)

  Resets the property to its natural value, which means that if the property is naturally inherited it acts like `inherit`, otherwise it acts like `initial`.

> **Note**: There is also a newer value, [`revert`](https://developer.mozilla.org/en-US/docs/Web/CSS/revert), which has limited browser support.
>
> **Note**: See [Origin of CSS declarations](https://developer.mozilla.org/en-US/docs/Web/CSS/Cascade#Origin_of_CSS_declarations) in [Introducing the CSS Cascade](https://developer.mozilla.org/en-US/docs/Web/CSS/Cascade) for more information on each of these and how they work.

We can look at a list of links and explore how the universal values work. The live example below allows you to play with the CSS and see what happens when you make changes. Playing with code really is the best way to get to grips with HTML and CSS.

For example:

1. The second list item has the class `my-class-1` applied. This sets the color of the `<a>` element nested inside to inherit. If you remove the rule how does it change the color of the link?
2. Do you understand why the third and fourth links are the color that they are? Check the description of the values above if not.
3. Which of the links will change color if you define a new color for the `<a>` element — for example `a { color: red; }`

<iframe class="live-sample-frame" frameborder="0" height="700" src="https://mdn.github.io/css-examples/learn/cascade/keywords.html" width="100%"></iframe>

### Resetting all property values



The CSS shorthand property `all` can be used to apply one of these inheritance values to (almost) all properties at once. Its value can be any one of the inheritance values (`inherit`, `initial`, `unset`, or `revert`). It's a convenient way to undo changes made to styles so that you can get back to a known starting point before beginning new changes.

In the below example we have two blockquotes. The first has styling applied to the blockquote element itself, the second has a class applied to the blockquote which sets the value of `all` to `unset`.

<iframe class="live-sample-frame" frameborder="0" height="700" src="https://mdn.github.io/css-examples/learn/cascade/all.html" width="100%"></iframe>

Try setting the value of `all` to some of the other available values and observe what the difference is.

## Understanding the cascade

We now understand why a paragraph nested deep in the structure of your HTML is the same color as the CSS applied to the body, and from the introductory lessons we have an understanding of how to change the CSS applied to something at any point in the document — whether by assigning CSS to an element or creating a class. We will now take a proper look at how the cascade defines which CSS rules apply when more than one thing could style an element.

There are three factors to consider, listed here in increasing order of importance. Later ones overrule earlier ones:

1. **Source order**
2. **Specificity**
3. **Importance**

We will look at these to see how browsers figure out exactly what CSS should be applied.

### Source order



We have already seen how source order matters to the cascade. If you have more than one rule, which has exactly the same weight, then the one that comes last in the CSS will win. You can think of this as rules which are nearer the element itself overwriting early ones until the last one wins and gets to style the element.

### Specificity



Once you understand the fact that source order matters, at some point you will run into a situation where you know that a rule comes later in the stylesheet, but an earlier, conflicting, rule is applied. This is because that earlier rule has a **higher specificity** — it is more specific, and therefore is being chosen by the browser as the one that should style the element.

As we saw earlier in this lesson, a class selector has more weight than an element selector, so the properties defined on the class will override those applied directly to the element.

Something to note here is that although we are thinking about selectors, and the rules that are applied to the thing they select, it isn't the entire rule which is overwritten, only the properties which are the same.

This behavior helps avoid repetition in your CSS. A common practice is to define generic styles for the basic elements, and then create classes for those which are different. For example, in the stylesheet below we have defined generic styles for level 2 headings, and then created some classes which change only some of the properties and values. The values defined initially are applied to all headings, then the more specific values are applied to the headings with the classes.

<iframe class="live-sample-frame" frameborder="0" height="700" src="https://mdn.github.io/css-examples/learn/cascade/mixing-rules.html" width="100%"></iframe>

Let's now have a look at how the browser will calculate specificity. We already know that an element selector has low specificity and can be overwritten by a class. Essentially a value in points is awarded to different types of selectors, and adding these up gives you the weight of that particular selector, which can then be assessed against other potential matches.

The amount of specificity a selector has is measured using four different values (or components), which can be thought of as thousands, hundreds, tens and ones — four single digits in four columns:

1. **Thousands**: Score one in this column if the declaration is inside a `style` attribute, aka inline styles. Such declarations don't have selectors, so their specificity is always simply 1000.
2. **Hundreds**: Score one in this column for each ID selector contained inside the overall selector.
3. **Tens**: Score one in this column for each class selector, attribute selector, or pseudo-class contained inside the overall selector.
4. **Ones**: Score one in this column for each element selector or pseudo-element contained inside the overall selector.

> **Note**: The universal selector (`*`), combinators (`+`, `>`, `~`, ' '), and negation pseudo-class (`:not`) have no effect on specificity.

The following table shows a few isolated examples to get you in the mood. Try going through these, and making sure you understand why they have the specificity that we have given them. We've not covered selectors in detail yet, but you can find details of each selector on the MDN [selectors reference](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Selectors).

<table class="standard-table">
 <thead>
  <tr>
   <th scope="col">Selector</th>
   <th scope="col">Thousands</th>
   <th scope="col">Hundreds</th>
   <th scope="col">Tens</th>
   <th scope="col">Ones</th>
   <th scope="col">Total specificity</th>
  </tr>
 </thead>
 <tbody>
  <tr>
   <td><code>h1</code></td>
   <td>0</td>
   <td>0</td>
   <td>0</td>
   <td>1</td>
   <td>0001</td>
  </tr>
  <tr>
   <td><code>h1 + p::first-letter</code></td>
   <td>0</td>
   <td>0</td>
   <td>0</td>
   <td>3</td>
   <td>0003</td>
  </tr>
  <tr>
   <td><code>li &gt; a[href*="en-US"] &gt; .inline-warning</code></td>
   <td>0</td>
   <td>0</td>
   <td>2</td>
   <td>2</td>
   <td>0022</td>
  </tr>
  <tr>
   <td><code>#identifier</code></td>
   <td>0</td>
   <td>1</td>
   <td>0</td>
   <td>0</td>
   <td>0100</td>
  </tr>
  <tr>
   <td>No selector, with a rule inside an element's <code><a href="/en-US/docs/Web/HTML/Global_attributes#attr-style">style</a></code> attribute</td>
   <td>1</td>
   <td>0</td>
   <td>0</td>
   <td>0</td>
   <td>1000</td>
  </tr>
 </tbody>
</table>

Before we move on, let's look at an example in action.



<iframe class="live-sample-frame" frameborder="0" height="700" src="https://mdn.github.io/css-examples/learn/cascade/specificity-boxes.html" width="100%"></iframe>

So what's going on here? First of all, we are only interested in the first seven rules of this example, and as you'll notice, we have included their specificity values in a comment before each one.

- The first two selectors are competing over the styling of the link's background color — the second one wins and makes the background color blue because it has an extra ID selector in the chain: its specificity is 201 vs. 101.
- The third and fourth selectors are competing over the styling of the link's text color — the second one wins and makes the text white because although it has one less element selector, the missing selector is swapped out for a class selector, which is worth ten rather than one. So the winning specificity is 113 vs. 104.
- Selectors 5–7 are competing over the styling of the link's border when hovered. Selector six clearly loses to five with a specificity of 23 vs. 24 — it has one fewer element selectors in the chain. Selector seven, however, beats both five and six — it has the same number of sub-selectors in the chain as five, but an element has been swapped out for a class selector. So the winning specificity is 33 vs. 23 and 24.



> **Note**: This has only been an approximate example for ease of understanding. In actuality, each selector type has its own level of specificity that cannot be overwritten by selectors with a lower specificity level. For example, a *million* **class** selectors combined would not be able to overwrite the rules of *one* **id** selector.
>
> A more accurate way to evaluate specificity would be to score the specificity levels individually starting from highest and moving on to lowest when necessary. Only when there is a tie between selector scores within a specificity level do you need to evaluate the next level down; otherwise, you can disregard the lower specificity level selectors since they can never overwrite the higher specificity levels.

### !important



There is a special piece of CSS that you can use to overrule all of the above calculations, however you should be very careful with using it — `!important`. This is used to make a particular property and value the most specific thing, thus overriding the normal rules of the cascade.

Take a look at this example where we have two paragraphs, one of which has an ID.

<iframe class="live-sample-frame" frameborder="0" height="700" src="https://mdn.github.io/css-examples/learn/cascade/important.html" width="100%"></iframe>

Let's walk through this to see what's happening — try removing some of the properties to see what happens if you are finding it hard to understand:

1. You'll see that the third rule's [`color`](https://developer.mozilla.org/en-US/docs/Web/CSS/color) and [`padding`](https://developer.mozilla.org/en-US/docs/Web/CSS/padding) values have been applied, but the [`background-color`](https://developer.mozilla.org/en-US/docs/Web/CSS/background-color) hasn't. Why? Really all three should surely apply, because rules later in the source order generally override earlier rules.
2. However, The rules above it win, because class selectors have higher specificity than element selectors.
3. Both elements have a `class` of `better`, but the 2nd one has an `id` of `winning` too. Since IDs have an *even higher* specificity than classes (you can only have one element with each unique ID on a page, but many elements with the same class — ID selectors are *very specific* in what they target), the red background color and the 1 pixel black border should both be applied to the 2nd element, with the first element getting the gray background color, and no border, as specified by the class.
4. The 2nd element *does* get the red background color, but no border. Why? Because of the `!important` declaration in the second rule — including this after `border: none` means that this declaration will win over the border value in the previous rule, even though the ID has higher specificity.

> **Note**: The only way to override this `!important` declaration would be to include another `!important` declaration on a declaration with the *same specificity* later in the source order, or one with a higher specificity.

It is useful to know that `!important` exists so that you know what it is when you come across it in other people's code. **However, we strongly recommend that you never use it unless you absolutely have to.** `!important` changes the way the cascade normally works, so it can make debugging CSS problems really hard to work out, especially in a large stylesheet.

One situation in which you may have to use it is when you are working on a CMS where you can't edit the core CSS modules, and you really want to override a style that can't be overridden in any other way. But really, don't use it if you can avoid it.

## The effect of CSS location

Finally, it is also useful to note that the importance of a CSS declaration depends on what stylesheet it is specified in — it is possible for users to set custom stylesheets to override the developer's styles, for example the user might be visually impaired, and want to set the font size on all web pages they visit to be double the normal size to allow for easier reading.

## To summarize

Conflicting declarations will be applied in the following order, with later ones overriding earlier ones:

1. Declarations in user agent style sheets (e.g. the browser's default styles, used when no other styling is set).

2. Normal declarations in user style sheets (custom styles set by a user).

3. Normal declarations in author style sheets (these are the styles set by us, the web developers).

4. Important declarations in author style sheets

5. Important declarations in user style sheets

   It makes sense for web developers' stylesheets to override user stylesheets, so the design can be kept as intended, but sometimes users have good reasons to override web developer styles, as mentioned above — this can be achieved by using `!important` in their rules.

## Test your skills!

We have covered a lot in this article, but can you remember the most important information? You can find some further tests to verify that you've retained this information before you move on — see [Test your skills: the Cascade](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Cascade_tasks).

## What's next

If you understood most of this article, then well done — you've started getting familiar with the fundamental mechanics of CSS. Next up, we'll look at selectors in detail.

If you didn't fully understand the cascade, specificity, and inheritance, then don't worry! This is definitely the most complicated thing we've covered so far in the course, and is something that even professional web developers sometimes find tricky. We'd advise that you return to this article a few times as you continue through the course, and keep thinking about it.

Refer back here if you start to come across strange issues with styles not applying as expected. It could be a specificity issue.



# CSS selectors

In [CSS](https://developer.mozilla.org/en-US/docs/Glossary/CSS), selectors are used to target the [HTML](https://developer.mozilla.org/en-US/docs/Glossary/HTML) elements on our web pages that we want to style. There are a wide variety of CSS selectors available, allowing for fine-grained precision when selecting elements to style. In this article and its sub-articles we'll run through the different types in great detail, seeing how they work.

| Prerequisites: | Basic computer literacy, [basic software installed](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Installing_basic_software), basic knowledge of [working with files](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Dealing_with_files), HTML basics (study [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML)), and an idea of how CSS works (study [CSS first steps](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps).) |
| :------------- | ------------------------------------------------------------ |
| Objective:     | To learn how CSS selectors work in detail.                   |

## What is a selector?

You have met selectors already. A CSS selector is the first part of a CSS Rule. It is a pattern of elements and other terms that tell the browser which HTML elements should be selected to have the CSS property values inside the rule applied to them. The element or elements which are selected by the selector are referred to as the *subject of the selector*.

![Some code with the h1 highlighted.](https://mdn.mozillademos.org/files/16550/selector.png)

In earlier articles you met some different selectors, and learned that there are selectors that target the document in different ways — for example by selecting an element such as `h1`, or a class such as `.special`.

In CSS, selectors are defined in the CSS Selectors specification; like any other part of CSS they need to have support in browsers for them to work. The majority of selectors that you will come across are defined in the [Level 3 Selectors specification](https://www.w3.org/TR/selectors-3/), which is a mature specification, therefore you will find excellent browser support for these selectors

## Selector lists

If you have more than one thing which uses the same CSS then the individual selectors can be combined into a *selector list* so that the rule is applied to all of the individual selectors. For example, if I have the same CSS for an `h1` and also a class of `.special`, I could write this as two separate rules.

```css
h1 { 
  color: blue; 
} 

.special { 
  color: blue; 
} 
```

I could also combine these into a selector list, by adding a comma between them.

```css
h1, .special { 
  color: blue; 
} 
```

White space is valid before or after the comma. You may also find the selectors more readable if each is on a new line.

```css
h1, 
.special {
  color: blue; 
} 
```

In the live example below try combining the two selectors which have identical declarations. The visual display should be the same after combining them.

<iframe class="live-sample-frame" frameborder="0" height="1000" src="https://mdn.github.io/css-examples/learn/selectors/selector-list.html" width="100%"></iframe>

When you group selectors in this way, if any selector is invalid the whole rule will be ignored.

In the following example, the invalid class selector rule will be ignored, whereas the `h1` would still be styled.

```
h1 { 
  color: blue; 
} 

..special { 
  color: blue; 
} 
```

When combined however, neither the `h1` nor the class will be styled as the entire rule is deemed invalid.

## Types of selectors

There are a few different groupings of selectors, and knowing which type of selector you might need will help you to find the right tool for the job. In this article's subarticles we will look at the different groups of selectors in more detail.

### Type, class, and ID selectors



This group includes selectors that target an HTML element such as an `<h1>`.

```css
h1 { }
```

It also includes selectors which target a class:

```css
.box { }
```

or, an ID:

```css
#unique { }
```

### Attribute selectors



This group of selectors gives you different ways to select elements based on the presence of a certain attribute on an element:



```css
a[title] { }
```

Or even make a selection based on the presence of an attribute with a particular value:

```css
a[href="https://example.com"] { }
```

### Pseudo-classes and pseudo-elements



This group of selectors includes *pseudo-classes*, which style certain states of an element. The `:hover` pseudo-class for example selects an element only when it is being hovered over by the mouse pointer:

```css
a:hover { }
```

It also includes pseudo-elements, which select a certain part of an element rather than the element itself. For example, `::first-line` always selects the first line of text inside an element (a `<p>` in the below case), acting as if a `<span>` was wrapped around the first formatted line and then selected.

```css
p::first-line { }
```

### Combinators



The final group of selectors combine other selectors in order to target elements within our documents. The following for example selects paragraphs that are direct children of `<article>` elements using the child combinator (`>`):

```css
article > p { }
```

## Next steps

You can take a look at the reference table of selectors below for direct links to the various types of selectors in this Learn section or on MDN in general, or continue on to start your journey by finding out about [type, class, and ID selectors](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Selectors/Type_Class_and_ID_Selectors).

# Type, class, and ID selectors

## Type selectors

A **type selector** is sometimes referred to as a *tag name selector* or *element selector*, because it selects an HTML tag/element in your document. In the example below we have used the span, em and strong selectors. All instances of `<span>`, `<em>` and `<strong>` elements are therefore styled accordingly.

**Try adding a CSS rule to select the `<h1>` element and change its color to blue.**

<iframe class="live-sample-frame" frameborder="0" height="1100" src="https://mdn.github.io/css-examples/learn/selectors/type.html" width="100%"></iframe>

## The universal selector

The universal selector is indicated by an asterisk (`*`) and selects everything in the document (or inside the parent element if it is being chained together with another element and a descendant combinator). In the following example we have used the universal selector to remove the margins on all elements. This means that instead of the default styling added by the browser, which spaces out headings and paragraphs with margins, everything is close together and we can't see the different paragraphs easily.

<iframe class="live-sample-frame" frameborder="0" height="750" src="https://mdn.github.io/css-examples/learn/selectors/universal.html" width="100%"></iframe>

This kind of behavior can sometimes be seen in "reset stylesheets", which strips out all of the browser styling. Since the universal selector makes global changes, we use it to deal with very specific situations such as the one outlined below.

### Using the universal selector to make your selectors easier to read



One use of the universal selector is to make selectors easier to read and more obvious in terms of what they are doing. For example, if I wanted to select the first child of any descendant element of `<article>` , no matter what element it was, and make it bold, I could use the [`:first-child`](https://developer.mozilla.org/en-US/docs/Web/CSS/:first-child) selector, which we will learn more about in the lesson on [pseudo-classes and pseudo-elements](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Selectors/Pseudo-classes_and_pseudo-elements), as a descendant selector along with the `<article>` element selector: 

```css
article :first-child {

}
```

This could be confused however with `article:first-child`, which will select any `<article>` element that is the first child of another element.

To avoid this confusion we can add the universal selector to the `:first-child` selector, so it is obvious what the selector is doing. It is selecting *any* element which is the first-child of any descendant element of `<article>`:

```css
article *:first-child { 

} 
```

Although both do the same thing, the readability is significantly improved.

## Class selectors

The class selector starts with a full stop (`.`) character and will select everything in the document with that class applied to it. In the live example below we have created a class called `.highlight`, and have applied it to several places in my document. All of the elements that have the class applied are highlighted.

<iframe class="live-sample-frame" frameborder="0" height="750" src="https://mdn.github.io/css-examples/learn/selectors/class.html" width="100%"></iframe>

### Targeting classes on particular elements



You can create a selector that will target specific elements with the class applied. In this next example we will highlight a `<span>` with a class of `highlight` differently to an `<h1>` heading with a class of `highlight`. We do this by using the type selector for the element I want to target, with the class appended using a dot, with no white space in between.

<iframe class="live-sample-frame" frameborder="0" height="750" src="https://mdn.github.io/css-examples/learn/selectors/class.html" width="100%"></iframe>

This approach reduces the scope of a rule as the rule will only apply to that particular element & class combination; so you would need to add another selector if you decided the rule should apply to other elements too.

###  Target an element if it has more than one class applied



You can apply multiple classes to an element and target them individually, or only select the element when all of the classes in the selector are present. This can be helpful when building up components that can be combined in different ways on your site.

In the example below we have a `<div>` that contains a note. The grey border is applied when the box has a class of `notebox`. If it also has a class of `warning` or `danger`, we change the [`border-color`](https://developer.mozilla.org/en-US/docs/Web/CSS/border-color).

We can tell the browser that we only want to match the element if it has two classes applied by chaining them together with no white space between them. You'll see that the last `<div>` doesn't get any styling applied, as it only has the `danger` class; it needs `notebox` as well to get anything applied.

<iframe class="live-sample-frame" frameborder="0" height="900" src="https://mdn.github.io/css-examples/learn/selectors/class-many.html" width="100%"></iframe>



## ID Selectors

An ID selector begins with a `#` rather than a full stop character, but is basically used in the same way as a class selector. An ID however can be used only once per document, and elements can only have a single `id` value applied to them. It can select an element that has the `id` set on it, and you can precede the ID with a type selector to only target the element if both the element and ID match. You can see both of these uses in the following example:

<iframe class="live-sample-frame" frameborder="0" height="900" src="https://mdn.github.io/css-examples/learn/selectors/class-many.html" width="100%"></iframe>

> **Warning:** Using the same ID multiple times in a document may appear to work for styling purposes, but don't do this. It results in invalid code, and will cause strange behavior in many places.
>
> **Note**: As we learned in the lesson on specificity, an ID has high specificity and will overrule most other selectors. This can make them difficult to deal with. In most cases it is preferable to add a class to the element rather than use an ID, however if using the ID is the only way to target the element — perhaps because you do not have access to the markup and so cannot edit it — this will work.

# Attribute selectors



As you know from your study of HTML, elements can have attributes that give further detail about the element being marked up. In CSS you can use attribute selectors to target elements with certain attributes. This lesson will show you how to use these very useful selectors.

| Prerequisites: | Basic computer literacy, [basic software installed](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Installing_basic_software), basic knowledge of [working with files](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Dealing_with_files), HTML basics (study [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML)), and an idea of how CSS works (study [CSS first steps](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps).) |
| :------------- | ------------------------------------------------------------ |
| Objective:     | To learn what attribute selectors are and how to use them.   |

## Presence and value selectors

These selectors enable the selection of an element based on the presence of an attribute alone (for example `href`), or on various different matches against the value of the attribute.

| Selector        | Example                         | Description                                                  |
| :-------------- | :------------------------------ | :----------------------------------------------------------- |
| `[attr]`        | `a[title]`                      | Matches elements with an *attr* attribute (whose name is the value in square brackets). |
| `[attr=value]`  | `a[href="https://example.com"]` | Matches elements with an *attr* attribute whose value is exactly *value* — the string inside the quotes. |
| `[attr~=value]` | `p[class~="special"]`           | Matches elements with an *attr* attribute whose value is exactly *value*, or contains *value* in its (space separated) list of values. |
| `[attr|=value]` | `div[lang|="zh"]`               | Matches elements with an *attr* attribute whose value is exactly *value* or begins with *value* immediately followed by a hyphen. |

In the example below you can see these selectors being used.

- By using `li[class]` we can match any selector with a class attribute. This matches all of the list items except the first one.
- `li[class="a"]` matches a selector with a class of `a`, but not a selector with a class of `a` with another space-separated class as part of the value. It selects the second list item.
- `li[class~="a"]` will match a class of `a` but also a value that contains the class of `a` as part of a whitespace-separated list. It selects the second and third list items.

<iframe class="live-sample-frame" frameborder="0" height="800" src="https://mdn.github.io/css-examples/learn/selectors/attribute.html" width="100%"></iframe>

## Substring matching selectors

These selectors allow for more advanced matching of substrings inside the value of your attribute. For example, if you had classes of `box-warning` and `box-error` and wanted to match everything that started with the string "box-", you could use `[class^="box-"]` to select them both (or `[class|="box"]` as described in section above).

| Selector        | Example             | Description                                                  |
| :-------------- | :------------------ | :----------------------------------------------------------- |
| `[attr^=value]` | `li[class^="box-"]` | Matches elements with an *attr* attribute (whose name is the value in square brackets), whose value begins with *value*. |
| `[attr$=value]` | `li[class$="-box"]` | Matches elements with an *attr* attribute whose value ends with *value*. |
| `[attr*=value]` | `li[class*="box"]`  | Matches elements with an *attr* attribute whose value contains *value* anywhere within the string. |

(Aside: It may help to note that `^` and `$` have long been used as *anchors* in so-called *regular expressions* to mean *begins with* and *ends with*.)

The next example shows usage of these selectors:

- `li[class^="a"]` matches any attribute value which starts with `a`, so matches the first two list items.
- `li[class$="a"]` matches any attribute value that ends with `a`, so matches the first and third list item.
- `li[class*="a"]` matches any attribute value where `a` appears anywhere in the string, so it matches all of our list items.

<iframe class="live-sample-frame" frameborder="0" height="800" src="https://mdn.github.io/css-examples/learn/selectors/attribute-substring.html" width="100%"></iframe>

## Case-sensitivity

If you want to match attribute values case-insensitively you can use the value `i` before the closing bracket. This flag tells the browser to match ASCII characters case-insensitively. Without the flag the values will be matched according to the case-sensitivity of the document language — in HTML's case it will be case sensitive.

In the example below, the first selector will match a value that begins with `a` — it only matches the first list item because the other two list items start with an uppercase A. The second selector uses the case-insensitive flag and so matches all of the list items.

<iframe class="live-sample-frame" frameborder="0" height="800" src="https://mdn.github.io/css-examples/learn/selectors/attribute-case.html" width="100%"></iframe>

> **Note**: There is also a newer value `s`, which will force case-sensitive matching in contexts where matching is normally case-insensitive, however this is less well supported in browsers and isn't very useful in an HTML context.

## Next steps

Now we are done with attribute selectors, you can continue on to the next article and read about [pseudo-class and pseudo-element selectors](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Selectors/Pseudo-classes_and_pseudo-elements).

# Pseudo-classes and pseudo-elements

The next set of selectors we will look at are referred to as **pseudo-classes** and **pseudo-elements**. There are a large number of these, and they often serve quite specific purposes. Once you know how to use them, you can look at the list to see if there is something which works for the task you are trying to achieve. Once again the relevant MDN page for each selector is helpful in explaining browser support.

| Prerequisites: | Basic computer literacy, [basic software installed](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Installing_basic_software), basic knowledge of [working with files](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Dealing_with_files), HTML basics (study [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML)), and an idea of how CSS works (study [CSS first steps](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps).) |
| :------------- | ------------------------------------------------------------ |
| Objective:     | To learn about the pseudo-class and pseudo-element selectors. |

## What is a pseudo-class?

A pseudo-class is a selector that selects elements that are in a specific state, e.g. they are the first element of their type, or they are being hovered over by the mouse pointer. They tend to act as if you had applied a class to some part of your document, often helping you cut down on excess classes in your markup, and giving you more flexible, maintainable code.

Pseudo-classes are keywords that start with a colon:

```css
:pseudo-class-name
```

### Simple pseudo-class example



Let's look at a simple example. If we wanted to make the first paragraph in an article larger and bold, we could add a class to that paragraph and then add CSS to that class, as shown in the first example below:

<iframe class="live-sample-frame" frameborder="0" height="800" src="https://mdn.github.io/css-examples/learn/selectors/first-child.html" width="100%"></iframe>

However, this could be annoying to maintain — what if a new paragraph got added to the top of the document? We'd need to move the class over to the new paragraph. Instead of adding the class, we could use the [`:first-child`](https://developer.mozilla.org/en-US/docs/Web/CSS/:first-child) pseudo-class selector — this will *always* target the first child element in the article, and we will no longer need to edit the HTML (this may not always be possible anyway, maybe due to it being generated by a CMS.)



<iframe class="live-sample-frame" frameborder="0" height="700" src="https://mdn.github.io/css-examples/learn/selectors/first-child2.html" width="100%"></iframe>

All pseudo-classes behave in this same kind of way. They target some bit of your document that is in a certain state, behaving as if you had added a class into your HTML. Take a look at some other examples on MDN:

- `:last-child`
- `:only-child`
- `:invalid`



> **Note**: It is valid to write pseudo-classes and elements without any element selector preceding them. In the example above, you could write `:first-child` and the rule would apply to *any* element that is the first child of an `<article>` element, not just a paragraph first child — `:first-child` is equivalent to `*:first-child`. However, usually you want more control than that, so you need to be more specific.

### User-action pseudo classes



Some pseudo-classes only apply when the user interacts with the document in some way. These **user-action** pseudo-classes, sometimes referred to as **dynamic pseudo-classes**, act as if a class had been added to the element when the user interacts with it. Examples include:

- `:hover` — mentioned above; this only applies if the user moves their pointer over an element, typically a link.
- `:focus` — only applies if the user focuses the element using keyboard controls.

<iframe class="live-sample-frame" frameborder="0" height="500" src="https://mdn.github.io/css-examples/learn/selectors/hover.html" width="100%"></iframe>

## What is a pseudo-element?

Pseudo-elements behave in a similar way, however they act as if you had added a whole new HTML element into the markup, rather than applying a class to existing elements. Pseudo-elements start with a double colon `::`.

```
::pseudo-element-name
```

> **Note**: Some early pseudo-elements used the single colon syntax, so you may sometimes see this in code or examples. Modern browsers support the early pseudo-elements with single- or double-colon syntax for backwards compatibility.



For example, if you wanted to select the first line of a paragraph you could wrap it in a `<span>` element and use an element selector; however, that would fail if the number of words you had wrapped were longer or shorter than the parent element's width. As we tend not to know how many words will fit on a line — as that will change if the screen width or font-size changes — it is impossible to robustly do this by adding HTML.

The `::first-line` pseudo-element selector will do this for you reliably — if the number of words increases and decreases it will still only select the first line.

<iframe class="live-sample-frame" frameborder="0" height="800" src="https://mdn.github.io/css-examples/learn/selectors/first-line.html" width="100%"></iframe>

It acts as if a `<span>` was magically wrapped around that first formatted line, and updated each time the line length changed.

You can see that this selects the first line of both paragraphs.

## Combining pseudo-classes and pseudo-elements

If you wanted to make the first line of the first paragraph bold you could chain the `:first-child` and `::first-line` selectors together. Try editing the previous live example so it uses the following CSS. We are saying that we want to select the first line, of the first `<p>` element, which is inside an `<article>` element.

```css
article p:first-child::first-line { 
  font-size: 120%; 
  font-weight: bold; 
}
```



## Generating content with ::before and ::after

There are a couple of special pseudo-elements, which are used along with the `content` property to insert content into your document using CSS.

You could use these to insert a string of text, such as in the live example below. Try changing the text value of the [`content`](https://developer.mozilla.org/en-US/docs/Web/CSS/content) property and see it change in the output. You could also change the `::before` pseudo-element to `::after` and see the text inserted at the end of the element instead of the beginning.

<iframe class="live-sample-frame" frameborder="0" height="400" src="https://mdn.github.io/css-examples/learn/selectors/before.html" width="100%"></iframe>

Inserting strings of text from CSS isn't really something we do very often on the web however, as that text is inaccessible to some screen readers and might be hard for someone to find and edit in the future.

A more valid use of these pseudo-elements is to insert an icon, for example the little arrow added in the example below, which is a visual indicator that we wouldn't want read out by a screenreader:





<iframe class="live-sample-frame" frameborder="0" height="400" src="https://mdn.github.io/css-examples/learn/selectors/after-icon.html" width="100%"></iframe>



These pseudo-elements are also frequently used to insert an empty string, which can then be styled just like any element on the page.

In this next example, we have added an empty string using the `::before` pseudo-element. We have set this to `display: block` in order that we can style it with a width and height. We then use CSS to style it just like any element. You can play around with the CSS and change how it looks and behaves.

<iframe class="live-sample-frame" frameborder="0" height="500" src="https://mdn.github.io/css-examples/learn/selectors/before-styled.html" width="100%"></iframe>

The use of the `::before` and `::after` pseudo-elements along with the `content` property is referred to as "Generated Content" in CSS, and you will often see this technique being used for various tasks. A great example is the site [CSS Arrow Please](http://www.cssarrowplease.com/), which helps you to generate an arrow with CSS. Look at the CSS as you create your arrow and you will see the [`::before`](https://developer.mozilla.org/en-US/docs/Web/CSS/::before) and [`::after`](https://developer.mozilla.org/en-US/docs/Web/CSS/::after) pseudo-elements in use. Whenever you see these selectors, look at the [`content`](https://developer.mozilla.org/en-US/docs/Web/CSS/content) property to see what is being added to the document.

## Reference section

There are a large number of pseudo-classes and pseudo-elements, and it is useful to have a list to refer to. Below are tables listing them, with links to their reference pages on MDN. Use this as a reference to see the kind of things that are available for you to target.

### Pseudo-classes

| Selector                                                     | Description                                                  |
| :----------------------------------------------------------- | :----------------------------------------------------------- |
| [`:active`](https://developer.mozilla.org/en-US/docs/Web/CSS/:active) | Matches when the user activates (for example clicks on) an element. |
| [`:any-link`](https://developer.mozilla.org/en-US/docs/Web/CSS/:any-link) | Matches both the `:link` and `:visited` states of a link.    |
| [`:blank`](https://developer.mozilla.org/en-US/docs/Web/CSS/:blank) | Matches an [`` element](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input) whose input value is empty. |
| [`:checked`](https://developer.mozilla.org/en-US/docs/Web/CSS/:checked) | Matches a radio button or checkbox in the selected state.    |
| `:current`                                                   | Matches the element, or an ancestor of the element, that is currently being displayed. |
| [`:default`](https://developer.mozilla.org/en-US/docs/Web/CSS/:default) | Matches the one or more UI elements that are the default among a set of similar elements. |
| [`:dir`](https://developer.mozilla.org/en-US/docs/Web/CSS/:dir) | Select an element based on its directionality (value of the HTML `dir` attribute or CSS `direction` property). |
| [`:disabled`](https://developer.mozilla.org/en-US/docs/Web/CSS/:disabled) | Matches user interface elements that are in an disabled state. |
| [`:empty`](https://developer.mozilla.org/en-US/docs/Web/CSS/:empty) | Matches an element that has no children except optionally white space. |
| [`:enabled`](https://developer.mozilla.org/en-US/docs/Web/CSS/:enabled) | Matches user interface elements that are in an enabled state. |
| [`:first`](https://developer.mozilla.org/en-US/docs/Web/CSS/:first) | In [Paged Media](https://developer.mozilla.org/en-US/docs/Web/CSS/Paged_Media), matches the first page. |
| [`:first-child`](https://developer.mozilla.org/en-US/docs/Web/CSS/:first-child) | Matches an element that is first among its siblings.         |
| [`:first-of-type`](https://developer.mozilla.org/en-US/docs/Web/CSS/:first-of-type) | Matches an element which is first of a certain type among its siblings. |
| [`:focus`](https://developer.mozilla.org/en-US/docs/Web/CSS/:focus) | Matches when an element has focus.                           |
| [`:focus-visible`](https://developer.mozilla.org/en-US/docs/Web/CSS/:focus-visible) | Matches when an element has focus and the focus should be visible to the user. |
| [`:focus-within`](https://developer.mozilla.org/en-US/docs/Web/CSS/:focus-within) | Matches an element with focus plus an element with a descendent that has focus. |
| `:future`                                                    | Matches the elements after the current element.              |
| [`:hover`](https://developer.mozilla.org/en-US/docs/Web/CSS/:hover) | Matches when the user hovers over an element.                |
| [`:indeterminate`](https://developer.mozilla.org/en-US/docs/Web/CSS/:indeterminate) | Matches UI elements whose value is in an indeterminate state, usually [checkboxes](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/checkbox). |
| [`:in-range`](https://developer.mozilla.org/en-US/docs/Web/CSS/:in-range) | Matches an element with a range when its value is in-range.  |
| [`:invalid`](https://developer.mozilla.org/en-US/docs/Web/CSS/:invalid) | Matches an element, such as an `<input>`, in an invalid state. |
| [`:lang`](https://developer.mozilla.org/en-US/docs/Web/CSS/:lang) | Matches an element based on language (value of the HTML [lang](https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/lang) attribute). |
| [`:last-child`](https://developer.mozilla.org/en-US/docs/Web/CSS/:last-child) | Matches an element which is last among its siblings.         |
| [`:last-of-type`](https://developer.mozilla.org/en-US/docs/Web/CSS/:last-of-type) | Matches an element of a certain type that is last among its siblings. |
| [`:left`](https://developer.mozilla.org/en-US/docs/Web/CSS/:left) | In [Paged Media](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Pages), matches left-hand pages. |
| [`:link`](https://developer.mozilla.org/en-US/docs/Web/CSS/:link) | Matches unvisited links.                                     |
| `:local-link`                                                | Matches links pointing to pages that are in the same site as the current document. |
| [`:is()`](https://developer.mozilla.org/en-US/docs/Web/CSS/:is) | Matches any of the selectors in the selector list that is passed in. |
| [`:not`](https://developer.mozilla.org/en-US/docs/Web/CSS/:not) | Matches things not matched by selectors that are passed in as a value to this selector. |
| [`:nth-child`](https://developer.mozilla.org/en-US/docs/Web/CSS/:nth-child) | Matches elements from a list of siblings — the siblings are matched by a formula of the form an+b (e.g. 2n + 1 would match elements 1, 3, 5, 7, etc. All the odd ones.) |
| [`:nth-of-type`](https://developer.mozilla.org/en-US/docs/Web/CSS/:nth-of-type) | Matches elements from a list of siblings that are of a certain type (e.g. `<p>` elements) — the siblings are matched by a formula of the form an+b (e.g. 2n + 1 would match that type of element, numbers 1, 3, 5, 7, etc. All the odd ones.) |
| [`:nth-last-child`](https://developer.mozilla.org/en-US/docs/Web/CSS/:nth-last-child) | Matches elements from a list of siblings, counting backwards from the end. The siblings are matched by a formula of the form an+b (e.g. 2n + 1 would match the last element in the sequence, then two elements before that, then two elements before that, etc. All the odd ones, counting from the end.) |
| [`:nth-last-of-type`](https://developer.mozilla.org/en-US/docs/Web/CSS/:nth-last-of-type) | Matches elements from a list of siblings that are of a certain type (e.g. `<p>` elements), counting backwards from the end. The siblings are matched by a formula of the form an+b (e.g. 2n + 1 would match the last element of that type in the sequence, then two elements before that, then two elements before that, etc. All the odd ones, counting from the end.) |
| [`:only-child`](https://developer.mozilla.org/en-US/docs/Web/CSS/:only-child) | Matches an element that has no siblings.                     |
| [`:only-of-type`](https://developer.mozilla.org/en-US/docs/Web/CSS/:only-of-type) | Matches an element that is the only one of its type among its siblings. |
| [`:optional`](https://developer.mozilla.org/en-US/docs/Web/CSS/:optional) | Matches form elements that are not required.                 |
| [`:out-of-range`](https://developer.mozilla.org/en-US/docs/Web/CSS/:out-of-range) | Matches an element with a range when its value is out of range. |
| `:past`                                                      | Matches the elements before the current element.             |
| [`:placeholder-shown`](https://developer.mozilla.org/en-US/docs/Web/CSS/:placeholder-shown) | Matches an input element that is showing placeholder text.   |
| `:playing`                                                   | Matches an element representing an audio, video, or similar resource that is capable of being “played” or “paused”, when that element is “playing”. |
| `:paused`                                                    | Matches an element representing an audio, video, or similar resource that is capable of being “played” or “paused”, when that element is “paused”. |
| [`:read-only`](https://developer.mozilla.org/en-US/docs/Web/CSS/:read-only) | Matches an element if it is not user-alterable.              |
| [`:read-write`](https://developer.mozilla.org/en-US/docs/Web/CSS/:read-write) | Matches an element if it is user-alterable.                  |
| [`:required`](https://developer.mozilla.org/en-US/docs/Web/CSS/:required) | Matches form elements that are required.                     |
| [`:right`](https://developer.mozilla.org/en-US/docs/Web/CSS/:right) | In [Paged Media](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Pages), matches right-hand pages. |
| [`:root`](https://developer.mozilla.org/en-US/docs/Web/CSS/:root) | Matches an element that is the root of the document.         |
| [`:scope`](https://developer.mozilla.org/en-US/docs/Web/CSS/:scope) | Matches any element that is a scope element.                 |
| [`:valid`](https://developer.mozilla.org/en-US/docs/Web/CSS/:valid) | Matches an element such as an `<input>` element, in a valid state. |
| [`:target`](https://developer.mozilla.org/en-US/docs/Web/CSS/:target) | Matches an element if it is the target of the current URL (i.e. if it has an ID matching the current [URL fragment](https://en.wikipedia.org/wiki/Fragment_identifier)). |
| [`:visited`](https://developer.mozilla.org/en-US/docs/Web/CSS/:visited) | Matches visited links.                                       |

### Pseudo-elements



| Selector                                                     | Description                                                  |
| :----------------------------------------------------------- | :----------------------------------------------------------- |
| [`::after`](https://developer.mozilla.org/en-US/docs/Web/CSS/::after) | Matches a stylable element appearing after the originating element's actual content. |
| [`::before`](https://developer.mozilla.org/en-US/docs/Web/CSS/::before) | Matches a stylable element appearing before the originating element's actual content. |
| [`::first-letter`](https://developer.mozilla.org/en-US/docs/Web/CSS/::first-letter) | Matches the first letter of the element.                     |
| [`::first-line`](https://developer.mozilla.org/en-US/docs/Web/CSS/::first-line) | Matches the first line of the containing element.            |
| [`::grammar-error`](https://developer.mozilla.org/en-US/docs/Web/CSS/::grammar-error) | Matches a portion of the document containing a grammar error as flagged by the browser. |
| [`::marker`](https://developer.mozilla.org/en-US/docs/Web/CSS/::marker) | Matches the marker box of a list item, which typically contains a bullet or number. |
| [`::selection`](https://developer.mozilla.org/en-US/docs/Web/CSS/::selection) | Matches the portion of the document that has been selected.  |
| [`::spelling-error`](https://developer.mozilla.org/en-US/docs/Web/CSS/::spelling-error) | Matches a portion of the document containing a spelling error as flagged by the browser. |



# Combinators

## Descendant combinator

The **descendant combinator** — typically represented by a single space (` `) character — combines two selectors such that elements matched by the second selector are selected if they have an ancestor (parent, parent's parent, parent's parent's parent, etc) element matching the first selector. Selectors that utilize a descendant combinator are called descendant selectors.

```css
body article p
```

In the example below, we are matching only the `<p>` element which is inside an element with a class of `.box`.

<iframe class="live-sample-frame" frameborder="0" height="500" src="https://mdn.github.io/css-examples/learn/selectors/descendant.html" width="100%"></iframe>

## 

## Child combinator

The **child combinator** (`>`) is placed between two CSS selectors. It matches only those elements matched by the second selector that are the direct children of elements matched by the first. Descendent elements further down the hierarchy don't match. For example, to select only `<p>` elements that are direct children of `<article>` elements:

```css
article > p
```

In this next example, we have an unordered list, nested inside of which is an ordered list. I am using the child combinator to select only the `<li>` elements which are a direct child of a `<ul>`, and have given them a top border.

If you remove the `>` that designates this as a child combinator, you end up with a descendant selector and all `<li>` elements will get a red border.

<iframe class="live-sample-frame" frameborder="0" height="600" src="https://mdn.github.io/css-examples/learn/selectors/child.html" width="100%"></iframe>

## Adjacent sibling combinator

The adjacent sibling selector (`+`) is used to select something if it is right next to another element at the same level of the hierarchy. For example, to select all `<img>` elements that come right after `<p>` elements:

```css
p + img
```

A common use case is to do something with a paragraph that follows a heading, as in my example below. Here we are looking for a paragraph which is directly adjacent to an `<h1>`, and styling it.

If you insert some other element such as a `<h2>` in between the `<h1>` and the `<p>`, you will find that the paragraph is no longer matched by the selector and so does not get the background and foreground color applied when the element is adjacent.

<iframe class="live-sample-frame" frameborder="0" height="800" src="https://mdn.github.io/css-examples/learn/selectors/adjacent.html" width="100%"></iframe>



## General sibling combinator

If you want to select siblings of an element even if they are not directly adjacent, then you can use the general sibling combinator (`~`). To select all `<img>` elements that come *anywhere* after `<p>` elements, we'd do this:

```css
p ~ img
```

In the example below we are selecting all `<p>` elements that come after the `<h1>`, and even though there is a `<div>` in the document as well, the `<p>` that comes after it is selected.

<iframe class="live-sample-frame" frameborder="0" height="600" src="https://mdn.github.io/css-examples/learn/selectors/general.html" width="100%"></iframe>

## Using combinators

You can combine any of the selectors that we discovered in previous lessons with combinators in order to pick out part of your document. For example if we want to select list items with a class of "a", which are direct children of a `<ul>`, I could use the following.

```css
ul > li[class="a"]  {  }
```

Take care however when creating big lists of selectors that select very specific parts of your document. It will be hard to reuse the CSS rules as you have made the selector very specific to the location of that element in the markup.

It is often better to create a simple class and apply that to the element in question. That said, your knowledge of combinators will come in very useful if you need to get to something in your document and are unable to access the HTML, perhaps due to it being generated by a CMS.

## Using combinators

You can combine any of the selectors that we discovered in previous lessons with combinators in order to pick out part of your document. For example if we want to select list items with a class of "a", which are direct children of a `<ul>`, I could use the following.

```css
ul > li[class="a"]  {  }
```

Take care however when creating big lists of selectors that select very specific parts of your document. It will be hard to reuse the CSS rules as you have made the selector very specific to the location of that element in the markup.

It is often better to create a simple class and apply that to the element in question. That said, your knowledge of combinators will come in very useful if you need to get to something in your document and are unable to access the HTML, perhaps due to it being generated by a CMS.

## Test your skills!

We have covered a lot in this article, but can you remember the most important information? You can find some further tests to verify that you've retained this information before you move on — see [Test your skills: Selectors](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Selectors/Selectors_Tasks).

## Moving on

This is the last section in our lessons on selectors. Next we will move on to another important part of CSS — the [CSS Box Model](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/The_box_model).

# The box model

Everything in CSS has a box around it, and understanding these boxes is key to being able to create layouts with CSS, or to align items with other items. In this lesson, we will take a proper look at the CSS *Box Model* so that you can build more complex layout tasks with an understanding of how it works and the terminology that relates to it.

| Prerequisites: | Basic computer literacy, [basic software installed](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Installing_basic_software), basic knowledge of [working with files](https://developer.mozilla.org/en-US/Learn/Getting_started_with_the_web/Dealing_with_files), HTML basics (study [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML)), and an idea of how CSS works (study [CSS first steps](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps).) |
| :------------- | ------------------------------------------------------------ |
| Objective:     | To learn about the CSS Box Model, what makes up the box model and how to switch to the alternate model. |

## Block and inline boxes

In CSS we broadly have two types of boxes — **block boxes** and **inline boxes**. These characteristics refer to how the box behaves in terms of page flow, and in relation to other boxes on the page:

If a box is defined as a block, it will behave in the following ways:

- The box will break onto a new line.
- The box will extend in the inline direction to fill the space available in its container. In most cases this means that the box will become as wide as its container, filling up 100% of the space available.
- The [`width`](https://developer.mozilla.org/en-US/docs/Web/CSS/width) and [`height`](https://developer.mozilla.org/en-US/docs/Web/CSS/height) properties are respected.
- Padding, margin and border will cause other elements to be pushed away from the box

Unless we decide to change the display type to inline, elements such as headings (e.g. `<h1>`) and `<p>` all use `block` as their outer display type by default.

If a box has an outer display type of `inline`, then:

- The box will not break onto a new line.
- The [`width`](https://developer.mozilla.org/en-US/docs/Web/CSS/width) and [`height`](https://developer.mozilla.org/en-US/docs/Web/CSS/height) properties will not apply.
- Vertical padding, margins, and borders will apply but will not cause other inline boxes to move away from the box.
- Horizontal padding, margins, and borders will apply and will cause other inline boxes to move away from the box.

The `<a>` element, used for links, `<span>`, `<em>` and `<strong>` are all examples of elements that will display inline by default.

The type of box applied to an element is defined by [`display`](https://developer.mozilla.org/en-US/docs/Web/CSS/display) property values such as `block` and `inline`, and relates to the **outer** value of `display`.



## Aside: Inner and outer display types

At this point, we'd better also explain **inner** and **outer** display types. As mentioned above, boxes in CSS have an *outer* display type, which details whether the box is block or inline.

Boxes also have an *inner* display type, however, which dictates how elements inside that box are laid out. By default, the elements inside a box are laid out in **[normal flow](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Normal_Flow)**, which means that they behave just like any other block and inline elements (as explained above).

We can, however, change the inner display type by using `display` values like `flex`. If we set `display: flex;` on an element, the outer display type is `block`, but the inner display type is changed to `flex`. Any direct children of this box will become flex items and will be laid out according to the rules set out in the [Flexbox](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Flexbox) spec, which you'll learn about later on.

> **Note**: To read more about the values of display, and how boxes work in block and inline layout, take a look at the MDN guide to [Block and Inline Layout](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Flow_Layout/Block_and_Inline_Layout_in_Normal_Flow).

When you move on to learn about CSS Layout in more detail, you will encounter `flex`, and various other inner values that your boxes can have, for example `grid`.

Block and inline layout, however, is the default way that things on the web behave — as we said above, it is sometimes referred to as *normal flow*, because without any other instruction, our boxes lay out as block or inline boxes.







# CSS layout

At this point we've already looked at CSS fundamentals, how to style text, and how to style and manipulate the boxes that your content sits inside. Now it's time to look at how to place your boxes in the right place in relation to the viewport, and one another. We have covered the necessary prerequisites so we can now dive deep into CSS layout, looking at different display settings, modern layout tools like flexbox, CSS grid, and positioning, and some of the legacy techniques you might still want to know about.

### Looking to become a front-end web developer?

We have put together a course that includes all the essential information you need to work towards your goal.

[Get started](https://developer.mozilla.org/docs/Learn/Front-end_web_developer)

## Prerequisites

Before starting this module, you should already:

1. Have basic familiarity with HTML, as discussed in the [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML) module.
2. Be comfortable with CSS fundamentals, as discussed in [Introduction to CSS](https://developer.mozilla.org/en-US/docs/Learn/CSS/Introduction_to_CSS).
3. Understand how to [style boxes](https://developer.mozilla.org/en-US/docs/Learn/CSS/Styling_boxes).

**Note**: If you are working on a computer/tablet/other device where you don't have the ability to create your own files, you could try out (most of) the code examples in an online coding program such as [JSBin](http://jsbin.com/) or [Glitch](https://glitch.com/).

## Guides

These articles will provide instruction on the fundamental layout tools and techniques available in CSS. At the end of the lessons is an assessment to help you check your understanding of layout methods, by laying out a webpage.

- [Introduction to CSS layout](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Introduction)

  This article will recap some of the CSS layout features we've already touched upon in previous modules — such as different [`display`](https://developer.mozilla.org/en-US/docs/Web/CSS/display) values — and introduce some of the concepts we'll be covering throughout this module.

- [Normal flow](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Normal_Flow)

  Elements on webpages lay themselves out according to *normal flow* - until we do something to change that. This article explains the basics of normal flow as a grounding for learning how to change it.

- [Flexbox](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Flexbox)

  [Flexbox](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Flexible_Box_Layout/Using_flexbox_to_lay_out_web_applications) is a one-dimensional layout method for laying out items in rows or columns. Items flex to fill additional space and shrink to fit into smaller spaces. This article explains all the fundamentals. After studying this guide you can [test your flexbox skills](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Flexbox_skills) to check your understanding before moving on.

- [Grids](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Grids)

  CSS Grid Layout is a two-dimensional layout system for the web. It lets you lay content out in rows and columns, and has many features that make building complex layouts straightforward. This article will give you all you need to know to get started with page layout, then [test your grid skills](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Grid_skills) before moving on.

- [Floats](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Floats)

  Originally for floating images inside blocks of text, the [`float`](https://developer.mozilla.org/en-US/docs/Web/CSS/float) property became one of the most commonly used tools for creating multiple column layouts on webpages. With the advent of Flexbox and Grid it has now returned to its original purpose, as this article explains.

- [Positioning](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Positioning)

  Positioning allows you to take elements out of the normal document layout flow, and make them behave differently, for example sitting on top of one another, or always remaining in the same place inside the browser viewport. This article explains the different [`position`](https://developer.mozilla.org/en-US/docs/Web/CSS/position) values, and how to use them.

- [Multiple-column layout](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Multiple-column_Layout)

  The multiple-column layout specification gives you a method of laying content out in columns, as you might see in a newspaper. This article explains how to use this feature.

- [Responsive design](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Responsive_Design)

  As more diverse screen sizes have appeared on web-enabled devices, the concept of responsive web design (RWD) has appeared: a set of practices that allows web pages to alter their layout and appearance to suit different screen widths, resolutions, etc. It is an idea that changed the way we design for a multi-device web, and in this article we'll help you understand the main techniques you need to know to master it.

- [Beginner's guide to media queries](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Media_queries)

  The **CSS Media Query** gives you a way to apply CSS only when the browser and device environment matches a rule that you specify, for example "viewport is wider than 480 pixels". Media queries are a key part of responsive web design, as they allow you to create different layouts depending on the size of the viewport, but they can also be used to detect other things about the environment your site is running on, for example whether the user is using a touchscreen rather than a mouse. In this lesson you will first learn about the syntax used in media queries, and then move on to use them in a worked example showing how a simple design might be made responsive.

- [Legacy layout methods](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Legacy_Layout_Methods)

  Grid systems are a very common feature used in CSS layouts, and before CSS Grid Layout they tended to be implemented using floats or other layout features. You imagine your layout as a set number of columns (e.g. 4, 6, or 12), and then fit your content columns inside these imaginary columns. In this article we'll explore how these older methods work, in order that you understand how they were used if you work on an older project.

- [Supporting older browsers](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Supporting_Older_Browsers)

  In this module we recommend using Flexbox and Grid as the main layout methods for your designs. However there will be visitors to your site who use older browsers, or browsers which do not support the methods you have used. This will always be the case on the web — as new features are developed, different browsers will prioritise different things. This article explains how to use modern web techniques without locking out users of older technology.

- [Assessment: Fundamental layout comprehension](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Fundamental_Layout_Comprehension)

  An assessment to test your knowledge of different layout methods by laying out a webpage.

# Introduction to CSS layout

This article will recap some of the CSS layout features we've already touched upon in previous modules — such as different [`display`](https://developer.mozilla.org/en-US/docs/Web/CSS/display) values — and introduce some of the concepts we'll be covering throughout this module.

| Prerequisites: | The basics of HTML (study [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML)), and an idea of How CSS works (study [Introduction to CSS](https://developer.mozilla.org/en-US/docs/Learn/CSS/Introduction_to_CSS).) |
| :------------- | ------------------------------------------------------------ |
| Objective:     | To give you an overview of CSS page layout techniques. Each technique can be learned in greater detail in subsequent tutorials. |

CSS page layout techniques allow us to take elements contained in a web page and control where they are positioned relative to their default position in normal layout flow, the other elements around them, their parent container, or the main viewport/window.  The page layout techniques we'll be covering in more detail in this module are

- Normal flow
- The [`display`](https://developer.mozilla.org/en-US/docs/Web/CSS/display) property
- Flexbox
- Grid
- Floats
- Positioning
- Table layout
- Multiple-column layout

Each technique has its uses, advantages, and disadvantages, and no technique is designed to be used in isolation. By understanding what each method is designed for you will be in a good place to understand which is the best layout tool for each task.

## Normal flow

Normal flow is how the browser lays out HTML pages by default when you do nothing to control page layout. Let's look at a quick HTML example:

```html
<p>I love my cat.</p>
    
<ul>
  <li>Buy cat food</li>
  <li>Exercise</li>
  <li>Cheer up friend</li>
</ul>
    
<p>The end!</p>
```

By default, the browser will display this code as follows:

<iframe class="live-sample-frame sample-code-frame" frameborder="0" height="200" id="frame_Normal_flow" src="https://mdn.mozillademos.org/en-US/docs/Learn/CSS/CSS_layout/Introduction$samples/Normal_flow?revision=1619420" width="100%"></iframe>

Note here how the HTML is displayed in the exact order in which it appears in the source code, with elements stacked up on top of one another — the first paragraph, followed by the unordered list, followed by the second paragraph.

The elements that appear one below the other are described as *block* elements, in contrast to *inline* elements, which appear one beside the other, like the individual words in a paragraph.

> **Note**: The direction in which block element contents are laid out is described as the Block Direction. The Block Direction runs vertically in a language such as English, which has a horizontal writing mode. It would run horizontally in any language with a Vertical Writing Mode, such as Japanese. The corresponding Inline Direction is the direction in which inline contents (such as a sentence) would run.

For many of the elements on your page the normal flow will create exactly the layout you need, however for more complex layouts you will need to alter this default behavior using some of the tools available to you in CSS. Starting with a well-structured HTML document is very important, as you can then work with the way things are laid out by default rather than fighting against it.

The methods that can change how elements are laid out in CSS are as follows:

- **The [`display`](https://developer.mozilla.org/en-US/docs/Web/CSS/display) property** — Standard values such as `block`, `inline` or `inline-block` can change how elements behave in normal flow, for example making a block-level element behave like an inline element (see [Types of CSS boxes](https://developer.mozilla.org/en-US/docs/Learn/CSS/Introduction_to_CSS/Box_model#Types_of_CSS_boxes) for more information). We also have entire layout methods that are switched on via specific `display` values, for example [CSS Grid](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Grids) and [Flexbox](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Flexbox), which alter how elements inside the element they are set on are laid out.
- **Floats** — Applying a [`float`](https://developer.mozilla.org/en-US/docs/Web/CSS/float) value such as `left` can cause block level elements to wrap alongside one side of an element, like the way images sometimes have text floating around them in magazine layouts.
- **The [`position`](https://developer.mozilla.org/en-US/docs/Web/CSS/position) property** — Allows you to precisely control the placement of boxes inside other boxes. `static` positioning is the default in normal flow, but you can cause elements to be laid out differently using other values, for example always fixed to the top of the browser viewport.
- **Table layout** — features designed for styling the parts of an HTML table can be used on non-table elements using `display: table` and associated properties.
- **Multi-column layout** — The [Multi-column layout](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Columns) properties can cause the content of a block to layout in columns, as you might see in a newspaper.

## The display property

The main methods of achieving page layout in CSS are all values of the `display` property. This property allows us to change the default way something displays. Everything in normal flow has a value of `display`, used as the default way that elements they are set on behave. For example, the fact that paragraphs in English display one below the other is due to the fact that they are styled with `display: block`. If you create a link around some text inside a paragraph, that link remains inline with the rest of the text, and doesn’t break onto a new line. This is because the [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a) element is `display: inline` by default.

You can change this default display behavior. For example, the [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/li) element is `display: block` by default, meaning that list items display one below the other in our English document. If we change the display value to `inline` they now display next to each other, as words would do in a sentence. The fact that you can change the value of `display` for any element means that you can pick HTML elements for their semantic meaning, without being concerned about how they will look. The way they look is something that you can change.

In addition to being able to change the default presentation by turning an item from `block` to `inline` and vice versa, there are some bigger layout methods that start out as a value of `display`. However, when using these, you will generally need to invoke additional properties. The two values most important for our purposes when discussing layout are `display: flex` and `display: grid`.









# Normal Flow

This article explains normal flow, or the way that webpage elements lay themselves out if you have not changed their layout.

| Prerequisites: | The basics of HTML (study [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML)), and an idea of How CSS works (study [Introduction to CSS](https://developer.mozilla.org/en-US/docs/Learn/CSS/Introduction_to_CSS).) |
| :------------- | ------------------------------------------------------------ |
| Objective:     | To explain how browsers layout web pages by default, before we begin to make changes. |

As detailed in the last lesson introducing layout, elements on a webpage lay out in the normal flow, if you have not applied any CSS to change the way they behave. And, as we began to discover, you can change how elements behave either by adjusting their position in that normal flow, or removing them from it altogether. Starting with a solid, well-structured document that is readable in normal flow is the best way to begin any webpage. It ensures that your content is readable, even if the user is using a very limited browser or a device such as a screen reader that reads out the content of the page. In addition, as normal flow is designed to make a readable document, by starting in this way you are working with the document rather than fighting against it as you make changes to the layout.

Before digging deeper into different layout methods, it is worth revisiting some of the things you will have studied in previous modules with regard to normal document flow.











# Flexbox

[Flexbox](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Flexible_Box_Layout) is a one-dimensional layout method for laying out items in rows or columns. Items flex to fill additional space and shrink to fit into smaller spaces. This article explains all the fundamentals.

| Prerequisites: | HTML basics (study [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML)), and an idea of how CSS works (study [Introduction to CSS](https://developer.mozilla.org/en-US/docs/Learn/CSS/Introduction_to_CSS).) |
| :------------- | ------------------------------------------------------------ |
| Objective:     | To learn how to use the Flexbox layout system to create web layouts. |



## Why Flexbox?

For a long time, the only reliable cross browser-compatible tools available for creating CSS layouts were things like [floats](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Floats) and [positioning](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Positioning). These are fine, and they work, but in some ways they are also rather limiting and frustrating.

The following simple layout requirements are either difficult or impossible to achieve with such tools, in any kind of convenient, flexible way:

- Vertically centering a block of content inside its parent.
- Making all the children of a container take up an equal amount of the available width/height, regardless of how much width/height is available.
- Making all columns in a multiple-column layout adopt the same height even if they contain a different amount of content.

As you'll see in subsequent sections, flexbox makes a lot of layout tasks much easier. Let's dig in!

## Introducing a simple example

In this article we are going to get you to work through a series of exercises to help you understand how flexbox works. To get started, you should make a local copy of the first starter file — [flexbox0.html](https://github.com/mdn/learning-area/blob/master/css/css-layout/flexbox/flexbox0.html) from our github repo — load it in a modern browser (like Firefox or Chrome), and have a look at the code in your code editor. You can also [see it live here](http://mdn.github.io/learning-area/css/css-layout/flexbox/flexbox0.html).

You'll see that we have a [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/header) element with a top level heading inside it, and a [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/section) element containing three [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article)s. We are going to use these to create a fairly standard three column layout.

![img](https://mdn.mozillademos.org/files/13406/flexbox-example1.png)



So, this single declaration gives us everything we need — incredible, right? We have our multiple column layout with equal-sized columns, and the columns are all the same height. This is because the default values given to flex items (the children of the flex container) are set up to solve common problems such as this.

To be clear, let's reiterate what is happening here. The element we've given a  [`display`](https://developer.mozilla.org/en-US/docs/Web/CSS/display) value of `flex` to is acting like a block-level element in terms of how it interacts with the rest of the page, but its children are being laid out as flex items. The next section will explain in more detail what this means. Note also that you can use a `display` value of `inline-flex` if you wish to lay out an element's children as flex items, but have that element behave like an inline element.

## The flex model

When elements are laid out as flex items, they are laid out along two axes:

![flex_terms.png](https://developer.mozilla.org/files/3739/flex_terms.png)

- The **main axis** is the axis running in the direction the flex items are being laid out in (e.g. as rows across the page, or columns down the page.) The start and end of this axis are called the **main start** and **main end**.
- The **cross axis** is the axis running perpendicular to the direction the flex items are being laid out in. The start and end of this axis are called the **cross start** and **cross end**.
- The parent element that has `display: flex` set on it (the [`<section>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/section) in our example) is called the **flex container**.
- The items being laid out as flexible boxes inside the flex container are called **flex items** (the [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article) elements in our example).

Bear this terminology in mind as you go through subsequent sections. You can always refer back to it if you get confused about any of the terms being used.

## Columns or rows?

Flexbox provides a property called [`flex-direction`](https://developer.mozilla.org/en-US/docs/Web/CSS/flex-direction) that specifies what direction the main axis runs in (what direction the flexbox children are laid out in) — by default this is set to `row`, which causes them to be laid out in a row in the direction your browser's default language works in (left to right, in the case of an English browser).

Try adding the following declaration to your [`<section>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/section) rule:

```css
flex-direction: column;
```

You'll see that this puts the items back in a column layout, much like they were before we added any CSS. Before you move on, delete this declaration from your example.

> **Note**: You can also lay out flex items in a reverse direction using the `row-reverse` and `column-reverse` values. Experiment with these values too!

## Wrapping

One issue that arises when you have a fixed amount of width or height in your layout is that eventually your flexbox children will overflow their container, breaking the layout. Have a look at our [flexbox-wrap0.html](https://github.com/mdn/learning-area/blob/master/css/css-layout/flexbox/flexbox-wrap0.html) example, and try [viewing it live](http://mdn.github.io/learning-area/css/css-layout/flexbox/flexbox-wrap0.html) (take a local copy of this file now if you want to follow along with this example):

![img](https://mdn.mozillademos.org/files/13410/flexbox-example3.png)

Here we see that the children are indeed breaking out of their container. One way in which you can fix this is to add the following declaration to your [`<section>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/section) rule:

```css
flex-wrap: wrap;
```

Also, add the following declaration to your [`<article>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article) rule:

```css
flex: 200px;
```

Try this now; you'll see that the layout looks much better with this included:

![img](https://mdn.mozillademos.org/files/13412/flexbox-example4.png)We now have multiple rows — as many flexbox children are fitted onto each row as makes sense, and any overflow is moved down to the next line. The `flex: 200px` declaration set on the articles means that each will be at least 200px wide. We'll discuss this property in more detail later on. You might also notice that the last few children on the last row are each made wider so that the entire row is still filled.

But there's more we can do here. First of all, try changing your [`flex-direction`](https://developer.mozilla.org/en-US/docs/Web/CSS/flex-direction) property value to `row-reverse` — now you'll see that you still have your multiple row layout, but it starts from the opposite corner of the browser window and flows in reverse.

## flex-flow shorthand

At this point it is worth noting that a shorthand exists for [`flex-direction`](https://developer.mozilla.org/en-US/docs/Web/CSS/flex-direction) and [`flex-wrap`](https://developer.mozilla.org/en-US/docs/Web/CSS/flex-wrap) — [`flex-flow`](https://developer.mozilla.org/en-US/docs/Web/CSS/flex-flow). So for example, you can replace

```css
flex-direction: row;
flex-wrap: wrap;
```

with

```css
flex-flow: row wrap;
```

## Flexible sizing of flex items

Let's now return to our first example, and look at how we can control what proportion of space flex items take up compared to the other flex items. Fire up your local copy of [flexbox0.html](https://github.com/mdn/learning-area/blob/master/css/css-layout/flexbox/flexbox0.html), or take a copy of [flexbox1.html](https://github.com/mdn/learning-area/blob/master/css/css-layout/flexbox/flexbox1.html) as a new starting point ([see it live](http://mdn.github.io/learning-area/css/css-layout/flexbox/flexbox1.html)).

First, add the following rule to the bottom of your CSS:

```css
article {
  flex: 1;
}
```

This is a unitless proportion value that dictates how much of the available space along the main axis each flex item will take up compared to other flex items. In this case, we are giving each [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article) element the same value (a value of 1), which means they will all take up an equal amount of the spare space left after things like padding and margin have been set. It is relative to other flex items, meaning that giving each flex item a value of 400000 would have exactly the same effect.

Now add the following rule below the previous one:

```css
article:nth-of-type(3) {
  flex: 2;
}
```

Now when you refresh, you'll see that the third [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article) takes up twice as much of the available width as the other two. There are now four proportion units available in total (since 1 + 1 + 2 = 4). The first two flex items have one unit each, so they take 1/4 of the available space each. The third one has two units, so it takes up 2/4 of the available space (or one-half).

You can also specify a minimum size value inside the flex value. Try updating your existing article rules like so:

```css
article {
  flex: 1 200px;
}

article:nth-of-type(3) {
  flex: 2 200px;
}
```

This basically states "Each flex item will first be given 200px of the available space. After that, the rest of the available space will be shared out according to the proportion units." Try refreshing and you'll see a difference in how the space is shared.

![img](https://mdn.mozillademos.org/files/13406/flexbox-example1.png)

The real value of flexbox can be seen in its flexibility/responsiveness — if you resize the browser window, or add another [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article) element, the layout continues to work just fine.



## flex: shorthand versus longhand

[`flex`](https://developer.mozilla.org/en-US/docs/Web/CSS/flex) is a shorthand property that can specify up to three different values:

- The unitless proportion value we discussed above. This can be specified individually using the [`flex-grow`](https://developer.mozilla.org/en-US/docs/Web/CSS/flex-grow) longhand property.
- A second unitless proportion value — [`flex-shrink`](https://developer.mozilla.org/en-US/docs/Web/CSS/flex-shrink) — that comes into play when the flex items are overflowing their container. This specifies how much of the overflowing amount is taken away from each flex item's size, to stop them overflowing their container. This is quite an advanced flexbox feature, and we won't be covering it any further in this article.
- The minimum size value we discussed above. This can be specified individually using the [`flex-basis`](https://developer.mozilla.org/en-US/docs/Web/CSS/flex-basis) longhand value.

We'd advise against using the longhand flex properties unless you really have to (for example, to override something previously set). They lead to a lot of extra code being written, and they can be somewhat confusing.

## Horizontal and vertical alignment

You can also use flexbox features to align flex items along the main or cross axis. Let's explore this by looking at a new example — [flex-align0.html](https://github.com/mdn/learning-area/blob/master/css/css-layout/flexbox/flex-align0.html) ([see it live also](http://mdn.github.io/learning-area/css/css-layout/flexbox/flex-align0.html)) — which we are going to turn into a neat, flexible button/toolbar. At the moment you'll see a horizontal menu bar, with some buttons jammed into the top left-hand corner.

![img](https://mdn.mozillademos.org/files/13414/flexbox-example5.png)

First, take a local copy of this example.

Now, add the following to the bottom of the example's CSS:

```css
div {
  display: flex;
  align-items: center;
  justify-content: space-around;
}
```

![img](https://mdn.mozillademos.org/files/17210/flexbox_center_space-around.png)

Refresh the page and you'll see that the buttons are now nicely centered, horizontally and vertically. We've done this via two new properties.

[`align-items`](https://developer.mozilla.org/en-US/docs/Web/CSS/align-items) controls where the flex items sit on the cross axis.

- By default, the value is `stretch`, which stretches all flex items to fill the parent in the direction of the cross axis. If the parent doesn't have a fixed width in the cross axis direction, then all flex items will become as long as the longest flex item. This is how our first example got equal height columns by default.
- The `center` value that we used in our above code causes the items to maintain their intrinsic dimensions, but be centered along the cross axis. This is why our current example's buttons are centered vertically.
- You can also have values like `flex-start` and `flex-end`, which will align all items at the start and end of the cross axis respectively. See [`align-items`](https://developer.mozilla.org/en-US/docs/Web/CSS/align-items) for the full details.

You can override the [`align-items`](https://developer.mozilla.org/en-US/docs/Web/CSS/align-items) behavior for individual flex items by applying the [`align-self`](https://developer.mozilla.org/en-US/docs/Web/CSS/align-self) property to them. For example, try adding the following to your CSS:

```css
button:first-child {
  align-self: flex-end;
}
```

![img](https://mdn.mozillademos.org/files/17211/flexbox_first-child_flex-end.png)

Have a look at what effect this has, and remove it again when you've finished.

[`justify-content`](https://developer.mozilla.org/en-US/docs/Web/CSS/justify-content) controls where the flex items sit on the main axis.

- The default value is `flex-start`, which makes all the items sit at the start of the main axis.
- You can use `flex-end` to make them sit at the end.
- `center` is also a value for `justify-content`, and will make the flex items sit in the center of the main axis.
- The value we've used above, `space-around`, is useful — it distributes all the items evenly along the main axis, with a bit of space left at either end.
- There is another value, `space-between`, which is very similar to `space-around` except that it doesn't leave any space at either end.

We'd like to encourage you to play with these values to see how they work before you continue.

## Ordering flex items

Flexbox also has a feature for changing the layout order of flex items, without affecting the source order. This is another thing that is impossible to do with traditional layout methods.

The code for this is simple; try adding the following CSS to your button bar example code:

```css
button:first-child {
  order: 1;
}
```

Refresh, and you'll now see that the "Smile" button has moved to the end of the main axis. Let's talk about how this works in a bit more detail:

- By default, all flex items have an [`order`](https://developer.mozilla.org/en-US/docs/Web/CSS/order) value of 0.
- Flex items with higher order values set on them will appear later in the display order than items with lower order values.
- Flex items with the same order value will appear in their source order. So if you have four items with order values of 2, 1, 1, and 0 set on them respectively, their display order would be 4th, 2nd, 3rd, then 1st.
- The 3rd item appears after the 2nd because it has the same order value and is after it in the source order.

You can set negative order values to make items appear earlier than items with 0 set. For example, you could make the "Blush" button appear at the start of the main axis using the following rule:

```css
button:last-child {
  order: -1;
}
```

## Nested flex boxes

It is possible to create some pretty complex layouts with flexbox. It is perfectly ok to set a flex item to also be a flex container, so that its children are also laid out like flexible boxes. Have a look at [complex-flexbox.html](https://github.com/mdn/learning-area/blob/master/css/css-layout/flexbox/complex-flexbox.html) ([see it live also](http://mdn.github.io/learning-area/css/css-layout/flexbox/complex-flexbox.html)).

![img](https://mdn.mozillademos.org/files/13418/flexbox-example7.png)

The HTML for this is fairly simple. We've got a [`<section>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/section) element containing three [`<article>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article)s. The third [`<article>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article) contains three [`<div>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/div) :

```html
section - article
          article
          article - div - button   
                    div   button
                    div   button
                          button
                          button
```

Let's look at the code we've used for the layout.

First of all, we set the children of the [`<section>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/section) to be laid out as flexible boxes.

```css
section {
  display: flex;
}
```

Next, we set some flex values on the [`<article>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article)sthemselves. Take special note of the 2nd rule here — we are setting the third [`<article>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article) to have its children laid out like flex items too, but this time we are laying them out like a column.

```css
article {
  flex: 1 200px;
}

article:nth-of-type(3) {
  flex: 3 200px;
  display: flex;
  flex-flow: column;
}
```

Next, we select the first [`<div>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/div). We first use `flex:1 100px;` to effectively give it a minimum height of 100px, then we set its children (the [`<button>`](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/button) elements) to also be laid out like flex items. Here we lay them out in a wrapping row, and align them in the center of the available space, as we did in the individual button example we saw earlier.

```css
article:nth-of-type(3) div:first-child {
  flex:1 100px;
  display: flex;
  flex-flow: row wrap;
  align-items: center;
  justify-content: space-around;
}
```

Finally, we set some sizing on the button, but more interestingly we give it a flex value of 1 auto. This has a very interesting effect, which you'll see if you try resizing your browser window width. The buttons will take up as much space as they can, and sit as many on the same line as they can, but when they can no longer fit comfortably on the same line, they'll drop down to create new lines.

```css
button {
  flex: 1 auto;
  margin: 5px;
  font-size: 18px;
  line-height: 1.5;
```

## Cross-browser compatibility

Flexbox support is available in most new browsers — Firefox, Chrome, Opera, Microsoft Edge, and IE 11, newer versions of Android/iOS, etc. However, you should be aware that there are still older browsers in use that don't support Flexbox (or do, but support a really old, out-of-date version of it.)

While you are just learning and experimenting, this doesn't matter too much; however, if you are considering using flexbox in a real website you need to do testing and make sure that your user experience is still acceptable in as many browsers as possible.

Flexbox is a bit trickier than some CSS features. For example, if a browser is missing a CSS drop shadow, then the site will likely still be usable. Not supporting flexbox features however will probably break a layout completely, making it unusable.

We discuss strategies for overcoming cross-browser support issues in our [Cross browser testing](https://developer.mozilla.org/en-US/docs/Learn/Tools_and_testing/Cross_browser_testing) module.

## Test your skills!

We have covered a lot in this article, but can you remember the most important information? You can find some further tests to verify that you've retained this information before you move on — see [Test your skills: Flexbox](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Flexbox_skills).

## Summary

That concludes our tour of the basics of flexbox. We hope you had fun, and will have a good play around with it as you travel forward with your learning. Next, we'll have a look at another important aspect of CSS layouts — CSS Grids.



# Beginner's guide to media queries

The **CSS Media Query** gives you a way to apply CSS only when the browser and device environment matches a rule that you specify, for example "viewport is wider than 480 pixels". Media queries are a key part of responsive web design, as they allow you to create different layouts depending on the size of the viewport, but they can also be used to detect other things about the environment your site is running on, for example whether the user is using a touchscreen rather than a mouse. In this lesson you will first learn about the syntax used in media queries, and then move on to use them in a worked example showing how a simple design might be made responsive.

| Prerequisites: | HTML basics (study [Introduction to HTML](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML)), and an idea of how CSS works (study [CSS first steps](https://developer.mozilla.org/en-US/docs/Learn/CSS/First_steps) and [CSS building blocks](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks).) |
| :------------- | ------------------------------------------------------------ |
| Objective:     | To understand how to use media queries, and the most common approach for using them to create responsive designs. |

## Media Query Basics

The simplest media query syntax looks like this:

```
@media media-type and (media-feature-rule) {
  /* CSS rules go here */
}
```

It consists of:

- A media type, which tells the browser what kind of media this code is for (e.g. print, or screen).
- A media expression, which is a rule, or test that must be passed for the contained CSS to be applied.
- A set of CSS rules that will be applied if the test passes and the media type is correct.

### Media types



The possible types of media you can specify are:

- `all`
- `print`
- `screen`
- `speech`

The following media query will only set the body to 12pt if the page is printed. It will not apply when the page is loaded in a browser.

```
@media print {
    body {
        font-size: 12pt;
    }
}
```

> **Note**: the media type here is different from the so-called [MIME type](https://developer.mozilla.org/en-US/docs/Glossary/MIME_type).
>
> **Note**: there were a number of other media types defined in the Level 3 Media Queries specification; these have been deprecated and should be avoided.
>
> **Note**: Media types are optional; if you do not indicate a media type in your media query then the media query will default to being for all media types.



### Media feature rules

After specifying the type, you can then target a media feature with a rule.

#### Width and height

The feature we tend to detect most often in order to create responsive designs (and that has widespread browser support) is viewport width, and we can apply CSS if the viewport is above or below a certain width — or an exact width — using the `min-width`, `max-width`, and `width` media features.

These features are used to create layouts that respond to different screen sizes. For example, to change the body text color to red if the viewport is exactly 600 pixels, you would use the following media query.

```
@media screen and (width: 600px) {
    body {
        color: red;
    }
}
```

[Open this example](https://mdn.github.io/css-examples/learn/media-queries/width.html) in the browser, or [view the source](https://github.com/mdn/css-examples/blob/master/learn/media-queries/width.html).

The `width` (and `height`) media features can be used as ranges, and therefore be prefixed with `min-` or `max-` to indicate that the given value is a minimum, or a maximum. For example, to make the color blue if the viewport is narrower than 600 pixels, use `max-width`:

```
@media screen and (max-width: 600px) {
    body {
        color: blue;
    }
}
```

[Open this example](https://mdn.github.io/css-examples/learn/media-queries/max-width.html) in the browser, or [view the source](https://github.com/mdn/css-examples/blob/master/learn/media-queries/max-width.html).

In practice, using minimum or maximum values is much more useful for responsive design so you will rarely see `width` or `height` used alone.

There are a number of other media features that you can test for, although some of the newer features introduced in Level 4 and 5 of the media queries specification have limited browser support. Each feature is documented on MDN along with browser support information, and you can find a full list at [Using Media Queries: Media Features](https://developer.mozilla.org/en-US/docs/Web/CSS/Media_Queries/Using_media_queries#Media_features).

#### Orientation

One well-supported media feature is `orientation`, which allows us to test for portrait or landscape mode. To change the body text color if the device is in landscape orientation, use the following media query.

```
@media (orientation: landscape) {
    body {
        color: rebeccapurple;
    }
}
```

[Open this example](https://mdn.github.io/css-examples/learn/media-queries/orientation.html) in the browser, or [view the source](https://github.com/mdn/css-examples/blob/master/learn/media-queries/orientation.html).

A standard desktop view has a landscape orientation, and a design that works well in this orientation may not work as well when viewed on a phone or tablet in portrait mode. Testing for orientation can help you to create a layout which is optimised for devices in portrait mode.

#### Use of pointing devices

As part of the Level 4 specification, the `hover` media feature was introduced. This feature means you can test if the user has the ability to hover over an element, which essentially means they are using some kind of pointing device; touchscreen and keyboard navigation does not hover.

```
@media (hover: hover) {
    body {
        color: rebeccapurple;
    }
}
```

[Open this example](https://mdn.github.io/css-examples/learn/media-queries/hover.html) in the browser, or [view the source](https://github.com/mdn/css-examples/blob/master/learn/media-queries/hover.html).

If we know the user cannot hover, we could display some interactive features by default. For users who can hover, we might choose to make them available when a link is hovered over.

Also in Level 4 is the `pointer` media feature. This takes three possible values, `none`, `fine` and `coarse`. A `fine` pointer is something like a mouse or trackpad. It enables the user to precisely target a small area. A `coarse` pointer is your finger on a touchscreen. The value `none` means the user has no pointing device; perhaps they are navigating with the keyboard only or with voice commands.

Using `pointer` can help you to design better interfaces that respond to the type of interaction a user is having with a screen. For example, you could create larger hit areas if you know that the user is interacting with the device as a touchscreen.



# <!--Reference-->

# CSS selectors reference

## Basic selectors

- [Universal selector](https://developer.mozilla.org/en-US/docs/Web/CSS/Universal_selectors)

  Selects all elements. Optionally, it may be restricted to a specific namespace or to all namespaces. **Syntax:** `*` `ns|*` `*|*` **Example:** `*` will match all the elements of the document.

- [Type selector](https://developer.mozilla.org/en-US/docs/Web/CSS/Type_selectors)

  Selects all elements that have the given node name. **Syntax:** `elementname` **Example:** `input` will match any [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input) element.

- [Class selector](https://developer.mozilla.org/en-US/docs/Web/CSS/Class_selectors)

  Selects all elements that have the given `class` attribute. **Syntax:** `.classname` **Example:** `.index` will match any element that has a class of "index".

- [ID selector](https://developer.mozilla.org/en-US/docs/Web/CSS/ID_selectors)

  Selects an element based on the value of its `id` attribute. There should be only one element with a given ID in a document. **Syntax:** `#idname` **Example:** `#toc` will match the element that has the ID "toc".

- [Attribute selector](https://developer.mozilla.org/en-US/docs/Web/CSS/Attribute_selectors)

  Selects all elements that have the given attribute. **Syntax:** `[attr]` `[attr=value]` `[attr~=value]` `[attr|=value]` `[attr^=value]` `[attr$=value]` `[attr*=value]` **Example:** `[autoplay]` will match all elements that have the `autoplay` attribute set (to any value).

## Grouping selectors

- [Selector list](https://developer.mozilla.org/en-US/docs/Web/CSS/Selector_list)

  The `,` is a grouping method, it selects all the matching nodes. **Syntax:** `A, B` **Example:** `div, span` will match both [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/span) and [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/div) elements.

## Combinators

- [Descendant combinator](https://developer.mozilla.org/en-US/docs/Web/CSS/Descendant_combinator)

  The ` ` (space) combinator selects nodes that are descendants of the first element. **Syntax:** `A B` **Example:** `div span` will match all [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/span) elements that are inside a [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/div) element.

- [Child combinator](https://developer.mozilla.org/en-US/docs/Web/CSS/Child_combinator)

  The `>` combinator selects nodes that are direct children of the first element. **Syntax:** `A > B` **Example:** `ul > li` will match all [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/li) elements that are nested directly inside a [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/ul) element.

- [General sibling combinator](https://developer.mozilla.org/en-US/docs/Web/CSS/General_sibling_combinator)

  The `~` combinator selects siblings. This means that the second element follows the first (though not necessarily immediately), and both share the same parent. **Syntax:** `A ~ B` **Example:** `p ~ span` will match all [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/span) elements that follow a [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/p), immediately or not.

- [Adjacent sibling combinator](https://developer.mozilla.org/en-US/docs/Web/CSS/Adjacent_sibling_combinator)

  The `+` combinator selects adjacent siblings. This means that the second element directly follows the first, and both share the same parent. **Syntax:** `A + B` **Example:** `h2 + p` will match all [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/p) elements that directly follow an [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/h2).

- [Column combinator](https://developer.mozilla.org/en-US/docs/Web/CSS/Column_combinator) 

  The `||` combinator selects nodes which belong to a column. **Syntax:** `A || B` **Example:** `col || td` will match all `](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/td) elements that belong to the scope of the .

## Pseudo

- [Pseudo classes](https://developer.mozilla.org/en-US/docs/Web/CSS/Pseudo-classes)

  The `:` pseudo allow the selection of elements based on state information that is not contained in the document tree. **Example:** `a:visited` will match all [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a) elements that have been visited by the user.

- [Pseudo elements](https://developer.mozilla.org/en-US/docs/Web/CSS/Pseudo-elements)

  The `::` pseudo represent entities that are not included in HTML. **Example:** `p::first-line` will match the first line of all [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/p) elements.

## Specifications

| Specification                                                | Status         | Comment                                                      |
| :----------------------------------------------------------- | :------------- | :----------------------------------------------------------- |
| [Selectors Level 4](https://drafts.csswg.org/selectors-4/)   | Working Draft  | Added the `||` column combinator, grid structural selectors, logical combinators, location, time-demensional, resource state, linguistic and UI pseudo-classes, modifier for ASCII case-sensitive and case-insensitive attribute value selection. |
| [Selectors Level 3](https://drafts.csswg.org/selectors-3/)   | Recommendation | Added the `~` general sibling combinator and tree-structural pseudo-classes. Made pseudo-elements use a `::` double-colon prefix. Additional attribute selectors |
| [CSS Level 2 (Revision 1)](https://www.w3.org/TR/CSS2/selector.html) | Recommendation | Added the `>` child and `+` adjacent sibling combinators. Added the **universal** and **attribute** selectors. |
| [CSS Level 1](https://www.w3.org/TR/CSS1/)                   | Recommendation | Initial definition.                                          |

See the [pseudo-class](https://developer.mozilla.org/en-US/docs/Web/CSS/Pseudo-classes#Specifications) and [pseudo-element](https://developer.mozilla.org/en-US/docs/Web/CSS/Pseudo-elements#Specifications) specification tables for details on those.



# CSS Basic Box Model

**CSS Basic Box Model** is a module of CSS that defines the rectangular boxes—including their padding and margin—that are generated for elements and laid out according to the [visual formatting model](https://developer.mozilla.org/en-US/docs/Web/CSS/Visual_formatting_model).

## Reference

### Properties

#### Properties controlling the flow of content in a box

- [`overflow`](https://developer.mozilla.org/en-US/docs/Web/CSS/overflow)
- [`overflow-x`](https://developer.mozilla.org/en-US/docs/Web/CSS/overflow-x)
- [`overflow-y`](https://developer.mozilla.org/en-US/docs/Web/CSS/overflow-y)

#### Properties controlling the size of a box

- [`height`](https://developer.mozilla.org/en-US/docs/Web/CSS/height)
- [`width`](https://developer.mozilla.org/en-US/docs/Web/CSS/width)
- [`max-height`](https://developer.mozilla.org/en-US/docs/Web/CSS/max-height)
- [`max-width`](https://developer.mozilla.org/en-US/docs/Web/CSS/max-width)
- [`min-height`](https://developer.mozilla.org/en-US/docs/Web/CSS/min-height)
- [`min-width`](https://developer.mozilla.org/en-US/docs/Web/CSS/min-width)

#### Properties controlling the margins of a box

- [`margin`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin)
- [`margin-bottom`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-bottom)
- [`margin-left`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-left)
- [`margin-right`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-right)
- [`margin-top`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-top)
- [`margin-trim`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-trim) 

#### Properties controlling the paddings of a box

- [`padding`](https://developer.mozilla.org/en-US/docs/Web/CSS/padding)
- [`padding-bottom`](https://developer.mozilla.org/en-US/docs/Web/CSS/padding-bottom)
- [`padding-left`](https://developer.mozilla.org/en-US/docs/Web/CSS/padding-left)
- [`padding-right`](https://developer.mozilla.org/en-US/docs/Web/CSS/padding-right)
- [`padding-top`](https://developer.mozilla.org/en-US/docs/Web/CSS/padding-top)

#### Other properties

- [`visibility`](https://developer.mozilla.org/en-US/docs/Web/CSS/visibility)

## Guides

- [Introduction to the CSS box model](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Box_Model/Introduction_to_the_CSS_box_model)

  Explains one of the fundamental concept of CSS: the box model. This model defines how CSS lays out elements, including their content, padding, border, and margin areas.

- [Mastering margin collapsing](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Box_Model/Mastering_margin_collapsing)

  Sometimes, two adjacent margins are collapsed into one. This article describes the rules that govern when and why this happens, and how to control it.

- [Visual formatting model](https://developer.mozilla.org/en-US/docs/Web/CSS/Visual_formatting_model)

  Explains the visual formatting model.

## Specifications

| Specification                                                | Status         | Comment             |
| :----------------------------------------------------------- | :------------- | :------------------ |
| [CSS Basic Box Model](https://drafts.csswg.org/css-box-3/)   | Working Draft  | Added `margin-trim` |
| [CSS Level 2 (Revision 1)](https://www.w3.org/TR/CSS2/box.html) | Recommendation |                     |
| [CSS Level 1](https://www.w3.org/TR/CSS1/)                   | Recommendation | Initial definition. |



# Introduction to the CSS basic box model

When laying out a document, the browser's rendering engine represents each element as a rectangular box according to the standard **CSS basic box model**. CSS determines the size, position, and properties (color, background, border size, etc.) of these boxes.

Every box is composed of four parts (or *areas*), defined by their respective edges: the *content edge*, *padding edge*, *border edge*, and *margin edge*.

![CSS Box model](https://mdn.mozillademos.org/files/8685/boxmodel-(3).png)

The **content area**, bounded by the content edge, contains the "real" content of the element, such as text, an image, or a video player. Its dimensions are the *content width* (or *content-box width*) and the *content height* (or *content-box height*). It often has a background color or background image.

If the [`box-sizing`](https://developer.mozilla.org/en-US/docs/Web/CSS/box-sizing) property is set to `content-box` (default) and if the element is a block element, the content area's size can be explicitly defined with the [`width`](https://developer.mozilla.org/en-US/docs/Web/CSS/width), [`min-width`](https://developer.mozilla.org/en-US/docs/Web/CSS/min-width), [`max-width`](https://developer.mozilla.org/en-US/docs/Web/CSS/max-width), [`height`](https://developer.mozilla.org/en-US/docs/Web/CSS/height), [`min-height`](https://developer.mozilla.org/en-US/docs/Web/CSS/min-height), and [`max-height`](https://developer.mozilla.org/en-US/docs/Web/CSS/max-height) properties.

The **padding area**, bounded by the padding edge, extends the content area to include the element's padding. Its dimensions are the *padding-box width* and the *padding-box height*.

The thickness of the padding is determined by the [`padding-top`](https://developer.mozilla.org/en-US/docs/Web/CSS/padding-top), [`padding-right`](https://developer.mozilla.org/en-US/docs/Web/CSS/padding-right), [`padding-bottom`](https://developer.mozilla.org/en-US/docs/Web/CSS/padding-bottom), [`padding-left`](https://developer.mozilla.org/en-US/docs/Web/CSS/padding-left), and shorthand [`padding`](https://developer.mozilla.org/en-US/docs/Web/CSS/padding) properties.

The **border area**, bounded by the border edge, extends the padding area to include the element's borders. Its dimensions are the *border-box width* and the *border-box height*.

The thickness of the borders are determined by the [`border-width`](https://developer.mozilla.org/en-US/docs/Web/CSS/border-width) and shorthand [`border`](https://developer.mozilla.org/en-US/docs/Web/CSS/border) properties. If the [`box-sizing`](https://developer.mozilla.org/en-US/docs/Web/CSS/box-sizing) property is set to `border-box`, the border area's size can be explicitly defined with the [`width`](https://developer.mozilla.org/en-US/docs/Web/CSS/width), [`min-width`](https://developer.mozilla.org/en-US/docs/Web/CSS/min-width), [`max-width`](https://developer.mozilla.org/en-US/docs/Web/CSS/max-width), [`height`](https://developer.mozilla.org/en-US/docs/Web/CSS/height), [`min-height`](https://developer.mozilla.org/en-US/docs/Web/CSS/min-height), and [`max-height`](https://developer.mozilla.org/en-US/docs/Web/CSS/max-height) properties. When there is a background ([`background-color`](https://developer.mozilla.org/en-US/docs/Web/CSS/background-color) or [`background-image`](https://developer.mozilla.org/en-US/docs/Web/CSS/background-image)) set on a box, it extends to the outer edge of the border (i.e. extends underneath the border in z-ordering). This default behavior can be altered with the [`background-clip`](https://developer.mozilla.org/en-US/docs/Web/CSS/background-clip) css property.

The **margin area**, bounded by the margin edge, extends the border area to include an empty area used to separate the element from its neighbors. Its dimensions are the *margin-box width* and the *margin-box height*.

The size of the margin area is determined by the [`margin-top`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-top), [`margin-right`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-right), [`margin-bottom`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-bottom), [`margin-left`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-left), and shorthand [`margin`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin) properties. When [margin collapsing](https://developer.mozilla.org/en/CSS/margin_collapsing) occurs, the margin area is not clearly defined since margins are shared between boxes.

Finally, note that for non-replaced inline elements, the amount of space taken up (the contribution to the height of the line) is determined by the [`line-height`](https://developer.mozilla.org/en-US/docs/Web/CSS/line-height) property, even though the borders and padding are still displayed around the content.

## See also

- [Layout and the containing block](https://developer.mozilla.org/en-US/docs/Web/CSS/Containing_block)
- [Introducing the CSS Cascade](https://developer.mozilla.org/en-US/docs/Web/CSS/Cascade)
- [Cascade and inheritance](https://developer.mozilla.org/en-US/docs/Learn/CSS/Introduction_to_CSS/Cascade_and_inheritance)

## Specification

| Specification                                                | Status         | Comment                                                     |
| :----------------------------------------------------------- | :------------- | :---------------------------------------------------------- |
| [CSS Basic Box Model](https://drafts.csswg.org/css-box-3/#intro) | Working Draft  |                                                             |
| [CSS Level 2 (Revision 1)](https://www.w3.org/TR/CSS2/box.html#box-dimensions) | Recommendation | Though more precisely worded, there is no practical change. |
| [CSS Level 1](https://www.w3.org/TR/CSS1/#formatting-model)  | Recommendation | Initial definition.                                         |

## See also

- CSS Key Concepts: [CSS syntax](https://developer.mozilla.org/en-US/docs/Web/CSS/Syntax), [at-rule](https://developer.mozilla.org/en-US/docs/Web/CSS/At-rule), [comments](https://developer.mozilla.org/en-US/docs/Web/CSS/Comments), [specificity](https://developer.mozilla.org/en-US/docs/Web/CSS/Specificity) and [inheritance](https://developer.mozilla.org/en-US/docs/Web/CSS/inheritance), the [box](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Box_Model/Introduction_to_the_CSS_box_model), [layout modes](https://developer.mozilla.org/en-US/docs/Web/CSS/Layout_mode) and [visual formatting models](https://developer.mozilla.org/en-US/docs/Web/Guide/CSS/Visual_formatting_model), and [margin collapsing](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Box_Model/Mastering_margin_collapsing), or the [initial](https://developer.mozilla.org/en-US/docs/Web/CSS/initial_value), [computed](https://developer.mozilla.org/en-US/docs/Web/CSS/computed_value), [resolved](https://developer.mozilla.org/en-US/docs/Web/CSS/resolved_value), [specified](https://developer.mozilla.org/en-US/docs/Web/CSS/specified_value), [used](https://developer.mozilla.org/en-US/docs/Web/CSS/used_value), and [actual](https://developer.mozilla.org/en-US/docs/Web/CSS/actual_value) values. Definitions of [value syntax](https://developer.mozilla.org/en-US/docs/Web/CSS/Value_definition_syntax), [shorthand properties](https://developer.mozilla.org/en-US/docs/Web/CSS/Shorthand_properties) and [replaced elements](https://developer.mozilla.org/en-US/docs/Web/CSS/Replaced_element).



# Mastering margin collapsing

The [top](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-top) and [bottom](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-bottom) margins of blocks are sometimes combined (collapsed) into a single margin whose size is the largest of the individual margins (or just one of them, if they are equal), a behavior known as **margin collapsing**. Note that the margins of [floating](https://developer.mozilla.org/en-US/docs/Web/CSS/float) and [absolutely positioned](https://developer.mozilla.org/en-US/docs/Web/CSS/position#absolute) elements never collapse.

Margin collapsing occurs in three basic cases:

- Adjacent siblings

  The margins of adjacent siblings are collapsed (except when the latter sibling needs to be [cleared](https://developer.mozilla.org/en-US/docs/Web/CSS/clear) past floats).

- No content separating parent and descendants

  If there is no border, padding, inline part, [block formatting context](https://developer.mozilla.org/en-US/docs/Web/Guide/CSS/Block_formatting_context) created, or *[clearance](https://developer.mozilla.org/en-US/docs/Web/CSS/clear)* to separate the [`margin-top`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-top) of a block from the [`margin-top`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-top) of one or more of its descendant blocks; or no border, padding, inline content, [`height`](https://developer.mozilla.org/en-US/docs/Web/CSS/height), [`min-height`](https://developer.mozilla.org/en-US/docs/Web/CSS/min-height), or [`max-height`](https://developer.mozilla.org/en-US/docs/Web/CSS/max-height) to separate the [`margin-bottom`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-bottom) of a block from the [`margin-bottom`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-bottom) of one or more of its descendant blocks, then those margins collapse. The collapsed margin ends up outside the parent.

- Empty blocks

  If there is no border, padding, inline content, [`height`](https://developer.mozilla.org/en-US/docs/Web/CSS/height), or [`min-height`](https://developer.mozilla.org/en-US/docs/Web/CSS/min-height) to separate a block's [`margin-top`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-top) from its [`margin-bottom`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-bottom), then its top and bottom margins collapse.

Some things to note:

- More complex margin collapsing (of more than two margins) occurs when the above cases are combined.
- These rules apply even to margins that are zero, so the margin of a descendant ends up outside its parent (according to the rules above) whether or not the parent's margin is zero.
- When negative margins are involved, the size of the collapsed margin is the sum of the largest positive margin and the smallest (most negative) negative margin.
- When all margins are negative, the size of the collapsed margin is the smallest (most negative) margin. This applies to both adjacent elements and nested elements.

## Examples

### HTML



```html
<p>The bottom margin of this paragraph is collapsed …</p>
<p>… with the top margin of this paragraph, yielding a margin of <code>1.2rem</code> in between.</p>

<div>This parent element contains two paragraphs!
  <p>This paragraph has a <code>.4rem</code> margin between it and the text above.</p>
  <p>My bottom margin collapses with my parent, yielding a bottom margin of <code>2rem</code>.</p>
</div>

<p>I am <code>2rem</code> below the element above.</p>
```

### CSS



```css
div {
  margin: 2rem 0;
  background: lavender;
}

p {
  margin: .4rem 0 1.2rem 0;
  background: yellow;
}
```

### Result





## Specifications

| Specification                                                | Status         | Comment             |
| :----------------------------------------------------------- | :------------- | :------------------ |
| [CSS Level 2 (Revision 1) The definition of 'margin collapsing' in that specification.](https://www.w3.org/TR/CSS2/box.html#collapsing-margins) | Recommendation | Initial definition. |

## See also

- CSS Key Concepts: [CSS syntax](https://developer.mozilla.org/en-US/docs/Web/CSS/Syntax), [at-rule](https://developer.mozilla.org/en-US/docs/Web/CSS/At-rule), [comments](https://developer.mozilla.org/en-US/docs/Web/CSS/Comments), [specificity](https://developer.mozilla.org/en-US/docs/Web/CSS/Specificity) and [inheritance](https://developer.mozilla.org/en-US/docs/Web/CSS/inheritance), the [box](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Box_Model/Introduction_to_the_CSS_box_model), [layout modes](https://developer.mozilla.org/en-US/docs/Web/CSS/Layout_mode) and [visual formatting models](https://developer.mozilla.org/en-US/docs/Web/Guide/CSS/Visual_formatting_model), and [margin collapsing](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Box_Model/Mastering_margin_collapsing), or the [initial](https://developer.mozilla.org/en-US/docs/Web/CSS/initial_value), [computed](https://developer.mozilla.org/en-US/docs/Web/CSS/computed_value), [resolved](https://developer.mozilla.org/en-US/docs/Web/CSS/resolved_value), [specified](https://developer.mozilla.org/en-US/docs/Web/CSS/specified_value), [used](https://developer.mozilla.org/en-US/docs/Web/CSS/used_value), and [actual](https://developer.mozilla.org/en-US/docs/Web/CSS/actual_value) values. Definitions of [value syntax](https://developer.mozilla.org/en-US/docs/Web/CSS/Value_definition_syntax), [shorthand properties](https://developer.mozilla.org/en-US/docs/Web/CSS/Shorthand_properties) and [replaced elements](https://developer.mozilla.org/en-US/docs/Web/CSS/Replaced_element).



# Layout mode

A [CSS](https://developer.mozilla.org/en-US/docs/Web/CSS) **layout mode**, sometimes simply called *layout*, is an algorithm that determines the position and size of boxes based on the way they interact with their sibling and ancestor boxes. There are several of them:

- *[Normal flow](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Flow_Layout)* — all elements are part of normal flow until you do something to take them out of it. Normal flow includes *block layout*, designed for laying out boxes such as paragraphs and *inline layout*, which lays out inline items such as text.

- [*Table layout*](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Table), designed for laying out tables.

- *Float layout*, designed to cause an item to position itself left or right with the rest of the content in normal flow wrapping around it.

- [*Positioned layout*](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Positioning), designed for positioning elements without much interaction with other elements.

- [*Multi-column layout*](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Columns), designed for laying content out in columns as in a newspaper.

- [*Flexible box layout*](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Flexible_Box_Layout), designed for laying out complex pages that can be resized smoothly.

- [*Grid layout*](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Grid_Layout), designed for laying out elements relative to a fixed grid.

  > **Note:** Not all [CSS properties](https://developer.mozilla.org/en-US/docs/Web/CSS/Reference) apply to all *layout modes*. Most of them apply to one or two of them and have no effect if they are set on an element participating in another layout mode.

## See also

- CSS Key Concepts: [CSS syntax](https://developer.mozilla.org/en-US/docs/Web/CSS/Syntax), [at-rule](https://developer.mozilla.org/en-US/docs/Web/CSS/At-rule), [comments](https://developer.mozilla.org/en-US/docs/Web/CSS/Comments), [specificity](https://developer.mozilla.org/en-US/docs/Web/CSS/Specificity) and [inheritance](https://developer.mozilla.org/en-US/docs/Web/CSS/inheritance), the [box](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Box_Model/Introduction_to_the_CSS_box_model), [layout modes](https://developer.mozilla.org/en-US/docs/Web/CSS/Layout_mode) and [visual formatting models](https://developer.mozilla.org/en-US/docs/Web/Guide/CSS/Visual_formatting_model), and [margin collapsing](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Box_Model/Mastering_margin_collapsing), or the [initial](https://developer.mozilla.org/en-US/docs/Web/CSS/initial_value), [computed](https://developer.mozilla.org/en-US/docs/Web/CSS/computed_value), [resolved](https://developer.mozilla.org/en-US/docs/Web/CSS/resolved_value), [specified](https://developer.mozilla.org/en-US/docs/Web/CSS/specified_value), [used](https://developer.mozilla.org/en-US/docs/Web/CSS/used_value), and [actual](https://developer.mozilla.org/en-US/docs/Web/CSS/actual_value) values. Definitions of [value syntax](https://developer.mozilla.org/en-US/docs/Web/CSS/Value_definition_syntax), [shorthand properties](https://developer.mozilla.org/en-US/docs/Web/CSS/Shorthand_properties) and [replaced elements](https://developer.mozilla.org/en-US/docs/Web/CSS/Replaced_element).



# Mastering margin collapsing

The [top](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-top) and [bottom](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-bottom) margins of blocks are sometimes combined (collapsed) into a single margin whose size is the largest of the individual margins (or just one of them, if they are equal), a behavior known as **margin collapsing**. Note that the margins of [floating](https://developer.mozilla.org/en-US/docs/Web/CSS/float) and [absolutely positioned](https://developer.mozilla.org/en-US/docs/Web/CSS/position#absolute) elements never collapse.

Margin collapsing occurs in three basic cases:

- **Adjacent siblings**

  The margins of adjacent siblings are collapsed (except when the latter sibling needs to be [cleared](https://developer.mozilla.org/en-US/docs/Web/CSS/clear) past floats).

- **No content separating parent and descendants**

  If there is no border, padding, inline part, [block formatting context](https://developer.mozilla.org/en-US/docs/Web/Guide/CSS/Block_formatting_context) created, or *[clearance](https://developer.mozilla.org/en-US/docs/Web/CSS/clear)* to separate the [`margin-top`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-top) of a block from the [`margin-top`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-top) of one or more of its descendant blocks; or no border, padding, inline content, [`height`](https://developer.mozilla.org/en-US/docs/Web/CSS/height), [`min-height`](https://developer.mozilla.org/en-US/docs/Web/CSS/min-height), or [`max-height`](https://developer.mozilla.org/en-US/docs/Web/CSS/max-height) to separate the [`margin-bottom`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-bottom) of a block from the [`margin-bottom`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-bottom) of one or more of its descendant blocks, then those margins collapse. The collapsed margin ends up outside the parent.

- **Empty blocks**

  If there is no border, padding, inline content, [`height`](https://developer.mozilla.org/en-US/docs/Web/CSS/height), or [`min-height`](https://developer.mozilla.org/en-US/docs/Web/CSS/min-height) to separate a block's [`margin-top`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-top) from its [`margin-bottom`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin-bottom), then its top and bottom margins collapse.

Some things to note:

- More complex margin collapsing (of more than two margins) occurs when the above cases are combined.
- These rules apply even to margins that are zero, so the margin of a descendant ends up outside its parent (according to the rules above) whether or not the parent's margin is zero.
- When negative margins are involved, the size of the collapsed margin is the sum of the largest positive margin and the smallest (most negative) negative margin.
- When all margins are negative, the size of the collapsed margin is the smallest (most negative) margin. This applies to both adjacent elements and nested elements.



# CSS Flow Layout

*Normal Flow*, or Flow Layout, is the way that Block and Inline elements are displayed on a page before any changes are made to their layout. The flow is essentially a set of things that are all working together and know about each other in your layout. Once something is taken *out of flow* it works independently.

In normal flow, **inline** elements display in the inline direction, that is in the direction words are displayed in a sentence according to the [Writing Mode](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Writing_Modes) of the document. **Block** elements display one after the other, as paragraphs do in the Writing Mode of that document. In English therefore, inline elements display one after the other, starting on the left, and block elements start at the top and move down the page.

## Basic Example

The following example demonstrates Block and Inline Level boxes. The two paragraph elements with a green border are Block Level, displaying one under the other.

The first sentence also includes a span element with a blue background. This is inline level and therefore displays in place in the sentence.



## Guides

- [Block and Inline Layout in Normal Flow](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Flow_Layout/Block_and_Inline_Layout_in_Normal_Flow)
- [In Flow and Out of Flow](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Flow_Layout/In_Flow_and_Out_of_Flow)
- [Formatting Contexts Explained](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Flow_Layout/Formatting_Contexts_Explained)
- [Flow Layout and Writing Modes](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Flow_Layout/Flow_Layout_and_Writing_Modes)
- [Flow Layout and Overflow](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Flow_Layout/Flow_Layout_and_Overflow)

## Reference

### Glossary Entries

- [Block (CSS)](https://developer.mozilla.org/en-US/docs/Glossary/Block/CSS)

#### Metadata

 

# Block and inline layout in normal flow

In this guide, we will explore the basics of how Block and Inline elements behave when they are part of the normal flow.

Normal Flow is defined in the [CSS 2.1 specification](https://www.w3.org/TR/CSS2/visuren.html#normal-flow), which explains that any boxes in normal flow will be part of a *formatting context*. They can be either block or inline, but not both at once. We describe block-level boxes as participating in a *block formatting context*, and inline-level boxes as participating in an *inline formatting context*.

The behaviour of elements which have a block or inline formatting context is also defined in this specification. For elements with a block formatting context, the spec says:

> “In a block formatting context, boxes are laid out one after the other, vertically, beginning at the top of a containing block. The vertical distance between two sibling boxes is determined by the 'margin' properties. Vertical margins between adjacent block-level boxes in a block formatting context collapse.
>
> In a block formatting context, each box's left outer edge touches the left edge of the containing block (for right-to-left formatting, right edges touch).” - 9.4.1

For elements with an inline formatting context:

> “In an inline formatting context, boxes are laid out horizontally, one after the other, beginning at the top of a containing block. Horizontal margins, borders, and padding are respected between these boxes. The boxes may be aligned vertically in different ways: their bottoms or tops may be aligned, or the baselines of text within them may be aligned. The rectangular area that contains the boxes that form a line is called a line box.” - 9.4.2

Note that the CSS 2.1 specification describes documents as being in a horizontal, top to bottom writing mode. For example, by describing vertical distance between block boxes. The behavior on block and inline elements is the same when working in a vertical writing mode, and we will explore this in a future guide on Flow Layout and Writing Modes.

## Elements participating in a block formatting context

Block elements in a horizontal writing mode such as English, layout vertically, one below the other.

![img](https://mdn.mozillademos.org/files/16125/mdn-horizontal.png)

In a vertical writing mode then would lay out horizontally.

![img](https://mdn.mozillademos.org/files/16126/mdn-vertical.png)

In this guide, we will be working in English and therefore a horizontal writing mode. However, everything described should work in the same way if your document is in a vertical writing mode.

As defined in the specification, the margins between two block boxes are what creates separation between the elements. We see this with a very simple layout of two paragraphs, to which I have added a border. The default browser stylesheet adds spacing between the paragraphs by way of adding a margin to the top and bottom.



If we set margins on the paragraph element to `0` then the borders will touch.



By default block elements will consume all of the space in the inline direction, so our paragraphs spread out and get as big as they can inside their containing block. If we give them a width, they will continue to lay out one below the other - even if there would be space for them to be side by side. Each will start against the start edge of the containing block, so the place at which sentences would begin in that writing mode.



### Margin collapsing



The spec explains that margins between block elements *collapse*. This means that if you have an element with a top margin immediately after an element with a bottom margin, rather than the total space being the sum of these two margins, the margin collapses, and so will essentially become as large as the larger of the two margins.

In the example below, the paragraphs have a top margin of `20px` and a bottom margin of `40px`. The size of the margin between the paragraphs is `40px` as the smaller top margin on the second paragraph has collapsed with the larger bottom margin of the first.



You can read more about margin collapsing in our article [Mastering Margin Collapsing](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Box_Model/Mastering_margin_collapsing).

Note: if you are not sure whether margins are collapsing, check the Box Model values in your browser DevTools. This will give you the actual size of the margin which can help you to identify what is happening.

![img](https://mdn.mozillademos.org/files/16124/box-model.png)

## Elements participating in an inline formatting context

Inline elements display one after the other in the direction that sentences run in that particular writing mode. While we don’t tend to think of inline elements as having a box, as with everything in CSS they do. These inline boxes are arranged one after the other. If there is not enough space in the containing block for all of the boxes a box can break onto a new line. The lines created are known as line boxes.

In the following example, we have three inline boxes created by a paragraph with a [``](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/strong) element inside it.