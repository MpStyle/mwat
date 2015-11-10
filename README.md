# mwat
## What's mwat?
mwat is a command line tool to perform an easy way to translate the HTML view for a web app.

## What?
I know, it isn't easy to understand and for me, it isn't easy to explain.
I restart with an example.

## Preamble
I like to develop web apps. The web technologies are very attractive, easy to understand and use.
I have found a boring point about these technologies: the translation.
There are a lot of js libraries to permit the translations, but i don't like them: they aren't intuitive (easy to use) and the result user experience isn't good (loading...).

## The example
My web project has this struccture:
- app
  - languages
    - it.json
  - output
  - views
    - index.html

In the laguanges folder there is the json file containing the traslations:
...
{
  "app_name": "mwat",
  "app_version": "0.1"
}
...

In the views folder there is the view to translate:
...
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title tr="app_name"></title>
</head>
<body>
    <div tr="app_version">
        <p>Hello World!</p>
    </div>
</body>
</html>
...

In the output folder, after the execution of the program, there will a sub-folder "it" containing the index.html translated.
