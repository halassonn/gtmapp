import { app, BrowserWindow, screen, dialog } from 'electron';
import * as path from 'path';

//import { autoUpdater } from "electron-updater"
const ipcMain = require('electron').ipcMain;
const autoUpdater = require("electron-updater").autoUpdater
const log = require('electron-log');


let win, serve;
const args = process.argv.slice(1);

serve = args.some(val => val === '--serve');
import * as url from 'url';

//autoUpdater.logger = log;
//autoUpdater.logger.transports.file.level = 'info';
log.info('App starting...');

var updatemessage ;
function sendStatusToWindow(text) {
  log.info(text);
  updatemessage=text;
  win.webContents.send('message', updatemessage);
}



if (serve) {
  require('electron-reload')(__dirname, {
  });
}

function createWindow() {
    
  const electronScreen = screen;
  const size = electronScreen.getPrimaryDisplay().workAreaSize;

  // Create the browser window.
  win = new BrowserWindow({
    x: 0,
    y: 0,
    //width: size.width,
    //height: size.height
    width: 660,
    height: 450,
    minHeight: 660,
    minWidth: 460
  });

  // and load the index.html of the app.
  win.loadURL(url.format({
    protocol: 'file:',
    pathname: path.join(__dirname, '/index.html'),
    slashes:  true
  }));

  // Open the DevTools.
  if (serve) {
    //win.webContents.openDevTools();
  }
  win.webContents.openDevTools();
  // Emitted when the window is closed.
  win.on('closed', () => {
    // Dereference the window object, usually you would store window
    // in an array if your app supports multi windows, this is the time
    // when you should delete the corresponding element.
    win = null;
    app.quit();
  });
}

try {

  // This method will be called when Electron has finished
  // initialization and is ready to create browser windows.
  // Some APIs can only be used after this event occurs.
  app.on('ready',() =>{
    //server();
    createWindow();
    win.webContents.send('getdata',app.getVersion());
  } );

  // Quit when all windows are closed.
  app.on('window-all-closed', () => {
    // On OS X it is common for applications and their menu bar
    // to stay active until the user quits explicitly with Cmd + Q
    if (process.platform !== 'darwin') {
      app.quit();
    }
  });

  app.on('activate', () => {
    // On OS X it's common to re-create a window in the app when the
    // dock icon is clicked and there are no other windows open.
    if (win === null) {
      
      createWindow();
    }
  });

} catch (e) {
  // Catch Error
  // throw e;
}

//const server = 'https://hazel-server-ugvaruiimu.now.sh';
//const feed = `${server}/update/${process.platform}/${app.getVersion()}`;
const feed='https://github.com/halassonn/myapp/releases/download/v1.0.8/';

autoUpdater.setFeedURL(feed);

autoUpdater.on('checking-for-update', () => {
  sendStatusToWindow('Checking for update...');
})
autoUpdater.on('update-available', (ev, info) => {
  sendStatusToWindow('update-available');
  setTimeout(function() {
    win.webContents.send('update_info', 
    'A new version has been downloaded. Restart the application to apply the updates.'+
    '<br> <button type="button" class="btn btn-success" (click)="click_update()">Success</button> <button>Later</button>');
  }, 5000)
  
})
autoUpdater.on('update-not-available', (ev,info) => {
  sendStatusToWindow('Update not available.');
})
autoUpdater.on('error', (ev, err) => {
  sendStatusToWindow('Error in auto-updater.');
})
autoUpdater.on('download-progress', (progressObj) => {
  let log_message = "Download speed: " + progressObj.bytesPerSecond;
  log_message = log_message + ' - Downloaded ' + progressObj.percent + '%';
  log_message = log_message + ' (' + progressObj.transferred + "/" + progressObj.total + ')';
  sendStatusToWindow(log_message);
})

autoUpdater.on('update-downloaded', (ev, info) => {
  sendStatusToWindow('Update downloaded; will install in 5 seconds');
});

autoUpdater.on('update-downloaded', (ev, releaseNotes, releaseName) => {
  // Wait 5 seconds, then quit and install
  // In your application, you don't need to wait 5 seconds.
  // You could call autoUpdater.quitAndInstall(); immediately
  /*setTimeout(function() {
    autoUpdater.quitAndInstall(); 
  }, 5000) */
  /*
  const dialogOpts = {
    type: 'info',
    buttons: ['Restart', 'Later'],
    title: 'Application Update',
    message: process.platform === 'win32' ? releaseNotes : releaseName,
    detail: 'A new version has been downloaded. Restart the application to apply the updates.'
  }

  dialog.showMessageBox(dialogOpts, (response) => {
    if (response === 0) autoUpdater.quitAndInstall()
  }) */

  win.webContents.send('update_info', 'A new version has been downloaded. Restart the application to apply the updates.');

})

app.on('ready', function()  {
  //autoUpdater.checkForUpdates();
  
}); 

ipcMain.on('cek_update_app', function(event, arg) {
  console.log('check update from button');
  autoUpdater.checkForUpdates();
  console.log(updatemessage);
  //event.sender.send('update_info','updatemessage');
});

ipcMain.on('getSomething', function(event, arg) {
  console.log('from angular')
  event.sender.send('getdata',app.getVersion());
});



