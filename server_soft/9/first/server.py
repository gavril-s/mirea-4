import flask
import requests

app = flask.Flask(__name__)

@app.route('/')
def index():
    response = requests.get('http://second/data')
    data = response.json()
    return flask.jsonify(data)

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=80)
