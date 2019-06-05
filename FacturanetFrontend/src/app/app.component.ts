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
  
  facturas = [
    {"codigo": 1 ,"cliente": "Sergio","empleado": "Andrés","fecha": "5/06/2019","tipo_pago": "contado", "producto": "Cocacola","cantidad": 1},
    {"codigo": 2,"cliente": "Juanita","empleado": "Antonio","fecha": "5/06/2019","tipo_pago": "contado","producto": "Pepsi","cantidad": 1},
    {"codigo": 3 ,"cliente": "Juanito","empleado": "Futanita","fecha": "5/06/2019","tipo_pago": "contado","producto": "BigCOla","cantidad": 10}
  ]

  model: any = {};
  model2: any = {};
  ocultareditarproducto: boolean = true;

  agregarfactura(): void {

    this.facturas.push(this.model);
    this.mensaje = "Factura agregada";

  }

  eliminarfactura(i): void {
    
    var respuesta = confirm("¿Seguro que desea eliminar el producto?");
    if(respuesta) {
      this.facturas.splice(i, 1);
      this.mensaje = "factura eliminada";
    }
    this.mensaje = "Factura no eliminada";
  }

  Dato;
  editarfactura(i): void {

    this.ocultareditarproducto = false;
    this.model2.codigo = this.facturas[i].codigo;
    this.model2.cliente = this.facturas[i].cliente;
    this.model2.empleado = this.facturas[i].empleado;
    this.model2.fecha = this.facturas[i].fecha;
    this.model2.tipo_pago = this.facturas[i].tipo_pago;
    this.model2.producto = this.facturas[i].producto;
    this.model2.cantidad = this.facturas[i].cantidad;
    this.Dato = i;
  }

  actualizarfactura(): void {
    let i = this.Dato;
    for(let j = 0; j < this.facturas.length; j++) {
      if(i == j) {
        this.facturas[i] = this.model2;
        this.model2 = {};
        this.mensaje = "Factura actualizada";
        this.ocultareditarproducto = true;
      }
    }
    
  }

  cerrarAlerta(): void {
    this.mensaje = "";
  }
}
