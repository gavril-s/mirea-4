#/bin/bash

curl -L -o blocknote-master.tar.gz https://www.dropbox.com/s/ija7ax3sj6ysb0p/blocknote-master.tar.gz
tar -xvf blocknote-master.tar.gz blocknote-master

cp requirements.txt blocknote-master
cd blocknote-master

sed -i '' 's/base/todoapp/g' ./apps/todoapp/apps.py

python3 -m venv venv
./venv/bin/python -m pip install -r requirements.txt

./venv/bin/python manage.py makemigrations
./venv/bin/python manage.py migrate
./venv/bin/python manage.py runserver
