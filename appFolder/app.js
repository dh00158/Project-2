//setup express to handle routing and rendering
var express = require('express');
var app = express();
const fs = require('node:fs');
const path = require('path');
const filePath = path.join(__dirname, 'RetirementHomes.zip');
app.set('view engine', 'ejs');

//setup bodyparser to extra data from form posts
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true })); 

// route to index page
app.get('/', function(req, res) {
    res.render('page/index');
});

// route to api call for downloading app

app.get('/api/download_retirement_home_app', (req, res) => {
	res.download(filePath, 'RetirementHomes.zip', (err) => {
		if (err) {
			console.error("Unable to download file:", err);
			res.status(500).send("Download failed");
		} else {
			console.log("Download successful");
		}
	});
});

//start the web app
app.listen(8080, function () {
	console.log('App listening on port 8080!');
});

