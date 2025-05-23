const fs = require('fs');
const path = require('path');
const { exec } = require('child_process');

console.log('Running setup...');

// Ensure views folder exists
const viewsPath = path.join(__dirname, 'views');
if (!fs.existsSync(viewsPath)) {
    fs.mkdirSync(viewsPath, { recursive: true });
    console.log('Created "views" directory.');
} else {
    console.log('"views" directory already exists.');
}

// Check if RetirementHomes.zip exists
const zipPath = path.join(__dirname, 'RetirementHomes.zip');
if (!fs.existsSync(zipPath)) {
    console.warn('RetirementHomes.zip not found in project root. App download route will fail.');
} else {
    console.log('RetirementHomes.zip found.');
}

// Create default config file if missing
const configPath = path.join(__dirname, 'config.json');
if (!fs.existsSync(configPath)) {
    const defaultConfig = {
        appName: "RetirementHomes",
        createdAt: new Date().toISOString()
    };
    fs.writeFileSync(configPath, JSON.stringify(defaultConfig, null, 2));
    console.log('Created config.json');
} else {
    console.log('config.json already exists.');
}
const resourceGroup = 'RH-app-group';
const appName = 'RetirementHomes';

console.log(`Deploying to Azure App Service "${appName}"...`);

exec(`az webapp up --name ${appName} --resource-group ${resourceGroup} --runtime "NODE|18-lts"`, (err, stdout, stderr) => {
    if (err) {
        console.error('Deployment failed:', stderr);
    } else {
        console.log('Deployment complete:\n', stdout);
    }
});

console.log('Setup completed.');
