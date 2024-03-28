FROM python:3.10-slim
RUN pip install flask
COPY ./app/main.py /app/
WORKDIR /app
CMD ['python', 'main.py']