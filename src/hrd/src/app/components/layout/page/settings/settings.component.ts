import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {LayoutService} from "../layout.service";

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent implements OnInit {
  open_main_setting:boolean = false;
  open_form_kesehatan:boolean = false;
  classmodal = 'cmodal';
  tjkesehatan : TunjanganKesehatan =new TunjanganKesehatan;

  constructor(private layoutservice:LayoutService) { }

  ngOnInit() {
  }




  open_form_tjkesehatan(){
    this.open_form_kesehatan = !this.open_form_kesehatan;
    console.log('open form tunjangan kesehatan');
  }

  batal(p:string){
    if(p === 'main_setting'){
      this.layoutservice.open_route('home');
    }else{
      this.open_form_kesehatan = !this.open_form_kesehatan;
    }

  }

}
export class TunjanganKesehatan{
  private tk:string='22.5 %';
  private k0:string='27.5 %';
  private k1:string='32.5 %';
  private k2:string='37.5 %';
  private k3:string='42.5 %';
}
