import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SettingsComponent} from './settings.component';
import { CommonModule } from '@angular/common';
import { CoreModule } from '../../../../core/core.module';
import { MymoduleModule } from '../../../../mymodule/mymodule.module';
import {MymodalModule} from "../../../../mymodal/mymodal.module";
import {LayoutService} from "../layout.service";
import {AngularFontAwesomeModule} from "angular-font-awesome";
const routes: Routes = [
    { path : '', component : SettingsComponent}
]
@NgModule({
    imports : [CommonModule, RouterModule.forChild(routes), CoreModule, MymoduleModule, MymodalModule,AngularFontAwesomeModule],
    exports : [SettingsComponent, RouterModule],
    declarations : [SettingsComponent],
    providers: [LayoutService]
})
export class SettingsModule {

}
