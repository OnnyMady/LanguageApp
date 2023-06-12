import {Component, OnInit} from '@angular/core';
import {Word} from "../../models/word.model";
import {WordsService} from "../../service/words.service";
import {HttpErrorResponse} from "@angular/common/http";


@Component({
  selector: 'app-words-list',
  templateUrl: './words-list.component.html',
  styleUrls: ['./words-list.component.css']
})
export class WordsListComponent implements OnInit {

  searchTextName: string;
  searchTextCategory: string;

  constructor(private wordsService: WordsService) {
  }

  listOfWords: Word[] ;

    onEdit(){
      this.wordsService.editWord(new Word());
    }

    onDelete(){
        this.wordsService.deleteWord('sas');
    }

    ngOnInit() {
     this.wordsService.getWords().subscribe( ( response: Word[]) => {
       this.listOfWords = response;
     },
     (error: HttpErrorResponse) => {
        alert(error.message);
      });
    }



}
