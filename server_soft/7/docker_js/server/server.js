const http = require('http');

const server = http.createServer((req, res) => {
    res.writeHead(200, {'Content-Type': 'text/plain'});
    res.end('This server is running in a Docker container but using Node.js');
});

const PORT = 1234;
server.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`)
});
