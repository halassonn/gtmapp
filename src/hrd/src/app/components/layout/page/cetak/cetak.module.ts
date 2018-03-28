import { NgModule } from '@angular/core';
import { CetakComponent } from './cetak.component';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { MymodalModule } from '../../../../mymodal/mymodal.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CoreModule } from '../../../../core/core.module';

const routes: Routes =
[
    {
        path : '', component : CetakComponent
    }
]

@NgModule({
    imports : [CommonModule,
        RouterModule.forChild(routes),
    MymodalModule, FormsModule, CoreModule, ReactiveFormsModule],
    exports : [CetakComponent, RouterModule],
    declarations : [
        CetakComponent
    ],
    providers : []
})
export class CetakModule {

}
