import {Injectable, EventEmitter, Output} from '@angular/core';
import {HttpService} from '../../../../../core/_http/http.service';
import {ProfileModel} from '../../../../../model/profile.model';
import {Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';


@Injectable()
export class ProfileService {
  @Output() loaderclass: EventEmitter<any> = new EventEmitter();
  constructor(private _http: HttpService) {}

  getAllDataKaryawanBy(by: string, param: string ): Observable<ProfileModel[]> {
    return this._http.get('api/data-karyawan/by-' + by + '/' + param)
      .map((response: Response) => response.json() as ProfileModel[])
      .catch(this.handleError);
  }


    getAllDataKaryawan(): Observable<ProfileModel[]> {
    return this._http.get('api/data_karyawans')
      .map((response: Response) => response.json().body as ProfileModel[])
      .catch(this.handleError);
  }

  /*getAllDataKantor(): Observable<DatakantorModel[]> {
    return this._http.get('datakantors')
      .map((response: Response) => response.json() as DatakantorModel[])
      .catch(this.handleError);
  }*/

  saveDatakaryawan(data: ProfileModel) {
    return this._http.post('api/data_karyawan', JSON.stringify(data));
    //  .catch(this.handleError);
  }
  updateDataKaryawan(data: ProfileModel) {
    return this._http.put('api/data_karyawan?id=' + data.id , JSON.stringify(data));
  }
  deleteDataKaryawan(id: string) {
    return this._http.delete('api/data_karyawan?id=' + id);
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
