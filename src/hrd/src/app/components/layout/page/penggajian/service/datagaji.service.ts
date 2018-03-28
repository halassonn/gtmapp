import {Injectable, EventEmitter, Output} from '@angular/core';
import {HttpService} from '../../../../../core/_http/http.service';
import {Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {DataGajiModel} from "../../../../../model/datagaji.model";


@Injectable()
export class DataGajiService {
    @Output() loaderclass: EventEmitter<any> = new EventEmitter();
    constructor(private _http: HttpService) {}
//get all data gaji

    getAllDataGaji():Observable<DataGajiModel[]>{
        return this._http.get('api/all_data_gaji')
            .map((response: Response) => response.json() as DataGajiModel[])
            .catch(this.handleError);

    }

    private handleError(error: Response | any) {
        // In a real world app, you might use a remote logging infrastructure
        let errMsg: string;
        if (error instanceof Response) {
            const body = error.json() || '';
            const err = body.error || JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
        } else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return Observable.throw(errMsg);
    }


    /*event emitter */
    public sideOpen(): any {
        return this.loaderclass.emit('page-container');
    }
    public sideclose(): any {
        return this.loaderclass.emit('page-container-full');
    }

    getEmittedValue() {
        return this.loaderclass;
    }

}
