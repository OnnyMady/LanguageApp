import {Injectable} from "@angular/core";

@Injectable()
export class AppService{

  checkHeader(header: boolean){
      return header;
  }

}
