import {Component, ElementRef, Inject, ViewChild} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {WordsService} from "../../../service/words.service";
import {Translation} from "../../../models/translation.model";
import {FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {Sentence} from "../../../models/sentance.model";
import {TranslationService} from "../../../service/translation.service";

@Component({
  selector: 'app-word-view',
  templateUrl: './word-view.component.html',
  styleUrls: ['./word-view.component.css']
})
export class WordViewComponent {

  myForm: FormGroup;
  formData: FormData;
  translationObj: Translation = {id: 0, name: "", sentenceList: [], wordId: 0};
  sentenceObj: Sentence = {id: 0, sentence: "", translationId: 0};

  showFieldFlag: boolean = false;
  showUpdateFlag: boolean = false;
  editSentenceFlag: boolean = false;

  @ViewChild('updateTranslation') updateTranslationInputName: ElementRef;
  @ViewChild('updateSentence') updateSentenceInputName: ElementRef;

  constructor(
    public dialogRef: MatDialogRef<WordViewComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private router: Router,
    public wordsService: WordsService,
    public translationService: TranslationService
  ) {
  }

  ngOnInit(): void {
    this.myForm = new FormGroup({
      'translation': new FormControl(null),
      'sentence': new FormControl(null),
    });
  }

  onSubmit(wordId: number){
    console.log(this.myForm.value);
    this.formData = this.wordsService.transformFormGroupToFormData(this.myForm);
    this.translationService.addTranslation(this.formData, wordId);
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

  showUpdateField(nameTranslation: string){
    this.showUpdateFlag = true;
    this.editSentenceFlag = false;
    this.translationObj.name = nameTranslation;
  }

  notShowUpdateField(){
    this.showUpdateFlag = false;
  }

  onEditSentence( sentence: string){
    this.showUpdateFlag = false;
    this.editSentenceFlag = true;
    this.sentenceObj.sentence = sentence;
    this.translationObj.sentenceList.push(this.sentenceObj);
  }

  notOnEditSentence(){
    this.editSentenceFlag = false;
  }

  onUpdateTranslation(translationId: number){
    let translation = {id: translationId, name: this.updateTranslationInputName.nativeElement.value};
    this.translationService.updateTranslation(translation);
    this.router.navigate(['/wordsList']).then( () => window.location.reload());

  }

  onDeleteTranslation(idTranslation: number){
        this.translationService.deleteTranslation(idTranslation);
        window.location.reload();

  }

  onDeleteSentence( idSentence: number){
        this.translationService.deleteSentence(idSentence);
  }

  onAddSentence(translationId: number){
    let sentence = {translationId: translationId, sentence: this.updateTranslationInputName.nativeElement.value};
    this.translationService.addSentence(sentence);
  }

  onUpdateSentence(sentenceId: number){
    let sentence = {id: sentenceId, sentence: this.updateSentenceInputName.nativeElement.value};
    this.translationService.updateSentence(sentence);
  }



}
