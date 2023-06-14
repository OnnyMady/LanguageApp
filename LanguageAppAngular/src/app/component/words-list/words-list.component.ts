import {Component, OnInit} from '@angular/core';
import {Word} from "../../models/word.model";
import {WordsService} from "../../service/words.service";
import {HttpErrorResponse} from "@angular/common/http";
import {ModalService} from "../../service/modal.service";


@Component({
  selector: 'app-words-list',
  templateUrl: './words-list.component.html',
  styleUrls: ['./words-list.component.css']
})
export class WordsListComponent implements OnInit {

  searchTextName: string;
  searchTextCategory: string;

  constructor(private wordsService: WordsService, private modalService: ModalService) {
  }

  listOfWords: Word[] ;

    onEdit(word: Word){
      this.modalService.onEditDialog(word);
    }

    onDelete(wordId: number, wordName: string){
        this.modalService.onDeleteDialog(wordId, wordName);
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
