import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import { LoaderComponent } from './_http/loader/loader.component';
import {MymoduleModule} from '../mymodule/mymodule.module';
import {LoaderService} from './_http/loader/loader.service';
import {HttpService} from './_http/http.service';
import {RequestOptions, XHRBackend} from '@angular/http';
import {httpServiceFactory} from './_http/http-service.factory';
import { ImageUploadComponent } from './_imageUploader/_imageUploader.component';
import { FileDropDirective } from './_imageUploader/core/file-drop.directive';
import { ImageService } from './_imageUploader/core/image.service';



@NgModule({
  imports : [CommonModule, MymoduleModule],
  declarations : [LoaderComponent, ImageUploadComponent, FileDropDirective],
  exports : [LoaderComponent, ImageUploadComponent, FileDropDirective],
  providers : [
    LoaderService,
    {
      provide: HttpService,
      useFactory: httpServiceFactory,
      deps: [XHRBackend, RequestOptions, LoaderService]
    },
    ImageService
  ]

})
export class CoreModule {}
