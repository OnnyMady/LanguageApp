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
  formData: FormData;

  constructor(
    public dialogRef: MatDialogRef<WordEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public wordsService: WordsService
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  onYesClick(word: Word){
    console.log(this.myForm.value)
    this.formData = this.wordsService.transformFormGroupToFormData(this.myForm);
    this.wordsService.editWord(this.formData);
    this.dialogRef.close();
  }

  onFileChange(event) {

    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.myForm.patchValue({
        fileSound: file
      });
    }
  }

  ngOnInit(): void {
    this.myForm = new FormGroup({
      'id': new FormControl(this.data.word.id),
      'word': new FormControl(null),
      'translation': new FormControl(null),
      'sentence': new FormControl(null),
      'category': new FormControl(null),
      'lesson': new FormControl(null),
      'fileSound': new FormControl(null)
    });
  }

}
