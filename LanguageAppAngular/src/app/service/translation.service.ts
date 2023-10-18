import {Injectable} from "@angular/core";
import {Translation} from "../models/translation.model";
import {HttpClient, HttpHeaders, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../enviroments/environment";
import {Sentence} from "../models/sentance.model";

@Injectable({
  providedIn: 'root'
})
export class TranslationService{

  private apiServerUrl = environment.apiBaseUrl;
  status: string;
  errorMessage: string;


  constructor(private http: HttpClient) {
  }


  addTranslation(word: FormData, wordId: number){
    const url = `${this.apiServerUrl}/translation/addTranslation?wordId=${wordId}`;

    this.http
      .post<any>(url,  word )
      .subscribe((data) => {});
  }

  updateTranslation(translation: Translation){

    this.http
      .post<any>(`${this.apiServerUrl}/translation/edit`,  translation)
      .subscribe((data) => {});
  }

  deleteTranslation(translationId: number){
    return this.http
      .delete<void>(`${this.apiServerUrl}/translation/delete?translationId=${translationId}`)
      .subscribe({
        next: data => {
          this.status = 'Delete successful';
        },
        error: error => {
          this.errorMessage = error.message;
          console.error('There was an error!', error);
        }
      });
  }

  addSentence(sentence: Sentence){
    this.http
      .post<any>(`${this.apiServerUrl}/translation/sentence/add`,  sentence)
      .subscribe((data) => {});
  }

  updateSentence(sentence: Sentence){
    this.http
      .post<any>(`${this.apiServerUrl}/translation/sentence/edit`,  sentence)
      .subscribe((data) => {});
  }

  deleteSentence(sentenceId: number){

    return this.http
      .delete<void>(`${this.apiServerUrl}/translation/sentence/delete?sentenceId=${sentenceId}`)
      .subscribe({
        next: data => {
          this.status = 'Delete successful';
        },
        error: error => {
          this.errorMessage = error.message;
          console.error('There was an error!', error);
        }
      });
  }



}
