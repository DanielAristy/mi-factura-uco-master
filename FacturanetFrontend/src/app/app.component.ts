import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  titulo = "BIENVENIDOS A FACTURANET";
  subtitulo = "Sus compras al mejor precio";

  mensaje:string ="";
  productos = [
    {"codigo": 1 ,"nombre": "Curatin","valor": 100000},
    {"codigo": 2,"nombre": "Clorox","valor": 1900},
    {"codigo": 3 ,"nombre": "Vaso para Clorox","valor": 10000},
  ]

  model: any = {};
  model2: any = {};
  ocultareditarproducto: boolean = true;

  agregarproducto(): void {

    this.productos.push(this.model);
    this.mensaje = "producto agregado";

  }

  eliminarproducto(i): void {
    
    var respuesta = confirm("¿Seguro que desea eliminar el producto?");
    if(respuesta) {
      this.productos.splice(i, 1);
      this.mensaje = "producto eliminado";
    }
    this.mensaje = "producto no eliminado";
  }

  Dato;
  editarproducto(i): void {

    this.ocultareditarproducto = false;
    this.model2.codigo = this.productos[i].codigo;
    this.model2.nombre = this.productos[i].nombre;
    this.model2.valor = this.productos[i].valor;
    this.Dato = i;
  }

  actualizarempleado(): void {
    let i = this.Dato;
    for(let j = 0; j < this.productos.length; j++) {
      if(i == j) {
        this.productos[i] = this.model2;
        this.model2 = {};
        this.mensaje = "producto actualizado";
        this.ocultareditarproducto = true;
      }
    }
    this.mensaje = "producto no actualizado";
  }

  cerrarAlerta(): void {
    this.mensaje = "";
  }
}
