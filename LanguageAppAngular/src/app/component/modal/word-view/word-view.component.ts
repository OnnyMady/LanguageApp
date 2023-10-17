import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {WordsService} from "../../../service/words.service";
import {Translation} from "../../../models/translation.model";
import {FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-word-view',
  templateUrl: './word-view.component.html',
  styleUrls: ['./word-view.component.css']
})
export class WordViewComponent {

  myForm: FormGroup;
  formData: FormData;

  showFieldFlag: boolean = false;

  constructor(
    public dialogRef: MatDialogRef<WordViewComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private router: Router,
    public wordsService: WordsService
  ) {
  }

  ngOnInit(): void {
    this.myForm = new FormGroup({
      'translation': new FormControl(null),
      'sentence': new FormControl(null),
    });
  }

  onSubmit(wordId: number){
    console.log(this.myForm.value)
    this.formData = this.wordsService.transformFormGroupToFormData(this.myForm);
    this.wordsService.addTranslation(this.formData, wordId);
    this.router.navigate(['/wordsList']).then( () => window.location.reload());
  }

  playSound(name: string) {
    let audio = new Audio();
    audio.src = '../../assets/sounds/' + name;
    audio.load();
    audio.play();
  }

  showField(){
    this.showFieldFlag = true;
  }

  notShowField(){
    this.showFieldFlag = false;
  }

}
