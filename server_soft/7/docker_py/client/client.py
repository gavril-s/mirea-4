import urllib.request

fp = urllib.request.urlopen('http://localhost:1234/')
encoded = fp.read()
fp.close()

decoded = encoded.decode('utf-8')
print(decoded)
