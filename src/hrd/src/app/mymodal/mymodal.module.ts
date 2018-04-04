import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {MymodalComponent} from "./mymodal.component";
import {FormsModule} from "@angular/forms";
import {ModalService} from "./services/modal.service";
import {MymoduleModule} from "../mymodule/mymodule.module";

@NgModule({
  imports:[CommonModule, FormsModule, MymoduleModule],
  declarations:[MymodalComponent],
  exports:[MymodalComponent],
  providers: [ModalService]
})
export class MymodalModule{

}
