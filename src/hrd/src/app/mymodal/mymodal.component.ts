import {Component, EventEmitter, Input, OnInit, Output, OnChanges, SimpleChanges, OnDestroy} from '@angular/core';
import {animate, style, transition, trigger} from '@angular/animations';
import {ModalService} from "./services/modal.service";

@Component({
  selector: 'app-mymodal',
  templateUrl:'./mymodal.component.html',
  styleUrls: ['./mymodal.component.scss'],
  animations: [
    trigger('dialog', [
      transition('void => *', [
        style({transform: 'scale3d(.3, .3, .3)'}),
        animate(100)
      ]),
      transition('* => void', [
        animate(100, style({transform: 'scale3d(.0, .0, .0)'}))
      ])
    ])
  ]
})
export class MymodalComponent implements OnChanges{



  @Input() closable = true;
  @Input() visiblekah: boolean;
  @Output() visibleChangez: EventEmitter<boolean> = new EventEmitter<boolean>();
  @Output() dataout: EventEmitter<string> = new EventEmitter<string>();
  @Input() mclass: string;
  @Input() judul: string;
  @Input() conf:any;
  private bodyclass:string;
constructor(private modalS: ModalService){
  this.conf = this.modalS.getConf();
}

  ngOnChanges(changes: SimpleChanges): void {

    this.judul=this.modalS.getTitle();

  }

  close(){
    this.visiblekah=false;
  }



}
