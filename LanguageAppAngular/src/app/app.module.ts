import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { AddWordComponent } from './component/add-word/add-word.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRountigModule } from '../app/app-routing.module';
import { HomeComponent } from './component/home/home.component';
import { WordsListComponent } from './component/words-list/words-list.component'
// import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {SearchWordPipe} from "./pipes/searchWord.pipe";
import {HttpClientModule} from "@angular/common/http";
import { WordEditComponent } from './component/modal/word-edit/word-edit.component';
import { WordDeleteComponent } from './component/modal/word-delete/word-delete.component';
import {MatDialogModule} from "@angular/material/dialog";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AddWordComponent,
    HomeComponent,
    WordsListComponent,
    SearchWordPipe,
    WordEditComponent,
    WordDeleteComponent,

  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    AppRountigModule,
    // NgbModule,
    HttpClientModule,
    MatDialogModule,
    BrowserAnimationsModule

  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [WordDeleteComponent]
})
export class AppModule { }
