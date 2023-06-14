import {Injectable} from "@angular/core";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {WordDeleteComponent} from "../component/modal/word-delete/word-delete.component";
import {Word} from "../models/word.model";
import {WordEditComponent} from "../component/modal/word-edit/word-edit.component";


@Injectable({
  providedIn: 'root'
})
export class ModalService{

  constructor(public dialog: MatDialog) {}

  //   ---Delete Modal---
  onDeleteDialog(wordId: number, wordName: string) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.width = "550px";
    dialogConfig.height = "200px";
    dialogConfig.hasBackdrop = true;
    dialogConfig.panelClass = 'word-delete-modal';
    dialogConfig.data = { name: wordName, id: wordId };


    const dialogRef = this.dialog.open(WordDeleteComponent, dialogConfig);
  }

  //   ---Edit Modal---
  onEditDialog(word: Word) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.width = "700px";
    dialogConfig.height = "650px";
    dialogConfig.hasBackdrop = true;
    dialogConfig.panelClass = 'word-edit-modal';
    dialogConfig.data = { word: word };

    const dialogRef = this.dialog.open(WordEditComponent, dialogConfig);
  }

}
