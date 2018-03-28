import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home.component';
import { CoreModule } from '../../../../core/core.module';

const routes: Routes = [
    {path : '', component: HomeComponent
    }
  ];

@NgModule({
    imports : [CoreModule, RouterModule.forChild(routes)],
    declarations : [HomeComponent],
    exports : [HomeComponent, RouterModule],
    providers : []
})


export class HomeModule {
}
