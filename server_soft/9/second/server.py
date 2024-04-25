import flask

app = flask.Flask(__name__)

@app.route('/data')
def get_data():
    data = {'data': 'SAMPLE DATA'}
    return flask.jsonify(data)

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=80)
