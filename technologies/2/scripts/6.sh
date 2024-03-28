#/bin/bash
# использование: ./6.sh /path/to/directory

for file in "$1"/*
do
    if [ -f "$file" ] && [ -x "$file" ]
    then
        echo "$file"
    fi
done
