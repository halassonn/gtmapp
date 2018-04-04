import {NgModule} from "@angular/core";
import {CommonModule, DecimalPipe} from "@angular/common";
import {PenggajianComponent} from "./penggajian.component";
import {MymoduleModule} from "../../../../mymodule/mymodule.module";
import {RouterModule, Routes} from "@angular/router";
import {MymodalModule} from "../../../../mymodal/mymodal.module";
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MyCurrencyFormatterDirective} from "../../../../core/directive/my-currency.directive";



const routes:Routes=[
  {path:'',component:PenggajianComponent}
]

@NgModule({
  imports : [CommonModule, MymoduleModule, MymodalModule, FormsModule, ReactiveFormsModule,
  RouterModule.forChild(routes)],
  declarations : [PenggajianComponent, MyCurrencyFormatterDirective],
  exports : [
    RouterModule,MyCurrencyFormatterDirective
  ],
  providers: []
})
export class PenggajianModule{

}
