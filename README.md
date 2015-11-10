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
- mwat.jar

In the laguanges folder there is the *json* file containing the traslations:
```
{
  "app_name": "mwat",
  "app_version": "0.1"
}
```

In the views folder there is the *view* to translate:
```
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
```

In the output folder, after the execution of the program, there will a sub-folder "*it*" containing the *index.html* translated.

As you can see, in the views/index.html file there are particular property in some tag: "*tr*". These are our bookmark. 
The program will parse all the files in the *views* folder (not recursively yet), it will search for the *tr* properties and it will prepend in the tag the translation. After that, it will save the translated files in a *it* sub-folder of the *output* folder.

So, if we run the program in this way:
```
java mwat.jar -i app/views -l app/languages -o app/output
```
The structure project will be;
- app
  - languages
    - it.json
  - output
    - it
      - index.html
  - views
    - index.html
- mwat.jar

The content of the app/output/it/index.html will be:
```
<!doctype html>
<html lang="en">
 <head> 
  <meta charset="UTF-8"> 
  <title tr="app_name">mwat</title> 
 </head> 
 <body> 
  <div tr="app_version">
   0.1 
   <p>Hello World!</p> 
  </div>  
 </body>
</html>
```

And that's all folk.
