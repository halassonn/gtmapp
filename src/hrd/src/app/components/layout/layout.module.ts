import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MymoduleModule} from '../../mymodule/mymodule.module';
import {RouterModule, Routes} from '@angular/router';
import {LoaderService} from '../../core/_http/loader/loader.service';
import {LayoutComponent} from './layout.component';



const routes: Routes = [
  {
    path: '', component: LayoutComponent,
    children: [
      {path: 'home', loadChildren: '../../components/layout/page/home/home.module#HomeModule'},
      {path: 'karyawan', loadChildren: '../../components/layout/page/profile/profile.module#ProfileModule'},
      {path: 'penggajian', loadChildren: '../../components/layout/page/penggajian/penggajian.module#PenggajianModule'},
      {path: 'datakantor', loadChildren: '../../components/layout/page/datakantor/datakantor.module#DatakantorModule'},
      {path: 'users', loadChildren: '../../components/layout/page/users/users.module#UsersModule'},
      {path: 'cetak', loadChildren: '../../components/layout/page/cetak/cetak.module#CetakModule'},
      {path: 'setting', loadChildren: '../../components/layout/page/settings/settings.module#SettingsModule'}
    ]
  }
];

@NgModule({
  imports: [
    CommonModule,
    MymoduleModule, RouterModule.forChild(routes)
  ],
  declarations: [
    LayoutComponent
  ],
  exports: [
    RouterModule
  ], providers: [
    LoaderService
  ]
})
export class LayoutModule {

}
