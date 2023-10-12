import {Component, OnInit} from '@angular/core';
import {Word} from "../../models/word.model";
import {WordsService} from "../../service/words.service";
import {HttpErrorResponse} from "@angular/common/http";
import {ModalService} from "../../service/modal.service";
import {AudioPlayerService} from "../../service/audio-player.service";


@Component({
  selector: 'app-words-list',
  templateUrl: './words-list.component.html',
  styleUrls: ['./words-list.component.css']
})
export class WordsListComponent implements OnInit {

  searchTextName: string;
  searchTextCategory: string;
  showImage: boolean = false;

  constructor(private wordsService: WordsService, private modalService: ModalService,
              private audioPlayerService: AudioPlayerService) {
  }

  listOfWords: Word[];
  refresh = false;

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

  playSound(name: string) {
    let audio = new Audio();
    audio.src = '../../assets/sounds/' + name;
    audio.load();
    audio.play();
  }

  ngOnInit() {
    this.wordsService.getWords().subscribe((response: Word[]) => {
        this.listOfWords = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      });
  }
}
