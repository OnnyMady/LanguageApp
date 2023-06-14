import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {WordsService} from "../../../service/words.service";
import {Word} from "../../../models/word.model";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-word-edit',
  templateUrl: './word-edit.component.html',
  styleUrls: ['./word-edit.component.css']
})
export class WordEditComponent {

  myForm: FormGroup;

  constructor(
    public dialogRef: MatDialogRef<WordEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public wordsService: WordsService
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  onYesClick(word: Word){
    this.wordsService.editWord(word);
  }

  ngOnInit(): void {
    this.myForm = new FormGroup({
      'word': new FormControl(null),
      'translation': new FormControl(null),
      'sentence': new FormControl(null),
      'category': new FormControl(null)
    });
  }

  onSubmit() {
    console.log(this.myForm.value)
    this.wordsService.saveWord();
  }

}
