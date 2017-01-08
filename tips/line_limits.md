# Line Limits
## How to set line limits in various text editors

### General
- A simple way to see if you have any lines over 80 characters is to use `grep`.
- `grep` is a file searching tool available on UNIX systems. That means it 
already exists on any Mac, and also should be available on the newest Windows 
terminal.
- Run the following command, where `filename` is the file you want to test:
		
		grep '.\{81\}' filename

- For example, you might run:

		grep '.\{81\}' Tester.java

- Any lines that are over 80 characters will be displayed, so if you get 
nothing back, then you your file is good to go!


### Sublime Text
- Download [here](https://www.sublimetext.com/3)!
- Sublime is my favorite text editor. It's clean, simple, and you'll learn
to use the terminal for compiling and running your files.
- To see if any of your lines go over 80 characters, set a ruler.
- Go to `Preferences -> Settings` (or push `Command + comma` for OSX).
- Inside a file called `Preferences.sublime-settings -- User` you should see
two curly braces with some content in between them. For example:
	
		{
			"color_inactive_tabs": true,
			"font_size": 18,
			"tabs_small": true,
		}

- You also might just have a blank file.
- In either case, you want to add this snippet to your file:

		"rulers":
		[
			80
		],

- So you'll end up with something that looks like this:

		{
			"color_inactive_tabs": true,
			"font_size": 18,
			"rulers":
			[
				80
			],
			"tabs_small": true,
		}

- Now you will have a line displayed in your editor at 80 characters.
- If you get a error, check you have commas in the right places and braces 
surrounding everything.


### Eclipse
- [Eclipse](https://eclipse.org/downloads/) is an IDE, an Integrated Development
Environment. That means it 
includes a compiler, text editor, debugger, as well as other useful tools.
- You can also set a ruler in Eclipse.
- Go to `Preferences -> General -> Editors -> Text Editors`.
- Tick the box labled `Show print margin` and make sure the box below, 
`Print margin column` is set to `80`.
- Now you will have a ruler at 80 characters!
