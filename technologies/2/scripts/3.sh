#!/bin/bash
# использование: ./3.sh filename.txt

while IFS= read -r line
do
  echo "$line"
done < "$1"
