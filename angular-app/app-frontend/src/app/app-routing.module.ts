import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {KeynotesComponent} from "./ui/keynotes/keynotes.component";
import {ConferencesComponent} from "./ui/conference/conference.component";

const routes: Routes = [
  { path: 'conferences', component: ConferencesComponent},
  { path: 'keynotes', component: KeynotesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
