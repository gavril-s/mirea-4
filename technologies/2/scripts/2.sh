#/bin/bash
# использование: ./2.sh /path/to/directory

if [ -d "$1" ] 
then
    ls -lh "$1"
else
    echo "Error: Directory $1 does not exist."
fi
