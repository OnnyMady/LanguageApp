export class Sentence {
  id?: number;
  translationId?: number;
  sentence?: string;

  constructor(translationId: number, sentence: string) {
    this.translationId = translationId;
    this.sentence = sentence;
  }

}
