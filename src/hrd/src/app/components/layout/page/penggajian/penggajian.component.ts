import { Component, OnInit } from '@angular/core';
import {MatSnackBarVerticalPosition, MatSnackBar, MatSnackBarConfig} from "@angular/material";
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {MyCurrencyPipe} from "../../../../core/pipe/my-currency.pipe";
import {ProfileModel} from "../../../../model/profile.model";
import {LoaderService} from "../../../../core/_http/loader/loader.service";
import {DataGajiService} from "./service/datagaji.service";
import {ProfileService} from "../profile/services/profile.service";
import {Response} from "@angular/http";



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
  profilemodel: ProfileModel;


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
  private datagajiService: DataGajiService;


  constructor(
    private loaderservice: LoaderService,
    private profileService: ProfileService,
    private snackbar: MatSnackBar,
    private fb: FormBuilder,
    private mycurrencyPipe: MyCurrencyPipe) {
  }

  ngOnInit() {
    this.buildform(null);
  }

  buildform(data:ProfileModel){
    if (data !== null){
      this.formgajitetap = this.fb.group(
        {
          'carinik': ['', Validators.required],
          'nik': [data.nik, Validators.required],
          'nama': [data.nama, Validators.required],
          'jabatan': [data.jabatan, Validators.required],
          'sts': [data.status, Validators.required],
          'pendidikan': [data.pendidikan, Validators.required],
          'gol': [data.masakerja, Validators.required],
          'masakerja': [data.masakerja, Validators.required],
          'gapok':['0',Validators.required],
          'tjistri':['0',Validators.required],
          'tjanak':['0',Validators.required],
          'tjjabatan':['0',Validators.required],
          'tjkesehatan':['0',Validators.required],
          'tjkhusus':['0',Validators.required],
          'tjtrans':['0',Validators.required],
          'tjprlihan':['0',Validators.required],
          'tjpangan':['0',Validators.required],
          'tjpengab':['0',Validators.required],
          'tht':['0',Validators.required]
        }
      )
    }else{
      this.formgajitetap = this.fb.group(
        {
          'carinik': ['', Validators.required],
          'nik': ['', Validators.required],
          'nama': ['', Validators.required],
          'jabatan': ['', Validators.required],
          'sts': ['', Validators.required],
          'pendidikan': ['', Validators.required],
          'gol': ['', Validators.required],
          'masakerja': ['', Validators.required],
          'gapok':['0',Validators.required],
          'tjistri':['0',Validators.required],
          'tjanak':['0',Validators.required],
          'tjjabatan':['0',Validators.required],
          'tjkesehatan':['0',Validators.required],
          'tjkhusus':['0',Validators.required],
          'tjtrans':['0',Validators.required],
          'tjprlihan':['0',Validators.required],
          'tjpangan':['0',Validators.required],
          'tjpengab':['0',Validators.required],
          'tht':['0',Validators.required]
        }
      )
    }

  }


  caridatakaryawan(nik){
    this.loaderservice.status('Get Data.......');
    this.profileService.getDataKaryawan(nik).subscribe(
      (data) =>{
        if(data === 'NOT_FOUND'){
        this.snackbar.open('Data Tidak Ditemukan','',this.snackBarErrorConf);
        }else{
          this.profilemodel = data;
          this.buildform(this.profilemodel);

        }
      },
      (err)=>{
        console.error(err)
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
