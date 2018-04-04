import { Component, OnInit } from '@angular/core';
import { DataSource } from '@angular/cdk/collections';
import {MatSnackBarVerticalPosition, MatSnackBar, MatSnackBarConfig} from "@angular/material";
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {MyCurrencyPipe} from "../../../../core/pipe/my-currency.pipe";


@Component({
  selector: 'app-penggajian',
  templateUrl: './penggajian.component.html',
  styleUrls: ['./penggajian.component.scss']
})
export class PenggajianComponent implements OnInit {

  showmodal = false;
  updateData  = false;
  showformadd = false;
  showcari = false;
  classmodal = 'cmodal';
  classmodalcari = 'cmodal-cari';
  position_tooltip: any = 'after';


  matSnackBarVerticalPosition: MatSnackBarVerticalPosition = 'top';
  snackBarSuccesConf: MatSnackBarConfig = {
    duration: 3000,
    extraClasses: ['success-snackbar'],
    verticalPosition: this.matSnackBarVerticalPosition
  };
  snackBarErrorConf: MatSnackBarConfig = {
    duration: 3000,
    extraClasses: ['error-snackbar'],
    verticalPosition: this.matSnackBarVerticalPosition
  };
  formgajitetap: FormGroup;
  tjistri:any=0;
  tjanak:any=0;

  constructor(private snackbar: MatSnackBar, private fb: FormBuilder,private mycurrencyPipe: MyCurrencyPipe) {
  }

  ngOnInit() {
    this.buildform();
  }

  buildform(){
    this.formgajitetap = this.fb.group(
      {
        'nik': [localStorage.getItem('nik'), Validators.required],
        'nama': ['', Validators.required],
        'gapok':['0',Validators.required],
        'tjistri':['0',Validators.required],
        'tjanak':['0',Validators.required],
        'tjjabatan':['0',Validators.required],
        'tjkesehatan':['0',Validators.required]

      }
    )

  }


  openFormGaji(){
    this.showformadd = !this.showformadd;
  }

  batal(){
    this.showformadd = !this.showformadd;
  }
  stringTonumber(x:string){
    return this.mycurrencyPipe.parse(x)
  }


  hitgaji(x){
    console.log(this.stringTonumber(x));

    const gp = x;
    const tji=(17.5 * gp)/100;
    const tja = ((12.5 * gp)/100)*3;
    this.tjistri = this.mycurrencyPipe.transform(tji.toLocaleString());
    this.tjanak = this.mycurrencyPipe.transform(tja.toLocaleString());

  }

}

export class GajiDB{

}
