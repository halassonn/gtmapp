import {Component, OnInit} from '@angular/core';

import { ipcRenderer } from "electron";
@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {
  public version: string;
  constructor() {
    this.getdata();
  }

  ngOnInit() {
  }
  getdata(){
    ipcRenderer.send('getSomething');
    //console.log(x);

    ipcRenderer.on('getdata', (event, arg) => {
      // Print 2
      console.log(arg);
      this.version=arg;
      // Send sync message to main process
      //let mainValue = ipcRenderer.sendSync('sync', 3);
      // Print 4
      //console.log(mainValue);
    });
  }

}
