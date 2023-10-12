import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import {WordsService} from "../../service/words.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-word',
  templateUrl: './add-word.component.html',
  styleUrls: ['./add-word.component.css']
})
export class AddWordComponent implements OnInit {
  myForm: FormGroup;
  formData: FormData;

  constructor(private  wordsService: WordsService, private router: Router) {
  }

  ngOnInit(): void {
    this.myForm = new FormGroup({
      'name': new FormControl(null),
      'category': new FormControl(null),
      'fileSound': new FormControl(null),
      'filePicture': new FormControl(null)
    });
  }

  onFileChange(event) {

    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.myForm.patchValue({
        fileSound: file
      });
    }
  }

  onFileChangePicture(event) {

    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.myForm.patchValue({
        filePicture: file
      });
    }
  }

  onSubmit() {
    console.log(this.myForm.value)
    this.formData = this.wordsService.transformFormGroupToFormData(this.myForm);
    this.wordsService.addWord(this.formData);
    this.router.navigate(['/wordsList']).then( () => window.location.reload());
  }

}
