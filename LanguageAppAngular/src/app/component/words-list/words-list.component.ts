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

  constructor(private wordsService: WordsService, private modalService: ModalService) {
  }

  searchTextName: string;
  searchTextCategory: string;
  showImage: boolean = false;
  listOfWords: Word[];
  refresh = false;

  ngOnInit() {
    this.wordsService.getWords().subscribe((response: Word[]) => {
        this.listOfWords = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      });
  }

  onEdit(word: Word) {
    this.modalService.onEditDialog(word);
  }

  onDelete(wordId: number, wordName: string) {
    this.refresh = this.modalService.onDeleteDialog(wordId, wordName);
    if (this.refresh) {
      this.wordsService.getWords().subscribe((response: Word[]) => {
          this.listOfWords = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        });
    }
  }

  onView(word: Word){
    this.modalService.onViewDialog(word);
  }

  playSound(name: string) {
    let audio = new Audio();
    audio.src = '../../assets/sounds/' + name;
    audio.load();
    audio.play();
  }

}
