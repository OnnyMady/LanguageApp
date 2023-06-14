import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Word} from "../models/word.model";
import { environment } from "src/enviroments/environment";

@Injectable({
  providedIn: 'root'
})
export class WordsService{

  private apiServerUrl = environment.apiBaseUrl;
  status: string;

  constructor(private http: HttpClient) {
  }

  deleteWord(idWord: number){
    return this.http
      .delete<void>(`${this.apiServerUrl}/words/delete/${idWord}`)
      .subscribe(() => {
        this.status = "Delete succes";
      });
  }

  editWord(word: Word){
    this.http
      .put<Word[]>(`${this.apiServerUrl}/words/update`,  word)
      .subscribe((data) => {});
  }

  public getWords(): Observable<Word[]>{
    return this.http.get<Array<Word>>(this.apiServerUrl + '/words/all');
  }

  addWord(word: Word){
    this.http
      .post<any>(`${this.apiServerUrl}/words/add`, word)
      .subscribe((data) => {});
  }

  saveWord( ){

  }
}
