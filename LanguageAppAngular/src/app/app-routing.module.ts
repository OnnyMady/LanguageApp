import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AddWordComponent } from "./component/add-word/add-word.component";
import { HeaderComponent } from "./component/header/header.component";
import { HomeComponent } from "./component/home/home.component";
import {WordsListComponent} from "./component/words-list/words-list.component";


const routes: Routes = [
    { path: '', component: HomeComponent },
  { path: 'wordsList', component: WordsListComponent },
    { path: 'addWord', component: AddWordComponent }
]




@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRountigModule {

}
