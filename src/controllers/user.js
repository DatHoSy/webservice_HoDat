const fs = require('fs');

function writeLog(jsonContent) {
    fs.writeFile("./src/data/output.json", jsonContent, 'utf8', function (err) {
        if (err) {
            console.log("An error occured while writing JSON Object to File.");
            return console.log(err);
        }
        console.log("JSON file has been saved.");
    });
}

function createJson(req, res) {
    const listJsonOjb = req.body;
    var jsonContent = JSON.stringify(listJsonOjb);
    writeLog(jsonContent);
    res.send('Successfully!');
}

function getAllData(req, res) {
    const listJsonOjb = fs.readFileSync("./src/data/output.json");
    var jsonContent = JSON.parse(listJsonOjb);
    res.send(jsonContent);
}

function getDatabyCountry(req, res) {
    const countryParams = req.params.country;
    const listJsonOjb = fs.readFileSync("./src/data/output.json");
    var jsonContent = JSON.parse(listJsonOjb);
    let newData = [];

    jsonContent.children[0].children.map(
        data => data.children.map(
            data => data.children.map(
                    data => {
                        if (data.country == countryParams) {
                            newData.push(data);
                        }
                    }
                )
            )
        );

    res.send(newData);
}

module.exports = { getAllData, createJson, getDatabyCountry }