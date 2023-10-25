import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Word} from "../../models/word.model";
import {WordsService} from "../../service/words.service";
import {HttpErrorResponse} from "@angular/common/http";
import {ModalService} from "../../service/modal.service";
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-words-list',
  templateUrl: './words-list.component.html',
  styleUrls: ['./words-list.component.css']
})



export class WordsListComponent implements OnInit {

  constructor(private wordsService: WordsService, private modalService: ModalService) {
  }

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild('checkEdit') checkEdit: ElementRef;

  searchTextName: string;
  searchTextCategory: string;
  showImage: boolean = false;
  listOfWords: Word[];
  refresh = false;
  paginatedListOfWords: any[] = [];
  pageIndex = 0;
  pageSize = 10;
  editMode = false;

  ngOnInit() {
    this.getData();

  }



  public getData(event?:PageEvent){
    this.wordsService.getWords().subscribe((response: any) => {
        this.listOfWords = response;
        this.paginatedListOfWords = this.listOfWords.slice(0, 10);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      });

    return event;
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

  onView(word: Word, editMode: boolean){
    this.modalService.onViewDialog(word, editMode);
  }

  playSound(name: string) {
    let audio = new Audio();
    audio.src = '../../assets/sounds/' + name;
    audio.load();
    audio.play();
  }

  onPageChange(event: PageEvent) {
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    const startIndex = this.pageIndex * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    this.paginatedListOfWords = this.listOfWords.slice(startIndex, endIndex);
  }

  onEditMode(){
    this.editMode = true;

    if (this.checkEdit.nativeElement.checked) {
      this.editMode = true;
    } else {
      this.editMode = false;
    }
  }



}
