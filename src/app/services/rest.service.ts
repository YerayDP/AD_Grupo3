import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment.prod';
import { Usuario } from '../usuario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestService {
  api = environment.apiUrl;
  token: any;
  tipo: any;
  ofertas: any[];
  activo: any;

  constructor(private http: HttpClient) { }

  login(mail: any,pass: any): Observable<any>
  {

    return this.http.post<any>('http://localhost:8080/api/login',new Usuario(mail,pass));
  }

  obtenerHistorial(token:any): Observable<any>
  {
    return this.http.get<any[]>('http://localhost:8080/api/listInscritos');
  }

}
