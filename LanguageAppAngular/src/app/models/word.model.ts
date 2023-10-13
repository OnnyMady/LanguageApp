import {Translation} from "./translation.model";

export class Word {
  id: number;
  name: string;
  translation?: string;
  sentence?: string;
  category?: string
  lesson?: string;
  soundName?: string;
  pictureName?:string;
  translationList?: Translation[];


}
