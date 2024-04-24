const http = require("http")
const server = http.createServer((req, res) => {
    res.write("NodeJS server response");
    res.end();
});
server.listen(5000, () => {
    console.log("NodeJS server log")
});
