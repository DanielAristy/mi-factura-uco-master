import { Injectable } from '@angular/core';
import { Producto } from './producto';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";

const httpOptions = {
  headers: new HttpHeaders({
   'Content-Type': 'application/json',
   'Authorization': 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ProductoServiceService {
  private productosUrl: string;

  _baseUrl: string = '';

  constructor(private http: HttpClient) {
    this._baseUrl = "http://localhost:8080/";
  }

  agregarProducto(producto: Producto): Observable<Producto> {
    return this.http.post<Producto>(this._baseUrl, '/api/factura/dummyproducto', httpOptions);
  }
}
