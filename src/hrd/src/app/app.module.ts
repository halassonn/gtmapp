import 'zone.js/dist/zone-mix';
import 'reflect-metadata';
// import 'polyfills';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { HttpClientModule, HttpClient } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

// NG Translate
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';

import { ElectronService } from './providers/electron.service';


import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MymoduleModule} from './mymodule/mymodule.module';


import { DateFormat } from './utils/date-formats';
import { DateAdapter } from '@angular/material';
import { LayoutModule } from '@angular/cdk/layout';
import { ProfileService } from './components/layout/page/profile/services/profile.service';
import { WebviewDirective } from './directives/webview.directive';
import { HttpModule } from '@angular/http';



// AoT requires an exported function for factories
export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  declarations: [
    AppComponent,
    WebviewDirective,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: (HttpLoaderFactory),
        deps: [HttpClient]
      }
    }),

    MymoduleModule,
    LayoutModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule
  ],
  providers: [ElectronService, ProfileService ],
  bootstrap: [AppComponent]
})
export class AppModule {
 }
