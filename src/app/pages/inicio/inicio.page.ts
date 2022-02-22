import { Component, OnInit } from '@angular/core';
import { LoadingController } from '@ionic/angular';
import { RestService } from 'src/app/services/rest.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.page.html',
  styleUrls: ['./inicio.page.scss'],
})
export class InicioPage implements OnInit {

  ofertas:any[];

  constructor(private restService: RestService, private loadingCtrl: LoadingController) { }

  ngOnInit() {
    this.showLoading();
  }

  historial()
  {
    this.restService.obtenerHistorial(this.restService.token)
      .subscribe(data => {
        this.ofertas = data;
        console.log(data);
    });
  }

  async showLoading() {
    const loading = await this.loadingCtrl.create({
    message: 'Loading.....'
    });  
    loading.present();
    setTimeout(() => {
      loading.dismiss();
      this.historial();
      console.log(this.restService.token);
    }, 500 );
 }

}
