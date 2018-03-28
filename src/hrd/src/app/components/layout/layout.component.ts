import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { LoaderService } from '../../core/_http/loader/loader.service';
import { environment } from '../../../environments';
import { MatSidenav } from '@angular/material';

@Component({
  selector: 'app-home',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.scss']
})
export class LayoutComponent implements OnInit {
  public appVersion;
  url: string = environment.server_host;
  title = 'Home';


  @ViewChild('sidenav')
  public mynav: MatSidenav;
  constructor(private router: Router, private loaderService: LoaderService) {
  }

  ngOnInit() {
    console.log('appVersion');
    console.log(this.url)
    switch (this.title) {
      case 'Data User': {
        // statements;
        this.router.navigateByUrl('/layout/users');
       // this.title = 'Data User';
        break;
      }
      case 'Data Kantor': {
        // statements;
        this.router.navigateByUrl('/layout/datakantor');
      //  this.title = 'Data Kantor';
        break;
      }
      case 'Data Karyawan': {
        // statements;
        this.router.navigateByUrl('/layout/karyawan');
       // this.title = 'Data Karyawan';
        break;
      }
      case 'Data Penggajian': {
        // statements;
        this.router.navigateByUrl('/layout/penggajian');
      //  this.title = 'Data Penggajian';
        break;
      }
      case 'Cetak Data' : {
        this.router.navigateByUrl('/layout/cetak')
      }
      // tslint:disable-next-line:no-switch-case-fall-through
      case 'Configuration' : {
        this.router.navigateByUrl('/layout/setting')
      }
      // tslint:disable-next-line:no-switch-case-fall-through
      default : {
        this.title = 'Home';
      this.router.navigateByUrl('/layout/home');
      }
    }
  }

  logout() {
    this.loaderService.status('Logout...');
    localStorage.removeItem('currentUser');
    localStorage.removeItem('isLoggedin');
    this.router.navigateByUrl('/');
  }

  open_sidemenu() {
    this.mynav.open();
  }

  open_route(m_url: string) {
    /*if (m_url === 'users') {
      this.set_title('Data User');
      this.router.navigateByUrl('/layout/users');
    } else if (m_url === 'data_kantor') {

      this.router.navigateByUrl('/layout/datakantor');
      this.title = 'Data Kantor';
    } else if (m_url === 'data_karyawan') {
      this.title = 'Data Karyawan';
      this.router.navigateByUrl('/layout/karyawan');
    } else if (m_url === 'data_gaji') {
      this.title = 'Data Penggajian';
      this.router.navigateByUrl('/layout/penggajian');
    } else {
      this.title = 'Home';
      this.router.navigateByUrl('/layout');
    } */
    switch (m_url) {
      case 'users': {
        // statements;
        this.router.navigateByUrl('/layout/users');
        this.title = 'Data User';
        break;
      }
      case 'data_kantor': {
        // statements;
        this.router.navigateByUrl('/layout/datakantor');
        this.title = 'Data Kantor';
        break;
      }
      case 'data_karyawan': {
        // statements;
        this.router.navigateByUrl('/layout/karyawan');
        this.title = 'Data Karyawan';
        break;
      }
      case 'data_gaji': {
        // statements;
        this.router.navigateByUrl('/layout/penggajian');
        this.title = 'Data Penggajian';
        break;
      }
      case 'data_cetak': {
        // statements;
        this.router.navigateByUrl('/layout/cetak');
        this.title = 'Cetak Data';
        break;
      }
      case 'setting': {
        // statements;
        this.router.navigateByUrl('/layout/setting');
        this.title = 'Configuration';
        break;
      }
      default : {
        this.title = 'Home';
      this.router.navigateByUrl('/layout/home');
      }
    }
    this.mynav.close();

  }

  public set_title(p: string) {
    this.title = p;
  }

  public get_title() {
    return this.title;
  }

}
