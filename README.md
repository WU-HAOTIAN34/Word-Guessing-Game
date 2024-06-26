# Word-Guessing Game

![img](https://github.com/WU-HAOTIAN34/Word-Guessing-Game/blob/main/2024-05-14_222224.png)

* [Using Gradle](#using-gradle)
* [Tests & Style Checking](#tests-and-style-checking)
* [Running The Application](#running-the-application)
* [Cleaning Up](#cleaning-up)
* [Submitting](#submitting)

## Using Gradle

Everything you need to do in this assignment, aside from editing code, is
handled by the Gradle build system.  You can run Gradle from the command
line, or use it from within VS Code or IntelliJ IDE if you prefer (see below).

**You do not need to install Gradle yourself**, as we've included a
'Gradle wrapper' that will download a compatible version of the tool, along
with various library dependencies, if required.  **This will be very slow
the first time that it runs!**

You should run Gradle commands in the `cwk1` directory.  On Linux, macOS or
Windows Subsystem for Linux (WSL2), use `./gradlew`.  On Windows, use
`gradlew`. (The commands below assume the use of Linux, macOS or WSL2.)

**NOTE: if your PC is running anti-virus software, you should add an exclusion
for the `cwk1` directory to avoid potential problems with Gradle.**

### If Using Visual Studio Code

You can simplify the use of Gradle by installing the Gradle Tasks extension.
This will add a Gradle button to the side bar.  Clicking on this will
active a panel in which you can see and run the Gradle tasks for the
various projects.

### If Using IntelliJ IDEA

**Please use the most recent version of the IntelliJ, on your own PC.
We do not support the use of older versions for the coursework, and may
not be able to help you if you encounter problems.**

Use the *New Project* button to import `cwk1` as the project directory.
After the project has been imported, you should be able to use the Gradle
button on the right-hand edge of the IntelliJ window to active the Gradle
tool window.  From here you can access a hierarchical list of all the
supported Gradle tasks.  The list entries you will need to use for the
coursework are

    Tasks/verification/test
    Tasks/verification/style
    Tasks/application/run
    Tasks/application/runFixed

Note: once you've used one of these entries, IntelliJ will create a run
configuration for it, allowing you to rerun it in future in a more
convenient way.

## Tests and Style Checking

To run all the unit tests, recompiling code where necessary, do

    ./gradlew test

Test names and status (PASSED or FAILED) are listed in the terminal.
A **test report** is also generated in HTML, containing detailed information
about the tests and any failures that have occurred.  You can access this
by pointing your browser at `build/reports/tests/test/index.html`.
We suggest you keep this page open in a browser tab, refreshing it after
each test run, so that you always have full information available on test
results.

Note that Gradle won't normally rerun tests if they have all passed, unless
you've changed something in your code.  You can force it to recompile
everything and rerun the tests using

    ./gradlew test --rerun-tasks

To check coding style for all classes (apart from the tests), do

    ./gradlew style

If there are any style violations, you'll see a count reported in the
terminal window.  A full report on the violations can be viewed by pointing
your browser at `build/reports/checkstyle/main.html`.

**Treat this as a rough guide.** Note that style checking is not exhaustive,
and we may still penalise you on style grounds even if no violations are
reported here.  As with unit tests, Gradle normally won't rerun the style
check unless you change something in your code.

## Running The Application

The application should be run in a terminal window, configured with a dark
background.  If you are doing the coursework on Windows, note that the default
command window provided by `cmd.exe` is NOT suitable.  You should install the
Windows Terminal app from the Microsoft Store and use that instead.

You can run the application like this:

    ./gradlew run

This will run the program in the `Wordle` class that we have provided for
you.  Note that this won't work properly until you've implemented the `Game`
class fully, with both constructors and the `play()` and `save()` methods
defined.

This command runs the application without any command line arguments, and
the expected behaviour in this case is that today's Wordle puzzle will
be played.  If you've implemented the `save()` method properly then a
summary of the game will be written to `build/lastgame.txt`.  You can view
this in the terminal with

    cat build/lastgame.txt

(At the Windows command prompt, use `type build\lastgame.txt` instead.)

For more convenient testing, you can do this:

    ./gradlew runFixed

This runs the application under fixed conditions, providing a specific game
number as a command line argument.  You will see the game number and the
corresponding target word displayed in the terminal before the application
itself executes.

## Cleaning Up

To remove all files generated by the build process, use

    ./gradlew clean

## Submitting

Your coursework solution must be submitted to Minerva **and** must also be
visible as a series of commits in your GitLab repository.

To generate your Minerva submission, do this:

    ./gradlew submission

This will produce a Zip archive named `cwk1.zip`, containing everything that
you need to submit.  **You must then submit this manually to Minerva**, using
the link provided in the *Submit My Work* area.
