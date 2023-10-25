import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { AddWordComponent } from './component/add-word/add-word.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRountigModule } from '../app/app-routing.module';
import { HomeComponent } from './component/home/home.component';
import { WordsListComponent } from './component/words-list/words-list.component'
import {SearchWordPipe} from "./pipes/searchWord.pipe";
import {HttpClientModule} from "@angular/common/http";
import { WordEditComponent } from './component/modal/word-edit/word-edit.component';
import { WordDeleteComponent } from './component/modal/word-delete/word-delete.component';
import {MatDialogModule} from "@angular/material/dialog";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { WordViewComponent } from './component/modal/word-view/word-view.component';
import {MatPaginatorModule} from "@angular/material/paginator";


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
    WordViewComponent,

  ],
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        FormsModule,
        AppRountigModule,
        HttpClientModule,
        MatDialogModule,
        BrowserAnimationsModule,
        MatPaginatorModule

    ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [WordDeleteComponent]
})
export class AppModule { }
