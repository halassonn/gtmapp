import {NgModule} from "@angular/core";
import {CommonModule, DecimalPipe, DatePipe} from "@angular/common";
import {PenggajianComponent} from "./penggajian.component";
import {MymoduleModule} from "../../../../mymodule/mymodule.module";
import {RouterModule, Routes} from "@angular/router";
import {MymodalModule} from "../../../../mymodal/mymodal.module";
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MyCurrencyFormatterDirective} from "../../../../core/directive/my-currency.directive";
import {ProfileService} from "../profile/services/profile.service";
import {DataGajiService} from "./service/datagaji.service";
import {MatPaginator, DateAdapter, MAT_DATE_FORMATS} from "@angular/material";
import {DateFormat, APP_DATE_FORMATS} from "../../../../utils/date-formats";
import {CoreModule} from "../../../../core/core.module";




const routes:Routes=[
  {path:'',component:PenggajianComponent}
]

@NgModule({
  imports : [CommonModule, MymoduleModule, MymodalModule, FormsModule, ReactiveFormsModule,CoreModule,
  RouterModule.forChild(routes)],
  declarations : [PenggajianComponent, MyCurrencyFormatterDirective],
  exports : [ RouterModule,MyCurrencyFormatterDirective],
  providers : [
    MatPaginator, ProfileService,
    { provide: DateAdapter, useClass: DateFormat },
    {
      provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS
    }, DatePipe
  ]
})
export class PenggajianModule{
  constructor(private dateAdapter: DateAdapter<Date>) {
  }
}
