import {Component, EventEmitter, Inject, Output} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {WordsService} from "../../../service/words.service";

@Component({
  selector: 'app-word-delete',
  templateUrl: './word-delete.component.html',
  styleUrls: ['./word-delete.component.css']
})
export class WordDeleteComponent {

  action: string;

  constructor(
    public dialogRef: MatDialogRef<WordDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public wordsService: WordsService
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  onYesClick(id: number){
    this.wordsService.deleteWord(id);
    this.dialogRef.close( {event: 'Delete'});
    window.location.reload();
  }

}
