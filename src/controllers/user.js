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

function createJson (req, res) {
    const listJsonOjb = req.body;
    var jsonContent = JSON.stringify(listJsonOjb);
    writeLog(jsonContent);
    res.send('Successfully!');
}

function getAllData (req, res) {
    const listJsonOjb = fs.readFileSync("./src/data/output.json");
    var jsonContent = JSON.parse(listJsonOjb);
    res.send(jsonContent);
}

function getDatabyCountry (req, res) {
    const countryParams = req.params.country;
    const listJsonOjb = fs.readFileSync("./src/data/output.json");
    var jsonContent = JSON.parse(listJsonOjb);
    console.log(jsonContent);

    let newDataImports = jsonContent.children[0].children.filter(data => data.type == 'Imports' );
    let newDataExports = jsonContent.children[0].children.filter(data => data.type == 'Exports' );

    let dataImportsAfrica =  newDataImports[0].children.filter(data => data.continent == 'Africa');
    let dataImportsAustralia =  newDataImports[0].children.filter(data => data.continent == 'Australia');

    let DataExportsAfrica = newDataExports[0].children.filter(data => data.continent == 'Africa');
    let DataExportsAustralia = newDataExports[0].children.filter(data => data.continent == 'Australia');

    let srearchContryImportsAfrica = dataImportsAfrica[0].children.filter(data => data.country == countryParams);
    let srearchContryImportsAustralia = dataImportsAustralia[0].children.filter(data => data.country == countryParams);
    let srearchContryExportsAfrica = DataExportsAfrica[0].children.filter(data => data.country == countryParams);
    let srearchContryExportsAustralia = DataExportsAustralia[0].children.filter(data => data.country == countryParams);

    let newData = [{type : "Imports", children : [...srearchContryImportsAfrica, ...srearchContryImportsAustralia]}
                    , {type : "Exports", children : [...srearchContryExportsAfrica, ...srearchContryExportsAustralia]}];
    res.send(newData);
}

module.exports = {getAllData, createJson, getDatabyCountry}