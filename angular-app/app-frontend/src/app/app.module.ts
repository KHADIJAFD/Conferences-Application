import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConferenceComponent } from './ui/conference/conference.component';
import { KeynotesComponent } from './ui/keynotes/keynotes.component';

@NgModule({
  declarations: [
    AppComponent,
    ConferenceComponent,
    KeynotesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
