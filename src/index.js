const express = require('express');
const app = express();
const port = 8000;
const userRouter = require('./routes/user');

app.use(express.json());

const fs = require('fs');
// json data
var jsonData = '{"persons":[{"name":"John","city":"New York"},{"name":"Phil","city":"Ohio"}]}';
 
// parse json
var jsonObj = JSON.parse(jsonData);
console.log(jsonObj);
 
// stringify JSON Object
var jsonContent = JSON.stringify(jsonObj);
console.log(jsonContent);
 
fs.writeFile("./src/data/output.json", jsonContent, 'utf8', function (err) {
    if (err) {
        console.log("An error occured while writing JSON Object to File.");
        return console.log(err);
    }
    console.log("JSON file has been saved.");
});


app.use('/v1/', userRouter);

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`);
})