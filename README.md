# webdriverdemo
Just a very short demo of Selenium's WebDriver.

## prerequisites

* Java JDK >= 7 (See [Oracle JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or [OpenJDK](http://openjdk.java.net/))
* [Maven 3](http://maven.apache.org/)
* [Git](http://www.git-scm.com/)
* [Firefox](https://www.mozilla.org/en-US/firefox/new/)

**Note for Windows users:** The instructions in this README are run from a console. This program is called `cmd.exe`. 
The program code can best be seen by another editor than notepad, since all code will be displayed on one line. Use something like [Notepad++](https://notepad-plus-plus.org/),
[UltraEdit](http://www.ultraedit.com/), ... or use Wordpad. Also, forward slashes in file paths `/` are backward slashes `\` in Windows.

## Get the code

Open a console. On the command line, type:

	git clone https://github.com/ghsnd/webdriverdemo.git

Now there is a new directory `webdriverdemo`, which contains the project source. `cd` to that directory.

	cd webdriver

## Build

To compile the source:

Open a console, go to the `webdriverdemo` directory, and type:

	mvn compile

To make a runnable jar from the compiled code:

	mvn package

Now, a file `target/webdriverdemo-1.0-SNAPSHOT-jar-with-dependencies.jar` should be created.

## Run

Still in the console, in the `webdriverdemo` directory, type:

	java -jar target/webdriverdemo-1.0-SNAPSHOT-jar-with-dependencies.jar

This launches Firefox and navigates through the NMBS website <http://www.belgianrail.be>

## Hack

The code is in `webdriverdemo/src/main/java/be/ugent/mmlab/webdriver/Demo.java`. Change the code, build, run and enjoy! 