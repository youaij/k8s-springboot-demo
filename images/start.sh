#!/bin/bash
echo "参数：$0";

java  -Xms256m -Xmx256m -XX:NewSize=128m -XX:MaxNewSize=128m -Dfile.encoding=UTF-8 -jar app.jar $*
