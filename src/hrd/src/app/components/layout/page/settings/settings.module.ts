import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SettingsComponent } from './settings.component';
import { CommonModule } from '@angular/common';
import { CoreModule } from '../../../../core/core.module';
import { MymoduleModule } from '../../../../mymodule/mymodule.module';
const routes: Routes = [
    { path : '', component : SettingsComponent}
]
@NgModule({
    imports : [CommonModule, RouterModule.forChild(routes), CoreModule, MymoduleModule],
    exports : [SettingsComponent, RouterModule],
    declarations : [SettingsComponent],
    providers: []
})
export class SettingsModule {

}
