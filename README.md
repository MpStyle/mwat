# mwat
## What's mwat?
mwat (mobile web app translator) is a command line tool to perform an easy way to translate the HTML view for a web app.

## What?
I know, it isn't clear, let me try to explain with an example.

## Preamble
I like developing web apps. The web technologies are very attractive, easy to understand and to use.
A boring point about these technologies is the translation.
There are a lot of Javascript libraries to permit the translations, but I don't like them: they aren't intuitive (easy to use) and the user experience isn't good (loading...).

## The example
My web project has this structure:
- app
  - languages
    - it.json
  - output
  - views
    - index.html
- mwat.jar

In the laguanges folder there is the *json* file containing the translations:
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

In the output folder, after executing the program, there will be a sub-folder "*it*" containing the translated *index.html*.

As you can see, in the views/index.html file there are particular properties in some tags: "*tr*". These are our bookmarks. 
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

And that's all folks.

## Next improvements
- Translate JavaDoc in English.
- Create a Netbeans extension.
- Create a JetBrains extension.
- Add the jar in the Maven Central Repository.
