#!/bin/bash
#set -x

i=0
while ((i<2));do

	curl -d  "param1=value1&param2=value2" "http://127.0.0.1/hello"


done
