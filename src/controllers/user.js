const fs = require('fs');

function writeLog (jsonContent) {
    fs.writeFile("./src/data/output.json", jsonContent, 'utf8', function (err) {
        if (err) {
            console.log("An error occured while writing JSON Object to File.");
            return console.log(err);
        }
        console.log("JSON file has been saved.");
    });
}

function getAllData (req, res) {
    const listJsonOjb = req.body;
    // stringify JSON Object
    var jsonContent = JSON.stringify(listJsonOjb);
    writeLog(jsonContent);
    res.send('Successfully!');
} 
module.exports = {getAllData}