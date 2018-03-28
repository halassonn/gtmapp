import { Injectable } from "@angular/core";

@Injectable()
export class UpdateStatus{
    message:string;
    constructor(){
    }
   
    public setMessage(msg:string){
        this.message=msg;
    }
    public getMessage(){
        return this.message;
    }
}