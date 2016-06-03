# sbv-to-ttaf
A quick Java based SBV to TTAF caption file conversion tool.


## Installation
You will need to have Java installed on your machine to run this tool. Java can be downloaded from [here](https://java.com/en/download/)

Clone this repository, or download it as a ZIP file. This repository contains all of the source code as well as unit tests needed to edit or augment the code, but a compiled JAR is also available to run a simple conversion.

## Usage
The runnable JAR file expects two arguments:
* The path to the SBV file
* The path to the new TTAF file

Optionally, a third *debug* parameter can be passed to output additional transformation details to the console.

* Navigate to the `\lib` folder
* Run `java -jar sbv-to-ttaf-0.0.1 <path_to_sbv_file> <path_to_new_ttaf_file> [debug]>`
* Enjoy!

## License
Copyright (c) 2016 Guillaume Clement

MIT License

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
