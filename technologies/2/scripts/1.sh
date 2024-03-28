#/bin/bash

# Создаем файл info.txt, который будет содержать информацию
FILE="info.txt"
> $FILE

# Добавляем дату и время
echo "Date and Time" | tee -a $FILE
echo $(date) | tee -a $FILE
echo | tee -a $FILE

# Добавляем информацию о зарегистрировавшихся пользователях
echo "Logged Users" | tee -a $FILE
echo "$(who)" | tee -a $FILE
echo "" | tee -a $FILE

# Добавляем uptime системы
echo "System Uptime" | tee -a $FILE
echo $(uptime) | tee -a $FILE
