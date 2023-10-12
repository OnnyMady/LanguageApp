// audio-player.service.ts

import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AudioPlayerService {
  private audioContext: AudioContext;

  constructor() {
    // Create the AudioContext
    this.audioContext = new (window.AudioContext || window.AudioContext)();
  }

  // playByteArray(byteArray: Uint8Array) {
  //   // Decode the array of bytes to an audio buffer
  //   this.audioContext.decodeAudioData(byteArray.buffer, (audioBuffer) => {
  //     // Create a buffer source
  //     const source = this.audioContext.createBufferSource();
  //     source.buffer = audioBuffer;
  //
  //     // Connect the source to the output (i.e., speakers)
  //     source.connect(this.audioContext.destination);
  //
  //     // Start playing the audio
  //     source.start();
  //   }, (error) => {
  //     console.error('Error decoding audio data:', error);
  //   });
  // }
}
