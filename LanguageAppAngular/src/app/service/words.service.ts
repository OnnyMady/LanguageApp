import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {Word} from "../models/word.model";
import { environment } from "src/enviroments/environment";
import {FormGroup} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class WordsService{

  private apiServerUrl = environment.apiBaseUrl;
  status: string;
  errorMessage: string;


  constructor(private http: HttpClient) {
  }

  deleteWord(idWord: number){
    return this.http
      .delete<void>(`${this.apiServerUrl}/words/delete/${idWord}`)
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

  editWord(word: FormData){
    this.http
      .post<any>(`${this.apiServerUrl}/words/edit`,  word)
      .subscribe((data) => {});
  }

  addWord(word: FormData){
    this.http
      .post<any>(`${this.apiServerUrl}/words/add`, word )
      .subscribe((data) => {});
  }

  public getWords(): Observable<Word[]>{
    return this.http.get<Array<Word>>(this.apiServerUrl + '/words/all');
  }

   transformFormGroupToFormData(formGroup: FormGroup): FormData {
  let formData = new FormData();

  Object.keys(formGroup.controls).forEach((key) => {
    let control = formGroup.get(key);
        formData.append(key, control?.value);
  });
     return formData;
   }
}
