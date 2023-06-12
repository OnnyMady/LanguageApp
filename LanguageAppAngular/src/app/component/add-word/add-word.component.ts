import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import {WordsService} from "../../service/words.service";

@Component({
  selector: 'app-add-word',
  templateUrl: './add-word.component.html',
  styleUrls: ['./add-word.component.css']
})
export class AddWordComponent implements OnInit {
  myForm: FormGroup;

  constructor(private  wordsService: WordsService) {
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
