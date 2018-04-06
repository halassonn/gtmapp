import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {LayoutService} from "../layout.service";
import {animate, style, transition, trigger} from '@angular/animations';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss'],
  animations: [
    trigger('dialog', [
      transition('void => *', [
        style({transform: 'scale3d(.3, .3, .3)'}),
        animate(100)
      ]),
      transition('* => void', [
        animate(100, style({transform: 'scale3d(.0, .0, .0)'}))
      ])
    ])
  ]
})
export class SettingsComponent implements OnInit {
  open_main_setting:boolean = false;
  open_form_kesehatan:boolean = false;
  open_form_istri_anak:boolean = false;
  open_form_khusus:boolean = false;
  open_form_jabatan:boolean = false;
  open_form_transport:boolean = false;
  open_form_pangan:boolean = false;
  open_form_tht:boolean = false;



  hide_main_setting:boolean = false;
  title:string;
  classmodal = 'cmodal';

  //model
  tjkesehatan : TunjanganKesehatan =new TunjanganKesehatan;
  tjistrianak : TunjanganIstriAnak = new TunjanganIstriAnak;

  constructor(private layoutservice:LayoutService) { }

  ngOnInit() {
  }




  open_form(p:string){
    if(p ==='TJKesehatan'){
      this.open_form_kesehatan = !this.open_form_kesehatan;
      this.title='Tunjangan Kesehatan';
    }else if(p ==='TJIstriAnak'){
      this.title='Tunjangan Istri / Anak';
      this.open_form_istri_anak = !this.open_form_istri_anak;
    }else if(p ==='TJPangan'){
      this.title='Tunjangan Pangan';
      this.open_form_pangan = !this.open_form_pangan;
    }else if(p ==='TJTransport'){
      this.title='Tunjangan Transport';
      this.open_form_transport = !this.open_form_transport;
    }else if(p ==='TJJabatan'){
      this.title='Tunjangan Jabatan';
      this.open_form_jabatan = !this.open_form_jabatan;
    }else if(p ==='TJTHT'){
      this.title='Tunjangan Hari Tua';
      this.open_form_tht = !this.open_form_tht;
    }else if(p ==='TJKhusus'){
      this.title='Tunjangan Khusus';
      this.open_form_khusus = !this.open_form_khusus;
    }
    this.hide_main_setting = !this.hide_main_setting;
    console.log('open form '+ p);
  }


  batal(p:string){
    if(p === 'main_setting'){
      this.layoutservice.open_route('home');
    }else if(p ==='TJKesehatan'){
      this.open_form_kesehatan = !this.open_form_kesehatan;
    }else if(p ==='TJIstriAnak'){
      this.open_form_istri_anak = !this.open_form_istri_anak;
    }else if(p ==='TJPangan'){
      this.open_form_pangan = !this.open_form_pangan;
    }else if(p ==='TJTransport'){
      this.open_form_transport = !this.open_form_transport;
    }else if(p ==='TJJabatan'){
      this.open_form_jabatan = !this.open_form_jabatan;
    }else if(p ==='TJTHT'){
      this.open_form_tht = !this.open_form_tht;
    }else if(p ==='TJKhusus'){
      this.open_form_khusus = !this.open_form_khusus;
    }
    this.hide_main_setting = !this.hide_main_setting;
    console.log('close ' + p);
  }

}
export class TunjanganKesehatan{
  private tk:string='22.5 %';
  private k0:string='27.5 %';
  private k1:string='32.5 %';
  private k2:string='37.5 %';
  private k3:string='42.5 %';
}
export class TunjanganIstriAnak{
  private tjistri:string = '17.5 %';
  private tjanak:string = '12.5 %';
}
