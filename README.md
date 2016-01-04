IntelliJ VDL plugin
-------------------

# Introduction

The IntelliJ VDL plugin provides [VDL] language support for IDEs based on
IntelliJ, including:

* [IDEA](https://www.jetbrains.com/idea/) -- the Java IDE
* [Android Studio](http://developer.android.com/tools/studio/index.html)
* RubyMine, WebStorm, PyCharm, etc.

# Installation

This section assumes you are using IntelliJ IDEA. The procedure should be
similar for the other IntelliJ-based products as well.

To install the plugin:

* Navigate to the Settings view
* Click "Plugins"
* Click "Browse Repositories"

![installation-1]

* In the filter text field, enter "VDL"
* Select "VDL plugin for IntelliJ" from the list
* Click the "Install" button

![installation-2]

You will need to restart IDEA for the changes to take effect.

# Features

While the plugin is very new, it does support a handful of useful features:

* syntax highlighting and checking
* structured file viewer
* usage finder
* rename refactoring

## Syntax highlighting

![syntax-highlighting]

## Structure view

![structure-view]

## Find usages

![find-usages]

## Rename refactoring

![refactor-rename]

# Limitations

Support for VDL is nascent. There are many places where identifiers will not be resolved
(e.g. parameter types in `error` declarations). These limitations will also affect the
accuracy of rename refactoring.

Code completion in general is not implemented yet.

[VDL]: https://github.com/vanadium/docs/blob/master/designdocs/vdl-spec.md
[installation-1]: https://cloud.githubusercontent.com/assets/4641539/12103294/e664b18c-b2f5-11e5-879a-e94d6f080680.png
[installation-2]: https://cloud.githubusercontent.com/assets/4641539/12103339/60d85f18-b2f6-11e5-9740-0dc6bd62d578.png
[syntax-highlighting]: https://cloud.githubusercontent.com/assets/4641539/12103372/a78a9ce6-b2f6-11e5-9960-505dda86bd3c.png
[structure-view]: https://cloud.githubusercontent.com/assets/4641539/12103413/0196cd2c-b2f7-11e5-8961-456a12df2ac5.png
[find-usages]: https://cloud.githubusercontent.com/assets/4641539/12103457/355c9416-b2f7-11e5-9634-59424c0fcce5.png
[refactor-rename]: https://cloud.githubusercontent.com/assets/4641539/12103488/66f56156-b2f7-11e5-9756-3f5157be0f4e.png
